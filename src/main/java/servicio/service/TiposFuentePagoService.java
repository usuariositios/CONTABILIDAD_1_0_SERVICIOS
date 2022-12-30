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
import servicio.model.TiposFuentePago;
import servicio.resource.TiposFuentePagoResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del TiposFuentePagoResource
 */
@Stateless
@Path("/tiposFuentePago")
public class TiposFuentePagoService {    
    @Path("/tiposFuentePago")
    @GET @Produces("application/json")
    public TiposFuentePago tiposFuentePago() {
        return (new TiposFuentePago());
    }
    @Path("/cargarTiposFuentePagoItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarTiposFuentePagoItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> pccList = new ArrayList();
        try{
            TiposFuentePagoResource pr = new TiposFuentePagoResource(utiles.getCon());        
            pccList = pr.cargarTiposFuentePagoItem();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;        
        
    }
    @Path("/cargarTiposFuentePago")
    @GET @Produces("application/json")
    public List<TiposFuentePago> cargarTiposFuentePago() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<TiposFuentePago> pccList = new ArrayList();
        try{
            TiposFuentePagoResource pr = new TiposFuentePagoResource(utiles.getCon());        
            pccList = pr.cargarTiposFuentePago(new TiposFuentePago());
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;        
        
    }
    @POST
    @Path("/guardarTiposFuentePago")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarTiposFuentePago(TiposFuentePago tiposFuentePago) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposFuentePagoResource pr = new TiposFuentePagoResource(utiles.getCon());        
            pr.guardarTiposFuentePago(tiposFuentePago);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
    @Path("/codigoTiposFuentePago")
    @GET @Produces("application/json")
    public String codigoTiposFuentePago() {
        return String.valueOf("0");
    }
    @POST
    @Path("/editarTiposFuentePago")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarTiposFuentePago(TiposFuentePago tiposFuentePago) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposFuentePagoResource pr = new TiposFuentePagoResource(utiles.getCon());        
            pr.editarTiposFuentePago(tiposFuentePago);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
        
    }
    @POST
    @Path("/eliminarTiposFuentePago")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarTiposFuentePago(TiposFuentePago tiposFuentePago) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposFuentePagoResource pr = new TiposFuentePagoResource(utiles.getCon());        
            pr.eliminarTiposFuentePago(tiposFuentePago);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
    
}
