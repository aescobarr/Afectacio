/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.creaf.afectaciobosc.www.controllers;

import JSON.TransformadorJSON;
import cat.creaf.afectaciobosc.model.Processionaria;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import org.json.JSONObject;

/**
 *
 * @author v.garcia
 */
public class TransformadorProcessionariaJSON implements TransformadorJSON {

    private SimpleDateFormat spdf;
    
    public TransformadorProcessionariaJSON(){
        super();
        spdf = new SimpleDateFormat("dd/MM/yyyy");
    }
    

    public JSONObject transformar(Object obj) {
        if (obj == null || !(obj instanceof Processionaria)) {
            return null;
        }
        JSONObject objecte = new JSONObject();
        Processionaria processionaria = (Processionaria) obj;
        String area = "";
        if(processionaria.getAreaAfectada()!=null){
            DecimalFormat df = new DecimalFormat("#0.00");
            area = df.format(processionaria.getAreaAfectada().getArea()/10000);
        }
        objecte.put("id", processionaria.getIdString());
        objecte.put("comarca", processionaria.getComarca() == null ? "" : processionaria.getComarca().toString());
        objecte.put("data", processionaria.getData() == null ? "" : spdf.format(processionaria.getData()));
        objecte.put("tipusBosc", processionaria.getTipusBosc() == null ? "" : processionaria.getTipusBosc().getTipus());
        objecte.put("orientacio", processionaria.getOrientacio() == null ? "" : processionaria.getOrientacio().getNom());
        objecte.put("alcada", processionaria.getAlcada() == null ? "" : processionaria.getAlcada() );
        objecte.put("especie", processionaria.getEspecie() == null ? "" : processionaria.getEspecie().getNom() );
        objecte.put("grauInfestacio", processionaria.getGrauInfestacio() == null ? "" : processionaria.getGrauInfestacio() );        
        objecte.put("codiAgent1", processionaria.getCodiAgent1() == null ? "" : processionaria.getCodiAgent1() );
        objecte.put("codiAgent2", processionaria.getCodiAgent2() == null ? "" : processionaria.getCodiAgent2() );
        objecte.put("codi", processionaria.getCodi());
        objecte.put("area",area);
        return objecte;
    }
}
