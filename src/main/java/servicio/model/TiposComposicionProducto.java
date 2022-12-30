/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class TiposComposicionProducto extends bean{
    int codTipoComposicionProducto = 0;
    String nombreTipoComposicionProducto = "";

    public int getCodTipoComposicionProducto() {
        return codTipoComposicionProducto;
    }

    public void setCodTipoComposicionProducto(int codTipoComposicionProducto) {
        this.codTipoComposicionProducto = codTipoComposicionProducto;
    }

    public String getNombreTipoComposicionProducto() {
        return nombreTipoComposicionProducto;
    }

    public void setNombreTipoComposicionProducto(String nombreTipoComposicionProducto) {
        this.nombreTipoComposicionProducto = nombreTipoComposicionProducto;
    }
    
    
}
