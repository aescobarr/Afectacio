/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.creaf.afectaciobosc.www.service;

import Dates.AritmeticaDates;
import Excepcions.SystemException;
import MSIPANBasicObj.ObjecteSIPAN;
import MSIPANGeneral.ObjecteSIPANAmbNom;
import MSIPANGeneral.SIPANService;
import cat.creaf.afectaciobosc.dao.AfectacioDAO;
import cat.creaf.afectaciobosc.model.*;
import cat.creaf.afectaciobosc.service.IAfectacioService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryCollection;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.PrecisionModel;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import java.util.NoSuchElementException;

/**
 *
 * @author v.garcia
 */
public class AfectacioService extends SIPANService implements IAfectacioService {

    private AfectacioDAO dao;

    public void setAfectacioDAO(AfectacioDAO dao) {
        this.setDAO(dao);
        this.dao = dao;
    }

    public Afectacio getAfectacio(String id) {
        return dao.getAfectacio(id);
    }

    public Processionaria getProcessionaria(String id) {
        Processionaria afectacio = (Processionaria)dao.getAfectacio(id);
        if(afectacio==null){
            afectacio = new Processionaria();
            afectacio.setEstat(ObjecteSIPAN.NOU);
        }
        return afectacio;
    }

    public Nevada getNevada(String id) {
        Nevada afectacio = (Nevada)dao.getAfectacio(id);
        if(afectacio==null){
            afectacio = new Nevada();
            afectacio.setEstat(ObjecteSIPAN.NOU);
        }
        return afectacio;
    }

    public Sequera getSequera(String id) {
        Sequera afectacio = (Sequera)dao.getAfectacio(id);
        if(afectacio==null){
            afectacio = new Sequera();
            afectacio.setEstat(ObjecteSIPAN.NOU);
        }
        return afectacio;
    }

//    public DanyMecanic getDanyMecanic(String id) {
//        DanyMecanic afectacio = (DanyMecanic)dao.getAfectacio(id);
//        if(afectacio==null){
//            afectacio = new DanyMecanic();
//            afectacio.setEstat(ObjecteSIPAN.NOU);
//        }
//        return afectacio;
//    }

    public DanyAbiotic createDanyAbiotic() {
        DanyAbiotic afectacio = new DanyAbiotic();
        afectacio.setEstat(ObjecteSIPAN.NOU);
        return afectacio;
    }

    public DanyAbiotic getDanyAbiotic(String id) {
        DanyAbiotic afectacio = (DanyAbiotic)dao.getAfectacio(id);
//        if(afectacio==null){
//            afectacio = new DanyAbiotic();
//            afectacio.setEstat(ObjecteSIPAN.NOU);
//        }
        return afectacio;
    }

    public CausaDecaiment getCausaDecaiment(String id){
        return dao.getCausaDecaiment(id);
    }

    public int getCausesDecaimentCount() {
        return dao.getCausesDecaimentCount();
    }

    public CausaDecaimentDanyAbiotic getCausaDecaimentDanyAbiotic(String id){
        return dao.getCausaDecaimentDanyAbiotic(id);
    }

    public int getCausesDecaimentDanyAbioticCount() {
        return dao.getCausesDecaimentDanyAbioticCount();
    }

    public int getProcessionariesCount() {
        return dao.getProcessionariesCount();
    }

    public List<Processionaria> getProcessionaries(String ordenacio, String direccioOrdenacio, int numPrimerRegistre, int maxNombreRegistres) {
        return dao.getProcessionaries(ordenacio,direccioOrdenacio,numPrimerRegistre,maxNombreRegistres);
    }

    public List<Processionaria> getProcessionaries() {
        return dao.getProcessionaries();
    }

    public int getNevadesCount() {
        return dao.getNevadesCount();
    }

    public List<Nevada> getNevades(String ordenacio, String direccioOrdenacio, int numPrimerRegistre, int maxNombreRegistres) {
        return dao.getNevades(ordenacio,direccioOrdenacio,numPrimerRegistre,maxNombreRegistres);
    }

    public List<Nevada> getNevades() {
        return dao.getNevades();
    }

    public int getSequeresCount() {
        return dao.getSequeresCount();
    }

    public List<Sequera> getSequeres(String ordenacio, String direccioOrdenacio, int numPrimerRegistre, int maxNombreRegistres) {
        return dao.getSequeres(ordenacio,direccioOrdenacio,numPrimerRegistre,maxNombreRegistres);
    }

    public List<Sequera> getSequeres() {
        return dao.getSequeres();
    }

//    public int getDanysMecanicsCount(){
//        return dao.getDanysMecanicsCount();
//    }
//
//    public List<Sequera> getDanysMecanics(String ordenacio, String direccioOrdenacio, int numPrimerRegistre, int maxNombreRegistres){
//        return dao.getDanysMecanics(ordenacio, direccioOrdenacio, numPrimerRegistre, maxNombreRegistres);
//    }
//
//    public List<Sequera> getDanysMecanics(){
//        return dao.getDanysMecanics();
//    }

