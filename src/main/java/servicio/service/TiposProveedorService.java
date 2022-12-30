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
import servicio.model.TiposProveedor;
import servicio.resource.TiposProveedorResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del TiposProveedorResource
 */
@Stateless
@Path("/tiposProveedor")
public class TiposProveedorService {    
    @Path("/tiposProveedor")
    @GET @Produces("application/json")
    public TiposProveedor tiposProveedor() {
        return (new TiposProveedor());
    }
    @Path("/cargarTiposProveedorItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarTiposProveedorItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> pccList = new ArrayList();
        try{
            TiposProveedorResource pr = new TiposProveedorResource(utiles.getCon());        
            pccList = pr.cargarTiposProveedorItem();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;
    }
    @Path("/cargarTiposProveedor")
    @GET @Produces("application/json")
    public List<TiposProveedor> cargarTiposProveedor() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<TiposProveedor> pccList = new ArrayList();
        try{
            TiposProveedorResource pr = new TiposProveedorResource(utiles.getCon());     
            pccList = pr.cargarTiposProveedor(new TiposProveedor());
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;
        
    }
    @POST
    @Path("/guardarTiposProveedor")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarTiposProveedor(TiposProveedor tiposProveedor) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposProveedorResource pr = new TiposProveedorResource(utiles.getCon());        
            pr.guardarTiposProveedor(tiposProveedor);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
    @Path("/codigoTiposProveedor")
    @GET @Produces("application/json")
    public String codigoTiposProveedor() {
        return String.valueOf("0");
    }
    @POST
    @Path("/editarTiposProveedor")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarTiposProveedor(TiposProveedor tiposProveedor) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposProveedorResource pr = new TiposProveedorResource(utiles.getCon());        
            pr.editarTiposProveedor(tiposProveedor);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
    @POST
    @Path("/eliminarTiposProveedor")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarTiposProveedor(TiposProveedor tiposProveedor)  throws Exception{
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposProveedorResource pr = new TiposProveedorResource(utiles.getCon());        
            pr.eliminarTiposProveedor(tiposProveedor);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
    
}
