/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class TiposEspecificacion {
    int codTipoEspecificacion  = 0;
    String nombreTipoEspecificacion = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodTipoEspecificacion() {
        return codTipoEspecificacion;
    }

    public void setCodTipoEspecificacion(int codTipoEspecificacion) {
        this.codTipoEspecificacion = codTipoEspecificacion;
    }

    public String getNombreTipoEspecificacion() {
        return nombreTipoEspecificacion;
    }

    public void setNombreTipoEspecificacion(String nombreTipoEspecificacion) {
        this.nombreTipoEspecificacion = nombreTipoEspecificacion;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
    
}
