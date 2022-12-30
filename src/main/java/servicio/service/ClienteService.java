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
import servicio.model.Clientes;
import servicio.model.SelectItem;
import servicio.resource.CentroCostosResource;
import servicio.resource.ClienteResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del ClienteResource
 */
@Stateless
@Path("/cliente")
public class ClienteService {    
    @Path("/cliente")
    @GET @Produces("application/json")
    public Clientes cliente() {
        return (new Clientes());
    }
    @Path("/cargarClienteItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarClienteItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> clientesList = new ArrayList<>();
        try{
        
        ClienteResource cr = new ClienteResource(utiles.getCon());        
        clientesList = cr.cargarClienteItem(new Clientes());
        
        }catch(Exception e){e.printStackTrace();}
        utiles.closeConnection();
        
        return clientesList;
    }
    @POST
    @Path("/cargarCliente")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Clientes> cargarCliente(Clientes cliente) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<Clientes> clientesList = new ArrayList<>();
        try{
        ClienteResource cr = new ClienteResource(utiles.getCon());
        clientesList = cr.cargarCliente(cliente);
        }catch(Exception e){e.printStackTrace();}
        utiles.closeConnection();
        return clientesList;
    }
    @POST
    @Path("/guardarCliente")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarCliente(Clientes cliente) throws Exception{
        Utiles utiles = new Utiles();
        utiles.getConnection();
        try{
        ClienteResource cr = new ClienteResource(utiles.getCon());        
        cr.guardarCliente(cliente);
        }catch(Exception e){e.printStackTrace();}
        utiles.closeConnection();
    }
    @Path("/codigoCliente")
    @GET @Produces("application/json")
    public String codigoCliente() throws Exception{
        Utiles utiles = new Utiles();
        utiles.getConnection();
        String codCliente = "";
        try{
        ClienteResource cr = new ClienteResource(utiles.getCon());
        codCliente = String.valueOf(cr.codigoCliente());
        }catch(Exception e){e.printStackTrace();}
        utiles.closeConnection();
        return codCliente;
    }
    @POST
    @Path("/editarCliente")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarCliente(Clientes cliente) throws Exception{
        Utiles utiles = new Utiles();
        utiles.getConnection();
        try{
        ClienteResource cr = new ClienteResource(utiles.getCon());
        cr.editarCliente(cliente);
        }catch(Exception e){e.printStackTrace();}
        utiles.closeConnection();
    }
    @POST
    @Path("/eliminarCliente")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarCliente(Clientes cliente) throws Exception{
        Utiles utiles = new Utiles();
        utiles.getConnection();
        try{
        ClienteResource cr = new ClienteResource(utiles.getCon());
        cr.eliminarCliente(cliente);
        }catch(Exception e){e.printStackTrace();}
        utiles.closeConnection();
    }
    
}
