/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class Genero extends bean{
    int codGenero = 0;
    String nombreGenero = "";
    //OrdenProduccionDetalleTalla ordenProduccionDetalleTalla = new OrdenProduccionDetalleTalla();

    public int getCodGenero() {
        return codGenero;
    }

    public void setCodGenero(int codGenero) {
        this.codGenero = codGenero;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }

   
    
    
}
