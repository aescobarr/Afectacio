/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.creaf.afectaciobosc.www.controllers;

import cat.creaf.afectaciobosc.service.IAfectacioService;
import cat.creaf.sia.sipan.controllers.LlistarJSONController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author a_escobar
 */
public class LlistarNevadesJSONController extends LlistarJSONController {

    private IAfectacioService afectacioService;

    public LlistarNevadesJSONController() {
        super(new TransformadorNevadaJSON());
    }

    public IAfectacioService getAfectacioService() {
        return afectacioService;
    }

    public void setAfectacioService(IAfectacioService afectacioService) {
        this.afectacioService = afectacioService;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        String startIndex = request.getParameter("startIndex");
        if(startIndex==null){
            startIndex = "-1";
        }
        String numResults = request.getParameter("results");
        if(numResults==null){
            numResults = "-1";
        }
        int total = afectacioService.getNevadesCount();
        String sort = request.getParameter("sort");
        String dir = request.getParameter("dir");
        String ordenacio = null;
        if("comarca".contains(sort)){
            ordenacio = "element.comarca.nom";
        }else if("terme".contains(sort)){
            ordenacio = "element.terme.nom";
        }else if(sort!=null){
            ordenacio = "element."+sort;
        }
        crearJSON(afectacioService.getNevades(
            ordenacio,dir,
            Integer.parseInt(startIndex),
            Integer.parseInt(numResults)),total, request, response);
        return null;
    }
}