    public int getDanysAbioticsCount(){
        return dao.getDanysAbioticsCount();
    }

    public List<DanyAbiotic> getDanysAbiotics(String ordenacio, String direccioOrdenacio, int numPrimerRegistre, int maxNombreRegistres){
        return dao.getDanysAbiotics(ordenacio, direccioOrdenacio, numPrimerRegistre, maxNombreRegistres);
    }

    public List<DanyAbiotic> getDanysAbiotics(){
        return dao.getDanysAbiotics();
    }

    public List<Especie> getEspecies() {
        return dao.getEspecies();
    }

    public List<Especie> getEspeciesAmbProcessionaria(){
        return dao.getEspeciesAmbProcessionaria();
    }

    public List<Especie> getEspeciesAmbSequera(){
        return dao.getEspeciesAmbSequera();
    }

    public List<Especie> getEspeciesAmbSequeraSoca(){
        return dao.getEspeciesAmbSequeraSoca();
    }

    public List<Especie> getEspeciesAmbSequeraTipusBosc(){
        return dao.getEspeciesAmbSequeraTipusBosc();
    }

    public List<Especie> getEspecies(String partNom) {
        return dao.getEspecies(partNom);
    }

    public List<GrauInfestacio> getGrausInfestacioProcessionaria() {
        return dao.getGrausInfestacioProcessionaria();
    }

    public List<GrauInfestacio> getGrausInfestacioDanyMecanic() {
        return dao.getGrausInfestacioDanyMecanic();
    }

    public List<TipusBosc> getTipusBoscos() {
        return dao.getTipusBoscos();
    }

    public List<Orientacio> getOrientacions(){
        return dao.getOrientacions();
    }

    public List<DistribucioArbresAfectats> getDistribucionsArbresAfectats(){
        return dao.getDistribucionsArbresAfectats();
    }

    public List<CausaDecaiment> getCausesDecaimentSequera(){
        return dao.getCausesDecaimentSequera();
    }

    public List<CausaDecaiment> getCausesDecaimentDanyMecanic(){
        return dao.getCausesDecaimentDanyMecanic();
    }

    public List<CausaDecaimentDanyAbiotic> getCausesDecaimentDanyAbiotic(){
        return dao.getCausesDecaimentDanyAbiotic();
    }
    
    public Foto getFoto(String id) {
        return dao.getFoto(id);
    }
    
