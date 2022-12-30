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


import servicio.resource.TiposTransporteResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */
@Stateless
@Path("/tiposTransporte")
public class TiposTransporteService {
    @Path("/cargarTiposTransporteItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarTiposTransporteItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> pccList = new ArrayList();
        try{
            TiposTransporteResource pr = new TiposTransporteResource(utiles.getCon());        
            pccList = pr.cargarTiposTransporteItem();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;
        
    }
}
