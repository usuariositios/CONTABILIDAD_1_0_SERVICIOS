/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import servicio.model.SelectItem;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import servicio.model.ReciboCompras;
import servicio.resource.ReciboComprasResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del ReciboComprasResource
 */
@Stateless
@Path("/reciboCompras")
public class ReciboComprasService {    
    @Path("/reciboCompras")
    @GET @Produces("application/json")
    public ReciboCompras reciboCompras() {
        return (new ReciboCompras());
    }
    @Path("/cargarReciboComprasItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarReciboComprasItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> pccList = new ArrayList();
        try{
            ReciboComprasResource pr = new ReciboComprasResource(utiles.getCon());        
            pccList = pr.cargarReciboComprasItem();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;                
    }
    @POST
    @Path("/cargarReciboCompras")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<ReciboCompras> cargarReciboCompras(ReciboCompras librocompras) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<ReciboCompras> pccList = new ArrayList();
        try{
            ReciboComprasResource pr = new ReciboComprasResource(utiles.getCon());        
            pccList = pr.cargarReciboCompras(librocompras);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;
    }
    @POST
    @Path("/guardarReciboCompras")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public ReciboCompras guardarReciboCompras(ReciboCompras librocompras) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        ReciboCompras pccList = new ReciboCompras();
        try{
            ReciboComprasResource pr = new ReciboComprasResource(utiles.getCon());        
            pccList = pr.guardarReciboCompras(librocompras);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;                        
    }
    @POST
    @Path("/editarReciboCompras")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarReciboCompras(ReciboCompras librocompras) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            ReciboComprasResource pr = new ReciboComprasResource(utiles.getCon());        
            pr.editarReciboCompras(librocompras);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
    @POST
    @Path("/eliminarReciboCompras")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarReciboCompras(ReciboCompras librocompras) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            ReciboComprasResource pr = new ReciboComprasResource(utiles.getCon());        
            pr.eliminarReciboCompras(librocompras);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
    @POST
    @Path("/buscarReciboCompras")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public  ReciboCompras buscarReciboCompras(ReciboCompras reciboCompras) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        ReciboCompras pccList = new ReciboCompras();
        try{
            ReciboComprasResource pr = new ReciboComprasResource(utiles.getCon());        
            pccList = pr.buscarReciboCompras(reciboCompras);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;        
    }
    
}
