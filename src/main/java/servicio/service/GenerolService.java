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
import servicio.resource.GeneroResource;
import servicio.util.Utiles;


/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */
@Stateless
@Path("/genero")
public class GenerolService {
    
    @Path("/cargarGeneroItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarGeneroItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> generoList = new ArrayList();
        try{
            GeneroResource err = new GeneroResource(utiles.getCon());        
            generoList = err.cargarGeneroItem();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return generoList;                
        
    }
}
