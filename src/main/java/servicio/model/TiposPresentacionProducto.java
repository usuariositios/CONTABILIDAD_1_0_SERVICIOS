/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author Computer
 */
public class TiposPresentacionProducto {
    int codTipoPresentacion = 0;
    String nombreTipoPresentacion = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodTipoPresentacion() {
        return codTipoPresentacion;
    }

    public void setCodTipoPresentacion(int codTipoPresentacion) {
        this.codTipoPresentacion = codTipoPresentacion;
    }

    public String getNombreTipoPresentacion() {
        return nombreTipoPresentacion;
    }

    public void setNombreTipoPresentacion(String nombreTipoPresentacion) {
        this.nombreTipoPresentacion = nombreTipoPresentacion;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
    
}
