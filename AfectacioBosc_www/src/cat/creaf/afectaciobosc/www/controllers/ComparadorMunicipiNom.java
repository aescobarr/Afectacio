/*
 * ComparadorMunicipiNom.java
 *
 * Created on 16 de noviembre de 2006, 14:47
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cat.creaf.afectaciobosc.www.controllers;


import MSIPANGeneral.ComparadorES;
import cat.creaf.afectaciobosc.model.Municipi;

/**
 *
 * @author v.garcia
 */
public class ComparadorMunicipiNom extends ComparadorES{
    
    /** Creates a new instance of ComparadorMunicipiNom */
    public ComparadorMunicipiNom() {
    }

    public int compare(Object o1, Object o2) {
        Municipi m1 = (Municipi)o1;
        Municipi m2 = (Municipi)o2;
        if(m1==null && m2==null)
            return 0;
        else if(m1==null && m2!=null)
            return 1;
        else if(m1!=null && m2==null)
            return -1;
        return comparar(m1.getNom(),m2.getNom());
    }    
}
