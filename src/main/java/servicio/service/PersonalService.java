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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import servicio.model.Personal;
import servicio.model.SelectItem;
import servicio.resource.PersonalResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */
@Stateless
@Path("/personal")
public class PersonalService {
    @GET
    @Path("/factorial")
    public String factorial(@QueryParam("base") long base) {

        return Long.toString(5*base);
    }
    @Path("/personal")
    @GET @Produces("application/json")
    public Personal personal() {
        return (new Personal());
    }
    @Path("/cargarPersonalItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarPersonalItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> personalList = new ArrayList();
        try{
            PersonalResource pr = new PersonalResource(utiles.getCon());        
            personalList = pr.cargarPersonalItem();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return personalList;        
    }
    @Path("/cargarPersonal")
    @GET @Produces("application/json")
    public List<Personal> cargarPersonal() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<Personal> personalList = new ArrayList();
        try{
            PersonalResource pr = new PersonalResource(utiles.getCon());        
            personalList = pr.cargarPersonal(new Personal());
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return personalList;        
    }
    @POST
    @Path("/guardarPersonal")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarPersonal(Personal personal) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            PersonalResource pr = new PersonalResource(utiles.getCon());        
            pr.guardarPersonal(personal);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        
    }
    @Path("/codigoPersonal")
    @GET @Produces("application/json")
    public String codigoPersonal() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        String codPersonal = "";
        try{
            PersonalResource pr = new PersonalResource(utiles.getCon());        
            codPersonal = String.valueOf(pr.codigoPersonal());
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return codPersonal;
    }
    @POST
    @Path("/editarPersonal")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarPersonal(Personal personal) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            PersonalResource pr = new PersonalResource(utiles.getCon());        
            pr.editarPersonal(personal);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
    }
    @POST
    @Path("/eliminarPersonal")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarPersonal(Personal personal) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try{
            PersonalResource pr = new PersonalResource(utiles.getCon());        
            pr.eliminarPersonal(personal);
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();        
    }
    
}