    public void esborrar(Foto foto) throws Exception {
        try {
            this.dao.delete(foto);
        } catch (SystemException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    public void desar(Nevada afectacio) {
        try {
        dao.save(afectacio);
        } catch (SystemException ex) {
            ex.printStackTrace();
        }
    }

    public void desar(Afectacio afectacio) {
        try {
//            if (ObjecteSIPAN.NOU == afectacio.getEstat() || ObjecteSIPAN.NO_MODIFICAT == afectacio.getEstat()) {
//                try {
//                    if(afectacio.getAreaAfectada() != null)
//                        afectacio.getAreaAfectada().setSRID(23031);
//                    desarNou(afectacio);
//                } catch (Exception ex) {
//                    Logger.getLogger(AfectacioService.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }else{
                dao.save(afectacio);
//            }
        } catch (SystemException ex) {
//            ex.printStackTrace();
            Logger.getLogger(AfectacioService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public void esborrar(Afectacio afectacio) {
        try {
            dao.delete(afectacio);
        } catch (SystemException ex) {
            Logger.getLogger(AfectacioService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<ObjecteSIPANAmbNom> getTipusOrientacions(){
        List<ObjecteSIPANAmbNom> orientacions = new ArrayList<ObjecteSIPANAmbNom>();
        ObjecteSIPANAmbNom obj = new ObjecteSIPANAmbNom("N");
        obj.setNom("N");
        orientacions.add(obj);
        obj = new ObjecteSIPANAmbNom("NE");
        obj.setNom("NE");
        orientacions.add(obj);
        obj = new ObjecteSIPANAmbNom("E");
        obj.setNom("E");
        orientacions.add(obj);
        obj = new ObjecteSIPANAmbNom("SE");
        obj.setNom("SE");
        orientacions.add(obj);
        obj = new ObjecteSIPANAmbNom("S");
        obj.setNom("S");
        orientacions.add(obj);
        obj = new ObjecteSIPANAmbNom("SO");
        obj.setNom("SO");
        orientacions.add(obj);
        obj = new ObjecteSIPANAmbNom("O");
        obj.setNom("O");
        orientacions.add(obj);
        obj = new ObjecteSIPANAmbNom("NO");
        obj.setNom("NO");
        orientacions.add(obj);
        return orientacions;
    }

    public List<ObjecteSIPANAmbNom> getPendents(){
        List<ObjecteSIPANAmbNom> orientacions = new ArrayList<ObjecteSIPANAmbNom>();
        ObjecteSIPANAmbNom obj = new ObjecteSIPANAmbNom("<10");
        obj.setNom("<10");
        orientacions.add(obj);
        obj = new ObjecteSIPANAmbNom("10-30");
        obj.setNom("10-30");
        orientacions.add(obj);
        obj = new ObjecteSIPANAmbNom("30-60");
        obj.setNom("30-60");
        orientacions.add(obj);
        obj = new ObjecteSIPANAmbNom("60-100");
        obj.setNom("60-100");
        orientacions.add(obj);
        obj = new ObjecteSIPANAmbNom(">100");
        obj.setNom(">100");
        orientacions.add(obj);
        return orientacions;
    }

    public List<ObjecteSIPANAmbNom> getPosicionsPendent(){
        List<ObjecteSIPANAmbNom> orientacions = new ArrayList<ObjecteSIPANAmbNom>();
        ObjecteSIPANAmbNom obj = new ObjecteSIPANAmbNom("cresta");
        obj.setNom("cresta");
        orientacions.add(obj);
        obj = new ObjecteSIPANAmbNom("part superior");
        obj.setNom("part superior");
        orientacions.add(obj);
        obj = new ObjecteSIPANAmbNom("mig vessant");
        obj.setNom("mig vessant");
        orientacions.add(obj);
        obj = new ObjecteSIPANAmbNom("part inferior");
        obj.setNom("part inferior");
        orientacions.add(obj);
        obj = new ObjecteSIPANAmbNom("falda");
        obj.setNom("falda");
        orientacions.add(obj);
        return orientacions;
    }

    public List<ObjecteSIPANAmbNom> getDisposicionsPendent(){
        List<ObjecteSIPANAmbNom> orientacions = new ArrayList<ObjecteSIPANAmbNom>();
        ObjecteSIPANAmbNom obj = new ObjecteSIPANAmbNom("convexa");
        obj.setNom("convexa");
        orientacions.add(obj);
        obj = new ObjecteSIPANAmbNom("plana");
        obj.setNom("plana");
        orientacions.add(obj);
        obj = new ObjecteSIPANAmbNom("concava");
        obj.setNom("còncava");
        orientacions.add(obj);
        obj = new ObjecteSIPANAmbNom("terrases");
        obj.setNom("terrasses");
        orientacions.add(obj);
        obj = new ObjecteSIPANAmbNom("irregular");
        obj.setNom("irregular");
        orientacions.add(obj);
        return orientacions;
    }

//    public void desar(DanyMecanic dany,String jsonEstimacions) {
//        convertirDadesEstimacionsJSON(jsonEstimacions, dany);
//        dany.calcularGrauAfectacio();
//        desar(dany);
//    }

    public void desar(DanyAbiotic dany,String jsonEstimacions) {
//        convertirDadesEstimacionsJSON(jsonEstimacions, dany);
//        dany.calcularGrauAfectacio();
        desar(dany);
    }
    
     public void desar(Sequera sequera,String jsonEstimacions,String jsonRegeneracio,
             String jsonTransecte) {
        convertirDadesEstimacionsJSON(jsonEstimacions, sequera);
        convertirDadesRegeneracioJSON(jsonRegeneracio, sequera);
        convertirDadesTransecteJSON(jsonTransecte, sequera);
        desar(sequera);
    }

//     private void convertirDadesEstimacionsJSON(String json, DanyMecanic afectacio) {
//        Especie especie;
//        AfectacioEstimadaDanyMecanic dada;
//        List<AfectacioEstimadaDanyMecanic> dades = afectacio.getAfectacionsEstimades();
//        dades.clear();
//        if (json == null || json.trim().length() == 0) {
//            return;
//        }
//        try {
//            JSONObject jsonObject = new JSONObject(json);
//            JSONArray array = jsonObject.getJSONArray("_records");
//            for (int i = 0; i < array.length(); i++) {
//                jsonObject = array.getJSONObject(i).getJSONObject("_oData");
//                String id = jsonObject.getString("id");
//                dada = new AfectacioEstimadaDanyMecanic();
////                dada.setIdString(id);
//                dada.setDanyMecanic(afectacio);
//                especie = getEspecies(jsonObject.getString("especie")).get(0);
//                dada.setEspecie(especie);
//                String valor = jsonObject.getString("recobriment");
//                if (valor != null && valor.length() > 0) {
//                    dada.setRecobriment(valor);
//                } else {
//                    dada.setRecobriment(null);
//                }
//                valor = jsonObject.getString("afectacio");
//                if (valor != null && valor.length() > 0) {
//                    dada.setAfectacio(valor);
//                } else {
//                    dada.setAfectacio(null);
//                }
//                valor = jsonObject.getString("alcada");
//                if (valor != null && valor.length() > 0) {
//                    if("Alts".equals(valor))
//                        dada.setAlcada(AfectacioEstimadaDanyMecanic.ALCADA_ALTS);
//                    else if("Baixos".equals(valor))
//                        dada.setAlcada(AfectacioEstimadaDanyMecanic.ALCADA_BAIXOS);
//                    else
//                        dada.setAlcada(AfectacioEstimadaDanyMecanic.ALCADA_TOTS);
//                } else {
//                    dada.setAlcada(AfectacioEstimadaDanyMecanic.ALCADA_TOTS);
//                }
//                dada.setOrdre(jsonObject.getInt("ordre"));
//                dades.add(dada);
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(AfectacioService.class.getName()).log(Level.SEVERE, null, ex);
//        }
////        return dades;
//    }

//     private void convertirDadesEstimacionsJSON(String json, DanyAbiotic afectacio) {
//        Especie especie;
//        AfectacioEstimadaDanyMecanic dada;
//        List<AfectacioEstimadaDanyMecanic> dades = afectacio.getAfectacionsEstimades();
//        dades.clear();
//        if (json == null || json.trim().length() == 0) {
//            return;
//        }
//        try {
//            JSONObject jsonObject = new JSONObject(json);
//            JSONArray array = jsonObject.getJSONArray("_records");
//            for (int i = 0; i < array.length(); i++) {
//                jsonObject = array.getJSONObject(i).getJSONObject("_oData");
//                String id = jsonObject.getString("id");
//                dada = new AfectacioEstimadaDanyMecanic();
////                dada.setIdString(id);
////                dada.setDanyMecanic(afectacio);
//                especie = getEspecies(jsonObject.getString("especie")).get(0);
//                dada.setEspecie(especie);
//                String valor = jsonObject.getString("recobriment");
//                if (valor != null && valor.length() > 0) {
//                    dada.setRecobriment(valor);
//                } else {
//                    dada.setRecobriment(null);
//                }
//                valor = jsonObject.getString("afectacio");
//                if (valor != null && valor.length() > 0) {
//                    dada.setAfectacio(valor);
//                } else {
//                    dada.setAfectacio(null);
//                }
//                valor = jsonObject.getString("alcada");
//                if (valor != null && valor.length() > 0) {
//                    if("Alts".equals(valor))
//                        dada.setAlcada(AfectacioEstimadaDanyMecanic.ALCADA_ALTS);
//                    else if("Baixos".equals(valor))
//                        dada.setAlcada(AfectacioEstimadaDanyMecanic.ALCADA_BAIXOS);
//                    else
//                        dada.setAlcada(AfectacioEstimadaDanyMecanic.ALCADA_TOTS);
//                } else {
//                    dada.setAlcada(AfectacioEstimadaDanyMecanic.ALCADA_TOTS);
//                }
//                dada.setOrdre(jsonObject.getInt("ordre"));
//                dades.add(dada);
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(AfectacioService.class.getName()).log(Level.SEVERE, null, ex);
//        }
////        return dades;
//    }

    private void convertirDadesEstimacionsJSON(String json, Sequera afectacio) {
        Especie especie;
        AfectacioEstimada dada;
        List<AfectacioEstimada> dades = afectacio.getAfectacionsEstimades();
        dades.clear();
        if (json == null || json.trim().length() == 0) {
            return;
        }
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray array = jsonObject.getJSONArray("_records");
            for (int i = 0; i < array.length(); i++) {
                jsonObject = array.getJSONObject(i).getJSONObject("_oData");
                String id = jsonObject.getString("id");
                dada = new AfectacioEstimada();
//                dada.setIdString(id);
                dada.setSequera(afectacio);
                especie = getEspecies(jsonObject.getString("especie")).get(0);
                dada.setEspecie(especie);
                String valor = jsonObject.getString("recobriment");
                if (valor != null && valor.length() > 0) {
                    dada.setRecobriment(valor);
                } else {
                    dada.setRecobriment(null);
                }
                valor = jsonObject.getString("afectacio");
                if (valor != null && valor.length() > 0) {
                    dada.setAfectacio(valor);
                } else {
                    dada.setAfectacio(null);
                }
                valor = jsonObject.getString("arbresafectats");
                if (valor != null && valor.length() > 0) {
                    dada.setArbresAfectats(valor);
                } else {
                    dada.setArbresAfectats(null);
                }
                if(jsonObject.has("percmortalitat")){
                    valor = jsonObject.getString("percmortalitat");
                    if (valor != null && !valor.equalsIgnoreCase("null") && valor.length() > 0) {
                        dada.setPercMortalitat(valor);
                    } else {
                        dada.setPercMortalitat(null);
                    }
                }
                if(jsonObject.has("rebrots")){
                    valor = jsonObject.getString("rebrots");
                    if (valor != null && !valor.equalsIgnoreCase("null") && valor.length() > 0) {
                        dada.setRebrots(valor);
                    } else {
                        dada.setRebrots(null);
                    }
                }
                if(jsonObject.has("percdefoliacio")){
                    valor = jsonObject.getString("percdefoliacio");
                    if (valor != null && !valor.equalsIgnoreCase("null") && valor.length() > 0) {
                        dada.setPercDefoliacio(valor);
                    } else {
                        dada.setPercDefoliacio(null);
                    }
                }
                if(jsonObject.has("percdecoloracio")){
                    valor = jsonObject.getString("percdecoloracio");
                    if (valor != null && !valor.equalsIgnoreCase("null") && valor.length() > 0) {
                        dada.setPercDecoloracio(valor);
                    } else {
                        dada.setPercDecoloracio(null);
                    }
                }
                if(jsonObject.has("canvimortalitat")){
                    valor = jsonObject.getString("canvimortalitat");
                    if (valor != null && !valor.equalsIgnoreCase("null") && valor.length() > 0) {
                        dada.setCanviMortalitat(valor);
                    } else {
                        dada.setCanviMortalitat(null);
                    }
                }
                if(jsonObject.has("canvidefoliacio")){
                    valor = jsonObject.getString("canvidefoliacio");
                    if (valor != null && !valor.equalsIgnoreCase("null") && valor.length() > 0) {
                        dada.setCanviDefoliacio(valor);
                    } else {
                        dada.setCanviDefoliacio(null);
                    }
                }
                if(jsonObject.has("canvidecoloracio")){
                    valor = jsonObject.getString("canvidecoloracio");
                    if (valor != null && !valor.equalsIgnoreCase("null") && valor.length() > 0) {
                        dada.setCanviDecoloracio(valor);
                    } else {
                        dada.setCanviDecoloracio(null);
                    }
                }
                valor = jsonObject.getString("arbre");
                if (valor != null && valor.length() > 0) {
                    dada.setArbre(valor);
                } else {
                    dada.setArbre(null);
                }                
                try{
                    valor = jsonObject.getString("tipusAfectacio");
                }catch(NoSuchElementException ex){
                    valor = null;
                }
                if (valor != null && valor.length() > 0) {
                    dada.setMortalitat(valor.contains("M"));
                    dada.setDecoloracio(valor.contains("DC"));
                    dada.setDefoliacio(valor.contains("DF"));
                } else {
                    dada.setMortalitat(false);
                    dada.setDecoloracio(false);
                    dada.setDefoliacio(false);
                }
                dada.setOrdre(jsonObject.getInt("ordre"));
                dades.add(dada);
            }
        } catch (Exception ex) {
            Logger.getLogger(AfectacioService.class.getName()).log(Level.SEVERE, null, ex);
        }
//        return dades;
    }
    
    private void convertirDadesRegeneracioJSON(String json, Sequera afectacio) {
        Especie especie;
        RegeneracioEspecieForestal dada;
        List<RegeneracioEspecieForestal> dades = afectacio.getRegeneracionsEspeciesForestals();//new ArrayList<RegeneracioEspecieForestal>();
        dades.clear();
        if (json == null || json.trim().length() == 0) {
            return ;
        }
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray array = jsonObject.getJSONArray("_records");
            for (int i = 0; i < array.length(); i++) {
                jsonObject = array.getJSONObject(i).getJSONObject("_oData");
                String id = jsonObject.getString("id");
                dada = new RegeneracioEspecieForestal();
//                dada.setIdString(id);
                dada.setSequera(afectacio);
                especie = getEspecies(jsonObject.getString("especie")).get(0);
                dada.setEspecie(especie);
                String valor = jsonObject.getString("abundancia");
                if ("Baixa".equals(valor)) {
                    dada.setAbundancia(RegeneracioEspecieForestal.ABUNDANCIA_BAIXA);
                } else if ("Alta".equals(valor)) {
                    dada.setAbundancia(RegeneracioEspecieForestal.ABUNDANCIA_ALTA);
                }
                valor = jsonObject.getString("individus");
                if ("<50%".equals(valor)) {
                    dada.setPercentatgeMorts(RegeneracioEspecieForestal.PERCENTATGE_BAIX);
                } else if (">50%".equals(valor)) {
                    dada.setPercentatgeMorts(RegeneracioEspecieForestal.PERCENTATGE_ALT);
                }
                dada.setOrdre(jsonObject.getInt("ordre"));
                dades.add(dada);
            }
        } catch (Exception ex) {
            Logger.getLogger(AfectacioService.class.getName()).log(Level.SEVERE, null, ex);
        }
//        return dades;
    }

    private void convertirDadesTransecteJSON(String json, Sequera afectacio) {
        Especie especie;
        ArbreTransecteSequera dada;
        List<ArbreTransecteSequera> dades = afectacio.getArbresTransecte();//new ArrayList<ArbreTransecteSequera>();
        dades.clear();
        if (json == null || json.trim().length() == 0) {
            return;
        }
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray array = jsonObject.getJSONArray("_records");
            List<Especie> especies = null;
            for (int i = 0; i < array.length(); i++) {
                jsonObject = array.getJSONObject(i).getJSONObject("_oData");
                String id = jsonObject.getString("id");
                dada = new ArbreTransecteSequera();
//                dada.setIdString(id);
                dada.setSequera(afectacio);
                especie = null;
                try {
                    String textEspecie = jsonObject.getString("especie");
                    if(textEspecie!=null && textEspecie.trim().length()>0){
                        especies = getEspecies(textEspecie);
                        if (especies != null && especies.size() > 0) {
                            especie = especies.get(0);
                        }
                    }
                } catch (java.util.NoSuchElementException ex) {
                    Logger.getLogger(AfectacioService.class.getName()).log(Level.WARNING, null, ex);
                }
                dada.setEspecie(especie);
                String valor = null;
                try {
                    valor = jsonObject.getString("estrat");
                    if (valor != null && valor.length() > 0 && !"null".equals(valor)) {
                        dada.setEstrat(valor);
                    } else {
                        dada.setEstrat(null);
                    }
                } catch (java.util.NoSuchElementException ex) {
                    Logger.getLogger(AfectacioService.class.getName()).log(Level.WARNING, null, ex);
                }
                try {
                    valor = jsonObject.getString("classeDiametrica");
                    if (valor != null && valor.length() > 0 && !"null".equals(valor)) {
                        dada.setClasseDiametrica(valor);
                    } else {
                        dada.setClasseDiametrica(null);
                    }
                } catch (java.util.NoSuchElementException ex) {
                    Logger.getLogger(AfectacioService.class.getName()).log(Level.WARNING, null, ex);
                }
                try {
                    valor = jsonObject.getString("estat");
                    if (valor != null && valor.length() > 0 && !"null".equals(valor)) {
                        dada.setEstatArbres(valor);
                    } else {
                        dada.setEstatArbres(null);
                    }
                } catch (java.util.NoSuchElementException ex) {
                    Logger.getLogger(AfectacioService.class.getName()).log(Level.WARNING, null, ex);
                }
                try {
                    valor = jsonObject.getString("afectacio");
                    if (valor != null && valor.length() > 0 && !"null".equals(valor)) {
                        dada.setAfectacioCapcada(valor);
                    } else {
                        dada.setAfectacioCapcada(null);
                    }
                } catch (java.util.NoSuchElementException ex) {
                    Logger.getLogger(AfectacioService.class.getName()).log(Level.WARNING, null, ex);
                }
                try {
                    valor = jsonObject.getString("fullaVerda");
                    if (valor != null && valor.length() > 0 && !"null".equals(valor)) {
                        dada.setPercentatgeFullaVerda(valor);
                    } else {
                        dada.setPercentatgeFullaVerda(null);
                    }
                } catch (java.util.NoSuchElementException ex) {
                    Logger.getLogger(AfectacioService.class.getName()).log(Level.WARNING, null, ex);
                }
                try {
                    valor = jsonObject.getString("observacions");
                    if (valor != null && valor.length() > 0 && !"null".equals(valor)) {
                        dada.setObservacions(valor);
                    } else {
                        dada.setObservacions(null);
                    }
                } catch (java.util.NoSuchElementException ex) {
                    Logger.getLogger(AfectacioService.class.getName()).log(Level.WARNING, null, ex);
                }
                dada.setOrdre(jsonObject.getInt("ordre"));
                dades.add(dada);
            }
        } catch (Exception ex) {
            Logger.getLogger(AfectacioService.class.getName()).log(Level.SEVERE, null, ex);
        }
//        return dades;
    }

    public void desarDanyAbiotic(DanyAbiotic afectacio,Map<String,String> parametres) throws Exception{
        try{
            String valor = parametres.get("codi");
            afectacio.setCodi(valor);
            valor = parametres.get("utmXPuntAfectat");
            if(valor!=null && !"".equals(valor.trim()))
                afectacio.setUtmX(Double.valueOf(valor));
            else
                afectacio.setUtmX(null);
            valor = parametres.get("utmYPuntAfectat");
            if(valor!=null && !"".equals(valor.trim()))
                afectacio.setUtmY(Double.valueOf(valor));
            else
                afectacio.setUtmY(null);
            Date data = null;
            valor = parametres.get("dataApreciacioInicial");
            if(valor!=null && !"".equals(valor.trim()))
                data = AritmeticaDates.transformar(valor);
            else
                data = null;
            afectacio.setDataApreciacioInicial(data);
            valor = parametres.get("dataDadesDefinitives");
            if(valor!=null && !"".equals(valor.trim()))
                data = AritmeticaDates.transformar(valor);
            else
                data = null;
            afectacio.setDataDadesDefinitives(data);
            valor = parametres.get("dataValidacio");
            if(valor!=null && !"".equals(valor.trim()))
                data = AritmeticaDates.transformar(valor);
            else
                data = null;
            afectacio.setDataValidacio(data);
            valor = parametres.get("nomEnginyer1");
            afectacio.setNomEnginyer1(valor);
            valor = parametres.get("nomEnginyer2");
            afectacio.setNomEnginyer2(valor);
            valor = parametres.get("codiAgent1");
            afectacio.setCodiAgent1(valor);
            valor = parametres.get("codiAgent2");
            afectacio.setCodiAgent2(valor);
            valor = parametres.get("excepcionalitatMeteorologica");
            afectacio.setExcepcionalitatMeteorologica(valor);
            valor = parametres.get("idmostreigSistematic");
            afectacio.setEsMostreigSistematicString(valor);
            valor = parametres.get("observacionsMostreigSistematic");
            afectacio.setObservacionsMostreigSistematic(valor);
            valor = parametres.get("percentatgeAmbTreballsGestioAparent");
            if(valor!=null && !"".equals(valor.trim()))
                afectacio.setPercentatgeAmbTreballsGestioAparent(Double.valueOf(valor));
            else
                afectacio.setPercentatgeAmbTreballsGestioAparent(null);
            valor = parametres.get("percentatgeSenseTreballsGestioAparent");
            if(valor!=null && !"".equals(valor.trim()))
                afectacio.setPercentatgeSenseTreballsGestioAparent(Double.valueOf(valor));
            else
                afectacio.setPercentatgeSenseTreballsGestioAparent(null);
            valor = parametres.get("percentatgeBoscRegeneracioNatural");
            if(valor!=null && !"".equals(valor.trim()))
                afectacio.setPercentatgeBoscRegeneracioNatural(Double.valueOf(valor));
            else
                afectacio.setPercentatgeBoscRegeneracioNatural(null);
            valor = parametres.get("percentatgeRepoblacioArtificial");
            if(valor!=null && !"".equals(valor.trim()))
                afectacio.setPercentatgeRepoblacioArtificial(Double.valueOf(valor));
            else
                afectacio.setPercentatgeRepoblacioArtificial(null);
            valor = parametres.get("percentatgePlantacioEspeciesCreixementRapid");
            if(valor!=null && !"".equals(valor.trim()))
                afectacio.setPercentatgePlantacioEspeciesCreixementRapid(Double.valueOf(valor));
            else
                afectacio.setPercentatgePlantacioEspeciesCreixementRapid(null);
            valor = parametres.get("dataEpisodi");
            if(valor!=null && !"".equals(valor.trim()))
                data = AritmeticaDates.transformar(valor);
            else
                data = null;
            afectacio.setData(data);

            //Taula Afectació General
            valor = parametres.get("idsDadesEstimacions");
            converirDadesEstimacionsJSON(valor, afectacio);

            valor = parametres.get("grauAfectacio");
            if(valor!=null && !"".equals(valor.trim()))
                afectacio.setGrauAfectacioXarxaViaria(Double.valueOf(valor));
            else
                afectacio.setGrauAfectacioXarxaViaria(null);


            //Checkboxes de causes decaiment
            int numCauses = getCausesDecaimentDanyAbioticCount();
            afectacio.getCausesDecaiment().clear();
            for (int i = 0; i < numCauses; i++) {
                String idCausa = parametres.get("CAUSADECAIMENTDANYABIOTIC_" + i);
                CausaDecaimentDanyAbiotic causa = getCausaDecaimentDanyAbiotic(idCausa);
                if(causa!=null)
                    afectacio.getCausesDecaiment().add(causa);
            }

            valor = parametres.get("observacions");
            afectacio.setObservacions(valor);

            String wktGeom = parametres.get("wkt");
            if (wktGeom.equalsIgnoreCase("GEOMETRYCOLLECTION()")) {
                afectacio.setAreaAfectada(null);
            } else {
                afectacio.setAreaAfectada(getAreaDeWkt(wktGeom));
            }

//            try{
//                if(informe.getOrganitzacio() == null){
//                    String idOrganitzacio = parametres.get("idorganitzacio");
//                    Organitzacio org = dao.getOrganitzacio(idOrganitzacio);
//                    informe.setOrganitzacio(org);
//                }
//                Informe aux = dao.getInformePerNumeroInforme(Integer.parseInt(valor),informe.getOrganitzacio().getIdString());
//                if(aux!=null && !informe.getIdString().equals(aux.getIdString())){
//                    throw new NumeroInformeIncorrecteException();
//                }
//            }catch(NumberFormatException ex){
//                throw new NumeroInformeIncorrecteException();
//            }
//            valor = parametres.get("titol");
//            informe.setTitol(valor);
//            valor = parametres.get("dataCaducitat");
//            informe.setDataCaducitatInforme(AritmeticaDates.transformar(valor));
//            valor = parametres.get("numeroRegistreEntrada");
//            try{
//                informe.setNumeroRegistreEntrada(Integer.parseInt(valor));
//            }catch(NumberFormatException ex){
//                informe.setNumeroRegistreEntradaInteger(null);
//            }
//            valor = parametres.get("dataEntradaInforme");
//            informe.setDataEntradaInforme(AritmeticaDates.transformar(valor));
//            valor = parametres.get("idviaEntrada");
//            TipusViaEntrada tipusViaEntrada = this.getTipusViaEntrada(valor);
//            informe.setViaEntrada(tipusViaEntrada);
//            valor = parametres.get("anyselect");
//            int anno = 0;
//            try{
//                anno = Integer.parseInt(valor);
//            }catch(NumberFormatException ex){
//
//            }
//            informe.setAnno(anno);
//            valor = parametres.get("idorganitzacio");
//            Organitzacio organitzacio = this.getOrganitzacio(valor);
//            informe.setOrganitzacio(organitzacio);
//            valor = parametres.get("idtipusInforme");
//            TipusInforme tipusInforme = this.getTipusInforme(valor);
//            informe.setTipusInforme(tipusInforme);
//            valor = parametres.get("numeroInforme");
//            try{
//                informe.setNumeroInforme(Integer.parseInt(valor));
//            }catch(NumberFormatException ex){
//                informe.setNumeroInformeInteger(null);
//            }
//            valor = parametres.get("idareaGestio");
//            AreaOrganitzacio areaGestio = this.getAreaOrganitzacio(valor);
//            informe.setAreaGestio(areaGestio);
//            valor = parametres.get("idtecnic");
//            Tecnic tecnic = this.getTecnic(valor);
//            informe.setTecnic(tecnic);
            dao.save(afectacio);
        } catch (Exception ex) {
            Logger.getLogger(AfectacioService.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    private void converirDadesEstimacionsJSON(String json, DanyAbiotic afectacio) {
        AfectacioEstimadaDanyAbiotic dada;
        List<AfectacioEstimadaDanyAbiotic> dades = afectacio.getAfectacionsEstimades();
        dades.clear();
        if(json==null || json.trim().length()==0)
            return;
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray array = jsonObject.getJSONArray("_records");
            Especie especie;
            String especieText,recobriment,afectacioText,estrat;
            for (int i = 0; i < array.length(); i++) {
                dada = new AfectacioEstimadaDanyAbiotic();
                dada.setDanyAbiotic(afectacio);
                jsonObject = array.getJSONObject(i).getJSONObject("_oData");
                especieText=jsonObject.getString("especie");
//                especieText=jsonObject.getString("recobriment");
//                especieText=jsonObject.getString("afectacio");
//                especieText=jsonObject.getString("estrat");
//                dada = new AfectacioEstimadaDanyAbiotic();
//                dada = zoologiaService.getPersona(id);
//                dades.add(dada);
                especie = getEspecies(especieText).get(0);
                dada.setEspecie(especie);
                String valor = jsonObject.getString("recobriment");
                if (valor != null && valor.length() > 0) {
                    dada.setRecobriment(valor);
                } else {
                    dada.setRecobriment(null);
                }
                valor = jsonObject.getString("afectacio");
                if (valor != null && valor.length() > 0) {
                    dada.setAfectacio(valor);
                } else {
                    dada.setAfectacio(null);
                }
                valor = jsonObject.getString("estrat");
                if (valor != null && valor.length() > 0) {
                    dada.setEstrat(valor);
                } else {
                    dada.setEstrat(null);
                }
                dada.setOrdre(jsonObject.getInt("ordre"));
                dades.add(dada);
            }
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
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

    
    public List<Comarca> getComarquesAfectacioBosc() {
        return this.dao.getComarquesAfectacioBosc();
    }

    public List<Municipi> getMunicipisAfectacioBosc() {
        return this.dao.getMunicipisAfectacioBosc();
    }
}
