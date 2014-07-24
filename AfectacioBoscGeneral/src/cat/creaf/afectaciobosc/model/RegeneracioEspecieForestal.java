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
public class RegeneracioEspecieForestal extends ObjecteSIPAN {

    public static final String ABUNDANCIA_BAIXA = "0";
    public static final String ABUNDANCIA_ALTA = "1";
    public static final String PERCENTATGE_BAIX = "0";
    public static final String PERCENTATGE_ALT = "1";

    private int ordre;
    private String abundancia;
    private String percentatgeMorts;
    private Especie especie;
    private Sequera sequera;

    public RegeneracioEspecieForestal(){
        this.abundancia = null;
        this.percentatgeMorts = null;
        this.especie = null;
        this.ordre = -1;
    }

    /**
     * @return the abundancia
     */
    public String getAbundancia() {
        return abundancia;
    }

    /**
     * @param abundancia the abundancia to set
     */
    public void setAbundancia(String abundancia) {
        this.abundancia = abundancia;
    }

    /**
     * @return the percentatgeMorts
     */
    public String getPercentatgeMorts() {
        return percentatgeMorts;
    }

    /**
     * @param percentatgeMorts the percentatgeMorts to set
     */
    public void setPercentatgeMorts(String percentatgeMorts) {
        this.percentatgeMorts = percentatgeMorts;
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
