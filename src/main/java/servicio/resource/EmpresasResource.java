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

import servicio.model.Empresas;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class EmpresasResource {
    Connection con;
    public EmpresasResource(){
    }
    public EmpresasResource(Connection con){
        this.con = con;
    }
    public  List<Empresas> cargarEmpresas(Empresas emp) throws Exception {
        List<Empresas> listEmpresas =new ArrayList<Empresas>();
        try {
            
            

            
            String query = " SELECT e.cod_empresa,e.nombre_empresa,e.ruc,e.cod_estado_registro,er.nombre_estado_registro, " +
                            "e.direccion, e.telefono, e.cod_ciudad,c.nombre_ciudad, e.nombre_impuesto,  "+
                            "e.porcentaje_impuesto, e.cod_moneda,m.nombre_moneda, e.logotipo_empresa " +
                            "FROM " +
                            "public.empresa e " +
                            "inner join public.estados_registro er on er.cod_estado_registro = e.cod_estado_registro " +
                            "left outer join public.ciudad c on c.cod_ciudad = e.cod_ciudad " +
                            "left outer join public.monedas m on m.cod_moneda = e.cod_moneda where 0=0 ";
            if(!emp.getNombreEmpresa().trim().equals("")){query+=" AND e.nombre_empresa like '%"+emp.getNombreEmpresa() +"%' ";}
            if(!emp.getRuc().trim().equals("")){query+=" AND e.ruc like '%"+emp.getRuc() +"%' ";}
            if(!emp.getDireccion().trim().equals("")){query+=" AND e.direccion like '%"+emp.getDireccion() +"%' ";}
            if(emp.getCiudad().getCodCiudad()!=0){query+=" AND e.cod_ciudad = '"+emp.getCiudad().getCodCiudad() +"' ";}
            
            query +=" order by e.cod_empresa;";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listEmpresas.clear();
            while (rs.next())
            {
                Empresas  e = new Empresas();
                e.setCodEmpresa(rs.getInt("cod_empresa"));
                e.setNombreEmpresa(rs.getString("nombre_empresa"));
                e.setRuc(rs.getString("ruc"));
                e.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                e.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                e.setDireccion(rs.getString("direccion"));
                e.setTelefono(rs.getString("telefono"));
                e.getCiudad().setCodCiudad(rs.getInt("cod_ciudad"));
                e.getCiudad().setNombreCiudad(rs.getString("nombre_ciudad"));
                e.setNombreImpuesto(rs.getString("nombre_impuesto"));
                e.setPorcentajeImpuesto(rs.getDouble("porcentaje_impuesto"));
                e.getMonedas().setCodMoneda(rs.getInt("cod_moneda"));
                e.getMonedas().setNombreMoneda(rs.getString("nombre_moneda"));
                e.setLogotipoEmpresa(rs.getString("logotipo_empresa"));
                listEmpresas.add(e);
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
        return listEmpresas;
    }
    public  int guardarEmpresa(Empresas e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            
            Statement statement = this.con.createStatement();
            String 
            
            cons = " INSERT INTO public.empresa ( cod_empresa,nombre_empresa, ruc,  cod_estado_registro,  direccion,  telefono,  cod_ciudad,  nombre_impuesto,  porcentaje_impuesto,  cod_moneda,  logotipo_empresa) " +
                   " VALUES ((select nextval('public.\"seqEmpresa\"')),'"+e.getNombreEmpresa()+"', '"+e.getRuc()+"', '"+e.getEstadosRegistro().getCodEstado()+"',  '"+e.getDireccion()+"',  '"+e.getTelefono()+"',  '"+e.getCiudad().getCodCiudad()+"',  '"+e.getNombreImpuesto()+"',  '"+e.getPorcentajeImpuesto()+"',  '"+e.getMonedas().getCodMoneda()+"',  '"+e.getLogotipoEmpresa()+"'); ";
            
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
    public int codCiudad(){
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        
    }
    public  int editarEmpresa(Empresas e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons =   "  UPDATE public.empresa SET " +
                            "  nombre_empresa = '"+e.getNombreEmpresa()+"'," +
                            "  ruc = '"+e.getRuc()+"'," +
                            "  cod_estado_registro = '"+e.getEstadosRegistro().getCodEstado()+"'," +
                            "  direccion = '"+e.getDireccion()+"'," +
                            "  telefono = '"+e.getTelefono()+"'," +
                            "  cod_ciudad = '"+e.getCiudad().getCodCiudad()+"'," +
                            "  nombre_impuesto = '"+e.getNombreImpuesto()+"'," +
                            "  porcentaje_impuesto = '"+e.getPorcentajeImpuesto()+"'," +
                            "  cod_moneda = '"+e.getMonedas().getCodMoneda()+"'," +
                            "  logotipo_empresa = '"+e.getLogotipoEmpresa()+"'" +
                            "  WHERE " +
                            "  cod_empresa = '"+e.getCodEmpresa()+"';";
            
                    
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
    public  int eliminarEmpresa(Empresas e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons = " delete from public.empresa where cod_empresa = '"+e.getCodEmpresa()+"' ";
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
    public  List<SelectItem> cargarEmpresaItem() throws Exception {
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
    
}
