/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.resource;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import servicio.model.SelectItem;
import javax.ws.rs.core.Response;
import servicio.model.Pais;
import servicio.model.PlanDeCuentasCentroCostos;

import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class PlanDeCuentasCentroCostosResource extends BeanResource {
    Connection con;
    public PlanDeCuentasCentroCostosResource(){
    }
    public PlanDeCuentasCentroCostosResource(Connection con){
        this.con = con;
    }
    public  List<PlanDeCuentasCentroCostos> cargarPlanDeCuentasCentroCostos(PlanDeCuentasCentroCostos pc) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //yyyy/MM/dd HH:mm:ss
        List<PlanDeCuentasCentroCostos> pcList =new ArrayList<PlanDeCuentasCentroCostos>();
        try {
            
           

            
            String consulta =   " select c.cod_centro_costos,p.cod_plan_cuenta, c.nombre_centro_costos,t.nombre_tipo_centro_costos " +
                                " from cont.plan_de_cuentas_por_centro_de_costos pc " +
                                " inner join cont.plan_de_cuentas p on p.cod_plan_cuenta = pc.cod_plan_cuenta and pc.cod_gestion = p.cod_gestion  " +
                                " inner join cont.centro_de_costos c on c.cod_centro_costos = pc.cod_centro_costos " +
                                " inner join cont.tipos_centro_de_costo t on t.cod_tipo_centro_costos = c.cod_tipo_centro_costos " +                                
                                " where 0=0 and p.cod_gestion = '"+pc.getGestion().getCodGestion()+"' and p.cod_plan_cuenta = '"+pc.getPlanDeCuentas().getCodPlanCuenta()+"' " +
                                " order by c.nombre_centro_costos,t.nombre_tipo_centro_costos ";
                    
            System.out.println("consulta " +consulta);

            PreparedStatement statement = this.con.prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            pcList.clear();
            while (rs.next())
            {
                PlanDeCuentasCentroCostos p = new PlanDeCuentasCentroCostos();
                p.getCentroCostos().setCodCentroCostos(rs.getInt("cod_centro_costos"));
                p.getPlanDeCuentas().setCodPlanCuenta(rs.getInt("cod_plan_cuenta"));
                p.getCentroCostos().setNombreCentroCostos(rs.getString("nombre_centro_costos"));
                p.getCentroCostos().getTiposCentroCostos().setNombreTipoCentroCostos(rs.getString("nombre_tipo_centro_costos"));
                
                pcList.add(p);
                
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
        return pcList;
    }
    
    
    public  int guardarPlanDeCuentasCentroCostos(PlanDeCuentasCentroCostos p) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            
            
            Statement statement = this.con.createStatement();
            String cons =   " INSERT INTO  " +
                            "  cont.plan_de_cuentas_por_centro_de_costos " +
                            "(  cod_centro_costos,  cod_plan_cuenta,  cod_gestion,  cod_empresa ) " +
                            "VALUES ('"+p.getCentroCostos().getCodCentroCostos()+"',  '"+p.getPlanDeCuentas().getCodPlanCuenta()+"', '"+p.getGestion().getCodGestion()+"',  '"+p.getEmpresas().getCodEmpresa()+"') ; ";
            
            
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
    public  int editarPlanDeCuentasCentroCostos(PlanDeCuentasCentroCostos p) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons =   "  UPDATE  " +
                            "  cont.plan_de_cuentas_por_centro_de_costos  " +
                            " SET  " +
                            "  cod_centro_costos = ?cod_centro_costos, " +
                            "  cod_plan_cuenta = ?cod_plan_cuenta, " +
                            "  cod_gestion = ?cod_gestion, " +
                            "  cod_empresa = ?cod_empresa " +
                            " WHERE  " +
                            " ;  ";

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
    
    
   
    
    public  int eliminarPlanDeCuentasCentroCostos(PlanDeCuentasCentroCostos p) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons =   "  delete from  " +
                            "  cont.plan_de_cuentas_por_centro_de_costos  " +                            
                            "  where cod_plan_cuenta = '"+p.getPlanDeCuentas().getCodPlanCuenta()+"' and cod_centro_costos='"+p.getCentroCostos().getCodCentroCostos()+"'  and cod_gestion = '"+p.getGestion().getCodGestion()+"'  ";
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
    
    public  List<servicio.model.SelectItem> cargarPlanDeCuentasCentroCostosItem(PlanDeCuentasCentroCostos p) throws Exception {
        List<servicio.model.SelectItem> pList = new ArrayList<servicio.model.SelectItem>();
        try {

            

            String query =  " select c.COD_CENTRO_COSTOS,c.NOMBRE_CENTRO_COSTOS ||'('|| t.NOMBRE_TIPO_CENTRO_COSTOS ||')' NOMBRE_CENTRO_COSTOS " +
                            " from cont.CENTRO_DE_COSTOS c,cont.TIPOS_CENTRO_DE_COSTO t  " +
                            " where c.COD_TIPO_CENTRO_COSTOS=t.COD_TIPO_CENTRO_COSTOS and 0=0 ";
            
                    if (p.getPlanDeCuentas().getCodPlanCuenta() != 0) {
                        String dePlnCtas = p.getDePlanCuentas()==1?"":"not";
                        query += " and " +
                             " c.COD_CENTRO_COSTOS "+dePlnCtas+" in (select COD_CENTRO_COSTOS  " +
                             " from cont.PLAN_DE_CUENTAS_POR_CENTRO_DE_COSTOS " +
                             " where COD_PLAN_CUENTA='"+p.getPlanDeCuentas().getCodPlanCuenta()+"' and COD_GESTION = '"+p.getGestion().getCodGestion()+"') ";
                             
                    }
                    
            
            
            query += " order by t.NOMBRE_TIPO_CENTRO_COSTOS,c.NOMBRE_CENTRO_COSTOS ";
            System.out.println("consulta " + query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            pList.clear();
            while (rs.next()) {
                pList.add(new servicio.model.SelectItem(rs.getInt("COD_CENTRO_COSTOS"), rs.getString("NOMBRE_CENTRO_COSTOS")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return pList;
    }    
    
    
}
