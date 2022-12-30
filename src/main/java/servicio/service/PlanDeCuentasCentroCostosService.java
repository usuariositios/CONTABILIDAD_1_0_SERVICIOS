/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import servicio.model.PlanDeCuentasCentroCostos;
import servicio.model.SelectItem;

import servicio.resource.PlanDeCuentasCentroCostosResource;
import servicio.util.Utiles;




/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */
@Stateless
@Path("/planDeCuentasCentroCostos")
public class PlanDeCuentasCentroCostosService {
    /*/planDeCuentas/planDeCuentas*/
    @Path("/planDeCuentasCentroCostos")
    @GET @Produces("application/json")
    public PlanDeCuentasCentroCostos planDeCuentas() {
        return (new PlanDeCuentasCentroCostos());
    }
    /*/planDeCuentas/cargarPlanDeCuentasCentroCostos*/
    @POST
    @Path("/cargarPlanDeCuentasCentroCostos")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<PlanDeCuentasCentroCostos> cargarPlanDeCuentasCentroCostos(PlanDeCuentasCentroCostos planDeCuentas) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<PlanDeCuentasCentroCostos> pccList = new ArrayList();
        try{
            PlanDeCuentasCentroCostosResource pr = new PlanDeCuentasCentroCostosResource(utiles.getCon());        
            pccList = pr.cargarPlanDeCuentasCentroCostos(planDeCuentas);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;
    }
    @POST
    @Path("/cargarPlanDeCuentasCentroCostosItem")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<SelectItem> cargarPlanDeCuentasCentroCostosItem(PlanDeCuentasCentroCostos planDeCuentas) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> pcList = new ArrayList();
        try{
            PlanDeCuentasCentroCostosResource pr = new PlanDeCuentasCentroCostosResource(utiles.getCon());        
            pcList = pr.cargarPlanDeCuentasCentroCostosItem(planDeCuentas);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pcList;        
    }
    /*/planDeCuentas/guardarPlanDeCuentas*/
    @POST
    @Path("/guardarPlanDeCuentasCentroCostos")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarPlanDeCuentas(PlanDeCuentasCentroCostos planDeCuentas) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            PlanDeCuentasCentroCostosResource pr = new PlanDeCuentasCentroCostosResource(utiles.getCon());        
            pr.guardarPlanDeCuentasCentroCostos(planDeCuentas);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
    /*/planDeCuentas/codigoPlanDeCuentas*/
    /*@Path("/codigoPlanDeCuentas")
    @GET    
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String codigoPlanDeCuentas() {
        return String.valueOf(PlanDeCuentasCentroCostosResource.codigoPlanDeCuentas());
    }*/
    /*/planDeCuentas/editarPlanDeCuentas*/
    @POST
    @Path("/editarPlanDeCuentasCentroCostos")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarPlanDeCuentas(PlanDeCuentasCentroCostos planDeCuentas) throws Exception{
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        try{
            PlanDeCuentasCentroCostosResource pr = new PlanDeCuentasCentroCostosResource(utiles.getCon());        
            pr.editarPlanDeCuentasCentroCostos(planDeCuentas);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
    }
    /*/planDeCuentas/eliminarIngresoAlmacen*/
    @POST
    @Path("/eliminarPlanDeCuentasCentroCostos")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarIngresoAlmacen(PlanDeCuentasCentroCostos planDeCuentas)throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            PlanDeCuentasCentroCostosResource pr = new PlanDeCuentasCentroCostosResource(utiles.getCon());        
            pr.eliminarPlanDeCuentasCentroCostos(planDeCuentas);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
}
