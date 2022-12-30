/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class EstadoCivil {
    int codEstadoCivil = 0;
    String nombreEstadoCivil = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodEstadoCivil() {
        return codEstadoCivil;
    }

    public void setCodEstadoCivil(int codEstadoCivil) {
        this.codEstadoCivil = codEstadoCivil;
    }

    public String getNombreEstadoCivil() {
        return nombreEstadoCivil;
    }

    public void setNombreEstadoCivil(String nombreEstadoCivil) {
        this.nombreEstadoCivil = nombreEstadoCivil;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
}
