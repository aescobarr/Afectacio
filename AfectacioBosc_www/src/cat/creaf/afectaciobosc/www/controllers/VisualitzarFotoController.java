/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.creaf.afectaciobosc.www.controllers;


import cat.creaf.afectaciobosc.model.Foto;
import cat.creaf.afectaciobosc.service.IAfectacioService;
import cat.creaf.sia.sipan.controllers.DocumentViewerController;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author a_escobar
 */
public class VisualitzarFotoController extends DocumentViewerController {

    private IAfectacioService afectacioService;

    public VisualitzarFotoController() {
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
        String id = (String) request.getParameter("id");
        Foto foto = this.afectacioService.getFoto(id);
        InputStream reportStream = new ByteArrayInputStream(foto.getFitxerEnBytes());
        setReportStream(reportStream);
        setContentType("application/"+foto.getNomExtensio());
        crearReport(request, response);
        return null;
    }

    
}
