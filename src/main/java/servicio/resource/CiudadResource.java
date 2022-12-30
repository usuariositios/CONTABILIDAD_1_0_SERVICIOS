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

import servicio.model.Pais;
import servicio.model.SelectItem;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class CiudadResource {
    Connection con;
    public CiudadResource(){
    }
    public CiudadResource(Connection con){
        this.con = con;
    }
    public  List<SelectItem> cargarCiudadItem(Pais p) throws Exception {
        List<SelectItem> ciudadList =new ArrayList<SelectItem>();
        Utiles utiles = new Utiles();
        utiles.getConnection();
        try {
            

            
            String query = "SELECT cod_ciudad,nombre_ciudad from ciudad where 0=0 ";
                    if(p.getCodPais()!=0){query+=" and cod_pais = '"+p.getCodPais()+"' ";}
                    query+=" order by nombre_ciudad asc ";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            ciudadList.clear();
            while (rs.next())
            {
                ciudadList.add(new SelectItem(rs.getInt("cod_ciudad"), rs.getString("nombre_ciudad")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return ciudadList;
    }
    
}
