/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cat.creaf.afectaciobosc.model;

import MSIPANBasicObj.ObjecteSIPAN;
import MSeguretatObj.SIPANAuthority;
import java.util.List;

/**
 *
 * @author v.garcia
 */
public class Usuari extends ObjecteSIPAN {

    private String userName;
    private String password;
    private String nom;
    private String primerCognom;
    private String segonCognom;
    private String email;
    private List<SIPANAuthority> authorities;
    private boolean alta;

    public Usuari(){
        super("-1");
    }

    /**
     * @return the userName
     */
    public String getNomUsuari() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setNomUsuari(String userName) {
        this.userName = userName;
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

    /**
     * @return the primerCognom
     */
    public String getPrimerCognom() {
        return primerCognom;
    }

    /**
     * @param primerCognom the primerCognom to set
     */
    public void setPrimerCognom(String primerCognom) {
        this.primerCognom = primerCognom;
    }

    /**
     * @return the segonCognom
     */
    public String getSegonCognom() {
        return segonCognom;
    }

    /**
     * @param segonCognom the segonCognom to set
     */
    public void setSegonCognom(String segonCognom) {
        this.segonCognom = segonCognom;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the authorities
     */
    public List<SIPANAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * @param authorities the authorities to set
     */
    public void setAuthorities(List<SIPANAuthority> authorities) {
        this.authorities = authorities;
    }

    public boolean getAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public String getAltaString() {
        if(this.alta)
            return "S";
        else
            return "N";
    }

    public void setAltaString(String s) {
        this.alta = "S".equals(s);
    }
}
