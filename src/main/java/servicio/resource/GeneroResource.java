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

import servicio.model.Genero;
import servicio.model.SelectItem;
import servicio.model.bean;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class GeneroResource{
    Connection con;
    public GeneroResource(){
    }
    public GeneroResource(Connection con){
        this.con = con;
    }
    public  List<SelectItem> cargarGeneroItem() throws Exception{
        List<SelectItem> generoList =new ArrayList<SelectItem>();
        try {
            
            
            
            String query = "select cod_genero,nombre_genero from genero ";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            generoList.clear();
            while (rs.next())
            {
                generoList.add(new SelectItem(rs.getInt("cod_genero"), rs.getString("nombre_genero")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return generoList;
    }
    
    
    
    public int codGenero(){
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        
    }
    
    public  int eliminarGenero(Genero e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons = " delete from genero where cod_genero = '"+e.getCodGenero()+"' ";
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
