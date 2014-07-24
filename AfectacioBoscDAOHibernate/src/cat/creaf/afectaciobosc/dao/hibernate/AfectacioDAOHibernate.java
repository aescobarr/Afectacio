/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cat.creaf.afectaciobosc.dao.hibernate;

import MSIPANDAOHibernate.SIPANDAOHibernate;
import cat.creaf.afectaciobosc.dao.AfectacioDAO;
import cat.creaf.afectaciobosc.model.*;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author v.garcia
 */
public class AfectacioDAOHibernate extends SIPANDAOHibernate implements AfectacioDAO {
    
    public AfectacioDAOHibernate(){
        super();
    }

    public int getProcessionariesCount() {
        String where = "WHERE year(element.data)=year(current_date())";
        return getTipicDAOHibernate().getElementsTaulaCount("Processionaria",where);
    }

    public int getNevadesCount() {
        return getTipicDAOHibernate().getElementsTaulaCount("Nevada");
    }

    public int getSequeresCount() {
//        String where = "WHERE year(element.data)=year(current_date())";
//        return getTipicDAOHibernate().getElementsTaulaCount("Sequera",where);
        String where = "WHERE year(element.data)=2013";
        return getTipicDAOHibernate().getElementsTaulaCount("Sequera",where);
    }

    public int getCausesDecaimentCount() {
        return getTipicDAOHibernate().getElementsTaulaCount("CausaDecaiment");
    }

    public int getCausesDecaimentDanyAbioticCount() {
        return getTipicDAOHibernate().getElementsTaulaCount("CausaDecaimentDanyAbiotic");
    }

    public List<Processionaria> getProcessionaries(String ordenacio, String direccioOrdenacio, int numPrimerRegistre, int maxNombreRegistres) {
        String consulta = "SELECT element " +
                "FROM Processionaria AS element ";
        String where = "WHERE year(element.data)=year(current_date())";
        String orderBy = "";
        if (ordenacio != null) {
            orderBy = "ORDER BY "+ordenacio;
            if(direccioOrdenacio!=null){
                orderBy += " "+direccioOrdenacio;
            }
        }
        consulta += where + orderBy;
        return getTipicDAOHibernate().getElementsFromQuery(consulta, numPrimerRegistre, maxNombreRegistres);
    }

    public List<Nevada> getNevades(String ordenacio, String direccioOrdenacio, int numPrimerRegistre, int maxNombreRegistres) {
        String consulta = "SELECT element " +
                "FROM Nevada AS element ";
        String where = "";
        String orderBy = "";
        if (ordenacio != null) {
            orderBy = "ORDER BY "+ordenacio;
            if(direccioOrdenacio!=null){
                orderBy += " "+direccioOrdenacio;
            }
        }
        consulta += where + orderBy;
        return getTipicDAOHibernate().getElementsFromQuery(consulta, numPrimerRegistre, maxNombreRegistres);
    }

    public List<Sequera> getSequeres(String ordenacio, String direccioOrdenacio, int numPrimerRegistre, int maxNombreRegistres) {
//        String consulta = "SELECT element " +
//                "FROM Sequera AS element ";
//        String where = "WHERE year(element.data)=year(current_date())";
//        String orderBy = "";
//        if (ordenacio != null) {
//            orderBy = "ORDER BY "+ordenacio;
//            if(direccioOrdenacio!=null){
//                orderBy += " "+direccioOrdenacio;
//            }
//        }
//        consulta += where + orderBy;
//        if("element.grauAfectacioEspecie1".equals(ordenacio)){
//            consulta =  "SELECT element " +
//                    "FROM Sequera AS element LEFT OUTER JOIN element.afectacionsEstimades AS ae " +
//                    "WHERE ae.ordre=1 AND year(element.data)=year(current_date()) "+
//                    "ORDER BY ae.afectacio "+ direccioOrdenacio;
//        }else if("element.especie1".equals(ordenacio)){
//            consulta =  "SELECT element " +
//                    "FROM Sequera AS element LEFT OUTER JOIN element.afectacionsEstimades AS ae " +
//                    "WHERE ae.ordre=1 AND year(element.data)=year(current_date()) "+
//                    "ORDER BY ae.especie.nom "+ direccioOrdenacio;
//        }
        String consulta = "SELECT element " +
                "FROM Sequera AS element ";
        String where = "WHERE year(element.data)=2013";
        String orderBy = "";
        if (ordenacio != null) {
            orderBy = "ORDER BY "+ordenacio;
            if(direccioOrdenacio!=null){
                orderBy += " "+direccioOrdenacio;
            }
        }
        consulta += where + orderBy;
        if("element.grauAfectacioEspecie1".equals(ordenacio)){
            consulta =  "SELECT element " +
                    "FROM Sequera AS element LEFT OUTER JOIN element.afectacionsEstimades AS ae " +
                    "WHERE ae.ordre=1 AND year(element.data)=2013 "+
                    "ORDER BY ae.afectacio "+ direccioOrdenacio;
        }else if("element.especie1".equals(ordenacio)){
            consulta =  "SELECT element " +
                    "FROM Sequera AS element LEFT OUTER JOIN element.afectacionsEstimades AS ae " +
                    "WHERE ae.ordre=1 AND year(element.data)=2013 "+
                    "ORDER BY ae.especie.nom "+ direccioOrdenacio;
        }

        return getTipicDAOHibernate().getElementsFromQuery(consulta, numPrimerRegistre, maxNombreRegistres);
    }

