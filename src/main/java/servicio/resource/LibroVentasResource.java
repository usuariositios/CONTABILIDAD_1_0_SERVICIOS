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

import servicio.model.LibroVentas;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class LibroVentasResource {
    Connection con;
    public LibroVentasResource(){
    }
    public LibroVentasResource(Connection con){
        this.con = con;
    }

    public  List<LibroVentas> cargarLibroVentas(LibroVentas l) throws Exception {
        List<LibroVentas> listLibroVentas =new ArrayList<LibroVentas>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
            
            

            
            String query =  "  SELECT  l.cod_libro_ventas,  l.especificacion,  l.numero,  l.fecha_factura,  l.nro_factura,  l.nro_autorizacion, " +
                            "  l.cod_estado,  cl.cod_cliente, cl.nit_cliente,  cl.nombre_cliente,  l.monto_total,  l.monto_ice_iehd_tasas,  l.monto_export_operac, " +
                            "  l.monto_vtas_grv_tasa_cero, l.monto_subtotal,  l.monto_dctos_bonific,  l.importe_base_credito_fiscal, " +
                            "  l.debito_fiscal,  l.codigo_control,l.cod_comprobante " +
                            "  FROM cont.libro_ventas l  " +
                            "  left outer join cont.comprobante c on c.cod_comprobante = l.cod_comprobante and l.cod_gestion = c.cod_gestion " +
                            "  left outer join public.clientes cl on cl.cod_cliente = l.cod_cliente " +
                            "  where 0=0 ";
            
            if(l.getEspecificacion()!=0){query+=" AND l.especificacion = '"+l.getEspecificacion() +"' ";}
            if(l.getNumero()!=0){query+=" AND l.numero = '"+l.getNumero() +"' ";}
            if(l.getComprobante().getNroComprobante()!=0){query+=" AND c.nro_comprobante = '"+l.getComprobante().getNroComprobante() +"' ";}
            if(l.getClientes().getCodCliente()!=0){query+=" AND cl.cod_cliente = '"+l.getClientes().getCodCliente() +"' ";}
            
            if(!l.getNroFactura().trim().equals("")){query+=" AND l.nro_factura like '%"+l.getNroFactura() +"%' ";}
            if(!l.getNroAutorizacion().trim().equals("")){query+=" AND l.nro_autorizacion like '%"+l.getNroAutorizacion() +"%' ";}
            
            if(l.getComprobante().getGestion().getCodGestion()!=0){query+=" AND l.cod_gestion= '"+l.getComprobante().getGestion().getCodGestion() +"' ";}
            
            query +=" order by l.cod_libro_ventas,l.fecha_libro desc LIMIT 10 OFFSET "+l.getFilaInicial()+"  ; ";
            System.out.println("consulta " +query);
            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listLibroVentas.clear();
            while (rs.next())
            {
                LibroVentas  lv = new LibroVentas();
                lv.setCodLibroVentas(rs.getInt("cod_libro_ventas"));
                lv.setEspecificacion(rs.getInt("especificacion"));
                lv.setNumero(rs.getInt("numero"));
                lv.setFechaFactura(sdf.format(rs.getTimestamp("fecha_factura")));
                lv.setNroFactura(rs.getString("nro_factura"));
                lv.setNroAutorizacion(rs.getString("nro_autorizacion"));
                lv.setCodEstado(rs.getString("cod_estado"));
                lv.getClientes().setCodCliente(rs.getInt("cod_cliente"));
                lv.getClientes().setNombreCliente(rs.getString("nombre_cliente"));
                lv.getClientes().setNitCliente(rs.getString("nit_cliente"));
                lv.setMontoTotal(rs.getDouble("monto_total"));
                lv.setMontoIceIehdTasas(rs.getDouble("monto_ice_iehd_tasas"));
                lv.setMontoExportOperac(rs.getDouble("monto_export_operac"));
                lv.setMontoVtasGrvTasaCero(rs.getDouble("monto_vtas_grv_tasa_cero"));
                lv.setMontoSubTotal(rs.getDouble("monto_subtotal"));
                lv.setMontoDctosBonific(rs.getDouble("monto_dctos_bonific"));
                lv.setImporteBaseCreditoFiscal(rs.getDouble("importe_base_credito_fiscal"));
                lv.setDebitoFiscal(rs.getDouble("debito_fiscal"));
                lv.setCodigoControl(rs.getString("codigo_control"));
                lv.getComprobante().setCodComprobante(rs.getInt("cod_comprobante"));
                
                
                
                listLibroVentas.add(lv);
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
        return listLibroVentas;
    }
    public  LibroVentas guardarLibroVentas(LibroVentas l) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            
            Statement statement = this.con.createStatement();
            l.setCodLibroVentas(codigoLibroVentas());
            String cons =  " INSERT INTO   cont.libro_ventas( " +
                            "  cod_libro_ventas,  especificacion,  numero,  fecha_factura,  nro_factura,  nro_autorizacion,  cod_estado, " +
                            "  cod_cliente,  nit_cliente,  nombre_cliente,  monto_total,  monto_ice_iehd_tasas,  monto_export_operac, " +
                            "  monto_vtas_grv_tasa_cero,  monto_subtotal,  monto_dctos_bonific,  importe_base_credito_fiscal,  debito_fiscal, " +
                            "  codigo_control,  cod_comprobante,  cod_gestion) " +
                            "VALUES (  '"+l.getCodLibroVentas()+"',  '"+l.getEspecificacion()+"',  '"+l.getEspecificacion()+"',  '"+l.getFechaFactura()+"',  '"+l.getNroFactura()+"',  '"+l.getNroAutorizacion()+"', " +
                            "  '"+l.getCodEstado()+"',  '"+l.getClientes().getCodCliente()+"',  '"+l.getClientes().getNitCliente()+"',  '"+l.getClientes().getNombreCliente()+"',  '"+l.getMontoTotal()+"', '"+l.getMontoIceIehdTasas()+"',  '"+l.getMontoExportOperac()+"', " +
                            "  '"+l.getMontoVtasGrvTasaCero()+"',  '"+l.getMontoSubTotal()+"',  '"+l.getMontoDctosBonific()+"',  '"+l.getImporteBaseCreditoFiscal()+"',  '"+l.getDebitoFiscal()+"', " +
                            "  '"+l.getCodigoControl()+"',  '"+l.getComprobante().getCodComprobante()+"',  '"+l.getGestion().getCodGestion()+"'); ";
            
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //connection.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
        return l;
    }
    public int codLibroVentas(){
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        
    }
    public  int editarLibroVentas(LibroVentas l) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons =   "  UPDATE  " +
                            "  cont.libro_ventas  " +
                            "  SET  " +
                            "  especificacion = '"+l.getEspecificacion()+"', " +
                            "  numero = '"+l.getNumero()+"', " +
                            "  fecha_factura = '"+l.getFechaFactura()+"', " +
                            "  nro_factura = '"+l.getNroFactura()+"', " +
                            "  nro_autorizacion = '"+l.getNroAutorizacion()+"', " +
                            "  cod_estado = '"+l.getCodEstado()+"', " +
                            "  cod_cliente = '"+l.getClientes().getCodCliente()+"', " +
                            "  nit_cliente = '"+l.getClientes().getNitCliente()+"', " +
                            "  nombre_cliente = '"+l.getClientes().getNombreCliente()+"', " +
                            "  monto_total = '"+l.getMontoTotal()+"', " +
                            "  monto_ice_iehd_tasas = '"+l.getMontoIceIehdTasas()+"', " +
                            "  monto_export_operac = '"+l.getMontoExportOperac()+"', " +
                            "  monto_vtas_grv_tasa_cero = '"+l.getMontoVtasGrvTasaCero()+"', " +
                            "  monto_subtotal = '"+l.getMontoSubTotal()+"', " +
                            "  monto_dctos_bonific = '"+l.getMontoDctosBonific()+"', " +
                            "  importe_base_credito_fiscal = '"+l.getImporteBaseCreditoFiscal()+"', " +
                            "  debito_fiscal = '"+l.getDebitoFiscal()+"', " +
                            "  codigo_control = '"+l.getCodigoControl()+"', " +
                            "  cod_comprobante = '"+l.getComprobante().getCodComprobante()+"', " +
                            "  cod_gestion = '"+l.getGestion().getCodGestion()+"' " +
                            "  WHERE  " +
                            "  cod_libro_ventas = '"+l.getCodLibroVentas()+"' " +
                            "; ";

                    
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
    public  int eliminarLibroVentas(LibroVentas e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons = " delete from cont.libro_ventas where cod_libro_ventas = '"+e.getCodLibroVentas()+"' ";
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
    public  List<SelectItem> cargarLibroVentasItem() throws Exception {
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
    public  LibroVentas buscarLibroVentas(LibroVentas l) throws Exception {
        
        LibroVentas  lv = new LibroVentas();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
            
            

            
            String query =  "  SELECT  l.cod_libro_ventas,  l.especificacion,  l.numero,  l.fecha_factura,  l.nro_factura,  l.nro_autorizacion, " +
                            "  l.cod_estado,  cl.cod_cliente, cl.nit_cliente,  cl.nombre_cliente,  l.monto_total,  l.monto_ice_iehd_tasas,  l.monto_export_operac, " +
                            "  l.monto_vtas_grv_tasa_cero, l.monto_subtotal,  l.monto_dctos_bonific,  l.importe_base_credito_fiscal, " +
                            "  l.debito_fiscal,  l.codigo_control,l.cod_comprobante " +
                            "  FROM cont.libro_ventas l  " +
                            "  left outer join cont.comprobante c on c.cod_comprobante = l.cod_comprobante and l.cod_gestion = c.cod_gestion " +
                            "  left outer join public.clientes cl on cl.cod_cliente = l.cod_cliente " +
                            "  where 0=0 ";
            
            if(l.getEspecificacion()!=0){query+=" AND l.especificacion = '"+l.getEspecificacion() +"' ";}
            if(l.getNumero()!=0){query+=" AND l.numero = '"+l.getNumero() +"' ";}
            if(l.getComprobante().getNroComprobante()!=0){query+=" AND c.nro_comprobante = '"+l.getComprobante().getNroComprobante() +"' ";}
            if(l.getClientes().getCodCliente()!=0){query+=" AND cl.cod_cliente = '"+l.getClientes().getCodCliente() +"' ";}
            
            if(!l.getNroFactura().trim().equals("")){query+=" AND l.nro_factura like '%"+l.getNroFactura() +"%' ";}
            if(!l.getNroAutorizacion().trim().equals("")){query+=" AND l.nro_autorizacion like '%"+l.getNroAutorizacion() +"%' ";}
            
            if(l.getComprobante().getGestion().getCodGestion()!=0){query+=" AND l.cod_gestion= '"+l.getComprobante().getGestion().getCodGestion() +"' ";}
            
            query +=" order by l.cod_libro_ventas,l.fecha_libro desc LIMIT 10 OFFSET "+l.getFilaInicial()+"  ; ";
            System.out.println("consulta " +query);
            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            
            while (rs.next())
            {
            
                lv.setCodLibroVentas(rs.getInt("cod_libro_ventas"));
                lv.setEspecificacion(rs.getInt("especificacion"));
                lv.setNumero(rs.getInt("numero"));
                lv.setFechaFactura(sdf.format(rs.getTimestamp("fecha_factura")));
                lv.setNroFactura(rs.getString("nro_factura"));
                lv.setNroAutorizacion(rs.getString("nro_autorizacion"));
                lv.setCodEstado(rs.getString("cod_estado"));
                lv.getClientes().setCodCliente(rs.getInt("cod_cliente"));
                lv.getClientes().setNombreCliente(rs.getString("nombre_cliente"));
                lv.getClientes().setNitCliente(rs.getString("nit_cliente"));
                lv.setMontoTotal(rs.getDouble("monto_total"));
                lv.setMontoIceIehdTasas(rs.getDouble("monto_ice_iehd_tasas"));
                lv.setMontoExportOperac(rs.getDouble("monto_export_operac"));
                lv.setMontoVtasGrvTasaCero(rs.getDouble("monto_vtas_grv_tasa_cero"));
                lv.setMontoSubTotal(rs.getDouble("monto_subtotal"));
                lv.setMontoDctosBonific(rs.getDouble("monto_dctos_bonific"));
                lv.setImporteBaseCreditoFiscal(rs.getDouble("importe_base_credito_fiscal"));
                lv.setDebitoFiscal(rs.getDouble("debito_fiscal"));
                lv.setCodigoControl(rs.getString("codigo_control"));
                lv.getComprobante().setCodComprobante(rs.getInt("cod_comprobante"));
                
                
                
                
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
        return lv;
    }
    public  int codigoLibroVentas() throws Exception{
        int codLibroVentas=0;
        try {
            
            Statement statement = this.con.createStatement();
            String cons = "select nextval('cont.\"seqLibroVentas\"') cod_libroVentas";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                codLibroVentas = rs.getInt("cod_libroVentas");
            }            
            statement.close();
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return codLibroVentas;
    }
    
}
