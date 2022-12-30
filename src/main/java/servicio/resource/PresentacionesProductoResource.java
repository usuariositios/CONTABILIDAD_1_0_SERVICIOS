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
public class PresentacionesProductoResource {
    
    /*public static List cargarPresentacionesProductoItem() {
        List presentacionesProductoList =new ArrayList();
        try {
            
            Connection con = Utiles.getConnection();

            
            String query = " select a.COD_PRESENTACION_PRODUCTO,a.NOMBRE_PRESENTACION_PRODUCTO from produccion.PRESENTACIONES_PRODUCTO a";
            System.out.println("consulta " +query);

            PreparedStatement statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            presentacionesProductoList.clear();
            while (rs.next())
            {
                presentacionesProductoList.add(new SelectItem(rs.getInt("COD_PRESENTACION_PRODUCTO"), rs.getString("NOMBRE_PRESENTACION_PRODUCTO")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return presentacionesProductoList;
    }*/
    
}
