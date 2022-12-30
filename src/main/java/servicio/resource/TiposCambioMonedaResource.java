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
import servicio.model.TiposCambioMoneda;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class TiposCambioMonedaResource {
    Connection con;
    public TiposCambioMonedaResource(){
    }
    public TiposCambioMonedaResource(Connection con){
        this.con = con;
    }
    public  List<SelectItem> cargarTiposCambioMonedaItem() throws Exception {
        List<SelectItem> tiposCambioMonedaList =new ArrayList<SelectItem>();
        try {
            
            
            
            String query = "SELECT   fecha,  cod_moneda,  cambio FROM cont.tipos_cambio_moneda ";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            tiposCambioMonedaList.clear();
            while (rs.next())
            {
                //tiposCambioMonedaList.add(new SelectItem(rs.getString("fecha"), rs.getString("nombre_tipo_centro_costos")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return tiposCambioMonedaList;
    }
    public  List<TiposCambioMoneda> cargarTiposCambioMoneda(TiposCambioMoneda t) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        List<TiposCambioMoneda> listTiposCambioMoneda =new ArrayList<TiposCambioMoneda>();
        try {
            
            String query =  " SELECT   t.fecha,  m.cod_moneda,m.nombre_moneda,t.monto " +
                            " FROM cont.tipos_cambio_moneda t " +
                            " inner join public.monedas m on m.cod_moneda = t.cod_moneda where 0=0 ";
            if(!t.getFecha().trim().equals("")){
                query +=" and t.fecha='"+t.getFecha()+"'";
            }
            if(t.getMes()!=0){
                query +=" and date_part('month', t.fecha)='"+t.getMes()+"'";
            }
            query +=" order by t.fecha asc ";
            
            
            
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listTiposCambioMoneda.clear();
            while (rs.next())
            {
                TiposCambioMoneda tc =  new TiposCambioMoneda();
                tc.setFecha(sdf.format(rs.getTimestamp("fecha")));
                tc.getMonedas().setCodMoneda(rs.getInt("cod_moneda"));
                tc.getMonedas().setNombreMoneda(rs.getString("nombre_moneda"));
                tc.setMonto(rs.getDouble("monto"));
                listTiposCambioMoneda.add(tc);
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
        return listTiposCambioMoneda;
    }
    public  TiposCambioMoneda buscarTiposCambioMoneda(TiposCambioMoneda t) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        TiposCambioMoneda tc =  new TiposCambioMoneda();
        try {
            
            String query =  " SELECT   t.fecha,  m.cod_moneda,m.nombre_moneda,t.monto " +
                            " FROM cont.tipos_cambio_moneda t " +
                            " inner join public.monedas m on m.cod_moneda = t.cod_moneda where 0=0 ";
            if(!t.getFecha().trim().equals("")){
                query +=" and t.fecha = '"+t.getFecha()+"' ";
            }
            if(t.getMonedas().getCodMoneda()!=0){
                query +=" and t.cod_moneda = '"+t.getMonedas().getCodMoneda()+"' ";
            }
            
            
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            
            if(rs.next())
            {
                
                tc.setFecha(sdf.format(rs.getTimestamp("fecha")));
                tc.getMonedas().setCodMoneda(rs.getInt("cod_moneda"));
                tc.getMonedas().setNombreMoneda(rs.getString("nombre_moneda"));
                tc.setMonto(rs.getDouble("monto"));
                
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
        return tc;
    }
    public  int guardarTiposCambioMoneda(TiposCambioMoneda t) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            
            Statement statement = this.con.createStatement();
            String cons =   " INSERT INTO cont.tipos_cambio_moneda " +
                            " ( fecha,  cod_moneda,  monto) " +
                            " VALUES (  '"+t.getFecha()+"',  '"+t.getMonedas().getCodMoneda()+"',  '"+t.getMonto()+"') ";
            
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
    public  int editarTiposCambioMoneda(TiposCambioMoneda t) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons =   " UPDATE  " +
                            "  cont.tipos_cambio_moneda  " +
                            " SET " +
                            "  monto = '"+t.getMonto()+"' " +
                            " WHERE fecha = '"+t.getFecha()+"'  "+
                            " and cod_moneda = '"+t.getMonedas().getCodMoneda()+"' ";
            
                    
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
    public  int eliminarTiposCambioMoneda(TiposCambioMoneda t) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons =   " delete from  " +
                            "  cont.tipos_cambio_moneda  " +                            
                            " WHERE fecha = '"+t.getFecha()+"'  "+
                            " and cod_moneda = '"+t.getMonedas().getCodMoneda()+"'  ";
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
