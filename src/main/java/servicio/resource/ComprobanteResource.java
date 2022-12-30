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
import java.util.Date;
import java.util.List;
import servicio.model.SelectItem;
import servicio.busines.ComprobanteBusiness;
import servicio.model.Comprobante;
import servicio.model.ComprobanteDetalle;
import servicio.model.EstadoDeCuenta;
import servicio.model.EstadoDeCuentasRelacionadas;
import servicio.model.Mensaje;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class ComprobanteResource extends BeanResource {
    Connection con;
    public ComprobanteResource(){
    }
    public ComprobanteResource(Connection con){
        this.con = con;
    }
    public  List<Comprobante> cargarComprobante(Comprobante c) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //yyyy/MM/dd HH:mm:ss
        List<Comprobante> ingresosAlmacenList =new ArrayList<Comprobante>();
        Utiles utiles = new Utiles();
        utiles.getConnection();
        try {
            
            
            String consulta =   " SELECT   c.cod_comprobante,  e.cod_empresa,e.nombre_empresa,g.cod_gestion,g.nombre_gestion,m.cod_moneda,m.nombre_moneda, " +
                                " p.cod_personal,p.nombres_personal,  ec.cod_estado_comprobante,ec.nombre_estado_comprobante, " +
                                " t.cod_tipo_comprobante,t.nombre_tipo_comprobante,  c.fecha_comprobante,  c.nro_comprobante, c.nro_cheque,  c.nro_factura,  c.glosa, " +
                                " c.cod_tipo_comprobante_generado,  c.estado_sistema,u.nombre_usuario ,c.cod_emision_cheqhe, c.fecha_sistema,c.descr_monto_total " +
                                " FROM   cont.comprobante c " +
                                " left outer join public.empresa e on e.cod_empresa = c.cod_empresa " +
                                " left outer join public.gestiones g on g.cod_gestion = c.cod_gestion " +
                                " left outer join public.monedas m on m.cod_moneda = c.cod_moneda " +
                                " left outer join public.personal p on p.cod_personal = c.cod_personal " +
                                " left outer join cont.estados_comprobantes ec on ec.cod_estado_comprobante = c.cod_estado_comprobante " +
                                " left outer join cont.tipos_comprobante t on t.cod_tipo_comprobante = c.cod_tipo_comprobante"+
                                " left outer join public.usuario_personal u on u.cod_personal = c.cod_personal "+
                                " where 0=0 and c.cod_empresa = '"+c.getEmpresas().getCodEmpresa()+"' and c.cod_gestion = '"+c.getGestion().getCodGestion()+"' and u.cod_proyecto = '"+c.getPersonal().getCodProyecto()+"'  ";
                    if(c.getNroComprobante()!=0){consulta+=" AND c.nro_comprobante = '"+c.getNroComprobante() +"' ";}
                    
                    
                    
                    if(c.getPersonal().getCodPersonal() !=0){consulta+=" AND c.cod_personal = '"+c.getPersonal().getCodPersonal()+"' ";}
                    if(c.getMonedas().getCodMoneda()!=0){consulta+=" AND c.cod_moneda = '"+c.getMonedas().getCodMoneda()+"' ";}
                    if(!c.getFechaComprobante().equals("")){consulta+=" AND c.fecha_comprobante = '"+c.getFechaComprobante()+"' ";}
                    if(!c.getNroFactura().equals("")){consulta+=" AND c.nro_factura = '"+c.getNroFactura()+"' ";}
                    
                    
                    if(!c.getFechaInicio().equals("") && !c.getFechaFinal().equals("")){consulta+=" AND c.fecha_comprobante between '"+c.getFechaInicio()+"' and '"+c.getFechaFinal()+"' ";}
                    if(c.getEstadosComprobante().getCodEstadoComprobante()!=0){consulta+=" AND c.cod_estado_comprobante = '"+c.getEstadosComprobante().getCodEstadoComprobante()+"' ";}
                    
                    consulta += " ORDER BY c.cod_comprobante DESC LIMIT 10 OFFSET "+c.getFilaInicial()+"  ;";
            
            
            System.out.println("consulta " +consulta);

            PreparedStatement statement = utiles.getCon().prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            ingresosAlmacenList.clear();
            while (rs.next())
            {
                Comprobante cpr = new Comprobante();
                
                cpr.setCodComprobante(rs.getInt("cod_comprobante"));
                cpr.setNroComprobante(rs.getInt("nro_comprobante"));
                cpr.getEmpresas().setCodEmpresa(rs.getInt("cod_empresa"));
                cpr.getEmpresas().setNombreEmpresa(rs.getString("nombre_empresa"));
                cpr.getGestion().setCodGestion(rs.getInt("cod_gestion"));
                cpr.getGestion().setNombreGestion(rs.getString("nombre_gestion"));
                cpr.getMonedas().setCodMoneda(rs.getInt("cod_moneda"));
                cpr.getMonedas().setNombreMoneda(rs.getString("nombre_moneda"));
                cpr.getPersonal().setCodPersonal(rs.getInt("cod_personal"));
                cpr.getPersonal().setNombrePersonal(rs.getString("nombre_usuario"));//nombres_personal
                cpr.getEstadosComprobante().setCodEstadoComprobante(rs.getInt("cod_estado_comprobante"));
                cpr.getEstadosComprobante().setNombreEstadoComprobante(rs.getString("nombre_estado_comprobante"));
                cpr.getTiposComprobante().setCodTipoComprobante(rs.getInt("cod_tipo_comprobante"));
                cpr.getTiposComprobante().setNombreTipoComprobante(rs.getString("nombre_tipo_comprobante"));
                cpr.setFechaComprobante(sdf1.format(rs.getTimestamp("fecha_comprobante")));
                cpr.setNroComprobante(rs.getInt("nro_comprobante"));
                cpr.setNroCheque(rs.getString("nro_cheque"));
                cpr.setNroFactura(rs.getString("nro_factura"));
                cpr.setGlosa(rs.getString("glosa"));
                cpr.setFechaSistema(rs.getString("fecha_sistema"));
                cpr.setDescrMontoTotal(rs.getString("descr_monto_total"));
                
                ingresosAlmacenList.add(cpr);
                
            }
            rs.close();
            statement.close();
            
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return ingresosAlmacenList;
    }
    public  int codigoComprobante() throws Exception{
        int codComprobante=0;
        Utiles utiles = new Utiles();
        utiles.getConnection();
        try {
            
            Statement statement = utiles.getCon().createStatement();
            String cons = "select nextval('cont.\"seqComprobante\"') cod";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                codComprobante = rs.getInt("cod");
            }
            
            statement.close();
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        utiles.closeConnection();
        return codComprobante;
    }
    public  int guardarComprobante(Comprobante c) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            
            
            Statement statement = this.con.createStatement();
            String cons =   " INSERT INTO   cont.comprobante (" +
                            "  cod_comprobante,  cod_empresa,  cod_gestion,  cod_moneda,  cod_personal,  cod_estado_comprobante,  cod_tipo_comprobante,  fecha_comprobante," +
                            "  nro_comprobante,  nro_cheque,  nro_factura,  glosa,  cod_tipo_comprobante_generado,  estado_sistema,  cod_emision_cheqhe,  fecha_sistema,descr_monto_total)" +
                            " VALUES ( '"+c.getCodComprobante()+"',  '"+c.getEmpresas().getCodEmpresa()+"',  '"+c.getGestion().getCodGestion()+"',  '"+c.getMonedas().getCodMoneda()+"',  '"+c.getPersonal().getCodPersonal()+"',  '"+c.getEstadosComprobante().getCodEstadoComprobante()+"',  '"+c.getTiposComprobante().getCodTipoComprobante()+"'," +
                            "  '"+c.getFechaComprobante()+"',  '"+c.getNroComprobante()+"',  '"+c.getNroCheque()+"',  '"+c.getNroFactura()+"',  '"+c.getGlosa()+"',  null,  null,  null," +
                            "  null,'"+c.getDescrMontoTotal()+"'); ";
            
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
    public  int editarComprobante(Comprobante c) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            Statement statement = this.con.createStatement();
            String cons =   "  UPDATE cont.comprobante  " +
                            " SET  " +
                            "  cod_empresa = '"+c.getEmpresas().getCodEmpresa()+"', " +
                            "  cod_gestion = '"+c.getGestion().getCodGestion()+"', " +
                            "  cod_moneda = '"+c.getMonedas().getCodMoneda()+"', " +
                            "  cod_personal = '"+c.getPersonal().getCodPersonal()+"', " +
                            "  cod_estado_comprobante = '"+c.getEstadosComprobante().getCodEstadoComprobante()+"', " +
                            "  cod_tipo_comprobante = '"+c.getTiposComprobante().getCodTipoComprobante()+"', " +
                            "  fecha_comprobante = '"+c.getFechaComprobante()+"', " +
                            "  nro_comprobante = '"+c.getNroComprobante()+"', " +
                            "  nro_cheque = '"+c.getNroCheque()+"', " +
                            "  nro_factura = '"+c.getNroFactura()+"', " +
                            "  glosa = '"+c.getGlosa()+"', " +
                            "  cod_tipo_comprobante_generado = null, " +
                            "  estado_sistema = null, " +
                            "  cod_emision_cheqhe = null, " +
                            "  fecha_sistema = null, " +
                            "  descr_monto_total = '"+c.getDescrMontoTotal()+"' "+
                            "  WHERE  " +
                            "  cod_comprobante = '"+c.getCodComprobante()+"' " +                            
                            "; ";

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
    
    public  List<SelectItem> cargarComprobanteItem() {
        List<SelectItem> productosList =new ArrayList<SelectItem>();        
        try {
            String query = " select c.cod_ingresos_almacen,c.nro_comprobante from ingresos_almacen c order by cod_comprobante ";
                           
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            productosList.clear();
            while (rs.next())
            {
                productosList.add(new SelectItem(rs.getInt("cod_ingresos_almacen"), rs.getString("nro_comprobante")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return productosList;
    }
    
    public  int nroComprobante(Comprobante c){
        int nroComprobante=0;
        try {            
            Statement statement = this.con.createStatement();
            String cons = "select COALESCE(max(nro_comprobante),0)+1 nro_comprobante from cont.comprobante c "
                    + " where c.cod_gestion = '"+c.getGestion().getCodGestion()+"' "
                    + " and c.cod_empresa = '"+c.getEmpresas().getCodEmpresa()+"' ";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                nroComprobante = rs.getInt("nro_comprobante");
            }
            
            statement.close();
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nroComprobante;
    }
    
    public  Comprobante buscarComprobante(Comprobante c){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Comprobante cpr = new Comprobante();
        try {
            
            
            String consulta =   " SELECT   c.cod_comprobante,  e.cod_empresa,e.nombre_empresa,g.cod_gestion,g.nombre_gestion,m.cod_moneda,m.nombre_moneda, " +
                                " p.cod_personal,p.nombres_personal,  ec.cod_estado_comprobante,ec.nombre_estado_comprobante, " +
                                " t.cod_tipo_comprobante,t.nombre_tipo_comprobante,  c.fecha_comprobante,  c.nro_comprobante,  c.nro_cheque,  c.nro_factura,  c.glosa, " +
                                " c.cod_tipo_comprobante_generado,  c.estado_sistema,  c.cod_emision_cheqhe,  c.fecha_sistema,c.descr_monto_total " +
                                " FROM   cont.comprobante c " +
                                " left outer join public.empresa e on e.cod_empresa = c.cod_empresa " +
                                " left outer join public.gestiones g on g.cod_gestion = c.cod_gestion " +
                                " left outer join public.monedas m on m.cod_moneda = c.cod_moneda " +
                                " left outer join public.personal p on p.cod_personal = c.cod_personal " +
                                " left outer join cont.estados_comprobantes ec on ec.cod_estado_comprobante = c.cod_estado_comprobante " +
                                " left outer join cont.tipos_comprobante t on t.cod_tipo_comprobante = c.cod_tipo_comprobante " +                                
                                " where 0=0 and c.cod_empresa = '"+c.getEmpresas().getCodEmpresa()+"' and c.cod_gestion = '"+c.getGestion().getCodGestion()+"'  ";
                    if(c.getNroComprobante()!=0){consulta+=" AND c.nro_comprobante = '"+c.getNroComprobante() +"' ";}
                    if(c.getPersonal().getCodPersonal() !=0){consulta+=" AND c.cod_personal = '"+c.getPersonal().getCodPersonal()+"' ";}
                    if(c.getMonedas().getCodMoneda()!=0){consulta+=" AND c.cod_moneda = '"+c.getMonedas().getCodMoneda()+"' ";}
                    if(!c.getFechaComprobante().equals("")){consulta+=" AND c.fecha_comprobante = '"+c.getFechaComprobante()+"' ";}
                    
                    if(!c.getFechaInicio().equals("") && !c.getFechaFinal().equals("")){consulta+=" AND c.fecha_comprobante between '"+c.getFechaInicio()+"' and '"+c.getFechaFinal()+"' ";}
                    if(c.getEstadosComprobante().getCodEstadoComprobante()!=0){consulta+=" AND c.cod_estado_comprobante = '"+c.getEstadosComprobante().getCodEstadoComprobante()+"' ";}
                    
                    consulta += " ORDER BY c.cod_comprobante DESC LIMIT 10 OFFSET "+c.getFilaInicial()+"  ;";
            
            
            System.out.println("consulta " +consulta);

            PreparedStatement statement = this.con.prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next())
            {
                
                
                
                
                cpr.setCodComprobante(rs.getInt("cod_comprobante"));
                cpr.setNroComprobante(rs.getInt("nro_comprobante"));
                cpr.getEmpresas().setCodEmpresa(rs.getInt("cod_empresa"));
                cpr.getEmpresas().setNombreEmpresa(rs.getString("nombre_empresa"));
                cpr.getGestion().setCodGestion(rs.getInt("cod_gestion"));
                cpr.getGestion().setNombreGestion(rs.getString("nombre_gestion"));
                cpr.getMonedas().setCodMoneda(rs.getInt("cod_moneda"));
                cpr.getMonedas().setNombreMoneda(rs.getString("nombre_moneda"));
                cpr.getPersonal().setCodPersonal(rs.getInt("cod_personal"));
                cpr.getPersonal().setNombrePersonal(rs.getString("nombres_personal"));
                cpr.getEstadosComprobante().setCodEstadoComprobante(rs.getInt("cod_estado_comprobante"));
                cpr.getEstadosComprobante().setNombreEstadoComprobante(rs.getString("nombre_estado_comprobante"));
                cpr.getTiposComprobante().setCodTipoComprobante(rs.getInt("cod_tipo_comprobante"));
                cpr.getTiposComprobante().setNombreTipoComprobante(rs.getString("nombre_tipo_comprobante"));
                cpr.setFechaComprobante(sdf.format(rs.getDate("fecha_comprobante")));
                cpr.setNroComprobante(rs.getInt("nro_comprobante"));
                cpr.setNroCheque(rs.getString("nro_cheque"));
                cpr.setNroFactura(rs.getString("nro_factura"));
                cpr.setGlosa(rs.getString("glosa"));
                cpr.setFechaSistema(rs.getString("fecha_sistema"));
                cpr.setDescrMontoTotal(rs.getString("descr_monto_total"));
                
                
                
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cpr;
    }
    public  int eliminarComprobante(Comprobante i) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Statement statement = this.con.createStatement();
            String cons =   "  delete from  " +
                            "  cont.comprobante  " +                            
                            "  where cod_comprobante = '"+i.getCodComprobante()+"' and nro_comprobante = '"+i.getNroComprobante()+"'  ";
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
    public  void guardarComprobanteBusiness(ComprobanteBusiness cbs) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        int resp = 0;
        ComprobanteResource cr = new ComprobanteResource(this.con);
        ComprobanteDetalleResource cdr = new ComprobanteDetalleResource(this.con);
        EstadoDeCuentasResource ecr = new EstadoDeCuentasResource(this.con);
        EstadoDeCuentasRelacionadasResource ecrr = new EstadoDeCuentasRelacionadasResource(this.con);
        
        
        try {
            cbs.getComprobante().setFechaComprobante(cbs.getComprobante().getFechaComprobante() + " " + sdf.format(new Date()) );
            cbs.getComprobante().setCodComprobante(cr.codigoComprobante());
            cr.guardarComprobante(cbs.getComprobante());
            
            
            int i = 1;
            for(ComprobanteDetalle cd : cbs.getComprobanteDetalleList()){
                cd.setCodComprobanteDetalle(i);
                cd.setComprobante(cbs.getComprobante());
                cdr.guardarComprobanteDetalle(cd);
                //registro de estado de cuentas
                
                if(cd.getPlanDeCuentas().getEstadoCuenta()==1){
                    if (cd.getPlanDeCuentas().getCodCuenta().substring(0, 1).equals("1") && cd.getDebe() > 0) {
                        EstadoDeCuenta e = new EstadoDeCuenta();
                        e.setCodEstadoCuenta(ecr.codigoEstadoDeCuenta());
                        e.setComprobanteDetalle(cd);
                        e.setMontoBS(cd.getDebe());
                        e.setMontoSUS(cd.getDebeSus());
                        ecr.guardarEstadoDeCuenta(e);
                    }
                    if (cd.getPlanDeCuentas().getCodCuenta().substring(0, 1).equals("2") && cd.getHaber() > 0) {
                        EstadoDeCuenta e = new EstadoDeCuenta();
                        e.setCodEstadoCuenta(ecr.codigoEstadoDeCuenta());
                        e.setComprobanteDetalle(cd);
                        e.setMontoBS(cd.getHaber());
                        e.setMontoSUS(cd.getHaberSus());
                        ecr.guardarEstadoDeCuenta(e);
                    }
                    //libro 211
                    if (cd.getPlanDeCuentas().getCodCuenta().substring(0, 4).equals("2111")) {
                    }
                    //matar estado de cuentas
                    
                    //cd.getCodEstadoCuenta();
                    EstadoDeCuentasRelacionadas er = new EstadoDeCuentasRelacionadas();
                    if (cd.getCodEstadoCuenta()>0 && cd.getHaber() > 0) { //cd.getPlanDeCuentas().getCodCuenta().substring(0, 1).equals("1")                        
                        er.getEstadoDeCuenta().setCodEstadoCuenta(cd.getCodEstadoCuenta());
                        er.setMontoBS(cd.getHaber());
                        er.setMontoSUS(cd.getHaberSus());
                        er.setCodComprobante(cd.getComprobante().getCodComprobante());
                        er.setCodComprobanteDetalle(cd.getCodComprobanteDetalle());
                        er.setCodPlanCuenta(cd.getPlanDeCuentas().getCodPlanCuenta());
                        er.setCodCentroCostos(cd.getPlanDeCuentas().getCentroCostos().getCodCentroCostos());
                        er.setCodGestion(cd.getComprobante().getGestion().getCodGestion());                        
                        ecrr.guardarEstadoDeCuentasRelacionadas(er);
                    }
                    if (cd.getCodEstadoCuenta()>0 && cd.getDebe() > 0) { //cd.getPlanDeCuentas().getCodCuenta().substring(0, 1).equals("2")                        
                        er.getEstadoDeCuenta().setCodEstadoCuenta(cd.getCodEstadoCuenta());
                        er.setMontoBS(cd.getDebe());
                        er.setMontoSUS(cd.getDebeSus());
                        er.setCodComprobante(cd.getComprobante().getCodComprobante());
                        er.setCodComprobanteDetalle(cd.getCodComprobanteDetalle());
                        er.setCodPlanCuenta(cd.getPlanDeCuentas().getCodPlanCuenta());
                        er.setCodCentroCostos(cd.getPlanDeCuentas().getCentroCostos().getCodCentroCostos());
                        er.setCodGestion(cd.getComprobante().getGestion().getCodGestion());
                        ecrr.guardarEstadoDeCuentasRelacionadas(er);
                    }
                    Double montoPagado = ecrr.montoPagado(er);
                    EstadoDeCuenta eb = new EstadoDeCuenta();
                    eb.setCodEstadoCuenta(cd.getCodEstadoCuenta());
                    EstadoDeCuenta e = ecr.buscarEstadoDeCuenta(eb);
                    System.out.println(" Math.abs(montoPagado-e.getMontoBS()) " + Math.abs(montoPagado-e.getMontoBS()));//verificar 
                    
                    if(montoPagado.equals(e.getMontoBS()) || Math.abs(montoPagado-e.getMontoBS())>0.001){
                        e.getTipoEstadoCuenta().setCodTipoEstadoCuenta(3);                        
                    }
                    if(e.getMontoBS()>montoPagado && montoPagado>0){
                        e.getTipoEstadoCuenta().setCodTipoEstadoCuenta(2);                        
                    }
                    
                    ecr.editarEstadoDeCuenta(e);
                }
                
                
                
                
                i++;
            }
            resp=1;
        } catch (Exception e) {
            e.printStackTrace();
            resp=0;
            throw new Exception(e.getMessage());
        }
        //return resp;
    }
    public  Mensaje editarComprobanteBusiness(ComprobanteBusiness cbs) throws Exception {
        
        Mensaje m = new Mensaje();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        EstadoDeCuentasRelacionadasResource ecrr = new EstadoDeCuentasRelacionadasResource(this.con);
        EstadoDeCuentasResource ecr = new EstadoDeCuentasResource(this.con);
        ComprobanteDetalleResource cdr = new ComprobanteDetalleResource(this.con);
        ComprobanteResource cr = new ComprobanteResource(this.con);
        try {
        cbs.getComprobante().setFechaComprobante(cbs.getComprobante().getFechaComprobante() + " " + sdf.format(new Date()) );//la hora actual        
        ComprobanteDetalle cd1 = new ComprobanteDetalle(); //borrar el comprobante detalle
        cd1.setComprobante(cbs.getComprobante());
        
        
        EstadoDeCuentasRelacionadas er1 = new EstadoDeCuentasRelacionadas();//borrar los estados de cuenta matados con el comprobante
        er1.setCodComprobante(cd1.getComprobante().getCodComprobante());
        er1.setCodGestion(cd1.getComprobante().getGestion().getCodGestion());
        ecrr.borraEstadoDeCuentasRelacionadas(er1);
        
        EstadoDeCuenta e1 = new EstadoDeCuenta();//borrar el detalle de estados de cuenta
        e1.setComprobanteDetalle(cd1);
        ecr.borraEstadoDeCuenta(e1);
        
        
        
        cdr.borraComprobanteDetalle(cd1);
        
        
        
        cr.editarComprobante(cbs.getComprobante());//editar comprobante
        int i = 1;
            for(ComprobanteDetalle cd : cbs.getComprobanteDetalleList()){
                cd.setCodComprobanteDetalle(i);
                cd.setComprobante(cbs.getComprobante());
                cdr.guardarComprobanteDetalle(cd);
                
                if(cd.getPlanDeCuentas().getEstadoCuenta()==1){
                    if (cd.getPlanDeCuentas().getCodCuenta().substring(0, 1).equals("1") && cd.getDebe() > 0) {
                        EstadoDeCuenta e = new EstadoDeCuenta();
                        e.setCodEstadoCuenta(ecr.codigoEstadoDeCuenta());
                        e.setComprobanteDetalle(cd);
                        e.setMontoBS(cd.getDebe());
                        e.setMontoSUS(cd.getDebeSus());
                        ecr.guardarEstadoDeCuenta(e);
                    }
                    if (cd.getPlanDeCuentas().getCodCuenta().substring(0, 1).equals("2") && cd.getHaber() > 0) {
                        EstadoDeCuenta e = new EstadoDeCuenta();
                        e.setCodEstadoCuenta(ecr.codigoEstadoDeCuenta());
                        e.setComprobanteDetalle(cd);
                        e.setMontoBS(cd.getHaber());
                        e.setMontoSUS(cd.getHaberSus());
                        ecr.guardarEstadoDeCuenta(e);
                    }
                    //libro 211
                    if (cd.getPlanDeCuentas().getCodCuenta().substring(0, 4).equals("2111")) {
                    }
                    //matar estado de cuentas
                    
                    //cd.getCodEstadoCuenta();
                    EstadoDeCuentasRelacionadas er = new EstadoDeCuentasRelacionadas();
                    if (cd.getCodEstadoCuenta()>0 && cd.getHaber() > 0) { //cd.getPlanDeCuentas().getCodCuenta().substring(0, 1).equals("1")                        
                        er.getEstadoDeCuenta().setCodEstadoCuenta(cd.getCodEstadoCuenta());
                        er.setMontoBS(cd.getHaber());
                        er.setMontoSUS(cd.getHaberSus());
                        er.setCodComprobante(cd.getComprobante().getCodComprobante());
                        er.setCodComprobanteDetalle(cd.getCodComprobanteDetalle());
                        er.setCodPlanCuenta(cd.getPlanDeCuentas().getCodPlanCuenta());
                        er.setCodCentroCostos(cd.getCodCentroDeCostos());
                        er.setCodGestion(cd.getComprobante().getGestion().getCodGestion());
                        ecrr.guardarEstadoDeCuentasRelacionadas(er);
                    }
                    if (cd.getCodEstadoCuenta()>0 && cd.getDebe() > 0) { //cd.getPlanDeCuentas().getCodCuenta().substring(0, 1).equals("2")                        
                        er.getEstadoDeCuenta().setCodEstadoCuenta(cd.getCodEstadoCuenta());
                        er.setMontoBS(cd.getDebe());
                        er.setMontoSUS(cd.getDebeSus());
                        er.setCodComprobante(cd.getComprobante().getCodComprobante());
                        er.setCodComprobanteDetalle(cd.getCodComprobanteDetalle());
                        er.setCodPlanCuenta(cd.getPlanDeCuentas().getCodPlanCuenta());
                        er.setCodCentroCostos(cd.getCodCentroDeCostos());
                        er.setCodGestion(cd.getComprobante().getGestion().getCodGestion());
                        ecrr.guardarEstadoDeCuentasRelacionadas(er);
                    }
                    Double montoPagado = ecrr.montoPagado(er);
                    EstadoDeCuenta eb = new EstadoDeCuenta();
                    eb.setCodEstadoCuenta(cd.getCodEstadoCuenta());
                    EstadoDeCuenta e = ecr.buscarEstadoDeCuenta(eb);
                    System.out.println(" Math.abs(montoPagado-e.getMontoBS()) " + Math.abs(montoPagado-e.getMontoBS()));//verificar 
                    
                    if(montoPagado.equals(e.getMontoBS()) || Math.abs(montoPagado-e.getMontoBS())>0.001){
                        e.getTipoEstadoCuenta().setCodTipoEstadoCuenta(3);                        
                    }
                    if(e.getMontoBS()>montoPagado && montoPagado>0){
                        e.getTipoEstadoCuenta().setCodTipoEstadoCuenta(2);                        
                    }
                    
                    ecr.editarEstadoDeCuenta(e);
                }
                
                
                
                
                i++;
            }
            m.setCodResp(1);
        } catch (Exception e) {
            e.printStackTrace();            
            m.setCodResp(0);
            m.setMensajeResp(e.getMessage());
            throw new Exception(e.getMessage());
        }
        return m;
        
    }
    public  int eliminarComprobanteBusiness(ComprobanteBusiness cbs){
        return 0;
    }

    
    
}
