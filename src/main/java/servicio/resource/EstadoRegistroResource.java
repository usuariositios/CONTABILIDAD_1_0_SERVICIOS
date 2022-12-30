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
import javax.naming.InitialContext;
import javax.sql.DataSource;
import servicio.model.EstadosRegistro;
import servicio.model.Pais;
import servicio.model.SelectItem;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class EstadoRegistroResource {
    Connection con;
    public EstadoRegistroResource(){
    }
    public EstadoRegistroResource(Connection con){
        this.con = con;
    }

    public  List<EstadosRegistro> cargarEstadosRegistro() throws Exception {
        List<EstadosRegistro> listEstadosRegistro =new ArrayList<EstadosRegistro>();
        try {
            

            
            String query = " SELECT e.cod_estado_registro, e.nombre_estado_registro " +
                           " FROM public.estados_registro e; ";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listEstadosRegistro.clear();
            while (rs.next())
            {
                EstadosRegistro e = new EstadosRegistro();
                e.setCodEstado(rs.getInt("cod_estado_registro"));
                e.setNombreEstado(rs.getString("nombre_estado_registro"));                
                listEstadosRegistro.add(e);
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
        return listEstadosRegistro;
    }
    public  List<SelectItem> cargarEstadosRegistroItem() throws Exception {
        List<SelectItem> estList =new ArrayList<SelectItem>();
        try {
            
            
            
            String query = "SELECT e.cod_estado_registro, e.nombre_estado_registro " +
                           " FROM public.estados_registro e; ";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            estList.clear();
            while (rs.next())
            {
                estList.add(new SelectItem(rs.getInt("cod_estado_registro"), rs.getString("nombre_estado_registro")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        
        return estList;
    }
   
    public  int guardarEstadosRegistro(EstadosRegistro gs) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Statement statement = this.con.createStatement();
            String cons = " ";
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
    public  int codCiudad(){
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        
    }
    public  int editarEstadosRegistro(EstadosRegistro e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Statement statement = this.con.createStatement();
            String cons = "  ";
            
                    
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
    public  int eliminarEstadosRegistro(EstadosRegistro e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Statement statement = this.con.createStatement();
            String cons = "  ";
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
