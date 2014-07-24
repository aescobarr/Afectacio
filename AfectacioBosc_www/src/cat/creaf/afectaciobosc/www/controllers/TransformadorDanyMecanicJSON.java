/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.creaf.afectaciobosc.www.controllers;

import JSON.TransformadorJSON;
import cat.creaf.afectaciobosc.model.DanyMecanic;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import org.json.JSONObject;

/**
 *
 * @author v.garcia
 */
public class TransformadorDanyMecanicJSON implements TransformadorJSON {

    private SimpleDateFormat spdf;
    
    public TransformadorDanyMecanicJSON(){
        super();
        spdf = new SimpleDateFormat("dd/MM/yyyy");
    }
    

    public JSONObject transformar(Object obj) {
        if (obj == null || !(obj instanceof DanyMecanic)) {
            return null;
        }
        JSONObject objecte = new JSONObject();
        DanyMecanic dm = (DanyMecanic) obj;
        objecte.put("id", dm.getIdString());
        objecte.put("comarca", dm.getComarca() == null ? "" : dm.getComarca().toString());
        objecte.put("data", dm.getData() == null ? "" : spdf.format(dm.getData()));
        String especie1 = "";
        String grauAfect = "";
        double grauAfectMax = -1;
        double grauAfectActual;
        for(int i=0;i<dm.getAfectacionsEstimades().size();i++){
            try{
                if(dm.getAfectacionsEstimades().get(i).getAfectacio()!=null)
                    grauAfectActual = Double.parseDouble(dm.getAfectacionsEstimades().get(i).getAfectacio());
                else
                    grauAfectActual = 0;
            }catch(NumberFormatException ex){
                grauAfectActual = 0;
            }
            if(grauAfectActual>grauAfectMax){
                grauAfectMax = grauAfectActual;
                grauAfect = grauAfectActual + "";
                especie1 = "";
                if(dm.getAfectacionsEstimades().get(i).getEspecie()!=null)
                    especie1 = dm.getAfectacionsEstimades().get(i).getEspecie().toString();
            }
        }
        objecte.put("especie1", especie1);
        objecte.put("grauAfectacio", dm.getGrauAfectacio() + "");
        objecte.put("codi", dm.getCodi());
        String area = "";
        if(dm.getAreaAfectada()!=null){
            DecimalFormat df = new DecimalFormat("#0.00");
            area = df.format(dm.getAreaAfectada().getArea()/10000);
        }
        objecte.put("areaAfectada",area);
        objecte.put("codiAgent1", dm.getCodiAgent1() == null ? "" : dm.getCodiAgent1() );
        objecte.put("codiAgent2", dm.getCodiAgent2() == null ? "" : dm.getCodiAgent2() );
        return objecte;
    }
}
