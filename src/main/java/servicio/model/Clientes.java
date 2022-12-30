/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class Clientes extends bean{
    int codCliente = 0;
    String nombreCliente = "";
    String nitCliente = "";
    String direccionCliente = "";
    String nroDireccionCliente = "";
    String telfCliente = "";
    String CelCliente = "";
    String faxCliente = "";
    String emailCliente = "";
    String nombrePropietario = "";
    String nombreRepresentante = "";
    Ciudad ciudad = new Ciudad();
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNitCliente() {
        return nitCliente;
    }

    public void setNitCliente(String nitCliente) {
        this.nitCliente = nitCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getNroDireccionCliente() {
        return nroDireccionCliente;
    }

    public void setNroDireccionCliente(String nroDireccionCliente) {
        this.nroDireccionCliente = nroDireccionCliente;
    }

    public String getTelfCliente() {
        return telfCliente;
    }

    public void setTelfCliente(String telfCliente) {
        this.telfCliente = telfCliente;
    }

    public String getCelCliente() {
        return CelCliente;
    }

    public void setCelCliente(String CelCliente) {
        this.CelCliente = CelCliente;
    }

    public String getFaxCliente() {
        return faxCliente;
    }

    public void setFaxCliente(String faxCliente) {
        this.faxCliente = faxCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getNombreRepresentante() {
        return nombreRepresentante;
    }

    public void setNombreRepresentante(String nombreRepresentante) {
        this.nombreRepresentante = nombreRepresentante;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
    
}
