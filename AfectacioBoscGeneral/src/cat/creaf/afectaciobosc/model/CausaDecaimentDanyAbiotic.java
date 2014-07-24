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
public class CausaDecaimentDanyAbiotic extends ObjecteSIPAN {

    private String nom;
    private int ordre;
    private String modul;

    public CausaDecaimentDanyAbiotic(){
        this("");
        this.ordre = -1;
    }

    public CausaDecaimentDanyAbiotic(String nom){
        this.nom = nom;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return this.getNom();
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
     * @return the modul
     */
    public String getModul() {
        return modul;
    }

    /**
     * @param modul the modul to set
     */
    public void setModul(String modul) {
        this.modul = modul;
    }


}
