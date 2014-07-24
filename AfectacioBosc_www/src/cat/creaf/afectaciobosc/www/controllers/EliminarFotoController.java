/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.creaf.afectaciobosc.www.controllers;

import cat.creaf.afectaciobosc.model.Foto;
import cat.creaf.afectaciobosc.service.IAfectacioService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author a_escobar
 */
public class EliminarFotoController extends AbstractController {

    private IAfectacioService afectacioService;

    public EliminarFotoController() {
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
        String idFoto = request.getParameter("idfoto");
        Foto foto = this.afectacioService.getFoto(idFoto);
        if(foto!=null)
            this.afectacioService.esborrar(foto);
//        Map hm = new HashMap();
//        hm.put("idenp",request.getParameter("idenp"));
//        return new ModelAndView("redirect:/enps/edicio/editardocumentsenp.htm",hm);
        //Al final cal fer una redirecció a una pàgina que no fàci res només per a què la
        //crida en ajax vegi que ha acabat.
        return new ModelAndView("redirect:/index.htm");
    }
    
}
