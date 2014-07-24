/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.creaf.afectaciobosc.www.controllers;

import JSON.TransformadorJSON;
import cat.creaf.afectaciobosc.model.Especie;
import org.json.JSONObject;

/**
 *
 * @author v.garcia
 */
public class TransformadorEspecieJSON implements TransformadorJSON {
    
    public TransformadorEspecieJSON(){
        super();
    }
    

    public JSONObject transformar(Object obj) {
        if (obj == null || !(obj instanceof Especie)) {
            return null;
        }
        JSONObject objecte = new JSONObject();
        Especie especie = (Especie) obj;
        objecte.put("id", especie.getIdString());
        objecte.put("nom", especie.toString());
        return objecte;
    }
}
