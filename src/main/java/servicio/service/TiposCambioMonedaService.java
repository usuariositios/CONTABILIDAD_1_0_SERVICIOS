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
import servicio.model.TiposCambioMoneda;
import servicio.resource.TiposCambioMonedaResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del TiposCambioMonedaResource
 */
@Stateless
@Path("/tiposCambioMoneda")
public class TiposCambioMonedaService {
    @Path("/tiposCambioMoneda")
    @GET @Produces("application/json")
    public TiposCambioMoneda tiposCambioMoneda() {
        return (new TiposCambioMoneda());
    }
    @Path("/cargarTiposCambioMonedaItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarTiposCambioMonedaItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> pccList = new ArrayList();
        try{
            TiposCambioMonedaResource pr = new TiposCambioMonedaResource(utiles.getCon());        
            pccList = pr.cargarTiposCambioMonedaItem();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;
        
    }
    @Path("/cargarTiposCambioMoneda")
    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<TiposCambioMoneda> cargarTiposCambioMoneda(TiposCambioMoneda t) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<TiposCambioMoneda> pccList = new ArrayList();
        try{
            TiposCambioMonedaResource pr = new TiposCambioMonedaResource(utiles.getCon());        
            pccList = pr.cargarTiposCambioMoneda(t);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;
    }
    @Path("/buscarTiposCambioMoneda")
    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public TiposCambioMoneda buscarTiposCambioMoneda(TiposCambioMoneda t) throws Exception{
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TiposCambioMoneda tcm = new TiposCambioMoneda();
        try{
            TiposCambioMonedaResource pr = new TiposCambioMonedaResource(utiles.getCon());        
            tcm = pr.buscarTiposCambioMoneda(t);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return tcm;
    }
    @POST
    @Path("/guardarTiposCambioMoneda")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarTiposCambioMoneda(TiposCambioMoneda tiposCambioMoneda) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        try{
            TiposCambioMonedaResource pr = new TiposCambioMonedaResource(utiles.getCon());        
            pr.guardarTiposCambioMoneda(tiposCambioMoneda);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
    }
    @Path("/codigoTiposCambioMoneda")
    @GET @Produces("application/json")
    public String codigoTiposCambioMoneda() {
        return String.valueOf("0");
    }
    @POST
    @Path("/editarTiposCambioMoneda")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarTiposCambioMoneda(TiposCambioMoneda tiposCambioMoneda) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposCambioMonedaResource pr = new TiposCambioMonedaResource(utiles.getCon());        
            pr.editarTiposCambioMoneda(tiposCambioMoneda);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
    @POST
    @Path("/eliminarTiposCambioMoneda")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarTiposCambioMoneda(TiposCambioMoneda tiposCambioMoneda) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposCambioMonedaResource pr = new TiposCambioMonedaResource(utiles.getCon());        
            pr.eliminarTiposCambioMoneda(tiposCambioMoneda);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
    
}
