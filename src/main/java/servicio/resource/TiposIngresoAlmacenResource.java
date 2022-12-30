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
import servicio.model.TiposIngresoAlmacen;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class TiposIngresoAlmacenResource {
    Connection con;
    public TiposIngresoAlmacenResource(){
    }
    public TiposIngresoAlmacenResource(Connection con){
        this.con = con;
    }
    public List<SelectItem> cargarTiposIngresoAlmacenItem() throws Exception  {
        List<SelectItem> tiposIngresoAlmacenList =new ArrayList<SelectItem>();
        try {
            
            
            
            String query = "SELECT cod_tipo_ingreso_almacen,nombre_tipo_ingreso_almacen from almacenes.tipos_ingreso_almacen";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            tiposIngresoAlmacenList.clear();
            while (rs.next())
            {
                tiposIngresoAlmacenList.add(new SelectItem(rs.getInt("cod_tipo_ingreso_almacen"), rs.getString("nombre_tipo_ingreso_almacen")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return tiposIngresoAlmacenList;
    }
    public List<TiposIngresoAlmacen> cargarTiposIngresoAlmacen(TiposIngresoAlmacen t) throws Exception {
        List<TiposIngresoAlmacen> listTiposIngresoAlmacen =new ArrayList<TiposIngresoAlmacen>();
        try {
            
            

            
            String query = " SELECT t.cod_tipo_ingreso_almacen, t.nombre_tipo_ingreso_almacen,t.obs_tipo_ingreso_almacen,"
                         + " e.cod_estado_registro, e.nombre_estado_registro "+
                           " FROM almacenes.tipos_ingreso_almacen t "+
                           " inner join public.estados_registro e on e.cod_estado_registro = t.cod_estado_registro ";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listTiposIngresoAlmacen.clear();
            while (rs.next())
            {
                TiposIngresoAlmacen r =  new TiposIngresoAlmacen();
                r.setCodTipoIngresoAlmacen(rs.getInt("cod_tipo_ingreso_almacen"));
                r.setNombreTipoIngresoAlmacen(rs.getString("nombre_tipo_ingreso_almacen"));
                r.setObsTipoIngresoAlmacen(rs.getString("obs_tipo_ingreso_almacen"));
                r.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                r.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                
                listTiposIngresoAlmacen.add(r);
            }
            rs.close();
            statement.close();
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return listTiposIngresoAlmacen;
    }
    public int guardarTiposIngresoAlmacen(TiposIngresoAlmacen e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            
            Statement statement = this.con.createStatement();
            String cons = "INSERT INTO almacenes.tipos_ingreso_almacen(cod_tipo_ingreso_almacen, nombre_tipo_ingreso_almacen, obs_tipo_ingreso_almacen, " +
                    " cod_estado_registro) " +
                    " VALUES ((select nextval('almacenes.\"seqTiposIngresoAlmacen\"')), '"+e.getNombreTipoIngresoAlmacen()+"', '"+e.getObsTipoIngresoAlmacen()+"', " +
                    "         '"+e.getEstadosRegistro().getCodEstado()+"');";
            
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
    public int editarTiposIngresoAlmacen(TiposIngresoAlmacen e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons =   " UPDATE almacenes.tipos_ingreso_almacen" +
                            " SET  nombre_tipo_ingreso_almacen='"+e.getNombreTipoIngresoAlmacen()+"', obs_tipo_ingreso_almacen='"+e.getObsTipoIngresoAlmacen()+"', " +
                            " cod_estado_registro='"+e.getEstadosRegistro().getCodEstado()+"'" +
                            " WHERE cod_tipo_ingreso_almacen='"+e.getCodTipoIngresoAlmacen()+"' ; ";
            
                    
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
    public int eliminarTiposIngresoAlmacen(TiposIngresoAlmacen e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons = " delete from almacenes.tipos_ingreso_almacen where cod_tipo_ingreso_almacen = '"+e.getCodTipoIngresoAlmacen()+"' ";
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
