/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cat.creaf.afectaciobosc.www.controllers;

import MSeguretatObj.Usuari;
import cat.creaf.afectaciobosc.service.IAfectacioService;
import java.util.ArrayList;
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
public class LlistarNevadesController extends AbstractController {

    private IAfectacioService afectacioService;

    public LlistarNevadesController(){
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
        int numTotal = afectacioService.getNevadesCount();
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
        String nomUsuari = "";
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            nomUsuari = SecurityContextHolder.getContext().getAuthentication().getName();
        }
        Usuari usuari = afectacioService.getUsuariPerNom(nomUsuari);
        for(int i=0;i<usuari.getAuthorities().size();i++){
            editable = editable || "ROLE_ESBORRAR_NEVADA".equals(usuari.getAuthorities().get(i).getAuthority());
        }
        hm.put("editable", editable);        
        return new ModelAndView("Nevades/llistarNevades", "dades", hm);
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
