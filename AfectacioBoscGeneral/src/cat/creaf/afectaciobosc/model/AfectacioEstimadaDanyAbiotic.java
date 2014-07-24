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
public class AfectacioEstimadaDanyAbiotic extends ObjecteSIPAN {

    private DanyAbiotic danyAbiotic;
    private String recobriment;
    private String afectacio;
    private String estrat;
    private Especie especie;
    private int ordre;

    public static final String ALCADA_VOL = "VOL";
    public static final String ALCADA_SUBVOL = "SUBVOL";

    public AfectacioEstimadaDanyAbiotic(){
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

    public DanyAbiotic getDanyAbiotic() {
        return danyAbiotic;
    }

    public void setDanyAbiotic(DanyAbiotic danyAbiotic) {
        this.danyAbiotic = danyAbiotic;
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
     * @return the estrat
     */
    public String getEstrat() {
        String estratMajuscules = null;
        if(this.estrat!=null)
            estratMajuscules = this.estrat.toUpperCase();
        return estratMajuscules;
    }

    /**
     * @param estrat the estrat to set
     */
    public void setEstrat(String estrat) {
        String estratMajuscules = null;
        if(estrat!=null)
            estratMajuscules = estrat.toUpperCase();
        this.estrat = estratMajuscules;
    }


//    public String getAlcadaFormatejada() {
//        ResourceBundle bundle = ResourceBundle.getBundle("cat.creaf.afectaciobosc.literals.AfectacioBosc");
//        String text = "";
//        if(ALCADA_TOTS.equals(alcada))
//            text = bundle.getString("tots");
//        else if(ALCADA_ALTS.equals(alcada))
//            text = bundle.getString("alts");
//        else if(ALCADA_BAIXOS.equals(alcada))
//            text = bundle.getString("baixos");
//        return text;
//    }
}