    public List<Sequera> getSequeres() {
        HashMap parametres = new HashMap();
        String consulta = "SELECT element " +
                "FROM Sequera AS element ";
        return getTipicDAOHibernate().getElementsFromQuery(consulta, parametres);
    }


    public int getDanysAbioticsCount(){
        String where = "";// "WHERE year(element.data)=year(current_date())";
        return getTipicDAOHibernate().getElementsTaulaCount("DanyAbiotic");//,where);
    }

    public List<DanyAbiotic> getDanysAbiotics(String ordenacio, String direccioOrdenacio, int numPrimerRegistre, int maxNombreRegistres){
        String consulta = "SELECT element " +
                "FROM DanyAbiotic AS element ";
        String where = " "; //year(element.data)=year(current_date())";
        String orderBy = "";// " year(element.data)=year(current_date()) ";
        if (ordenacio != null) {
            orderBy = "ORDER BY "+ordenacio;
            if(direccioOrdenacio!=null){
                orderBy += " "+direccioOrdenacio;
            }
        }
        consulta += where + orderBy;
        if("element.grauAfectacioEspecie1".equals(ordenacio)){
            consulta =  "SELECT element " +
                    "FROM DanyAbiotic AS element LEFT OUTER JOIN element.afectacionsEstimades AS ae " +
//                    "WHERE ae.ordre=1 AND year(element.data)=year(current_date())  "+
                    "ORDER BY ae.afectacio "+ direccioOrdenacio;
        }else if("element.especie1".equals(ordenacio)){
            consulta =  "SELECT element " +
                    "FROM DanyAbiotic AS element LEFT OUTER JOIN element.afectacionsEstimades AS ae " +
//                    "WHERE ae.ordre=1 AND year(element.data)=year(current_date())  "+
                    "ORDER BY ae.especie.nom "+ direccioOrdenacio;
        }

        return getTipicDAOHibernate().getElementsFromQuery(consulta, numPrimerRegistre, maxNombreRegistres);
    }

//    public int getDanysMecanicsCount(){
//        String where = "WHERE year(element.data)=year(current_date())";
//        return getTipicDAOHibernate().getElementsTaulaCount("DanyMecanic",where);
//    }
//
//    public List<Sequera> getDanysMecanics(String ordenacio, String direccioOrdenacio, int numPrimerRegistre, int maxNombreRegistres){
//        String consulta = "SELECT element " +
//                "FROM DanyMecanic AS element ";
//        String where = "WHERE year(element.data)=year(current_date())";
//        String orderBy = " year(element.data)=year(current_date()) ";
//        if (ordenacio != null) {
//            orderBy = "ORDER BY "+ordenacio;
//            if(direccioOrdenacio!=null){
//                orderBy += " "+direccioOrdenacio;
//            }
//        }
//        consulta += where + orderBy;
//        if("element.grauAfectacioEspecie1".equals(ordenacio)){
//            consulta =  "SELECT element " +
//                    "FROM DanyMecanic AS element LEFT OUTER JOIN element.afectacionsEstimades AS ae " +
//                    "WHERE ae.ordre=1 AND year(element.data)=year(current_date())  "+
//                    "ORDER BY ae.afectacio "+ direccioOrdenacio;
//        }else if("element.especie1".equals(ordenacio)){
//            consulta =  "SELECT element " +
//                    "FROM DanyMecanic AS element LEFT OUTER JOIN element.afectacionsEstimades AS ae " +
//                    "WHERE ae.ordre=1 AND year(element.data)=year(current_date())  "+
//                    "ORDER BY ae.especie.nom "+ direccioOrdenacio;
//        }
//
//        return getTipicDAOHibernate().getElementsFromQuery(consulta, numPrimerRegistre, maxNombreRegistres);
//    }

//    public List<Sequera> getDanysMecanics(){
//        HashMap parametres = new HashMap();
//        String consulta = "SELECT element " +
//                "FROM DanyMecanic AS element ";
//        return getTipicDAOHibernate().getElementsFromQuery(consulta, parametres);
//    }

