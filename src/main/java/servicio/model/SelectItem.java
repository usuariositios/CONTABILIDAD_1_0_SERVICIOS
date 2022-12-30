/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Computer
 */
@XmlRootElement
public class SelectItem {
    int codItem = 0;
    String nombreItem = "";

    public SelectItem() {
    }
    
    

    public int getCodItem() {
        return codItem;
    }

    public void setCodItem(int codItem) {
        this.codItem = codItem;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }
    

    public SelectItem(int codItem,String nombreItem) {
        this.codItem = codItem;
        this.nombreItem = nombreItem;
    }
    
    
}
