/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cat.creaf.afectaciobosc.www.controllers;

import MGeneral_www.editor.ObjecteSIPANEditor;
import cat.creaf.afectaciobosc.model.*;
import cat.creaf.afectaciobosc.service.IAfectacioService;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryCollection;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.PrecisionModel;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.acegisecurity.context.SecurityContextHolder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author v.garcia
 */
public class NevadaController extends SimpleFormController {

    private IAfectacioService afectacioService;

    public NevadaController() {
        setCommandClass(Nevada.class);
        setCommandName("nevada");
        setFormView("Nevades/llistarNevades");
    }

    public IAfectacioService getAfectacioService() {
        return afectacioService;
    }

    public void setAfectacioService(IAfectacioService afectacioService) {
        this.afectacioService = afectacioService;
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        Nevada nevada = null;
        String idAfectacio = request.getParameter("idnevada");
        nevada = (Nevada)getAfectacioService().getNevada(idAfectacio);
        return nevada;
    }

    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Especie.class, new ObjecteSIPANEditor(afectacioService.getEspecies()));
        binder.registerCustomEditor(Comarca.class, new ObjecteSIPANEditor(afectacioService.getComarquesAfectacioBosc()));
        binder.registerCustomEditor(Municipi.class, new ObjecteSIPANEditor(afectacioService.getMunicipisAfectacioBosc()));
    }

    @Override
    protected Map referenceData(HttpServletRequest request, Object command, Errors errors) throws Exception {
        Map sortida = new HashMap();
        sortida.put("id", request.getParameter("id"));
        String primerElement = "0";
        if (request.getParameter("primerelement") != null && !request.getParameter("primerelement").equalsIgnoreCase("")) {
            primerElement = request.getParameter("primerelement");
        }
        sortida.put("numtotalelements", request.getParameter("numtotalelements"));
        sortida.put("primerelement", primerElement);
        sortida.put("especies",afectacioService.getEspecies());
        sortida.put("comarques",afectacioService.getComarquesAfectacioBosc());
        sortida.put("municipis",afectacioService.getMunicipisAfectacioBosc());
        int primer = Integer.parseInt(primerElement);
        String numElemsString = request.getParameter("numelements");
        if (numElemsString == null || "".equals(numElemsString)) {
            numElemsString = "30";
        }
        int numElements = Integer.parseInt(numElemsString);
        sortida.put("numelements", request.getParameter("numelements"));
        int numTotal = afectacioService.getNevadesCount();
        sortida.put("numtotalelements", numTotal);
        String operacio = request.getParameter("operacio");
        if (numElements == -1) {
            primer = 0;
            numElements = numTotal;
        } else if ("0".equals(operacio)) {
            primer = 0;
        } else if ("1".equals(operacio)) {
            primer = primer - numElements;
        } else if ("2".equals(operacio)) {
            primer = primer + numElements;
        } else if ("3".equals(operacio)) {
            if (numTotal % numElements > 0) {
                primer = numTotal - (numTotal % numElements);
                numElements = numTotal % numElements;
            } else {
                primer = numTotal - numElements;
            }
        }
        sortida.put("editable", true);
        sortida.put("primerelement", primer + "");
        sortida.put("ip", getIP());
        sortida.put("observacionsjson", convertirDadesObservacioJSON((Nevada) command));
        List<Especie> especies = afectacioService.getEspecies();
        sortida.put("especiesAOferir",convertirEspeciesJSON(especies));
        return sortida;
    }


    private String getIP() {
        String ip = null;
        try {
            java.net.InetAddress i = java.net.InetAddress.getLocalHost();
            ip =i.getCanonicalHostName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ip;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        Map hm = new HashMap();
        hm.put("id", request.getParameter("id"));
        hm.put("ip", getIP());
        String primerElement = "0";
        if (request.getParameter("primerelement") != null) {
            primerElement = request.getParameter("primerelement");
        }
        hm.put("primerelement", primerElement);
        hm.put("numelements", request.getParameter("numelements"));        
//        String altitud = request.getParameter("altitud");
        Nevada nevada = (Nevada) command;
//        processionaria.setAlcadaString(altitud);
        String wktGeom = request.getParameter("wkt");
        if(wktGeom.equalsIgnoreCase("GEOMETRYCOLLECTION()")){
            nevada.setAreaAfectada(null);
        }else{
            nevada.setAreaAfectada(getAreaDeWkt(wktGeom));
        }
        nevada.setDadesObservacions(convertirDadesObservacioJSON(request.getParameter("idsDadesObservacions"),nevada));
        afectacioService.desar(nevada);
        return new ModelAndView("redirect:/nevades/llistarnevades.htm", "dades", hm);
    }

    private Geometry getAreaDeWkt(String wkt) throws ParseException{
        PrecisionModel p = new PrecisionModel(PrecisionModel.FLOATING);
        GeometryFactory gf = new GeometryFactory(p,23031);
        WKTReader reader = new WKTReader(gf);
        GeometryCollection area = (GeometryCollection)reader.read(wkt);
        ArrayList llistaGeometries = new ArrayList();
        Coordinate[] coords = new Coordinate[2];
        if(area.getNumGeometries()==2){
            Geometry g_n = area.getGeometryN(0);
            coords[0] = g_n.getCoordinate();
            g_n = area.getGeometryN(1);
            coords[1] = g_n.getCoordinate();
            Geometry linia = gf.createLineString(coords);
            linia.setSRID(23031);
            llistaGeometries.add(linia);
        }
        return gf.buildGeometry(llistaGeometries);
    }

    private String convertirDadesObservacioJSON(Nevada nevada) {
//        TransformadorJSON transformador = new TransformadorDadaObservacioGallFerJSON();
        JSONArray array = new JSONArray();
//        JSONObject objecte;
//        List elements = citacio.getDadesObservacions();
//        for (int i = 0; i < elements.size(); i++) {
//            objecte = transformador.transformar(elements.get(i));
//            array.put(objecte);
//        }
        return array.toString();
    }

    private String convertirEspeciesJSON(List<Especie> elements) {
        JSONArray array = new JSONArray();
        JSONObject objecte;
        Especie especie;
        for (int i = 0; i < elements.size(); i++) {
            especie = (Especie)elements.get(i);
            objecte = new JSONObject();
            objecte.put("id", especie.getIdString());
            objecte.put("especie", especie.toString());
            objecte.put("value", especie.toString());
            objecte.put("label", especie.toString());
            array.put(objecte);
        }
        return array.toString();
    }

    private List<DadaObservacio> convertirDadesObservacioJSON(String json,Nevada nevada) {
        Especie especie;
        DadaObservacio dada;
        List<DadaObservacio> dades = new ArrayList<DadaObservacio>();
        if(json==null || json.trim().length()==0)
            return dades;
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray array = jsonObject.getJSONArray("_records");
            for (int i = 0; i < array.length(); i++) {
                jsonObject = array.getJSONObject(i).getJSONObject("_oData");
                String id = jsonObject.getString("id");
                dada = new DadaObservacio();
                dada.setIdString(id);
                dada.setNevada(nevada);
                especie = afectacioService.getEspecies(jsonObject.getString("especie")).get(0);
                dada.setEspecie(especie);
                dada.setPistaParcialmentAfectat(jsonObject.getInt("pistaParcial"));
                dada.setPistaTotalmentAfectat(jsonObject.getInt("pistaTotal"));
                dada.setFranjaParcialmentAfectat(jsonObject.getInt("franjaParcial"));
                dada.setFranjaTotalmentAfectat(jsonObject.getInt("franjaTotal"));
                dades.add(dada);
            }
        } catch (Exception ex) {
            Logger.getLogger(NevadaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dades;
    }

    
}