    public List<DanyAbiotic> getDanysAbiotics(){
        HashMap parametres = new HashMap();
        String consulta = "SELECT element " +
                "FROM DanyAbiotic AS element ";
        return getTipicDAOHibernate().getElementsFromQuery(consulta, parametres);
    }

    public List<Processionaria> getProcessionaries() {
        HashMap parametres = new HashMap();
        String consulta = "SELECT element " +
                "FROM Processionaria AS element ";
        return getTipicDAOHibernate().getElementsFromQuery(consulta, parametres);
    }

    public List<Nevada> getNevades() {
        HashMap parametres = new HashMap();
        String consulta = "SELECT element " +
                "FROM Nevada AS element ";
        return getTipicDAOHibernate().getElementsFromQuery(consulta, parametres);
    }

    public List<Especie> getEspecies() {
        HashMap parametres = new HashMap();
        String consulta = "SELECT element " +
                "FROM Especie AS element " +
                "ORDER BY element.nom";
        return getTipicDAOHibernate().getElementsFromQuery(consulta, parametres);
    }

    public List<Especie> getEspeciesAmbProcessionaria() {
        HashMap parametres = new HashMap();
        String consulta = "SELECT element " +
                "FROM EspecieAmbProcessionaria AS element " +
                "ORDER BY element.nom";
        return getTipicDAOHibernate().getElementsFromQuery(consulta, parametres);
    }

    public List<Especie> getEspeciesAmbSequera() {
        HashMap parametres = new HashMap();
        String consulta = "SELECT element " +
                "FROM EspecieAmbSequera AS element " +
                "ORDER BY element.nom";
        return getTipicDAOHibernate().getElementsFromQuery(consulta, parametres);
    }

    public List<Especie> getEspeciesAmbSequeraSoca() {
        HashMap parametres = new HashMap();
        String consulta = "SELECT element " +
                "FROM EspecieAmbSequeraSoca AS element " +
                "ORDER BY element.nom";
        return getTipicDAOHibernate().getElementsFromQuery(consulta, parametres);
    }

    public List<Especie> getEspeciesAmbSequeraTipusBosc() {
        HashMap parametres = new HashMap();
        String consulta = "SELECT element " +
                "FROM EspecieAmbSequeraTipusBosc AS element " +
                "ORDER BY element.nom";
        return getTipicDAOHibernate().getElementsFromQuery(consulta, parametres);
    }

    public List<Especie> getEspecies(String partNom) {
        HashMap parametres = new HashMap();
        String consulta = "SELECT element " +
                "FROM Especie AS element " +
                "WHERE lower(element.nom) LIKE '%" + partNom.toLowerCase() + "%' " +
                "ORDER BY element.nom";
        List<Especie> taxons = getTipicDAOHibernate().getElementsFromQuery(consulta, parametres);
        return taxons;
    }

    public List<GrauInfestacio> getGrausInfestacioProcessionaria() {
        HashMap parametres = new HashMap();
        String consulta = "SELECT element " +
                "FROM GrauInfestacio AS element " +
                "WHERE element.idString <> 'grau_0' " +
                "ORDER BY element.grau";
        return getTipicDAOHibernate().getElementsFromQuery(consulta, parametres);
    }

    public List<GrauInfestacio> getGrausInfestacioDanyMecanic() {
        HashMap parametres = new HashMap();
        String consulta = "SELECT element " +
                "FROM GrauInfestacio AS element " +
                "ORDER BY element.grau";
        return getTipicDAOHibernate().getElementsFromQuery(consulta, parametres);
    }

    public List<TipusBosc> getTipusBoscos() {
        HashMap parametres = new HashMap();
        String consulta = "SELECT element " +
                "FROM TipusBosc AS element ";
        return getTipicDAOHibernate().getElementsFromQuery(consulta, parametres);
    }

