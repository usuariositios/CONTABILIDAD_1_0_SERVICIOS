/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author henry
 */
public abstract class bean {
    boolean checked = false;
    int filaInicial = 0;
    int filaFinal = 10;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getFilaInicial() {
        return filaInicial;
    }

    public void setFilaInicial(int filaInicial) {
        this.filaInicial = filaInicial;
    }

    public int getFilaFinal() {
        return filaFinal;
    }

    public void setFilaFinal(int filaFinal) {
        this.filaFinal = filaFinal;
    }
    
    
    
    
}
