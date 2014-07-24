/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.creaf.afectaciobosc.www.controllers;

import Imatge.ImatgesUtilitats;
import JSON.TransformadorJSON;
import cat.creaf.afectaciobosc.model.Foto;
import java.awt.image.BufferedImage;
import org.json.JSONObject;

/**
 *
 * @author v.garcia
 */
public class TransformadorFotoJSON implements TransformadorJSON {
    
    private String pathThumbnails;

    public JSONObject transformar(Object obj) {
        if (obj == null || !(obj instanceof Foto)) {
            return null;
        }
        JSONObject objecte = new JSONObject();
        Foto foto = (Foto) obj;
        try{
        BufferedImage biThumb = ImatgesUtilitats.resize(ImatgesUtilitats.read(foto.getFitxerEnBytes()), 150);
        
        String pathThumb = pathThumbnails+ foto.getIdString() + "_thn.jpg";
//        String pathThumb = "C:\\AplicacionsWEB\\AfectacioBosc\\grafics_temp\\" + foto.getIdString() + "_thn.jpg";
            ImatgesUtilitats.storeJPEG(biThumb, pathThumb);

        objecte.put("",pathThumb);
        }catch(Exception ex){
            
        }
        return objecte;
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
}
