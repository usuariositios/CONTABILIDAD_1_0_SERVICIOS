/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class TiposTareaProduccion {
    int codTipoTareaProduccion = 0;
    String nombreTipoTareaProduccion = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodTipoTareaProduccion() {
        return codTipoTareaProduccion;
    }

    public void setCodTipoTareaProduccion(int codTipoTareaProduccion) {
        this.codTipoTareaProduccion = codTipoTareaProduccion;
    }

    public String getNombreTipoTareaProduccion() {
        return nombreTipoTareaProduccion;
    }

    public void setNombreTipoTareaProduccion(String nombreTipoTareaProduccion) {
        this.nombreTipoTareaProduccion = nombreTipoTareaProduccion;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
}
