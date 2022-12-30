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
import servicio.model.TiposDocumentoLibroCompras;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class TiposDocumentoLibroComprasResource {
    Connection con;
    public TiposDocumentoLibroComprasResource(){
    }
    public TiposDocumentoLibroComprasResource(Connection con){
        this.con = con;
    }
    public  List<SelectItem> cargarTiposDocumentoLibroComprasItem() throws Exception {
        List<SelectItem> tiposDocumentoList =new ArrayList<SelectItem>();
        try {
            
            
            
            String query = " SELECT cod_tipo_documento_libro_compras,nombre_tipo_documento_libro_compras "
                    + " from cont.tipos_documento_libro_compras "
                    + " order by cod_tipo_documento_libro_compras ";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            tiposDocumentoList.clear();
            while (rs.next())
            {
                tiposDocumentoList.add(new SelectItem(rs.getInt("cod_tipo_documento_libro_compras"), rs.getString("nombre_tipo_documento_libro_compras")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return tiposDocumentoList;
    }
    public  List<TiposDocumentoLibroCompras> cargarTiposDocumentoLibroCompras(TiposDocumentoLibroCompras t) throws Exception {
        List<TiposDocumentoLibroCompras> listTiposDocumentoLibroCompras =new ArrayList<TiposDocumentoLibroCompras>();
        try {
            
            
            String query = " SELECT t.cod_tipo_documento_libro_compras, t.nombre_tipo_documento_libro_compras, t.cod_estado_registro, e.nombre_estado_registro " +
                           " FROM public.tipos_documento t "+
                           " inner join public.estados_registro e on e.cod_estado_registro = t.cod_estado_registro ";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listTiposDocumentoLibroCompras.clear();
            while (rs.next())
            {
                TiposDocumentoLibroCompras r =  new TiposDocumentoLibroCompras();
                r.setCodTipoDocumentoLibroCompra(rs.getInt("cod_tipo_documento_libro_compras"));
                r.setNombreTipoDocumentoLibroCompra(rs.getString("nombre_tipo_documento_libro_compras"));                
                r.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                r.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                
                listTiposDocumentoLibroCompras.add(r);
            }
            //rs.close();
            statement.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return listTiposDocumentoLibroCompras;
    }
    public  int guardarTiposDocumentoLibroCompras(TiposDocumentoLibroCompras t) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            
            Statement statement = this.con.createStatement();
            String cons =   " INSERT INTO public.tipos_documento_libro_compras " +
                            " (cod_tipo_documento_libro_compras,  nombre_tipo_documento_libro_compras,  cod_estado_registro) " +
                            " VALUES ((select nextval('public.\"seqTiposDocumentoLibroCompras\"')), '"+t.getNombreTipoDocumentoLibroCompra()+"', '"+t.getEstadosRegistro().getCodEstado()+"');";
            
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
    public  int editarTiposDocumentoLibroCompras(TiposDocumentoLibroCompras t) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons =   " UPDATE public.tipos_documento" +
                            " SET  nombre_tipo_documento_libro_compras='"+t.getNombreTipoDocumentoLibroCompra()+"',"+                            
                            " cod_estado_registro='"+t.getEstadosRegistro().getCodEstado()+"'" +
                            " WHERE cod_tipo_documento_libro_compras='"+t.getCodTipoDocumentoLibroCompra()+"' ; ";
            
                    
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
    public  int eliminarTiposDocumentoLibroCompras(TiposDocumentoLibroCompras t) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons = " delete from public.tipos_documento where cod_tipo_documento_libro_compras = '"+t.getCodTipoDocumentoLibroCompra()+"' ";
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
