/*
 * Municipi.java
 *
 * Created on 18 de abril de 2005, 13:39
 */

package cat.creaf.afectaciobosc.model;
import MSIPANBasicObj.ObjecteSIPAN;
import cat.creaf.sipan.MGeometriaWrapper.GeometriaWrapper;
import java.util.*;
import java.util.ArrayList;


/**
 * v1.0 @author v.garcia
 * Adabtaci� a Orientaci� a Objectes
 */
/**
 *
 * @author arnald
 */
public class Municipi  extends ObjecteSIPAN {
    private String idMunicipi = null;
    private String codiINE = null;
    private String nom = null;
    private Date data = null;
    private double areaReal = -1;
    private double areaOficial = -1;
    private Comarca comarca;
    private Provincia provincia;
    
//    private Geometria cartografia;
    private GeometriaWrapper cartografia;

    
    /** Creates a new instance of Municipi */
    public Municipi() 
    {
        this.setIdString("-1");
        this.setComarca(null);
        this.setProvincia(null);
    }
    
    public Municipi(String idMunicipi) 
    {
        this.setIdString(idMunicipi);
        this.setComarca(null);
        this.setProvincia(null);
    }
    public Municipi(String idMunicipi, String codiINE, Date data, String nom, double areaReal, double areaOficial,Comarca comarca,Provincia provincia) {        
        this.setIdString(idMunicipi);
        this.setCodiINE(codiINE);
        this.setNom(nom);
        this.setAreaReal(areaReal);
        this.setAreaOficial(areaOficial);
        this.setData(data);
        this.setComarca(comarca);
        this.setProvincia(provincia);
    }
    public Municipi(String codiINE, Date data, String nom, double areaReal, double areaOficial,Comarca comarca,Provincia provincia) {
        this.setCodiINE(codiINE);
        this.setNom(nom);
        this.setAreaReal(areaReal);
        this.setAreaOficial(areaOficial);
        this.setData(data);
        this.setComarca(comarca);
        this.setProvincia(provincia);
    }
    public Municipi(String idMunicipi, String codiINE, Date data, String nom){
        this.setIdString(idMunicipi);
        this.setCodiINE(codiINE);
        this.setNom(nom);
        this.setData(data);
        this.setComarca(null);
        this.setProvincia(null);
    }
    public Municipi(String codiINE, Date data, String nom){
        this.setCodiINE(codiINE);
        this.setNom(nom);
        this.setData(data);
        this.setComarca(null);
        this.setProvincia(null);
    }
        
    public String getCodiINE() {
        return codiINE;
    }
    
    public void setCodiINE(String codiINE) {
        this.codiINE = codiINE;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public double getAreaReal() {
        return areaReal;
    }
    
    public void setAreaReal(double areaReal) {
        this.areaReal = areaReal;
    }
    
    public Comarca getComarca() {
        return comarca;
    }
    
    public void setComarca(Comarca comarca) {
        this.comarca = comarca;
    }
    
    public Provincia getProvincia() {
        return provincia;
    }
    
    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
    
    public double getAreaOficial() {
        return areaOficial;
    }
    
    public void setAreaOficial(double areaOficial) {
        this.areaOficial = areaOficial;
    }
    
    public Date getData() {
        return data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }
    
    @Override
    public String toString(){return this.nom;}

    @Override
    public String getIdString()
    {
        return idMunicipi;
    }

    @Override
    public void setIdString(String idMunicipi)
    {
        this.idMunicipi = idMunicipi;
    }

    @Override
    public Object clone() {
        return null;
    }

    @Override
    public ArrayList getDadesBasiquesPerTaula() {
        return null;
    }

    @Override
    public String[] getTitolsPerTaula() {
        return null;
    }

    @Override
    public void save(Object o) {
    }

    @Override
    public String missatgeError() {
        return null;
    }

    public ArrayList<Municipi> getMunicipisAmbit() {
        ArrayList<Municipi> retVal = new ArrayList<Municipi>();
        retVal.add(this);
        return retVal;
    }

//    public Geometria getCartografia() {
//        return cartografia;
//    }
//
//    public void setCartografia(Geometria cartografia) {
//        this.cartografia = cartografia;
//    }

    /**
     * @return the minX
     */
    public double getMinX() {
        if(this.cartografia==null || this.cartografia.getMinX()==null)
            return -1;
        return this.cartografia.getMinX().doubleValue();
    }

    public double getMaxX() {
        if(this.cartografia==null || this.cartografia.getMaxX()==null)
            return -1;
        return this.cartografia.getMaxX().doubleValue();
    }

    public double getMinY() {
        if(this.cartografia==null || this.cartografia.getMinY()==null)
            return -1;
        return this.cartografia.getMinY().doubleValue();
    }

    public double getMaxY() {
        if(this.cartografia==null || this.cartografia.getMaxY()==null)
            return -1;
        return this.cartografia.getMaxY().doubleValue();
    }

    public GeometriaWrapper getGeometria() {
        return cartografia;
    }

    public void setGeometria(GeometriaWrapper geometriaWrapper) {
        this.cartografia = geometriaWrapper;
    }
    
}
