/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PRETXEL
 */
@WebServlet(name = "Procesa", urlPatterns = {"/Procesa"})
public class Procesa extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
          out.println("<!DOCTYPE html><html xmlns=\"http://www.w3.org/1999/xhtml/\"><head><meta http-equiv=\"Content-Type content=\"text html; charset=utf-8\"/>"
           + "<title>Banco Multinacional</title><style type=\"text/css\">body,td,th {color: #90F;}</style><style type=\"text/css\">"
                   + "ul.ppt {position: relative;}.ppt li {list-style-type: none;position: absolute;top: 4px;left: 59px;height: 247px;}.ppt img {"
                   + "border: 1px solid #e7e7e7;padding: 5px;background-color: #ececec;}</style></head><body text=\"#FFFFFF\" link=\"#FFFFFF\" vlink=\"#FFFFFF\" alink=\"#FFFFFF\"><table width=\"1321\" height=\"1090\" border=\"0\" align=\"center\">"
                   + "<tbody><tr><td width=\"304\" height=\"24\"> </td><td width=\"6\"> </td><td width=\"363\"> </td><td width=\"309\">&nbsp;</td>"
           + "<td width=\"318\" colspan=\"2\">&nbsp;</td></tr><tr><td colspan=\"3\"><h6><a href=\"/Cliente/index.jsp\"><img src=\"/Cliente/images/bm_morado.png\" alt=\"\" width=\"384\" height=\"211\" align=\"top\" /></a></h6></td>"
           + "<td colspan=\"3\"><p>&nbsp;</p><p><a href=\"compromisocial.jsp\"><img src=\"/Cliente/images/compromiso_social.png\" width=\"346\" height=\"149\" align=\"right\" /></a></p></td></tr><tr>"
           + "<td height=\"84\" colspan=\"6\"><h6><img src=\"/Cliente/images/eco_fin.png\" width=\"1316\" height=\"126\" /></h6></td></tr><tr><td colspan=\"2\"><h5>&nbsp;</h5><h5>COBRANZA DOCUMENTARIA<a href=\"cobranza.jsp\">--&gt; </a></h5><h5>GIROS DIRECTOS FINANCIADOS<a href=\"giros.jsp\">--&gt;</a> </h5>"
           + "<h5>FINANCIAMIENTO A CORTO PLAZO<a href=\"f_cp.jsp\">--&gt;</a></h5>        <h5>SUCURSALES EXTRANJERAS<a href=\"cons_banc.jsp\">--&gt;</a></h5></td><td>"
           + "<h3>Procesa </h3>"
           + "</td><td rowspan=\"2\" align=\"right\"><h5><strong><a href=\"carta.jsp\">&lt;--</a>¿QUE ES UNA CARTA DE CREDITO?</strong></h5>"
           + "<h5><strong><a href=\"c_credito.jsp\">&lt;--</a>CARTA DE CREDITO DE IMPORTACIÓN</strong><br></h5><h5><strong><a href=\"c_domestica.jsp\">&lt;--</a>CARTAS DE CREDITO DOMESTICAS</strong></h5>"
           + "<h5><strong><a href=\"c_exportacion.jsp\">&lt;--</a>CARTAS DE CREDITO DE EXPORTACIÓN</strong></h5>"
           + "<h5><strong><a href=\"c_standby.jsp\">&lt;--</a>CARTAS DE CREDITO EN STANDBY</strong></h5></td></tr><tr><td colspan=\"2\" rowspan=\"2\" align=\"left\"><h6>&nbsp;</h6>        <h6>&nbsp;</h6>        <h6>&nbsp;</h6>        <h6>&nbsp;</h6>        <h6>&nbsp;</h6>          <a href=\"qys.jsp\"><img src=\"/Cliente/images/qys.png\" width=\"265\" height=\"143\" /></a></td>"
           + "</tr><tr><td align=\"center\"><p>&nbsp;</p><p>&nbsp;</p><p><strong>SÍGUENOS EN:  </strong></p><p><strong><a href=\"www.facebook.com\"><img src=\"/Cliente/images/icon-facebook.jpg\" width=\"42\" height=\"40\" /></a></strong></p>"
           + "<p><strong>Banco.Multinacional@facebook.com</strong></p><p><strong><a href=\"www.twitter.com\"><img src=\"/Cliente/images/icon-twitter.jpg\" width=\"45\" height=\"44\" alt=\"TWITTER\" /></a> </strong></p>"
           + "<p><strong>@Banco_Multinacional</strong></p>        </td></tr><tr><td height=\"53\" colspan=\"5\" align=\"center\"> <h5>Av. Juan 1e Dios Bátiz s/n esquina Miguel Othón de Mendizabal. Unidad Profesional Adolfo López Mateos. Col. Lindavista C.P. 07742,</h5>"
           + "<h5>México, D. F. Teléfono 55238744 ext. 16948 fax 77003</h5></td></tr></tbody></table></body</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
