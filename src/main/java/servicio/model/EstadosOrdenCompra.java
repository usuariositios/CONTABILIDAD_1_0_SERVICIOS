/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class EstadosOrdenCompra {
    int codEstadoOrdenCompra = 0;
    String nombreEstadoOrdenCompra = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodEstadoOrdenCompra() {
        return codEstadoOrdenCompra;
    }

    public void setCodEstadoOrdenCompra(int codEstadoOrdenCompra) {
        this.codEstadoOrdenCompra = codEstadoOrdenCompra;
    }

    public String getNombreEstadoOrdenCompra() {
        return nombreEstadoOrdenCompra;
    }

    public void setNombreEstadoOrdenCompra(String nombreEstadoOrdenCompra) {
        this.nombreEstadoOrdenCompra = nombreEstadoOrdenCompra;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
}
