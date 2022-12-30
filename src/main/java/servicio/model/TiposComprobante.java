/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Computer
 */
@XmlRootElement
public class TiposComprobante extends bean{
    int codTipoComprobante = 0;
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    String nombreTipoComprobante = "";
    String obsTipoComprobante = "";
    String abreviatura = "";

    public int getCodTipoComprobante() {
        return codTipoComprobante;
    }

    public void setCodTipoComprobante(int codTipoComprobante) {
        this.codTipoComprobante = codTipoComprobante;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public String getNombreTipoComprobante() {
        return nombreTipoComprobante;
    }

    public void setNombreTipoComprobante(String nombreTipoComprobante) {
        this.nombreTipoComprobante = nombreTipoComprobante;
    }

    public String getObsTipoComprobante() {
        return obsTipoComprobante;
    }

    public void setObsTipoComprobante(String obsTipoComprobante) {
        this.obsTipoComprobante = obsTipoComprobante;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }
    
    
    
    
    
}
