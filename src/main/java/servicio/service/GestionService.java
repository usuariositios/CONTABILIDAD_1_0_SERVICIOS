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
import servicio.model.EstadosOrdenCompra;
import servicio.model.Gestion;
import servicio.resource.EstadosOrdenesCompraResource;
import servicio.resource.GestionResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del GestionResource
 */
@Stateless
@Path("/gestion")
public class GestionService {    
    @Path("/gestion")
    @GET @Produces("application/json")
    public Gestion gestion() {
        return (new Gestion());
    }        
    @POST
    @Path("/cargarGestion")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Gestion> cargarGestion() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<Gestion> gestionList = new ArrayList();
        try{
            GestionResource err = new GestionResource(utiles.getCon());        
            gestionList = err.cargarGestiones();
        }catch(Exception ex){ex.printStackTrace();
        }
        utiles.closeConnection();
        return gestionList;                
        
    }
    @Path("/cargarGestionItem")
    @GET @Produces("application/json")
    public List<servicio.model.SelectItem> cargarGestionItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<servicio.model.SelectItem> gestionList = new ArrayList();
        try{
            GestionResource eocr = new GestionResource(utiles.getCon());        
            gestionList = eocr.cargarGestionItem();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return gestionList;                
    }
    @POST
    @Path("/guardarGestion")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarGestion(Gestion gestion) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        try{
            GestionResource gr = new GestionResource(utiles.getCon());        
            gr.guardarGestion(gestion);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
    }    
    @POST
    @Path("/editarGestion")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarGestion(Gestion gestion) throws Exception{
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        try{
            GestionResource gr = new GestionResource(utiles.getCon());        
            gr.editarGestion(gestion);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
        
    }
    @POST
    @Path("/eliminarGestion")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarGestion(Gestion gestion) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        try{
            GestionResource gr = new GestionResource(utiles.getCon());        
            gr.eliminarGestion(gestion);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
    }
    @GET
    @Path("/gestionActiva")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Gestion gestionActiva() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        Gestion g = new Gestion();
        try{
            GestionResource gr = new GestionResource(utiles.getCon());        
            g = gr.gestionActiva();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
        return g;
    }
    
    
    @POST
    @Path("/buscarGestion")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Gestion buscarGestion(Gestion g) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        Gestion g1 = new Gestion();
        try{
            GestionResource gr = new GestionResource(utiles.getCon());        
            g1 = gr.buscarGestion(g);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
        return g1;
    }
   
    
}
