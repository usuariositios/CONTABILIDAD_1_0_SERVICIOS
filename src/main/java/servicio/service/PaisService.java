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
import servicio.resource.PaisResource;
import servicio.util.Utiles;


/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */
@Stateless
@Path("/pais")
public class PaisService {
    
    @Path("/cargarPaisItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarPaisItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> paisList = new ArrayList();
        try{
            PaisResource mr = new PaisResource(utiles.getCon());        
            paisList = mr.cargarPaisItem();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return paisList;        
    }
    
}
