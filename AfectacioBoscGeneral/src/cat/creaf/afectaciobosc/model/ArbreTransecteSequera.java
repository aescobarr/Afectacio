/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cat.creaf.afectaciobosc.model;

import MSIPANBasicObj.ObjecteSIPAN;

/**
 *
 * @author v.garcia
 */
public class ArbreTransecteSequera extends ObjecteSIPAN {

    private Sequera sequera;
    private Especie especie;
    private String estrat;
    private String classeDiametrica;
    private String estatArbres;
    private String afectacioCapcada;
    private String percentatgeFullaVerda;
    private String observacions;
    private int ordre;

    public ArbreTransecteSequera(){
        this.especie = null;
        this.estrat = "";
        this.classeDiametrica = "";
        this.estatArbres = "";
        this.afectacioCapcada = "";
        this.percentatgeFullaVerda = "";
        this.observacions = "";
        this.sequera = null;
        this.ordre = -1;
    }

    /**
     * @return the especie
     */
    public Especie getEspecie() {
        return especie;
    }

    /**
     * @param especie the especie to set
     */
    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    /**
     * @return the estrat
     */
    public String getEstrat() {
        return estrat;
    }

    /**
     * @param estrat the estrat to set
     */
    public void setEstrat(String estrat) {
        this.estrat = estrat;
    }

    /**
     * @return the classeDiametrica
     */
    public String getClasseDiametrica() {
        return classeDiametrica;
    }

    /**
     * @param classeDiametrica the classeDiametrica to set
     */
    public void setClasseDiametrica(String classeDiametrica) {
        this.classeDiametrica = classeDiametrica;
    }

    /**
     * @return the estatArbres
     */
    public String getEstatArbres() {
        return estatArbres;
    }

    /**
     * @param estatArbres the estatArbres to set
     */
    public void setEstatArbres(String estatArbres) {
        this.estatArbres = estatArbres;
    }

    /**
     * @return the afectacioCapcada
     */
    public String getAfectacioCapcada() {
        return afectacioCapcada;
    }

    /**
     * @param afectacioCapcada the afectacioCapcada to set
     */
    public void setAfectacioCapcada(String afectacioCapcada) {
        this.afectacioCapcada = afectacioCapcada;
    }

    /**
     * @return the percentatgeFullaVerda
     */
    public String getPercentatgeFullaVerda() {
        return percentatgeFullaVerda;
    }

    /**
     * @param percentatgeFullaVerda the percentatgeFullaVerda to set
     */
    public void setPercentatgeFullaVerda(String percentatgeFullaVerda) {
        this.percentatgeFullaVerda = percentatgeFullaVerda;
    }

    /**
     * @return the observacions
     */
    public String getObservacions() {
        return observacions;
    }

    /**
     * @param observacions the observacions to set
     */
    public void setObservacions(String observacions) {
        this.observacions = observacions;
    }

    /**
     * @return the sequera
     */
    public Sequera getSequera() {
        return sequera;
    }

    /**
     * @param sequera the sequera to set
     */
    public void setSequera(Sequera sequera) {
        this.sequera = sequera;
    }

    /**
     * @return the ordre
     */
    public int getOrdre() {
        return ordre;
    }

    /**
     * @param ordre the ordre to set
     */
    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }

}
