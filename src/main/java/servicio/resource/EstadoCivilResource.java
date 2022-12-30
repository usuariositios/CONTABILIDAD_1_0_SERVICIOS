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
public class EstadoCivilResource {
    Connection con;
    public EstadoCivilResource(){
    }
    public EstadoCivilResource(Connection con){
        this.con = con;
    }
    public  List<SelectItem> cargarEstadoCivilItem() throws Exception {
        List<SelectItem> estadoCivilList =new ArrayList<SelectItem>();
        try {
            
            
            
            String query = "SELECT cod_estado_civil,nombre_estado_civil from estado_civil";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            estadoCivilList.clear();
            while (rs.next())
            {
                estadoCivilList.add(new SelectItem(rs.getInt("cod_estado_civil"), rs.getString("nombre_estado_civil")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return estadoCivilList;
    }
    
}
