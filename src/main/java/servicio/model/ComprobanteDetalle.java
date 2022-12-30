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
public class ComprobanteDetalle {
    Comprobante comprobante = new Comprobante();
    int codComprobanteDetalle = 0;
    PlanDeCuentas planDeCuentas = new PlanDeCuentas();
    int codRegional = 0;
    int codProducto = 0;
    int codCentroDeCostos = 0;
    double debe = 0;
    double haber = 0;
    double debeSus = 0;
    double haberSus = 0;
    String glosa = "";
    int codEstadoCuenta = 0;//para reducir codigo de estado de cuentas el comprobante detalle se colecta
    double montoMaximoDebe = 0.0;//para validar el monto maximo
    double montoMaximoHaber = 0.0;//para validar el monto maximo
    

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    public int getCodComprobanteDetalle() {
        return codComprobanteDetalle;
    }

    public void setCodComprobanteDetalle(int codComprobanteDetalle) {
        this.codComprobanteDetalle = codComprobanteDetalle;
    }

    public PlanDeCuentas getPlanDeCuentas() {
        return planDeCuentas;
    }

    public void setPlanDeCuentas(PlanDeCuentas planDeCuentas) {
        this.planDeCuentas = planDeCuentas;
    }

    public int getCodRegional() {
        return codRegional;
    }

    public void setCodRegional(int codRegional) {
        this.codRegional = codRegional;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public int getCodCentroDeCostos() {
        return codCentroDeCostos;
    }

    public void setCodCentroDeCostos(int codCentroDeCostos) {
        this.codCentroDeCostos = codCentroDeCostos;
    }

    public double getDebe() {
        return debe;
    }

    public void setDebe(double debe) {
        this.debe = debe;
    }

    public double getHaber() {
        return haber;
    }

    public void setHaber(double haber) {
        this.haber = haber;
    }

    public double getDebeSus() {
        return debeSus;
    }

    public void setDebeSus(double debeSus) {
        this.debeSus = debeSus;
    }

    public double getHaberSus() {
        return haberSus;
    }

    public void setHaberSus(double haberSus) {
        this.haberSus = haberSus;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public int getCodEstadoCuenta() {
        return codEstadoCuenta;
    }

    public void setCodEstadoCuenta(int codEstadoCuenta) {
        this.codEstadoCuenta = codEstadoCuenta;
    }

    public double getMontoMaximoDebe() {
        return montoMaximoDebe;
    }

    public void setMontoMaximoDebe(double montoMaximoDebe) {
        this.montoMaximoDebe = montoMaximoDebe;
    }

    public double getMontoMaximoHaber() {
        return montoMaximoHaber;
    }

    public void setMontoMaximoHaber(double montoMaximoHaber) {
        this.montoMaximoHaber = montoMaximoHaber;
    }

    
    

    
    
    
    
    
    
    
}
