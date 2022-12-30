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
import servicio.model.TiposPago;
import servicio.resource.TiposPagoResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del TiposPagoResource
 */
@Stateless
@Path("/tiposPago")
public class TiposPagoService {    
    @Path("/tiposPago")
    @GET @Produces("application/json")
    public TiposPago tiposPago() {
        return (new TiposPago());
    }
    @Path("/cargarTiposPagoItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarTiposPagoItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> pccList = new ArrayList();
        try{
            TiposPagoResource pr = new TiposPagoResource(utiles.getCon());        
            pccList = pr.cargarTiposPagoItem();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;                
    }
    @Path("/cargarTiposPago")
    @GET @Produces("application/json")
    public List<TiposPago> cargarTiposPago() throws Exception{
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<TiposPago> pccList = new ArrayList();
        try{
            TiposPagoResource pr = new TiposPagoResource(utiles.getCon());        
            pccList = pr.cargarTiposPago(new TiposPago());
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;                
        
    }
    @POST
    @Path("/guardarTiposPago")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarTiposPago(TiposPago tiposPago)throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposPagoResource pr = new TiposPagoResource(utiles.getCon());        
            pr.guardarTiposPago(tiposPago);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
    @Path("/codigoTiposPago")
    @GET @Produces("application/json")
    public String codigoTiposPago() {
        return String.valueOf("0");
    }
    @POST
    @Path("/editarTiposPago")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarTiposPago(TiposPago tiposPago) throws Exception{
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposPagoResource pr = new TiposPagoResource(utiles.getCon());        
            pr.editarTiposPago(tiposPago);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
    @POST
    @Path("/eliminarTiposPago")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarTiposPago(TiposPago tiposPago) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposPagoResource pr = new TiposPagoResource(utiles.getCon());        
            pr.eliminarTiposPago(tiposPago);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
        
    }
    
}
