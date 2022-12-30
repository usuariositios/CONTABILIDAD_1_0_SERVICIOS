/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author henry
 */
@XmlRootElement
public class Monedas extends bean {
    int codMoneda = 0;
    String nombreMoneda = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodMoneda() {
        return codMoneda;
    }

    public void setCodMoneda(int codMoneda) {
        this.codMoneda = codMoneda;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
    
    
}
