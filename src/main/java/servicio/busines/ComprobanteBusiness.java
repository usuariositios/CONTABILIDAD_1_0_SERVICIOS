/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.busines;

import java.util.ArrayList;
import java.util.List;
import servicio.model.Comprobante;
import servicio.model.ComprobanteDetalle;

/**
 *
 * @author Computer
 */
public class ComprobanteBusiness {
    Comprobante comprobante = new Comprobante();
    List<ComprobanteDetalle> comprobanteDetalleList = new ArrayList<ComprobanteDetalle>();

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    public List<ComprobanteDetalle> getComprobanteDetalleList() {
        return comprobanteDetalleList;
    }

    public void setComprobanteDetalleList(List<ComprobanteDetalle> comprobanteDetalleList) {
        this.comprobanteDetalleList = comprobanteDetalleList;
    }
    
    
    
}
