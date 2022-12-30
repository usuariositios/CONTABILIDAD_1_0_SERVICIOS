/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import servicio.model.SelectItem;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import servicio.model.Empresas;
import servicio.resource.ComprobanteResource;
import servicio.resource.EmpresasResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del EmpresasResource
 */
@Stateless
@Path("/empresas")
public class EmpresaService {    
    @Path("/empresas")
    @GET @Produces("application/json")
    public Empresas empresas() {
        return (new Empresas());
    }
    @Path("/cargarEmpresasItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarEmpresasItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        List<SelectItem> empresasList = new ArrayList();
        try{
            EmpresasResource er = new EmpresasResource(utiles.getCon());
            empresasList = er.cargarEmpresaItem();
        }catch(Exception e){e.printStackTrace();}
        utiles.closeConnection();
        return empresasList;
    }
    @POST
    @Path("/cargarEmpresas")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Empresas> cargarEmpresas(Empresas empresas) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        List<Empresas> empresasList = new ArrayList();
        try{
            EmpresasResource er = new EmpresasResource(utiles.getCon());
            empresasList = er.cargarEmpresas(empresas);
        }catch(Exception e){e.printStackTrace();}
        utiles.closeConnection();
        return empresasList;
    }
    @POST
    @Path("/guardarEmpresas")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarEmpresas(Empresas empresas) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        try{
            EmpresasResource er = new EmpresasResource(utiles.getCon());
            er.guardarEmpresa(empresas);
        }catch(Exception e){e.printStackTrace();}
        utiles.closeConnection();
    }
    @POST
    @Path("/editarEmpresas")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarEmpresas(Empresas empresas) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        try{
            EmpresasResource er = new EmpresasResource(utiles.getCon());
            er.editarEmpresa(empresas);
        }catch(Exception e){e.printStackTrace();}
        utiles.closeConnection();
    }
    @POST
    @Path("/eliminarEmpresas")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarEmpresas(Empresas empresas) throws Exception  {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        try{
        EmpresasResource er = new EmpresasResource(utiles.getCon());
        er.eliminarEmpresa(empresas);
        }catch(Exception e){e.printStackTrace();}
        utiles.closeConnection();
    }
    
}
