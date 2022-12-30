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
import servicio.model.Monedas;
import servicio.resource.LibroVentasResource;
import servicio.resource.MonedaResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del MonedaResource
 */
@Stateless
@Path("/moneda")
public class MonedaService {
    @Path("/moneda")
    @GET @Produces("application/json")
    public Monedas moneda() {
        return (new Monedas());
    }
    @Path("/cargarMoneda")
    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Monedas> cargarMoneda(Monedas m) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<Monedas> monedaList = new ArrayList();
        try{
            MonedaResource mr = new MonedaResource(utiles.getCon());        
            monedaList = mr.cargarMonedas(m);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return monedaList;
    }
    @Path("/cargarMonedasItem")
    @GET @Produces("application/json")
    public List<servicio.model.SelectItem> cargarMonedasItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<servicio.model.SelectItem> monedaList = new ArrayList();
        try{
            MonedaResource mr = new MonedaResource(utiles.getCon());        
            monedaList = mr.cargarMonedasItem();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return monedaList;        
    }
    @POST
    @Path("/guardarMoneda")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarMoneda(Monedas moneda) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            MonedaResource mr = new MonedaResource(utiles.getCon());        
            mr.guardarMoneda(moneda);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
    }    
    @POST
    @Path("/editarMoneda")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarMoneda(Monedas moneda) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            MonedaResource mr = new MonedaResource(utiles.getCon());        
            mr.editarMonedas(moneda);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
    }
    @POST
    @Path("/eliminarMoneda")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarMoneda(Monedas moneda) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            MonedaResource mr = new MonedaResource(utiles.getCon());        
            mr.eliminarMonedas(moneda);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
    }    
}
