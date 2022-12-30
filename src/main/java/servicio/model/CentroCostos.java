/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author Computer
 */
public class CentroCostos {
    int codCentroCostos = 0;
    TiposCentroCostos tiposCentroCostos = new TiposCentroCostos();
    String nombreCentroCostos = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    String codigo = "";
    String abreviatura = "";

    public int getCodCentroCostos() {
        return codCentroCostos;
    }

    public void setCodCentroCostos(int codCentroCostos) {
        this.codCentroCostos = codCentroCostos;
    }

    public TiposCentroCostos getTiposCentroCostos() {
        return tiposCentroCostos;
    }

    public void setTiposCentroCostos(TiposCentroCostos tiposCentroCostos) {
        this.tiposCentroCostos = tiposCentroCostos;
    }

    public String getNombreCentroCostos() {
        return nombreCentroCostos;
    }

    public void setNombreCentroCostos(String nombreCentroCostos) {
        this.nombreCentroCostos = nombreCentroCostos;
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

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }
    
    
}
