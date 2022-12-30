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

import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import servicio.model.PlanDeCuentas;
import servicio.model.SelectItem;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class PlanDeCuentasResource extends BeanResource {
    Connection con;
    public PlanDeCuentasResource(){
    }
    public PlanDeCuentasResource(Connection con){
        this.con = con;
    }
    
    public  List<PlanDeCuentas> cargarPlanDeCuentas(PlanDeCuentas p) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //yyyy/MM/dd HH:mm:ss
        List<PlanDeCuentas> ingresosAlmacenList =new ArrayList<PlanDeCuentas>();
        try {
            
            

            
            String consulta =   " SELECT p.cod_plan_cuenta,  p.cod_cuenta,  p.nombre_cuenta,  m.cod_moneda,m.nombre_moneda,e.cod_estado_registro,e.nombre_estado_registro,  p.estado_cuentas, " +
                                "  p.ajustable,  p.movimiento,  p.cod_plan_cuenta_padre,  p.nivel,  p.descripcion, g.cod_gestion,g.nombre_gestion,p.codigo_cuenta_sin,p.nombre_cuenta_sin  " +
                                " FROM " +
                                "  cont.plan_de_cuentas p " +
                                "  left outer join public.monedas m on m.cod_moneda = p.cod_moneda " +
                                "  left outer join public.estados_registro e on e.cod_estado_registro = p.cod_estado_registro " +
                                "  left outer join public.gestiones g on g.cod_gestion = p.cod_gestion " +
                                " where 0=0 and p.cod_gestion = '"+p.getGestion().getCodGestion()+"'  ";                    
                    
                    if(!p.getCodCuenta().equals("")){consulta+=" AND p.cod_cuenta like '"+p.getCodCuenta()+"%' ";}
                    if(!p.getNombreCuenta().equals("")){consulta+=" AND UPPER(p.nombre_cuenta) like UPPER('%"+p.getNombreCuenta()+"%') ";}                    
                    if(p.getMoneda().getCodMoneda()!=0){consulta+=" AND p.cod_moneda = '"+p.getMoneda().getCodMoneda()+"'  ";}
                    if(p.getEstadosRegistro().getCodEstado()!=0){consulta+=" AND e.cod_estado_registro = '"+p.getEstadosRegistro().getCodEstado()+"' ";}
                    if(p.getMovimiento()!=0){consulta+=" AND p.movimiento = '"+p.getMovimiento()+"' ";}
                    if(p.getEstadoCuenta()!=0){consulta+=" AND p.estado_cuentas = '"+p.getEstadoCuenta()+"' ";}
                    
                    consulta += " ORDER BY p.cod_cuenta ASC;"; // LIMIT 10 OFFSET "+p.getFilaInicial()+"  
            
            
            System.out.println("consulta " +consulta);

            PreparedStatement statement = this.con.prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            ingresosAlmacenList.clear();
            while (rs.next())
            {
                PlanDeCuentas np = new PlanDeCuentas();
                np.setCodPlanCuenta(rs.getInt("cod_plan_cuenta"));
                np.setCodCuenta(rs.getString("cod_cuenta"));
                np.setNombreCuenta(rs.getString("nombre_cuenta"));
                np.getMoneda().setCodMoneda(rs.getInt("cod_moneda"));
                np.getMoneda().setNombreMoneda(rs.getString("nombre_moneda"));
                np.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                np.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                np.setEstadoCuenta(rs.getInt("estado_cuentas"));
                np.setAjustable(rs.getInt("ajustable"));
                np.setMovimiento(rs.getInt("movimiento"));
                np.setCodPlanCuentaPadre(rs.getInt("cod_plan_cuenta_padre"));
                np.setNivel(rs.getInt("nivel"));
                np.setDescripcion(rs.getString("descripcion"));
                np.getGestion().setCodGestion(rs.getInt("cod_gestion"));
                np.getGestion().setNombreGestion(rs.getString("nombre_gestion"));
                np.setCodigoCuentaSIN(rs.getString("codigo_cuenta_sin"));
                np.setNombreCuentaSIN(rs.getString("nombre_cuenta_sin"));
                
                ingresosAlmacenList.add(np);
                
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
        return ingresosAlmacenList;
    }
    public  List<PlanDeCuentas> cargarPlanDeCuentasCentroCostos(PlanDeCuentas p) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //yyyy/MM/dd HH:mm:ss
        List<PlanDeCuentas> ingresosAlmacenList =new ArrayList<PlanDeCuentas>();
        try {
            
            

            
            String consulta =   " select p.COD_PLAN_CUENTA,p.COD_CUENTA,p.NOMBRE_CUENTA,ce.COD_CENTRO_COSTOS, ce.NOMBRE_CENTRO_COSTOS || '(' ||t.NOMBRE_TIPO_CENTRO_COSTOS||')' NOMBRE_CENTRO_COSTOS,p.ESTADO_CUENTAS,p.codigo_cuenta_sin,p.nombre_cuenta_sin " +
                                " from cont.PLAN_DE_CUENTAS p " +
                                " inner join cont.PLAN_DE_CUENTAS_POR_CENTRO_DE_COSTOS pl on pl.cod_plan_cuenta = p.cod_plan_cuenta " +
                                " inner join cont.CENTRO_DE_COSTOS ce on ce.cod_centro_costos = pl.cod_centro_costos " +
                                " inner join cont.TIPOS_CENTRO_DE_COSTO t on t.cod_tipo_centro_costos = ce.cod_tipo_centro_costos " +
                                " where 0=0 and p.cod_estado_registro = 1 " +
                                " and p.movimiento = 1 " +                                
                                " and p.cod_gestion = '"+p.getGestion().getCodGestion()+"'  ";
                    if(p.getCentroCostos().getCodCentroCostos()!=0){consulta+=" and ce.cod_centro_costos = '"+p.getCentroCostos().getCodCentroCostos()+"' ";}                    
                    consulta += " ORDER BY p.cod_cuenta ASC;"; // LIMIT 10 OFFSET "+p.getFilaInicial()+"
                    
                    
            System.out.println("consulta " +consulta);

            PreparedStatement statement = this.con.prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            ingresosAlmacenList.clear();
            while (rs.next())
            {
                PlanDeCuentas np = new PlanDeCuentas();
                np.setCodPlanCuenta(rs.getInt("cod_plan_cuenta"));
                np.setCodCuenta(rs.getString("cod_cuenta"));
                np.setNombreCuenta(rs.getString("nombre_cuenta"));
                np.getCentroCostos().setCodCentroCostos(rs.getInt("COD_CENTRO_COSTOS"));
                np.getCentroCostos().setNombreCentroCostos(rs.getString("NOMBRE_CENTRO_COSTOS"));                
                np.setEstadoCuenta(rs.getInt("ESTADO_CUENTAS"));
                np.setCodigoCuentaSIN(rs.getString("codigo_cuenta_sin"));
                np.setNombreCuentaSIN(rs.getString("nombre_cuenta_sin"));
                ingresosAlmacenList.add(np);
                
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
        return ingresosAlmacenList;
    }
    public  int codigoPlanDeCuentas() throws Exception{
        int codPlanCuenta=0;
        try {
            
            Statement statement = this.con.createStatement();
            String cons = "select nextval('cont.\"seqPlanDeCuentas\"') cod_plan_cuenta";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                codPlanCuenta = rs.getInt("cod_plan_cuenta");
            }
            
            statement.close();
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return codPlanCuenta;
    }
    public  int guardarPlanDeCuentas(PlanDeCuentas p) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            p.setCodPlanCuenta(this.codigoPlanDeCuentas());
            
            Statement statement = this.con.createStatement();
            String cons = " INSERT INTO  " +
                            "  cont.plan_de_cuentas " +
                            "( cod_plan_cuenta,  cod_cuenta,  nombre_cuenta,  cod_moneda,  cod_estado_registro,  estado_cuentas,  ajustable,  movimiento, " +
                            "  costos,  cod_plan_cuenta_padre,  nivel,  estado_cronos,  cod_division,  distribucion_gastos,  cod_estado_flujo,  cod_flujo, " +
                            "  descripcion,  estado_promocion,  cod_estadoclientemedico,cod_gestion,codigo_cuenta_sin,nombre_cuenta_sin) " +
                            "VALUES ( " +
                            "  '"+p.getCodPlanCuenta()+"',  '"+p.getCodCuenta()+"',  '"+p.getNombreCuenta()+"',  '"+p.getMoneda().getCodMoneda()+"',  '"+p.getEstadosRegistro().getCodEstado()+"',  '"+p.getEstadoCuenta()+"',  '"+p.getAjustable()+"',  '"+p.getMovimiento()+"', " +
                            "  null,  '"+p.getCodPlanCuentaPadre()+"',  '"+p.getNivel()+"',  null,  null,  null,  null,  null, " +
                            "  '"+p.getDescripcion()+"',  null,  null,'"+p.getGestion().getCodGestion()+"','"+p.getCodigoCuentaSIN()+"','"+p.getNombreCuentaSIN()+"') ; ";
            
            
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
    public  int editarPlanDeCuentas(PlanDeCuentas p) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons =   "  UPDATE " +
                            "  cont.plan_de_cuentas " +
                            "  SET " +
                            "  cod_cuenta = '"+p.getCodCuenta()+"', " +
                            "  nombre_cuenta = '"+p.getNombreCuenta()+"', " +
                            "  cod_moneda = '"+p.getMoneda().getCodMoneda()+"', " +
                            "  cod_estado_registro = '"+p.getEstadosRegistro().getCodEstado()+"', " +
                            "  estado_cuentas = '"+p.getEstadoCuenta()+"', " +
                            "  ajustable = '"+p.getAjustable()+"', " +
                            "  movimiento = '"+p.getMovimiento()+"', " +
                            "  costos = null, " +
                            "  cod_plan_cuenta_padre = '"+p.getCodPlanCuentaPadre()+"', " +
                            "  nivel = '"+p.getNivel()+"', " +
                            "  estado_cronos = null, " +
                            "  cod_division = null, " +
                            "  distribucion_gastos = null, " +
                            "  cod_estado_flujo = null, " +
                            "  cod_flujo = null, " +
                            "  descripcion = '"+p.getDescripcion()+"', " +
                            "  estado_promocion = null, " +
                            "  cod_estadoclientemedico = null," +
                            "  codigo_cuenta_sin = '"+p.getCodigoCuentaSIN()+"', "+
                            "  nombre_cuenta_sin = '"+p.getNombreCuentaSIN()+"'" +
                            "  WHERE " +
                            "  cod_plan_cuenta = '"+p.getCodPlanCuenta()+"' and cod_gestion = '"+p.getGestion().getCodGestion()+"' ;  ";

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
    
    public  List<SelectItem> cargarPlanDeCuentasItem(PlanDeCuentas p) throws Exception {
        List<SelectItem> productosList =new ArrayList<SelectItem>();
        try {
            
            

            
            String query = " select c.cod_plan_cuenta, c.cod_cuenta ||' '|| c.nombre_cuenta  nombre_cuenta from cont.plan_de_cuentas c where c.movimiento =1 ";
            if(p.getEstadoCuenta()!=0){
                query += " and c.estado_cuentas = '"+p.getEstadoCuenta()+"'  ";
            }
            if(p.getGestion().getCodGestion()!=0){
                query += " and c.cod_gestion = '"+p.getGestion().getCodGestion()+"'  ";
            }
            if(!p.getNombreCuenta().equals("")){
                query += " and UPPER(c.cod_cuenta ||' '|| c.nombre_cuenta) like UPPER('%"+p.getNombreCuenta()+"%')  ";
            }
            query+= " order by c.cod_cuenta ||' '|| c.nombre_cuenta ";
                           
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            productosList.clear();
            while (rs.next())
            {
                productosList.add(new SelectItem(rs.getInt("cod_plan_cuenta"), rs.getString("nombre_cuenta")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return productosList;
    }
   public  PlanDeCuentas buscarPlanDeCuentas(PlanDeCuentas p) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //yyyy/MM/dd HH:mm:ss
        
        PlanDeCuentas np = new PlanDeCuentas();
        try {
            
            

            
            String consulta =   " SELECT p.cod_plan_cuenta,  p.cod_cuenta,  p.nombre_cuenta,  m.cod_moneda,m.nombre_moneda,e.cod_estado_registro,e.nombre_estado_registro,  p.estado_cuentas, " +
                                "  p.ajustable,  p.movimiento,  p.cod_plan_cuenta_padre,  p.nivel,  p.descripcion,g.cod_gestion,g.nombre_gestion,p.codigo_cuenta_sin,p.nombre_cuenta_sin " +
                                " FROM " +
                                "  cont.plan_de_cuentas p " +
                                "  left outer join public.monedas m on m.cod_moneda = p.cod_moneda " +
                                "  left outer join public.estados_registro e on e.cod_estado_registro = p.cod_estado_registro "+
                                "  left outer join public.gestiones g on g.cod_gestion = p.cod_gestion   " +
                                " where 0=0 and g.cod_gestion = '"+p.getGestion().getCodGestion()+"'  ";                    
                    
                    if(!p.getCodCuenta().equals("")){consulta+=" AND p.cod_cuenta like '%"+p.getCodCuenta()+"%' ";}
                    if(!p.getNombreCuenta().equals("")){consulta+=" AND p.nombre_cuenta like '%"+p.getNombreCuenta()+"%' ";}                    
                    if(p.getMoneda().getCodMoneda()!=0){consulta+=" AND p.cod_moneda = '"+p.getMoneda().getCodMoneda()+"'  ";}
                    if(p.getEstadosRegistro().getCodEstado()!=0){consulta+=" AND e.cod_estado_registro = '"+p.getEstadosRegistro().getCodEstado()+"' ";}
                    
                    //consulta += " ORDER BY p.cod_cuenta DESC LIMIT 10 OFFSET "+p.getFilaInicial()+"  ;";
            
            
            System.out.println("consulta " +consulta);

            PreparedStatement statement = this.con.prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next())
            {
                
                np.setCodPlanCuenta(rs.getInt("cod_plan_cuenta"));
                np.setCodCuenta(rs.getString("cod_cuenta"));
                np.setNombreCuenta(rs.getString("nombre_cuenta"));
                np.getMoneda().setCodMoneda(rs.getInt("cod_moneda"));
                np.getMoneda().setNombreMoneda(rs.getString("nombre_moneda"));
                np.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                np.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                np.setEstadoCuenta(rs.getInt("estado_cuentas"));
                np.setAjustable(rs.getInt("ajustable"));
                np.setMovimiento(rs.getInt("movimiento"));
                np.setCodPlanCuentaPadre(rs.getInt("cod_plan_cuenta_padre"));
                np.setNivel(rs.getInt("nivel"));
                np.setDescripcion(rs.getString("descripcion"));
                np.getGestion().setCodGestion(rs.getInt("cod_gestion"));
                np.getGestion().setNombreGestion(rs.getString("nombre_gestion"));
                np.setCodigoCuentaSIN(rs.getString("codigo_cuenta_sin"));
                np.setNombreCuentaSIN(rs.getString("nombre_cuenta_sin"));
                
                
                
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
        return np;
    }
    
    public  int eliminarPlanDeCuentas(PlanDeCuentas p) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            Statement statement = this.con.createStatement();
            String cons =   "  delete from  " +
                            "  cont.plan_de_cuentas  " +                            
                            "  where cod_plan_cuenta = '"+p.getCodPlanCuenta()+"' and cod_gestion = '"+p.getGestion().getCodGestion()+"'  ";
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
    
    public  Response uploadFile (
            InputStream uploadedInputStream,
            FormDataContentDisposition fileDetail,String codGestion) throws Exception {
        String UPLOAD_FOLDER = "uploadedFiles/";
        try{
            PlanDeCuentasResource pdr = new PlanDeCuentasResource();
            String path = pdr.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
            path = path.replaceAll("PlanDeCuentasResource.class", "");
            UPLOAD_FOLDER = path + UPLOAD_FOLDER;
            System.out.println("UPLOAD_FOLDER "+ UPLOAD_FOLDER);
            
            
            
            
            
            
        }catch(Exception e){e.printStackTrace();}

        // check if all form parameters are provided
        if (uploadedInputStream == null || fileDetail == null) {
            return Response.status(400).entity("Invalid form data").build();
        }
        // create our destination folder, if it not exists
        try {
            this.createFolderIfNotExists(UPLOAD_FOLDER);
        } catch (SecurityException se) {
            return Response.status(500)
                    .entity("Can not create destination folder on server")
                    .build();
        }
        String uploadedFileLocation = UPLOAD_FOLDER + fileDetail.getFileName();
        try {
            this.saveToFile(uploadedInputStream, uploadedFileLocation);
        } catch (IOException e) {
            return Response.status(500).entity("Can not save file").build();
        }
        
        this.guardarPlanDeCuentasCSV(uploadedFileLocation,codGestion);
        
        return Response.status(200)
                .entity("File saved to " + uploadedFileLocation).build();
    }
    public  void saveToFile(InputStream inStream, String target)
			throws IOException {
		OutputStream out = null;
		int read = 0;
		byte[] bytes = new byte[1024];
		out = new FileOutputStream(new File(target));
		while ((read = inStream.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		out.flush();
		out.close();
    }
        /**
	 * Creates a folder to desired location if it not already exists
	 * 
	 * @param dirName
	 *            - full path to the folder
	 * @throws SecurityException
	 *             - in case you don't have permission to create the folder
	 */
    public  void createFolderIfNotExists(String dirName)
			throws SecurityException {
		File theDir = new File(dirName);
		if (!theDir.exists()) {
			theDir.mkdir();
		}
    }
    public  int guardarPlanDeCuentasCSV(String csvFile,String codGestion) throws Exception{
        
        int resp = 0;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        PlanDeCuentas p = new PlanDeCuentas();

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] fila = line.split(cvsSplitBy);
                
                System.out.println("line " + line);

                System.out.println("codigo: " + fila[0] + " , nombre: " + fila[1] + " ");
                p.setCodPlanCuenta(this.codigoPlanDeCuentas());
                p.setCodCuenta(fila[0]);
                p.setNombreCuenta(fila[1]);
                p.getEstadosRegistro().setCodEstado(1);
                p.getGestion().setCodGestion(Integer.valueOf(codGestion));
                
                
                this.guardarPlanDeCuentas(p);
                

            }
            resp = 1;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



        return resp;
        
    }
    
    public  int generarPlanDeCuentas(PlanDeCuentas p) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            p.setCodPlanCuenta(this.codigoPlanDeCuentas());
            
            Statement statement = this.con.createStatement();
            String cons =   " INSERT INTO " +
                            "  cont.plan_de_cuentas(" +
                            "  cod_plan_cuenta,cod_cuenta,  nombre_cuenta,  cod_moneda,  cod_estado_registro,  estado_cuentas,  ajustable,  movimiento,  costos," +
                            "  cod_plan_cuenta_padre,  nivel,  estado_cronos,  cod_division,  distribucion_gastos,  cod_estado_flujo,  cod_flujo,  descripcion," +
                            "  estado_promocion,  cod_estadoclientemedico,  cod_gestion,  codigo_cuenta_sin,  nombre_cuenta_sin)" +
                            " SELECT " +
                            "  cod_plan_cuenta,  cod_cuenta,  nombre_cuenta,  cod_moneda,  cod_estado_registro,  estado_cuentas,  ajustable,  movimiento,  costos," +
                            "  cod_plan_cuenta_padre,  nivel,  estado_cronos,  cod_division,  distribucion_gastos,  cod_estado_flujo,  cod_flujo,  descripcion," +
                            "  estado_promocion,  cod_estadoclientemedico,  '"+p.getGestion().getCodGestion()+"',  '0',  ''" +
                            " FROM " +
                            "  cont.plan_de_cuentas_com  ";
            
            
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
}
