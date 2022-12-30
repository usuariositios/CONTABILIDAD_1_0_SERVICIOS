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
import servicio.model.TiposDocumento;
import servicio.resource.TiposDocumentoResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del TiposDocumentoResource
 */
@Stateless
@Path("/tiposDocumento")
public class TiposDocumentoService {
    @Path("/tiposDocumento")
    @GET @Produces("application/json")
    public TiposDocumento tiposDocumento() {
        return (new TiposDocumento());
    }
    @Path("/cargarTiposDocumentoItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarTiposDocumentoItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> pccList = new ArrayList();
        try{
            TiposDocumentoResource pr = new TiposDocumentoResource(utiles.getCon());        
            pccList = pr.cargarTiposDocumentoItem();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;        
        
    }
    @Path("/cargarTiposDocumento")
    @GET @Produces("application/json")
    public List<TiposDocumento> cargarTiposDocumento() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<TiposDocumento> pccList = new ArrayList();
        try{
            TiposDocumentoResource pr = new TiposDocumentoResource(utiles.getCon());        
            pccList = pr.cargarTiposDocumento(new TiposDocumento());
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;        
        
    }
    @POST
    @Path("/guardarTiposDocumento")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarTiposDocumento(TiposDocumento tiposDocumento) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposDocumentoResource pr = new TiposDocumentoResource(utiles.getCon());        
            pr.guardarTiposDocumento(tiposDocumento);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
    @Path("/codigoTiposDocumento")
    @GET @Produces("application/json")
    public String codigoTiposDocumento() throws Exception {
        return String.valueOf("0");
    }
    @POST
    @Path("/editarTiposDocumento")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarTiposDocumento(TiposDocumento tiposDocumento) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposDocumentoResource pr = new TiposDocumentoResource(utiles.getCon());        
            pr.editarTiposDocumento(tiposDocumento);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
        
    }
    @POST
    @Path("/eliminarTiposDocumento")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarTiposDocumento(TiposDocumento tiposDocumento) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposDocumentoResource pr = new TiposDocumentoResource(utiles.getCon());        
            pr.eliminarTiposDocumento(tiposDocumento);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
    
}
