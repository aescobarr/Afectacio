/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.creaf.afectaciobosc.www.controllers;

import MSIPANGeneral.ObjecteSIPANAmbNom;
import cat.creaf.afectaciobosc.model.Especie;
import cat.creaf.afectaciobosc.service.IAfectacioService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;
import MSeguretatObj.Usuari;
import Utilitats.TransformadorDades;
import cat.creaf.afectaciobosc.model.AfectacioEstimadaDanyAbiotic;
import cat.creaf.afectaciobosc.model.DanyAbiotic;
import org.acegisecurity.context.SecurityContextHolder;
import org.springframework.web.servlet.mvc.AbstractController;
import MSeguretatExcepcions.FaltenPermisosException;

/**
 *
 * @author v.garcia
 */
public class DanyAbioticController extends AbstractController {

    private IAfectacioService afectacioService;

    public DanyAbioticController() {
        super();
    }

    public IAfectacioService getAfectacioService() {
        return afectacioService;
    }

    public void setAfectacioService(IAfectacioService afectacioService) {
        this.afectacioService = afectacioService;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap hm = new HashMap();        
        String nomUsuari = "";
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            nomUsuari = SecurityContextHolder.getContext().getAuthentication().getName();
        }
        Usuari usuari = afectacioService.getUsuariPerNom(nomUsuari);
        boolean editable = false;
//        boolean esborrable = false;
        for(int i=0;i<usuari.getAuthorities().size();i++){
            editable = editable || "ROLE_EDITAR_DANYABIOTIC".equals(usuari.getAuthorities().get(i).getAuthority());
//            esborrable = esborrable || "ROLE_ESBORRAR_DANYMECANIC".equals(usuari.getAuthorities().get(i).getAuthority());
        }
        if(!editable){
            throw new FaltenPermisosException();
        }
//        hm.put("editable", editable);
//        hm.put("esborrable", esborrable);
        DanyAbiotic afectacio = null;
        String idAfectacio = request.getParameter("idafectacio");
        afectacio = afectacioService.getDanyAbiotic(idAfectacio);
        if("-1".equals(idAfectacio)){
            afectacio = afectacioService.createDanyAbiotic();
        }
        hm.put("afectacio",afectacio);
        hm.put("idafectacio",idAfectacio);
        String urlSortida = "DanysAbiotics/editarDanyAbiotic";
        String accio = request.getParameter("accio");
        if("1".equals(accio)){            
            hm.put("idafectacio", request.getParameter("idafectacio"));
            hm.put("ip", getIP());
            String primerElement = "0";
            if (request.getParameter("primerelement") != null) {
                primerElement = request.getParameter("primerelement");
            }
            hm.put("primerelement", primerElement);
            hm.put("numelements", request.getParameter("numelements"));
            HashMap<String,String> parametres = TransformadorDades.convertirHttpServletRequestToHashMap(request);
            afectacioService.desarDanyAbiotic(afectacio, parametres);
            hm.put("idafectacio", afectacio.getIdString());
            String novaUrl = request.getParameter("novaurl");
            if("/sequeres/edicio/editar.htm".equals(novaUrl)){
                return new ModelAndView("redirect:"+novaUrl, hm);
            }
            return new ModelAndView("redirect:"+novaUrl, hm);
        }else{
            String primerElement = "0";
            if (request.getParameter("primerelement") != null && !request.getParameter("primerelement").equalsIgnoreCase("")) {
                primerElement = request.getParameter("primerelement");
            }
            hm.put("numtotalelements", request.getParameter("numtotalelements"));
            hm.put("primerelement", primerElement);
            hm.put("grausinfestacio",afectacioService.getGrausInfestacioDanyMecanic());
            int primer = Integer.parseInt(primerElement);
            String numElemsString = request.getParameter("numelements");
            if (numElemsString == null || "".equals(numElemsString)) {
                numElemsString = "30";
            }
            int numElements = Integer.parseInt(numElemsString);
            hm.put("numelements", request.getParameter("numelements"));
            int numTotal = afectacioService.getDanysAbioticsCount();
            hm.put("numtotalelements", numTotal);
            String operacio = request.getParameter("operacio");
            if (numElements == -1) {
                primer = 0;
                numElements = numTotal;
            } else if ("0".equals(operacio)) {
                primer = 0;
            } else if ("1".equals(operacio)) {
                primer = primer - numElements;
            } else if ("2".equals(operacio)) {
                primer = primer + numElements;
            } else if ("3".equals(operacio)) {
                if (numTotal % numElements > 0) {
                    primer = numTotal - (numTotal % numElements);
                    numElements = numTotal % numElements;
                } else {
                    primer = numTotal - numElements;
                }
            }
            hm.put("primerelement", primer + "");
            hm.put("ip", getIP());
            hm.put("distribucions", afectacioService.getDistribucionsArbresAfectats());
            hm.put("causesDecaiment", afectacioService.getCausesDecaimentDanyAbiotic());
            hm.put("orientacions", afectacioService.getTipusOrientacions());
            hm.put("pendents", afectacioService.getPendents());
            hm.put("posicionsPendent", afectacioService.getPosicionsPendent());
            hm.put("disposicionsPendent", afectacioService.getDisposicionsPendent());
            hm.put("tipusBoscos", afectacioService.getTipusBoscos());
            hm.put("especiesAOferir", convertirEspeciesJSON(afectacioService.getEspeciesAmbSequera()));
            hm.put("especiesAOferirSequeraSoca", afectacioService.getEspeciesAmbSequeraSoca());
            hm.put("especiesAOferirSequeraTipusBosc", afectacioService.getEspeciesAmbSequeraTipusBosc());
            List<ObjecteSIPANAmbNom> llistaSiNo = new ArrayList<ObjecteSIPANAmbNom>();
            ObjecteSIPANAmbNom objAmbNom = new ObjecteSIPANAmbNom("S");
            objAmbNom.setNom("Si");
            llistaSiNo.add(objAmbNom);
            objAmbNom = new ObjecteSIPANAmbNom("N");
            objAmbNom.setNom("No");
            llistaSiNo.add(objAmbNom);
            hm.put("siNo",llistaSiNo);
            hm.put("estimacionsjson",convertirDadesEstimacionsJSON(afectacio.getAfectacionsEstimades()));
            



            String ex = request.getParameter("exception");
            if(ex!=null && !"".equals(ex)){
                hm.put("exception",ex);
                hm.put("resultat",request.getParameter("resultat"));
            }else{
                hm.put("resultat",request.getParameter("resultat"));
            }
            hm.put("ip", getIP());
        }
        return new ModelAndView(urlSortida, hm);
    }

    private String getIP() {
        String ip = null;
        try {
            java.net.InetAddress i = java.net.InetAddress.getLocalHost();
            ip = i.getCanonicalHostName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ip;
    }

    private String convertirEspeciesJSON(List<Especie> elements) {
        JSONArray array = new JSONArray();
        JSONObject objecte;
        Especie especie;
        for (int i = 0; i < elements.size(); i++) {
            especie = (Especie) elements.get(i);
            objecte = new JSONObject();
            objecte.put("id", especie.getIdString());
            objecte.put("especie", especie.toString());
            objecte.put("value", especie.toString());
            objecte.put("label", especie.toString());
            array.put(objecte);
        }
        return array.toString();
    }

    private String convertirDadesEstimacionsJSON(List<AfectacioEstimadaDanyAbiotic> elements) {
        JSONArray array = new JSONArray();
        JSONObject objecte;
        AfectacioEstimadaDanyAbiotic ae;
        int ordre;
        for (int i = 0; i < elements.size(); i++) {
            ae = elements.get(i);
            objecte = new JSONObject();
            String especie = "";
            String idEspecie = "";
            if (ae.getEspecie() != null) {
                especie = ae.getEspecie().toString();
                idEspecie = ae.getEspecie().getIdString();
            }
            objecte.put("id", ae.getIdString());
            objecte.put("idespecie", idEspecie);
            objecte.put("especie", especie);
            objecte.put("estrat", ae.getEstrat());
            objecte.put("recobriment", ae.getRecobriment());
            objecte.put("afectacio", ae.getAfectacio());
            if(ae.getOrdre()==-1)
                ordre = i+1;
            else
                ordre = ae.getOrdre();
            objecte.put("ordre",ordre);
            array.put(objecte);
        }
        return array.toString();
    }
}
