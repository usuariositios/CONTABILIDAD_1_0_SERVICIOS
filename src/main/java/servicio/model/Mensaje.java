/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Computer
 */
@XmlRootElement
public class Mensaje {
    int codResp =0;
    String mensajeResp ="";

    public int getCodResp() {
        return codResp;
    }

    public void setCodResp(int codResp) {
        this.codResp = codResp;
    }

    public String getMensajeResp() {
        return mensajeResp;
    }

    public void setMensajeResp(String mensajeResp) {
        this.mensajeResp = mensajeResp;
    }

    
}
