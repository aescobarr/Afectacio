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
public class LlistarDanysAbioticsJSONController extends LlistarJSONController {

    private IAfectacioService afectacioService;

    public LlistarDanysAbioticsJSONController() {
        super(new TransformadorDanyAbioticJSON());
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
        int total = afectacioService.getDanysAbioticsCount();
        String sort = request.getParameter("sort");
        String dir = request.getParameter("dir");
        String ordenacio = null;
//        if("grauAfectacioEspecie1".equals(sort)){
//            ordenacio = "element.afectacionsEstimades.afectacio";
//        }else
        
        if(sort != null && "enginyer1".equals(sort)){
            ordenacio = "element.nomEnginyer1";
        }else if(sort != null && "enginyer2".equals(sort)){
            ordenacio = "element.nomEnginyer2";
        }else if (sort != null) {
            ordenacio = "element."+sort;
        }
        crearJSON(afectacioService.getDanysAbiotics(
            ordenacio,dir,
            Integer.parseInt(startIndex),
            Integer.parseInt(numResults)),total, request, response);
        return null;
    }
}
