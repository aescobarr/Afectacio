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
public class DanyAbiotic extends Afectacio {

    
    private Date dataApreciacioInicial;
    private Date dataDadesDefinitives;
    private Date dataValidacio;
    private String codiAgent1;
    private String codiAgent2;
    private String nomEnginyer1;
    private String nomEnginyer2;
    private String excepcionalitatMeteorologica;
    private Boolean esMostreigSistematic;
    private String observacionsMostreigSistematic;
    private Double percentatgeAmbTreballsGestioAparent;
    private Double percentatgeSenseTreballsGestioAparent;
    private Double percentatgeBoscRegeneracioNatural;
    private Double percentatgeRepoblacioArtificial;
    private Double percentatgePlantacioEspeciesCreixementRapid;
    private List<AfectacioEstimadaDanyAbiotic> afectacionsEstimades;
    private Double grauAfectacioXarxaViaria;
    private List<CausaDecaimentDanyAbiotic> causesDecaiment;
    private Double utmX;
    private Double utmY;
    
    public DanyAbiotic(){
        super("-1", null, "", "");
        afectacionsEstimades = new ArrayList<AfectacioEstimadaDanyAbiotic>();
        causesDecaiment = new ArrayList<CausaDecaimentDanyAbiotic>();
    }

//    public String getCausesDecaimentFormatada(){
//        String causes = "";
//        for(int i=0;i<causesDecaiment.size();i++){
//            causes += causesDecaiment.get(i).toString();
//            if(i<causesDecaiment.size()-1)
//                causes += ", ";
//        }
//        return causes;
//    }
        
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
     * @return the dataApreciacioInicial
     */
    public Date getDataApreciacioInicial() {
        return dataApreciacioInicial;
    }

    /**
     * @param dataApreciacioInicial the dataApreciacioInicial to set
     */
    public void setDataApreciacioInicial(Date dataApreciacioInicial) {
        this.dataApreciacioInicial = dataApreciacioInicial;
    }

    /**
     * @return the dataDadesDefinitives
     */
    public Date getDataDadesDefinitives() {
        return dataDadesDefinitives;
    }

    /**
     * @param dataDadesDefinitives the dataDadesDefinitives to set
     */
    public void setDataDadesDefinitives(Date dataDadesDefinitives) {
        this.dataDadesDefinitives = dataDadesDefinitives;
    }

    /**
     * @return the dataValidacio
     */
    public Date getDataValidacio() {
        return dataValidacio;
    }

    /**
     * @param dataValidacio the dataValidacio to set
     */
    public void setDataValidacio(Date dataValidacio) {
        this.dataValidacio = dataValidacio;
    }

    /**
     * @return the nomEnginyer1
     */
    public String getNomEnginyer1() {
        return nomEnginyer1;
    }

    /**
     * @param nomEnginyer1 the nomEnginyer1 to set
     */
    public void setNomEnginyer1(String nomEnginyer1) {
        this.nomEnginyer1 = nomEnginyer1;
    }

    /**
     * @return the nomEnginyer2
     */
    public String getNomEnginyer2() {
        return nomEnginyer2;
    }

    /**
     * @param nomEnginyer2 the nomEnginyer2 to set
     */
    public void setNomEnginyer2(String nomEnginyer2) {
        this.nomEnginyer2 = nomEnginyer2;
    }

    /**
     * @return the excepcionalitatMeteorologica
     */
    public String getExcepcionalitatMeteorologica() {
        return excepcionalitatMeteorologica;
    }

    /**
     * @param excepcionalitatMeteorologica the excepcionalitatMeteorologica to set
     */
    public void setExcepcionalitatMeteorologica(String excepcionalitatMeteorologica) {
        this.excepcionalitatMeteorologica = excepcionalitatMeteorologica;
    }

    /**
     * @return the esMostreigSistematic
     */
    public Boolean getEsMostreigSistematic() {
        return esMostreigSistematic;
    }

    /**
     * @param esMostreigSistematic the esMostreigSistematic to set
     */
    public void setEsMostreigSistematic(Boolean esMostreigSistematic) {
        this.esMostreigSistematic = esMostreigSistematic;
    }

    public String getEsMostreigSistematicString() {
        if(esMostreigSistematic==null)
            return null;
        if(esMostreigSistematic.booleanValue())
            return "S";
        else
            return "N";
    }

    public void setEsMostreigSistematicString(String esMostreigSistematic) {
        this.esMostreigSistematic = Boolean.valueOf("S".equalsIgnoreCase(esMostreigSistematic));
    }

    /**
     * @return the observacionsMostreigSistematic
     */
    public String getObservacionsMostreigSistematic() {
        return observacionsMostreigSistematic;
    }

