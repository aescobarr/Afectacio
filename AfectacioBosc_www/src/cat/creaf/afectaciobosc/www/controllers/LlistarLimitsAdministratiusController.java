/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cat.creaf.afectaciobosc.www.controllers;

import MSIPANGeneral.ISIPANService;
import MSIPANGeneral.Toponim;
import cat.creaf.afectaciobosc.model.Comarca;
import cat.creaf.afectaciobosc.model.Municipi;
import cat.creaf.afectaciobosc.model.Provincia;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author a_escobar
 */
public class LlistarLimitsAdministratiusController extends AbstractController {

    private ISIPANService SIPANService;
    private ResourceBundle bundleSIPAN;

    public LlistarLimitsAdministratiusController(){
        super();
        bundleSIPAN = ResourceBundle.getBundle("Literals/MSIPAN");
    }

    protected void escriuComarquesDeProvincia(String codiProvincia,HttpServletResponse response,Integer numCaracters) throws IOException{
        List comarques = SIPANService.getComarquesDeProvincia(codiProvincia);
        StringBuffer retVal = new StringBuffer();
        retVal.append("obj.options[obj.options.length] = new Option(\"" + bundleSIPAN.getString("triaUna")  + " " + bundleSIPAN.getString("comarca") + "...\",'');\n");
        for (int i = 0; i < comarques.size(); i++) {
            Comarca c = (Comarca)comarques.get(i);            
            retVal.append("obj.options[obj.options.length] = new Option(\"" + trencaLinia(c.getNom(),numCaracters) +  "\",'" + c.getIdString() + "&" + getEnvolupantComarcaFormatString(c) + "');\n");
        }
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().print(retVal.toString());
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //List provincia = SIPANService.getProvincies();
        //crearJSON(provincia, httpServletRequest, httpServletResponse);
        String objRetorna = httpServletRequest.getParameter("retorna");
        String codiObj = httpServletRequest.getParameter("codi");
        Integer num_break = null;
        String break_str = httpServletRequest.getParameter("break");
        try{
            num_break = Integer.parseInt(break_str);
        }catch(NumberFormatException e){

        }
        if(objRetorna != null){
            if(objRetorna.equalsIgnoreCase("comarca")){
                escriuComarquesDeProvincia(codiObj,httpServletResponse,num_break);
            }else if(objRetorna.equalsIgnoreCase("municipi")){
                escriuMunicipisDeComarca(codiObj,httpServletResponse,num_break);
            }else if(objRetorna.equalsIgnoreCase("toponim")){
                escriuToponimsDeMunicipi(codiObj, httpServletResponse,num_break);
            }
        }
        return null;
    }

    protected void escriuToponimsDeMunicipi(String codiMunicipi, HttpServletResponse response, Integer numCaracters) throws IOException {
        List toponims = SIPANService.getToponimsDeMunicipi(codiMunicipi);
        //La sentència select HQL no els torna ordenats(??)
        //Collections.sort(municipis, new ComparadorMunicipiNom());
        StringBuffer retVal = new StringBuffer();
        retVal.append("obj.options[obj.options.length] = new Option(\"" + bundleSIPAN.getString("triaUn")  + " " + bundleSIPAN.getString("toponim") + "...\",'');\n");
        for (int i = 0; i < toponims.size(); i++) {
            Toponim t = (Toponim)toponims.get(i);
            retVal.append("obj.options[obj.options.length] = new Option(\"" + trencaLinia(t.getToponim(),numCaracters) +  "\",'" + t.getIdString() + "&" + getEnvolupantToponimFormatString(t) + "');\n");
        }
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().print(retVal.toString());
    }

    protected void escriuMunicipisDeComarca(String codiComarca, HttpServletResponse response, Integer numCaracters) throws IOException {
        List municipis = SIPANService.getMunicipisDeComarca(codiComarca);
        //La sentència select HQL no els torna ordenats(??)
        Collections.sort(municipis, new ComparadorMunicipiNom());
        StringBuffer retVal = new StringBuffer();
        retVal.append("obj.options[obj.options.length] = new Option(\"" + bundleSIPAN.getString("triaUn")  + " " + bundleSIPAN.getString("municipi") + "...\",'');\n");
        for (int i = 0; i < municipis.size(); i++) {
            Municipi m = (Municipi)municipis.get(i);
            retVal.append("obj.options[obj.options.length] = new Option(\"" + trencaLinia(m.getNom(),numCaracters) +  "\",'" + m.getIdString() + "&" + getEnvolupantMunicipiFormatString(m) + "');\n");
//            retVal.append("obj.options[obj.options.length] = o;\n");
//            retVal.append("o.id = " + getEnvolupantMunicipiFormatString(m) + ";\n");
            //retVal.append("obj.options[obj.options.length].value = " + getEnvolupantMunicipiFormatString(m) + ";\n");
        }
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().print(retVal.toString());
    }

    private String getEnvolupantComarcaFormatString(Comarca c){
        StringBuffer retVal = new StringBuffer();
        retVal.append(c.getMinX() + "&" + c.getMaxX() + "&" + c.getMinY() + "&" + c.getMaxY());
        return retVal.toString();
    }

    private String getEnvolupantMunicipiFormatString(Municipi m){
        StringBuffer retVal = new StringBuffer();
        retVal.append(m.getMinX() + "&" + m.getMaxX() + "&" + m.getMinY() + "&" + m.getMaxY());
        return retVal.toString();
    }

    private String getEnvolupantToponimFormatString(Toponim t){
        StringBuffer retVal = new StringBuffer();
        retVal.append(t.getX() + "&" + t.getX() + "&" + t.getY() + "&" + t.getY());
        return retVal.toString();
    }

    protected void crearJSON(List<Provincia> provincies,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JSONObject resultat = new JSONObject();
        JSONArray array = new JSONArray();
        JSONObject objecte;

        for (int i = 0; i < provincies.size(); i++) {
            objecte = new JSONObject();            
            Provincia p = provincies.get(i);
            objecte.put("id", p.getIdString());
            objecte.put("nom", p.getNom());
            array.put(objecte);
        }
        resultat.put("records", array);
        response.setContentType("text/json;charset=UTF-8");
        try {
            response.getWriter().print(resultat.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String trencaLinia(String cadena, Integer numCaracters){
        StringBuffer retVal = new StringBuffer(cadena);
        if(numCaracters==null || retVal.length() < numCaracters - 1)
            return retVal.toString();
        if(retVal.substring(numCaracters-1,1).equalsIgnoreCase(" ")){
            retVal.insert(numCaracters-1, "<br>");
        }else{
            int contador = numCaracters-1;
            while(contador >= 0){
                if(retVal.substring(contador,1).equalsIgnoreCase(" ")){
                    retVal.insert(contador, "<br>");
                }
                contador--;
            }
        }
        return retVal.toString();
    }

    /**
     * @return the SIPANService
     */
    public ISIPANService getSIPANService() {
        return SIPANService;
    }

    /**
     * @param SIPANService the SIPANService to set
     */
    public void setSIPANService(ISIPANService SIPANService) {
        this.SIPANService = SIPANService;
    }


}
