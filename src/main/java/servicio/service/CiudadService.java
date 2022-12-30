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
import servicio.model.Pais;
import servicio.model.SelectItem;
import servicio.resource.CentroCostosResource;
import servicio.resource.CiudadResource;
import servicio.util.Utiles;



/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */
@Stateless
@Path("/ciudad")
public class CiudadService {
    
    @Path("/cargarCiudadItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarCiudadItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        CiudadResource cr = new CiudadResource(utiles.getCon());
        List<SelectItem> ciudadList = new ArrayList<>();
        ciudadList = cr.cargarCiudadItem(new Pais());
        utiles.closeConnection();
        return ciudadList;
        
    }
}
