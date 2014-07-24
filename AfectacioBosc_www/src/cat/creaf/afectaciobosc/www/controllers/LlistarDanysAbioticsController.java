/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cat.creaf.afectaciobosc.www.controllers;

import MSeguretatObj.Usuari;
import cat.creaf.afectaciobosc.service.IAfectacioService;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.acegisecurity.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author a_escobar
 */
public class LlistarDanysAbioticsController extends AbstractController {

    private IAfectacioService afectacioService;

    public LlistarDanysAbioticsController(){
        super();
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap hm = new HashMap();
        String primerElement = "0";
        if (request.getParameter("primerelement") != null) {
            primerElement = request.getParameter("primerelement");
        }
        hm.put("primerelement", primerElement);
        hm.put("numtotalelements", request.getParameter("numtotalelements"));
        
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
        boolean editable = false;
        boolean esborrable = false;
        boolean llistableShape = false;
        String nomUsuari = "";
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            nomUsuari = SecurityContextHolder.getContext().getAuthentication().getName();
        }
        Usuari usuari = afectacioService.getUsuariPerNom(nomUsuari);
        for(int i=0;i<usuari.getAuthorities().size();i++){
            editable = editable || "ROLE_EDITAR_DANYABIOTIC".equals(usuari.getAuthorities().get(i).getAuthority());
            esborrable = esborrable || "ROLE_ESBORRAR_DANYABIOTIC".equals(usuari.getAuthorities().get(i).getAuthority());
            llistableShape = llistableShape || "ROLE_CONSULTA_SHAPE_DA".equals(usuari.getAuthorities().get(i).getAuthority());
        }
        hm.put("editable", editable);
        hm.put("esborrable", esborrable);
        hm.put("llistableShape", llistableShape);
        return new ModelAndView("DanysAbiotics/llistarDanysAbiotics", "dades", hm);
    }

    private String getIP() {
        String ip = null;
        try {
            java.net.InetAddress i = java.net.InetAddress.getLocalHost();
            ip =i.getCanonicalHostName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ip;
    }

    /**
     * @return the afectacioService
     */
    public IAfectacioService getAfectacioService() {
        return afectacioService;
    }

    /**
     * @param afectacioService the afectacioService to set
     */
    public void setAfectacioService(IAfectacioService afectacioService) {
        this.afectacioService = afectacioService;
    }

}
