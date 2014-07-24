/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.creaf.afectaciobosc.model;

import MSIPANBasicObj.ObjecteSIPAN;


public class Foto extends ObjecteSIPAN {

    
    private String titol;
    private String observacions;
    private String nomOriginal;
    private int mida;


    private byte[] thumbnailEnBytes;
    private byte[] fitxerEnBytes;
    
    byte[] image;
    
    private Afectacio afectacio;
    
    public Foto(){
        super("-1");
    }

    public Foto(String id){
        super(id);
    }

//    @Override
    public String getTitol() {
        return titol;
    }

//    @Override
    public void setTitol(String titol) {
        this.titol = titol;
    }

//    @Override
    public String getObservacions() {
        return observacions;
    }

//    @Override
    public void setObservacions(String observacions) {
        this.observacions = observacions;
        if (this.observacions == null) {
            this.observacions = "";
        }
    }

    @Override
    public String toString() {
        return this.getTitol();
    }

    public String getNomExtensio() {
        String extensio = "";
        if(this.nomOriginal!=null && this.nomOriginal.indexOf(".")>0 &&
                this.nomOriginal.lastIndexOf(".")+1<this.nomOriginal.length()){
            extensio = this.nomOriginal.substring(this.nomOriginal.lastIndexOf(".")+1);
        }
        return extensio;
    }

//    @Override
    public byte[] getThumbnailEnBytes() {
        return thumbnailEnBytes;
    }

    /**
     * @param thumbnail the thumbnail to set
     */
//    @Override
    public void setThumbnailEnBytes(byte[] thumbnailEnBytes) {
        this.thumbnailEnBytes = thumbnailEnBytes;
    }

//    @Override
    public byte[] getFitxerEnBytes() {
        return fitxerEnBytes;
    }

    /**
     * @param fitxer the fitxer to set
     */
//    @Override
    public void setFitxerEnBytes(byte[] fitxerEnBytes) {
        this.fitxerEnBytes = fitxerEnBytes;
    }
        
    @Override
    public void setIdString(String idDocument) {
        super.setIdString(idDocument);
    }

    public int getMida() {
        return mida;
    }

    public void setMida(int mida) {
        this.mida = mida;
    }

    /**
     * @return the afectacio
     */
    public Afectacio getAfectacio() {
        return afectacio;
    }

    /**
     * @param afectacio the afectacio to set
     */
    public void setAfectacio(Afectacio afectacio) {
        this.afectacio = afectacio;
    }

    /**
     * @return the nomOriginal
     */
    public String getNomOriginal() {
        return nomOriginal;
    }

    /**
     * @param nomOriginal the nomOriginal to set
     */
    public void setNomOriginal(String nomOriginal) {
        this.nomOriginal = nomOriginal;
    }
}