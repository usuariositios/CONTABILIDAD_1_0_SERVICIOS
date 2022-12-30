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
public class ReciboCompras {
    int codRecibo = 0;
    Proveedor proveedor = new Proveedor();
    String nroRecibo = "";
    String fechaRecibo = "";
    Double importeTotal = 0.0;
    Double descuentosRebajas = 0.0;
    Double importeCancelado = 0.0;
    String glosa = "";
    String fechaPago = "";

    public int getCodRecibo() {
        return codRecibo;
    }

    public void setCodRecibo(int codRecibo) {
        this.codRecibo = codRecibo;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getNroRecibo() {
        return nroRecibo;
    }

    public void setNroRecibo(String nroRecibo) {
        this.nroRecibo = nroRecibo;
    }

   

    public String getFechaRecibo() {
        return fechaRecibo;
    }

    public void setFechaRecibo(String fechaRecibo) {
        this.fechaRecibo = fechaRecibo;
    }

    public Double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(Double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public Double getDescuentosRebajas() {
        return descuentosRebajas;
    }

    public void setDescuentosRebajas(Double descuentosRebajas) {
        this.descuentosRebajas = descuentosRebajas;
    }

    public Double getImporteCancelado() {
        return importeCancelado;
    }

    public void setImporteCancelado(Double importeCancelado) {
        this.importeCancelado = importeCancelado;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }
    
    
    
    
}
