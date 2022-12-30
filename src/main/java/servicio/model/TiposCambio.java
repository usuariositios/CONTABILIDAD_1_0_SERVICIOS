/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import java.util.Date;

/**
 *
 * @author henry
 */
public class TiposCambio {
    Date fecha = new Date();
    Monedas monedas = new Monedas();
    Double valor = 0.0;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Monedas getMonedas() {
        return monedas;
    }

    public void setMonedas(Monedas monedas) {
        this.monedas = monedas;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
}
