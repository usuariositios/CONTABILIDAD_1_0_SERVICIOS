/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class TiposMedioPago {
    int codTipoMedioPago = 0;
    String nombreTipoMedioPago = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    

    public int getCodTipoMedioPago() {
        return codTipoMedioPago;
    }

    public void setCodTipoMedioPago(int codTipoMedioPago) {
        this.codTipoMedioPago = codTipoMedioPago;
    }

    public String getNombreTipoMedioPago() {
        return nombreTipoMedioPago;
    }

    public void setNombreTipoMedioPago(String nombreTipoMedioPago) {
        this.nombreTipoMedioPago = nombreTipoMedioPago;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
    
}
