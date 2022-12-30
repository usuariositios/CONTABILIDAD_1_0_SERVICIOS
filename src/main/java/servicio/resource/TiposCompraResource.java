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

public class TiposCompraResource {
    Connection con;
    public TiposCompraResource(){
    }
    public TiposCompraResource(Connection con){
        this.con = con;
    }
    public  List<SelectItem> cargarTiposCompraItem() throws Exception {
        List<SelectItem> tiposCompraList =new ArrayList<SelectItem>();
        try {
            
            
            
            String query = "SELECT cod_tipo_compra,nombre_tipo_compra from tipos_compra";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            tiposCompraList.clear();
            while (rs.next())
            {
                tiposCompraList.add(new SelectItem(rs.getInt("cod_tipo_compra"), rs.getString("nombre_tipo_compra")));
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
