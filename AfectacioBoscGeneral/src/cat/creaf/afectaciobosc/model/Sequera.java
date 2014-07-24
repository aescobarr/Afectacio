/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cat.creaf.afectaciobosc.model;


import com.vividsolutions.jts.geom.Geometry;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author v.garcia
 */
public class Sequera extends Afectacio {

    private Double coordenadaXPuntObservacio;
    private Double coordenadaYPuntObservacio;
//    private Double coordenadaXIniciTransecte;
//    private Double coordenadaXFiTransecte;
//    private Double coordenadaYIniciTransecte;
//    private Double coordenadaYFiTransecte;
    private Geometry transecte;
    private List<CausaDecaiment> causesDecaiment;
    private List<RegeneracioEspecieForestal> regeneracionsEspeciesForestals;
    private List<AfectacioEstimada> afectacionsEstimades;
    private List<ArbreTransecteSequera> arbresTransecte;;
    private DistribucioArbresAfectats distribucioArbresAfectats;
    private Especie especie1TipusBosc;
    private Especie especie2TipusBosc;
    private Especie especie3TipusBosc;
    private Especie especie1Soca;
    private Especie especie2Soca;
    private Especie especie3Soca;
    private String orientacio;
    private String pendent;
    private String posicioPendent;
    private String disposicioPendent;
    //Gestio forestal
    private TipusBosc tipusBosc;
    private boolean presenciaSoquesRecents;
    private boolean presenciaSoquesAntigues;
    private boolean aclaridaDeMillora;
    private boolean talladaDeRegeneracio;
    private boolean estassada;
    private boolean talladaDeSeleccio;
    private String codiAgent1;
    private String codiAgent2;
    private Integer orientacioFoto;
    
    private String nouOAntic;
    private String arbresNousAfectats;

    private List<Foto> fotos = new ArrayList<Foto>();


    public Sequera(){
        this("-1",null,"","");
    }

