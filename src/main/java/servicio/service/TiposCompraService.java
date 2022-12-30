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


import servicio.resource.TiposCompraResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */
@Stateless
@Path("/tiposCompra")
public class TiposCompraService {
    @Path("/cargarTiposCompraItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarTiposCompraItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> pccList = new ArrayList();
        try{
            TiposCompraResource pr = new TiposCompraResource(utiles.getCon());        
            pccList = pr.cargarTiposCompraItem();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return pccList;                
    }
}
