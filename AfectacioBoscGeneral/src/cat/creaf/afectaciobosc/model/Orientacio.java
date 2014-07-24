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
public class Orientacio extends ObjecteSIPAN {
    private String nom;

    public Orientacio(){
        this("","");
    }

    public Orientacio(String id,String nom){
        super(id);
        this.nom = nom;
    }

    /**
     * @return the tipus
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param tipus the tipus to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return this.nom;
    }


}
