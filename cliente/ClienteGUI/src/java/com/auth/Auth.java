package com.auth;


import java.sql.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ROLANDO
 */
public class Auth {
    
   public static Connection Coneccion() throws ClassNotFoundException, SQLException{
       Class.forName("org.gjt.mm.mysql.Driver");
         Connection conexion = DriverManager.getConnection(
            "jdbc:mysql://localhost/sdcf_database", "root", "admin");
         return conexion;
   } 
    
    
    public static Usuario  Select() throws ClassNotFoundException, SQLException{
         Connection conexion= Coneccion();
         Statement st = conexion.createStatement();
         ResultSet rs = st.executeQuery("select * from usuarios" );
         Usuario us = new Usuario();
         
         while (rs.next())
         {
            us.setId(rs.getInt("id"));
            us.setNombre(rs.getString("nombre"));
            us.setContraseña(rs.getString("pass"));
         }
         
         return us;
         
    }
    
    
    public static String verifica (String nombre, String pass) throws ClassNotFoundException, SQLException{
        Connection conexion= Coneccion();
        Statement st = conexion.createStatement();
        String passwd = "select pass from usuarios where nombre='"+nombre+"';";
        ResultSet rs = st.executeQuery(passwd); 
        rs.next();
       // int id = rs.getInt("id");
       //String nombre1 = rs.getString("nombre");
        String passw= rs.getString("pass");
        return passw;
       
    }
    
    
    
}
