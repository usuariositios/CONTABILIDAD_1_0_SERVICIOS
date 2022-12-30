/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author Computer
 */
public class PlanDeCuentas extends bean {
    int codPlanCuenta = 0;
    String codCuenta ="";
    String nombreCuenta = "";
    Monedas moneda = new Monedas();
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    int estadoCuenta =0;
    int ajustable = 0;
    int movimiento = 0;
    int costos = 0;
    int codPlanCuentaPadre = 0;
    int nivel = 0;
    String descripcion = "";
    Gestion gestion = new Gestion();
    CentroCostos centroCostos = new CentroCostos();//auxuliar de la tabla plan_cuentas_por_centro_costos
    String codigoCuentaSIN = "";
    String nombreCuentaSIN = "";

    public CentroCostos getCentroCostos() {
        return centroCostos;
    }

    public void setCentroCostos(CentroCostos centroCostos) {
        this.centroCostos = centroCostos;
    }
    
    

    public int getCodPlanCuenta() {
        return codPlanCuenta;
    }

    public void setCodPlanCuenta(int codPlanCuenta) {
        this.codPlanCuenta = codPlanCuenta;
    }

    public String getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(String codCuenta) {
        this.codCuenta = codCuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public Monedas getMoneda() {
        return moneda;
    }

    public void setMoneda(Monedas moneda) {
        this.moneda = moneda;
    }

   

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public int getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(int estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public int getAjustable() {
        return ajustable;
    }

    public void setAjustable(int ajustable) {
        this.ajustable = ajustable;
    }

    public int getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(int movimiento) {
        this.movimiento = movimiento;
    }

    public int getCostos() {
        return costos;
    }

    public void setCostos(int costos) {
        this.costos = costos;
    }

    public int getCodPlanCuentaPadre() {
        return codPlanCuentaPadre;
    }

    public void setCodPlanCuentaPadre(int codPlanCuentaPadre) {
        this.codPlanCuentaPadre = codPlanCuentaPadre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Gestion getGestion() {
        return gestion;
    }

    public void setGestion(Gestion gestion) {
        this.gestion = gestion;
    }

    public String getCodigoCuentaSIN() {
        return codigoCuentaSIN;
    }

    public void setCodigoCuentaSIN(String codigoCuentaSIN) {
        this.codigoCuentaSIN = codigoCuentaSIN;
    }

    

    public String getNombreCuentaSIN() {
        return nombreCuentaSIN;
    }

    public void setNombreCuentaSIN(String nombreCuentaSIN) {
        this.nombreCuentaSIN = nombreCuentaSIN;
    }
    
    
    
    
    
    
    
    
    
}
