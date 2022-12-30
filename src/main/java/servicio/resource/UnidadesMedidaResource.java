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
import servicio.model.UnidadesMedida;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class UnidadesMedidaResource {
    Connection con;
    public UnidadesMedidaResource(){
    }
    public UnidadesMedidaResource(Connection con){
        this.con = con;
    }

    public List<SelectItem> cargarUnidadesMedidaItem() throws Exception {
        List<SelectItem> tiposIngresoAlmacenList =new ArrayList<SelectItem>();
        try {
            
            
            
            String query = "SELECT cod_unidad_medida,nombre_unidad_medida from public.unidades_medida ";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            tiposIngresoAlmacenList.clear();
            while (rs.next())
            {
                tiposIngresoAlmacenList.add(new SelectItem(rs.getInt("cod_unidad_medida"), rs.getString("nombre_unidad_medida")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return tiposIngresoAlmacenList;
    }
    public List<UnidadesMedida> cargarUnidadesMedida(UnidadesMedida u) throws Exception {
        List<UnidadesMedida> listUnidadesMedida =new ArrayList<UnidadesMedida>();
        try {
            
            

            
            String query =  " SELECT  " +
                            " cod_unidad_medida,nombre_unidad_medida,abreviatura " +
                            " FROM  " +
                            " public.unidades_medida ; ";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listUnidadesMedida.clear();
            while (rs.next())
            {
                UnidadesMedida um =  new UnidadesMedida();
                um.setCodUnidadMedida(rs.getInt("cod_unidad_medida"));
                um.setNombreUnidadMedida(rs.getString("nombre_unidad_medida"));
                um.setAbreviatura(rs.getString("abreviatura"));
                listUnidadesMedida.add(um);
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
        return listUnidadesMedida;
    }
    public int guardarUnidadesMedida(UnidadesMedida e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            
            Statement statement = this.con.createStatement();
            String cons = " INSERT INTO public.unidades_medida " +
                   "(cod_unidad_medida,  nombre_unidad_medida,  abreviatura)  " +
                   "VALUES (  (select nextval('almacenes.\"seqUnidadesMedida\"')),  '"+e.getNombreUnidadMedida()+"',  '"+e.getAbreviatura()+"'); ";
            
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
    public int codTipoComposicionProducto(){
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        
    }
    public int editarUnidadesMedida(UnidadesMedida e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons =   " UPDATE " +
                            " public.unidades_medida " +
                            " SET   " +
                            " nombre_unidad_medida = '"+e.getNombreUnidadMedida()+"',  " +
                            " abreviatura = '"+e.getAbreviatura()+"'  " +
                            " WHERE   " +
                            " cod_unidad_medida = '"+e.getCodUnidadMedida()+"'  ; ";
            
                    
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
    public int eliminarUnidadesMedida(UnidadesMedida e) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons = " delete from almacenes.unidades_medida where cod_unidad_medida = '"+e.getCodUnidadMedida()+"' ";
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
