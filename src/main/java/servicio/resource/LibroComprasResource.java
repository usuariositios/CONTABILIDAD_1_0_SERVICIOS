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

import servicio.model.LibroCompras;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class LibroComprasResource {
    Connection con;
    public LibroComprasResource(){
    }
    public LibroComprasResource(Connection con){
        this.con = con;
    }

    public  List<LibroCompras> cargarLibroCompras(LibroCompras l) throws Exception {
        List<LibroCompras> listLibroCompras =new ArrayList<LibroCompras>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
            
           

            
            String query = " SELECT l.cod_libro_compras,l.cod_comprobante,c.nro_comprobante,p.cod_proveedor,p.nombre_proveedor,p.nit_proveedor , l.nro_factura,  l.nro_orden,  l.fecha_libro," +
                    " l.total_factura,  l.ice,  l.importes_excentos,  l.credito_fiscal,  l.nro_autorizacion," +
                    " t.cod_tipo_documento_libro_compras,t.nombre_tipo_documento_libro_compras,  l.nro_poliza,  l.nit_proveedor,  l.nombre_proveedor," +
                    " l.cod_caja_chica,  l.cod_caja_chicadetalle,  l.cod_rendicion,  l.cod_rendicion_detalle, importe_no_sujeto_credito_fiscal,descuentos_bonificaciones,codigo_control, " +
                    " l.DUI,l.especificacion,l.nro_DUI,l.numero,l.importe_sub_total,l.importe_base_credito_fiscal,l.cod_gestion  " +
                    " FROM" +
                    " cont.libro_compras l" +
                    " left outer join cont.comprobante c on c.cod_comprobante = l.cod_comprobante and l.cod_gestion = c.cod_gestion " +
                    " left outer join public.proveedores p on p.cod_proveedor = l.cod_proveedor" +
                    " left outer join cont.tipos_documento_libro_compras t on t.cod_tipo_documento_libro_compras = l.cod_tipo_documento_libro_compras where 0=0 ";
            
            if(!l.getEspecificacion().equals("")){query+=" AND l.especificacion = '"+l.getEspecificacion() +"' ";}
            if(l.getNumero()!=0){query+=" AND l.numero = '"+l.getNumero() +"' ";}
            if(l.getComprobante().getNroComprobante()!=0){query+=" AND c.nro_comprobante = '"+l.getComprobante().getNroComprobante() +"' ";}
            if(l.getProveedores().getCodProveedor()!=0){query+=" AND p.cod_proveedor ='"+l.getProveedores().getCodProveedor()+"' ";}
            if(!l.getFechaLibro().trim().equals("") && !l.getFechaLibro2().trim().equals("")){query+=" AND l.fecha_libro between '"+l.getFechaLibro()+"' and '"+l.getFechaLibro2()+"' ";}
            if(!l.getNroFactura().trim().equals("")){query+=" AND l.nro_factura like '%"+l.getNroFactura() +"%' ";}
            if(!l.getNroAutorizacion().trim().equals("")){query+=" AND l.nro_autorizacion like '%"+l.getNroAutorizacion() +"%' ";}
            if(!l.getDUI().equals("")){query+=" AND l.nro_DUI = '"+l.getDUI() +"' ";}
            if(l.getComprobante().getGestion().getCodGestion()!=0){query+=" AND l.cod_gestion= '"+l.getComprobante().getGestion().getCodGestion() +"' ";}
            if(l.getTotalFactura()!=0){query+=" AND l.total_factura= '"+l.getTotalFactura() +"' ";}
            query +=" order by l.cod_libro_compras,l.fecha_libro desc LIMIT 10 OFFSET "+l.getFilaInicial()+"  ; ";
            System.out.println("consulta " +query);
            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listLibroCompras.clear();
            while (rs.next())
            {
                LibroCompras  lc = new LibroCompras();
                lc.setCodLibroCompras(rs.getInt("cod_libro_compras"));
                lc.getComprobante().setCodComprobante(rs.getInt("cod_comprobante"));
                lc.getComprobante().setNroComprobante(rs.getInt("nro_comprobante"));
                lc.getProveedores().setCodProveedor(rs.getInt("cod_proveedor"));
                lc.getProveedores().setNombreProveedor(rs.getString("nombre_proveedor"));
                lc.getProveedores().setNitProveedor(rs.getString("nit_proveedor"));
                lc.setNroFactura(rs.getString("nro_factura"));
                lc.setNroOrden(rs.getString("nro_orden"));
                lc.setFechaLibro(sdf.format(rs.getTimestamp("fecha_libro")));
                lc.setTotalFactura(rs.getDouble("total_factura"));
                lc.setIce(rs.getDouble("ice"));
                lc.setImportesExcentos(rs.getDouble("importes_excentos"));
                lc.setImporteCreditoFiscal(rs.getDouble("credito_fiscal"));
                lc.setNroAutorizacion(rs.getString("nro_autorizacion"));
                lc.getTiposDocumentoLibrosCompra().setCodTipoDocumentoLibroCompra(rs.getInt("cod_tipo_documento_libro_compras"));
                lc.getTiposDocumentoLibrosCompra().setNombreTipoDocumentoLibroCompra(rs.getString("nombre_tipo_documento_libro_compras"));
                lc.setNroPoliza(rs.getString("nro_poliza"));
                lc.setImporteNoSujetoCreditoFiscal(rs.getDouble("importe_no_sujeto_credito_fiscal"));
                lc.setDescuentosBonificaciones(rs.getDouble("descuentos_bonificaciones"));
                lc.setCodigoControl(rs.getString("codigo_control"));
                lc.setDUI(rs.getString("DUI"));
                lc.setEspecificacion(rs.getString("especificacion"));
                lc.setNroDUI(rs.getInt("nro_dui"));
                lc.setNumero(rs.getInt("numero"));
                lc.setImporteSubTotal(rs.getDouble("importe_sub_total"));
                lc.setImporteBaseCreditoFiscal(rs.getDouble("importe_base_credito_fiscal"));
                lc.getGestion().setCodGestion(rs.getInt("cod_gestion"));
                
                
                
                listLibroCompras.add(lc);
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
        return listLibroCompras;
    }
    public  LibroCompras guardarLibroCompras(LibroCompras l) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            
            Statement statement = this.con.createStatement();
            l.setCodLibroCompras(codigoLibroCompras());
            String cons =  " INSERT INTO  " +
                    "  cont.libro_compras " +
                    "( " +
                    "  cod_libro_compras,  cod_comprobante,  cod_proveedor,  nro_factura,  nro_orden,  fecha_libro,  total_factura,   " +
                    "  ice,  importes_excentos,  credito_fiscal,  nro_autorizacion,  cod_tipo_documento_libro_compras,  nro_poliza,   " +
                    "  nit_proveedor,  nombre_proveedor,  cod_caja_chica,  cod_caja_chicadetalle,  cod_rendicion,  cod_rendicion_detalle,"
                    + "importe_no_sujeto_credito_fiscal,descuentos_bonificaciones,codigo_control,"
                    + " DUI, especificacion, nro_DUI, numero, importe_sub_total, importe_base_credito_fiscal,cod_gestion) " +
                    "  VALUES ('"+l.getCodLibroCompras()+"',  '"+l.getComprobante().getCodComprobante()+"',  '"+l.getProveedores().getCodProveedor()+"',  '"+l.getNroFactura()+"',  '"+l.getNroOrden()+"',  '"+l.getFechaLibro()+"',  '"+l.getTotalFactura()+"',"
                    + "  '"+l.getIce()+"',  '"+l.getImportesExcentos()+"',  '"+l.getImporteCreditoFiscal()+"',  '"+l.getNroAutorizacion()+"',  '"+l.getTiposDocumentoLibrosCompra().getCodTipoDocumentoLibroCompra()+"',  '"+l.getNroPoliza()+"',  "
                    + "null,  null,  null,  null,  null,  null,"
                    + "'"+l.getImporteNoSujetoCreditoFiscal()+"','"+l.getDescuentosBonificaciones()+"','"+l.getCodigoControl()+"',"
                    + " '"+l.getDUI()+"','"+l.getEspecificacion()+"','"+l.getNroDUI()+"','"+l.getNumero()+"','"+l.getImporteSubTotal()+"','"+l.getImporteBaseCreditoFiscal()+"','"+l.getGestion().getCodGestion()+"'); ";
            
            
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
    public int codLibroCompras(){
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        
    }
    public  int editarLibroCompras(LibroCompras l) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons =   "  UPDATE  " +
                            "  cont.libro_compras  " +
                            "  SET  " +
                            
                            "  cod_comprobante = '"+l.getComprobante().getCodComprobante()+"', " +
                            "  cod_proveedor = '"+l.getProveedores().getCodProveedor()+"', " +
                            "  nro_factura = '"+l.getNroFactura()+"', " +
                            "  nro_orden = '"+l.getNroOrden()+"', " +
                            "  fecha_libro = '"+l.getFechaLibro()+"', " +
                            "  total_factura = '"+l.getTotalFactura()+"', " +
                            "  ice = '"+l.getIce()+"', " +
                            "  importes_excentos = '"+l.getImportesExcentos()+"', " +
                            "  credito_fiscal = '"+l.getImporteCreditoFiscal()+"', " +
                            "  nro_autorizacion = '"+l.getNroAutorizacion()+"', " +
                            "  cod_tipo_documento_libro_compras = '"+l.getTiposDocumentoLibrosCompra().getCodTipoDocumentoLibroCompra()+"', " +
                            "  nro_poliza = '"+l.getNroPoliza()+"', " +
                            "  nit_proveedor = null, " +
                            "  nombre_proveedor = null, " +
                            "  cod_caja_chica = null, " +
                            "  cod_caja_chicadetalle = null, " +
                            "  cod_rendicion = null, " +
                            "  cod_rendicion_detalle = null, " +
                            "  importe_no_sujeto_credito_fiscal= '"+l.getImporteNoSujetoCreditoFiscal()+"', " +
                            "  descuentos_bonificaciones = '"+l.getDescuentosBonificaciones()+"', "+
                            "  codigo_control = '"+l.getCodigoControl()+"',"+
                            "  DUI = '"+l.getDUI()+"',"
                            + " especificacion='"+l.getEspecificacion()+"',"
                            + " nro_DUI='"+l.getNroDUI()+"',"
                            + " numero='"+l.getNumero()+"',"
                            + " importe_sub_total='"+l.getImporteSubTotal()+"',"
                            + " importe_base_credito_fiscal='"+l.getImporteBaseCreditoFiscal()+"',"
                            + " cod_gestion='"+l.getGestion().getCodGestion()+"'" +
                            "  WHERE cod_libro_compras = '"+l.getCodLibroCompras()+"' ";

                    
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
    public  int eliminarLibroCompras(LibroCompras e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons = " delete from cont.libro_compras where cod_libro_compras = '"+e.getCodLibroCompras()+"' ";
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
    public  List<SelectItem> cargarLibroComprasItem()  throws Exception{
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
    public  LibroCompras buscarLibroCompras(LibroCompras l) throws Exception {
        
        LibroCompras  lc = new LibroCompras();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
            
            

            
            String query = " SELECT l.cod_libro_compras,l.cod_comprobante,p.cod_proveedor,p.nombre_proveedor , l.nro_factura,  l.nro_orden,  l.fecha_libro," +
                    " l.total_factura,  l.ice,  l.importes_excentos,  l.credito_fiscal,  l.nro_autorizacion," +
                    " t.cod_tipo_documento_libro_compras,t.nombre_tipo_documento_libro_compras,  l.nro_poliza,  l.nit_proveedor,  l.nombre_proveedor," +
                    " l.cod_caja_chica,  l.cod_caja_chicadetalle,  l.cod_rendicion,  l.cod_rendicion_detalle, importe_no_sujeto_credito_fiscal,descuentos_bonificaciones,codigo_control, " +
                    " l.DUI,l.especificacion,l.nro_DUI,l.numero,l.importe_sub_total,l.importe_base_credito_fiscal  " +
                    " FROM" +
                    " cont.libro_compras l" +
                    " left outer join cont.comprobante c on c.cod_comprobante = l.cod_comprobante" +
                    " left outer join public.proveedores p on p.cod_proveedor = l.cod_proveedor" +
                    " left outer join cont.tipos_documento_libro_compras t on t.cod_tipo_documento_libro_compras = l.cod_tipo_documento_libro_compras where 0=0 ";
            
            if(l.getCodLibroCompras()!=0){query+=" AND l.cod_libro_compras = '"+l.getCodLibroCompras() +"' ";}
            if(l.getComprobante().getNroComprobante()!=0){query+=" AND c.nro_comprobante = '"+l.getComprobante().getNroComprobante() +"' ";}
            if(l.getProveedores().getCodProveedor()!=0){query+=" AND p.cod_proveedor ='"+l.getProveedores().getCodProveedor()+"' ";}
            if(!l.getFechaLibro().trim().equals("")){query+=" AND l.fecha_libro '"+l.getFechaLibro()+"' ";}
            if(!l.getNroFactura().trim().equals("")){query+=" AND l.nro_factura like '%"+l.getNroFactura() +"%' ";}
            if(!l.getNroAutorizacion().trim().equals("")){query+=" AND l.nro_autorizacion like '%"+l.getNroAutorizacion() +"%' ";}
            query +=" order by l.fecha_libro;";
            System.out.println("consulta " +query);
            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next())
            {
                
                lc.setCodLibroCompras(rs.getInt("cod_libro_compras"));
                lc.getComprobante().setCodComprobante(rs.getInt("cod_comprobante"));
                lc.getProveedores().setCodProveedor(rs.getInt("cod_proveedor"));
                lc.getProveedores().setNombreProveedor(rs.getString("nombre_proveedor"));
                lc.setNroFactura(rs.getString("nro_factura"));
                lc.setNroOrden(rs.getString("nro_orden"));
                lc.setFechaLibro(sdf.format(rs.getTimestamp("fecha_libro")));
                lc.setTotalFactura(rs.getDouble("total_factura"));
                lc.setIce(rs.getDouble("ice"));
                lc.setImportesExcentos(rs.getDouble("importes_excentos"));
                lc.setImporteCreditoFiscal(rs.getDouble("credito_fiscal"));
                lc.setNroAutorizacion(rs.getString("nro_autorizacion"));
                lc.getTiposDocumentoLibrosCompra().setCodTipoDocumentoLibroCompra(rs.getInt("cod_tipo_documento_libro_compras"));
                lc.getTiposDocumentoLibrosCompra().setNombreTipoDocumentoLibroCompra(rs.getString("nombre_tipo_documento_libro_compras"));
                lc.setNroPoliza(rs.getString("nro_poliza"));
                lc.setImporteNoSujetoCreditoFiscal(rs.getDouble("importe_no_sujeto_credito_fiscal"));
                lc.setDescuentosBonificaciones(rs.getDouble("descuentos_bonificaciones"));
                lc.setCodigoControl(rs.getString("codigo_control"));
                lc.setDUI(rs.getString("DUI"));
                lc.setEspecificacion(rs.getString("especificacion"));
                lc.setNroDUI(rs.getInt("nro_dui"));
                lc.setNumero(rs.getInt("numero"));
                lc.setImporteSubTotal(rs.getDouble("importe_sub_total"));
                lc.setImporteBaseCreditoFiscal(rs.getDouble("importe_base_credito_fiscal"));
                
                
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
        return lc;
    }
    public  int codigoLibroCompras() throws Exception{
        int codLibroCompras=0;
        try {
            
            Statement statement = this.con.createStatement();
            String cons = "select nextval('cont.\"seqLibroCompras\"') cod_libroCompras";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                codLibroCompras = rs.getInt("cod_libroCompras");
            }
            
            statement.close();
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return codLibroCompras;
    }
    
}
