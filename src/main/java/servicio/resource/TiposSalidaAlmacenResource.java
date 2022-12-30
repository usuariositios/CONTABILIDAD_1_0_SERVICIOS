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
import servicio.model.TiposSalidaAlmacen;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class TiposSalidaAlmacenResource {
    Connection con;
    public TiposSalidaAlmacenResource(){
    }
    public TiposSalidaAlmacenResource(Connection con){
        this.con = con;
    }
    public List<SelectItem> cargarTiposSalidaAlmacenItem() throws Exception {
        List<SelectItem> tiposSalidaAlmacenList =new ArrayList<SelectItem>();
        try {
            
            
            
            String query = "SELECT cod_tipo_salida_almacen,nombre_tipo_salida_almacen from almacenes.tipos_salida_almacen";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            tiposSalidaAlmacenList.clear();
            while (rs.next())
            {
                tiposSalidaAlmacenList.add(new SelectItem(rs.getInt("cod_tipo_salida_almacen"), rs.getString("nombre_tipo_salida_almacen")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return tiposSalidaAlmacenList;
    }
    public List<TiposSalidaAlmacen> cargarTiposSalidaAlmacen(TiposSalidaAlmacen t) throws Exception {
        List<TiposSalidaAlmacen> listTiposSalidaAlmacen =new ArrayList<TiposSalidaAlmacen>();
        try {
            
            

            
            String query = " SELECT t.cod_tipo_salida_almacen, t.nombre_tipo_salida_almacen,t.obs_tipo_salida_almacen,"
                         + " e.cod_estado_registro, e.nombre_estado_registro "+
                           " FROM almacenes.tipos_salida_almacen t "+
                           " inner join public.estados_registro e on e.cod_estado_registro = t.cod_estado_registro ";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listTiposSalidaAlmacen.clear();
            while (rs.next())
            {
                TiposSalidaAlmacen r =  new TiposSalidaAlmacen();
                r.setCodTipoSalidaAlmacen(rs.getInt("cod_tipo_salida_almacen"));
                r.setNombreTipoSalidaAlmacen(rs.getString("nombre_tipo_salida_almacen"));
                r.setObsTipoSalidaAlmacen(rs.getString("obs_tipo_salida_almacen"));
                r.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                r.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                
                listTiposSalidaAlmacen.add(r);
            }
            //rs.close();
            statement.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return listTiposSalidaAlmacen;
    }
    public int guardarTiposSalidaAlmacen(TiposSalidaAlmacen e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            
            Statement statement = this.con.createStatement();
            String cons = "INSERT INTO almacenes.tipos_salida_almacen(cod_tipo_salida_almacen, nombre_tipo_salida_almacen, obs_tipo_salida_almacen, " +
                    " cod_estado_registro) " +
                    " VALUES ((select nextval('almacenes.\"seqTiposSalidaAlmacen\"')), '"+e.getNombreTipoSalidaAlmacen()+"', '"+e.getObsTipoSalidaAlmacen()+"', " +
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
    public int editarTiposSalidaAlmacen(TiposSalidaAlmacen e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons =   " UPDATE almacenes.tipos_salida_almacen" +
                            " SET  nombre_tipo_salida_almacen='"+e.getNombreTipoSalidaAlmacen()+"', obs_tipo_salida_almacen='"+e.getObsTipoSalidaAlmacen()+"', " +
                            " cod_estado_registro='"+e.getEstadosRegistro().getCodEstado()+"'" +
                            " WHERE cod_tipo_salida_almacen='"+e.getCodTipoSalidaAlmacen()+"' ; ";
            
                    
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
    public int eliminarTiposSalidaAlmacen(TiposSalidaAlmacen e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons = " delete from almacenes.tipos_salida_almacen where cod_tipo_salida_almacen = '"+e.getCodTipoSalidaAlmacen()+"' ";
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
