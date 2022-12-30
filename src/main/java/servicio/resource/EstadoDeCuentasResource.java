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

import servicio.model.EstadoDeCuenta;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class EstadoDeCuentasResource {
    Connection con;
    public EstadoDeCuentasResource(){
    }
    public EstadoDeCuentasResource(Connection con){
        this.con = con;
    }
    
   public  List<EstadoDeCuenta> cargarEstadoDeCuenta(EstadoDeCuenta ec) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //yyyy/MM/dd HH:mm:ss
        List<EstadoDeCuenta> ecdList =new ArrayList<EstadoDeCuenta>();
        try {
            
            

            
            String consulta =   " select COD_ESTADO_CUENTA,MONTOBS,montoPagadoBS,NRO_COMPROBANTE,MONTOBS-montoPagadoBS montofaltanteBS,NRO_FACTURA,FECHA_COMPROBANTE,GLOSA,nombre_tipo_comprobante,"+
                                " debe,haber,debesus,habersus from ( " +
                                " SELECT E.COD_ESTADO_CUENTA, " +
                                "       E.MONTOBS, " +
                                "       ( " +
                                "         select coalesce(sum(MONTOBS), 0) " +
                                "         from cont.ESTADO_DE_CUENTAS_RELACIONADAS er, " +
                                "              cont.COMPROBANTE COM " +
                                "         where er.COD_ESTADO_CUENTA = e.COD_ESTADO_CUENTA AND " +
                                "               COM.COD_COMPROBANTE = ER.COD_COMPROBANTE AND " +
                                "               COM.COD_ESTADO_COMPROBANTE = 1  " +
                                "       ) as montoPagadoBS, " +
                                "       C.NRO_COMPROBANTE, " +
                                "       C.NRO_FACTURA, " +
                                "       c.FECHA_COMPROBANTE, " +
                                "       cd.GLOSA,"+
                                "       t.nombre_tipo_comprobante,cd.debe,cd.haber,cd.debesus,cd.habersus " +
                                " FROM cont.ESTADO_DE_CUENTAS E " +
                                "     inner join cont.COMPROBANTE_DETALLE cd on e.COD_COMPROBANTE_DETALLE = cd.COD_COMPROBANTE_DETALLE and " +
                                "      E.COD_COMPROBANTE = cd.COD_COMPROBANTE AND " +
                                "      E.COD_PLAN_CUENTA = cd.COD_PLAN_CUENTA AND " +
                                "      coalesce(e.COD_REGIONAL,0) = coalesce (cd.COD_REGIONAL,0 ) AND " +
                                "      coalesce( e.COD_LINEA,0) = coalesce( cd.COD_LINEA,0) and " +
                                "      coalesce( e.COD_PRODUCTO,0) = coalesce( cd.COD_PRODUCTO,0) AND " +
                                "      coalesce( e.COD_CENTRO_COSTOS,0) = coalesce( cd.COD_CENTRO_COSTOS,0) " +
                                "     inner join cont.COMPROBANTE C on  cd.COD_COMPROBANTE = C.COD_COMPROBANTE " +
                                "     left outer join cont.tipos_comprobante t on t.cod_tipo_comprobante = c.cod_tipo_comprobante " +
                                " WHERE c.COD_ESTADO_COMPROBANTE = 1 and " +
                                "      c.cod_gestion = '"+ec.getComprobanteDetalle().getComprobante().getGestion().getCodGestion()+"' and " +
                                "      E.COD_PLAN_CUENTA = '"+ec.getComprobanteDetalle().getPlanDeCuentas().getCodPlanCuenta()+"' AND E.COD_TIPO_ESTADO_CUENTA <> 3 ";
                                    if(ec.getComprobanteDetalle().getPlanDeCuentas().getCentroCostos().getCodCentroCostos()!=0){
                                        consulta +=" and e.cod_centro_costos = '"+ec.getComprobanteDetalle().getPlanDeCuentas().getCentroCostos().getCodCentroCostos()+"' ";
                                    }                                
                                    if(ec.getComprobanteDetalle().getPlanDeCuentas().getCentroCostos().getCodCentroCostos()!=0){
                                        consulta +=" and e.cod_centro_costos = '"+ec.getComprobanteDetalle().getPlanDeCuentas().getCentroCostos().getCodCentroCostos()+"' ";
                                    }
                                consulta +=" ) ed ";
            
            
            System.out.println("consulta " +consulta);

            PreparedStatement statement = this.con.prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            ecdList.clear();
            while (rs.next())
            {
                EstadoDeCuenta c = new EstadoDeCuenta();
                c.setCodEstadoCuenta(rs.getInt("COD_ESTADO_CUENTA"));
                c.setMontoBS(rs.getDouble("MONTOBS"));
                c.setMontoPagadoBS(rs.getDouble("MONTOPAGADOBS"));
                c.setMontoFaltanteBS(rs.getDouble("montofaltanteBS"));
                c.getComprobanteDetalle().getComprobante().setNroFactura(rs.getString("NRO_FACTURA"));
                c.getComprobanteDetalle().getComprobante().setNroComprobante(rs.getInt("NRO_COMPROBANTE"));
                c.getComprobanteDetalle().getComprobante().setFechaComprobante(sdf.format(rs.getTimestamp("FECHA_COMPROBANTE")));
                c.getComprobanteDetalle().getComprobante().setGlosa(rs.getString("glosa"));
                c.getComprobanteDetalle().getComprobante().getTiposComprobante().setNombreTipoComprobante(rs.getString("nombre_tipo_comprobante"));
                c.getComprobanteDetalle().setDebe(rs.getDouble("debe"));
                c.getComprobanteDetalle().setHaber(rs.getDouble("haber"));
                c.getComprobanteDetalle().setDebeSus(rs.getDouble("debeSus"));
                c.getComprobanteDetalle().setHaberSus(rs.getDouble("haberSus"));
                
                
                ecdList.add(c);
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
        return ecdList;
    }
    public  int codigoEstadoDeCuenta() throws Exception{
        int codComprobante=0;
        try {
            
            Statement statement = this.con.createStatement();
            String cons = "select nextval('cont.\"seqEstadoDeCuenta\"') cod";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                codComprobante = rs.getInt("cod");
            }
            
            statement.close();
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
            
        }
        return codComprobante;
    }
    public  int guardarEstadoDeCuenta(EstadoDeCuenta e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons =  " INSERT INTO  " +
                    " cont.estado_de_cuentas " +
                    " ( cod_estado_cuenta,  cod_tipo_estado_cuenta,  cod_comprobante,  cod_plan_cuenta,  cod_regional,  cod_linea,  cod_producto, " +
                    "  cod_centro_costos,  montobs,  montosus,  cod_comprobante_detalle,cod_gestion) " +
                    " VALUES (  '"+e.getCodEstadoCuenta()+"',  '"+e.getTipoEstadoCuenta().getCodTipoEstadoCuenta()+"',  '"+e.getComprobanteDetalle().getComprobante().getCodComprobante()+"',  '"+e.getComprobanteDetalle().getPlanDeCuentas().getCodPlanCuenta()+"',null,  null, " +
                    " null,  '"+e.getComprobanteDetalle().getPlanDeCuentas().getCentroCostos().getCodCentroCostos()+"',  '"+e.getMontoBS()+"',  '"+e.getMontoSUS()+"',  '"+e.getComprobanteDetalle().getCodComprobanteDetalle()+"','"+e.getComprobanteDetalle().getComprobante().getGestion().getCodGestion()+"');";

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
    
    
    
    public  int editarEstadoDeCuenta(EstadoDeCuenta e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons =   "  UPDATE " +
                            "  cont.estado_de_cuentas " +
                            "  SET " +
                            "  cod_tipo_estado_cuenta = '"+e.getTipoEstadoCuenta().getCodTipoEstadoCuenta()+"', " +
                            "  cod_comprobante = '"+e.getComprobanteDetalle().getComprobante().getCodComprobante()+"', " +
                            "  cod_plan_cuenta = '"+e.getComprobanteDetalle().getPlanDeCuentas().getCodPlanCuenta()+"', " +
                            "  cod_regional = null, " +
                            "  cod_linea = null, " +
                            "  cod_producto = null, " +
                            "  cod_centro_costos = '"+e.getComprobanteDetalle().getPlanDeCuentas().getCentroCostos().getCodCentroCostos()+"', " +
                            "  montobs = '"+e.getMontoBS()+"', " +
                            "  montosus = '"+e.getMontoSUS()+"', " +
                            "  cod_comprobante_detalle = '"+e.getComprobanteDetalle().getCodComprobanteDetalle()+"',"+
                            "  cod_gestion = '"+e.getComprobanteDetalle().getComprobante().getGestion().getCodGestion()+"' " +
                            "  WHERE " +
                            "  cod_estado_cuenta = '"+e.getCodEstadoCuenta()+"' ";
            
            
            
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
    public  int borraEstadoDeCuenta(EstadoDeCuenta c) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons =   "  DELETE FROM  " +
                            "  cont.estado_de_cuentas  " +
                            "  WHERE  " +
                            "  cod_comprobante = '"+c.getComprobanteDetalle().getComprobante().getCodComprobante()+"' and cod_gestion = '"+c.getComprobanteDetalle().getComprobante().getGestion().getCodGestion()+"' ";
            
            
            
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
    
    public  EstadoDeCuenta buscarEstadoDeCuenta(EstadoDeCuenta ec) throws Exception{        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        EstadoDeCuenta e = new EstadoDeCuenta();
        try {
            
            
            String consulta =   " SELECT  cod_estado_cuenta,  cod_tipo_estado_cuenta,  cod_comprobante,  cod_plan_cuenta,   " +
                                " cod_regional,  cod_linea,cod_producto,  cod_centro_costos,  montobs,   " +
                                " montosus,  cod_comprobante_detalle,cod_gestion " +
                                " FROM cont.estado_de_cuentas where cod_estado_cuenta = '"+ec.getCodEstadoCuenta()+"' ; ";
                                  
                                
            
            
            
            
            System.out.println("consulta " +consulta);

            PreparedStatement statement = this.con.prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next())
            {
                e.setCodEstadoCuenta(rs.getInt("cod_estado_cuenta"));
                e.getTipoEstadoCuenta().setCodTipoEstadoCuenta(rs.getInt("cod_tipo_estado_cuenta"));
                e.getComprobanteDetalle().getComprobante().setCodComprobante(rs.getInt("cod_comprobante"));
                e.getComprobanteDetalle().getPlanDeCuentas().setCodPlanCuenta(rs.getInt("cod_plan_cuenta"));
                e.getComprobanteDetalle().getPlanDeCuentas().getCentroCostos().setCodCentroCostos(rs.getInt("cod_centro_costos"));
                e.setMontoBS(rs.getDouble("montobs"));
                e.setMontoSUS(rs.getDouble("montosus"));
                e.getComprobanteDetalle().setCodComprobanteDetalle(rs.getInt("cod_comprobante_detalle"));
                e.getComprobanteDetalle().getComprobante().getGestion().setCodGestion(rs.getInt("cod_gestion"));
                
               
                
            }
            rs.close();
            statement.close();
            
            //con.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
        return e;
    }
    
    public  List<EstadoDeCuenta> cargarEstadoDeCuentaEditar(EstadoDeCuenta ec)  throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //yyyy/MM/dd HH:mm:ss
        List<EstadoDeCuenta> ecdList =new ArrayList<EstadoDeCuenta>();
        try {
            
            

            //para que muestre de forma adicional el estado de cuentas que dio de baja
            String consulta =   " select COD_ESTADO_CUENTA,MONTOBS,montoPagadoBS,NRO_COMPROBANTE,MONTOBS-montoPagadoBS montofaltanteBS,NRO_FACTURA,FECHA_COMPROBANTE,GLOSA,nombre_tipo_comprobante,"+
                                " debe,haber,debesus,habersus from ( " +
                                " SELECT E.COD_ESTADO_CUENTA, " +
                                "       E.MONTOBS, " +
                                "       ( " +
                                "         select coalesce(sum(MONTOBS), 0) " +
                                "         from cont.ESTADO_DE_CUENTAS_RELACIONADAS er, " +
                                "              cont.COMPROBANTE COM " +
                                "         where er.COD_ESTADO_CUENTA = e.COD_ESTADO_CUENTA AND " +
                                "               COM.COD_COMPROBANTE = ER.COD_COMPROBANTE AND " +
                                "               COM.COD_ESTADO_COMPROBANTE = 1 and "+
                                "         er.cod_comprobante||''||er.cod_comprobante_detalle||''||er.cod_plan_cuenta||''||er.cod_centro_costos||''||er.cod_gestion <> "+
                                "'"+ec.getComprobanteDetalle().getComprobante().getCodComprobante()+""+
                                ""+ec.getComprobanteDetalle().getCodComprobanteDetalle()+""+
                                ""+ec.getComprobanteDetalle().getPlanDeCuentas().getCodPlanCuenta()+""+
                                ""+ec.getComprobanteDetalle().getPlanDeCuentas().getCentroCostos().getCodCentroCostos()+""+
                                ""+ec.getComprobanteDetalle().getComprobante().getGestion().getCodGestion()+"' " +
                                "       ) as montoPagadoBS, " +
                                "       C.NRO_COMPROBANTE, " +
                                "       C.NRO_FACTURA, " +
                                "       c.FECHA_COMPROBANTE, " +
                                "       cd.GLOSA,"+
                                "       t.nombre_tipo_comprobante,cd.debe,cd.haber,cd.debesus,cd.habersus " +
                                " FROM cont.ESTADO_DE_CUENTAS E " +
                                "     inner join cont.COMPROBANTE_DETALLE cd on e.COD_COMPROBANTE_DETALLE = cd.COD_COMPROBANTE_DETALLE and " +
                                "      E.COD_COMPROBANTE = cd.COD_COMPROBANTE AND " +
                                "      E.COD_PLAN_CUENTA = cd.COD_PLAN_CUENTA AND " +
                                "      coalesce(e.COD_REGIONAL,0) = coalesce (cd.COD_REGIONAL,0 ) AND " +
                                "      coalesce( e.COD_LINEA,0) = coalesce( cd.COD_LINEA,0) and " +
                                "      coalesce( e.COD_PRODUCTO,0) = coalesce( cd.COD_PRODUCTO,0) AND " +
                                "      coalesce( e.COD_CENTRO_COSTOS,0) = coalesce( cd.COD_CENTRO_COSTOS,0) " +
                                "     inner join cont.COMPROBANTE C on  cd.COD_COMPROBANTE = C.COD_COMPROBANTE " +
                                "     left outer join cont.tipos_comprobante t on t.cod_tipo_comprobante = c.cod_tipo_comprobante " +
                                " WHERE c.COD_ESTADO_COMPROBANTE = 1 and " +
                                "      c.cod_gestion = '"+ec.getComprobanteDetalle().getComprobante().getGestion().getCodGestion()+"' and " +
                                "      E.COD_PLAN_CUENTA = '"+ec.getComprobanteDetalle().getPlanDeCuentas().getCodPlanCuenta()+"'";
                                if(ec.getComprobanteDetalle().getPlanDeCuentas().getCentroCostos().getCodCentroCostos()!=0){
                                    consulta += "      AND E.COD_CENTRO_COSTOS = '"+ec.getComprobanteDetalle().getPlanDeCuentas().getCentroCostos().getCodCentroCostos()+"'  ";
                                }
                                consulta +="  AND (E.COD_TIPO_ESTADO_CUENTA <> 3"+
                                "      or  e.cod_estado_cuenta in( select er.cod_estado_cuenta from cont.estado_de_cuentas_relacionadas er where "+
                                "               er.cod_comprobante= '"+ec.getComprobanteDetalle().getComprobante().getCodComprobante()+"'"+
                                "               and er.cod_comprobante_detalle='"+ec.getComprobanteDetalle().getCodComprobanteDetalle()+"'"+
                                "               and er.cod_plan_cuenta = '"+ec.getComprobanteDetalle().getPlanDeCuentas().getCodPlanCuenta()+"'"+
                                "               and er.cod_centro_costos= '"+ec.getComprobanteDetalle().getPlanDeCuentas().getCentroCostos().getCodCentroCostos()+"'"+
                                "               and er.cod_gestion = '"+ec.getComprobanteDetalle().getComprobante().getGestion().getCodGestion()+"')) " +
                                " ) ed ";
            
            
            System.out.println("consulta " +consulta);

            PreparedStatement statement = this.con.prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            ecdList.clear();
            while (rs.next())
            {
                EstadoDeCuenta c = new EstadoDeCuenta();
                c.setCodEstadoCuenta(rs.getInt("COD_ESTADO_CUENTA"));
                c.setMontoBS(rs.getDouble("MONTOBS"));
                c.setMontoPagadoBS(rs.getDouble("MONTOPAGADOBS"));
                c.setMontoFaltanteBS(rs.getDouble("montofaltanteBS"));
                c.getComprobanteDetalle().getComprobante().setNroFactura(rs.getString("NRO_FACTURA"));
                c.getComprobanteDetalle().getComprobante().setNroComprobante(rs.getInt("NRO_COMPROBANTE"));
                c.getComprobanteDetalle().getComprobante().setFechaComprobante(sdf.format(rs.getTimestamp("FECHA_COMPROBANTE")));
                c.getComprobanteDetalle().getComprobante().setGlosa(rs.getString("glosa"));
                c.getComprobanteDetalle().getComprobante().getTiposComprobante().setNombreTipoComprobante(rs.getString("nombre_tipo_comprobante"));
                c.getComprobanteDetalle().setDebe(rs.getDouble("debe"));
                c.getComprobanteDetalle().setHaber(rs.getDouble("haber"));
                c.getComprobanteDetalle().setDebeSus(rs.getDouble("debeSus"));
                c.getComprobanteDetalle().setHaberSus(rs.getDouble("haberSus"));
                
                
                ecdList.add(c);
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
        return ecdList;
    }
    
    
}
