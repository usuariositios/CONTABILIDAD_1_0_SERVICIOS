<%-- 
    Document   : ventana
    Created on : 25-dic-2013, 17:33:09
    Author     : henry
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.naming.*" %>
<%@page import="javax.sql.*" %>
<%@page import="java.sql.*" %>
<%@page import="servicio.util.Utiles" %>

<%!
    private void ventana(JspWriter out,Connection c,int codVentanaPadre,String nombreVentana,String urlVentana,int codPersonal, int codProyecto){
        try{
            String consulta = " select v.cod_ventana,v.cod_proyecto,v.ventana_padre,v.cod_ventana_padre,vu.nombre_ventana,vu.url_ventana "
                    + " from usuario_personal u"
                    + " inner join ventanas_perfil vp on vp.cod_perfil = u.cod_perfil and vp.cod_proyecto = u.cod_proyecto"
                    + " inner join ventanas v on v.cod_ventana = vp.cod_ventana and v.cod_proyecto = vp.cod_proyecto "
                    + " inner join ventanas_url vu on vu.cod_ventana = v.cod_ventana and vu.cod_proyecto = v.cod_proyecto"
                    + " where cod_ventana_padre = '"+codVentanaPadre+"' "
                    + " and v.cod_estado_registro = '1' and u.cod_personal = '"+codPersonal+"' "
                    + " and vp.cod_estado_registro = 1 "
                    + " and vp.cod_proyecto = '"+codProyecto+"' "
                    + " order by v.orden ";
            System.out.println(consulta);
            Statement st = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(consulta);
            if(!rs.next()){
                out.print("<li class='last'><a href='"+urlVentana+"' ><span>"+nombreVentana+"</span></a></li>");
            }else{
            rs.beforeFirst();
            out.print("<li class='has-sub'><a href='"+urlVentana+"' ><span>"+nombreVentana+"</span></a>");
            out.print("<ul>");
            while(rs.next()){
                ventana(out,c,rs.getInt("cod_ventana"),rs.getString("nombre_ventana"),rs.getString("url_ventana"),codPersonal,codProyecto);
            }
            out.print("</ul>");
            out.print("</li>");
            
           }
        }catch(Exception e)
        {e.printStackTrace();}
    }

%>
<!DOCTYPE html>

        <%
            String codPersonal=request.getParameter("codPersonal")==null?"0":request.getParameter("codPersonal");
            System.out.print("el dato recibido ..."+ codPersonal);
            InitialContext ctx = new InitialContext();
            //The JDBC Data source that we just created
            //DataSource ds = (DataSource) ctx.lookup("jdbc/postgresql");
            //Connection connection = ds.getConnection();
            Utiles utiles = new Utiles();
            utiles.getConnection();
            //Connection connection = Utiles.getConnection();
            out.print("<ul>");
            ventana(out,utiles.getCon(),0,"SISTEMA DE CONTABILIDAD","",Integer.valueOf(codPersonal),2);//enviar el proyecto contabilidad
            utiles.closeConnection();
            out.print("</ul>");
            
            
        %>

