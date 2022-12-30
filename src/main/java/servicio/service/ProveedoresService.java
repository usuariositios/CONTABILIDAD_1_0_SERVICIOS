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
import servicio.model.Proveedor;
import servicio.model.SelectItem;
import servicio.resource.ProveedorResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del ProveedorResource
 */
@Stateless
@Path("/proveedor")
public class ProveedoresService {
    
    @Path("/proveedor")
    @GET @Produces("application/json")
    public Proveedor proveedor() {
        return (new Proveedor());
    }
    @Path("/cargarProveedoresItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarProveedoresItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> pccList = new ArrayList();
        try{
            ProveedorResource pr = new ProveedorResource(utiles.getCon());        
            pccList = pr.cargarProveedoresItem();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;        
    }
    @Path("/cargarProveedor")
    @POST 
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Proveedor> cargarProveedor(Proveedor p) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<Proveedor> pccList = new ArrayList();
        try{
            ProveedorResource pr = new ProveedorResource(utiles.getCon());        
            pccList = pr.cargarProveedores(p);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;        
        
    }
    @POST
    @Path("/guardarProveedor")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarProveedor(Proveedor proveedor) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            ProveedorResource pr = new ProveedorResource(utiles.getCon());        
            pr.guardarProveedor(proveedor);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
        
    }
    @Path("/codigoProveedor")
    @GET @Produces("application/json")
    public String codigoProveedor() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        String pccList = "";
        try{
            ProveedorResource pr = new ProveedorResource(utiles.getCon());        
            pccList = String.valueOf(pr.codigoProveedor());
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;        
        
    }
    @POST
    @Path("/editarProveedor")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarProveedor(Proveedor proveedor) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            ProveedorResource pr = new ProveedorResource(utiles.getCon());        
            pr.editarProveedor(proveedor);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
        
    }
    @POST
    @Path("/eliminarProveedor")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarProveedor(Proveedor proveedor) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            ProveedorResource pr = new ProveedorResource(utiles.getCon());        
            pr.eliminarProveedor(proveedor);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
        
    }
    @POST
    @Path("/buscarProveedor")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Proveedor buscarProveedor(Proveedor proveedor) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        Proveedor p = new Proveedor();
        try{
            ProveedorResource pr = new ProveedorResource(utiles.getCon());        
            p = pr.buscarProveedor(proveedor);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return p;                
    }
}
