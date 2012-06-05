/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package escom.tds.servidor;

import escom.tds.algoritmo.knn;
import escom.tds.dao.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author ROLANDO
 */
@WebService(serviceName = "prevencion")
public class prevencion {

    public DAO dao = new DAO();
    public ResultSet rs = null;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultaBase")
    public String consultaBase(@WebParam(name = "sqlString") String sqlString) {
        try {
            //TODO write your implementation code here:


            String a;
            StringBuilder s1 = new StringBuilder();

            rs = dao.queryDB(sqlString);

            while (rs.next()) {
                s1.append(rs.getString(1)).append(",");
                s1.append("-,");
            }

            a = s1.toString();
            a = a.substring(0, (a.length() - 1));

            return a;
        } catch (SQLException ex) {
            Logger.getLogger(prevencion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "procesaInformacion")
    public String procesaInformacion(@WebParam(name = "dep") final String dep) {
        //TODO write your implementation code here:
        //String muestras = "1,100,20,-,1,108,15,-,1,121,25,-,0,148,35,-,0,140,42,-,0,155,30,-";

        String queriedString = consultaProcesa(dep);
        String queriedBank = consultaBanco(dep);
        String valor = "1329504,3766187	,0.566197,0.0142387";
        knn ini = new knn(queriedString, queriedBank, 3);
        String a = ini.iniciar();

        return a;
    }

    
    @WebMethod(operationName = "consultaBanco")
    public String consultaBanco(@WebParam(name = "dep") final String dep) {
        try {
            //TODO write your implementation code here:

            String a;
            StringBuilder s1 = new StringBuilder();
            //mes MAyo
            rs = dao.queryDB("SELECT ingresos,egresos, liquidez, solvencia FROM "
                    + "estado_resultados AS E WHERE E.id_dep='"+dep+"'" 
                    + "AND E.id_banco = '1' AND E.mes = '5' ORDER BY E.id_edo;");

            while (rs.next()) {


                s1.append(rs.getString("ingresos")).append(",");

                s1.append(rs.getString("egresos")).append(",");

                s1.append(rs.getString("liquidez")).append(",");

                s1.append(rs.getString("solvencia"));
              

            }
            rs.close();
            a = s1.toString();
            a = a.substring(0, (a.length() - 1));

            return a;
        } catch (SQLException ex) {
            Logger.getLogger(prevencion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultaProcesa")
    public String consultaProcesa(@WebParam(name = "dep") final String dep) {
        try {
            //TODO write your implementation code here:

            String a;
            StringBuilder s1 = new StringBuilder();
            //mes MAyo
            rs = dao.queryDB("SELECT flag, ingresos,egresos, liquidez, solvencia"
                    + " FROM estado_resultados AS E"
                    + " WHERE E.id_dep='" + dep + "'" + "AND E.id_banco <> '1' AND E.mes = '5'"
                    + " ORDER BY E.id_edo;");

            while (rs.next()) {


                s1.append(rs.getString("flag")).append(",");

                s1.append(rs.getString("ingresos")).append(",");

                s1.append(rs.getString("egresos")).append(",");

                s1.append(rs.getString("liquidez")).append(",");

                s1.append(rs.getString("solvencia")).append(",");

                s1.append("-,");


            }
            rs.close();
            a = s1.toString();
            a = a.substring(0, (a.length() - 1));

            return a;
        } catch (SQLException ex) {
            Logger.getLogger(prevencion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consulta1Mes")
    public String consulta1Mes(@WebParam(name = "dep") final String dep) {
        //TODO write your implementation code here:
        try {
            //TODO write your implementation code here:

            String a;
            StringBuilder s1 = new StringBuilder();

            rs = dao.queryDB("SELECT * FROM estado_resultados WHERE id_banco='1' AND id_dep='"+dep+"' "
                    + "ORDER BY id_edo DESC LIMIT 1;");

            while (rs.next()) {

                s1.append(rs.getString("ingresos")).append(",");

                s1.append(rs.getString("egresos")).append(",");

                s1.append(rs.getString("liquidez")).append(",");

                s1.append(rs.getString("solvencia")).append(",");

                s1.append(rs.getString("año")).append(",");

                s1.append(rs.getString("mes")).append(",");

                s1.append(rs.getString("flag")).append(",");

            }
            rs.close();
            a = s1.toString();
            a = a.substring(0, (a.length() - 1));

            return a;
        } catch (SQLException ex) {
            Logger.getLogger(prevencion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consulta3Meses")
    public String consulta3Meses(@WebParam(name = "dep") final String dep) {
        //TODO write your implementation code here:
        try {
            //TODO write your implementation code here:

            String a;
            int i=0;
            StringBuilder s1 = new StringBuilder();



            rs = dao.queryDB("SELECT * FROM estado_resultados WHERE id_banco='1' AND id_dep='"+dep+"' "
                    + "ORDER BY id_edo DESC LIMIT 3;");

            while (rs.next()) {

                s1.append(rs.getString("ingresos")).append(",");

                s1.append(rs.getString("egresos")).append(",");

                s1.append(rs.getString("liquidez")).append(",");

                s1.append(rs.getString("solvencia")).append(",");

                s1.append(rs.getString("año")).append(",");

                s1.append(rs.getString("mes")).append(",");

                s1.append(rs.getString("flag")).append(",");
         


               }
            
            rs.close();
            a = s1.toString();
            a = a.substring(0, (a.length() - 1));

            return a;
        } catch (SQLException ex) {
            Logger.getLogger(prevencion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consulta1Ano")
    public String consulta1Ano(@WebParam(name = "dep") final String dep) {
        //TODO write your implementation code here:
        try {
            //TODO write your implementation code here:

            String a;
            StringBuilder s1 = new StringBuilder();
            
                
            rs = dao.queryDB("SELECT * FROM estado_resultados WHERE id_banco='1' AND id_dep='"+dep+"' "
                    + " ORDER BY id_edo DESC LIMIT 12;");

            while (rs.next()) {

                s1.append(rs.getString("ingresos")).append(",");

                s1.append(rs.getString("egresos")).append(",");

                s1.append(rs.getString("liquidez")).append(",");

                s1.append(rs.getString("solvencia")).append(",");

                s1.append(rs.getString("año")).append(",");

                s1.append(rs.getString("mes")).append(",");

                s1.append(rs.getString("flag")).append(",");

               


            }
            
            rs.close();
            a = s1.toString();
            a = a.substring(0, (a.length() - 1));

            return a;
        } catch (SQLException ex) {
            Logger.getLogger(prevencion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "verificaUsr")
    public String verificaUsr(@WebParam(name = "usr") final String usr, @WebParam(name = "pass") final String pass,
            @WebParam(name = "dep") final String dep) {
        String id;
        ResultSet rs2;
        try {
            //TODO write your implementation code here:
            rs = dao.queryDB("SELECT id_usuario FROM banco.usuarios "
                    + "WHERE nombre_user = '" + usr + "' AND contrasena = '" + pass + "'");

            if (rs.next()) {
                id = rs.getString("id_usuario");
                rs2 = dao.queryDB("SELECT * FROM banco.usuario_depto "
                        + "WHERE  id_user='" + id + "' AND id_depto ='" + dep + "'");
                if (rs2.next()) {
                    return "1";
                } else {
                    return "Ud. no pertenece al departamento ";
                }

            } else {
                return "Usuario y/o Contrasena Incorrecta";
            }
        } catch (SQLException ex) {
            Logger.getLogger(prevencion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "0";
    }
}
