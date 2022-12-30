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

import servicio.resource.EstadosComprobanteResource;
import servicio.util.Utiles;



/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */
@Stateless
@Path("/estadosComprobante")
public class EstadosComprobanteService {
    
    @Path("/cargarEstadosComprobanteItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarEstadosComprobanteItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> estadoComprobanteList = new ArrayList();
        try{
            EstadosComprobanteResource ecr = new EstadosComprobanteResource(utiles.getCon());        
            estadoComprobanteList = ecr.cargarEstadosComprobanteItem();
        }catch(Exception ex){ex.printStackTrace();        
        }
        utiles.closeConnection();
        return estadoComprobanteList;
    }
}
