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
import servicio.resource.AreaEmpresaResource;
import servicio.util.Utiles;


/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */
@Stateless
@Path("/areasEmpresa")
public class AreaEmpresaService {
    
    @Path("/cargarAreasEmpresaItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarAreasEmpresaItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<SelectItem> areasEmpresaList = new ArrayList();
        try{        
            AreaEmpresaResource aer = new AreaEmpresaResource();
            areasEmpresaList =  aer.cargarAreasEmpresaItem();
        }catch(Exception e)
        {e.printStackTrace();
        }
        utiles.closeConnection();
        return areasEmpresaList;
    }
}
