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
import servicio.model.TiposCentroCostos;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class TiposCentroCostosResource {
    Connection con;
    public TiposCentroCostosResource(){
    }
    public TiposCentroCostosResource(Connection con){
        this.con = con;
    }
    public List<SelectItem> cargarTiposCentroCostosItem() throws Exception {
        List<SelectItem> tiposIngresoAlmacenList =new ArrayList<SelectItem>();
        try {
            
            
            
            String query = "SELECT cod_tipo_centro_costos,nombre_tipo_centro_costos from cont.tipos_centro_de_costo";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            tiposIngresoAlmacenList.clear();
            while (rs.next())
            {
                tiposIngresoAlmacenList.add(new SelectItem(rs.getInt("cod_tipo_centro_costos"), rs.getString("nombre_tipo_centro_costos")));
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
    public List<TiposCentroCostos> cargarTiposCentroCostos(TiposCentroCostos t) throws Exception {
        List<TiposCentroCostos> listTiposCentroCostos =new ArrayList<TiposCentroCostos>();
        try {
            
            

            
            String query = "  ";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listTiposCentroCostos.clear();
            while (rs.next())
            {
                TiposCentroCostos r =  new TiposCentroCostos();
                r.setCodTipoCentroCostos(rs.getInt("cod_tipo_centro_costos"));
                r.setNombreTipoCentroCostos(rs.getString("nombre_tipo_centro_costos"));
                
                r.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                r.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                
                listTiposCentroCostos.add(r);
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
        return listTiposCentroCostos;
    }
    public int guardarTiposCentroCostos(TiposCentroCostos e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            
            Statement statement = this.con.createStatement();
            String cons = "";
            
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
    public int editarTiposCentroCostos(TiposCentroCostos e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons =   " ";
            
                    
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
    public int eliminarTiposCentroCostos(TiposCentroCostos e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons = "  ";
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
