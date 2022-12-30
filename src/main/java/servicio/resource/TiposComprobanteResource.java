/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.resource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import servicio.model.SelectItem;
import servicio.model.TiposComprobante;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class TiposComprobanteResource {
    Connection con;
    public TiposComprobanteResource(){
    }
    public TiposComprobanteResource(Connection con){
        this.con = con;
    }
    public  List<SelectItem> cargarTiposComprobanteItem() throws Exception {
        List<SelectItem> tiposComprobanteList =new ArrayList<SelectItem>();
        try {
            
            
            
            String query = "SELECT cod_tipo_comprobante,nombre_tipo_comprobante from cont.tipos_comprobante";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            tiposComprobanteList.clear();
            while (rs.next())
            {
                tiposComprobanteList.add(new SelectItem(rs.getInt("cod_tipo_comprobante"), rs.getString("nombre_tipo_comprobante")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return tiposComprobanteList;
    }
    public  List<TiposComprobante> cargarTiposComprobante(TiposComprobante t) throws Exception {
        List<TiposComprobante> listTiposComprobante =new ArrayList<TiposComprobante>();
        try {
            
            
            String query =  " SELECT  t.cod_tipo_comprobante, e.cod_estado_registro,e.nombre_estado_registro, t.nombre_tipo_comprobante, t.obs_tipo_comprobante, t.abreviatura" +
                            " FROM " +
                            " cont.tipos_comprobante t "+
                            " inner join public.estados_registro e on e.cod_estado_registro = t.cod_estado_registro order by t.cod_tipo_comprobante asc";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listTiposComprobante.clear();
            while (rs.next())
            {
                TiposComprobante r =  new TiposComprobante();
                r.setCodTipoComprobante(rs.getInt("cod_tipo_comprobante"));
                r.setNombreTipoComprobante(rs.getString("nombre_tipo_comprobante"));
                r.setObsTipoComprobante(rs.getString("obs_tipo_comprobante"));
                r.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                r.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                r.setAbreviatura(rs.getString("abreviatura"));
                
                
                listTiposComprobante.add(r);
            }
            //rs.close();
            statement.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return listTiposComprobante;
    }
    public  int guardarTiposComprobante(TiposComprobante t) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            
            Statement statement = this.con.createStatement();
            String cons =   " INSERT INTO cont.tipos_comprobante " +
                            " (cod_tipo_comprobante,  nombre_tipo_comprobante,  cod_estado_registro,obs_tipo_comprobante,abreviatura) " +
                            " VALUES ((select nextval('cont.\"seqTiposComprobante\"')), '"+t.getNombreTipoComprobante()+"', '"+t.getEstadosRegistro().getCodEstado()+"','"+t.getObsTipoComprobante()+"','"+t.getAbreviatura()+"');";
            
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //connection.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
        return guardado;
    }
    public int codTipoComposicionProducto(){
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        
    }
    public  int editarTiposComprobante(TiposComprobante t) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons =   " UPDATE cont.tipos_comprobante" +
                            " SET  nombre_tipo_comprobante='"+t.getNombreTipoComprobante()+"',"+                            
                            " cod_estado_registro='"+t.getEstadosRegistro().getCodEstado()+"'," +
                            " obs_tipo_comprobante='"+t.getObsTipoComprobante()+"'," +
                            " abreviatura='"+t.getAbreviatura()+"' " +
                            " WHERE cod_tipo_comprobante='"+t.getCodTipoComprobante()+"' ; ";
            
                    
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //connection.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
        return guardado;
    }
    public  int eliminarTiposComprobante(TiposComprobante t) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons = " delete from cont.tipos_comprobante where cod_tipo_comprobante = '"+t.getCodTipoComprobante()+"' ";
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            statement.close();
            //connection.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
        return guardado;
    }
}
