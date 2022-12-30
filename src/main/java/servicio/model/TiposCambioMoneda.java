/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author COMPUTER
 */
@XmlRootElement
public class TiposCambioMoneda {
    String fecha = "";
    Monedas monedas = new Monedas();
    Double monto = 0.0;
    int mes = 0;
    

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Monedas getMonedas() {
        return monedas;
    }

    public void setMonedas(Monedas monedas) {
        this.monedas = monedas;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }
    
    
    
}
