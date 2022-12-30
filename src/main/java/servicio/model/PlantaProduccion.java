/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class PlantaProduccion extends  bean{
    int codPlantaProduccion = 0;
    String nombrePlantaProduccion = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    boolean externo = false;
    String observacion = "";

    public int getCodPlantaProduccion() {
        return codPlantaProduccion;
    }

    public void setCodPlantaProduccion(int codPlantaProduccion) {
        this.codPlantaProduccion = codPlantaProduccion;
    }

    public String getNombrePlantaProduccion() {
        return nombrePlantaProduccion;
    }

    public void setNombrePlantaProduccion(String nombrePlantaProduccion) {
        this.nombrePlantaProduccion = nombrePlantaProduccion;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public boolean isExterno() {
        return externo;
    }

    public void setExterno(boolean externo) {
        this.externo = externo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    
    
    
    
}
