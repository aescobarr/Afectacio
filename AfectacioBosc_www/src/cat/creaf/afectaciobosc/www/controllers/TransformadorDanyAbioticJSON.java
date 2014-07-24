/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.creaf.afectaciobosc.www.controllers;

import JSON.TransformadorJSON;
import cat.creaf.afectaciobosc.model.DanyAbiotic;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import org.json.JSONObject;

/**
 *
 * @author v.garcia
 */
public class TransformadorDanyAbioticJSON implements TransformadorJSON {

    private SimpleDateFormat spdf;
    
    public TransformadorDanyAbioticJSON(){
        super();
        spdf = new SimpleDateFormat("dd/MM/yyyy");
    }
    

    public JSONObject transformar(Object obj) {
        if (obj == null || !(obj instanceof DanyAbiotic)) {
            return null;
        }
        JSONObject objecte = new JSONObject();
        DanyAbiotic afectacio = (DanyAbiotic) obj;
        objecte.put("id", afectacio.getIdString());
        objecte.put("comarca", afectacio.getComarca() == null ? "" : afectacio.getComarca().toString());
        objecte.put("data", afectacio.getData() == null ? "" : spdf.format(afectacio.getData()));
        String especie1 = "";
        String grauAfect = "";
        double grauAfectMax = -1;
        double grauAfectActual;
        for(int i=0;i<afectacio.getAfectacionsEstimades().size();i++){
            try{
                if(afectacio.getAfectacionsEstimades().get(i).getAfectacio()!=null)
                    grauAfectActual = Double.parseDouble(afectacio.getAfectacionsEstimades().get(i).getAfectacio());
                else
                    grauAfectActual = 0;
            }catch(NumberFormatException ex){
                grauAfectActual = 0;
            }
            if(grauAfectActual>grauAfectMax){
                grauAfectMax = grauAfectActual;
                grauAfect = grauAfectActual + "";
                especie1 = "";
                if(afectacio.getAfectacionsEstimades().get(i).getEspecie()!=null)
                    especie1 = afectacio.getAfectacionsEstimades().get(i).getEspecie().toString();
            }
        }
        objecte.put("especie1", especie1);
        objecte.put("grauAfectacio",grauAfect);
//        objecte.put("grauAfectacio", afectacio.getGrauAfectacioXarxaViaria() + "");
        objecte.put("codi", afectacio.getCodi());
        String area = "";
        if(afectacio.getAreaAfectada()!=null){
            DecimalFormat df = new DecimalFormat("#0.00");
            area = df.format(afectacio.getAreaAfectada().getArea()/10000);
        }
        objecte.put("areaAfectada",area);
        objecte.put("codiAgent1", afectacio.getCodiAgent1() == null ? "" : afectacio.getCodiAgent1() );
        objecte.put("codiAgent2", afectacio.getCodiAgent2() == null ? "" : afectacio.getCodiAgent2() );
        objecte.put("enginyer1", afectacio.getNomEnginyer1() == null ? "" : afectacio.getNomEnginyer1() );
        objecte.put("enginyer2", afectacio.getNomEnginyer2() == null ? "" : afectacio.getNomEnginyer2() );
        return objecte;
    }
}
