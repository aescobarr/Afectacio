/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cat.creaf.afectaciobosc.model;

import MSIPANBasicObj.ObjecteSIPAN;
import java.util.ResourceBundle;

/**
 *
 * @author v.garcia
 */
public class AfectacioEstimadaDanyMecanic extends ObjecteSIPAN {

    private DanyMecanic danyMecanic;
    private String recobriment;
    private String afectacio;
    private String alcada;
    private Especie especie;
    private int ordre;

    public static final String ALCADA_TOTS = "TOTS";
    public static final String ALCADA_ALTS = "ALTS";
    public static final String ALCADA_BAIXOS = "BAIXOS";

    public AfectacioEstimadaDanyMecanic(){
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

    public DanyMecanic getDanyMecanic() {
        return danyMecanic;
    }

    public void setDanyMecanic(DanyMecanic danyMecanic) {
        this.danyMecanic = danyMecanic;
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
     * @return the alcada
     */
    public String getAlcada() {
        return alcada;
    }

    /**
     * @param alcada the alcada to set
     */
    public void setAlcada(String alcada) {
        this.alcada = alcada;
    }

    public String getAlcadaFormatejada() {
        ResourceBundle bundle = ResourceBundle.getBundle("cat.creaf.afectaciobosc.literals.AfectacioBosc");
        String text = "";
        if(ALCADA_TOTS.equals(alcada))
            text = bundle.getString("tots");
        else if(ALCADA_ALTS.equals(alcada))
            text = bundle.getString("alts");
        else if(ALCADA_BAIXOS.equals(alcada))
            text = bundle.getString("baixos");
        return text;
    }
}