    public Sequera(String id,Date data,String codi,String observacions){
        super(id,data,codi,observacions);
        this.causesDecaiment = new ArrayList<CausaDecaiment>();
        this.regeneracionsEspeciesForestals = new ArrayList<RegeneracioEspecieForestal>();
        this.afectacionsEstimades = new ArrayList<AfectacioEstimada>();
        this.arbresTransecte = new ArrayList<ArbreTransecteSequera>();
        this.codiAgent1 = "";
        this.codiAgent2 = "";
        this.coordenadaXPuntObservacio = null;
        this.coordenadaYPuntObservacio = null;
        this.nouOAntic = "A";
        this.arbresNousAfectats = null;
//        this.coordenadaXIniciTransecte = null;
//        this.coordenadaXFiTransecte = null;
//        this.coordenadaYIniciTransecte = null;
//        this.coordenadaYFiTransecte = null;
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
     * @return the regeneracionsEspeciesForestals
     */
    public List<RegeneracioEspecieForestal> getRegeneracionsEspeciesForestals() {
        return regeneracionsEspeciesForestals;
    }

    /**
     * @param regeneracionsEspeciesForestals the regeneracionsEspeciesForestals to set
     */
    public void setRegeneracionsEspeciesForestals(List<RegeneracioEspecieForestal> regeneracionsEspeciesForestals) {
        this.regeneracionsEspeciesForestals = regeneracionsEspeciesForestals;
    }

    /**
     * @return the afectacionsEstimades
     */
    public List<AfectacioEstimada> getAfectacionsEstimades() {
        return afectacionsEstimades;
    }

    /**
     * @param afectacionsEstimades the afectacionsEstimades to set
     */
    public void setAfectacionsEstimades(List<AfectacioEstimada> afectacionsEstimades) {
        this.afectacionsEstimades = afectacionsEstimades;
    }

    /**
     * @return the especie1TipusBosc
     */
    public Especie getEspecie1TipusBosc() {
        return especie1TipusBosc;
    }

    /**
     * @param especie1TipusBosc the especie1TipusBosc to set
     */
    public void setEspecie1TipusBosc(Especie especie1TipusBosc) {
        this.especie1TipusBosc = especie1TipusBosc;
    }

    /**
     * @return the especie2TipusBosc
     */
    public Especie getEspecie2TipusBosc() {
        return especie2TipusBosc;
    }

    /**
     * @param especie2TipusBosc the especie2TipusBosc to set
     */
    public void setEspecie2TipusBosc(Especie especie2TipusBosc) {
        this.especie2TipusBosc = especie2TipusBosc;
    }

    /**
     * @return the especie3TipusBosc
     */
    public Especie getEspecie3TipusBosc() {
        return especie3TipusBosc;
    }

    /**
     * @param especie3TipusBosc the especie3TipusBosc to set
     */
    public void setEspecie3TipusBosc(Especie especie3TipusBosc) {
        this.especie3TipusBosc = especie3TipusBosc;
    }

    /**
     * @return the especie1Soca
     */
    public Especie getEspecie1Soca() {
        return especie1Soca;
    }

    /**
     * @param especie1Soca the especie1Soca to set
     */
    public void setEspecie1Soca(Especie especie1Soca) {
        this.especie1Soca = especie1Soca;
    }

    /**
     * @return the especie2Soca
     */
    public Especie getEspecie2Soca() {
        return especie2Soca;
    }

    /**
     * @param especie2Soca the especie2Soca to set
     */
    public void setEspecie2Soca(Especie especie2Soca) {
        this.especie2Soca = especie2Soca;
    }

    /**
     * @return the especie3Soca
     */
    public Especie getEspecie3Soca() {
        return especie3Soca;
    }

    /**
     * @param especie3Soca the especie3Soca to set
     */
    public void setEspecie3Soca(Especie especie3Soca) {
        this.especie3Soca = especie3Soca;
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
     * @return the orientacio
     */
    public String getOrientacio() {
        return orientacio;
    }

    /**
     * @param orientacio the orientacio to set
     */
    public void setOrientacio(String orientacio) {
        this.orientacio = orientacio;
    }

    /**
     * @return the pendent
     */
    public String getPendent() {
        return pendent;
    }

    /**
     * @param pendent the pendent to set
     */
    public void setPendent(String pendent) {
        this.pendent = pendent;
    }

    /**
     * @return the posicioPendent
     */
    public String getPosicioPendent() {
        return posicioPendent;
    }

    /**
     * @param posicioPendent the posicioPendent to set
     */
    public void setPosicioPendent(String posicioPendent) {
        this.posicioPendent = posicioPendent;
    }

    /**
     * @return the disposicioPendent
     */
    public String getDisposicioPendent() {
        return disposicioPendent;
    }

    /**
     * @param disposicioPendent the disposicioPendent to set
     */
    public void setDisposicioPendent(String disposicioPendent) {
        this.disposicioPendent = disposicioPendent;
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
     * @return the presenciaSoquesRecents
     */
    public boolean getPresenciaSoquesRecents() {
        return presenciaSoquesRecents;
    }

    /**
     * @param presenciaSoquesRecents the presenciaSoquesRecents to set
     */
    public void setPresenciaSoquesRecents(boolean presenciaSoquesRecents) {
        this.presenciaSoquesRecents = presenciaSoquesRecents;
    }

    /**
     * @return the presenciaSoquesAntigues
     */
    public boolean getPresenciaSoquesAntigues() {
        return presenciaSoquesAntigues;
    }

    /**
     * @param presenciaSoquesAntigues the presenciaSoquesAntigues to set
     */
    public void setPresenciaSoquesAntigues(boolean presenciaSoquesAntigues) {
        this.presenciaSoquesAntigues = presenciaSoquesAntigues;
    }

    public String getPresenciaSoquesRecentsString() {
        if(presenciaSoquesRecents)
            return "S";
        else
            return "N";
    }

    public void setPresenciaSoquesRecentsString(String presenciaSoquesRecents) {
        this.presenciaSoquesRecents = "S".equals(presenciaSoquesRecents);
    }

    public String getPresenciaSoquesAntiguesString() {
        if(presenciaSoquesAntigues)
            return "S";
        else
            return "N";
    }

    public void setPresenciaSoquesAntiguesString(String presenciaSoquesAntigues) {
        this.presenciaSoquesAntigues = "S".equals(presenciaSoquesAntigues);
    }

    public String getTreballsSilvicolesString(){
        Locale localCAT = new Locale("ca","ES");
        ResourceBundle bundle = ResourceBundle.getBundle("cat.creaf.afectaciobosc.literals.AfectacioBosc",localCAT);
        String treballs = "";
        if(this.aclaridaDeMillora)
            treballs += bundle.getString("aclaridaMillora");
        if(this.estassada || this.talladaDeRegeneracio || this.talladaDeSeleccio)
            treballs += ", ";
        if(this.estassada)
            treballs += bundle.getString("estassadaSotabosc");
        if(this.talladaDeRegeneracio)
            treballs += ", ";
        if(this.talladaDeRegeneracio)
            treballs += bundle.getString("talladaRegeneracio");
        if(this.talladaDeSeleccio)
            treballs += ", ";
        if(this.talladaDeSeleccio)
            treballs += bundle.getString("talladaSeleccio");
        return treballs;
    }

    /**
     * @return the aclaridaDeMillora
     */
    public boolean getAclaridaDeMillora() {
        return aclaridaDeMillora;
    }

    /**
     * @param aclaridaDeMillora the aclaridaDeMillora to set
     */
    public void setAclaridaDeMillora(boolean aclaridaDeMillora) {
        this.aclaridaDeMillora = aclaridaDeMillora;
    }

    public String getAclaridaDeMilloraString() {
        if(aclaridaDeMillora)
            return "S";
        else
            return "N";
    }

    public void setAclaridaDeMilloraString(String aclaridaDeMillora) {
        this.aclaridaDeMillora = "S".equals(aclaridaDeMillora);
    }

    /**
     * @return the talladaDeRegeneracio
     */
    public boolean getTalladaDeRegeneracio() {
        return talladaDeRegeneracio;
    }

    /**
     * @param talladaDeRegeneracio the talladaDeRegeneracio to set
     */
    public void setTalladaDeRegeneracio(boolean talladaDeRegeneracio) {
        this.talladaDeRegeneracio = talladaDeRegeneracio;
    }

    public String getTalladaDeRegeneracioString() {
        if(talladaDeRegeneracio)
            return "S";
        else
            return "N";
    }

    public void setTalladaDeRegeneracioString(String talladaDeRegeneracio) {
        this.talladaDeRegeneracio = "S".equals(talladaDeRegeneracio);
    }

    public boolean getEstassada() {
        return estassada;
    }

    /**
     * @param estassada the estassada to set
     */
    public void setEstassada(boolean estassada) {
        this.estassada = estassada;
    }

    public String getEstassadaString() {
        if(estassada)
            return "S";
        else
            return "N";
    }

    public void setEstassadaString(String estassada) {
        this.estassada = "S".equals(estassada);
    }

    /**
     * @return the talladaDeSeleccio
     */
    public boolean getTalladaDeSeleccio() {
        return talladaDeSeleccio;
    }

    /**
     * @param talladaDeSeleccio the talladaDeSeleccio to set
     */
    public void setTalladaDeSeleccio(boolean talladaDeSeleccio) {
        this.talladaDeSeleccio = talladaDeSeleccio;
    }

    public String getTalladaDeSeleccioString() {
        if(talladaDeSeleccio)
            return "S";
        else
            return "N";
    }

    public void setTalladaDeSeleccioString(String talladaDeSeleccio) {
        this.talladaDeSeleccio = "S".equals(talladaDeSeleccio);
    }

    /**
     * @return the arbresTransecte
     */
    public List<ArbreTransecteSequera> getArbresTransecte() {
        return arbresTransecte;
    }

    /**
     * @param arbresTransecte the arbresTransecte to set
     */
    public void setArbresTransecte(List<ArbreTransecteSequera> arbresTransecte) {
        this.arbresTransecte = arbresTransecte;
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
     * @return the coordenadaXPuntObservacio
     */
    public Double getCoordenadaXPuntObservacio() {
        return coordenadaXPuntObservacio;
    }

    /**
     * @param coordenadaXPuntObservacio the coordenadaXPuntObservacio to set
     */
    public void setCoordenadaXPuntObservacio(Double coordenadaXPuntObservacio) {
        this.coordenadaXPuntObservacio = coordenadaXPuntObservacio;
    }

    /**
     * @return the coordenadaYPuntObservacio
     */
    public Double getCoordenadaYPuntObservacio() {
        return coordenadaYPuntObservacio;
    }

    /**
     * @param coordenadaYPuntObservacio the coordenadaYPuntObservacio to set
     */
    public void setCoordenadaYPuntObservacio(Double coordenadaYPuntObservacio) {
        this.coordenadaYPuntObservacio = coordenadaYPuntObservacio;
    }
    
    public Double getCoordenadaXIniciTransecte() {
        Double coordenada = null;
        if(transecte!=null){
            coordenada = new Double(transecte.getCoordinates()[0].x);
        }
        return coordenada;
    }
//
//    public void setCoordenadaXIniciTransecte(Double coordenadaXIniciTransecte) {
//        this.coordenadaXIniciTransecte = coordenadaXIniciTransecte;
//    }
//
    public Double getCoordenadaXFiTransecte() {
        Double coordenada = null;
        if(transecte!=null){
            coordenada = new Double(transecte.getCoordinates()[1].x);
        }
        return coordenada;
    }
//
//    public void setCoordenadaXFiTransecte(Double coordenadaXFiTransecte) {
//        this.coordenadaXFiTransecte = coordenadaXFiTransecte;
//    }

    public Double getCoordenadaYIniciTransecte() {
        Double coordenada = null;
        if(transecte!=null){
            coordenada = new Double(transecte.getCoordinates()[0].y);
        }
        return coordenada;
    }
//
//    public void setCoordenadaYIniciTransecte(Double coordenadaYIniciTransecte) {
//        this.coordenadaYIniciTransecte = coordenadaYIniciTransecte;
//    }

    public Double getCoordenadaYFiTransecte() {
        Double coordenada = null;
        if(transecte!=null){
            coordenada = new Double(transecte.getCoordinates()[1].y);
        }
        return coordenada;
    }
//    public void setCoordenadaYFiTransecte(Double coordenadaYFiTransecte) {
//        this.coordenadaYFiTransecte = coordenadaYFiTransecte;
//    }

    /**
     * @return the transecte
     */
    public Geometry getTransecte() {
        return transecte;
    }

    /**
     * @param transecte the transecte to set
     */
    public void setTransecte(Geometry transecte) {
        this.transecte = transecte;
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
    
    public List getFotos() {
        return fotos;
    }

    public void setFotos(List fotos) {
        this.fotos = fotos;
    }

    /**
     * @return the nouOAntic
     */
    public String getNouOAntic() {
        return nouOAntic;
    }

    /**
     * @param nouOAntic the nouOAntic to set
     */
    public void setNouOAntic(String nouOAntic) {
        this.nouOAntic = nouOAntic;
    }

    /**
     * @return the arbresNousAfectats
     */
    public String getArbresNousAfectats() {
        return arbresNousAfectats;
    }

    /**
     * @param arbresNousAfectats the arbresNousAfectats to set
     */
    public void setArbresNousAfectats(String arbresNousAfectats) {
        this.arbresNousAfectats = arbresNousAfectats;
    }
}
