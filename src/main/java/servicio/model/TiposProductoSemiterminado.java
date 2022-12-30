/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class TiposProductoSemiterminado extends bean {
    int codTipoProductoSemiterminado = 0;
    String nombreTipoProductoSemiterminado = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodTipoProductoSemiterminado() {
        return codTipoProductoSemiterminado;
    }

    public void setCodTipoProductoSemiterminado(int codTipoProductoSemiterminado) {
        this.codTipoProductoSemiterminado = codTipoProductoSemiterminado;
    }

    public String getNombreTipoProductoSemiterminado() {
        return nombreTipoProductoSemiterminado;
    }

    public void setNombreTipoProductoSemiterminado(String nombreTipoProductoSemiterminado) {
        this.nombreTipoProductoSemiterminado = nombreTipoProductoSemiterminado;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
    
    
}
