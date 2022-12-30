/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author henry
 */
public class TiposCuenta {
    int codTipoCuenta = 0;
    String nombreTipoCuenta = "";
    String codInicial = "";

    public int getCodTipoCuenta() {
        return codTipoCuenta;
    }

    public void setCodTipoCuenta(int codTipoCuenta) {
        this.codTipoCuenta = codTipoCuenta;
    }

    public String getNombreTipoCuenta() {
        return nombreTipoCuenta;
    }

    public void setNombreTipoCuenta(String nombreTipoCuenta) {
        this.nombreTipoCuenta = nombreTipoCuenta;
    }

    public String getCodInicial() {
        return codInicial;
    }

    public void setCodInicial(String codInicial) {
        this.codInicial = codInicial;
    }
    
    
    
}
