/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.creaf.afectaciobosc.www.controllers;

import JSON.TransformadorJSON;
import cat.creaf.afectaciobosc.model.Sequera;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.json.JSONObject;

/**
 *
 * @author v.garcia
 */
public class TransformadorSequeraJSON implements TransformadorJSON {

    private SimpleDateFormat spdf;
    
    public TransformadorSequeraJSON(){
        super();
        spdf = new SimpleDateFormat("dd/MM/yyyy");
    }
    

    public JSONObject transformar(Object obj) {
        if (obj == null || !(obj instanceof Sequera)) {
            return null;
        }
        JSONObject objecte = new JSONObject();
        Sequera sequera = (Sequera) obj;
        objecte.put("id", sequera.getIdString());
        objecte.put("comarca", sequera.getComarca() == null ? "" : sequera.getComarca().toString());
        objecte.put("data", sequera.getData() == null ? "" : spdf.format(sequera.getData()));
        String especie1 = "";
        String grauAfect = "";
        double grauAfectMax = -1;
        double grauAfectActual;
        for(int i=0;i<sequera.getAfectacionsEstimades().size();i++){
            try{
                if(sequera.getAfectacionsEstimades().get(i).getAfectacio()!=null)
                    grauAfectActual = Double.parseDouble(sequera.getAfectacionsEstimades().get(i).getAfectacio());
                else
                    grauAfectActual = 0;
            }catch(NumberFormatException ex){
                grauAfectActual = 0;
            }
            if(grauAfectActual>grauAfectMax){
                grauAfectMax = grauAfectActual;
                grauAfect = grauAfectActual + "";
                especie1 = "";
                if(sequera.getAfectacionsEstimades().get(i).getEspecie()!=null)
                    especie1 = sequera.getAfectacionsEstimades().get(i).getEspecie().toString();
            }
        }
//        if(sequera.getAfectacionsEstimades().size()>0 &&
//                sequera.getAfectacionsEstimades().get(0).getEspecie()!=null){
//            especie1 = sequera.getAfectacionsEstimades().get(0).getEspecie().toString();
//            grauAfect = sequera.getAfectacionsEstimades().get(0).getAfectacio();
//        }
        objecte.put("especie1", especie1);
        objecte.put("grauAfectacioEspecie1", grauAfect);
        objecte.put("codi", sequera.getCodi());
        String area = "";
        if(sequera.getAreaAfectada()!=null){
            DecimalFormat df = new DecimalFormat("#0.00");
            area = df.format(sequera.getAreaAfectada().getArea()/10000);
        }
        objecte.put("areaAfectada",area);
        objecte.put("codiAgent1", sequera.getCodiAgent1() == null ? "" : sequera.getCodiAgent1() );
        objecte.put("codiAgent2", sequera.getCodiAgent2() == null ? "" : sequera.getCodiAgent2() );
        return objecte;
    }
}
