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


import servicio.model.Clientes;
import servicio.model.SelectItem;
import servicio.util.Utiles;



/**
 *
 * @author henry
 */
public class ClienteResource {    
    Connection con;
    public ClienteResource(){
    }
    public ClienteResource(Connection con){
        this.con = con;
    }

    public  List<Clientes> cargarCliente(Clientes c) throws Exception {
        List<Clientes> personalList =new ArrayList<Clientes>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        

        try {
            
            

            
            String query =  " SELECT c.cod_cliente,  c.nombre_cliente,  c.nit_cliente,  c.direccion_cliente,  c.nro_direccion_cliente,  c.telf_cliente,  c.cel_cliente, " +
                            " c.fax_cliente,  c.email_cliente,  c.nombre_propietario,  c.nombre_representante,  cd.cod_ciudad,cd.nombre_ciudad,  e.cod_estado_registro,e.nombre_estado_registro " +
                            " FROM  " +
                            " public.clientes c " +
                            " left outer join public.ciudad cd on cd.cod_ciudad = c.cod_ciudad " +
                            " inner join public.estados_registro e on e.cod_estado_registro = c.cod_estado_registro where 0=0 ";
            if(!c.getNombreCliente().equals("")){query+=" AND c.nombre_cliente LIKE '%"+c.getNombreCliente()+"%' ";}
            if(!c.getDireccionCliente().equals("")){query+=" AND c.direccion_cliente like '%"+c.getDireccionCliente()+"%' ";}
            if(c.getCiudad().getCodCiudad()!=0){query+=" AND c.cod_ciudad = '"+c.getCiudad().getCodCiudad()+"' ";}
            if(!c.getTelfCliente().equals("")){query+=" AND c.telf_cliente = '"+c.getTelfCliente()+"' ";}
            if(!c.getEmailCliente().equals("")){query+=" AND c.email_cliente like '%"+c.getEmailCliente()+"%' ";}
            if(!c.getNitCliente().equals("")){query+=" AND c.nit_cliente = '"+c.getNitCliente()+"' ";}
            query += " ORDER BY  c.nombre_cliente asc";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            personalList.clear();
            while (rs.next())
            {
                Clientes cl = new Clientes();
                cl.setCodCliente(rs.getInt("cod_cliente"));                
                cl.setNombreCliente(rs.getString("nombre_cliente"));
                cl.setNitCliente(rs.getString("nit_cliente"));
                cl.setDireccionCliente(rs.getString("direccion_cliente"));
                cl.setNroDireccionCliente(rs.getString("nro_direccion_cliente"));
                cl.setTelfCliente(rs.getString("telf_cliente"));
                cl.setCelCliente(rs.getString("cel_cliente"));
                cl.setFaxCliente(rs.getString("fax_cliente"));
                cl.setEmailCliente(rs.getString("email_cliente"));
                cl.setNombrePropietario(rs.getString("nombre_propietario"));
                cl.setNombreRepresentante(rs.getString("nombre_representante"));
                cl.getCiudad().setCodCiudad(rs.getInt("cod_ciudad"));
                cl.getCiudad().setNombreCiudad(rs.getString("nombre_ciudad"));                
                cl.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                cl.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));                
                
                personalList.add(cl);
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
        return personalList;
    }
    public  int guardarCliente(Clientes c) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        
        try {
            
            
            Statement st = this.con.createStatement();
            
            String cons = " INSERT INTO  " +
                            "  public.clientes " +
                            "( cod_cliente,  nombre_cliente,  nit_cliente,  direccion_cliente,  nro_direccion_cliente,  telf_cliente,  cel_cliente,  fax_cliente, " +
                            "  email_cliente,  nombre_propietario,  nombre_representante,  cod_ciudad,  cod_estado_registro) " +
                            " VALUES (  '"+this.codigoCliente()+"',  '"+c.getNombreCliente()+"',  '"+c.getNitCliente()+"',  '"+c.getDireccionCliente()+"',  '"+c.getNroDireccionCliente()+"',  '"+c.getTelfCliente()+"', " +
                            "  '"+c.getCelCliente()+"',  '"+c.getFaxCliente()+"',  '"+c.getEmailCliente()+"',  '"+c.getNombrePropietario()+"',  '"+c.getNombreRepresentante()+"',  '"+c.getCiudad().getCodCiudad()+"',  '"+c.getEstadosRegistro().getCodEstado()+"'); ";
            System.out.println("cons " + cons);
            guardado = st.executeUpdate(cons);
            
            st.close();
            //con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        
        return guardado;
    }
    public  int codigoCliente() throws Exception{
        int codCliente=0;
        
        try {
            
            Statement statement = this.con.createStatement();
            String cons = "select COALESCE(max(p.cod_cliente),0)+1 cod_cliente from public.clientes p";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                codCliente = rs.getInt("cod_cliente");
            }
            
            statement.close();
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        
        return codCliente;
    }
    public  int editarCliente(Clientes c) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons = " UPDATE  " +
                            "  public.clientes  " +
                            "  SET  " +
                            "  nombre_cliente = '"+c.getNombreCliente()+"', " +
                            "  nit_cliente = '"+c.getNitCliente()+"', " +
                            "  direccion_cliente = '"+c.getDireccionCliente()+"', " +
                            "  nro_direccion_cliente = '"+c.getNroDireccionCliente()+"', " +
                            "  telf_cliente = '"+c.getTelfCliente()+"', " +
                            "  cel_cliente = '"+c.getCelCliente()+"', " +
                            "  fax_cliente = '"+c.getFaxCliente()+"', " +
                            "  email_cliente = '"+c.getEmailCliente()+"', " +
                            "  nombre_propietario = '"+c.getNombrePropietario()+"', " +
                            "  nombre_representante = '"+c.getNombreRepresentante()+"', " +
                            "  cod_ciudad = '"+c.getCiudad().getCodCiudad()+"', " +
                            "  cod_estado_registro = '"+c.getEstadosRegistro().getCodEstado()+"' " +
                            "WHERE  " +
                            "  cod_cliente = '"+c.getCodCliente()+"'; ";
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        
        return guardado;
    }
    public int eliminarCliente(Clientes p) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        
        try {
            Statement statement = this.con.createStatement();
            String cons = " delete from public.clientes where cod_cliente= '"+p.getCodCliente()+"' ";
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            statement.close();
            //con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        
        return guardado;
    }
    
    public  List<SelectItem> cargarClienteItem(Clientes c) throws Exception {
        List<SelectItem> clienteList =new ArrayList<SelectItem>();
        
        try {
            
            
            
            String query = "SELECT cod_cliente, nombre_cliente "                    
                    + " from public.clientes order by nombre_cliente  ";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            clienteList.clear();
            while (rs.next())
            {
                clienteList.add(new SelectItem(rs.getInt("cod_cliente"), rs.getString("nombre_cliente")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return clienteList;
    }
    
    
}
