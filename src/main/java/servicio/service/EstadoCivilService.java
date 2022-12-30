/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import servicio.model.SelectItem;
import servicio.resource.EstadoCivilResource;
import servicio.util.Utiles;


/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */
@Stateless
@Path("/estadoCivil")
public class EstadoCivilService {
    
    @Path("/cargarEstadoCivilItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarEstadoCivilItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> estadoCivilList = new ArrayList();
        try{
            EstadoCivilResource ecr = new EstadoCivilResource(utiles.getCon());
            estadoCivilList = ecr.cargarEstadoCivilItem();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return estadoCivilList;
    }
    
}
