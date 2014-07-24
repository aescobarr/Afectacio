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
public class GrauInfestacio extends ObjecteSIPAN {

    private String grau;

    public GrauInfestacio(){
        this("","");
    }

    public GrauInfestacio(String id,String grau){
        super(id);
        this.grau = grau;
    }

    /**
     * @return the grau
     */
    public String getGrau() {
        return grau;
    }

    /**
     * @param grau the grau to set
     */
    public void setGrau(String grau) {
        this.grau = grau;
    }

    @Override
    public String toString() {
        return this.grau;
    }


}
