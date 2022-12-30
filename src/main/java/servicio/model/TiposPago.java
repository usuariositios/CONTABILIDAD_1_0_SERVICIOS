/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class TiposPago {
    int codTipoPago = 0;
    String nombreTipoPago = "";
    double porcentajeAnticipo = 0.0;
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodTipoPago() {
        return codTipoPago;
    }

    public void setCodTipoPago(int codTipoPago) {
        this.codTipoPago = codTipoPago;
    }

    public String getNombreTipoPago() {
        return nombreTipoPago;
    }

    public void setNombreTipoPago(String nombreTipoPago) {
        this.nombreTipoPago = nombreTipoPago;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public double getPorcentajeAnticipo() {
        return porcentajeAnticipo;
    }

    public void setPorcentajeAnticipo(double porcentajeAnticipo) {
        this.porcentajeAnticipo = porcentajeAnticipo;
    }
    
    
    
    
    
}
