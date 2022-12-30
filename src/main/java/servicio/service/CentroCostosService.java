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
import servicio.model.CentroCostos;
import servicio.model.Pais;
import servicio.model.SelectItem;
import servicio.resource.CargoResource;
import servicio.resource.CentroCostosResource;
import servicio.util.Utiles;



/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */
@Stateless
@Path("/centroCostos")
public class CentroCostosService {
    
    @Path("/centroCostos")
    @GET @Produces("application/json")
    public CentroCostos centroCostos() {
        return new CentroCostos();
    }
    @POST
    @Path("/cargarCentroCostosItem")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<SelectItem> cargarCentroCostosItem(CentroCostos c) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        CentroCostosResource ccr = new CentroCostosResource(utiles.getCon());
        List<SelectItem> centroCostosList = new ArrayList<>();
        centroCostosList = ccr.cargarCentroCostosItem(c);        
        utiles.closeConnection();
        return centroCostosList;
    }
}
