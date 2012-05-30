/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.auth.Auth;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ROLANDO
 */
@WebServlet(name = "Verifica", urlPatterns = {"/Verifica"})
public class Verifica extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            String a = request.getParameter("usr");
            String b = request.getParameter("pass");
            String pass = Auth.verifica(a, b);
            
            if (pass.equals(b)){
                out.println("<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"><title>Consulta</title></head>"
                        + "<body><center><h1>Sistema de Prevención de Crisis Financiera</h1><table border=\"0\"><thead>"
                        + "<tr><th>Menú</th></tr></thead><tbody><tr><td><form name=\"aut\" method=\"post\" action=\"LlamaProcesa\">"
                        + "<table border=\"0\"><thead></thead><tbody><tr><td><input name=\"radio\" type=\"radio\" id=\"radio\" value=\"radio\" />Consultar Información</td>"
                        + "</tr><tr><td><input name=\"radio\" type=\"radio\" id=\"radio\" value=\"radio\" />Procesar Información</td></tr>"
                        + "<tr><td><input type=\"submit\" value=\"Acceder\" name=\"accederButton\"></td></tr></tbody></table>"
                        + "</form></td> </tr>   </tbody> </table> </center></body></html>");
                
                
            }else{
               out.println("<html>");
            out.println("<head>");
            out.println("<link rel=" + "\"stylesheet\"" + " type=\"text/css\"" + " href=\"style.css\">");
            out.println("<title>Servlet ClienteLlamaWs</title>");
            out.println("</head>");
            out.println("<body>"); 
            out.println("<h1>Contraseña Incorrecta"+pass+"</h1>");    
            out.println("</body>");
            out.println("</html>");     
            }
            
            
           /* out.println("<html>");
            out.println("<head>");
            out.println("<link rel=" + "\"stylesheet\"" + " type=\"text/css\"" + " href=\"style.css\">");
            out.println("<title>Servlet ClienteLlamaWs</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Resultado del algoritmo:"+pass+"</h1>");*/
            
            
            
                out.println("<form name=" + "\"aut\"" +  "method=" + "\"post\"" + "action=" + "\"consulta.jsp\"" + ">");
           out.println("</body>");
            out.println("</html>");     
                
            
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Verifica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Verifica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Verifica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Verifica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
