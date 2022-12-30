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
import servicio.model.Comprobante;

import servicio.model.ComprobanteDetalle;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class ComprobanteDetalleResource {
    Connection con;
    public ComprobanteDetalleResource(){
    }
    public ComprobanteDetalleResource(Connection con){
        this.con = con;
    }
    public  List<ComprobanteDetalle> cargarComprobanteDetalle(Comprobante cd) throws Exception  {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        List<ComprobanteDetalle> cdList =new ArrayList<ComprobanteDetalle>();
        Utiles utiles = new Utiles();
        utiles.getConnection();
        try {
            
            

            
            String consulta =   " SELECT cd.cod_comprobante,  cd.cod_comprobante_detalle,  p.cod_plan_cuenta,p.cod_cuenta,p.nombre_cuenta,  cd.cod_regional,  cd.cod_producto, " +
                                "  cd.cod_linea,  c.cod_centro_costos,c.nombre_centro_costos || '(' ||t.NOMBRE_TIPO_CENTRO_COSTOS||')' NOMBRE_CENTRO_COSTOS ,  cd.debe,  cd.haber,  cd.glosa,  cd.debesus,  cd.habersus,  cd.cod_orden_compra,cd.cod_gestion,e.cod_estado_cuenta cod_estado_cuenta_r,p.estado_cuentas " +
                                " FROM " +
                                "  cont.comprobante_detalle cd " +
                                "  left outer join cont.plan_de_cuentas p on p.cod_plan_cuenta = cd.cod_plan_cuenta and p.cod_gestion = cd.cod_gestion " +
                                "  left outer join cont.centro_de_costos c on c.cod_centro_costos = cd.cod_centro_costos  "+
                                "  left outer join cont.tipos_centro_de_costo t on t.cod_tipo_centro_costos = c.cod_tipo_centro_costos "+
                                "  left outer join cont.estado_de_cuentas_relacionadas e on e.cod_comprobante = cd.cod_comprobante"+
                                "  and e.cod_comprobante_detalle = cd.cod_comprobante_detalle and e.cod_plan_cuenta = cd.cod_plan_cuenta"+
                                "  and e.cod_centro_costos = cd.cod_centro_costos and e.cod_gestion = cd.cod_gestion  "+ 
                                " where cd.cod_comprobante = '"+cd.getCodComprobante()+"' and cd.cod_gestion = '"+cd.getGestion().getCodGestion()+"' "+
                                "  order by  cd.cod_comprobante_detalle asc";
            
            
            
            
            System.out.println("consulta " +consulta);

            PreparedStatement statement = utiles.getCon().prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            cdList.clear();
            while (rs.next())
            {
                ComprobanteDetalle c = new ComprobanteDetalle();
                c.getComprobante().setCodComprobante(rs.getInt("cod_comprobante"));
                c.setCodComprobanteDetalle(rs.getInt("cod_comprobante_detalle"));
                c.getPlanDeCuentas().setCodPlanCuenta(rs.getInt("cod_plan_cuenta"));
                c.getPlanDeCuentas().setCodCuenta(rs.getString("cod_cuenta"));                
                c.getPlanDeCuentas().setNombreCuenta(rs.getString("nombre_cuenta"));
                c.getPlanDeCuentas().getCentroCostos().setCodCentroCostos(rs.getInt("cod_centro_costos"));
                c.getPlanDeCuentas().getCentroCostos().setNombreCentroCostos(rs.getString("nombre_centro_costos"));
                c.getPlanDeCuentas().setEstadoCuenta(rs.getInt("estado_cuentas"));
                c.setDebe(rs.getDouble("debe"));
                c.setHaber(rs.getDouble("haber"));
                c.setGlosa(rs.getString("glosa"));
                c.setDebeSus(rs.getDouble("debesus"));
                c.setHaberSus(rs.getDouble("habersus"));
                c.getComprobante().getGestion().setCodGestion(rs.getInt("cod_gestion"));
                c.setCodEstadoCuenta(rs.getInt("cod_estado_cuenta_r"));
                c.setMontoMaximoDebe(rs.getInt("cod_estado_cuenta_r")>0?rs.getDouble("debe"):0);
                c.setMontoMaximoHaber(rs.getInt("cod_estado_cuenta_r")>0?rs.getDouble("haber"):0);
                
                cdList.add(c);
            }
            rs.close();
            statement.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return cdList;
    }
    public  int codigoComprobanteDetalle(Comprobante c) throws Exception{
        int codDetalle=0;
        Utiles utiles = new Utiles();
        utiles.getConnection();
        try {
            
            Statement statement = utiles.getCon().createStatement();
            String cons = "select COALESCE(max(c.cod_detalle),0)+1 cod_detalle from cont.comprobante_detalle c where c.cod_comprobante = '"+c.getCodComprobante()+"'";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                codDetalle = rs.getInt("cod_detalle");
            }
            
            statement.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        utiles.closeConnection();
        return codDetalle;
    }
    public  int guardarComprobanteDetalle(ComprobanteDetalle cd) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons =   " INSERT INTO cont.comprobante_detalle " +
                            " ( " +
                            "  cod_comprobante,  cod_comprobante_detalle,  cod_plan_cuenta,  cod_regional,  cod_producto,  cod_linea, " +
                            "  cod_centro_costos,  debe,  haber,  glosa,  debesus,  habersus,  cod_orden_compra,cod_gestion) " +
                            " VALUES (  '"+cd.getComprobante().getCodComprobante()+"', '"+cd.getCodComprobanteDetalle()+"' ,  '"+cd.getPlanDeCuentas().getCodPlanCuenta()+"',  null,  null, " +
                            "  null,  '"+cd.getPlanDeCuentas().getCentroCostos().getCodCentroCostos()+"',  '"+cd.getDebe()+"',  '"+cd.getHaber()+"',  '"+cd.getGlosa()+"',  '"+cd.getDebeSus()+"',  '"+cd.getHaberSus()+"',  null,'"+cd.getComprobante().getGestion().getCodGestion()+"'); ";

            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //con.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error en guardarComprobanteDetalle");
        }
        return guardado;
    }
    
    public  int editarComprobanteDetalle(ComprobanteDetalle i){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons =   "  ";
            
            
            
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //con.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return guardado;
    }    
    public  int borraComprobanteDetalle(ComprobanteDetalle c) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons =   " delete from cont.comprobante_detalle " +
                            " WHERE cod_comprobante='"+c.getComprobante().getCodComprobante()+"' and cod_gestion = '"+c.getComprobante().getGestion().getCodGestion()+"' ";
            
            
            
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //con.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
        return guardado;
    }
    
    public  ComprobanteDetalle buscarComprobanteDetalle(ComprobanteDetalle c) throws Exception{        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        ComprobanteDetalle cd = new ComprobanteDetalle();
        Utiles utiles = new Utiles();
        utiles.getConnection();

        try {
            
        
            String consulta =   " SELECT cd.cod_comprobante,  cd.cod_comprobante_detalle,  p.cod_plan_cuenta,p.nombre_cuenta,  cd.cod_regional,  cd.cod_producto, " +
                                "  cd.cod_linea,  cd.cod_centro_costos,  cd.debe,  cd.haber,  cd.glosa,  cd.debesus,  cd.habersus,  cd.cod_orden_compra " +
                                " FROM " +
                                "  cont.comprobante_detalle cd"+
                                "  inner join cont.comprobante c on c.cod_comprobante = cd.cod_comprobante and c.cod_gestion = cd.cod_gestion " +
                                "  left outer join cont.plan_de_cuentas p on p.cod_plan_cuenta = cd.cod_plan_cuenta " +
                                " where 0=0 and cd.cod_gestion = '"+c.getComprobante().getGestion().getCodGestion()+"'";
                                if(c.getComprobante().getCodComprobante()!=0){
                                    consulta += " and c.cod_comprobante = '"+c.getComprobante().getCodComprobante()+"'";
                                }
                                if(c.getComprobante().getEstadosComprobante().getCodEstadoComprobante()!=0){
                                    consulta += " and c.cod_estado_comprobante = '"+c.getComprobante().getEstadosComprobante().getCodEstadoComprobante()+"'";
                                }
                                if(c.getPlanDeCuentas().getCodPlanCuenta()!=0){
                                    consulta += " and cd.cod_plan_cuenta = '"+c.getPlanDeCuentas().getCodPlanCuenta()+"'";
                                }
                                  
                                
            
            
            
            
            System.out.println("consulta " +consulta);

            PreparedStatement statement = utiles.getCon().prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next())
            {
                
                cd.getComprobante().setCodComprobante(rs.getInt("cod_comprobante"));
                cd.setCodComprobanteDetalle(rs.getInt("cod_comprobante_detalle"));
                cd.getPlanDeCuentas().setCodPlanCuenta(rs.getInt("cod_plan_cuenta"));
                cd.getPlanDeCuentas().setNombreCuenta(rs.getString("nombre_cuenta"));
                cd.setDebe(rs.getDouble("debe"));
                cd.setHaber(rs.getDouble("haber"));
                cd.setGlosa(rs.getString("glosa"));
                cd.setDebeSus(rs.getDouble("debesus"));
                cd.setHaberSus(rs.getDouble("habersus"));
                
            }
            rs.close();
            statement.close();
            
            //con.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        utiles.closeConnection();
        return cd;
    }
}
