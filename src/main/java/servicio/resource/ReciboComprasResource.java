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
import javax.naming.InitialContext;
import javax.sql.DataSource;

import servicio.model.ReciboCompras;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class ReciboComprasResource {
    Connection con;
    public ReciboComprasResource(){
    }
    public ReciboComprasResource(Connection con){
        this.con = con;
    }
    public  List<ReciboCompras> cargarReciboCompras(ReciboCompras l) throws Exception {
        List<ReciboCompras> listReciboCompras =new ArrayList<ReciboCompras>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
            
            

            
            String query =  " SELECT r.cod_recibo,p.cod_proveedor,p.nombre_proveedor,r.nro_recibo,r.fecha_recibo,r.importe_total, " +
                            " r.descuentos_rebajas, r.importe_cancelado, r.glosa, r.fecha_pago " +
                            " FROM cont.recibos_compra r " +
                            " inner join public.proveedores p on p.cod_proveedor = r.cod_proveedor;  ";
            
            
            System.out.println("consulta " +query);
            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listReciboCompras.clear();
            while (rs.next())
            {
                ReciboCompras  r = new ReciboCompras();
                r.setCodRecibo(rs.getInt("cod_recibo"));
                r.getProveedor().setCodProveedor(rs.getInt("cod_proveedor"));
                r.getProveedor().setNombreProveedor(rs.getString("nombre_proveedor"));
                r.setNroRecibo(rs.getString("nro_recibo"));
                r.setFechaRecibo(rs.getString("fecha_recibo"));
                r.setImporteTotal(rs.getDouble("importe_total"));
                r.setDescuentosRebajas(rs.getDouble("descuentos_rebajas"));
                r.setImporteCancelado(rs.getDouble("importe_cancelado"));
                r.setGlosa(rs.getString("glosa"));
                r.setFechaPago(rs.getString("fecha_pago"));
                
                listReciboCompras.add(r);
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
        return listReciboCompras;
    }
    public  ReciboCompras guardarReciboCompras(ReciboCompras r) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            
            Statement statement = this.con.createStatement();
            r.setCodRecibo(codigoReciboCompras());
            String cons =   " INSERT INTO   cont.recibos_compra(" +
                            " cod_recibo,  cod_proveedor,  nro_recibo,  fecha_recibo,  importe_total,  descuentos_rebajas," +
                            " importe_cancelado,  glosa,  fecha_pago)" +
                            " VALUES (  '"+r.getCodRecibo()+"',  '"+r.getProveedor().getCodProveedor()+"',  '"+r.getNroRecibo()+"',  '"+r.getFechaRecibo()+"',  '"+r.getImporteTotal()+"',  '"+r.getDescuentosRebajas()+"'," +
                            " '"+r.getImporteCancelado()+"',  '"+r.getGlosa()+"',  '"+r.getFechaPago()+"'); ";
            
            
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //connection.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
        return r;
    }
    
    public  int editarReciboCompras(ReciboCompras r) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons =   "  UPDATE  " +
                            "  cont.recibos_compra  " +
                            "  SET  " +                            
                            "  cod_proveedor = '"+r.getProveedor().getCodProveedor()+"', " +
                            "  nro_recibo = '"+r.getNroRecibo()+"', " +
                            "  fecha_recibo = '"+r.getFechaRecibo()+"', " +
                            "  importe_total = '"+r.getImporteTotal()+"', " +
                            "  descuentos_rebajas = '"+r.getDescuentosRebajas()+"', " +
                            "  importe_cancelado = '"+r.getImporteCancelado()+"', " +
                            "  glosa = '"+r.getGlosa()+"', " +
                            "  fecha_pago = '"+r.getFechaPago()+"' " +
                            "  WHERE  " +
                            "  cod_recibo = '"+r.getCodRecibo()+"' ";

                    
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
    public  int eliminarReciboCompras(ReciboCompras e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            Statement statement = this.con.createStatement();
            String cons = " delete from cont.libro_compras where cod_libro_compras = '"+e.getCodRecibo()+"' ";
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
    public  List<SelectItem> cargarReciboComprasItem() throws Exception {
        List<SelectItem> cargoList =new ArrayList<SelectItem>();
        try {
            
            
            
            String query = "SELECT cod_cargo,nombre_cargo from cargo";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            cargoList.clear();
            while (rs.next())
            {
                cargoList.add(new SelectItem(rs.getInt("cod_cargo"), rs.getString("nombre_cargo")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return cargoList;
    }
    public  ReciboCompras buscarReciboCompras(ReciboCompras r) throws Exception {
        
        ReciboCompras  rBuscar = new ReciboCompras();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
            
            

            
            String query =  " SELECT r.cod_recibo,p.cod_proveedor,p.nombre_proveedor,r.nro_recibo,r.fecha_recibo,r.importe_total, " +
                            " r.descuentos_rebajas, r.importe_cancelado, r.glosa, r.fecha_pago " +
                            " FROM cont.recibos_compra r " +
                            " inner join public.proveedores p on p.cod_proveedor = r.cod_proveedor where 0=0  ";
            if(r.getCodRecibo()!=0){
                query +=" and r.cod_recibo = '"+r.getCodRecibo()+"' ";
            }
            
            System.out.println("consulta " +query);
            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next())
            {
                
                rBuscar.setCodRecibo(rs.getInt("cod_recibo"));
                rBuscar.getProveedor().setCodProveedor(rs.getInt("cod_proveedor"));
                rBuscar.getProveedor().setNombreProveedor(rs.getString("nombre_proveedor"));
                rBuscar.setNroRecibo(rs.getString("nro_recibo"));
                rBuscar.setFechaRecibo(rs.getString("fecha_recibo"));
                rBuscar.setImporteTotal(rs.getDouble("importe_total"));
                rBuscar.setDescuentosRebajas(rs.getDouble("descuentos_rebajas"));
                rBuscar.setImporteCancelado(rs.getDouble("importe_cancelado"));
                rBuscar.setGlosa(rs.getString("glosa"));
                rBuscar.setFechaPago(rs.getString("fecha_pago"));
                
                
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
        return rBuscar;
    }
    public  int codigoReciboCompras() throws Exception{
        int codReciboCompras=0;
        try {
            
            Statement statement = this.con.createStatement();
            String cons = "select nextval('cont.\"seqReciboCompras\"') cod_libroCompras";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                codReciboCompras = rs.getInt("cod_libroCompras");
            }
            
            statement.close();
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return codReciboCompras;
    }
    
}
