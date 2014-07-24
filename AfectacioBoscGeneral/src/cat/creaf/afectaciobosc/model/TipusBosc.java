/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cat.creaf.afectaciobosc.model;

import MSIPANBasicObj.ObjecteSIPAN;

/**
 *
 * @author v.garcia
 */
public class TipusBosc extends ObjecteSIPAN {
    private String tipus;

    public TipusBosc(){
        this("","");
    }

    public TipusBosc(String id,String tipus){
        super(id);
        this.tipus = tipus;
    }

    /**
     * @return the tipus
     */
    public String getTipus() {
        return tipus;
    }

    /**
     * @param tipus the tipus to set
     */
    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    @Override
    public String toString() {
        return this.tipus;
    }


}
