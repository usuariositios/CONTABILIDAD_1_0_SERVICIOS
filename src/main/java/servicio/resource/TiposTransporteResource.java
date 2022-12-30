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

public class TiposTransporteResource {
    Connection con;
    public TiposTransporteResource(){
    }
    public TiposTransporteResource(Connection con){
        this.con = con;
    }

    public List<SelectItem> cargarTiposTransporteItem() throws Exception {
        List<SelectItem> tiposCompraList =new ArrayList<SelectItem>();
        try {
            
            
            
            String query = "SELECT cod_tipo_transporte,nombre_tipo_transporte from tipos_transporte";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            tiposCompraList.clear();
            while (rs.next())
            {
                tiposCompraList.add(new SelectItem(rs.getInt("cod_tipo_transporte"), rs.getString("nombre_tipo_transporte")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return tiposCompraList;
    }
    
}
