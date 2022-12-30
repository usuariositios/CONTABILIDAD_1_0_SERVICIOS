/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author Computer
 */
public class TiposSalidaAlmacen {
    int codTipoSalidaAlmacen = 0;
    String nombreTipoSalidaAlmacen = "";
    String obsTipoSalidaAlmacen = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodTipoSalidaAlmacen() {
        return codTipoSalidaAlmacen;
    }

    public void setCodTipoSalidaAlmacen(int codTipoSalidaAlmacen) {
        this.codTipoSalidaAlmacen = codTipoSalidaAlmacen;
    }

    public String getNombreTipoSalidaAlmacen() {
        return nombreTipoSalidaAlmacen;
    }

    public void setNombreTipoSalidaAlmacen(String nombreTipoSalidaAlmacen) {
        this.nombreTipoSalidaAlmacen = nombreTipoSalidaAlmacen;
    }

    public String getObsTipoSalidaAlmacen() {
        return obsTipoSalidaAlmacen;
    }

    public void setObsTipoSalidaAlmacen(String obsTipoSalidaAlmacen) {
        this.obsTipoSalidaAlmacen = obsTipoSalidaAlmacen;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
    
}
