<%-- 
    Document   : report
    Created on : 12/06/2012, 12:53:57 AM
    Author     : PRETXEL
--%>


<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
        String depto = request.getParameter("dep");
        String sta = request.getParameter("status");
        String ndepto = request.getParameter("n_dep");
        
    final String driver = "com.mysql.jdbc.Driver";
    final String login = "root";
    final String password = "060590";
    final String bd = "banco";
    final String url = "jdbc:mysql://localhost:3306/" + bd;  
    Connection conn = null;
            
    try
    {
        Class.forName(driver);
        conn = DriverManager.getConnection(url, login, password);
        out.print("conexion CTM! xD");
    }
    catch (Exception ex)
    {
        ex.printStackTrace();
    }

  File reportFile = new File(application.getRealPath("reporte.jasper"));

    Map parameters = new HashMap();
    if(conn!=null)
    out.print("conexion CTM! xD" + reportFile.getPath());
    
    parameters.put("dep", depto);
    parameters.put("resu", sta);
    parameters.put("ndepto", ndepto);
    byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath (),parameters,conn);

    response.setContentType("application/pdf");
    response.setContentLength(bytes.length);
    ServletOutputStream ouputStream = response.getOutputStream();
    ouputStream.write(bytes, 0, bytes.length);
    ouputStream.flush();
    ouputStream.close();
%>
%>
    </body>
</html>
