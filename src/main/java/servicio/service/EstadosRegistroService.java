/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import servicio.model.SelectItem;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import servicio.model.EstadosOrdenCompra;
import servicio.model.EstadosRegistro;
import servicio.resource.CargoResource;
import servicio.resource.EstadoRegistroResource;
import servicio.resource.EstadosOrdenesCompraResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del EstadosRegistroResource
 */
@Stateless
@Path("/estadosRegistro")
public class EstadosRegistroService {
    @Path("/estadosRegistro")
    @GET @Produces("application/json")
    public EstadosRegistro estadosRegistro() {
        return (new EstadosRegistro());
    }
    @Path("/cargarEstadosRegistroItem")
    @GET @Produces("application/json")
    public List<servicio.model.SelectItem> cargarEstadosRegistroItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<servicio.model.SelectItem> estadoRegistroList = new ArrayList();
        try{
            EstadoRegistroResource err = new EstadoRegistroResource(utiles.getCon());        
            estadoRegistroList = err.cargarEstadosRegistroItem();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return estadoRegistroList;        
    }
    @Path("/cargarEstadosRegistro")
    @GET @Produces("application/json")
    public List<EstadosRegistro> cargarEstadosRegistro() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<EstadosRegistro> estadoRegistroList = new ArrayList();
        try{
            EstadoRegistroResource err = new EstadoRegistroResource(utiles.getCon());        
            estadoRegistroList = err.cargarEstadosRegistro();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return estadoRegistroList;                
    }
    @POST
    @Path("/guardarEstadosRegistro")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarEstadosRegistro(EstadosRegistro estadosRegistro) {
        //EstadosRegistroResource.guardarEstadosRegistro(estadosRegistro);
    }    
    @POST
    @Path("/editarEstadosRegistro")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarEstadosRegistro(EstadosRegistro estadosRegistro) {
        //EstadosRegistroResource.editarEstadosRegistro(estadosRegistro);
    }
    @POST
    @Path("/eliminarEstadosRegistro")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarEstadosRegistro(EstadosRegistro estadosRegistro) {
        //EstadosRegistroResource.eliminarEstadosRegistro(estadosRegistro);
    }    
    
}
