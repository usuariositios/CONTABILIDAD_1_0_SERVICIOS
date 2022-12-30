/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author HENRY VALDIVIA
 */
public class TiposDocumentoLibroCompras {
    int codTipoDocumentoLibroCompra = 0;
    String nombreTipoDocumentoLibroCompra = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    String codigo = "";

    public int getCodTipoDocumentoLibroCompra() {
        return codTipoDocumentoLibroCompra;
    }

    public void setCodTipoDocumentoLibroCompra(int codTipoDocumentoLibroCompra) {
        this.codTipoDocumentoLibroCompra = codTipoDocumentoLibroCompra;
    }

    public String getNombreTipoDocumentoLibroCompra() {
        return nombreTipoDocumentoLibroCompra;
    }

    public void setNombreTipoDocumentoLibroCompra(String nombreTipoDocumentoLibroCompra) {
        this.nombreTipoDocumentoLibroCompra = nombreTipoDocumentoLibroCompra;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
}
