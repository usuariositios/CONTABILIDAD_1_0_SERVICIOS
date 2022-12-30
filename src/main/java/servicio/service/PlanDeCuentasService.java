/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.service;

//import com.sun.jersey.core.header.FormDataContentDisposition;
//import com.sun.jersey.multipart.FormDataParam;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import servicio.model.PlanDeCuentas;
import servicio.model.SelectItem;

import servicio.resource.PlanDeCuentasResource;
import servicio.util.Utiles;



/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */
@Stateless
@Path("/planDeCuentas")
public class PlanDeCuentasService {    
    /*/planDeCuentas/planDeCuentas*/
    @Path("/planDeCuentas")
    @GET @Produces("application/json")
    public PlanDeCuentas planDeCuentas() {
        return (new PlanDeCuentas());
    }
    /*/planDeCuentas/cargarPlanDeCuentas*/
    @POST
    @Path("/cargarPlanDeCuentas")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<PlanDeCuentas> cargarPlanDeCuentas(PlanDeCuentas planDeCuentas) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<PlanDeCuentas> pccList = new ArrayList();
        try{
            PlanDeCuentasResource pr = new PlanDeCuentasResource(utiles.getCon());        
            pccList = pr.cargarPlanDeCuentas(planDeCuentas);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;
    }
    @POST
    @Path("/cargarPlanDeCuentasItem")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<SelectItem> cargarPlanDeCuentasItem(PlanDeCuentas planDeCuentas) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> pccList = new ArrayList();
        try{
            PlanDeCuentasResource pr = new PlanDeCuentasResource(utiles.getCon());        
            pccList = pr.cargarPlanDeCuentasItem(planDeCuentas);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;        
    }
    /*/planDeCuentas/guardarPlanDeCuentas*/
    @POST
    @Path("/guardarPlanDeCuentas")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarPlanDeCuentas(PlanDeCuentas planDeCuentas) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        try{
            PlanDeCuentasResource pr = new PlanDeCuentasResource(utiles.getCon());        
            pr.guardarPlanDeCuentas(planDeCuentas);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
    }
    /*/planDeCuentas/codigoPlanDeCuentas*/
    @Path("/codigoPlanDeCuentas")
    @GET    
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String codigoPlanDeCuentas() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        String codPlanCuenta = "";
        try{
            PlanDeCuentasResource pr = new PlanDeCuentasResource(utiles.getCon());        
            codPlanCuenta = String.valueOf(pr.codigoPlanDeCuentas());
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return codPlanCuenta;        
    }
    /*/planDeCuentas/editarPlanDeCuentas*/
    @POST
    @Path("/editarPlanDeCuentas")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarPlanDeCuentas(PlanDeCuentas planDeCuentas) throws Exception{
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            PlanDeCuentasResource pr = new PlanDeCuentasResource(utiles.getCon());        
            pr.editarPlanDeCuentas(planDeCuentas);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
    }
    /*/planDeCuentas/eliminarIngresoAlmacen*/
    @POST
    @Path("/eliminarPlanDeCuentas")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarIngresoAlmacen(PlanDeCuentas planDeCuentas)throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        try{
            PlanDeCuentasResource pr = new PlanDeCuentasResource(utiles.getCon());        
            pr.eliminarPlanDeCuentas(planDeCuentas);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
    }
    /*@POST
    @Path("/uploadFile")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces({MediaType.TEXT_PLAIN})
    public String uploadFile(
			@FormDataParam("file") InputStream uploadedInputStream,
                        @FormDataParam("file") FormDataContentDisposition fileDetail,
                        @FormDataParam("codGestion") String codGestion) {
        System.out.println("proceso archivo....."+ codGestion);
        
        System.out.println(fileDetail.getFileName()+ " " + fileDetail.getSize());
        
        return "{respuesta:"+PlanDeCuentasResource.uploadFile(uploadedInputStream, fileDetail,codGestion).getStatus()+"}";
    }*/
    
    @POST
    @Path("/cargarPlanDeCuentasCentroCostos")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<PlanDeCuentas> cargarPlanDeCuentasCentroCostos(PlanDeCuentas planDeCuentas) throws Exception  {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<PlanDeCuentas> pccList = new ArrayList();
        try{
            PlanDeCuentasResource pr = new PlanDeCuentasResource(utiles.getCon());        
            pccList = pr.cargarPlanDeCuentasCentroCostos(planDeCuentas);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;
        
    }
    
    @POST
    @Path("/generarPlanDeCuentas")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void generarPlanDeCuentas(PlanDeCuentas planDeCuentas) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<PlanDeCuentas> pccList = new ArrayList();
        try{
            PlanDeCuentasResource pr = new PlanDeCuentasResource(utiles.getCon());        
            pr.generarPlanDeCuentas(planDeCuentas);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
    }
    @POST
    @Path("/buscarPlanDeCuentas")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public PlanDeCuentas buscarPlanDeCuentas(PlanDeCuentas planDeCuentas) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        PlanDeCuentas planDeCuentas1 = new PlanDeCuentas();
        try{
            PlanDeCuentasResource pr = new PlanDeCuentasResource(utiles.getCon());        
            planDeCuentas1 = pr.buscarPlanDeCuentas(planDeCuentas1);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return planDeCuentas1;
        
    }
    
}
