/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author OSCAR VALDIVIA
 */

@XmlRootElement
public class UsuarioPersonal {
    int codProyecto = 0;
    Personal personal = new Personal();
    Perfil perfil = new Perfil();
    String nombreUsuario = "";
    String passwordUsuario = "";
    Gestion gestion = new Gestion();
    TiposCambioMoneda tiposCambioMoneda = new TiposCambioMoneda();

    public int getCodProyecto() {
        return codProyecto;
    }

    public void setCodProyecto(int codProyecto) {
        this.codProyecto = codProyecto;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public Gestion getGestion() {
        return gestion;
    }

    public void setGestion(Gestion gestion) {
        this.gestion = gestion;
    }

    public TiposCambioMoneda getTiposCambioMoneda() {
        return tiposCambioMoneda;
    }

    public void setTiposCambioMoneda(TiposCambioMoneda tiposCambioMoneda) {
        this.tiposCambioMoneda = tiposCambioMoneda;
    }
    
    
    
    
}
