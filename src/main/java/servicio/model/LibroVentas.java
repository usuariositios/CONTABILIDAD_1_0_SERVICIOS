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
public class LibroVentas extends bean {
    int codLibroVentas = 0;
    int especificacion = 0;
    int numero = 0;
    String fechaFactura = "";
    String nroFactura = "";
    String nroAutorizacion = "";
    String codEstado = "";
    String nitCliente = "";
    String nombreCliente = "";
    Double montoTotal = 0.0;
    Double montoIceIehdTasas = 0.0;
    Double montoExportOperac = 0.0;
    Double montoVtasGrvTasaCero = 0.0;
    Double montoSubTotal = 0.0;
    Double montoDctosBonific = 0.0;
    Double importeBaseCreditoFiscal = 0.0;
    Double debitoFiscal = 0.0;
    String codigoControl = "";
    Clientes clientes = new Clientes();
    Comprobante comprobante = new Comprobante();
    Gestion gestion = new Gestion();

    public int getCodLibroVentas() {
        return codLibroVentas;
    }

    public void setCodLibroVentas(int codLibroVentas) {
        this.codLibroVentas = codLibroVentas;
    }

    public int getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(int especificacion) {
        this.especificacion = especificacion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public String getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(String nroFactura) {
        this.nroFactura = nroFactura;
    }

    public String getNroAutorizacion() {
        return nroAutorizacion;
    }

    public void setNroAutorizacion(String nroAutorizacion) {
        this.nroAutorizacion = nroAutorizacion;
    }

    public String getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(String codEstado) {
        this.codEstado = codEstado;
    }

    public String getNitCliente() {
        return nitCliente;
    }

    public void setNitCliente(String nitCliente) {
        this.nitCliente = nitCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Double getMontoIceIehdTasas() {
        return montoIceIehdTasas;
    }

    public void setMontoIceIehdTasas(Double montoIceIehdTasas) {
        this.montoIceIehdTasas = montoIceIehdTasas;
    }

    public Double getMontoExportOperac() {
        return montoExportOperac;
    }

    public void setMontoExportOperac(Double montoExportOperac) {
        this.montoExportOperac = montoExportOperac;
    }

    public Double getMontoVtasGrvTasaCero() {
        return montoVtasGrvTasaCero;
    }

    public void setMontoVtasGrvTasaCero(Double montoVtasGrvTasaCero) {
        this.montoVtasGrvTasaCero = montoVtasGrvTasaCero;
    }

    public Double getMontoSubTotal() {
        return montoSubTotal;
    }

    public void setMontoSubTotal(Double montoSubTotal) {
        this.montoSubTotal = montoSubTotal;
    }

    public Double getMontoDctosBonific() {
        return montoDctosBonific;
    }

    public void setMontoDctosBonific(Double montoDctosBonific) {
        this.montoDctosBonific = montoDctosBonific;
    }

    public Double getImporteBaseCreditoFiscal() {
        return importeBaseCreditoFiscal;
    }

    public void setImporteBaseCreditoFiscal(Double importeBaseCreditoFiscal) {
        this.importeBaseCreditoFiscal = importeBaseCreditoFiscal;
    }

    public Double getDebitoFiscal() {
        return debitoFiscal;
    }

    public void setDebitoFiscal(Double debitoFiscal) {
        this.debitoFiscal = debitoFiscal;
    }

    public String getCodigoControl() {
        return codigoControl;
    }

    public void setCodigoControl(String codigoControl) {
        this.codigoControl = codigoControl;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    public Gestion getGestion() {
        return gestion;
    }

    public void setGestion(Gestion gestion) {
        this.gestion = gestion;
    }
    
    
    
    
    
            
            
    
}
