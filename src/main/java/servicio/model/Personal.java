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
public class Personal extends bean{
    int codPersonal = 0;
    String apPaternoPersonal = "";
    String apMaternoPersonal = "";
    String nombrePersonal = "";
    String nroCarnet = "";
    EstadoCivil estadoCivil = new EstadoCivil();
    AreasEmpresa areasEmpresa = new AreasEmpresa();
    Cargo cargo = new Cargo();
    String direccionPersonal = "";
    String fechaNacPersonal = "";
    Pais pais = new Pais();
    Ciudad ciudad = new Ciudad();
    String telefPersonal = "";
    String celularPersonal = "";
    Genero genero = new Genero();
    String emailPersonal = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    boolean personalExterno = false;
    String codigoPersonal = "0";
    int codProyecto = 0;//ref a codigo proyecto de usuario_personal
    
    

    public int getCodPersonal() {
        return codPersonal;
    }

    public void setCodPersonal(int codPersonal) {
        this.codPersonal = codPersonal;
    }

    public String getApPaternoPersonal() {
        return apPaternoPersonal;
    }

    public void setApPaternoPersonal(String apPaternoPersonal) {
        this.apPaternoPersonal = apPaternoPersonal;
    }

    public String getApMaternoPersonal() {
        return apMaternoPersonal;
    }

    public void setApMaternoPersonal(String apMaternoPersonal) {
        this.apMaternoPersonal = apMaternoPersonal;
    }

    public String getNombrePersonal() {
        return nombrePersonal;
    }

    public void setNombrePersonal(String nombrePersonal) {
        this.nombrePersonal = nombrePersonal;
    }

    public String getNroCarnet() {
        return nroCarnet;
    }

    public void setNroCarnet(String nroCarnet) {
        this.nroCarnet = nroCarnet;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public AreasEmpresa getAreasEmpresa() {
        return areasEmpresa;
    }

    public void setAreasEmpresa(AreasEmpresa areasEmpresa) {
        this.areasEmpresa = areasEmpresa;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getDireccionPersonal() {
        return direccionPersonal;
    }

    public void setDireccionPersonal(String direccionPersonal) {
        this.direccionPersonal = direccionPersonal;
    }

    public String getFechaNacPersonal() {
        return fechaNacPersonal;
    }

    public void setFechaNacPersonal(String fechaNacPersonal) {
        this.fechaNacPersonal = fechaNacPersonal;
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

    public String getTelefPersonal() {
        return telefPersonal;
    }

    public void setTelefPersonal(String telefPersonal) {
        this.telefPersonal = telefPersonal;
    }

    public String getCelularPersonal() {
        return celularPersonal;
    }

    public void setCelularPersonal(String celularPersonal) {
        this.celularPersonal = celularPersonal;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public boolean isPersonalExterno() {
        return personalExterno;
    }

    public void setPersonalExterno(boolean personalExterno) {
        this.personalExterno = personalExterno;
    }

    public String getCodigoPersonal() {
        return codigoPersonal;
    }

    public void setCodigoPersonal(String codigoPersonal) {
        this.codigoPersonal = codigoPersonal;
    }

    public int getCodProyecto() {
        return codProyecto;
    }

    public void setCodProyecto(int codProyecto) {
        this.codProyecto = codProyecto;
    }
    
    

  
    
    
    
    
    
    
    
    
}
