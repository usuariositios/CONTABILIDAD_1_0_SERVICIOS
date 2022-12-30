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
import servicio.model.TiposDocumentoLibroCompras;
import servicio.resource.TiposDocumentoLibroComprasResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del TiposDocumentoLibroComprasResource
 */
@Stateless
@Path("/tiposDocumentoLibroCompras")
public class TiposDocumentoLibroComprasService {
    @Path("/tiposDocumentoLibroCompras")
    @GET @Produces("application/json")
    public TiposDocumentoLibroCompras tiposDocumentoLibroCompras() {
        return (new TiposDocumentoLibroCompras());
    }
    @Path("/cargarTiposDocumentoLibroComprasItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarTiposDocumentoLibroComprasItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> pccList = new ArrayList();
        try{
            TiposDocumentoLibroComprasResource pr = new TiposDocumentoLibroComprasResource(utiles.getCon());        
            pccList = pr.cargarTiposDocumentoLibroComprasItem();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;        
        
    }
    @Path("/cargarTiposDocumentoLibroCompras")
    @GET @Produces("application/json")
    public List<TiposDocumentoLibroCompras> cargarTiposDocumentoLibroCompras() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<TiposDocumentoLibroCompras> pccList = new ArrayList();
        try{
            TiposDocumentoLibroComprasResource pr = new TiposDocumentoLibroComprasResource(utiles.getCon());        
            pccList = pr.cargarTiposDocumentoLibroCompras(new TiposDocumentoLibroCompras());
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;        
        
    }
    @POST
    @Path("/guardarTiposDocumentoLibroCompras")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarTiposDocumentoLibroCompras(TiposDocumentoLibroCompras tiposDocumentoLibroCompras) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposDocumentoLibroComprasResource pr = new TiposDocumentoLibroComprasResource(utiles.getCon());        
            pr.guardarTiposDocumentoLibroCompras(tiposDocumentoLibroCompras);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
    @Path("/codigoTiposDocumentoLibroCompras")
    @GET @Produces("application/json")
    public String codigoTiposDocumentoLibroCompras() throws Exception {
        return String.valueOf("0");
    }
    @POST
    @Path("/editarTiposDocumentoLibroCompras")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarTiposDocumentoLibroCompras(TiposDocumentoLibroCompras tiposDocumentoLibroCompras) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposDocumentoLibroComprasResource pr = new TiposDocumentoLibroComprasResource(utiles.getCon());        
            pr.editarTiposDocumentoLibroCompras(tiposDocumentoLibroCompras);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
    }
    @POST
    @Path("/eliminarTiposDocumentoLibroCompras")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarTiposDocumentoLibroCompras(TiposDocumentoLibroCompras tiposDocumentoLibroCompras)  throws Exception{
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            TiposDocumentoLibroComprasResource pr = new TiposDocumentoLibroComprasResource(utiles.getCon());        
            pr.eliminarTiposDocumentoLibroCompras(tiposDocumentoLibroCompras);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
    }
    
}
