/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package escom.tds.servidor;

import java.sql.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author ROLANDO
 */
@WebService(serviceName = "prevencion")
public class prevencion {

     public String bd = "sdcf_database";
    public String login = "root";
    public String password = "admin";
    public ResultSet rs = null;
    public Statement stm;
    public String url = "jdbc:mysql://localhost:3306/" + bd;
    public Connection conn = null;
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultaBase")
    public String consultaBase(@WebParam(name = "sqlString") String sqlString) {
        //TODO write your implementation code here:
        int i = 0;
        int j = 0;
        String a = "";
        StringBuilder s1 = new StringBuilder();


        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            stm = conn.createStatement();
            if (conn != null) {
                System.out.println("Conexión a base de datos " + url + " ... Ok");
            }


            String query2 = "SELECT flag, ingresos,egresos"
                    + " FROM estado_resultados AS E, bancos AS B, departamentos AS D"
                    + " WHERE E.id_dep='2' AND E.año='2011' AND mes = '2' AND B.id_banco = E.id_banco AND D.id_depto = E.id_dep"
                    + " ORDER BY E.id_banco;";

            rs = stm.executeQuery(query2);

            while (rs.next()) {


                s1.append(rs.getString("flag")).append(",");

                s1.append(rs.getString("ingresos")).append(",");

                s1.append(rs.getString("egresos")).append(",");

                s1.append("-,");


            }

            a = s1.toString();
            a = a.substring(0, (a.length() - 1));

        } catch (SQLException ex) {
            System.out.println("Problema al consultar la base de datos" + url);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }

        return a;


    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "procesaInformacion")
    public String procesaInformacion(@WebParam(name = "sqlString") String sqlString) {
        //TODO write your implementation code here:
        //String muestras = "1,100,20,-,1,108,15,-,1,121,25,-,0,148,35,-,0,140,42,-,0,155,30,-";
        String valor = "100,20";
        knn ini = new knn(sqlString, valor, 1);
        String a = ini.iniciar();

        return a;
    }
}
