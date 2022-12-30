/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Computer
 */
@XmlRootElement
public class TiposIngresoAlmacen extends bean{
    int codTipoIngresoAlmacen = 0;
    String nombreTipoIngresoAlmacen = "";
    String obsTipoIngresoAlmacen = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodTipoIngresoAlmacen() {
        return codTipoIngresoAlmacen;
    }

    public void setCodTipoIngresoAlmacen(int codTipoIngresoAlmacen) {
        this.codTipoIngresoAlmacen = codTipoIngresoAlmacen;
    }

    public String getNombreTipoIngresoAlmacen() {
        return nombreTipoIngresoAlmacen;
    }

    public void setNombreTipoIngresoAlmacen(String nombreTipoIngresoAlmacen) {
        this.nombreTipoIngresoAlmacen = nombreTipoIngresoAlmacen;
    }

    public String getObsTipoIngresoAlmacen() {
        return obsTipoIngresoAlmacen;
    }

    public void setObsTipoIngresoAlmacen(String obsTipoIngresoAlmacen) {
        this.obsTipoIngresoAlmacen = obsTipoIngresoAlmacen;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
            
}
