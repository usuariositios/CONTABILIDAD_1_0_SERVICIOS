/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author Computer
 */
public class TiposProgramaProduccion {
    int codTipoProgramaProduccion = 0;
    String nombreProgramaProduccion = "";
    String obsTipoProgramaProduccion = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    String abreviatura = "";

    public int getCodTipoProgramaProduccion() {
        return codTipoProgramaProduccion;
    }

    public void setCodTipoProgramaProduccion(int codTipoProgramaProduccion) {
        this.codTipoProgramaProduccion = codTipoProgramaProduccion;
    }

    public String getNombreProgramaProduccion() {
        return nombreProgramaProduccion;
    }

    public void setNombreProgramaProduccion(String nombreProgramaProduccion) {
        this.nombreProgramaProduccion = nombreProgramaProduccion;
    }

    public String getObsTipoProgramaProduccion() {
        return obsTipoProgramaProduccion;
    }

    public void setObsTipoProgramaProduccion(String obsTipoProgramaProduccion) {
        this.obsTipoProgramaProduccion = obsTipoProgramaProduccion;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    
    
            
            
    
}
