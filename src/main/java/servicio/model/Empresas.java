/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author henry
 */
public class Empresas extends bean{
    int codEmpresa = 0;
    String nombreEmpresa = "";
    String ruc = "";
    int codGestion = 0;
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    String direccion = "";
    String telefono = "";
    Ciudad ciudad = new Ciudad();
    String nombreImpuesto = "";
    Double porcentajeImpuesto = 0.0;
    Monedas monedas = new Monedas();
    String logotipoEmpresa = "";
    
    public Empresas() {
    }

    public int getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(int codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public int getCodGestion() {
        return codGestion;
    }

    public void setCodGestion(int codGestion) {
        this.codGestion = codGestion;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreImpuesto() {
        return nombreImpuesto;
    }

    public void setNombreImpuesto(String nombreImpuesto) {
        this.nombreImpuesto = nombreImpuesto;
    }

    public Double getPorcentajeImpuesto() {
        return porcentajeImpuesto;
    }

    public void setPorcentajeImpuesto(Double porcentajeImpuesto) {
        this.porcentajeImpuesto = porcentajeImpuesto;
    }

    public Monedas getMonedas() {
        return monedas;
    }

    public void setMonedas(Monedas monedas) {
        this.monedas = monedas;
    }

    

    public String getLogotipoEmpresa() {
        return logotipoEmpresa;
    }

    public void setLogotipoEmpresa(String logotipoEmpresa) {
        this.logotipoEmpresa = logotipoEmpresa;
    }
    
    
    
    
    
    

    

    
}
