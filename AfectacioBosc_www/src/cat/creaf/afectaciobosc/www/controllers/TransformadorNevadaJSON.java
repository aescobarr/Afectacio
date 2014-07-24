/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.creaf.afectaciobosc.www.controllers;

import JSON.TransformadorJSON;
import cat.creaf.afectaciobosc.model.Nevada;
import java.text.SimpleDateFormat;
import org.json.JSONObject;

/**
 *
 * @author v.garcia
 */
public class TransformadorNevadaJSON implements TransformadorJSON {

    private SimpleDateFormat spdf;
    
    public TransformadorNevadaJSON(){
        super();
        spdf = new SimpleDateFormat("dd/MM/yyyy");
    }
    

    public JSONObject transformar(Object obj) {
        if (obj == null || !(obj instanceof Nevada)) {
            return null;
        }
        JSONObject objecte = new JSONObject();
        Nevada nevada = (Nevada) obj;
        objecte.put("id", nevada.getIdString());
        objecte.put("comarca", nevada.getComarca() == null ? "" : nevada.getComarca().toString());
        objecte.put("observacions", nevada.getObservacions() == null ? "" : nevada.getObservacions() );
        objecte.put("codi", nevada.getCodi());
        objecte.put("nomCami", nevada.getNomCami());
        objecte.put("longitudKm", nevada.getLongitudKm());
        objecte.put("terme", nevada.getTerme() == null ? "" : nevada.getTerme().toString());
        objecte.put("codiAgent1", nevada.getCodiAgent1() == null ? "" : nevada.getCodiAgent1() );
        objecte.put("codiAgent2", nevada.getCodiAgent2() == null ? "" : nevada.getCodiAgent2() );
        objecte.put("peusAfectats", nevada.getSumaPeusAfectatsPerHa());
        objecte.put("nivellAfectacio", nevada.getNivellAfectacio());
        return objecte;
    }
}
