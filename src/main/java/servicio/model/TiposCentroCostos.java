/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author Computer
 */
public class TiposCentroCostos {
    int codTipoCentroCostos = 0;
    String nombreTipoCentroCostos = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodTipoCentroCostos() {
        return codTipoCentroCostos;
    }

    public void setCodTipoCentroCostos(int codTipoCentroCostos) {
        this.codTipoCentroCostos = codTipoCentroCostos;
    }

    public String getNombreTipoCentroCostos() {
        return nombreTipoCentroCostos;
    }

    public void setNombreTipoCentroCostos(String nombreTipoCentroCostos) {
        this.nombreTipoCentroCostos = nombreTipoCentroCostos;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
    
}
