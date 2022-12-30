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

import servicio.model.EstadoDeCuentasRelacionadas;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class EstadoDeCuentasRelacionadasResource {
    Connection con;
    public EstadoDeCuentasRelacionadasResource(){
    }
    public EstadoDeCuentasRelacionadasResource(Connection con){
        this.con = con;
    }
    public  List<EstadoDeCuentasRelacionadas> cargarEstadoDeCuentasRelacionadas(Comprobante cd) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        List<EstadoDeCuentasRelacionadas> ecdList =new ArrayList<EstadoDeCuentasRelacionadas>();
        try {
            
            String consulta =   " ";
            System.out.println("consulta " +consulta);

            PreparedStatement statement = this.con.prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            ecdList.clear();
            while (rs.next())
            {
                EstadoDeCuentasRelacionadas c = new EstadoDeCuentasRelacionadas();
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
    public  int codigoEstadoDeCuentasRelacionadas() throws Exception{
        int codComprobante=0;
        try {
            
            Statement statement = this.con.createStatement();
            String cons = "select nextval('cont.\"seqEstadoDeCuentasRelacionadas\"') cod";
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
    public  Double montoPagado(EstadoDeCuentasRelacionadas er) throws Exception{
        Double monto=0.0;
        try {
            
            Statement statement = this.con.createStatement();
            String cons =   " select coalesce(sum(MONTOBS), 0) monto_pagado " +
                            " from cont.ESTADO_DE_CUENTAS_RELACIONADAS er, " +
                            " cont.COMPROBANTE COM " +
                            " where er.COD_ESTADO_CUENTA = '"+er.getEstadoDeCuenta().getCodEstadoCuenta()+"' AND " +
                            " COM.COD_COMPROBANTE = ER.COD_COMPROBANTE AND " +
                            " COM.COD_ESTADO_COMPROBANTE = 1  ";
            
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                monto = rs.getDouble("monto_pagado");
            }
            
            statement.close();
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return monto;
    }
    public  int guardarEstadoDeCuentasRelacionadas(EstadoDeCuentasRelacionadas e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons =   " INSERT INTO " +
                            "  cont.estado_de_cuentas_relacionadas " +
                            " ( cod_estado_cuenta_relacionada,  cod_estado_cuenta,  montobs,  montosus,  cod_comprobante,  cod_plan_cuenta, " +
                            "  cod_regional,  cod_linea,  cod_producto,  cod_centro_costos,  cod_comprobante_detalle,cod_gestion) " +
                            " VALUES ( null,  '"+e.getEstadoDeCuenta().getCodEstadoCuenta()+"',  '"+e.getMontoBS()+"',  '"+e.getMontoSUS()+"',  '"+e.getCodComprobante()+"', " +
                            " '"+e.getCodPlanCuenta()+"',  '"+e.getCodRegional()+"', '"+e.getCodLinea()+"',  '"+e.getCodProducto()+"',  '"+e.getCodCentroCostos()+"',  '"+e.getCodComprobanteDetalle()+"','"+e.getCodGestion()+"');";

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
    
    public  int editarEstadoDeCuentasRelacionadas(EstadoDeCuentasRelacionadas i) throws Exception{
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
            throw new Exception(ex.getMessage());
        }
        return guardado;
    }    
    
    public  int borraEstadoDeCuentasRelacionadas(EstadoDeCuentasRelacionadas c) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons =   " DELETE FROM " +
                            " cont.estado_de_cuentas_relacionadas " +
                            " WHERE cod_comprobante = '"+c.getCodComprobante()+"' and cod_gestion = '"+c.getCodGestion()+"' ";            
            
            
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
    
    public  EstadoDeCuentasRelacionadas buscarEstadoDeCuentasRelacionadas(EstadoDeCuentasRelacionadas c) throws Exception{        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        EstadoDeCuentasRelacionadas cd = new EstadoDeCuentasRelacionadas();
        try {
            
            
            String consulta =   "";
                                  
                                
            
            
            
            
            System.out.println("consulta " +consulta);

            PreparedStatement statement = this.con.prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next())
            {
                
               
                
            }
            rs.close();
            statement.close();
            
            //con.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
        return cd;
    }
    
    
}