    /**
     * @param observacionsMostreigSistematic the observacionsMostreigSistematic to set
     */
    public void setObservacionsMostreigSistematic(String observacionsMostreigSistematic) {
        this.observacionsMostreigSistematic = observacionsMostreigSistematic;
    }

    /**
     * @return the percentatgeAmbTreballsGestioAparent
     */
    public Double getPercentatgeAmbTreballsGestioAparent() {
        return percentatgeAmbTreballsGestioAparent;
    }

    /**
     * @param percentatgeAmbTreballsGestioAparent the percentatgeAmbTreballsGestioAparent to set
     */
    public void setPercentatgeAmbTreballsGestioAparent(Double percentatgeAmbTreballsGestioAparent) {
        this.percentatgeAmbTreballsGestioAparent = percentatgeAmbTreballsGestioAparent;
    }

    /**
     * @return the percentatgeSenseTreballsGestioAparent
     */
    public Double getPercentatgeSenseTreballsGestioAparent() {
        return percentatgeSenseTreballsGestioAparent;
    }

    /**
     * @param percentatgeSenseTreballsGestioAparent the percentatgeSenseTreballsGestioAparent to set
     */
    public void setPercentatgeSenseTreballsGestioAparent(Double percentatgeSenseTreballsGestioAparent) {
        this.percentatgeSenseTreballsGestioAparent = percentatgeSenseTreballsGestioAparent;
    }

    /**
     * @return the percentatgeBoscRegeneracioNatural
     */
    public Double getPercentatgeBoscRegeneracioNatural() {
        return percentatgeBoscRegeneracioNatural;
    }

    /**
     * @param percentatgeBoscRegeneracioNatural the percentatgeBoscRegeneracioNatural to set
     */
    public void setPercentatgeBoscRegeneracioNatural(Double percentatgeBoscRegeneracioNatural) {
        this.percentatgeBoscRegeneracioNatural = percentatgeBoscRegeneracioNatural;
    }

    /**
     * @return the percentatgeRepoblacioArtificial
     */
    public Double getPercentatgeRepoblacioArtificial() {
        return percentatgeRepoblacioArtificial;
    }

    /**
     * @param percentatgeRepoblacioArtificial the percentatgeRepoblacioArtificial to set
     */
    public void setPercentatgeRepoblacioArtificial(Double percentatgeRepoblacioArtificial) {
        this.percentatgeRepoblacioArtificial = percentatgeRepoblacioArtificial;
    }

    /**
     * @return the percentatgePlantacioEspeciesCreixementRapid
     */
    public Double getPercentatgePlantacioEspeciesCreixementRapid() {
        return percentatgePlantacioEspeciesCreixementRapid;
    }

    /**
     * @param percentatgePlantacioEspeciesCreixementRapid the percentatgePlantacioEspeciesCreixementRapid to set
     */
    public void setPercentatgePlantacioEspeciesCreixementRapid(Double percentatgePlantacioEspeciesCreixementRapid) {
        this.percentatgePlantacioEspeciesCreixementRapid = percentatgePlantacioEspeciesCreixementRapid;
    }

    /**
     * @return the grauAfectacioXarxaViaria
     */
    public Double getGrauAfectacioXarxaViaria() {
        return grauAfectacioXarxaViaria;
    }

    /**
     * @param grauAfectacioXarxaViaria the grauAfectacioXarxaViaria to set
     */
    public void setGrauAfectacioXarxaViaria(Double grauAfectacioXarxaViaria) {
        this.grauAfectacioXarxaViaria = grauAfectacioXarxaViaria;
    }

    /**
     * @return the afectacionsEstimades
     */
    public List<AfectacioEstimadaDanyAbiotic> getAfectacionsEstimades() {
        return afectacionsEstimades;
    }

    /**
     * @param afectacionsEstimades the afectacionsEstimades to set
     */
    public void setAfectacionsEstimades(List<AfectacioEstimadaDanyAbiotic> afectacionsEstimades) {
        this.afectacionsEstimades = afectacionsEstimades;
    }

    /**
     * @return the causesDecaiment
     */
    public List<CausaDecaimentDanyAbiotic> getCausesDecaiment() {
        return causesDecaiment;
    }

    /**
     * @param causesDecaiment the causesDecaiment to set
     */
    public void setCausesDecaiment(List<CausaDecaimentDanyAbiotic> causesDecaiment) {
        this.causesDecaiment = causesDecaiment;
    }

    /**
     * @return the utmX
     */
    public Double getUtmX() {
        return utmX;
    }

    /**
     * @param utmX the utmX to set
     */
    public void setUtmX(Double utmX) {
        this.utmX = utmX;
    }

    /**
     * @return the utmY
     */
    public Double getUtmY() {
        return utmY;
    }

    /**
     * @param utmY the utmY to set
     */
    public void setUtmY(Double utmY) {
        this.utmY = utmY;
    }

}
