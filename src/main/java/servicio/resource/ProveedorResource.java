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


import servicio.model.Proveedor;
import servicio.model.SelectItem;
import servicio.util.Utiles;



/**
 *
 * @author henry
 */
public class ProveedorResource {
    Connection con;
    public ProveedorResource(){
    }
    public ProveedorResource(Connection con){
        this.con = con;
    }
    
    public  List<SelectItem> cargarProveedoresItem() throws Exception {
        List<SelectItem> proveedorList =new ArrayList<SelectItem>();
        try {
            
            
            
            String query = "SELECT cod_proveedor, nombre_proveedor "
                    + " from public.proveedores "
                    + " order by nombre_proveedor  ";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            proveedorList.clear();
            while (rs.next())
            {
                proveedorList.add(new SelectItem(rs.getInt("cod_proveedor"), rs.getString("nombre_proveedor")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return proveedorList;
    }
    public  List<Proveedor> cargarProveedores(Proveedor pro) throws Exception {
        List<Proveedor> proveedorList =new ArrayList<Proveedor>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        try {
            
            

            
            String query =  " SELECT p.cod_proveedor, p.nombre_proveedor,  p.nit_proveedor,  p.cod_tipo_proveedor,  e.cod_estado_proveedor,e.nombre_estado_proveedor,  m.cod_moneda,m.nombre_moneda, " +
                            " t.cod_tipo_pago,t.nombre_tipo_pago,  td.cod_tipo_documento, td.nombre_tipo_documento , ps.cod_pais, ps.nombre_pais,  c.cod_ciudad,c.nombre_ciudad,  p.direccion_proveedor,  p.telefono_proveedor, " +
                            " p.email_proveedor,  p.fax_proveedor,  p.pagina_web_proveedor,  p.obs_proveedor,  p.nombre_cheque,  tp.cod_tipo_medio_pago,tp.nombre_tipo_medio_pago, " +
                            " p.dias_termino_pago " +
                            " FROM public.proveedores p " +
                            " inner join public.estados_proveedor e on e.cod_estado_proveedor = p.cod_estado_proveedor " +
                            " inner join public.monedas m on m.cod_moneda = p.cod_moneda " +
                            " inner join public.tipos_pago t on t.cod_tipo_pago = p.cod_tipo_pago " +
                            " inner join public.tipos_documento td on td.cod_tipo_documento = p.cod_tipo_documento " +
                            " left outer join public.pais ps on ps.cod_pais = p.cod_pais " +
                            " left outer join public.tipos_medio_pago tp on tp.cod_tipo_medio_pago = p.cod_tipo_medio_pago  "+
                            " left outer join public.ciudad c on c.cod_ciudad = p.cod_ciudad where 0=0 ";
                            
            if(!pro.getNombreProveedor().equals("")){
                query +=" and p.nombre_proveedor like '%"+pro.getNombreProveedor()+"%' ";
            }
            
            if(pro.getMonedas().getCodMoneda()!=0){
                query +=" and m.cod_moneda = '"+pro.getMonedas().getCodMoneda()+"' ";
            }
            if(pro.getTiposProveedor().getCodTipoProveedor()!=0){
                query +=" and p.cod_tipo_proveedor = '"+pro.getTiposProveedor().getCodTipoProveedor()+"' ";
            }
            if(pro.getCiudad().getCodCiudad()!=0){
                query += " and c.cod_ciudad = '"+pro.getCiudad().getCodCiudad()+"' ";
            }
            if(!pro.getDireccionProveedor().equals("")){
                query +=" and p.direccion_proveedor like '%"+pro.getDireccionProveedor()+"%'  ";
            }
            query +=" ORDER BY p.nombre_proveedor DESC LIMIT 10 OFFSET "+pro.getFilaInicial()+"   ";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            proveedorList.clear();
            Proveedor p = new Proveedor();
            while (rs.next())
            {
                p = new Proveedor();
                p.setCodProveedor(rs.getInt("cod_proveedor"));
                p.setNombreProveedor(rs.getString("nombre_proveedor"));
                p.setNitProveedor(rs.getString("nit_proveedor"));
                p.getTiposProveedor().setCodTipoProveedor(rs.getInt("cod_tipo_proveedor"));
                p.getEstadosProveedor().setCodEstadoProveedor(rs.getInt("cod_estado_proveedor"));
                p.getMonedas().setCodMoneda(rs.getInt("cod_moneda"));
                p.getMonedas().setNombreMoneda(rs.getString("nombre_moneda"));
                p.getTiposPago().setCodTipoPago(rs.getInt("cod_tipo_pago"));
                p.getTiposPago().setNombreTipoPago(rs.getString("nombre_tipo_pago"));
                p.getTiposDocumento().setCodTipoDocumento(rs.getInt("cod_tipo_documento"));
                p.getTiposDocumento().setNombreTipoDocumento(rs.getString("nombre_tipo_documento"));
                p.getPais().setCodPais(rs.getInt("cod_pais"));
                p.getPais().setNombrePais(rs.getString("nombre_pais"));
                p.getCiudad().setCodCiudad(rs.getInt("cod_ciudad"));
                p.getCiudad().setNombreCiudad(rs.getString("nombre_ciudad"));
                p.setDireccionProveedor(rs.getString("direccion_proveedor"));
                p.setTelefonoProveedor(rs.getString("telefono_proveedor"));
                p.setEmailProveedor(rs.getString("email_proveedor"));
                p.setFaxProveedor(rs.getString("fax_proveedor"));
                p.setPaginaWebProveedor(rs.getString("pagina_web_proveedor"));
                p.setObsProveedor(rs.getString("obs_proveedor"));
                p.setNombreCheque(rs.getString("nombre_cheque"));
                p.getTiposMedioPago().setCodTipoMedioPago(rs.getInt("cod_tipo_medio_pago"));
                p.getTiposMedioPago().setNombreTipoMedioPago(rs.getString("nombre_tipo_medio_pago"));
                p.setDiasTerminoPago(rs.getString("dias_termino_pago"));
                
                proveedorList.add(p);
            }
                
                
            rs.close();
            statement.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return proveedorList;
    }
    public  int guardarProveedor(Proveedor p) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement st = this.con.createStatement();
            
            String cons =   " INSERT INTO public.proveedores  " +
                            " ( cod_proveedor,  nombre_proveedor,  nit_proveedor,  cod_tipo_proveedor,  cod_estado_proveedor,  cod_moneda,  " +
                            " cod_tipo_pago,  cod_tipo_documento,  cod_pais,  cod_ciudad,  direccion_proveedor,  telefono_proveedor,  " +
                            " email_proveedor,  fax_proveedor,  pagina_web_proveedor,  obs_proveedor,  nombre_cheque,  cod_tipo_medio_pago,  " +
                            " dias_termino_pago )  " +
                            " VALUES ((select nextval('public.\"seqProveedor\"')),  '"+p.getNombreProveedor()+"',  '"+p.getNitProveedor()+"',  '"+p.getTiposProveedor().getCodTipoProveedor()+"',  '"+p.getEstadosProveedor().getCodEstadoProveedor()+"',  " +
                            " '"+p.getMonedas().getCodMoneda()+"',  '"+p.getTiposPago().getCodTipoPago()+"',  '"+p.getTiposDocumento().getCodTipoDocumento()+"',  '"+p.getPais().getCodPais()+"',  '"+p.getCiudad().getCodCiudad()+"',  '"+p.getDireccionProveedor()+"',  " +
                            " '"+p.getTelefonoProveedor()+"',  '"+p.getEmailProveedor()+"',  '"+p.getFaxProveedor()+"',  '"+p.getPaginaWebProveedor()+"',  '"+p.getObsProveedor()+"',  " +
                            " '"+p.getNombreCheque()+"',  '"+p.getTiposMedioPago().getCodTipoMedioPago()+"',  '"+p.getDiasTerminoPago()+"'); ";
            
            System.out.println("cons " + cons);
            guardado = st.executeUpdate(cons);
            
            st.close();
            //con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return guardado;
    }
    public  int codigoProveedor() throws Exception{
        int codProveedor=0;
        try {
            
            Statement statement = this.con.createStatement();
            String cons = "select COALESCE(max(p.cod_proveedor),0)+1 cod_proveedor from proveedor p";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                codProveedor = rs.getInt("cod_proveedor");
            }
            
            statement.close();
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());            
        }
        return codProveedor;
    }
    public  int editarProveedor(Proveedor p) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons =   "  UPDATE   " +
                            "  public.proveedores   " +
                            "  SET   " +
                            "  nombre_proveedor = '"+p.getNombreProveedor()+"',  " +
                            "  nit_proveedor = '"+p.getNitProveedor()+"',  " +
                            "  cod_tipo_proveedor = '"+p.getTiposProveedor().getCodTipoProveedor()+"',  " +
                            "  cod_estado_proveedor = '"+p.getEstadosProveedor().getCodEstadoProveedor()+"',  " +
                            "  cod_moneda = '"+p.getMonedas().getCodMoneda()+"',  " +
                            "  cod_tipo_pago = '"+p.getTiposPago().getCodTipoPago()+"',  " +
                            "  cod_tipo_documento = '"+p.getTiposDocumento().getCodTipoDocumento()+"',  " +
                            "  cod_pais = '"+p.getPais().getCodPais()+"',  " +
                            "  cod_ciudad = '"+p.getCiudad().getCodCiudad()+"',  " +
                            "  direccion_proveedor = '"+p.getDireccionProveedor()+"',  " +
                            "  telefono_proveedor = '"+p.getTelefonoProveedor()+"',  " +
                            "  email_proveedor = '"+p.getEmailProveedor()+"',  " +
                            "  fax_proveedor = '"+p.getFaxProveedor()+"',  " +
                            "  pagina_web_proveedor = '"+p.getPaginaWebProveedor()+"',  " +
                            "  obs_proveedor = '"+p.getObsProveedor()+"',  " +
                            "  nombre_cheque = '"+p.getNombreCheque()+"',  " +
                            "  cod_tipo_medio_pago = '"+p.getTiposMedioPago().getCodTipoMedioPago()+"',  " +
                            "  dias_termino_pago = '"+p.getDiasTerminoPago()+"'  " +
                            "WHERE   " +
                            "  cod_proveedor = '"+p.getCodProveedor()+"'  " +
                            " ";
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return guardado;
    }
    public  int eliminarProveedor(Proveedor p) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons = " delete from public.proveedores where cod_proveedor= '"+p.getCodProveedor()+"' ";
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            statement.close();
            //con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return guardado;
    }
    public  Proveedor buscarProveedor(Proveedor pro) throws Exception {
        List<Proveedor> proveedorList =new ArrayList<Proveedor>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        Proveedor p = new Proveedor();
        try {
            
            

            
            String query =  " SELECT p.cod_proveedor,  p.nombre_proveedor,  p.nit_proveedor,  p.cod_tipo_proveedor,  p.cod_estado_proveedor,  " +
                            " p.cod_moneda,  p.cod_tipo_pago,  p.cod_tipo_documento,  p.cod_pais,  p.cod_ciudad,  p.direccion_proveedor,  " +
                            " p.telefono_proveedor,  p.email_proveedor,  p.fax_proveedor,  p.pagina_web_proveedor,  p.obs_proveedor,  " +
                            " p.nombre_cheque,  p.cod_tipo_medio_pago,  p.dias_termino_pago" +
                            " FROM  " +
                            " public.proveedores p where 0=0 ";
                    if(pro.getCodProveedor()!=0){
                        query += " and p.cod_proveedor='"+pro.getCodProveedor()+"'  ";
                    }
                    
            
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            proveedorList.clear();
            
            while (rs.next())
            {
                p = new Proveedor();
                p.setCodProveedor(rs.getInt("cod_proveedor"));
                p.setNombreProveedor(rs.getString("nombre_proveedor"));
                p.setNitProveedor(rs.getString("nit_proveedor"));
                
                proveedorList.add(p);
            }
                
                
            rs.close();
            statement.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return p;
    }
    
    
    
    
}
