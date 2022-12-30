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
import servicio.busines.ComprobanteBusiness;

import servicio.model.Comprobante;
import servicio.model.ComprobanteDetalle;
import servicio.model.Mensaje;



import servicio.resource.ComprobanteResource;
import servicio.util.Utiles;



/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */
@Stateless
@Path("/comprobante")
public class ComprobanteService {    
    /*/comprobante/comprobante*/
    @Path("/comprobante")
    @GET @Produces("application/json")
    public Comprobante comprobante() {
        return (new Comprobante());
    }
    /*/comprobante/cargarComprobante*/
    @POST
    @Path("/cargarComprobante")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Comprobante> cargarComprobante(Comprobante comprobante) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<Comprobante> comprobanteList = new ArrayList<>();
        
        try{
            ComprobanteResource cr = new ComprobanteResource(utiles.getCon());
            comprobanteList = cr.cargarComprobante(comprobante);
        }catch(Exception e){e.printStackTrace();}
        utiles.closeConnection();
        return comprobanteList;
    }
    /*/comprobante/guardarComprobante*/
    @POST
    @Path("/guardarComprobante")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarComprobante(Comprobante comprobante) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        try{
            ComprobanteResource cr = new ComprobanteResource(utiles.getCon());
            cr.guardarComprobante(comprobante);
        }catch(Exception e){e.printStackTrace();}
        utiles.closeConnection();
    }
    /*/comprobante/codigoComprobante*/
    @Path("/codigoComprobante")
    @GET    
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String codigoComprobante() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        String codComprobante= "";
        try{
            ComprobanteResource cr = new ComprobanteResource(utiles.getCon());
            codComprobante= String.valueOf(cr.codigoComprobante());
        }catch(Exception e){e.printStackTrace();}
        utiles.closeConnection();
        return codComprobante;
    }
    /*/comprobante/editarComprobante*/
    @POST
    @Path("/editarComprobante")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Mensaje editarComprobante(Comprobante comprobante) throws Exception{
        Mensaje m = new Mensaje();
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        try{
            ComprobanteResource cr = new ComprobanteResource(utiles.getCon());
            m.setCodResp(cr.editarComprobante(comprobante));
        }catch(Exception e){e.printStackTrace();}
        utiles.closeConnection();
        return m;
    }
    /*/comprobante/eliminarComprobante*/
    @POST
    @Path("/eliminarComprobante")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarComprobante(Comprobante comprobante) {
        
    }
    /*/comprobante/nroComprobante*/
    @POST
    @Path("/nroComprobante")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String nroComprobante(Comprobante ia) throws Exception {        
        Utiles utiles = new Utiles();
        utiles.getConnection();
        String nroComprobante = "";
        try{
            ComprobanteResource cr = new ComprobanteResource(utiles.getCon());
            nroComprobante = String.valueOf(cr.nroComprobante(ia));
        }catch(Exception e){e.printStackTrace();}
        utiles.closeConnection();
        return nroComprobante;
    }
    
    /*/comprobante/guardarComprobante*/
    @POST
    @Path("/guardarComprobanteBusiness")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public ComprobanteBusiness guardarComprobanteBusiness(ComprobanteBusiness comprobante) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        utiles.getCon().setAutoCommit(false);
        try{
            ComprobanteResource cr = new ComprobanteResource(utiles.getCon());
            cr.guardarComprobanteBusiness(comprobante);
            utiles.getCon().commit();
            utiles.getCon().setAutoCommit(true);
        }catch(Exception e){e.printStackTrace();
            utiles.getCon().rollback();
        }
        utiles.closeConnection();
        return comprobante;
    }
    /*/comprobante/guardarComprobante*/
    @POST
    @Path("/editarComprobanteBusiness")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Mensaje editarComprobanteBusiness(ComprobanteBusiness comprobante) throws Exception {        
        Utiles utiles = new Utiles();
        utiles.getConnection();
        Mensaje m = new Mensaje();
        utiles.getCon().setAutoCommit(false);
        try{
            ComprobanteResource cr = new ComprobanteResource(utiles.getCon());
            m = cr.editarComprobanteBusiness(comprobante);
            utiles.getCon().commit();
            utiles.getCon().setAutoCommit(true);
        }catch(Exception e){e.printStackTrace();
            utiles.getCon().rollback();
        }
        utiles.closeConnection();
        return m;
    }
    @POST
    @Path("/eliminarComprobanteBusiness")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarComprobanteBusiness(ComprobanteBusiness comprobante) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        try{
            ComprobanteResource cr = new ComprobanteResource(utiles.getCon());
            cr.eliminarComprobanteBusiness(comprobante);
        }catch(Exception e){e.printStackTrace();}
        utiles.closeConnection();
    }
    
}
