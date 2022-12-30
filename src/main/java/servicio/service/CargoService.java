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
import servicio.resource.CargoResource;
import servicio.util.Utiles;


/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */
@Stateless
@Path("/cargo")
public class CargoService {
    @Path("/cargarCargoItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarCargoItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> cargoList = new ArrayList<>();
        
        CargoResource cr = new CargoResource();
        cargoList = cr.cargarCargoItem();
        utiles.closeConnection();
        
        return cargoList;
    }
}
