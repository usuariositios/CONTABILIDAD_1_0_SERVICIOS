/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class TiposLavado extends bean {
    int codTipoLavado = 0;
    String nombreTipoLavado = "";

    public int getCodTipoLavado() {
        return codTipoLavado;
    }

    public void setCodTipoLavado(int codTipoLavado) {
        this.codTipoLavado = codTipoLavado;
    }

    public String getNombreTipoLavado() {
        return nombreTipoLavado;
    }

    public void setNombreTipoLavado(String nombreTipoLavado) {
        this.nombreTipoLavado = nombreTipoLavado;
    }
    
    
    
}
