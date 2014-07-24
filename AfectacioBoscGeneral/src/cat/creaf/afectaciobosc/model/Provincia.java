/*
 * Provincia.java
 *
 * Created on 18 de abril de 2005, 13:39
 */

package cat.creaf.afectaciobosc.model;
import MSIPANBasicObj.ObjecteSIPAN;
import cat.creaf.sipan.MGeometriaWrapper.GeometriaWrapper;
import java.util.ArrayList;
/**
 *
 * @author arnald
 */
public class Provincia extends ObjecteSIPAN {
        
    private String nom = null;
    private int codi;
    private ArrayList<Comarca> comarques;
//    private Geometria cartografia;
    private GeometriaWrapper cartografia;
    
    public Provincia(String id,int codi,String nom) {
        this.setIdString(id);
        this.setNom(nom);
        this.setCodi(codi);
        comarques = new ArrayList<Comarca>();
    }
       
    public Provincia(String id){
        setIdString(id);
        comarques = new ArrayList<Comarca>();
    }
    
    public Provincia(){
        this("-1");
    }
    
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    @Override
    public String toString(){return this.nom;}
    
    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public Object clone() {
        return null;
    }

    public ArrayList getDadesBasiquesPerTaula() {
        return null;
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

    public ArrayList<Municipi> getMunicipisAmbit() {
        ArrayList<Municipi> retVal = new ArrayList<Municipi>();
        for (int i = 0; i < comarques.size(); i++) {
            Comarca c = (Comarca)comarques.get(i);
            retVal.addAll(c.getMunicipisAmbit());
        }
        return retVal;
    }
    
    public ArrayList<Comarca> getComarques() {
        return comarques;
    }

    public void setComarques(ArrayList<Comarca> comarques) {
        this.comarques = comarques;
    }
    
//    public Geometria getCartografia() {
//        return cartografia;
//    }
//
//    public void setCartografia(Geometria cartografia) {
//        this.cartografia = cartografia;
//    }

    public GeometriaWrapper getGeometria() {
        return cartografia;
    }

    public void setGeometria(GeometriaWrapper geometriaWrapper) {
        this.cartografia = geometriaWrapper;
    }
}
