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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import servicio.model.LibroVentas;
import servicio.resource.LibroComprasResource;
import servicio.resource.LibroVentasResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del LibroVentasResource
 */
@Stateless
@Path("/libroVentas")
public class LibroVentasService {    
    @Path("/libroVentas")
    @GET @Produces("application/json")
    public LibroVentas libroVentas() {
        return (new LibroVentas());
    }
    @Path("/cargarLibroVentasItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarLibroVentasItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> libroVentasList = new ArrayList();
        try{
            LibroVentasResource lvr = new LibroVentasResource(utiles.getCon());        
            libroVentasList = lvr.cargarLibroVentasItem();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
        return libroVentasList;        
    }
    @POST
    @Path("/cargarLibroVentas")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<LibroVentas> cargarLibroVentas(LibroVentas libroventas) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<LibroVentas> libroVentasList = new ArrayList();
        try{
            LibroVentasResource lvr = new LibroVentasResource(utiles.getCon());        
            libroVentasList = lvr.cargarLibroVentas(libroventas);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
        return libroVentasList;        
        
    }
    @POST
    @Path("/guardarLibroVentas")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public LibroVentas guardarLibroVentas(LibroVentas libroventas) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        LibroVentas libroVentas = new LibroVentas();
        try{
            LibroVentasResource lvr = new LibroVentasResource(utiles.getCon());        
            libroVentas = lvr.guardarLibroVentas(libroventas);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
        return libroVentas;        
    }
    @POST
    @Path("/editarLibroVentas")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarLibroVentas(LibroVentas libroventas) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            LibroVentasResource lvr = new LibroVentasResource(utiles.getCon());        
            lvr.editarLibroVentas(libroventas);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
    }
    @POST
    @Path("/eliminarLibroVentas")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarLibroVentas(LibroVentas libroventas) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            LibroVentasResource lvr = new LibroVentasResource(utiles.getCon());        
            lvr.eliminarLibroVentas(libroventas);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
    }
    @POST
    @Path("/buscarLibroVentas")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public LibroVentas buscarLibroVentas(LibroVentas libroventas) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        LibroVentas libroVentasList = new LibroVentas();
        try{
            LibroVentasResource lvr = new LibroVentasResource(utiles.getCon());        
            libroVentasList = lvr.buscarLibroVentas(libroventas);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
        return libroVentasList;        
    }
    
}
