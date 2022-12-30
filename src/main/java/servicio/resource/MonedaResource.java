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
import servicio.model.Monedas;

import servicio.model.SelectItem;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class MonedaResource {
    Connection con;
    public MonedaResource(){
    }
    public MonedaResource(Connection con){
        this.con = con;
    }

    public  List<Monedas> cargarMonedas(Monedas m) throws Exception {
        List<Monedas> listMonedas =new ArrayList<Monedas>();
        try {
            

            
            String query = " SELECT m.cod_moneda, m.nombre_moneda,e.cod_estado_registro, e.nombre_estado_registro "+
                           " FROM " +
                           " public.monedas m inner join public.estados_registro e on e.cod_estado_registro = m.cod_estado_registro  " +
                           " where 0=0 ";
            if(m.getNombreMoneda().equals("")){query+=" AND nombre_moneda like '%"+m.getNombreMoneda()+"%' ";}
            
            System.out.println("consulta " +query);
            
            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listMonedas.clear();
            while (rs.next())
            {
                Monedas mnd = new Monedas();
                mnd.setCodMoneda(rs.getInt("cod_moneda"));
                mnd.setNombreMoneda(rs.getString("nombre_moneda"));
                mnd.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                mnd.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                
                listMonedas.add(mnd);
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
        return listMonedas;
    }
    public  List<SelectItem> cargarMonedasItem() throws Exception {
        List<SelectItem> estList =new ArrayList<SelectItem>();
        try {
            
            
            
            String query = "SELECT cod_moneda, nombre_moneda "+
                           " FROM " +
                           " public.monedas ; ";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            estList.clear();
            while (rs.next())
            {
                estList.add(new SelectItem(rs.getInt("cod_moneda"), rs.getString("nombre_moneda")));
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
    public  int guardarMoneda(Monedas m) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Statement statement = this.con.createStatement();
            String cons = " INSERT INTO public.monedas( cod_moneda, nombre_moneda,cod_estado_registro)" +
                          "  VALUES ((select nextval('public.\"seqMoneda\"')),  '"+m.getNombreMoneda()+"','"+m.getEstadosRegistro().getCodEstado()+"'); ";
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
    public  int editarMonedas(Monedas m) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Statement statement = this.con.createStatement();
            String cons =   " UPDATE  " +
                            "  public.monedas  " +
                            "  SET  " +                            
                            "  nombre_moneda = '"+m.getNombreMoneda()+"',"+
                            "  cod_estado_registro = '"+m.getEstadosRegistro().getCodEstado()+"' " +
                            "  WHERE  " +
                            "  cod_moneda = '"+m.getCodMoneda()+"' ";
            
                    
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
    public  int eliminarMonedas(Monedas e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Statement statement = this.con.createStatement();
            String cons = " delete from public.monedas where cod_moneda = '"+e.getCodMoneda()+"' ";
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