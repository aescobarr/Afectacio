/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.creaf.afectaciobosc.www.controllers;


import Imatge.ImatgesUtilitats;
import cat.creaf.afectaciobosc.model.Foto;
import cat.creaf.afectaciobosc.model.Sequera;
import cat.creaf.afectaciobosc.service.IAfectacioService;
import cat.creaf.sia.sipan.controllers.LlistarJSONController;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author a_escobar
 */
public class LlistarFotosSequeraJSONController extends LlistarJSONController {

    private IAfectacioService afectacioService;
    
    
    private String pathThumbnails;
    
    public LlistarFotosSequeraJSONController() {
        super(new TransformadorFotoJSON());
        this.pathThumbnails = "";
    }
    
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

//        String idENP = request.getParameter("idenp");
//        ENP enp = enpsService.getENP(idENP);
        String idSequera = request.getParameter("idafectacio");
        Sequera sequera = afectacioService.getSequera(idSequera);

        List<Foto> imatges = sequera.getFotos();
        String pos = request.getParameter("pos");
        int posicio = -1;
        if (pos != null && !"".equals(pos)) {
            posicio = Integer.parseInt(pos);
        } else {
            posicio = 0;
        }

        List<Foto> imatgesARetornar = imatges;
        if (posicio > -1) {
            imatgesARetornar = new ArrayList<Foto>();
            if (imatges.size() > posicio) {
                imatgesARetornar.add(imatges.get(posicio));
            }
            if (imatges.size() > posicio + 1) {
                imatgesARetornar.add(imatges.get(posicio + 1));
            }
            if (imatges.size() > posicio + 2) {
                imatgesARetornar.add(imatges.get(posicio + 2));
            }
            if (imatges.size() > posicio + 3) {
                imatgesARetornar.add(imatges.get(posicio + 3));
            }
            if (imatges.size() > posicio + 4) {
                imatgesARetornar.add(imatges.get(posicio + 4));
            }
            if (imatges.size() > posicio + 5) {
                imatgesARetornar.add(imatges.get(posicio + 5));
            }
            if (imatges.size() > posicio + 6) {
                imatgesARetornar.add(imatges.get(posicio + 6));
            }
            if (imatges.size() > posicio + 7) {
                imatgesARetornar.add(imatges.get(posicio + 7));
            }
            if (imatges.size() > posicio + 8) {
                imatgesARetornar.add(imatges.get(posicio + 8));
            }
        }
        crearJSONImatges(imatgesARetornar, request, response);
        return null;
    }    
    
    protected void crearJSONImatges(List elements, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject resultat = new JSONObject();
        JSONArray array = new JSONArray();
        JSONObject objecte;
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        ((TransformadorFotoJSON)this.getTransformador()).setPathThumbnails(getServletContext().getRealPath("grafics_temp")  +"/");
        try {
            for (int i = 0; i < elements.size(); i++) {
                objecte = new JSONObject();
                Foto foto = (Foto) elements.get(i);
                BufferedImage biThumb = ImatgesUtilitats.resize(ImatgesUtilitats.read(foto.getFitxerEnBytes()), 150);
                if(pathThumbnails==null || "".equals(pathThumbnails)){
                    setPathThumbnails(getServletContext().getRealPath("grafics_temp")  +"/");
                }
                String pathThumbDesat = pathThumbnails + foto.getIdString() + "_thn.jpg";
                ImatgesUtilitats.storeJPEG(biThumb, pathThumbDesat);
                objecte.put("id", foto.getIdString());
                objecte.put("titol", foto.getTitol()== null ? "": foto.getTitol());
                array.put(objecte);
            }
            resultat.put("records", array);
            response.setContentType("text/json;charset=utf-8");
            response.getWriter().print(resultat.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the pathThumbnails
     */
    public String getPathThumbnails() {
        return pathThumbnails;
    }

    /**
     * @param pathThumbnails the pathThumbnails to set
     */
    public void setPathThumbnails(String pathThumbnails) {
        this.pathThumbnails = pathThumbnails;
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
