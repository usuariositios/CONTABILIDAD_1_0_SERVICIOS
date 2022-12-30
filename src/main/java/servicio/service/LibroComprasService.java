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
import servicio.model.LibroCompras;
import servicio.resource.LibroComprasResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del LibroComprasResource
 */
@Stateless
@Path("/libroCompras")
public class LibroComprasService {    
    @Path("/libroCompras")
    @GET @Produces("application/json")
    public LibroCompras libroCompras() {
        return (new LibroCompras());
    }
    @Path("/cargarLibroComprasItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarLibroComprasItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        List<SelectItem> libroComprasList = new ArrayList();
        try{
            LibroComprasResource lcr = new LibroComprasResource(utiles.getCon());        
            libroComprasList = lcr.cargarLibroComprasItem();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
        return libroComprasList;
    }
    @POST
    @Path("/cargarLibroCompras")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<LibroCompras> cargarLibroCompras(LibroCompras librocompras) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        List<LibroCompras> libroComprasList = new ArrayList();
        try{
            LibroComprasResource lcr = new LibroComprasResource(utiles.getCon());        
            libroComprasList = lcr.cargarLibroCompras(librocompras);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
        return libroComprasList;        
    }
    @POST
    @Path("/guardarLibroCompras")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public LibroCompras guardarLibroCompras(LibroCompras librocompras) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        LibroCompras libroCompras1 = new LibroCompras();
        try{
            LibroComprasResource lcr = new LibroComprasResource(utiles.getCon());        
            libroCompras1 = lcr.guardarLibroCompras(librocompras);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
        return libroCompras1;        
    }
    @POST
    @Path("/editarLibroCompras")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarLibroCompras(LibroCompras librocompras) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        
        try{
            LibroComprasResource lcr = new LibroComprasResource(utiles.getCon());        
            lcr.editarLibroCompras(librocompras);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();                
    }
    @POST
    @Path("/eliminarLibroCompras")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarLibroCompras(LibroCompras librocompras) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        
        try{
            LibroComprasResource lcr = new LibroComprasResource(utiles.getCon());        
            lcr.eliminarLibroCompras(librocompras);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();                
    }
    @POST
    @Path("/buscarLibroCompras")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public LibroCompras buscarLibroCompras(LibroCompras librocompras) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        LibroCompras libroCompras1 = new LibroCompras();
        try{
            LibroComprasResource gr = new LibroComprasResource(utiles.getCon());        
            libroCompras1 = gr.buscarLibroCompras(librocompras);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
        return libroCompras1;        
    }
    
}
