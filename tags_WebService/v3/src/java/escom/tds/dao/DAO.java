package escom.tds.dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author ROLANDO
 */
public class DAO {

    final String driver = "com.mysql.jdbc.Driver";
    final String login = "root";
    final String password = "060590";
    final String bd = "banco";
    final String url = "jdbc:mysql://localhost:3306/" + bd;
    public Statement stm = null;
    public Connection conn = null;

    public boolean conexion() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, login, password);
            stm = conn.createStatement();
            if (conn != null) {
                System.out.println("Conexión a base de datos " + url + " ... Ok");
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public ResultSet queryDB(String sqlString) {
        try {
            if (conexion()) {
                return stm.executeQuery(sqlString);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int updateDB(String sqlString) throws SQLException, ClassNotFoundException {
        try {
            if (conexion()) {
                return stm.executeUpdate(sqlString);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    ;
    public int insertDB(String sqlString) throws SQLException, ClassNotFoundException {
        try {
            if (conexion()) {
                return stm.executeUpdate(sqlString);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int deleteDB(String sqlString) throws SQLException, ClassNotFoundException {
        try {
            if (conexion()) {
                return stm.executeUpdate(sqlString);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }
}
