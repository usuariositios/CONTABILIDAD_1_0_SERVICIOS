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
import servicio.model.TiposIngresoAlmacen;
import servicio.resource.TiposIngresoAlmacenResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del TiposIngresoAlmacenResource
 */
@Stateless
@Path("/tiposIngresoAlmacen")
public class TiposIngresoAlmacenService {    
    @Path("/tiposIngresoAlmacen")
    @GET @Produces("application/json")
    public TiposIngresoAlmacen tiposIngresoAlmacen() {
        return (new TiposIngresoAlmacen());
    }
    @Path("/cargarTiposIngresoAlmacenItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarTiposIngresoAlmacenItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> pccList = new ArrayList();
        try{
            TiposIngresoAlmacenResource pr = new TiposIngresoAlmacenResource(utiles.getCon());        
            pccList = pr.cargarTiposIngresoAlmacenItem();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;        
        
    }
    @Path("/cargarTiposIngresoAlmacen")
    @GET @Produces("application/json")
    public List<TiposIngresoAlmacen> cargarTiposIngresoAlmacen() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<TiposIngresoAlmacen> pccList = new ArrayList();
        try{
            TiposIngresoAlmacenResource pr = new TiposIngresoAlmacenResource(utiles.getCon());        
            pccList = pr.cargarTiposIngresoAlmacen(new TiposIngresoAlmacen());
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;        
        
    }
    @POST
    @Path("/guardarTiposIngresoAlmacen")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarTiposIngresoAlmacen(TiposIngresoAlmacen tiposIngresoAlmacen) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposIngresoAlmacenResource pr = new TiposIngresoAlmacenResource(utiles.getCon());        
            pr.guardarTiposIngresoAlmacen(tiposIngresoAlmacen);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
    @Path("/codigoTiposIngresoAlmacen")
    @GET @Produces("application/json")
    public String codigoTiposIngresoAlmacen() {
        return String.valueOf("0");
    }
    @POST
    @Path("/editarTiposIngresoAlmacen")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarTiposIngresoAlmacen(TiposIngresoAlmacen tiposIngresoAlmacen) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposIngresoAlmacenResource pr = new TiposIngresoAlmacenResource(utiles.getCon());        
            pr.editarTiposIngresoAlmacen(tiposIngresoAlmacen);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
        
    }
    @POST
    @Path("/eliminarTiposIngresoAlmacen")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarTiposIngresoAlmacen(TiposIngresoAlmacen tiposIngresoAlmacen) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposIngresoAlmacenResource pr = new TiposIngresoAlmacenResource(utiles.getCon());        
            pr.eliminarTiposIngresoAlmacen(tiposIngresoAlmacen);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
    
}
