/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.creaf.afectaciobosc.www.controllers;

import cat.creaf.afectaciobosc.model.Afectacio;
import cat.creaf.afectaciobosc.model.DanyAbiotic;
import cat.creaf.afectaciobosc.model.Nevada;
import cat.creaf.afectaciobosc.model.Processionaria;
import cat.creaf.afectaciobosc.model.Sequera;
import cat.creaf.afectaciobosc.service.IAfectacioService;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author a_escobar
 */
public class ImprimirAfectacioController extends AbstractController {

    private final static int width = 400;
    private final static int height = 400;
    private final static int zoom = 550;
//    private final static double AIRE_X = 500;
//    private final static double AIRE_Y = 500;
    private final static double AIRE_X = 1000;
    private final static double AIRE_Y = 1000;
    private final static double CAT_MIN_X = 258000;
    private final static double CAT_MAX_X = 536000;
    private final static double CAT_MIN_Y = 4485000;
    private final static double CAT_MAX_Y = 4752000;
//    private final static String PATH_IMG_TEMP = "C:\\AplicacionsWEB\\AfectacioBosc\\grafics_temp\\";
    private final static String PATH_IMG_TEMP = "/home/usu_samba/AplicacionsWeb/AfectacioBosc/grafics_temp/";
    private IAfectacioService afectacioService;
    public ImprimirAfectacioController() {
        super();
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap hm = new HashMap();
        BufferedImage resultat = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        String idAfectacio = request.getParameter("idafectacio");
        Afectacio afectacio = afectacioService.getAfectacio(idAfectacio);
        hm.put("afectacio", afectacio);
        String paginaSortida = "";
        String capaGeoserver = "";
        if(afectacio instanceof Processionaria){
            paginaSortida = "Processionaria/imprimirProcessionaria";
            capaGeoserver = "SIPAN%3AAFECTACIO_GEOMETRIA";
        }else if(afectacio instanceof Nevada){
            paginaSortida = "Nevades/imprimirNevada";
            capaGeoserver = "SIPAN%3ANEVADES_GEOMETRIA";
        }else if(afectacio instanceof Sequera){
            paginaSortida = "Sequeres/imprimirSequera";
            capaGeoserver = "SIPAN%3ASEQUERA_GEOMETRIA";
            hm.put("numFotos",((Sequera)afectacio).getFotos().size());
//        }else if(afectacio instanceof DanyMecanic){
//            paginaSortida = "DanysMecanics/imprimirDanyMecanic";
//            capaGeoserver = "SIPAN%3ADANYMECANIC_GEOMETRIA";
        }else if(afectacio instanceof DanyAbiotic){
            paginaSortida = "DanysAbiotics/imprimirDanyAbiotic";
            capaGeoserver = "SIPAN%3ADANYABIOTIC_GEOMETRIA";
        }
        String coordenades = "";
        double minX = CAT_MIN_X;
        double maxX = CAT_MAX_X;
        double minY = CAT_MIN_Y;
        double maxY = CAT_MAX_Y;
        coordenades = minX + "," + minY + "," + maxX + "," + maxY;
        Graphics2D g2 = (Graphics2D)resultat.getGraphics();
        double k = width/height;
        String direccioPolURL = "";
        if (afectacio.getAreaAfectada() != null) {
            double envolupantXMin = afectacio.getAreaAfectada().getEnvelopeInternal().getMinX() - AIRE_X;
            double envolupantXMax = afectacio.getAreaAfectada().getEnvelopeInternal().getMaxX() + AIRE_X;
            double envolupantYMin = afectacio.getAreaAfectada().getEnvelopeInternal().getMinY() - AIRE_Y;
            double envolupantYMax = afectacio.getAreaAfectada().getEnvelopeInternal().getMaxY() + AIRE_Y;
            double envAireX = envolupantXMax - envolupantXMin;
            double envAireY = envolupantYMax - envolupantYMin;
            double afegit = 0;
            if((envAireX/envAireY)>k){
                afegit = (envAireX/k) - envAireY;
                envolupantYMin -= afegit/2;
                envolupantYMax += afegit/2;
            }else{
                afegit = k*envAireY - envAireX;
                envolupantXMin -= afegit/2;
                envolupantXMax += afegit/2;
            }
            coordenades = envolupantXMin + "," + envolupantYMin + "," + envolupantXMax + "," + envolupantYMax;
            direccioPolURL = "http://"+getIP()+"/geoserver/wms?LAYERS="+capaGeoserver+"&STYLES=&TRANSPARENT=true&FORMAT=image%2Fpng&WIDTH="+width+"&HEIGHT="+height+"&TILED=true&SERVICE=WMS&VERSION=1.1.1&REQUEST=GetMap&EXCEPTIONS=application%2Fvnd.ogc.se_inimage&SRS=EPSG%3A23031&BBOX="+coordenades
                                +"&CQL_FILTER=(id='"+afectacio.getIdString()+"')";
        }
        String direccioURL = null;
        if(afectacio.getAreaAfectada()!=null && afectacio.getAreaAfectada().getArea() < 5000){
            direccioURL = "http://shagrat.icc.es/lizardtech/iserv/ows?LAYERS=mtc5m&FORMAT=image%2Fpng&EXCEPTIONS=application%2Fvnd.ogc.se_xml&SERVICE=WMS&VERSION=1.1.1&REQUEST=GetMap&STYLES=&SRS=EPSG%3A23031&WIDTH="+width+"&HEIGHT="+height+"&BBOX="+ coordenades;
        }else{
            direccioURL = "http://shagrat.icc.es/lizardtech/iserv/ows?LAYERS=mtc50m&FORMAT=image%2Fpng&EXCEPTIONS=application%2Fvnd.ogc.se_xml&SERVICE=WMS&VERSION=1.1.1&REQUEST=GetMap&STYLES=&SRS=EPSG%3A23031&WIDTH="+width+"&HEIGHT="+height+"&BBOX="+ coordenades;
        }
        String nom = System.currentTimeMillis() + ".png";
        try{
            URL url = new URL(direccioURL);
            BufferedImage orto = ImageIO.read(url);
            g2.drawImage(orto, null, 0, 0);
            if (afectacio.getAreaAfectada() != null) {                
                URL urlPols = new URL(direccioPolURL);
                BufferedImage pols = ImageIO.read(urlPols);
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.7f));
                g2.drawImage(pols, null, 0, 0);
            }
            hm.put("nomFitxer",nom);
            ImageIO.write(resultat, "png",new File(PATH_IMG_TEMP+nom));
        }catch(Exception ex){
            ex.printStackTrace();
            Logger.getLogger(ImprimirAfectacioController.class.getName()).log(Level.SEVERE,PATH_IMG_TEMP+nom , ex);
        }
        String area = "";
        String centroide = "";
        String centroide_x = "";
        String centroide_y = "";
        if(afectacio.getAreaAfectada()!=null){
            area = Double.toString(afectacio.getAreaAfectada().getArea()/10000);
            centroide = "X="+Integer.toString((int)afectacio.getAreaAfectada().getCentroid().getX())+
                    ",Y="+Integer.toString((int)afectacio.getAreaAfectada().getCentroid().getY());
            centroide_x = Integer.toString((int)afectacio.getAreaAfectada().getCentroid().getX());
            centroide_y = Integer.toString((int)afectacio.getAreaAfectada().getCentroid().getY());
        }
        hm.put("area",area);
        hm.put("centroide",centroide);
        hm.put("centroide_x",centroide_x);
        hm.put("centroide_y",centroide_y);
        hm.put("ip",getIP());    
        return new ModelAndView(paginaSortida, "dades", hm);
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
    /**
     * @return the afectacioService
     */
    public IAfectacioService getAfectacioService() {
        return afectacioService;
    }

    /**
     * @param afectacioService the afectacioService to set
     */
    public void setAfectacioService(IAfectacioService afectacioService) {
        this.afectacioService = afectacioService;
    }
}
