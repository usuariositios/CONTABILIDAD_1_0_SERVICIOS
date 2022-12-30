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
import servicio.model.TiposCentroCostos;
import servicio.resource.TiposCentroCostosResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del TiposCentroCostosResource
 */
@Stateless
@Path("/tiposCentroCostos")
public class TiposCentroCostosService {    
    @Path("/tiposCentroCostos")
    @GET @Produces("application/json")
    public TiposCentroCostos tiposCentroCostos() {
        return (new TiposCentroCostos());
    }
    @Path("/cargarTiposCentroCostosItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarTiposCentroCostosItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> pccList = new ArrayList();
        try{
            TiposCentroCostosResource pr = new TiposCentroCostosResource(utiles.getCon());        
            pccList = pr.cargarTiposCentroCostosItem();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;        
    }
    @Path("/cargarTiposCentroCostos")
    @GET @Produces("application/json")
    public List<TiposCentroCostos> cargarTiposCentroCostos() throws Exception{
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<TiposCentroCostos> pccList = new ArrayList();
        try{
            TiposCentroCostosResource pr = new TiposCentroCostosResource(utiles.getCon());        
            pccList = pr.cargarTiposCentroCostos(new TiposCentroCostos());
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;
    }
    @POST
    @Path("/guardarTiposCentroCostos")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarTiposCentroCostos(TiposCentroCostos tiposCentroCostos)  throws Exception{
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposCentroCostosResource pr = new TiposCentroCostosResource(utiles.getCon());        
            pr.guardarTiposCentroCostos(tiposCentroCostos);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
    @Path("/codigoTiposCentroCostos")
    @GET @Produces("application/json")
    public String codigoTiposCentroCostos() throws Exception {
        return String.valueOf("0");
    }
    @POST
    @Path("/editarTiposCentroCostos")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarTiposCentroCostos(TiposCentroCostos tiposCentroCostos) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposCentroCostosResource pr = new TiposCentroCostosResource(utiles.getCon());        
            pr.editarTiposCentroCostos(tiposCentroCostos);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
    @POST
    @Path("/eliminarTiposCentroCostos")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarTiposCentroCostos(TiposCentroCostos tiposCentroCostos) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposCentroCostosResource pr = new TiposCentroCostosResource(utiles.getCon());        
            pr.eliminarTiposCentroCostos(tiposCentroCostos);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
    }
    
}
