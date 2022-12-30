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
import servicio.model.UsuarioPersonal;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class UsuarioPersonalResource extends BeanResource {
    Connection con;
    public UsuarioPersonalResource(){
    }
    public UsuarioPersonalResource(Connection con){
        this.con = con;
    }

    public List<UsuarioPersonal> cargarUsuarioPersonales(UsuarioPersonal p) throws Exception {
        List<UsuarioPersonal> usuarioList =new ArrayList<UsuarioPersonal>();
        try {
            
            

            
            String consulta =   " select p1.cod_personal,p1.nombres_personal,p1.ap_paterno_personal,p1.ap_materno_personal, " +
                                " p1.cod_area_empresa " +
                                " from " +
                                " usuario_personal p " +
                                " inner join personal p1 on p.cod_personal = p1.cod_personal " +
                                " where p1.cod_estado_registro = 1 ";
                                if(!p.getNombreUsuario().equals("")){consulta+=" and p.nombre_usuario = '"+p.getNombreUsuario()+"' ";}
                                if(!p.getPasswordUsuario().equals("")){consulta+=" and p.password_usuario = '"+p.getPasswordUsuario()+"' ";}
                                consulta +="";
            System.out.println("consulta " +consulta);

            PreparedStatement statement = this.con.prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            usuarioList.clear();
            while (rs.next())
            {
                UsuarioPersonal pr = new UsuarioPersonal();
                pr.getPersonal().setCodPersonal(rs.getInt("cod_personal"));
                pr.getPersonal().setNombrePersonal(rs.getString("nombres_personal"));
                pr.getPersonal().setApPaternoPersonal(rs.getString("ap_paterno_personal"));
                pr.getPersonal().setApMaternoPersonal(rs.getString("ap_materno_personal"));
                pr.getPersonal().getAreasEmpresa().setCodAreaEmpresa(rs.getInt("cod_area_empresa"));
                usuarioList.add(pr);
                
            }
            rs.close();
            statement.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return usuarioList;
    }
    public int codigoUsuarioPersonal() throws Exception{
        int codProductoSemiterminado=0;
        try {
            
            Statement statement = this.con.createStatement();
            String cons = "select COALESCE(max(c.cod_cotizacion),0)+1 cod_cotizacion from cotizacion c";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                codProductoSemiterminado = rs.getInt("cod_cotizacion");
            }
            
            statement.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return codProductoSemiterminado;
    }
    public int guardarUsuarioPersonal(UsuarioPersonal c) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons = "  ";
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
        return guardado;
    }
    public int editarUsuarioPersonal(UsuarioPersonal c) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons = "  UPDATE  " +
                            " COTIZACION   " +
                            " SET  ";
//                            "  COD_CLIENTE = '"+c.getClientes().getCodCliente()+"', " +
//                            "  FECHA_COTIZACION = '"+sdf.format(c.getFechaUsuarioPersonal())+"', " +
//                            "  NRO_PEDIDO = '"+c.getNroPedido()+"', " +
//                            "  COD_TIPO_PAGO = '"+c.getTiposPago().getCodTipoPago()+"', " +
//                            "  DIAS_ENTREGA = '"+c.getDiasEntrega()+"', " +
//                            "  MONTO_ANTICIPO = '"+c.getMontoAnticipo()+"', " +
//                            "  COD_ESTADO_COTIZACION = '"+c.getEstadosUsuarioPersonal().getCodEstadoUsuarioPersonal()+"',"
//                          + " COD_TIPO_MEDIO_PAGO = '"+c.getTiposMedioPago().getCodTipoMedioPago()+"',"
//                          + " COD_PAIS = '"+c.getPais().getCodPais()+"',"
//                          + " COD_CIUDAD = '"+c.getCiudad().getCodCiudad()+"',"
//                          + " EMAIL_ENVIADO = '"+c.getEmailEnviado()+"' " +
//                            " WHERE  " +
//                            "  COD_COTIZACION = '"+c.getCodUsuarioPersonal()+"' ";
            
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
        return guardado;
    }
    
    public UsuarioPersonal buscarUsuarioPersonal(UsuarioPersonal p) throws Exception {
        UsuarioPersonal usuario =new UsuarioPersonal();
        try {
            
            

            
            String consulta =   " select p1.cod_personal,p1.nombres_personal,p1.ap_paterno_personal,p1.ap_materno_personal, " +
                                " p1.cod_area_empresa,p.cod_proyecto " +
                                " from " +
                                " usuario_personal p " +
                                " inner join personal p1 on p.cod_personal = p1.cod_personal " +
                                " where p1.cod_estado_registro = 1 ";
                                if(!p.getNombreUsuario().equals("")){consulta+=" and p.nombre_usuario = '"+p.getNombreUsuario()+"' ";}
                                if(!p.getPasswordUsuario().equals("")){consulta+=" and p.password_usuario = '"+p.getPasswordUsuario()+"' ";}
                                consulta +="";
            System.out.println("consulta " +consulta);

            PreparedStatement statement = this.con.prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            
            if(rs.next())
            {
                usuario = new UsuarioPersonal();
                usuario.getPersonal().setCodPersonal(rs.getInt("cod_personal"));
                usuario.getPersonal().setNombrePersonal(rs.getString("nombres_personal"));
                usuario.getPersonal().setApPaternoPersonal(rs.getString("ap_paterno_personal"));
                usuario.getPersonal().setApMaternoPersonal(rs.getString("ap_materno_personal"));
                usuario.getPersonal().getAreasEmpresa().setCodAreaEmpresa(rs.getInt("cod_area_empresa"));
                usuario.setCodProyecto(rs.getInt("cod_proyecto"));
            }
            
            
            rs.close();
            statement.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return usuario;
    }
    
    
    
}
