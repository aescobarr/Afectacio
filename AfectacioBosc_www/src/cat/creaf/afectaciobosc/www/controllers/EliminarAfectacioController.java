/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.creaf.afectaciobosc.www.controllers;

import cat.creaf.afectaciobosc.model.Afectacio;
import cat.creaf.afectaciobosc.service.IAfectacioService;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author a_escobar
 */
public class EliminarAfectacioController extends AbstractController {

    private IAfectacioService afectacioService;

    public EliminarAfectacioController() {
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
        String primerElement = "0";
        if (request.getParameter("primerelement") != null) {
            primerElement = request.getParameter("primerelement");
        }
        hm.put("primerelement", primerElement);
        hm.put("numelements", request.getParameter("numelements"));
        String novaUrl = request.getParameter("novaurl");
        Afectacio afectacio = afectacioService.getAfectacio(request.getParameter("idafectacio"));
        afectacioService.esborrar(afectacio);
        return new ModelAndView("redirect:"+novaUrl, "dades", hm);
    }
}
