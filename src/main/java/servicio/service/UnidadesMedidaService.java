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
import servicio.model.SelectItem;
import servicio.model.UnidadesMedida;
import servicio.resource.UnidadesMedidaResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del UnidadesMedidaResource
 */
@Stateless
@Path("/unidadesMedida")
public class UnidadesMedidaService {    
    @Path("/unidadesMedida")
    @GET @Produces("application/json")
    public UnidadesMedida unidadesMedida() {
        return (new UnidadesMedida());
    }
    @Path("/cargarUnidadesMedidaItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarUnidadesMedidaItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> pccList = new ArrayList();
        try{
            UnidadesMedidaResource pr = new UnidadesMedidaResource(utiles.getCon());        
            pccList = pr.cargarUnidadesMedidaItem();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;
        
    }
    @Path("/cargarUnidadesMedida")
    @GET @Produces("application/json")
    public List<UnidadesMedida> cargarUnidadesMedida() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<UnidadesMedida> pccList = new ArrayList();
        try{
            UnidadesMedidaResource pr = new UnidadesMedidaResource(utiles.getCon());        
            pccList = pr.cargarUnidadesMedida(new UnidadesMedida());
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;
        
    }
    @POST
    @Path("/guardarUnidadesMedida")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarUnidadesMedida(UnidadesMedida unidadesMedida) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            UnidadesMedidaResource pr = new UnidadesMedidaResource(utiles.getCon());        
            pr.guardarUnidadesMedida(unidadesMedida);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
    @Path("/codigoUnidadesMedida")
    @GET @Produces("application/json")
    public String codigoUnidadesMedida() {
        return String.valueOf("0");
    }
    @POST
    @Path("/editarUnidadesMedida")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarUnidadesMedida(UnidadesMedida unidadesMedida) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        try{
            UnidadesMedidaResource pr = new UnidadesMedidaResource(utiles.getCon());        
            pr.editarUnidadesMedida(unidadesMedida);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
    }
    @POST
    @Path("/eliminarUnidadesMedida")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarUnidadesMedida(UnidadesMedida unidadesMedida) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            UnidadesMedidaResource pr = new UnidadesMedidaResource(utiles.getCon());        
            pr.eliminarUnidadesMedida(unidadesMedida);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
        
    }
    
}
