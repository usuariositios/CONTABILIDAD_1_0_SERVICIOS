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
import servicio.model.TiposFuentePago;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class TiposFuentePagoResource {
    Connection con;
    public TiposFuentePagoResource(){
    }
    public TiposFuentePagoResource(Connection con){
        this.con = con;
    }
    public List<SelectItem> cargarTiposFuentePagoItem() throws Exception {
        List<SelectItem> tiposIngresoAlmacenList =new ArrayList<SelectItem>();
        try {
            
            
            
            String query = "SELECT cod_tipo_fuente_pago,nombre_tipo_fuente_pago from ventas.tipos_fuente_pago";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            tiposIngresoAlmacenList.clear();
            while (rs.next())
            {
                tiposIngresoAlmacenList.add(new SelectItem(rs.getInt("cod_tipo_fuente_pago"), rs.getString("nombre_tipo_fuente_pago")));
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
    public List<TiposFuentePago> cargarTiposFuentePago(TiposFuentePago t) throws Exception {
        List<TiposFuentePago> listTiposFuentePago =new ArrayList<TiposFuentePago>();
        try {
            
            

            
            String query = " SELECT t.cod_tipo_fuente_pago, t.nombre_tipo_fuente_pago,"
                         + " e.cod_estado_registro, e.nombre_estado_registro "+
                           " FROM almacenes.tipos_fuente_pago t "+
                           " inner join public.estados_registro e on e.cod_estado_registro = t.cod_estado_registro ";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listTiposFuentePago.clear();
            while (rs.next())
            {
                TiposFuentePago r =  new TiposFuentePago();
                r.setCodTipoFuentePago(rs.getInt("cod_tipo_fuente_pago"));
                r.setNombreTipoFuentePago(rs.getString("nombre_tipo_fuente_pago"));
                
                r.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                r.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                
                listTiposFuentePago.add(r);
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
        return listTiposFuentePago;
    }
    public int guardarTiposFuentePago(TiposFuentePago e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            
            Statement statement = this.con.createStatement();
            String cons = "INSERT INTO almacenes.tipos_fuente_pago(cod_tipo_fuente_pago, nombre_tipo_fuente_pago, " +
                    " cod_estado_registro) " +
                    " VALUES ((select nextval('almacenes.\"seqTiposFuentePago\"')), '"+e.getNombreTipoFuentePago()+"','"+e.getEstadosRegistro().getCodEstado()+"');";
            
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
    public int editarTiposFuentePago(TiposFuentePago e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons =   " UPDATE almacenes.tipos_fuente_pago" +
                            " SET  nombre_tipo_fuente_pago='"+e.getNombreTipoFuentePago()+"', " +
                            " cod_estado_registro='"+e.getEstadosRegistro().getCodEstado()+"'" +
                            " WHERE cod_tipo_fuente_pago='"+e.getCodTipoFuentePago()+"' ; ";
            
                    
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
    public int eliminarTiposFuentePago(TiposFuentePago e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons = " delete from almacenes.tipos_fuente_pago where cod_tipo_fuente_pago = '"+e.getCodTipoFuentePago()+"' ";
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
