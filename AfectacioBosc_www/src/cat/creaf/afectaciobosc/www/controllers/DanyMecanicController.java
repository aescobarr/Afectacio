/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.creaf.afectaciobosc.www.controllers;

import cat.creaf.afectaciobosc.model.ArbreTransecteSequera;
import MGeneral_www.editor.ObjecteSIPANEditor;
import cat.creaf.afectaciobosc.model.CausaDecaiment;
import cat.creaf.afectaciobosc.model.DistribucioArbresAfectats;
import cat.creaf.afectaciobosc.model.Especie;
import cat.creaf.afectaciobosc.model.RegeneracioEspecieForestal;
import cat.creaf.afectaciobosc.model.TipusBosc;
import cat.creaf.afectaciobosc.service.IAfectacioService;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryCollection;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.PrecisionModel;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.acegisecurity.context.SecurityContextHolder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import MSeguretatObj.Usuari;
import cat.creaf.afectaciobosc.model.AfectacioEstimadaDanyMecanic;
import cat.creaf.afectaciobosc.model.DanyMecanic;
import cat.creaf.afectaciobosc.model.GrauInfestacio;
import org.acegisecurity.context.SecurityContextHolder;

/**
 *
 * @author v.garcia
 */
@Deprecated
public class DanyMecanicController extends SimpleFormController {

//    private IAfectacioService afectacioService;

    public DanyMecanicController() {
        setCommandClass(DanyMecanic.class);
        setCommandName("afectacio");
        setFormView("DanysMecanics/llistarDanysMecanics");
    }

//    public IAfectacioService getAfectacioService() {
//        return afectacioService;
//    }
//
//    public void setAfectacioService(IAfectacioService afectacioService) {
//        this.afectacioService = afectacioService;
//    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        DanyMecanic afectacio = null;
//        String idAfectacio = request.getParameter("idafectacio");
//        afectacio = getAfectacioService().getDanyMecanic(idAfectacio);
        return afectacio;
    }

    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
