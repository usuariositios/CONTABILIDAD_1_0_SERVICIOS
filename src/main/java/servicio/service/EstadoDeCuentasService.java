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
import servicio.model.Comprobante;
import servicio.model.EstadoDeCuenta;
import servicio.resource.EmpresasResource;
import servicio.resource.EstadoDeCuentasResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del EstadoDeCuentaResource
 */
@Stateless
@Path("/estadoDeCuenta")
public class EstadoDeCuentasService {
    /*/comprobanteDetalle/comprobanteDetalle*/
    @Path("/estadoDeCuenta")
    @GET @Produces("application/json")
    public EstadoDeCuenta estadoDeCuenta() {
        return (new EstadoDeCuenta());
    }
    /*/comprobanteDetalle/cargarEstadoDeCuenta*/
    @POST
    @Path("/cargarEstadoDeCuenta")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<EstadoDeCuenta> cargarEstadoDeCuenta(EstadoDeCuenta e) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<EstadoDeCuenta> estadoDeCuentaList = new ArrayList();
        try{
            EstadoDeCuentasResource ecr = new EstadoDeCuentasResource(utiles.getCon());
            estadoDeCuentaList = ecr.cargarEstadoDeCuenta(e);
        }catch(Exception ex){ex.printStackTrace();}
        utiles.closeConnection();
        return estadoDeCuentaList;
    }
    /*/comprobanteDetalle/cargarEstadoDeCuentaEditar*/
    @POST
    @Path("/cargarEstadoDeCuentaEditar")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<EstadoDeCuenta> cargarEstadoDeCuentaEditar(EstadoDeCuenta e) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<EstadoDeCuenta> estadoDeCuentaList = new ArrayList();
        try{
            EstadoDeCuentasResource ecr = new EstadoDeCuentasResource(utiles.getCon());
            estadoDeCuentaList=ecr.cargarEstadoDeCuentaEditar(e);
        }catch(Exception ex){ex.printStackTrace();}
        utiles.closeConnection();
        return estadoDeCuentaList;
    }
    /*/comprobanteDetalle/guardarEstadoDeCuenta*/
    @POST
    @Path("/guardarEstadoDeCuenta")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarEstadoDeCuenta(EstadoDeCuenta e) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        try{
            EstadoDeCuentasResource ecr = new EstadoDeCuentasResource(utiles.getCon());
            ecr.guardarEstadoDeCuenta(e);
            }catch(Exception ex){ex.printStackTrace();}
        utiles.closeConnection();        
    }
    /*/comprobanteDetalle/codigoEstadoDeCuenta*/
    @Path("/codigoEstadoDeCuenta")
    @GET @Produces("application/json")
    public String codigoEstadoDeCuenta() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        String codEstadoDeCuenta = "";
        try{
            EstadoDeCuentasResource ecr = new EstadoDeCuentasResource(utiles.getCon());
            codEstadoDeCuenta = String.valueOf(ecr.codigoEstadoDeCuenta());
            }catch(Exception ex){ex.printStackTrace();}
        utiles.closeConnection();
        return codEstadoDeCuenta;
    }
    /*/comprobanteDetalle/editarEstadoDeCuenta*/
    @POST
    @Path("/editarEstadoDeCuenta")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarEstadoDeCuenta(EstadoDeCuenta e) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        try{
            EstadoDeCuentasResource ecr = new EstadoDeCuentasResource(utiles.getCon());
            ecr.editarEstadoDeCuenta(e);
            }catch(Exception ex){ex.printStackTrace();}
        utiles.closeConnection();
    }
    /*/comprobanteDetalle/borraEstadoDeCuenta*/
    @POST
    @Path("/borraEstadoDeCuenta")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void borraEstadoDeCuenta(EstadoDeCuenta e) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        utiles.getCon().setAutoCommit(false);
        try{
            EstadoDeCuentasResource ecr = new EstadoDeCuentasResource(utiles.getCon());
            ecr.borraEstadoDeCuenta(e);
            utiles.commit();
            utiles.setAutoCommit(true);
        }catch(Exception ex){ex.printStackTrace();
        utiles.getCon().rollback();
        }
        utiles.closeConnection();
    }
    
    @POST
    @Path("/buscarEstadoDeCuenta")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public EstadoDeCuenta buscarEstadoDeCuenta(EstadoDeCuenta e) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        EstadoDeCuenta ec = new EstadoDeCuenta();
        try{
            EstadoDeCuentasResource ecr = new EstadoDeCuentasResource(utiles.getCon());
            ecr.borraEstadoDeCuenta(e);        
            ec = ecr.buscarEstadoDeCuenta(e);
        }catch(Exception ex){ex.printStackTrace();
        
        }
        utiles.closeConnection();
        return ec;
    }
    
    
}
