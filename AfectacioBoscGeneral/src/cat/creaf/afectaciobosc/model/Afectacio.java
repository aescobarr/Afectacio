/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.creaf.afectaciobosc.model;

import Dates.AritmeticaDates;
import MSIPANBasicObj.ObjecteSIPAN;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.WKTWriter;
import java.util.Date;

/**
 *
 * @author v.garcia
 */
public class Afectacio extends ObjecteSIPAN {

    private Date data;
    private String codi;
    private String observacions;
    private Geometry areaAfectada;
    private String areaAfectadaWtk;
    private Comarca comarca;

    public Afectacio() {
        this("-1", new Date(), "", "");
    }

    public Afectacio(String id, Date data, String codi, String observacions) {
        super(id);
        this.data = data;
        this.codi = codi;
        this.observacions = observacions;
    }

    @Override
    public void save(Object o) {
        Afectacio backingObject = (Afectacio) o;
        setCodi(backingObject.getCodi());
        setData(backingObject.getData());
        setObservacions(backingObject.getObservacions());
        setComarca(backingObject.getComarca());
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    public String getDataFormatada() {
        String sData = "";
        if(data!=null)
            sData = AritmeticaDates.transformar(data);
        return sData;
    }

    /**
     * @return the codi
     */
    public String getCodi() {
        return codi;
    }

    /**
     * @param codi the codi to set
     */
    public void setCodi(String codi) {
        this.codi = codi;
    }

    /**
     * @return the observacions
     */
    public String getObservacions() {
        return observacions;
    }

    /**
     * @param observacions the observacions to set
     */
    public void setObservacions(String observacions) {
        this.observacions = observacions;
    }

    @Override
    public String toString() {
        String s = "";
        if(this.data!=null){
            s += this.data;
        }
        s += this.codi;
        return s;
    }

    /**
     * @return the areaAfectada
     */
    public Geometry getAreaAfectada() {
        return areaAfectada;
    }
    

    /**
     * @param areaAfectada the areaAfectada to set
     */
    public void setAreaAfectada(Geometry areaAfectada) {
        if(areaAfectada!=null){
            WKTWriter writer = new WKTWriter();
            areaAfectadaWtk = writer.write(areaAfectada);
        }
        this.areaAfectada = areaAfectada;
    }

    /**
     * @return the areaAfectadaWtk
     */
    public String getAreaAfectadaWtk() {
        return areaAfectadaWtk;
    }

    /**
     * @return the comarca
     */
    public Comarca getComarca() {
        return comarca;
    }

    /**
     * @param comarca the comarca to set
     */
    public void setComarca(Comarca comarca) {
        this.comarca = comarca;
    }
}
