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
public class Comprobante extends bean {
    int codComprobante = 0;
    int nroComprobante = 0;
    Empresas empresas = new Empresas();
    Gestion gestion = new Gestion();
    Monedas monedas = new Monedas();
    Personal personal = new Personal();
    EstadosComprobante estadosComprobante = new EstadosComprobante();
    TiposComprobante tiposComprobante = new TiposComprobante();
    String fechaComprobante = "";
    String nroCheque = "";
    String nroFactura = "";
    String glosa ="";
    String fechaSistema = "";
    String fechaInicio = "";
    String fechaFinal = "";
    String descrMontoTotal = "";

    public int getCodComprobante() {
        return codComprobante;
    }

    public void setCodComprobante(int codComprobante) {
        this.codComprobante = codComprobante;
    }

    public int getNroComprobante() {
        return nroComprobante;
    }

    public void setNroComprobante(int nroComprobante) {
        this.nroComprobante = nroComprobante;
    }

    public Empresas getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }

    public Gestion getGestion() {
        return gestion;
    }

    public void setGestion(Gestion gestion) {
        this.gestion = gestion;
    }

    public Monedas getMonedas() {
        return monedas;
    }

    public void setMonedas(Monedas monedas) {
        this.monedas = monedas;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public EstadosComprobante getEstadosComprobante() {
        return estadosComprobante;
    }

    public void setEstadosComprobante(EstadosComprobante estadosComprobante) {
        this.estadosComprobante = estadosComprobante;
    }

    public TiposComprobante getTiposComprobante() {
        return tiposComprobante;
    }

    public void setTiposComprobante(TiposComprobante tiposComprobante) {
        this.tiposComprobante = tiposComprobante;
    }

    public String getFechaComprobante() {
        return fechaComprobante;
    }

    public void setFechaComprobante(String fechaComprobante) {
        this.fechaComprobante = fechaComprobante;
    }

    public String getNroCheque() {
        return nroCheque;
    }

    public void setNroCheque(String nroCheque) {
        this.nroCheque = nroCheque;
    }

    public String getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(String nroFactura) {
        this.nroFactura = nroFactura;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public String getFechaSistema() {
        return fechaSistema;
    }

    public void setFechaSistema(String fechaSistema) {
        this.fechaSistema = fechaSistema;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getDescrMontoTotal() {
        return descrMontoTotal;
    }

    public void setDescrMontoTotal(String descrMontoTotal) {
        this.descrMontoTotal = descrMontoTotal;
    }
    
    
    
    
}
