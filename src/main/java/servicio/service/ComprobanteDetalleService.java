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
import servicio.model.Comprobante;
import servicio.model.ComprobanteDetalle;
import servicio.resource.ComprobanteDetalleResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del ComprobanteDetalleResource
 */
@Stateless
@Path("/comprobanteDetalle")
public class ComprobanteDetalleService {
    /*/comprobanteDetalle/comprobanteDetalle*/
    @Path("/comprobanteDetalle")
    @GET @Produces("application/json")
    public ComprobanteDetalle comprobanteDetalle() {
        return (new ComprobanteDetalle());
    }
    /*/comprobanteDetalle/cargarComprobanteDetalle*/
    @POST
    @Path("/cargarComprobanteDetalle")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<ComprobanteDetalle> cargarComprobanteDetalle(Comprobante c) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<ComprobanteDetalle> comprobanteDetalleList = new ArrayList<>();
        try{
            ComprobanteDetalleResource  cdr = new ComprobanteDetalleResource(utiles.getCon());
            comprobanteDetalleList = cdr.cargarComprobanteDetalle(c);
        }catch(Exception e){e.printStackTrace();}
        utiles.closeConnection();
        return comprobanteDetalleList;
    }
    /*/comprobanteDetalle/guardarComprobanteDetalle*/
    @POST
    @Path("/guardarComprobanteDetalle")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarComprobanteDetalle(ComprobanteDetalle comprobanteDetalle) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        try{
            ComprobanteDetalleResource cdr = new ComprobanteDetalleResource(utiles.getCon());
            cdr.guardarComprobanteDetalle(comprobanteDetalle);
            }catch(Exception e){e.printStackTrace();}
        utiles.closeConnection();
        
    }
    /*/comprobanteDetalle/codigoComprobanteDetalle*/
    @Path("/codigoComprobanteDetalle")
    @GET @Produces("application/json")
    public String codigoComprobanteDetalle()throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        String codigoComprobanteDetalle = "";
        try{
            ComprobanteDetalleResource cdr = new ComprobanteDetalleResource(utiles.getCon());
            codigoComprobanteDetalle = String.valueOf(cdr.codigoComprobanteDetalle(new Comprobante()));
        }catch(Exception e){e.printStackTrace();}
        utiles.closeConnection();
        return codigoComprobanteDetalle;
    }
    /*/comprobanteDetalle/editarComprobanteDetalle*/
    @POST
    @Path("/editarComprobanteDetalle")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarComprobanteDetalle(ComprobanteDetalle comprobanteDetalle) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        ComprobanteDetalleResource cdr = new ComprobanteDetalleResource(utiles.getCon());
        try{
            cdr.editarComprobanteDetalle(comprobanteDetalle);
        }catch(Exception e){e.printStackTrace();}
        utiles.closeConnection();
    }
    /*/comprobanteDetalle/borraComprobanteDetalle*/
    @POST
    @Path("/borraComprobanteDetalle")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void borraComprobanteDetalle(ComprobanteDetalle comprobanteDetalle) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        ComprobanteDetalleResource cdr = new ComprobanteDetalleResource(utiles.getCon());
        try{
        cdr.borraComprobanteDetalle(comprobanteDetalle);
        }catch(Exception e){e.printStackTrace();}
        utiles.closeConnection();
    }
    
    @POST
    @Path("/buscarComprobanteDetalle")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public ComprobanteDetalle buscarComprobanteDetalle(ComprobanteDetalle c) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        ComprobanteDetalle cd = new ComprobanteDetalle();
        try{
            ComprobanteDetalleResource  cdr = new ComprobanteDetalleResource(utiles.getCon());
            cd = cdr.buscarComprobanteDetalle(c);
            }catch(Exception e){e.printStackTrace();}
        utiles.closeConnection();
        return cd ;
    }
    
    
}
