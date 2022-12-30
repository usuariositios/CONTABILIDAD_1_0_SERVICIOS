/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author COMPUTER
 */
public class Proveedor extends bean {
    int codProveedor = 0;
    String nombreProveedor = "";
    String nitProveedor = "";
    
    TiposProveedor tiposProveedor = new TiposProveedor();
    EstadosProveedor estadosProveedor = new EstadosProveedor();
    Monedas monedas = new Monedas();
    TiposPago tiposPago = new TiposPago();
    TiposDocumento tiposDocumento = new TiposDocumento();
    Pais pais = new Pais();
    Ciudad ciudad = new Ciudad();
    String direccionProveedor = "";
    String telefonoProveedor = "";
    String emailProveedor="";
    String faxProveedor="";
    String paginaWebProveedor="";
    String obsProveedor = "";
    String nombreCheque="";
    String diasTerminoPago="";
    TiposMedioPago tiposMedioPago = new TiposMedioPago();
    
    
    
            
            

    public int getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(int codProveedor) {
        this.codProveedor = codProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getNitProveedor() {
        return nitProveedor;
    }

    public void setNitProveedor(String nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public TiposProveedor getTiposProveedor() {
        return tiposProveedor;
    }

    public void setTiposProveedor(TiposProveedor tiposProveedor) {
        this.tiposProveedor = tiposProveedor;
    }

    public EstadosProveedor getEstadosProveedor() {
        return estadosProveedor;
    }

    public void setEstadosProveedor(EstadosProveedor estadosProveedor) {
        this.estadosProveedor = estadosProveedor;
    }

    public Monedas getMonedas() {
        return monedas;
    }

    public void setMonedas(Monedas monedas) {
        this.monedas = monedas;
    }

    public TiposPago getTiposPago() {
        return tiposPago;
    }

    public void setTiposPago(TiposPago tiposPago) {
        this.tiposPago = tiposPago;
    }

    public TiposDocumento getTiposDocumento() {
        return tiposDocumento;
    }

    public void setTiposDocumento(TiposDocumento tiposDocumento) {
        this.tiposDocumento = tiposDocumento;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public TiposMedioPago getTiposMedioPago() {
        return tiposMedioPago;
    }

    public void setTiposMedioPago(TiposMedioPago tiposMedioPago) {
        this.tiposMedioPago = tiposMedioPago;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getEmailProveedor() {
        return emailProveedor;
    }

    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }

    public String getFaxProveedor() {
        return faxProveedor;
    }

    public void setFaxProveedor(String faxProveedor) {
        this.faxProveedor = faxProveedor;
    }

    public String getPaginaWebProveedor() {
        return paginaWebProveedor;
    }

    public void setPaginaWebProveedor(String paginaWebProveedor) {
        this.paginaWebProveedor = paginaWebProveedor;
    }

    public String getObsProveedor() {
        return obsProveedor;
    }

    public void setObsProveedor(String obsProveedor) {
        this.obsProveedor = obsProveedor;
    }

    public String getNombreCheque() {
        return nombreCheque;
    }

    public void setNombreCheque(String nombreCheque) {
        this.nombreCheque = nombreCheque;
    }

    public String getDiasTerminoPago() {
        return diasTerminoPago;
    }

    public void setDiasTerminoPago(String diasTerminoPago) {
        this.diasTerminoPago = diasTerminoPago;
    }
    
    
    
    
    
}
