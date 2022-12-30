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
public class CargoResource {
    public static List<SelectItem> cargarCargoItem() throws Exception {
        List<SelectItem> cargoList =new ArrayList<SelectItem>();
        Utiles utiles = new Utiles();
        utiles.getConnection();
        try {
            
            
            
            String query = "SELECT cod_cargo,nombre_cargo from cargo";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            cargoList.clear();
            while (rs.next())
            {
                cargoList.add(new SelectItem(rs.getInt("cod_cargo"), rs.getString("nombre_cargo")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return cargoList;
    }
    
}
