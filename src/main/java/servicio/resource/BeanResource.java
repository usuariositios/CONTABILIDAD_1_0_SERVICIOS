/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.resource;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class BeanResource {
    static int filaInicial = 0;
    static int filaFinal = 10;

    public static int getFilaInicial() {
        return filaInicial;
    }

    public static void setFilaInicial(int filaInicial) {
        BeanResource.filaInicial = filaInicial;
    }

    public static int getFilaFinal() {
        return filaFinal;
    }

    public static void setFilaFinal(int filaFinal) {
        BeanResource.filaFinal = filaFinal;
    }

    
    
    
    
}
