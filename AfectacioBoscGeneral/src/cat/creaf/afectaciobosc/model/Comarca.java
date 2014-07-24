/*
 * Comarca.java
 *
 * Created on 18 de abril de 2005, 13:39
 */

package cat.creaf.afectaciobosc.model;
import MSIPANBasicObj.ObjecteSIPAN;
import cat.creaf.sipan.MGeometriaWrapper.GeometriaWrapper;
import java.util.*;
import java.util.ArrayList;

/**
 *
 * @author arnald
 */
public class Comarca extends ObjecteSIPAN {
    
    private String nom = null;
    private String codiComarca;
    private ArrayList municipis = null;
//    private Geometria cartografia;  
    private ArrayList<Provincia> provincies;

    private GeometriaWrapper cartografia;
    
    /** Creates a new instance of Comarca */
    public Comarca() {
        setIdString("-1");
        municipis = new ArrayList();
        provincies = new ArrayList<Provincia>();
    }
    
    public Comarca(String id,String codi,String nom) {
        this.setIdString(id);
        this.setCodiComarca(codi);
        this.setNom(nom);
        municipis = new ArrayList();
        provincies = new ArrayList<Provincia>();
    }
    
    public Comarca(String id) {
        setIdString(id);
        municipis = new ArrayList();
        provincies = new ArrayList<Provincia>();
    }
       
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    
    public ArrayList getMunicipis() {
        return municipis;
    }

    public void setMunicipis(ArrayList municipis) {
        this.municipis = municipis;
    }
    
    @Override
    public String toString(){return this.nom;}

//    public Geometria getCartografia() {
//        return cartografia;
//    }
//
//    public void setCartografia(Geometria cartografia) {
//        this.cartografia = cartografia;
//    }

    public Object clone() {
        return null;
    }

    public ArrayList getDadesBasiquesPerTaula() {
        ArrayList dades = new ArrayList();
        dades.add(this);
        return dades;
    }

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

    public List<Provincia> getProvincies() {
        return provincies;
    }

    public void setProvincies(List<Provincia> provincia) {
        this.provincies = new ArrayList(provincia);
    }
    
    public ArrayList<Provincia> getProvincia() {
        return provincies;
    }

    public void setProvincia(ArrayList<Provincia> provincia) {
        this.provincies = provincia;
    }

    public String getCodiComarca() {
        return codiComarca;
    }

    public void setCodiComarca(String codiComarca) {
        this.codiComarca = codiComarca;
    }

    public ArrayList<Municipi> getMunicipisAmbit() {
        return municipis;
    }

    public Object getPare() {
        return provincies;
    }

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
