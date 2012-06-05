<%-- 
    Document   : authentication
    Created on : May 2, 2012, 1:38:32 PM
    Author     : ROLANDO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" %>
<%@ page import = "com.auth.Usuario"%> 
<%@ page import = "com.auth.Auth"%> 
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Autenticación</title>
    </head>
    <body>
        
        
        
    <center>
        <h1>Sistema de Prevención de Crisis Financiera</h1>
        <table border="0">
            <thead>
                <tr>
                    <th>Autenticación</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><form name="aut" method="post" action="Verifica">

                            <table border="0">
                                <thead>
                                    <tr>
                                        <th>Introduce tu usuario y contraseña: </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Usuario: <input type="text" name="usr" value="" /></td>
                                    </tr>
                                    <tr>
                                        <td>Password:  <input type="password" name="pass" value="" /></td>
                                    </tr>
                                    <tr>
                                        
                                        
                                        <td><input type="submit" value="Acceder" name="accederButton"></td>
                                    
                                       
                                    
                                    </tr>

                                    


                                </tbody>
                            </table>
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>
    </center>
</body>
</html>