//        binder.registerCustomEditor(Especie.class, new ObjecteSIPANEditor(afectacioService.getEspecies()));
//        binder.registerCustomEditor(TipusBosc.class, new ObjecteSIPANEditor(afectacioService.getTipusBoscos()));
//        binder.registerCustomEditor(DistribucioArbresAfectats.class, new ObjecteSIPANEditor(afectacioService.getDistribucionsArbresAfectats()));
//        binder.registerCustomEditor(GrauInfestacio.class, new ObjecteSIPANEditor(afectacioService.getGrausInfestacioDanyMecanic()));
//        binder.registerCustomEditor(Date.class, null,
//                new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true));
    }

    @Override
    protected Map referenceData(HttpServletRequest request, Object command, Errors errors) throws Exception {
        Map sortida = new HashMap();
//        sortida.put("id", request.getParameter("id"));
//        String primerElement = "0";
//        if (request.getParameter("primerelement") != null && !request.getParameter("primerelement").equalsIgnoreCase("")) {
//            primerElement = request.getParameter("primerelement");
//        }
//        sortida.put("numtotalelements", request.getParameter("numtotalelements"));
//        sortida.put("primerelement", primerElement);
//        sortida.put("grausinfestacio",afectacioService.getGrausInfestacioDanyMecanic());
//        int primer = Integer.parseInt(primerElement);
//        String numElemsString = request.getParameter("numelements");
//        if (numElemsString == null || "".equals(numElemsString)) {
//            numElemsString = "30";
//        }
//        int numElements = Integer.parseInt(numElemsString);
//        sortida.put("numelements", request.getParameter("numelements"));
//        int numTotal = afectacioService.getDanysMecanicsCount();
//        sortida.put("numtotalelements", numTotal);
//        String operacio = request.getParameter("operacio");
//        if (numElements == -1) {
//            primer = 0;
//            numElements = numTotal;
//        } else if ("0".equals(operacio)) {
//            primer = 0;
//        } else if ("1".equals(operacio)) {
//            primer = primer - numElements;
//        } else if ("2".equals(operacio)) {
//            primer = primer + numElements;
//        } else if ("3".equals(operacio)) {
//            if (numTotal % numElements > 0) {
//                primer = numTotal - (numTotal % numElements);
//                numElements = numTotal % numElements;
//            } else {
//                primer = numTotal - numElements;
//            }
//        }
//        sortida.put("editable", true);
//        sortida.put("primerelement", primer + "");
//        sortida.put("ip", getIP());
//        sortida.put("distribucions", afectacioService.getDistribucionsArbresAfectats());
//        sortida.put("causesDecaiment", afectacioService.getCausesDecaimentDanyMecanic());
//        sortida.put("orientacions", afectacioService.getTipusOrientacions());
//        sortida.put("pendents", afectacioService.getPendents());
//        sortida.put("posicionsPendent", afectacioService.getPosicionsPendent());
//        sortida.put("disposicionsPendent", afectacioService.getDisposicionsPendent());
//        sortida.put("tipusBoscos", afectacioService.getTipusBoscos());
//        sortida.put("especiesAOferir", convertirEspeciesJSON(afectacioService.getEspeciesAmbSequera()));
//        sortida.put("especiesAOferirSequeraSoca", afectacioService.getEspeciesAmbSequeraSoca());
//        sortida.put("especiesAOferirSequeraTipusBosc", afectacioService.getEspeciesAmbSequeraTipusBosc());
////        DanyMecanic sequera = (DanyMecanic) command;
////        sortida.put("regeneraciojson", convertirDadesRegeneracioJSON(((DanyMecanic) command).getRegeneracionsEspeciesForestals()));
//        sortida.put("estimacionsjson", convertirDadesEstimacionsJSON(((DanyMecanic)command).getAfectacionsEstimades()));
////        List<ArbreTransecteSequera> arbres = null;
////        if (sequera.getArbresTransecte().size() > 0) {
////            arbres = sequera.getArbresTransecte();
////        } else {
////            arbres = crear100ArbresTransecte();
////        }
////        sortida.put("arbrestransectejson", convertirArbresTransecteJSON(arbres));
//        boolean editable = false;
//        boolean esborrable = false;
//        String nomUsuari = "";
//        if (SecurityContextHolder.getContext().getAuthentication() != null) {
//            nomUsuari = SecurityContextHolder.getContext().getAuthentication().getName();
//        }
//        Usuari usuari = afectacioService.getUsuariPerNom(nomUsuari);
//        for(int i=0;i<usuari.getAuthorities().size();i++){
//            editable = editable || "ROLE_EDITAR_DANYMECANIC".equals(usuari.getAuthorities().get(i).getAuthority());
//            esborrable = esborrable || "ROLE_ESBORRAR_DANYMECANIC".equals(usuari.getAuthorities().get(i).getAuthority());
//        }
//        sortida.put("editable", editable);
//        sortida.put("esborrable", esborrable);
        return sortida;
    }

