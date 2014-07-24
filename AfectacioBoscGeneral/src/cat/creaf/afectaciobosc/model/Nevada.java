/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cat.creaf.afectaciobosc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * @author v.garcia
 */
public class Nevada extends Afectacio {

    private String nomCami;
    private double longitudKm;
    private Municipi terme;
    private List<DadaObservacio> dadesObservacions;
    private String codiAgent1;
    private String codiAgent2;

    public static final int DANY_NO = -1;
    public static final int DANY_MODERAT = 0;
    public static final int DANY_GREU = 1;
    public static final int DANY_MOLT_GREU = 2;
    public static final int DANY_EXTREM = 3;

    public Nevada(){
        this("-1",null,"","","",-1,null);
    }

    public Nevada(String id,Date data,String codi,String observacions,
        String nomCami,int longitudKm,Municipi terme){
        super(id,data,codi,observacions);
        this.nomCami = nomCami;
        this.longitudKm = longitudKm;
        this.terme = terme;
        this.dadesObservacions = new ArrayList<DadaObservacio>();
    }

    /**
     * @return the nomCami
     */
    public String getNomCami() {
        return nomCami;
    }

    /**
     * @param nomCami the nomCami to set
     */
    public void setNomCami(String nomCami) {
        this.nomCami = nomCami;
    }

    /**
     * @return the longitudKm
     */
    public double getLongitudKm() {
        return longitudKm;
    }

    /**
     * @param longitudKm the longitudKm to set
     */
    public void setLongitudKm(double longitudKm) {
        this.longitudKm = longitudKm;
    }

    public String getLongitudKmString() {
        if(longitudKm<0)
            return "";
        return Double.toString(longitudKm);
    }

    public void setLongitudKmString(String longitudKm) {
        try{
            longitudKm = longitudKm.replace(",", ".");
            this.longitudKm = Double.parseDouble(longitudKm);
        }catch(NumberFormatException ex){
            this.longitudKm = -1;
        }
        
    }

    /**
     * @return the terme
     */
    public Municipi getTerme() {
        return terme;
    }

    /**
     * @param terme the terme to set
     */
    public void setTerme(Municipi terme) {
        this.terme = terme;
    }

    /**
     * @return the dadesObservacions
     */
    public List<DadaObservacio> getDadesObservacions() {
        return dadesObservacions;
    }

    /**
     * @param dadesObservacions the dadesObservacions to set
     */
    public void setDadesObservacions(List<DadaObservacio> dadesObservacions) {
        this.dadesObservacions = dadesObservacions;
    }

    public double getPeusParcialmentAfectatsPerHa(){
        double resultat = 0;
        for(int i=0;i<dadesObservacions.size();i++){
            resultat += dadesObservacions.get(i).getFranjaParcialmentAfectat() +
                    dadesObservacions.get(i).getPistaParcialmentAfectat();
        }
        return resultat;
    }

    public double getPeusTotalmentAfectatsPerHa(){
        double resultat = 0;
        for(int i=0;i<dadesObservacions.size();i++){
            resultat += dadesObservacions.get(i).getFranjaTotalmentAfectat() +
                    dadesObservacions.get(i).getPistaTotalmentAfectat();
        }
        return resultat;
    }

    public double getSumaPeusAfectatsPerHa(){
        double total = getPeusParcialmentAfectatsPerHa() +
                getPeusTotalmentAfectatsPerHa();
        return total / longitudKm;
    }

    public int getNivellAfectacio(){
        int resultat = DANY_NO;
        double relacio = getSumaPeusAfectatsPerHa();
        if(relacio>15){
            resultat = DANY_EXTREM;
        }else if(relacio>10){
            resultat = DANY_MOLT_GREU;
        }else if(relacio>5){
            resultat = DANY_GREU;
        }else if(relacio>0){
            resultat = DANY_MODERAT;
        }
        return resultat;
    }

    public String getNivellAfectacioText(){
        ResourceBundle bundle = ResourceBundle.getBundle("cat.creaf.afectaciobosc.literals.AfectacioBosc");
        String resultat = "";
        double relacio = getNivellAfectacio();
        if(relacio==DANY_EXTREM){
            resultat = bundle.getString("danyExtrem");
        }else if(relacio==DANY_MOLT_GREU){
            resultat = bundle.getString("danyMoltGreu");
        }else if(relacio==DANY_GREU){
            resultat = bundle.getString("danyGreu");
        }else if(relacio==DANY_MODERAT){
            resultat = bundle.getString("danyModerat");
        }
        return resultat;
    }

    /**
     * @return the codiAgent1
     */
    public String getCodiAgent1() {
        return codiAgent1;
    }

    /**
     * @param codiAgent1 the codiAgent1 to set
     */
    public void setCodiAgent1(String codiAgent1) {
        this.codiAgent1 = codiAgent1;
    }

    /**
     * @return the codiAgent2
     */
    public String getCodiAgent2() {
        return codiAgent2;
    }

    /**
     * @param codiAgent2 the codiAgent2 to set
     */
    public void setCodiAgent2(String codiAgent2) {
        this.codiAgent2 = codiAgent2;
    }


}
