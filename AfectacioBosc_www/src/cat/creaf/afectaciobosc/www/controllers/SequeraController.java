/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.creaf.afectaciobosc.www.controllers;

import cat.creaf.afectaciobosc.model.ArbreTransecteSequera;
import MGeneral_www.editor.ObjecteSIPANEditor;
import cat.creaf.afectaciobosc.model.AfectacioEstimada;
import cat.creaf.afectaciobosc.model.CausaDecaiment;
import cat.creaf.afectaciobosc.model.DistribucioArbresAfectats;
import cat.creaf.afectaciobosc.model.Especie;
import cat.creaf.afectaciobosc.model.RegeneracioEspecieForestal;
import cat.creaf.afectaciobosc.model.Sequera;
import cat.creaf.afectaciobosc.model.TipusBosc;
import cat.creaf.afectaciobosc.service.IAfectacioService;
import com.vividsolutions.jts.geom.Coordinate;
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
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.acegisecurity.context.SecurityContextHolder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import MSeguretatObj.Usuari;
import cat.creaf.afectaciobosc.model.Foto;
import java.io.*;
import java.util.StringTokenizer;
import org.acegisecurity.context.SecurityContextHolder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 *
 * @author v.garcia
 */
public class SequeraController extends SimpleFormController {

    private IAfectacioService afectacioService;

    public SequeraController() {
        setCommandClass(Sequera.class);
        setCommandName("afectacio");
        setFormView("Sequeres/llistarSequeres");
    }

    public IAfectacioService getAfectacioService() {
        return afectacioService;
    }

