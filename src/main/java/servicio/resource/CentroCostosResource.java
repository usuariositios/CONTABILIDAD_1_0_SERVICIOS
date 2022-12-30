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
import servicio.model.CentroCostos;

import servicio.model.Pais;
import servicio.model.SelectItem;
import servicio.model.TiposCentroCostos;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class CentroCostosResource {
    Connection con;
    public CentroCostosResource(){
    }
    public CentroCostosResource(Connection con){
        this.con = con;
    }

    
    public  List<SelectItem> cargarCentroCostosItem(CentroCostos c) throws Exception {
        List<SelectItem> centroCostosList =new ArrayList<SelectItem>();
        Utiles utiles = new Utiles();
        utiles.getConnection();

        try {
            String query =  " select c.cod_centro_costos, c.nombre_centro_costos || ' (' || t.nombre_tipo_centro_costos || ')'as nombre_centro_costos " +
                            " from cont.CENTRO_DE_COSTOS c, cont.TIPOS_CENTRO_DE_COSTO t " +
                            " where c.COD_TIPO_CENTRO_COSTOS=t.COD_TIPO_CENTRO_COSTOS " +
                            " and c.cod_estado_registro=1 and 0=0 ";
            if(c.getTiposCentroCostos().getCodTipoCentroCostos()!=0){
                query +=" and t.cod_tipo_centro_costos = '"+c.getTiposCentroCostos().getCodTipoCentroCostos()+"' ";
            }
            query +=" order by c.nombre_centro_costos || ' (' || t.nombre_tipo_centro_costos || ')'  ";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            centroCostosList.clear();
            while (rs.next())
            {
                centroCostosList.add(new SelectItem(rs.getInt("cod_centro_costos"), rs.getString("nombre_centro_costos")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        utiles.closeConnection();
        return centroCostosList;
    }
    
}
