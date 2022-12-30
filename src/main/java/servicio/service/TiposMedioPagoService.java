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
import servicio.model.TiposMedioPago;
import servicio.resource.TiposMedioPagoResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del TiposMedioPagoResource
 */
@Stateless
@Path("/tiposMedioPago")
public class TiposMedioPagoService {    
    @Path("/tiposMedioPago")
    @GET @Produces("application/json")
    public TiposMedioPago tiposMedioPago() {
        return (new TiposMedioPago());
    }
    @Path("/cargarTiposMedioPagoItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarTiposMedioPagoItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> pccList = new ArrayList();
        try{
            TiposMedioPagoResource pr = new TiposMedioPagoResource(utiles.getCon());        
            pccList = pr.cargarTiposMedioPagoItem();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;        
        
    }
    @Path("/cargarTiposMedioPago")
    @GET @Produces("application/json")
    public List<TiposMedioPago> cargarTiposMedioPago() throws Exception {        
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<TiposMedioPago> pccList = new ArrayList();
        try{
            TiposMedioPagoResource pr = new TiposMedioPagoResource(utiles.getCon());        
            pccList = pr.cargarTiposMedioPago(new TiposMedioPago());
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;        
        
    }
    @POST
    @Path("/guardarTiposMedioPago")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarTiposMedioPago(TiposMedioPago tiposMedioPago) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposMedioPagoResource pr = new TiposMedioPagoResource(utiles.getCon());        
            pr.guardarTiposMedioPago(tiposMedioPago);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
    @Path("/codigoTiposMedioPago")
    @GET @Produces("application/json")
    public String codigoTiposMedioPago() throws Exception {
        return String.valueOf("0");
    }
    @POST
    @Path("/editarTiposMedioPago")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarTiposMedioPago(TiposMedioPago tiposMedioPago) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposMedioPagoResource pr = new TiposMedioPagoResource(utiles.getCon());        
            pr.editarTiposMedioPago(tiposMedioPago);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
        
    }
    @POST
    @Path("/eliminarTiposMedioPago")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarTiposMedioPago(TiposMedioPago tiposMedioPago) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposMedioPagoResource pr = new TiposMedioPagoResource(utiles.getCon());        
            pr.eliminarTiposMedioPago(tiposMedioPago);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
        
    }
    
}
