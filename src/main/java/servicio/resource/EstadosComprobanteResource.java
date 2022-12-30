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
public class EstadosComprobanteResource {
    Connection con;
    public EstadosComprobanteResource(){
    }
    public EstadosComprobanteResource(Connection con){
        this.con = con;
    }

    public  List<SelectItem> cargarEstadosComprobanteItem() throws Exception {
        List<SelectItem> ecList =new ArrayList<SelectItem>();
        try {
            
            
            
            String query = "   SELECT cod_estado_comprobante, nombre_estado_comprobante FROM cont.estados_comprobantes ; ";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            ecList.clear();
            while (rs.next())
            {
                ecList.add(new SelectItem(rs.getInt("cod_estado_comprobante"), rs.getString("nombre_estado_comprobante")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return ecList;
    }
    
}
