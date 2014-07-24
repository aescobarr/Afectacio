/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cat.creaf.afectaciobosc.model;

import java.util.Date;

/**
 *
 * @author v.garcia
 */
public class Processionaria extends Afectacio {

    private TipusBosc tipusBosc;
    private Orientacio orientacio;
    private Especie especie;
    private GrauInfestacio grauInfestacio;
    private Double alcada;
    private String codiAgent1;
    private String codiAgent2;
    private Double alcadaMitjanaArbres;

    public Processionaria(){
        this("-1",null,"","",null,null,null,null);
    }

    public Processionaria(String id,Date data,String codi,String observacions,
        TipusBosc tipusBosc,Especie especie,GrauInfestacio grauInfestacio,Double alcada){
        super(id,data,codi,observacions);
        this.tipusBosc = tipusBosc;
        this.especie = especie;
        this.grauInfestacio = grauInfestacio;
        this.alcada = alcada;
        this.orientacio = null;
        this.codiAgent1 = "";
        this.codiAgent2 = "";
        this.alcadaMitjanaArbres = null;
    }

    @Override
    public void save(Object o) {
        super.save(o);
        Processionaria backingObject = (Processionaria) o;
        setAlcada(backingObject.getAlcada());
        setEspecie(backingObject.getEspecie());
        setGrauInfestacio(backingObject.getGrauInfestacio());
        setTipusBosc(backingObject.getTipusBosc());
        setOrientacio(backingObject.getOrientacio());
        setEstat(backingObject.getEstat());
    }



    /**
     * @return the tipusBosc
     */
    public TipusBosc getTipusBosc() {
        return tipusBosc;
    }

    /**
     * @param tipusBosc the tipusBosc to set
     */
    public void setTipusBosc(TipusBosc tipusBosc) {
        this.tipusBosc = tipusBosc;
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
     * @return the grauInfestacio
     */
    public GrauInfestacio getGrauInfestacio() {
        return grauInfestacio;
    }

    /**
     * @param grauInfestacio the grauInfestacio to set
     */
    public void setGrauInfestacio(GrauInfestacio grauInfestacio) {
        this.grauInfestacio = grauInfestacio;
    }

    /**
     * @return the alcada
     */
    public Double getAlcada() {
        return alcada;
    }

    /**
     * @param alcada the alcada to set
     */
    public void setAlcada(Double alcada) {
        this.alcada = alcada;
    }

//    /**
//     * @return the alcada
//     */
//    public String getAlcadaString() {
//        return alcada + "";
//    }
//
//    /**
//     * @param alcada the alcada to set
//     */
//    public void setAlcadaString(String alcada) {
//        try{
//            this.alcada = Double.parseDouble(alcada);
//        }catch(NumberFormatException ex){
//            this.alcada = 0;
//        }
//    }

    /**
     * @return the orientacio
     */
    public Orientacio getOrientacio() {
        return orientacio;
    }

    /**
     * @param orientacio the orientacio to set
     */
    public void setOrientacio(Orientacio orientacio) {
        this.orientacio = orientacio;
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

    /**
     * @return the alcadaMitjanaArbres
     */
    public Double getAlcadaMitjanaArbres() {
        return alcadaMitjanaArbres;
    }

    /**
     * @param alcadaMitjanaArbres the alcadaMitjanaArbres to set
     */
    public void setAlcadaMitjanaArbres(Double alcadaMitjanaArbres) {
        this.alcadaMitjanaArbres = alcadaMitjanaArbres;
    }
}
