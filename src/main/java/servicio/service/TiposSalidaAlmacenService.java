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
import servicio.model.TiposSalidaAlmacen;
import servicio.resource.TiposSalidaAlmacenResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del TiposSalidaAlmacenResource
 */
@Stateless
@Path("/tiposSalidaAlmacen")
public class TiposSalidaAlmacenService {    
    @Path("/tiposSalidaAlmacen")
    @GET @Produces("application/json")
    public TiposSalidaAlmacen tiposSalidaAlmacen() {
        return (new TiposSalidaAlmacen());
    }
    @Path("/cargarTiposSalidaAlmacenItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarTiposSalidaAlmacenItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> pccList = new ArrayList();
        try{
            TiposSalidaAlmacenResource pr = new TiposSalidaAlmacenResource(utiles.getCon());        
            pccList = pr.cargarTiposSalidaAlmacenItem();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;
        
    }
    @Path("/cargarTiposSalidaAlmacen")
    @GET @Produces("application/json")
    public List<TiposSalidaAlmacen> cargarTiposSalidaAlmacen() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<TiposSalidaAlmacen> pccList = new ArrayList();
        try{
            TiposSalidaAlmacenResource pr = new TiposSalidaAlmacenResource(utiles.getCon());        
            pccList = pr.cargarTiposSalidaAlmacen(new TiposSalidaAlmacen());
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;
        
    }
    @POST
    @Path("/guardarTiposSalidaAlmacen")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarTiposSalidaAlmacen(TiposSalidaAlmacen tiposSalidaAlmacen) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposSalidaAlmacenResource pr = new TiposSalidaAlmacenResource(utiles.getCon());        
            pr.guardarTiposSalidaAlmacen(tiposSalidaAlmacen);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
    @Path("/codigoTiposSalidaAlmacen")
    @GET @Produces("application/json")
    public String codigoTiposSalidaAlmacen() {
        return String.valueOf("0");
    }
    @POST
    @Path("/editarTiposSalidaAlmacen")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarTiposSalidaAlmacen(TiposSalidaAlmacen tiposSalidaAlmacen) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposSalidaAlmacenResource pr = new TiposSalidaAlmacenResource(utiles.getCon());        
            pr.editarTiposSalidaAlmacen(tiposSalidaAlmacen);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
        
    }
    @POST
    @Path("/eliminarTiposSalidaAlmacen")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarTiposSalidaAlmacen(TiposSalidaAlmacen tiposSalidaAlmacen) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposSalidaAlmacenResource pr = new TiposSalidaAlmacenResource(utiles.getCon());        
            pr.eliminarTiposSalidaAlmacen(tiposSalidaAlmacen);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
        
    }
    
}
