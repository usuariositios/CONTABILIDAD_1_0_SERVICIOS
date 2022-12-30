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
public class PlanDeCuentasCentroCostos extends bean {
    CentroCostos centroCostos = new CentroCostos();
    PlanDeCuentas planDeCuentas = new PlanDeCuentas();
    Gestion gestion = new Gestion();
    Empresas empresas = new Empresas();
    int dePlanCuentas = 0;//para que cargue los centros de costos del plan de cuenta o lo contrario
    

    public CentroCostos getCentroCostos() {
        return centroCostos;
    }

    public void setCentroCostos(CentroCostos centroCostos) {
        this.centroCostos = centroCostos;
    }

    public PlanDeCuentas getPlanDeCuentas() {
        return planDeCuentas;
    }

    public void setPlanDeCuentas(PlanDeCuentas planDeCuentas) {
        this.planDeCuentas = planDeCuentas;
    }

    public Gestion getGestion() {
        return gestion;
    }

    public void setGestion(Gestion gestion) {
        this.gestion = gestion;
    }

    public Empresas getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }

    public int getDePlanCuentas() {
        return dePlanCuentas;
    }

    public void setDePlanCuentas(int dePlanCuentas) {
        this.dePlanCuentas = dePlanCuentas;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
