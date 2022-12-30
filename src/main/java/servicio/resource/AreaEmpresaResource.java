/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.resource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import servicio.model.SelectItem;

import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class AreaEmpresaResource {
    Connection con;
    public AreaEmpresaResource(){
    }
    public AreaEmpresaResource(Connection con){
        this.con = con;
    }
    public List cargarAreasEmpresaItem() throws Exception  {
            List areaEmpresaList =new ArrayList();
        
        try {
            
            String query = " select a.COD_AREA_EMPRESA,a.NOMBRE_AREA_EMPRESA from AREAS_EMPRESA a ";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            areaEmpresaList.clear();
            while (rs.next())
            {
                areaEmpresaList.add(new SelectItem(rs.getInt("COD_AREA_EMPRESA"), rs.getString("NOMBRE_AREA_EMPRESA")));
            }
            rs.close();
            //con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return areaEmpresaList;
    }
    
}
