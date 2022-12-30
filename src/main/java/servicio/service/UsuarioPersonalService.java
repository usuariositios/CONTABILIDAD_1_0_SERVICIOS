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
import servicio.model.UsuarioPersonal;
import servicio.resource.UsuarioPersonalResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del UsuarioPersonalResource
 */
@Stateless
@Path("/usuarioPersonal")
public class UsuarioPersonalService {    
    @Path("/usuarioPersonal")
    @GET @Produces("application/json")
    public UsuarioPersonal usuarioPersonal() {
        return (new UsuarioPersonal());
    }    
    @Path("/cargarUsuarioPersonal")
    @POST @Produces("application/json")
    public List<UsuarioPersonal> cargarUsuarioPersonal() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<UsuarioPersonal> pccList = new ArrayList();
        try{
            UsuarioPersonalResource pr = new UsuarioPersonalResource(utiles.getCon());        
            pccList = pr.cargarUsuarioPersonales(new UsuarioPersonal());
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;
        
    }
    @POST
    @Path("/guardarUsuarioPersonal")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarUsuarioPersonal(UsuarioPersonal personal) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            UsuarioPersonalResource pr = new UsuarioPersonalResource(utiles.getCon());        
            pr.guardarUsuarioPersonal(personal);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
    @Path("/codigoUsuarioPersonal")
    @GET @Produces("application/json")
    public String codigoUsuarioPersonal() throws Exception  {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        String pccList = "";
        try{
            UsuarioPersonalResource pr = new UsuarioPersonalResource(utiles.getCon());        
            pccList = String.valueOf(pr.codigoUsuarioPersonal());
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;
        
    }
    @POST
    @Path("/buscarUsuarioPersonal")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public UsuarioPersonal buscarUsuarioPersonal(UsuarioPersonal personal) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        UsuarioPersonal pccList = new UsuarioPersonal();
        try{
            UsuarioPersonalResource pr = new UsuarioPersonalResource(utiles.getCon());        
            pccList = pr.buscarUsuarioPersonal(personal);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;
        
    }
    /*@POST
    @Path("/editarUsuarioPersonal")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarUsuarioPersonal(UsuarioPersonal personal) {
        UsuarioPersonalResource.editarUsuarioPersonal(personal);
    }
    @POST
    @Path("/eliminarUsuarioPersonal")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarUsuarioPersonal(UsuarioPersonal personal) {
        UsuarioPersonalResource.eliminarUsuarioPersonal(personal);
    }*/
    
}
