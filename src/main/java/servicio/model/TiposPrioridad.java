/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class TiposPrioridad {
    int codTipoPrioridad = 0;
    String nombreTipoPrioridad = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodTipoPrioridad() {
        return codTipoPrioridad;
    }

    public void setCodTipoPrioridad(int codTipoPrioridad) {
        this.codTipoPrioridad = codTipoPrioridad;
    }

    public String getNombreTipoPrioridad() {
        return nombreTipoPrioridad;
    }

    public void setNombreTipoPrioridad(String nombreTipoPrioridad) {
        this.nombreTipoPrioridad = nombreTipoPrioridad;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
}
