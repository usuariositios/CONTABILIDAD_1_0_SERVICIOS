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
import servicio.model.Gestion;
import servicio.model.SelectItem;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class GestionResource {
    Connection con;
    public GestionResource(){
    }
    public GestionResource(Connection con){
        this.con = con;
    }

    public List<Gestion> cargarGestiones() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        List<Gestion> gestionList =new ArrayList<Gestion>();
        try {
            

            
            String query = " select gs.cod_gestion,gs.nombre_gestion,gs.fecha_inicio,gs.fecha_final,e.cod_estado_registro,e.nombre_estado_registro "
                         + " from public.gestiones gs "
                         + " inner join public.estados_registro e on e.cod_estado_registro = gs.cod_estado_registro order by gs.cod_gestion asc";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            gestionList.clear();
            while (rs.next())
            {
                Gestion gest = new Gestion();
                gest.setCodGestion(rs.getInt("cod_gestion"));
                gest.setNombreGestion(rs.getString("nombre_gestion"));
                gest.setFechaInicio(sdf.format(rs.getTimestamp("fecha_inicio")));
                gest.setFechaFinal(sdf.format(rs.getTimestamp("fecha_final")));
                gest.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                gest.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                gestionList.add(gest);
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
        return gestionList;
    }
    public Gestion buscarGestion(Gestion g) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        Gestion gest =new Gestion();
        try {
            

            
            String query = " select gs.cod_gestion,gs.nombre_gestion,gs.fecha_inicio,gs.fecha_final,e.cod_estado_registro,e.nombre_estado_registro "
                         + " from public.gestiones gs "
                         + " inner join public.estados_registro e on e.cod_estado_registro = gs.cod_estado_registro where 0=0 ";
            if(g.getCodGestion()!=0){
                query +=" and gs.cod_gestion = '"+g.getCodGestion()+"' ";
            }
                    
            query+=" order by gs.cod_gestion asc";
                         
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            
            while (rs.next())
            {                
                gest.setCodGestion(rs.getInt("cod_gestion"));
                gest.setNombreGestion(rs.getString("nombre_gestion"));
                gest.setFechaInicio(sdf.format(rs.getTimestamp("fecha_inicio")));
                gest.setFechaFinal(sdf.format(rs.getTimestamp("fecha_final")));
                gest.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                gest.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                
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
        return gest;
    }
    public Gestion gestionActiva() throws Exception {
        Gestion gest = new Gestion();
        List<Gestion> listGestion =new ArrayList<Gestion>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            

            
            String query = " select cod_gestion,nombre_gestion,fecha_inicio,fecha_final from gestiones where cod_estado_registro = 1 ";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listGestion.clear();
            
            if(rs.next())
            {
                gest.setCodGestion(rs.getInt("cod_gestion"));
                gest.setNombreGestion(rs.getString("nombre_gestion"));
                gest.setFechaInicio(sdf.format(rs.getTimestamp("fecha_inicio")));
                gest.setFechaFinal(sdf.format(rs.getTimestamp("fecha_final")));
                
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
        return gest;
    }
    
    public int guardarGestion(Gestion gs) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Statement statement = this.con.createStatement();
            String cons = " insert into gestiones(cod_gestion,nombre_gestion,fecha_inicio,fecha_final,cod_estado_registro)values((select COALESCE(max(cod_gestion),0)+1 from gestiones),'"+gs.getNombreGestion()+"','"+gs.getFechaInicio()+"','"+gs.getFechaFinal()+"',1) ";
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
    public int editarGestion(Gestion e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Statement statement = this.con.createStatement();
            String cons = " update gestiones set nombre_gestion = '"+e.getNombreGestion()+"',fecha_inicio='"+e.getFechaInicio()+"',fecha_final= '"+e.getFechaFinal()+"',cod_estado_registro = '"+e.getEstadosRegistro().getCodEstado()+"'"
                    + " where cod_gestion = '"+e.getCodGestion()+"' ";
            
                    
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
    public int eliminarGestion(Gestion e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Statement statement = this.con.createStatement();
            String cons = " delete from gestiones where cod_gestion = '"+e.getCodGestion()+"' ";
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
    public List<SelectItem> cargarGestionItem()  throws Exception{
        List<SelectItem> gestionesList =new ArrayList<SelectItem>();
        try {
            
            
            
            String query = "SELECT cod_gestion, nombre_gestion from public.gestiones  "; //where cod_estado_registro = 1
            
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            gestionesList.clear();
            while (rs.next())
            {   
                gestionesList.add(new SelectItem(rs.getInt("cod_gestion"), rs.getString("nombre_gestion")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return gestionesList;
    }
    
}
