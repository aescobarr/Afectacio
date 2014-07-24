/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cat.creaf.afectaciobosc.service;

import MSIPANGeneral.ObjecteSIPANAmbNom;
import MSeguretatObj.Usuari;
import cat.creaf.afectaciobosc.dao.AfectacioDAO;
import cat.creaf.afectaciobosc.model.*;
import java.util.List;
import java.util.Map;

/**
 *
 * @author v.garcia
 */
public interface IAfectacioService {
    public void setAfectacioDAO(AfectacioDAO dao);
    public int getProcessionariesCount();
    public int getNevadesCount();
    public Afectacio getAfectacio(String id);
    public List<Processionaria> getProcessionaries();
    public List<Processionaria> getProcessionaries(String ordenacio, String direccioOrdenacio, int numPrimerRegistre, int maxNombreRegistres);
    public List<Nevada> getNevades();
    public List<Nevada> getNevades(String ordenacio, String direccioOrdenacio, int numPrimerRegistre, int maxNombreRegistres);
    public int getSequeresCount();
    public List<Sequera> getSequeres(String ordenacio, String direccioOrdenacio, int numPrimerRegistre, int maxNombreRegistres);
    public List<Sequera> getSequeres();
//    public int getDanysMecanicsCount();
//    public List<Sequera> getDanysMecanics(String ordenacio, String direccioOrdenacio, int numPrimerRegistre, int maxNombreRegistres);
//    public List<Sequera> getDanysMecanics();
    public int getDanysAbioticsCount();
    public List<DanyAbiotic> getDanysAbiotics(String ordenacio, String direccioOrdenacio, int numPrimerRegistre, int maxNombreRegistres);
    public List<DanyAbiotic> getDanysAbiotics();
    public List<Especie> getEspecies();
    public List<Especie> getEspeciesAmbProcessionaria();
    public List<Especie> getEspeciesAmbSequera();
    public List<Especie> getEspeciesAmbSequeraSoca();
    public List<Especie> getEspeciesAmbSequeraTipusBosc();
    public List<Especie> getEspecies(String partNom);
    public List<GrauInfestacio> getGrausInfestacioProcessionaria();
    public List<GrauInfestacio> getGrausInfestacioDanyMecanic();
    public List<TipusBosc> getTipusBoscos();
    public List<Orientacio> getOrientacions();
    public List<ObjecteSIPANAmbNom> getTipusOrientacions();
    public List<ObjecteSIPANAmbNom> getPendents();
    public List<ObjecteSIPANAmbNom> getPosicionsPendent();
    public List<ObjecteSIPANAmbNom> getDisposicionsPendent();
    public List<Comarca> getComarquesAfectacioBosc();
    public List<Municipi> getMunicipisAfectacioBosc();
    public void desar(Afectacio afectacio);
//    public void desar(DanyMecanic dany,String jsonEstimacions);
    public void desar(DanyAbiotic dany,String jsonEstimacions);
    public void desar(Sequera sequera,String jsonEstimacions,String jsonRegeneracio,
             String jsonTransecte);
    public void esborrar(Afectacio afectacio);
    public Usuari getUsuariPerNom(String nom);
    public Nevada getNevada(String id);
    public Processionaria getProcessionaria(String id);
    public Sequera getSequera(String id);
//    public DanyMecanic getDanyMecanic(String id);
    public DanyAbiotic createDanyAbiotic();
    public DanyAbiotic getDanyAbiotic(String id);
    public List<DistribucioArbresAfectats> getDistribucionsArbresAfectats();
    public List<CausaDecaiment> getCausesDecaimentSequera();
    public List<CausaDecaiment> getCausesDecaimentDanyMecanic();
    public List<CausaDecaimentDanyAbiotic> getCausesDecaimentDanyAbiotic();
    public CausaDecaiment getCausaDecaiment(String id);
    public CausaDecaimentDanyAbiotic getCausaDecaimentDanyAbiotic(String id);
    public int getCausesDecaimentCount();
    public int getCausesDecaimentDanyAbioticCount();
    public Foto getFoto(String id);
    public void esborrar(Foto foto) throws Exception;
    public void desarDanyAbiotic(DanyAbiotic afectacio,Map<String,String> parametres) throws Exception;
}
