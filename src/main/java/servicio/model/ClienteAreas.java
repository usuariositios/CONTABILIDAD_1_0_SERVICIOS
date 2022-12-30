/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class ClienteAreas extends bean {
    Clientes cliente = new Clientes();
    int codClienteArea = 0;
    String nombreClienteArea = "";

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public int getCodClienteArea() {
        return codClienteArea;
    }

    public void setCodClienteArea(int codClienteArea) {
        this.codClienteArea = codClienteArea;
    }

    public String getNombreClienteArea() {
        return nombreClienteArea;
    }

    public void setNombreClienteArea(String nombreClienteArea) {
        this.nombreClienteArea = nombreClienteArea;
    }
    
    
    
}
