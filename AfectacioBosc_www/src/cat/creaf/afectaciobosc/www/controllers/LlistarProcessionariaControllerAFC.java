/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cat.creaf.afectaciobosc.www.controllers;

import cat.creaf.afectaciobosc.model.Afectacio;
import cat.creaf.afectaciobosc.model.Processionaria;
import cat.creaf.afectaciobosc.service.IAfectacioService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author a_escobar
 */
public class LlistarProcessionariaControllerAFC extends AbstractController {

    private IAfectacioService afectacioService;

    public LlistarProcessionariaControllerAFC(){
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
        int numTotal = afectacioService.getProcessionariesCount();
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
        String idProcessionaria = request.getParameter("idprocessionaria");
        if(idProcessionaria!=null){
            Processionaria processionaria = (Processionaria)afectacioService.getAfectacio(idProcessionaria);
            hm.put("processionaria",processionaria);
        }
//        List processionaries = new ArrayList<Processionaria>();
//        processionaries = afectacioService.getProcessionaries("codi", "asc", primer, numTotal);
//        hm.put("processionaries", processionaries);
        return new ModelAndView("Processionaria/llistarProcessionaries", "dades", hm);
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
