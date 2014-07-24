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
public class DadaObservacio extends ObjecteSIPAN {

    private Nevada nevada;
    private Especie especie;
    private int pistaParcialmentAfectat;
    private int pistaTotalmentAfectat;
    private int franjaParcialmentAfectat;
    private int franjaTotalmentAfectat;

    public DadaObservacio(){
        super();
        this.pistaParcialmentAfectat = 0;
        this.pistaTotalmentAfectat = 0;
        this.franjaParcialmentAfectat = 0;
        this.franjaTotalmentAfectat = 0;
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
     * @return the pistaParcialmentAfectat
     */
    public int getPistaParcialmentAfectat() {
        return pistaParcialmentAfectat;
    }

    /**
     * @param pistaParcialmentAfectat the pistaParcialmentAfectat to set
     */
    public void setPistaParcialmentAfectat(int pistaParcialmentAfectat) {
        this.pistaParcialmentAfectat = pistaParcialmentAfectat;
    }

    /**
     * @return the pistaTotalmentAfectat
     */
    public int getPistaTotalmentAfectat() {
        return pistaTotalmentAfectat;
    }

    /**
     * @param pistaTotalmentAfectat the pistaTotalmentAfectat to set
     */
    public void setPistaTotalmentAfectat(int pistaTotalmentAfectat) {
        this.pistaTotalmentAfectat = pistaTotalmentAfectat;
    }

    /**
     * @return the franjaParcialmentAfectat
     */
    public int getFranjaParcialmentAfectat() {
        return franjaParcialmentAfectat;
    }

    /**
     * @param franjaParcialmentAfectat the franjaParcialmentAfectat to set
     */
    public void setFranjaParcialmentAfectat(int franjaParcialmentAfectat) {
        this.franjaParcialmentAfectat = franjaParcialmentAfectat;
    }

    /**
     * @return the franjaTotalmentAfectat
     */
    public int getFranjaTotalmentAfectat() {
        return franjaTotalmentAfectat;
    }

    /**
     * @param franjaTotalmentAfectat the franjaTotalmentAfectat to set
     */
    public void setFranjaTotalmentAfectat(int franjaTotalmentAfectat) {
        this.franjaTotalmentAfectat = franjaTotalmentAfectat;
    }

    /**
     * @return the nevada
     */
    public Nevada getNevada() {
        return nevada;
    }

    /**
     * @param nevada the nevada to set
     */
    public void setNevada(Nevada nevada) {
        this.nevada = nevada;
    }

}
