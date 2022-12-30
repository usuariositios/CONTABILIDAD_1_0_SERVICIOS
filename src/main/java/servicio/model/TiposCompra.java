/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class TiposCompra {
    int codTipoCompra = 0;
    String nombreTipoCompra = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodTipoCompra() {
        return codTipoCompra;
    }

    public void setCodTipoCompra(int codTipoCompra) {
        this.codTipoCompra = codTipoCompra;
    }

    public String getNombreTipoCompra() {
        return nombreTipoCompra;
    }

    public void setNombreTipoCompra(String nombreTipoCompra) {
        this.nombreTipoCompra = nombreTipoCompra;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
    
    
}
