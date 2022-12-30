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
public class EstadoDeCuenta {
    int codEstadoCuenta = 0;
    TiposEstadoDeCuentas tipoEstadoCuenta = new TiposEstadoDeCuentas();
    ComprobanteDetalle comprobanteDetalle = new ComprobanteDetalle();
    Double montoBS = 0.0;
    Double montoSUS = 0.0;
    Double montoPagadoBS = 0.0;
    Double montoPagadoSUS = 0.0;
    Double montoFaltanteBS = 0.0;
    Double montoFaltanteSUS = 0.0;
    
    
    
    

    public int getCodEstadoCuenta() {
        return codEstadoCuenta;
    }

    public void setCodEstadoCuenta(int codEstadoCuenta) {
        this.codEstadoCuenta = codEstadoCuenta;
    }

    public TiposEstadoDeCuentas getTipoEstadoCuenta() {
        return tipoEstadoCuenta;
    }

    public void setTipoEstadoCuenta(TiposEstadoDeCuentas tipoEstadoCuenta) {
        this.tipoEstadoCuenta = tipoEstadoCuenta;
    }

   
    
    public ComprobanteDetalle getComprobanteDetalle() {
        return comprobanteDetalle;
    }

    public void setComprobanteDetalle(ComprobanteDetalle comprobanteDetalle) {
        this.comprobanteDetalle = comprobanteDetalle;
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

    public Double getMontoPagadoBS() {
        return montoPagadoBS;
    }

    public void setMontoPagadoBS(Double montoPagadoBS) {
        this.montoPagadoBS = montoPagadoBS;
    }

    public Double getMontoPagadoSUS() {
        return montoPagadoSUS;
    }

    public void setMontoPagadoSUS(Double montoPagadoSUS) {
        this.montoPagadoSUS = montoPagadoSUS;
    }

    public Double getMontoFaltanteBS() {
        return montoFaltanteBS;
    }

    public void setMontoFaltanteBS(Double montoFaltanteBS) {
        this.montoFaltanteBS = montoFaltanteBS;
    }

    public Double getMontoFaltanteSUS() {
        return montoFaltanteSUS;
    }

    public void setMontoFaltanteSUS(Double montoFaltanteSUS) {
        this.montoFaltanteSUS = montoFaltanteSUS;
    }

  
    
    
    
}