//    private List<ArbreTransecteSequera> crear100ArbresTransecte() {
//        List<ArbreTransecteSequera> arbres = new ArrayList<ArbreTransecteSequera>();
//        for (int i = 0; i < 100; i++) {
//            arbres.add(new ArbreTransecteSequera());
//        }
//        return arbres;
//    }
//
//    private String getIP() {
//        String ip = null;
//        try {
//            java.net.InetAddress i = java.net.InetAddress.getLocalHost();
//            ip = i.getCanonicalHostName();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ip;
//    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        Map hm = new HashMap();
//        hm.put("id", request.getParameter("id"));
//        hm.put("idafectacio", request.getParameter("idafectacio"));
//        hm.put("ip", getIP());
//        String primerElement = "0";
//        if (request.getParameter("primerelement") != null) {
//            primerElement = request.getParameter("primerelement");
//        }
//        hm.put("primerelement", primerElement);
//        hm.put("numelements", request.getParameter("numelements"));
//        DanyMecanic afectacio = (DanyMecanic) command;
//        int numCauses = afectacioService.getCausesDecaimentCount();
//        afectacio.getCausesDecaiment().clear();
//        for (int i = 0; i < numCauses; i++) {
//            String idCausa = request.getParameter("CAUSADECAIMENT_" + i);
//            CausaDecaiment causa = afectacioService.getCausaDecaiment(idCausa);
//            afectacio.getCausesDecaiment().add(causa);
//        }
////        double xInici = Double.parseDouble(request.getParameter("coordenadaXIniciTransecte"));
////        double yInici = Double.parseDouble(request.getParameter("coordenadaYIniciTransecte"));
////        double xFi = Double.parseDouble(request.getParameter("coordenadaXFiTransecte"));
////        double yFi = Double.parseDouble(request.getParameter("coordenadaYFiTransecte"));
////        afectacio.setTransecte(convertirTransecte(xInici, yInici, xFi, yFi));
//        String wktGeom = request.getParameter("wkt");
//        if (wktGeom.equalsIgnoreCase("GEOMETRYCOLLECTION()")) {
//            afectacio.setAreaAfectada(null);
//        } else {
//            afectacio.setAreaAfectada(getAreaDeWkt(wktGeom));
//        }
////        if("null".equals(afectacio.getOrientacio()))
////            afectacio.setOrientacio(null);
////        if("null".equals(afectacio.getPendent()))
////            afectacio.setPendent(null);
////        if("null".equals(afectacio.getPosicioPendent()))
////            afectacio.setPosicioPendent(null);
////        if("null".equals(afectacio.getDisposicioPendent()))
////            afectacio.setDisposicioPendent(null);
////        afectacioService.desar(afectacio,request.getParameter("idsDadesEstimacions"),
////                request.getParameter("idsDadesRegeneracio"),request.getParameter("idsDadesTransecte"));
//        afectacioService.desar(afectacio,request.getParameter("idsDadesEstimacions"));
        String novaUrl = request.getParameter("novaurl");
//        if("/sequeres/edicio/editar.htm".equals(novaUrl)){
//            return new ModelAndView("redirect:"+novaUrl, hm);
//        }
        return new ModelAndView("redirect:"+novaUrl, "dades", hm);
    }

//    private Geometry convertirTransecte(double xInici, double yInici, double xFi, double yFi) {
//        Coordinate[] coordinates = new Coordinate[2];
//        PrecisionModel p = new PrecisionModel(PrecisionModel.FLOATING);
//        GeometryFactory gf = new GeometryFactory(p, 23031);
//        coordinates[0] = new Coordinate(xInici, yInici);
//        coordinates[1] = new Coordinate(xFi, yFi);
//        Geometry g_n = gf.createLineString(coordinates);
//        g_n.setSRID(23031);
//        return g_n;
//    }

