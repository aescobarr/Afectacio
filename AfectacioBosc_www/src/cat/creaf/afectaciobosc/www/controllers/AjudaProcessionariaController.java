/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cat.creaf.afectaciobosc.www.controllers;

import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.acegisecurity.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author v.garcia
 */
public class AjudaProcessionariaController extends AbstractController {

    public AjudaProcessionariaController(){
        super();
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap hm = new HashMap();
        Enumeration<String> names = request.getParameterNames();
        String name;
        while(names.hasMoreElements()){
            name = names.nextElement();
            hm.put(name,request.getParameter(name));
        }
        String contingut = request.getParameter("contingut");
        return new ModelAndView("Processionaria/"+contingut,hm);
    }

}
