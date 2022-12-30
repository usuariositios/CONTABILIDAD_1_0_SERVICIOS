/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author COMPUTER
 */
public class EstadoDeCuentasRelacionadas {
    int codEstadoDeCuentasRelacionada = 0;
    EstadoDeCuenta estadoDeCuenta = new EstadoDeCuenta();
    Double montoBS = 0.0;
    Double montoSUS = 0.0;
    int codComprobante = 0;
    int codPlanCuenta = 0;
    int codRegional = 0;
    int codLinea = 0;
    int codProducto = 0;
    int codCentroCostos = 0;
    int codComprobanteDetalle = 0;
    int codGestion = 0;

    public int getCodEstadoDeCuentasRelacionada() {
        return codEstadoDeCuentasRelacionada;
    }

    public void setCodEstadoDeCuentasRelacionada(int codEstadoDeCuentasRelacionada) {
        this.codEstadoDeCuentasRelacionada = codEstadoDeCuentasRelacionada;
    }

    public EstadoDeCuenta getEstadoDeCuenta() {
        return estadoDeCuenta;
    }

    public void setEstadoDeCuenta(EstadoDeCuenta estadoDeCuenta) {
        this.estadoDeCuenta = estadoDeCuenta;
    }

    public Double getMontoBS() {
        return montoBS;
    }

    public void setMontoBS(Double montoBS) {
        this.montoBS = montoBS;
    }

    public Double getMontoSUS() {
        return montoSUS;
    }

    public void setMontoSUS(Double montoSUS) {
        this.montoSUS = montoSUS;
    }

    public int getCodComprobante() {
        return codComprobante;
    }

    public void setCodComprobante(int codComprobante) {
        this.codComprobante = codComprobante;
    }

    public int getCodPlanCuenta() {
        return codPlanCuenta;
    }

    public void setCodPlanCuenta(int codPlanCuenta) {
        this.codPlanCuenta = codPlanCuenta;
    }

    public int getCodRegional() {
        return codRegional;
    }

    public void setCodRegional(int codRegional) {
        this.codRegional = codRegional;
    }

    public int getCodLinea() {
        return codLinea;
    }

    public void setCodLinea(int codLinea) {
        this.codLinea = codLinea;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public int getCodCentroCostos() {
        return codCentroCostos;
    }

    public void setCodCentroCostos(int codCentroCostos) {
        this.codCentroCostos = codCentroCostos;
    }

    public int getCodComprobanteDetalle() {
        return codComprobanteDetalle;
    }

    public void setCodComprobanteDetalle(int codComprobanteDetalle) {
        this.codComprobanteDetalle = codComprobanteDetalle;
    }

    public int getCodGestion() {
        return codGestion;
    }

    public void setCodGestion(int codGestion) {
        this.codGestion = codGestion;
    }
    
    
    
    
    
}