    public List<Orientacio> getOrientacions(){
        HashMap parametres = new HashMap();
        String consulta = "SELECT element " +
                "FROM Orientacio AS element ";
        return getTipicDAOHibernate().getElementsFromQuery(consulta, parametres);
    }

    public List<DistribucioArbresAfectats> getDistribucionsArbresAfectats(){
        HashMap parametres = new HashMap();
        String consulta = "SELECT element " +
                "FROM DistribucioArbresAfectats AS element ";
        return getTipicDAOHibernate().getElementsFromQuery(consulta, parametres);
    }

    public List<CausaDecaiment> getCausesDecaimentSequera(){
        HashMap parametres = new HashMap();
        String consulta = "SELECT element " +
                "FROM CausaDecaiment AS element " +
                "WHERE element.modul='SEQUERA' " +
                "ORDER BY element.ordre ASC";
        return getTipicDAOHibernate().getElementsFromQuery(consulta, parametres);
    }

    public List<CausaDecaiment> getCausesDecaimentDanyMecanic(){
        HashMap parametres = new HashMap();
        String consulta = "SELECT element " +
                "FROM CausaDecaiment AS element " +
                "WHERE element.modul='DANYMECANIC' " +
                "ORDER BY element.ordre ASC";
        return getTipicDAOHibernate().getElementsFromQuery(consulta, parametres);
    }

    public List<CausaDecaimentDanyAbiotic> getCausesDecaimentDanyAbiotic(){
        HashMap parametres = new HashMap();
        String consulta = "SELECT element " +
                "FROM CausaDecaimentDanyAbiotic AS element ";/* +
                "WHERE element.modul='DANYMECANIC' " +
                "ORDER BY element.ordre ASC";*/
        return getTipicDAOHibernate().getElementsFromQuery(consulta, parametres);
    }

    public Afectacio getAfectacio(String id) {
        HashMap parametres = new HashMap();
        parametres.put("id", id);
        String consulta = "SELECT element " +
                "FROM Afectacio AS element " +
                "WHERE element.id=:id";
        List elements = getTipicDAOHibernate().getElementsFromQuery(consulta, parametres);
        if (elements != null && elements.size() > 0) {
            return (Afectacio) elements.get(0);
        } else {
            return null;
        }
    }

    public CausaDecaiment getCausaDecaiment(String id) {
        HashMap parametres = new HashMap();
        parametres.put("id", id);
        String consulta = "SELECT element " +
                "FROM CausaDecaiment AS element " +
                "WHERE element.id=:id";
        List elements = getTipicDAOHibernate().getElementsFromQuery(consulta, parametres);
        if (elements != null && elements.size() > 0) {
            return (CausaDecaiment) elements.get(0);
        } else {
            return null;
        }
    }

    public CausaDecaimentDanyAbiotic getCausaDecaimentDanyAbiotic(String id){
        HashMap parametres = new HashMap();
        parametres.put("id", id);
        String consulta = "SELECT element " +
                "FROM CausaDecaimentDanyAbiotic AS element " +
                "WHERE element.id=:id";
        List elements = getTipicDAOHibernate().getElementsFromQuery(consulta, parametres);
        if (elements != null && elements.size() > 0) {
            return (CausaDecaimentDanyAbiotic) elements.get(0);
        } else {
            return null;
        }
    }
    
    public Foto getFoto(String id) {
        HashMap parametres = new HashMap();
        parametres.put("id", id);
        String consulta = "SELECT element " +
                "FROM Foto AS element " +
                "WHERE element.idString = :id ";
        List elements = getTipicDAOHibernate().getElementsFromQuery(consulta, parametres);
        if (elements != null && elements.size() > 0) {
            return (Foto) elements.get(0);
        } else {
            return null;
        }
    }
    
    public List<Comarca> getComarquesAfectacioBosc(){
        HashMap parametres = new HashMap();
        String consulta = "SELECT element " +
                "FROM Comarca AS element ";/* +
                "WHERE element.modul='DANYMECANIC' " +
                "ORDER BY element.ordre ASC";*/
        return getTipicDAOHibernate().getElementsFromQuery(consulta, parametres);
    }
    
    public List<Municipi> getMunicipisAfectacioBosc(){
        HashMap parametres = new HashMap();
        String consulta = "SELECT element " +
                "FROM Municipi AS element ";/* +
                "WHERE element.modul='DANYMECANIC' " +
                "ORDER BY element.ordre ASC";*/
        return getTipicDAOHibernate().getElementsFromQuery(consulta, parametres);
    }
}
