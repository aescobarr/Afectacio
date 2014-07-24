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
public class AfectacioEstimada extends ObjecteSIPAN {

    private Sequera sequera;
    private String recobriment;
    private String afectacio;
    private String arbre;
    private boolean mortalitat;
    private boolean defoliacio;
    private boolean decoloracio;
    
    private String arbresAfectats;
    private String percMortalitat;
    private String percDefoliacio;
    private String percDecoloracio;
    
    private String canviMortalitat;
    private String canviDefoliacio;
    private String canviDecoloracio;
    private String rebrots;
    
    private Especie especie;
    private int ordre;

    public AfectacioEstimada(){
        super();
        this.ordre = -1;
    }

    /**
     * @return the recobriment
     */
    public String getRecobriment() {
        return recobriment;
    }

    /**
     * @param recobriment the recobriment to set
     */
    public void setRecobriment(String recobriment) {
        this.recobriment = recobriment;
    }

    /**
     * @return the afectacio
     */
    public String getAfectacio() {
        return afectacio;
    }

    /**
     * @param afectacio the afectacio to set
     */
    public void setAfectacio(String afectacio) {
        this.afectacio = afectacio;
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

    /**
     * @return the decoloracio
     */
    public boolean getDecoloracio() {
        return decoloracio;
    }

    /**
     * @param decoloracio the decoloracio to set
     */
    public void setDecoloracio(boolean decoloracio) {
        this.decoloracio = decoloracio;
    }

    /**
     * @return the mortalitat
     */
    public boolean getMortalitat() {
        return mortalitat;
    }

    /**
     * @param mortalitat the mortalitat to set
     */
    public void setMortalitat(boolean mortalitat) {
        this.mortalitat = mortalitat;
    }

    /**
     * @return the defoliacio
     */
    public boolean getDefoliacio() {
        return defoliacio;
    }

    /**
     * @param defoliacio the defoliacio to set
     */
    public void setDefoliacio(boolean defoliacio) {
        this.defoliacio = defoliacio;
    }
    
    public String getDecoloracioString() {
        if(decoloracio)
            return "S";
        else
            return "N";
    }

    public void setDecoloracioString(String decoloracio) {
        this.decoloracio = "S".equals(decoloracio);
    }

    public String getMortalitatString() {
        if(mortalitat)
            return "S";
        else
            return "N";
    }

    public void setMortalitatString(String mortalitat) {
        this.mortalitat = "S".equals(mortalitat);
    }

    public String getDefoliacioString() {
        if(defoliacio)
            return "S";
        else
            return "N";
    }

    public void setDefoliacioString(String defoliacio) {
        this.defoliacio = "S".equals(defoliacio);
    }

    /**
     * @return the arbre
     */
    public String getArbre() {
        return arbre;
    }

    /**
     * @param arbre the arbre to set
     */
    public void setArbre(String arbre) {
        this.arbre = arbre;
    }

    /**
     * @return the arbresAfectats
     */
    public String getArbresAfectats() {
        return arbresAfectats;
    }

    /**
     * @param arbresAfectats the arbresAfectats to set
     */
    public void setArbresAfectats(String arbresAfectats) {
        this.arbresAfectats = arbresAfectats;
    }

    /**
     * @return the percMortalitat
     */
    public String getPercMortalitat() {
        return percMortalitat;
    }

    /**
     * @param percMortalitat the percMortalitat to set
     */
    public void setPercMortalitat(String percMortalitat) {
        this.percMortalitat = percMortalitat;
    }

    /**
     * @return the percDefoliacio
     */
    public String getPercDefoliacio() {
        return percDefoliacio;
    }

    /**
     * @param percDefoliacio the percDefoliacio to set
     */
    public void setPercDefoliacio(String percDefoliacio) {
        this.percDefoliacio = percDefoliacio;
    }

    /**
     * @return the percDecoloracio
     */
    public String getPercDecoloracio() {
        return percDecoloracio;
    }

    /**
     * @param percDecoloracio the percDecoloracio to set
     */
    public void setPercDecoloracio(String percDecoloracio) {
        this.percDecoloracio = percDecoloracio;
    }

    /**
     * @return the canviMortalitat
     */
    public String getCanviMortalitat() {
        return canviMortalitat;
    }

    /**
     * @param canviMortalitat the canviMortalitat to set
     */
    public void setCanviMortalitat(String canviMortalitat) {
        this.canviMortalitat = canviMortalitat;
    }

    /**
     * @return the canviDefoliacio
     */
    public String getCanviDefoliacio() {
        return canviDefoliacio;
    }

    /**
     * @param canviDefoliacio the canviDefoliacio to set
     */
    public void setCanviDefoliacio(String canviDefoliacio) {
        this.canviDefoliacio = canviDefoliacio;
    }

    /**
     * @return the canviDecoloracio
     */
    public String getCanviDecoloracio() {
        return canviDecoloracio;
    }

    /**
     * @param canviDecoloracio the canviDecoloracio to set
     */
    public void setCanviDecoloracio(String canviDecoloracio) {
        this.canviDecoloracio = canviDecoloracio;
    }

    /**
     * @return the rebrots
     */
    public String getRebrots() {
        return rebrots;
    }

    /**
     * @param rebrots the rebrots to set
     */
    public void setRebrots(String rebrots) {
        this.rebrots = rebrots;
    }

}
