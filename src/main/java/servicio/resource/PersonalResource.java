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


import servicio.model.Personal;
import servicio.model.SelectItem;
import servicio.util.Utiles;



/**
 *
 * @author henry
 */
public class PersonalResource {
    Connection con;
    public PersonalResource(){
    }
    public PersonalResource(Connection con){
        this.con = con;
    }
    public  List<SelectItem> cargarPersonalItem() throws Exception {
        List<SelectItem> personalList =new ArrayList<SelectItem>();
        try {
            
            
            
            String query = "SELECT cod_personal,ap_paterno_personal ||' '||ap_materno_personal||' '||nombres_personal nombre_personal from personal where cod_estado_registro = 1"
                    + " order by nombre_personal  ";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            personalList.clear();
            while (rs.next())
            {
                personalList.add(new SelectItem(rs.getInt("cod_personal"), rs.getString("nombre_personal")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return personalList;
    }
    public  List<Personal> cargarPersonal(Personal per) throws Exception {
        List<Personal> personalList =new ArrayList<Personal>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        try {
            
            

            
            String query =  "select p.cod_personal,p.ap_paterno_personal,p.ap_materno_personal,p.nombres_personal,p.nro_carnet,e.cod_estado_civil,e.nombre_estado_civil, " +
                            "a.cod_area_empresa,a.nombre_area_empresa,cg.cod_cargo,cg.nombre_cargo,p.direccion_personal,p.fecha_nac_personal,pa.cod_pais,pa.nombre_pais, " +
                            "c.cod_ciudad,c.nombre_ciudad,p.telf_personal,p.celular_personal,g.cod_genero,g.nombre_genero,p.email_personal,et.cod_estado_registro,et.nombre_estado_registro,p.personal_externo " +
                            "from personal p " +
                            "inner join estado_civil e on e.cod_estado_civil = p.cod_estado_civil " +
                            "inner join areas_empresa a on a.cod_area_empresa = p.cod_area_empresa " +
                            "inner join cargo cg on cg.cod_cargo = p.cod_cargo " +
                            "inner join genero g on g.cod_genero = p.cod_genero " +
                            "inner join estados_registro et on et.cod_estado_registro = p.cod_estado_registro "+
                            "left outer join pais pa on pa.cod_pais = p.cod_pais " +
                            "left outer join ciudad c on c.cod_ciudad = p.cod_ciudad"
                          + " where e.cod_estado_civil = p.cod_estado_civil ";
            if(per.getAreasEmpresa().getCodAreaEmpresa()!=0){query+=" AND p.cod_area_empresa = '"+per.getAreasEmpresa().getCodAreaEmpresa()+"' ";}
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            personalList.clear();
            while (rs.next())
            {
                Personal p = new Personal();
                p.setCodPersonal(rs.getInt("cod_personal"));
                p.setApPaternoPersonal(rs.getString("ap_paterno_personal"));
                p.setApMaternoPersonal(rs.getString("ap_materno_personal"));
                p.setNombrePersonal(rs.getString("nombres_personal"));
                p.setNroCarnet(rs.getString("nro_carnet"));
                p.getEstadoCivil().setCodEstadoCivil(rs.getInt("cod_estado_civil"));
                p.getEstadoCivil().setNombreEstadoCivil(rs.getString("nombre_estado_civil"));
                p.getAreasEmpresa().setCodAreaEmpresa(rs.getInt("cod_area_empresa"));
                p.getAreasEmpresa().setNombreAreaEmpresa(rs.getString("nombre_area_empresa"));
                p.getCargo().setCodCargo(rs.getInt("cod_cargo"));
                p.getCargo().setNombreCargo(rs.getString("nombre_cargo"));
                p.setDireccionPersonal(rs.getString("direccion_personal"));
                p.setFechaNacPersonal(sdf.format(rs.getDate("fecha_nac_personal")));
                p.getPais().setCodPais(rs.getInt("cod_pais"));
                p.getPais().setNombrePais(rs.getString("nombre_pais"));
                p.getCiudad().setCodCiudad(rs.getInt("cod_ciudad"));
                p.getCiudad().setNombreCiudad(rs.getString("nombre_ciudad"));
                p.setTelefPersonal(rs.getString(("telf_personal")));
                p.setCelularPersonal(rs.getString("celular_personal"));
                p.getGenero().setCodGenero(rs.getInt("cod_genero"));
                p.getGenero().setNombreGenero(rs.getString("nombre_genero"));
                p.setEmailPersonal(rs.getString("email_personal"));
                p.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                p.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                p.setPersonalExterno(rs.getInt("personal_externo")==1?true:false);
                
                personalList.add(p);
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
    public  int guardarPersonal(Personal p) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement st = this.con.createStatement();
            
            String cons = " INSERT INTO personal( " +
                            "            cod_personal, ap_paterno_personal, ap_materno_personal, nombres_personal,  " +
                            "            nro_carnet, cod_estado_civil, cod_area_empresa, cod_cargo, direccion_personal,  " +
                            "            fecha_nac_personal, cod_pais, telf_personal, celular_personal,  " +
                            "            cod_genero, email_personal, cod_ciudad, cod_estado_registro,personal_externo) " +
                            "    VALUES ( '"+p.getCodPersonal()+"', '"+p.getApPaternoPersonal()+"', '"+p.getApMaternoPersonal()+"', '"+p.getNombrePersonal()+"',  " +
                            "            '"+p.getNroCarnet()+"', '"+p.getEstadoCivil().getCodEstadoCivil()+"', '"+p.getAreasEmpresa().getCodAreaEmpresa()+"', '"+p.getCargo().getCodCargo()+"', '"+p.getDireccionPersonal()+"',  " +
                            "            timestamp '"+p.getFechaNacPersonal()+"', '"+p.getPais().getCodPais()+"', '"+p.getTelefPersonal()+"', '"+p.getCelularPersonal()+"',  " +
                            "            '"+p.getGenero().getCodGenero()+"', '"+p.getEmailPersonal()+"', '"+p.getCiudad().getCodCiudad()+"', '"+p.getEstadosRegistro().getCodEstado()+"','"+(p.isPersonalExterno()==true?1:0)+"'); ";
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
    public  int codigoPersonal() throws Exception{
        int codPersonal=0;
        try {
            
            Statement statement = this.con.createStatement();
            String cons = "select COALESCE(max(p.cod_personal),0)+1 cod_personal from personal p";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                codPersonal = rs.getInt("cod_personal");
            }
            
            statement.close();
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return codPersonal;
    }
    public  int editarPersonal(Personal p) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons = " UPDATE personal " +
                            "   SET  ap_paterno_personal ='"+p.getApPaternoPersonal()+"', ap_materno_personal ='"+p.getApMaternoPersonal()+"',  " +
                            "       nombres_personal ='"+p.getNombrePersonal()+"', nro_carnet ='"+p.getNroCarnet()+"', cod_estado_civil ='"+p.getEstadoCivil().getCodEstadoCivil()+"', cod_area_empresa ='"+p.getAreasEmpresa().getCodAreaEmpresa()+"',  " +
                            "       cod_cargo ='"+p.getCargo().getCodCargo()+"', direccion_personal ='"+p.getDireccionPersonal()+"', fecha_nac_personal =timestamp '"+p.getFechaNacPersonal()+"', cod_pais ='"+p.getPais().getCodPais()+"',  " +
                            "       telf_personal ='"+p.getTelefPersonal()+"', celular_personal ='"+p.getCelularPersonal()+"', cod_genero ='"+p.getGenero().getCodGenero()+"', email_personal ='"+p.getEmailPersonal()+"',  " +
                            "       cod_ciudad ='"+p.getCiudad().getCodCiudad()+"', cod_estado_registro ='"+p.getEstadosRegistro().getCodEstado()+"',personal_externo='"+(p.isPersonalExterno()==true?1:0)+"' " +
                            " WHERE cod_personal ='"+p.getCodPersonal()+"'  ";
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
    public  int eliminarPersonal(Personal p) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons = " delete from personal where cod_personal= '"+p.getCodPersonal()+"' ";
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
    
    public  List<SelectItem> cargarPersonalItem(Personal p) throws Exception {
        List<SelectItem> personalList =new ArrayList<SelectItem>();
        try {
            
            
            
            String query = "SELECT cod_personal,ap_paterno_personal ||' '||ap_materno_personal||' '||nombres_personal nombre_personal from personal where cod_estado_registro = 1 and personal_externo = '"+(p.isPersonalExterno()==true?1:0)+"'"
                    + (p.getAreasEmpresa().getCodAreaEmpresa()!=0?" and cod_area_empresa = '"+p.getAreasEmpresa().getCodAreaEmpresa()+"'":"")
                    + (!p.getCodigoPersonal().equals("0")?" and cod_personal in ( "+p.getCodigoPersonal()+")":"")
                    + " order by nombre_personal  ";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            personalList.clear();
            while (rs.next())
            {
                personalList.add(new SelectItem(rs.getInt("cod_personal"), rs.getString("nombre_personal")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return personalList;
    }
    
    
}