//    private Geometry getAreaDeWkt(String wkt) throws ParseException {
//        PrecisionModel p = new PrecisionModel(PrecisionModel.FLOATING);
//        GeometryFactory gf = new GeometryFactory(p, 23031);
//        WKTReader reader = new WKTReader(gf);
//        GeometryCollection area = (GeometryCollection) reader.read(wkt);
//        ArrayList llistaGeometries = new ArrayList();
//        for (int i = 0; i < area.getNumGeometries(); i++) {
//            Geometry g_n = area.getGeometryN(i);
//            g_n.setSRID(23031);
//            llistaGeometries.add(g_n);
//        }
//        return gf.buildGeometry(llistaGeometries);
//    }
//
//    private String convertirEspeciesJSON(List<Especie> elements) {
//        JSONArray array = new JSONArray();
//        JSONObject objecte;
//        Especie especie;
//        for (int i = 0; i < elements.size(); i++) {
//            especie = (Especie) elements.get(i);
//            objecte = new JSONObject();
//            objecte.put("id", especie.getIdString());
//            objecte.put("especie", especie.toString());
//            objecte.put("value", especie.toString());
//            objecte.put("label", especie.toString());
//            array.put(objecte);
//        }
//        return array.toString();
//    }
//
//    private String convertirArbresTransecteJSON(List<ArbreTransecteSequera> elements) {
//        JSONArray array = new JSONArray();
//        JSONObject objecte;
//        ArbreTransecteSequera ats;
//        int ordre;
//        for (int i = 0; i < elements.size(); i++) {
//            ats = (ArbreTransecteSequera) elements.get(i);
//            objecte = new JSONObject();
//            String especie = "";
//            if (ats.getEspecie() != null) {
//                especie = ats.getEspecie().toString();
//            }
////            objecte.put("posicio", (i + 1) + "");
//            objecte.put("id", ats.getIdString());
//            objecte.put("especie", especie);
//            objecte.put("estrat", ats.getEstrat()==null ? "" : ats.getEstrat());
//            objecte.put("classeDiametrica", ats.getClasseDiametrica()==null ? "" : ats.getClasseDiametrica());
//            objecte.put("estat", ats.getEstatArbres()==null ? "" : ats.getEstatArbres());
//            objecte.put("afectacio", ats.getAfectacioCapcada()==null ? "" : ats.getAfectacioCapcada());
//            objecte.put("fullaVerda", ats.getPercentatgeFullaVerda()==null ? "" : ats.getPercentatgeFullaVerda());
//            objecte.put("observacions", ats.getObservacions() == null ? "" : ats.getObservacions());
//            if(ats.getOrdre()==-1)
//                ordre = i+1;
//            else
//                ordre = ats.getOrdre();
//            objecte.put("ordre",ordre);
//            array.put(objecte);
//        }
//        return array.toString();
//    }
//
//
//
//    private String convertirDadesRegeneracioJSON(List<RegeneracioEspecieForestal> elements) {
//        JSONArray array = new JSONArray();
//        JSONObject objecte;
//        RegeneracioEspecieForestal reg;
//        int ordre;
//        for (int i = 0; i < elements.size(); i++) {
//            reg = elements.get(i);
//            objecte = new JSONObject();
//            String especie = "";
//            String idEspecie = "";
//            if (reg.getEspecie() != null) {
//                especie = reg.getEspecie().toString();
//                idEspecie = reg.getEspecie().getIdString();
//            }
//            objecte.put("id", reg.getIdString());
//            objecte.put("idespecie", idEspecie);
//            objecte.put("especie", especie);
//            String abundancia = "";
//            if(RegeneracioEspecieForestal.ABUNDANCIA_BAIXA.equals(reg.getAbundancia()))
//                abundancia = "Baixa";
//            else if(RegeneracioEspecieForestal.ABUNDANCIA_ALTA.equals(reg.getAbundancia()))
//                abundancia = "Alta";
//            String individus = "";
//            if(RegeneracioEspecieForestal.PERCENTATGE_BAIX.equals(reg.getPercentatgeMorts()))
//                individus = "<50%";
//            else if(RegeneracioEspecieForestal.PERCENTATGE_ALT.equals(reg.getPercentatgeMorts()))
//                individus = ">50%";
//            objecte.put("abundancia", abundancia);
//            objecte.put("individus", individus);
//            if(reg.getOrdre()==-1)
//                ordre = i+1;
//            else
//                ordre = reg.getOrdre();
//            objecte.put("ordre",ordre);
//            array.put(objecte);
//        }
//        return array.toString();
//    }
//
//
//
//
//
//    private String convertirDadesEstimacionsJSON(List<AfectacioEstimadaDanyMecanic> elements) {
//        JSONArray array = new JSONArray();
//        JSONObject objecte;
//        AfectacioEstimadaDanyMecanic ae;
//        int ordre;
//        for (int i = 0; i < elements.size(); i++) {
//            ae = elements.get(i);
//            objecte = new JSONObject();
//            String especie = "";
//            String idEspecie = "";
//            if (ae.getEspecie() != null) {
//                especie = ae.getEspecie().toString();
//                idEspecie = ae.getEspecie().getIdString();
//            }
//            objecte.put("id", ae.getIdString());
//            objecte.put("idespecie", idEspecie);
//            objecte.put("especie", especie);
//            objecte.put("alcada", ae.getAlcadaFormatejada());
//            objecte.put("recobriment", ae.getRecobriment());
//            objecte.put("afectacio", ae.getAfectacio());
//            if(ae.getOrdre()==-1)
//                ordre = i+1;
//            else
//                ordre = ae.getOrdre();
//            objecte.put("ordre",ordre);
//            array.put(objecte);
//        }
//        return array.toString();
//    }
}
