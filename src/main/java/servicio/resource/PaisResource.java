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
public class PaisResource {
    Connection con;
    public PaisResource(){
    }
    public PaisResource(Connection con){
        this.con = con;
    }
    public  List<SelectItem> cargarPaisItem() throws Exception {
        List<SelectItem> paisList =new ArrayList<SelectItem>();
        try {
            
            
            
            String query = "SELECT cod_pais,nombre_pais from pais where cod_estado_registro = 1 ";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            paisList.clear();
            while (rs.next())
            {
                paisList.add(new SelectItem(rs.getInt("cod_pais"), rs.getString("nombre_pais")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return paisList;
    }
    
}
