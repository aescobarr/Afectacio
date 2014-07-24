/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cat.creaf.afectaciobosc.www.controllers;

import MGeneral_www.editor.ObjecteSIPANEditor;
import cat.creaf.afectaciobosc.model.*;
import cat.creaf.afectaciobosc.service.IAfectacioService;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryCollection;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.PrecisionModel;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.acegisecurity.context.SecurityContextHolder;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author v.garcia
 */
public class ProcessionariaController extends SimpleFormController {

    private IAfectacioService afectacioService;

    public ProcessionariaController() {
        setCommandClass(Processionaria.class);
        setCommandName("processionaria");
        setFormView("Processionaria/llistarProcessionaries");
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        String id = request.getParameter("idprocessionaria");
        Processionaria processionaria = afectacioService.getProcessionaria(id);
        return processionaria;
    }

    public IAfectacioService getAfectacioService() {
        return afectacioService;
    }

    public void setAfectacioService(IAfectacioService afectacioService) {
        this.afectacioService = afectacioService;
    }

    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(TipusBosc.class, new ObjecteSIPANEditor(afectacioService.getTipusBoscos()));
        binder.registerCustomEditor(Orientacio.class, new ObjecteSIPANEditor(afectacioService.getOrientacions()));
        binder.registerCustomEditor(Especie.class, new ObjecteSIPANEditor(afectacioService.getEspecies()));
        binder.registerCustomEditor(GrauInfestacio.class, new ObjecteSIPANEditor(afectacioService.getGrausInfestacioProcessionaria()));
        binder.registerCustomEditor(Comarca.class, new ObjecteSIPANEditor(afectacioService.getComarquesAfectacioBosc()));
        binder.registerCustomEditor(Date.class, null,
                new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true));
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
        sortida.put("especies",afectacioService.getEspeciesAmbProcessionaria());
        sortida.put("grausinfestacio",afectacioService.getGrausInfestacioProcessionaria());
        sortida.put("tipusbosc",afectacioService.getTipusBoscos());
        sortida.put("orientacions",afectacioService.getOrientacions());
        sortida.put("comarques",afectacioService.getComarquesAfectacioBosc());

        int primer = Integer.parseInt(primerElement);
        String numElemsString = request.getParameter("numelements");
        if (numElemsString == null || "".equals(numElemsString)) {
            numElemsString = "30";
        }
        int numElements = Integer.parseInt(numElemsString);
        sortida.put("numelements", request.getParameter("numelements"));
        int numTotal = afectacioService.getProcessionariesCount();
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
        Processionaria processionaria = (Processionaria) command;
//        processionaria.setAlcadaString(altitud);
        String wktGeom = request.getParameter("wkt");
        if(wktGeom.equalsIgnoreCase("GEOMETRYCOLLECTION()")){
            processionaria.setAreaAfectada(null);
        }else{
            processionaria.setAreaAfectada(getAreaDeWkt(wktGeom));
        }
        afectacioService.desar(processionaria);
        return new ModelAndView("redirect:/processionaria/llistarprocessionaries.htm", "dades", hm);
    }

    private Geometry getAreaDeWkt(String wkt) throws ParseException{
        PrecisionModel p = new PrecisionModel(PrecisionModel.FLOATING);
        GeometryFactory gf = new GeometryFactory(p,23031);
        WKTReader reader = new WKTReader(gf);
        GeometryCollection area = (GeometryCollection)reader.read(wkt);
        ArrayList llistaGeometries = new ArrayList();
        for (int i = 0; i < area.getNumGeometries(); i++) {
            Geometry g_n = area.getGeometryN(i);
            g_n.setSRID(23031);
            llistaGeometries.add(g_n);
        }
        return gf.buildGeometry(llistaGeometries);
    }    
}