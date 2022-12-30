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
import servicio.model.TiposComprobante;
import servicio.resource.TiposComprobanteResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del TiposComprobanteResource
 */
@Stateless
@Path("/tiposComprobante")
public class TiposComprobanteService {
    @Path("/tiposComprobante")
    @GET @Produces("application/json")
    public TiposComprobante tiposComprobante() {
        return (new TiposComprobante());
    }
    @Path("/cargarTiposComprobanteItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarTiposComprobanteItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> pccList = new ArrayList();
        try{
            TiposComprobanteResource pr = new TiposComprobanteResource(utiles.getCon());        
            pccList = pr.cargarTiposComprobanteItem();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;
    }
    @Path("/cargarTiposComprobante")
    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<TiposComprobante> cargarTiposComprobante(TiposComprobante t) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<TiposComprobante> pccList = new ArrayList();
        try{
            TiposComprobanteResource pr = new TiposComprobanteResource(utiles.getCon());        
            pccList = pr.cargarTiposComprobante(t);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;        
    }
    @POST
    @Path("/guardarTiposComprobante")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarTiposComprobante(TiposComprobante tiposComprobante) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposComprobanteResource pr = new TiposComprobanteResource(utiles.getCon());        
            pr.guardarTiposComprobante(tiposComprobante);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
        
    }
    @Path("/codigoTiposComprobante")
    @GET @Produces("application/json")
    public String codigoTiposComprobante() {
        return String.valueOf("0");
    }
    @POST
    @Path("/editarTiposComprobante")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarTiposComprobante(TiposComprobante tiposComprobante) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposComprobanteResource pr = new TiposComprobanteResource(utiles.getCon());        
            pr.editarTiposComprobante(tiposComprobante);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
    @POST
    @Path("/eliminarTiposComprobante")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarTiposComprobante(TiposComprobante tiposComprobante) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposComprobanteResource pr = new TiposComprobanteResource(utiles.getCon());        
            pr.eliminarTiposComprobante(tiposComprobante);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
    
}
