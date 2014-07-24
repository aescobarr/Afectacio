/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cat.creaf.afectaciobosc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author v.garcia
 */
public class DanyMecanic extends Afectacio {

    
    private List<CausaDecaiment> causesDecaiment;
    private List<AfectacioEstimadaDanyMecanic> afectacionsEstimades;
    private DistribucioArbresAfectats distribucioArbresAfectats;
    private String codiAgent1;
    private String codiAgent2;
    private Integer orientacioFoto;
    private Double grauAfectacio;
    private GrauInfestacio grauInfestacio;
    private Date dataEpisodi;


    public DanyMecanic(){
        this("-1",null,"","");
    }

    public DanyMecanic(String id,Date data,String codi,String observacions){
        super(id,data,codi,observacions);
        this.causesDecaiment = new ArrayList<CausaDecaiment>();
        this.afectacionsEstimades = new ArrayList<AfectacioEstimadaDanyMecanic>();
        this.codiAgent1 = "";
        this.codiAgent2 = "";        
    }
    /**
     * @return the causesDecaiments
     */
    public List<CausaDecaiment> getCausesDecaiment() {
        return causesDecaiment;
    }

    /**
     * @param causesDecaiments the causesDecaiments to set
     */
    public void setCausesDecaiment(List<CausaDecaiment> causesDecaiment) {
        this.causesDecaiment = causesDecaiment;
    }

    public String getCausesDecaimentFormatada(){
        String causes = "";
        for(int i=0;i<causesDecaiment.size();i++){
            causes += causesDecaiment.get(i).toString();
            if(i<causesDecaiment.size()-1)
                causes += ", ";
        }
        return causes;
    }
    
    /**
     * @return the afectacionsEstimades
     */
    public List<AfectacioEstimadaDanyMecanic> getAfectacionsEstimades() {
        return afectacionsEstimades;
    }

    /**
     * @param afectacionsEstimades the afectacionsEstimades to set
     */
    public void setAfectacionsEstimades(List<AfectacioEstimadaDanyMecanic> afectacionsEstimades) {
        this.afectacionsEstimades = afectacionsEstimades;
    }

    /**
     * @return the distribucioArbresAfectats
     */
    public DistribucioArbresAfectats getDistribucioArbresAfectats() {
        return distribucioArbresAfectats;
    }

    /**
     * @param distribucioArbresAfectats the distribucioArbresAfectats to set
     */
    public void setDistribucioArbresAfectats(DistribucioArbresAfectats distribucioArbresAfectats) {
        this.distribucioArbresAfectats = distribucioArbresAfectats;
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
     * @return the orientacioFoto
     */
    public Integer getOrientacioFoto() {
        return orientacioFoto;
    }

    /**
     * @param orientacioFoto the orientacioFoto to set
     */
    public void setOrientacioFoto(Integer orientacioFoto) {
        this.orientacioFoto = orientacioFoto;
    }

    /**
     * @return the grauAfectacio
     */
    public Double getGrauAfectacio() {
        return grauAfectacio;
    }

    /**
     * @param grauAfectacio the grauAfectacio to set
     */
    public void setGrauAfectacio(Double grauAfectacio) {
        this.grauAfectacio = grauAfectacio;
    }

    public void calcularGrauAfectacio(){
        double numerador = 0;
        double denominador = 0;
        for(int i=0;i<this.afectacionsEstimades.size();i++){
            numerador += Double.parseDouble(this.afectacionsEstimades.get(i).getRecobriment())*
                    Double.parseDouble(this.afectacionsEstimades.get(i).getAfectacio());
            denominador += Double.parseDouble(this.afectacionsEstimades.get(i).getRecobriment());
        }
        this.grauAfectacio = new Double(numerador/denominador);
    }

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
     * @return the dataEpisodi
     */
    public Date getDataEpisodi() {
        return dataEpisodi;
    }

    /**
     * @param dataEpisodi the dataEpisodi to set
     */
    public void setDataEpisodi(Date dataEpisodi) {
        this.dataEpisodi = dataEpisodi;
    }
}
