/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author henry
 */
@XmlRootElement
public class TiposFuentePago {
    int codTipoFuentePago = 0;
    String nombreTipoFuentePago = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodTipoFuentePago() {
        return codTipoFuentePago;
    }

    public void setCodTipoFuentePago(int codTipoFuentePago) {
        this.codTipoFuentePago = codTipoFuentePago;
    }

    public String getNombreTipoFuentePago() {
        return nombreTipoFuentePago;
    }

    public void setNombreTipoFuentePago(String nombreTipoFuentePago) {
        this.nombreTipoFuentePago = nombreTipoFuentePago;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
            
    
}