    public void setAfectacioService(IAfectacioService afectacioService) {
        this.afectacioService = afectacioService;
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        Sequera afectacio = null;
        String idAfectacio = request.getParameter("idafectacio");
        afectacio = getAfectacioService().getSequera(idAfectacio);
        return afectacio;
    }

    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Especie.class, new ObjecteSIPANEditor(afectacioService.getEspecies()));
        binder.registerCustomEditor(TipusBosc.class, new ObjecteSIPANEditor(afectacioService.getTipusBoscos()));
        binder.registerCustomEditor(DistribucioArbresAfectats.class, new ObjecteSIPANEditor(afectacioService.getDistribucionsArbresAfectats()));
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
        int primer = Integer.parseInt(primerElement);
        String numElemsString = request.getParameter("numelements");
        if (numElemsString == null || "".equals(numElemsString)) {
            numElemsString = "30";
        }
        int numElements = Integer.parseInt(numElemsString);
        sortida.put("numelements", request.getParameter("numelements"));
        int numTotal = afectacioService.getSequeresCount();
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
        sortida.put("distribucions", afectacioService.getDistribucionsArbresAfectats());
        sortida.put("causesDecaiment", afectacioService.getCausesDecaimentSequera());
        sortida.put("orientacions", afectacioService.getTipusOrientacions());
        sortida.put("pendents", afectacioService.getPendents());
        sortida.put("posicionsPendent", afectacioService.getPosicionsPendent());
        sortida.put("disposicionsPendent", afectacioService.getDisposicionsPendent());
        sortida.put("tipusBoscos", afectacioService.getTipusBoscos());
        sortida.put("especiesAOferir", convertirEspeciesJSON(afectacioService.getEspeciesAmbSequera()));
        sortida.put("especiesAOferirSequeraSoca", afectacioService.getEspeciesAmbSequeraSoca());
        sortida.put("especiesAOferirSequeraTipusBosc", afectacioService.getEspeciesAmbSequeraTipusBosc());
        Sequera sequera = (Sequera) command;
        sortida.put("regeneraciojson", convertirDadesRegeneracioJSON(((Sequera) command).getRegeneracionsEspeciesForestals()));
        sortida.put("estimacionsjson", convertirDadesEstimacionsJSON(((Sequera)command).getAfectacionsEstimades()));
        List<ArbreTransecteSequera> arbres = null;
        if (sequera.getArbresTransecte().size() > 0) {
            arbres = sequera.getArbresTransecte();
        } else {
            arbres = crear100ArbresTransecte();
        }
        sortida.put("arbrestransectejson", convertirArbresTransecteJSON(arbres));
        sortida.put("numFotos", sequera.getFotos().size());
        boolean editable = false;
        boolean esborrable = false;
        String nomUsuari = "";
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            nomUsuari = SecurityContextHolder.getContext().getAuthentication().getName();
        }
        Usuari usuari = afectacioService.getUsuariPerNom(nomUsuari);
        for(int i=0;i<usuari.getAuthorities().size();i++){
            editable = editable || "ROLE_EDITAR_SEQUERA".equals(usuari.getAuthorities().get(i).getAuthority());
            esborrable = esborrable || "ROLE_ESBORRAR_SEQUERA".equals(usuari.getAuthorities().get(i).getAuthority());
        }
        sortida.put("editable", editable);
        sortida.put("esborrable", esborrable);
        return sortida;
    }

    private List<ArbreTransecteSequera> crear100ArbresTransecte() {
        List<ArbreTransecteSequera> arbres = new ArrayList<ArbreTransecteSequera>();
        for (int i = 0; i < 100; i++) {
            arbres.add(new ArbreTransecteSequera());
        }
        return arbres;
    }

    private String getIP() {
        String ip = null;
        try {
            java.net.InetAddress i = java.net.InetAddress.getLocalHost();
            ip = i.getCanonicalHostName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ip;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        Map hm = new HashMap();
//        hm.put("idafectacio", request.getParameter("idafectacio"));
        hm.put("idafectacio", request.getParameter("idafectacio"));
        hm.put("ip", getIP());
        String primerElement = "0";
        if (request.getParameter("primerelement") != null) {
            primerElement = request.getParameter("primerelement");
        }
        hm.put("primerelement", primerElement);
        hm.put("numelements", request.getParameter("numelements"));
        Sequera afectacio = (Sequera) command;
        int numCauses = afectacioService.getCausesDecaimentCount();
        afectacio.getCausesDecaiment().clear();
        for (int i = 0; i < numCauses; i++) {
            String idCausa = request.getParameter("CAUSADECAIMENT_" + i);
            CausaDecaiment causa = afectacioService.getCausaDecaiment(idCausa);
            afectacio.getCausesDecaiment().add(causa);
        }
//        double xInici = Double.parseDouble(request.getParameter("coordenadaXIniciTransecte"));
//        double yInici = Double.parseDouble(request.getParameter("coordenadaYIniciTransecte"));
//        double xFi = Double.parseDouble(request.getParameter("coordenadaXFiTransecte"));
//        double yFi = Double.parseDouble(request.getParameter("coordenadaYFiTransecte"));
//        afectacio.setTransecte(convertirTransecte(xInici, yInici, xFi, yFi));
        String wktGeom = request.getParameter("wkt");
        if (wktGeom==null || wktGeom.equalsIgnoreCase("GEOMETRYCOLLECTION()")) {
            afectacio.setAreaAfectada(null);
        } else {
            afectacio.setAreaAfectada(getAreaDeWkt(wktGeom));
        }
        if("null".equals(afectacio.getOrientacio()))
            afectacio.setOrientacio(null);
        if("null".equals(afectacio.getPendent()))
            afectacio.setPendent(null);
        if("null".equals(afectacio.getPosicioPendent()))
            afectacio.setPosicioPendent(null);
        if("null".equals(afectacio.getDisposicioPendent()))
            afectacio.setDisposicioPendent(null);
        if(!"A".equals(afectacio.getNouOAntic())){
            afectacio.setArbresNousAfectats(null);
        }
        desarFotos(afectacio,request);
        afectacioService.desar(afectacio,request.getParameter("idsDadesEstimacions"),
                request.getParameter("idsDadesRegeneracio"),request.getParameter("idsDadesTransecte"));
        hm.put("idafectacio", afectacio.getIdString());
        String novaUrl = request.getParameter("novaurl");
        if("/sequeres/edicio/editar.htm".equals(novaUrl)){
            return new ModelAndView("redirect:"+novaUrl, hm);
        }
        return new ModelAndView("redirect:"+novaUrl, "dades", hm);
    }
    
    protected void desarFotos(Sequera sequera,HttpServletRequest request) throws Exception {
//        Map hm = new HashMap();
//        hm.put("id", request.getParameter("id"));
//        hm.put("idenp", request.getParameter("idenp"));
//        hm.put("idactuacio", request.getParameter("idactuacio"));
//        hm.put("ip", getIP());
//        String primerElement = "0";
//        if (request.getParameter("primerelement") != null) {
//            primerElement = request.getParameter("primerelement");
//        }
//        hm.put("primerelement", primerElement);
//        hm.put("numelements", request.getParameter("numelements"));
//        Actuacio actuacio = (Actuacio) command;
//        Usuari usuari = seguretatServei.getUsuariLogginat();
//        actuacionsService.comprovarPermisosEdicioActuacio(actuacio, usuari);
//        String idObjecte = request.getParameter("idfiguraProteccio");
//        enp.setFiguraProteccio(enpsService.getFiguraProteccio(idObjecte));
//        idObjecte = request.getParameter("idconjuntProtegit");
//        enp.setConjuntProtegit(enpsService.getConjuntProtegit(idObjecte));
//        idObjecte = request.getParameter("idzonaPeriferica");
//        enp.setZonaPeriferica(enpsService.getENP(idObjecte));
//        Document document = convertirFitxer(request);
        List<Foto> documents = new ArrayList<Foto>();
        Foto doc = convertirFitxer(request, "file1");
        if (doc != null) {
            documents.add(doc);
            doc.setAfectacio(sequera);
        }
        doc = convertirFitxer(request, "file2");
        if (doc != null) {
            documents.add(doc);
            doc.setAfectacio(sequera);
        }
        doc = convertirFitxer(request, "file3");
        if (doc != null) {
            documents.add(doc);
            doc.setAfectacio(sequera);
        }

        sequera.getFotos().addAll(documents);
//        esborrarDocuments(enp.getFotos(), request.getParameter("idsaesborrar"));
//        enp.getFotos().addAll(documents);
//        if(document!=null || "S".equals(request.getParameter("eliminarDocument")))
//            norma.setDocument(document);
        String novaUrl = request.getParameter("novaurl");
        if (novaUrl == null || "".equals(novaUrl.trim())) {
            novaUrl = "/sequeres/edicio/editar.htm";
        }
//        enpsService.desar(enp);
//        actuacionsService.desar(actuacio);
//        hm.put("resultat","0");
//        ResourceBundle bundle = ResourceBundle.getBundle("Literals.MSIPAN");
//        hm.put("exception", actuacio.toString() + "&nbsp;" + bundle.getString("xxxdesatCorrecte"));
//        return new ModelAndView("redirect:" + novaUrl, hm);
    }
    
    private void esborrarDocuments(List<Foto> documents, String idsAEsborrar) {
        StringTokenizer st = new StringTokenizer(idsAEsborrar, "&");
        List<String> ids = new ArrayList<String>();
        while (st.hasMoreElements()) {
            String id = st.nextToken();
//            ids.add(st.nextToken());
            for (int i = documents.size() - 1; i >= 0; i--) {
                if (id.equals(documents.get(i).getIdString())) {
                    documents.remove(i);
                }
            }
        }
    }

    private Foto convertirFitxer(HttpServletRequest request, String nomInput) throws IOException {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile filea = multipartRequest.getFile(nomInput);

        String nom = multipartRequest.getParameter("nom");

        Foto document = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        if (filea.getSize() > 0) {


            inputStream = filea.getInputStream();
//            File realUpload = new File("C:/");
            String nomAleatori = System.currentTimeMillis() + "";
            String nomOriginal = filea.getOriginalFilename();

            outputStream = new ByteArrayOutputStream();
            int readBytes = 0;
            byte[] buffer = new byte[8192];
            while ((readBytes = inputStream.read(buffer, 0, 8192)) != -1) {
                outputStream.write(buffer, 0, readBytes);
            }
            outputStream.close();
            inputStream.close();
            document = new Foto();
            document.setFitxerEnBytes(((ByteArrayOutputStream) outputStream).toByteArray());
            document.setNomOriginal(nomOriginal);
            document.setTitol(nomOriginal);
        }
        return document;
    }

    private Geometry convertirTransecte(double xInici, double yInici, double xFi, double yFi) {
        Coordinate[] coordinates = new Coordinate[2];
        PrecisionModel p = new PrecisionModel(PrecisionModel.FLOATING);
        GeometryFactory gf = new GeometryFactory(p, 23031);
        coordinates[0] = new Coordinate(xInici, yInici);
        coordinates[1] = new Coordinate(xFi, yFi);
        Geometry g_n = gf.createLineString(coordinates);
        g_n.setSRID(23031);
        return g_n;
    }

    private Geometry getAreaDeWkt(String wkt) throws ParseException {
        PrecisionModel p = new PrecisionModel(PrecisionModel.FLOATING);
        GeometryFactory gf = new GeometryFactory(p, 23031);
        WKTReader reader = new WKTReader(gf);
        GeometryCollection area = (GeometryCollection) reader.read(wkt);
        ArrayList llistaGeometries = new ArrayList();
        for (int i = 0; i < area.getNumGeometries(); i++) {
            Geometry g_n = area.getGeometryN(i);
            g_n.setSRID(23031);
            llistaGeometries.add(g_n);
        }
        return gf.buildGeometry(llistaGeometries);
    }

    private String convertirEspeciesJSON(List<Especie> elements) {
        JSONArray array = new JSONArray();
        JSONObject objecte;
        Especie especie;
        for (int i = 0; i < elements.size(); i++) {
            especie = (Especie) elements.get(i);
            objecte = new JSONObject();
            objecte.put("id", especie.getIdString());
            objecte.put("especie", especie.toString());
            objecte.put("value", especie.toString());
            objecte.put("label", especie.toString());
            array.put(objecte);
        }
        return array.toString();
    }

    private String convertirArbresTransecteJSON(List<ArbreTransecteSequera> elements) {
        JSONArray array = new JSONArray();
        JSONObject objecte;
        ArbreTransecteSequera ats;
        int ordre;
        for (int i = 0; i < elements.size(); i++) {
            ats = (ArbreTransecteSequera) elements.get(i);
            objecte = new JSONObject();
            String especie = "";
            if (ats.getEspecie() != null) {
                especie = ats.getEspecie().toString();
            }
//            objecte.put("posicio", (i + 1) + "");
            objecte.put("id", ats.getIdString());
            objecte.put("especie", especie);
            objecte.put("estrat", ats.getEstrat()==null ? "" : ats.getEstrat());
            objecte.put("classeDiametrica", ats.getClasseDiametrica()==null ? "" : ats.getClasseDiametrica());
            objecte.put("estat", ats.getEstatArbres()==null ? "" : ats.getEstatArbres());
            objecte.put("afectacio", ats.getAfectacioCapcada()==null ? "" : ats.getAfectacioCapcada());
            objecte.put("fullaVerda", ats.getPercentatgeFullaVerda()==null ? "" : ats.getPercentatgeFullaVerda());
            objecte.put("observacions", ats.getObservacions() == null ? "" : ats.getObservacions());
            if(ats.getOrdre()==-1)
                ordre = i+1;
            else
                ordre = ats.getOrdre();
            objecte.put("ordre",ordre);
            array.put(objecte); 
        }
        return array.toString();
    }

    

    private String convertirDadesRegeneracioJSON(List<RegeneracioEspecieForestal> elements) {
        JSONArray array = new JSONArray();
        JSONObject objecte;
        RegeneracioEspecieForestal reg;
        int ordre;
        for (int i = 0; i < elements.size(); i++) {
            reg = elements.get(i);
            objecte = new JSONObject();
            String especie = "";
            String idEspecie = "";
            if (reg.getEspecie() != null) {
                especie = reg.getEspecie().toString();
                idEspecie = reg.getEspecie().getIdString();
            }
            objecte.put("id", reg.getIdString());
            objecte.put("idespecie", idEspecie);
            objecte.put("especie", especie);
            String abundancia = "";
            if(RegeneracioEspecieForestal.ABUNDANCIA_BAIXA.equals(reg.getAbundancia()))
                abundancia = "Baixa";
            else if(RegeneracioEspecieForestal.ABUNDANCIA_ALTA.equals(reg.getAbundancia()))
                abundancia = "Alta";
            String individus = "";
            if(RegeneracioEspecieForestal.PERCENTATGE_BAIX.equals(reg.getPercentatgeMorts()))
                individus = "<50%";
            else if(RegeneracioEspecieForestal.PERCENTATGE_ALT.equals(reg.getPercentatgeMorts()))
                individus = ">50%";
            objecte.put("abundancia", abundancia);
            objecte.put("individus", individus);
            if(reg.getOrdre()==-1)
                ordre = i+1;
            else
                ordre = reg.getOrdre();
            objecte.put("ordre",ordre);
            array.put(objecte);
        }
        return array.toString();
    }

    

    

    private String convertirDadesEstimacionsJSON(List<AfectacioEstimada> elements) {
        JSONArray array = new JSONArray();
        JSONObject objecte;
        AfectacioEstimada ae;
        int ordre;
        for (int i = 0; i < elements.size(); i++) {
            ae = elements.get(i);
            objecte = new JSONObject();
            String especie = "";
            String idEspecie = "";
            if (ae.getEspecie() != null) {
                especie = ae.getEspecie().toString();
                idEspecie = ae.getEspecie().getIdString();
            }
            objecte.put("id", ae.getIdString());
            objecte.put("idespecie", idEspecie);
            objecte.put("especie", especie);
            objecte.put("recobriment", ae.getRecobriment());
            objecte.put("afectacio", ae.getAfectacio());
            objecte.put("arbre", ae.getArbre());
            
            objecte.put("arbresafectats",ae.getArbresAfectats());
            objecte.put("percmortalitat",ae.getPercMortalitat());
            objecte.put("percdefoliacio",ae.getPercDefoliacio());
            objecte.put("percdecoloracio",ae.getPercDecoloracio());
            objecte.put("canvimortalitat",ae.getCanviMortalitat());
            objecte.put("canvidefoliacio",ae.getCanviDefoliacio());
            objecte.put("canvidecoloracio",ae.getCanviDecoloracio());
            objecte.put("rebrots",ae.getRebrots());
            
            JSONArray arrayTipusAfectacio = new JSONArray();
            if(ae.getMortalitat())
                arrayTipusAfectacio.put("M");
            if(ae.getDefoliacio())
                arrayTipusAfectacio.put("DF");
            if(ae.getDecoloracio())
                arrayTipusAfectacio.put("DC");
            objecte.put("tipusAfectacio",arrayTipusAfectacio);
            if(ae.getOrdre()==-1)
                ordre = i+1;
            else
                ordre = ae.getOrdre();
            objecte.put("ordre",ordre);
            array.put(objecte);
        }
        return array.toString();
    }
}
