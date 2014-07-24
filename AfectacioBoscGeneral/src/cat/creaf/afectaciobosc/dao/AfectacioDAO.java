/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cat.creaf.afectaciobosc.dao;

import MSIPANBD.SIPANDAO;
import MSeguretatObj.Usuari;
import cat.creaf.afectaciobosc.model.*;
import java.util.List;

/**
 *
 * @author v.garcia
 */
public interface AfectacioDAO extends SIPANDAO {
    public Afectacio getAfectacio(String id);
    public int getProcessionariesCount();
    public int getNevadesCount();
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
    public Usuari getUsuariPerNom(String nom);
    public List<DistribucioArbresAfectats> getDistribucionsArbresAfectats();
    public List<CausaDecaiment> getCausesDecaimentSequera();
    public List<CausaDecaiment> getCausesDecaimentDanyMecanic();
    public List<CausaDecaimentDanyAbiotic> getCausesDecaimentDanyAbiotic();
    public CausaDecaiment getCausaDecaiment(String id);
    public CausaDecaimentDanyAbiotic getCausaDecaimentDanyAbiotic(String id);
    public int getCausesDecaimentCount();
    public int getCausesDecaimentDanyAbioticCount();
    public Foto getFoto(String id);
    public List<Comarca> getComarquesAfectacioBosc();
    public List<Municipi> getMunicipisAfectacioBosc();
}
