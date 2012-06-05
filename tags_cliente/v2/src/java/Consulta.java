/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import escom.tds.servidor.Prevencion_Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author PRETXEL
 */
@WebServlet(name = "Consulta", urlPatterns = {"/Consulta"})
public class Consulta extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/Servidor/prevencion.wsdl")
    private Prevencion_Service service;

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
            
            
            String mes_1 = request.getParameter("1mes");
            String mes_3 = request.getParameter("3meses");
            String mes_12 = request.getParameter("12meses");
            String depto = request.getParameter("dep");
            
             String name_depto = null;
                  switch(Integer.parseInt(depto)) 
                     {
                   case 1:name_depto = "Manejo de Fondos";
                           break;
                   case 2:name_depto = "Monetaria";
                           break;
                   case 3:name_depto = "Politica";
                           break;
                   case 4:name_depto = "Sistemas Finacieros";
                           break; 
                }
            
            
            if (mes_1!=null || mes_3!=null || mes_12!=null){
                
                String dep = request.getParameter("depto");
               
                
                
                
               if (mes_1!=null && mes_3==null && mes_12==null){
                   
                   
                   
                   String ee = new String();
                   if(depto!=null){
                       ee ="HOla";
                   }else{
                       ee = "Adios";
                   }
                   
                   
                   String consult = consulta1Mes(dep);
                   StringTokenizer ed = new StringTokenizer(consult,",");
                   String con[] = new String[7];
                   String status = new String();                
                   while (ed.hasMoreTokens()){
                       
                       for (int i=0;i<7;i++){
                           con[i] = ed.nextToken();
                       }
                       
                   }
                   
                   for(int i=0;i<3;i++){
                   if(con[6].equals("1")){
                       status = "Banco en Operación";
                   }else{
                       status = "Banco en Bancarrota";
                   }
                   }
                   
                   out.println("<!DOCTYPE html><html xmlns=\"http://www.w3.org/1999/xhtml/\"><head><meta http-equiv=\"Content-Type content=\"text html; charset=utf-8\"/>"
           + "<title>Banco Multinacional</title><style type=\"text/css\">body,td,th {color: #90F;}</style><style type=\"text/css\">"
                   + "ul.ppt {position: relative;}.ppt li {list-style-type: none;position: absolute;top: 4px;left: 59px;height: 247px;}.ppt img {"
                   + "border: 1px solid #e7e7e7;padding: 5px;background-color: #ececec;}</style></head><body text=\"#FFFFFF\" link=\"#FFFFFF\" vlink=\"#FFFFFF\" alink=\"#FFFFFF\"><table width=\"1321\" height=\"1090\" border=\"0\" align=\"center\">"
                   + "<tbody><tr><td width=\"304\" height=\"24\"> </td><td width=\"6\"> </td><td width=\"363\"> </td><td width=\"309\">&nbsp;</td>"
           + "<td width=\"318\" colspan=\"2\">&nbsp;</td></tr><tr><td colspan=\"3\"><h6><a href=\"/Cliente/index.jsp\"><img src=\"/Cliente/images/bm_morado.png\" alt=\"\" width=\"384\" height=\"211\" align=\"top\" /></a></h6></td>"
           + "<td colspan=\"3\"><p>&nbsp;</p><p><a href=\"compromisocial.jsp\"><img src=\"/Cliente/images/compromiso_social.png\" width=\"346\" height=\"149\" align=\"right\" /></a></p></td></tr><tr>"
           + "<td height=\"84\" colspan=\"6\"><h6><img src=\"/Cliente/images/eco_fin.png\" width=\"1316\" height=\"126\" /></h6></td></tr><tr><td colspan=\"2\"><h5>&nbsp;</h5><h5>COBRANZA DOCUMENTARIA<a href=\"cobranza.jsp\">--&gt; </a></h5><h5>GIROS DIRECTOS FINANCIADOS<a href=\"giros.jsp\">--&gt;</a> </h5>"
           + "<h5>FINANCIAMIENTO A CORTO PLAZO<a href=\"f_cp.jsp\">--&gt;</a></h5>        <h5>SUCURSALES EXTRANJERAS<a href=\"cons_banc.jsp\">--&gt;</a></h5></td><td>"
           + "<center><h2>Departamento: "+name_depto+"</h2></center> "
           + "<center><h2>Consulta de 1 mes </h2></center> "      
           + "<table border=\"1\" width =\"600\"><thead><tr><th>Ingresos</th><th>Egresos</th><th>Liquidez</th><th>Solvencia</th><th>Año</th><th>Mes</th><th>Status</th>"
           + "</tr></thead><tbody><tr><td>"+con[0]+"</td><td>"+con[1]+"</td><td>"+con[2]+"</td><td>"+con[3]+"</td><td>"+con[4]+"</td><td>"+con[5]+"</td><td>"+status+"</td></tr>"
           + "</tbody></table>"
           + "</td><td rowspan=\"2\" align=\"right\"><h5><strong><a href=\"carta.jsp\">&lt;--</a>¿QUE ES UNA CARTA DE CREDITO?</strong></h5>"
           + "<h5><strong><a href=\"c_credito.jsp\">&lt;--</a>CARTA DE CREDITO DE IMPORTACIÓN</strong><br></h5><h5><strong><a href=\"c_domestica.jsp\">&lt;--</a>CARTAS DE CREDITO DOMESTICAS</strong></h5>"
           + "<h5><strong><a href=\"c_exportacion.jsp\">&lt;--</a>CARTAS DE CREDITO DE EXPORTACIÓN</strong></h5>"
           + "<h5><strong><a href=\"c_standby.jsp\">&lt;--</a>CARTAS DE CREDITO EN STANDBY</strong></h5></td></tr><tr><td colspan=\"2\" rowspan=\"2\" align=\"left\"><h6>&nbsp;</h6>        <h6>&nbsp;</h6>        <h6>&nbsp;</h6>        <h6>&nbsp;</h6>        <h6>&nbsp;</h6>          <a href=\"qys.jsp\"><img src=\"/Cliente/images/qys.png\" width=\"265\" height=\"143\" /></a></td>"
           + "</tr><tr><td align=\"center\"><p>&nbsp;</p><p>&nbsp;</p><p><strong>SÍGUENOS EN:  </strong></p><p><strong><a href=\"www.facebook.com\"><img src=\"/Cliente/images/icon-facebook.jpg\" width=\"42\" height=\"40\" /></a></strong></p>"
           + "<p><strong>Banco.Multinacional@facebook.com</strong></p><p><strong><a href=\"www.twitter.com\"><img src=\"/Cliente/images/icon-twitter.jpg\" width=\"45\" height=\"44\" alt=\"TWITTER\" /></a> </strong></p>"
           + "<p><strong>@Banco_Multinacional</strong></p>        </td></tr><tr><td height=\"53\" colspan=\"5\" align=\"center\"> <h5>Av. Juan 1e Dios Bátiz s/n esquina Miguel Othón de Mendizabal. Unidad Profesional Adolfo López Mateos. Col. Lindavista C.P. 07742,</h5>"
           + "<h5>México, D. F. Teléfono 55238744 ext. 16948 fax 77003</h5></td></tr></tbody></table></body</html>");
                   
               }else if(mes_1==null && mes_3!=null && mes_12==null){
                   
                   String consult = consulta3Meses(dep);
                   StringTokenizer ed = new StringTokenizer(consult,",");
                   String con[][] = new String[3][7];
                   String status[] = new String[3];
                   int j=0;
                   while (ed.hasMoreTokens()){
                       
                       for (int i=0;i<7;i++){
                           con[j][i] = ed.nextToken();
                       }
                       j++;
                   }
                   
                   for(int i=0;i<3;i++){
                   if(con[i][6].equals("1")){
                       status[i] = "Banco en Operación";
                   }else{
                       status[i] = "Banco en Bancarrota";
                   }
                   }
                   
                   
                   
                   
                   
                   out.println("<!DOCTYPE html><html xmlns=\"http://www.w3.org/1999/xhtml/\"><head><meta http-equiv=\"Content-Type content=\"text html; charset=utf-8\"/>"
           + "<title>Banco Multinacional</title><style type=\"text/css\">body,td,th {color: #90F;}</style><style type=\"text/css\">"
                   + "ul.ppt {position: relative;}.ppt li {list-style-type: none;position: absolute;top: 4px;left: 59px;height: 247px;}.ppt img {"
                   + "border: 1px solid #e7e7e7;padding: 5px;background-color: #ececec;}</style></head><body text=\"#FFFFFF\" link=\"#FFFFFF\" vlink=\"#FFFFFF\" alink=\"#FFFFFF\"><table width=\"1321\" height=\"1090\" border=\"0\" align=\"center\">"
                   + "<tbody><tr><td width=\"304\" height=\"24\"> </td><td width=\"6\"> </td><td width=\"363\"> </td><td width=\"309\">&nbsp;</td>"
           + "<td width=\"318\" colspan=\"2\">&nbsp;</td></tr><tr><td colspan=\"3\"><h6><a href=\"/Cliente/index.jsp\"><img src=\"/Cliente/images/bm_morado.png\" alt=\"\" width=\"384\" height=\"211\" align=\"top\" /></a></h6></td>"
           + "<td colspan=\"3\"><p>&nbsp;</p><p><a href=\"compromisocial.jsp\"><img src=\"/Cliente/images/compromiso_social.png\" width=\"346\" height=\"149\" align=\"right\" /></a></p></td></tr><tr>"
           + "<td height=\"84\" colspan=\"6\"><h6><img src=\"/Cliente/images/eco_fin.png\" width=\"1316\" height=\"126\" /></h6></td></tr><tr><td colspan=\"2\"><h5>&nbsp;</h5><h5>COBRANZA DOCUMENTARIA<a href=\"cobranza.jsp\">--&gt; </a></h5><h5>GIROS DIRECTOS FINANCIADOS<a href=\"giros.jsp\">--&gt;</a> </h5>"
           + "<h5>FINANCIAMIENTO A CORTO PLAZO<a href=\"f_cp.jsp\">--&gt;</a></h5>        <h5>SUCURSALES EXTRANJERAS<a href=\"cons_banc.jsp\">--&gt;</a></h5></td><td>"
           + "<center><h2>Departamento: "+name_depto+"</h2></center> "
            + "<center><h2>Consulta de 3 meses </h2></center>"
           + "<table border=\"1\" width =\"600\"><thead><tr><th>Ingresos</th><th>Egresos</th><th>Liquidez</th><th>Solvencia</th><th>Año</th><th>Mes</th><th>Status</th>"
           + "</tr></thead><tbody><tr><td>"+con[0][0]+"</td><td>"+con[0][1]+"</td><td>"+con[0][2]+"</td><td>"+con[0][3]+"</td><td>"+con[0][4]+"</td><td>"+con[0][5]+"</td><td>"+status[0]+"</td></tr>"
           + "<tr><td>"+con[1][0]+"</td><td>"+con[1][1]+"</td><td>"+con[1][2]+"</td><td>"+con[1][3]+"</td><td>"+con[1][4]+"</td><td>"+con[1][5]+"</td><td>"+status[1]+"</td></tr>"
           + "<tr><td>"+con[2][0]+"</td><td>"+con[2][1]+"</td><td>"+con[2][2]+"</td><td>"+con[2][3]+"</td><td>"+con[1][4]+"</td><td>"+con[2][5]+"</td><td>"+status[2]+"</td></tr>"
           + "</tbody></table>"  
           + "</td><td rowspan=\"2\" align=\"right\"><h5><strong><a href=\"carta.jsp\">&lt;--</a>¿QUE ES UNA CARTA DE CREDITO?</strong></h5>"
           + "<h5><strong><a href=\"c_credito.jsp\">&lt;--</a>CARTA DE CREDITO DE IMPORTACIÓN</strong><br></h5><h5><strong><a href=\"c_domestica.jsp\">&lt;--</a>CARTAS DE CREDITO DOMESTICAS</strong></h5>"
           + "<h5><strong><a href=\"c_exportacion.jsp\">&lt;--</a>CARTAS DE CREDITO DE EXPORTACIÓN</strong></h5>"
           + "<h5><strong><a href=\"c_standby.jsp\">&lt;--</a>CARTAS DE CREDITO EN STANDBY</strong></h5></td></tr><tr><td colspan=\"2\" rowspan=\"2\" align=\"left\"><h6>&nbsp;</h6>        <h6>&nbsp;</h6>        <h6>&nbsp;</h6>        <h6>&nbsp;</h6>        <h6>&nbsp;</h6>          <a href=\"qys.jsp\"><img src=\"/Cliente/images/qys.png\" width=\"265\" height=\"143\" /></a></td>"
           + "</tr><tr><td align=\"center\"><p>&nbsp;</p><p>&nbsp;</p><p><strong>SÍGUENOS EN:  </strong></p><p><strong><a href=\"www.facebook.com\"><img src=\"/Cliente/images/icon-facebook.jpg\" width=\"42\" height=\"40\" /></a></strong></p>"
           + "<p><strong>Banco.Multinacional@facebook.com</strong></p><p><strong><a href=\"www.twitter.com\"><img src=\"/Cliente/images/icon-twitter.jpg\" width=\"45\" height=\"44\" alt=\"TWITTER\" /></a> </strong></p>"
           + "<p><strong>@Banco_Multinacional</strong></p>        </td></tr><tr><td height=\"53\" colspan=\"5\" align=\"center\"> <h5>Av. Juan 1e Dios Bátiz s/n esquina Miguel Othón de Mendizabal. Unidad Profesional Adolfo López Mateos. Col. Lindavista C.P. 07742,</h5>"
           + "<h5>México, D. F. Teléfono 55238744 ext. 16948 fax 77003</h5></td></tr></tbody></table></body</html>");
                   
               }else{
                   String consult = consulta1Ano(dep);
                   StringTokenizer ed = new StringTokenizer(consult,",");
                   String con[][] = new String[12][7];
                   String status[] = new String[12];
                   int j=0;
                   while (ed.hasMoreTokens()){
                       
                       for (int i=0;i<7;i++){
                           con[j][i] = ed.nextToken();
                       }
                       j++;
                   }
                   
                   for(int i=0;i<12;i++){
                   if(con[i][6].equals("1")){
                       status[i] = "Banco en Operación";
                   }else{
                       status[i] = "Banco en Bancarrota";
                   }
                   }
                   
                    out.println("<!DOCTYPE html><html xmlns=\"http://www.w3.org/1999/xhtml/\"><head><meta http-equiv=\"Content-Type content=\"text html; charset=utf-8\"/>"
           + "<title>Banco Multinacional</title><style type=\"text/css\">body,td,th {color: #90F;}</style><style type=\"text/css\">"
                   + "ul.ppt {position: relative;}.ppt li {list-style-type: none;position: absolute;top: 4px;left: 59px;height: 247px;}.ppt img {"
                   + "border: 1px solid #e7e7e7;padding: 5px;background-color: #ececec;}</style></head><body text=\"#FFFFFF\" link=\"#FFFFFF\" vlink=\"#FFFFFF\" alink=\"#FFFFFF\"><table width=\"1321\" height=\"1090\" border=\"0\" align=\"center\">"
                   + "<tbody><tr><td width=\"304\" height=\"24\"> </td><td width=\"6\"> </td><td width=\"363\"> </td><td width=\"309\">&nbsp;</td>"
           + "<td width=\"318\" colspan=\"2\">&nbsp;</td></tr><tr><td colspan=\"3\"><h6><a href=\"/Cliente/index.jsp\"><img src=\"/Cliente/images/bm_morado.png\" alt=\"\" width=\"384\" height=\"211\" align=\"top\" /></a></h6></td>"
           + "<td colspan=\"3\"><p>&nbsp;</p><p><a href=\"compromisocial.jsp\"><img src=\"/Cliente/images/compromiso_social.png\" width=\"346\" height=\"149\" align=\"right\" /></a></p></td></tr><tr>"
           + "<td height=\"84\" colspan=\"6\"><h6><img src=\"/Cliente/images/eco_fin.png\" width=\"1316\" height=\"126\" /></h6></td></tr><tr><td colspan=\"2\"><h5>&nbsp;</h5><h5>COBRANZA DOCUMENTARIA<a href=\"cobranza.jsp\">--&gt; </a></h5><h5>GIROS DIRECTOS FINANCIADOS<a href=\"giros.jsp\">--&gt;</a> </h5>"
           + "<h5>FINANCIAMIENTO A CORTO PLAZO<a href=\"f_cp.jsp\">--&gt;</a></h5>        <h5>SUCURSALES EXTRANJERAS<a href=\"cons_banc.jsp\">--&gt;</a></h5></td><td>"
           + "<center><h2>Departamento: "+name_depto+"</h2></center> "
           + "<center><h2>Consulta de 12 meses </h2></center>"
           + "<table border=\"1\" width =\"600\"><thead><tr><th>Ingresos</th><th>Egresos</th><th>Liquidez</th><th>Solvencia</th><th>Año</th><th>Mes</th><th>Status</th>"
           + "</tr></thead><tbody><tr><td>"+con[0][0]+"</td><td>"+con[0][1]+"</td><td>"+con[0][2]+"</td><td>"+con[0][3]+"</td><td>"+con[0][4]+"</td><td>"+con[0][5]+"</td><td>"+status[0]+"</td></tr>"
           + "<tr><td>"+con[1][0]+"</td><td>"+con[1][1]+"</td><td>"+con[1][2]+"</td><td>"+con[1][3]+"</td><td>"+con[1][4]+"</td><td>"+con[1][5]+"</td><td>"+status[1]+"</td></tr>"
           + "<tr><td>"+con[2][0]+"</td><td>"+con[2][1]+"</td><td>"+con[2][2]+"</td><td>"+con[2][3]+"</td><td>"+con[2][4]+"</td><td>"+con[2][5]+"</td><td>"+status[2]+"</td></tr>"
           + "<tr><td>"+con[2][0]+"</td><td>"+con[2][1]+"</td><td>"+con[3][2]+"</td><td>"+con[3][3]+"</td><td>"+con[3][4]+"</td><td>"+con[3][5]+"</td><td>"+status[3]+"</td></tr>"
           + "<tr><td>"+con[1][0]+"</td><td>"+con[1][1]+"</td><td>"+con[4][2]+"</td><td>"+con[4][3]+"</td><td>"+con[4][4]+"</td><td>"+con[4][5]+"</td><td>"+status[4]+"</td></tr>"
           + "<tr><td>"+con[2][0]+"</td><td>"+con[2][1]+"</td><td>"+con[5][2]+"</td><td>"+con[5][3]+"</td><td>"+con[5][4]+"</td><td>"+con[5][5]+"</td><td>"+status[5]+"</td></tr>"
           + "<tr><td>"+con[2][0]+"</td><td>"+con[2][1]+"</td><td>"+con[6][2]+"</td><td>"+con[6][3]+"</td><td>"+con[6][4]+"</td><td>"+con[6][5]+"</td><td>"+status[6]+"</td></tr>"
           + "<tr><td>"+con[1][0]+"</td><td>"+con[1][1]+"</td><td>"+con[7][2]+"</td><td>"+con[7][3]+"</td><td>"+con[7][4]+"</td><td>"+con[7][5]+"</td><td>"+status[7]+"</td></tr>"
           + "<tr><td>"+con[2][0]+"</td><td>"+con[2][1]+"</td><td>"+con[8][2]+"</td><td>"+con[8][3]+"</td><td>"+con[8][4]+"</td><td>"+con[8][5]+"</td><td>"+status[8]+"</td></tr>"
           + "<tr><td>"+con[2][0]+"</td><td>"+con[2][1]+"</td><td>"+con[9][2]+"</td><td>"+con[9][3]+"</td><td>"+con[9][4]+"</td><td>"+con[9][5]+"</td><td>"+status[9]+"</td></tr>"
           + "<tr><td>"+con[2][0]+"</td><td>"+con[2][1]+"</td><td>"+con[10][2]+"</td><td>"+con[10][3]+"</td><td>"+con[10][4]+"</td><td>"+con[10][5]+"</td><td>"+status[10]+"</td></tr>"
           + "<tr><td>"+con[2][0]+"</td><td>"+con[2][1]+"</td><td>"+con[11][2]+"</td><td>"+con[11][3]+"</td><td>"+con[11][4]+"</td><td>"+con[11][5]+"</td><td>"+status[11]+"</td></tr>"          
           + "</tbody></table>"  
           + "</td><td rowspan=\"2\" align=\"right\"><h5><strong><a href=\"carta.jsp\">&lt;--</a>¿QUE ES UNA CARTA DE CREDITO?</strong></h5>"
           + "<h5><strong><a href=\"c_credito.jsp\">&lt;--</a>CARTA DE CREDITO DE IMPORTACIÓN</strong><br></h5><h5><strong><a href=\"c_domestica.jsp\">&lt;--</a>CARTAS DE CREDITO DOMESTICAS</strong></h5>"
           + "<h5><strong><a href=\"c_exportacion.jsp\">&lt;--</a>CARTAS DE CREDITO DE EXPORTACIÓN</strong></h5>"
           + "<h5><strong><a href=\"c_standby.jsp\">&lt;--</a>CARTAS DE CREDITO EN STANDBY</strong></h5></td></tr><tr><td colspan=\"2\" rowspan=\"2\" align=\"left\"><h6>&nbsp;</h6>        <h6>&nbsp;</h6>        <h6>&nbsp;</h6>        <h6>&nbsp;</h6>        <h6>&nbsp;</h6>          <a href=\"qys.jsp\"><img src=\"/Cliente/images/qys.png\" width=\"265\" height=\"143\" /></a></td>"
           + "</tr><tr><td align=\"center\"><p>&nbsp;</p><p>&nbsp;</p><p><strong>SÍGUENOS EN:  </strong></p><p><strong><a href=\"www.facebook.com\"><img src=\"/Cliente/images/icon-facebook.jpg\" width=\"42\" height=\"40\" /></a></strong></p>"
           + "<p><strong>Banco.Multinacional@facebook.com</strong></p><p><strong><a href=\"www.twitter.com\"><img src=\"/Cliente/images/icon-twitter.jpg\" width=\"45\" height=\"44\" alt=\"TWITTER\" /></a> </strong></p>"
           + "<p><strong>@Banco_Multinacional</strong></p>        </td></tr><tr><td height=\"53\" colspan=\"5\" align=\"center\"> <h5>Av. Juan 1e Dios Bátiz s/n esquina Miguel Othón de Mendizabal. Unidad Profesional Adolfo López Mateos. Col. Lindavista C.P. 07742,</h5>"
           + "<h5>México, D. F. Teléfono 55238744 ext. 16948 fax 77003</h5></td></tr></tbody></table></body</html>");
     
               }
                    
                
            }
            else
            {
            
            
           out.println("<!DOCTYPE html><html xmlns=\"http://www.w3.org/1999/xhtml/\"><head><meta http-equiv=\"Content-Type content=\"text html; charset=utf-8\"/>"
           + "<title>Banco Multinacional</title><style type=\"text/css\">body,td,th {color: #90F;}</style><style type=\"text/css\">"
                   + "ul.ppt {position: relative;}.ppt li {list-style-type: none;position: absolute;top: 4px;left: 59px;height: 247px;}.ppt img {"
                   + "border: 1px solid #e7e7e7;padding: 5px;background-color: #ececec;}</style></head><body text=\"#FFFFFF\" link=\"#FFFFFF\" vlink=\"#FFFFFF\" alink=\"#FFFFFF\"><table width=\"1321\" height=\"1090\" border=\"0\" align=\"center\">"
                   + "<tbody><tr><td width=\"304\" height=\"24\"> </td><td width=\"6\"> </td><td width=\"363\"> </td><td width=\"309\">&nbsp;</td>"
           + "<td width=\"318\" colspan=\"2\">&nbsp;</td></tr><tr><td colspan=\"3\"><h6><a href=\"/Cliente/index.jsp\"><img src=\"/Cliente/images/bm_morado.png\" alt=\"\" width=\"384\" height=\"211\" align=\"top\" /></a></h6></td>"
           + "<td colspan=\"3\"><p>&nbsp;</p><p><a href=\"compromisocial.jsp\"><img src=\"/Cliente/images/compromiso_social.png\" width=\"346\" height=\"149\" align=\"right\" /></a></p></td></tr><tr>"
           + "<td height=\"84\" colspan=\"6\"><h6><img src=\"/Cliente/images/eco_fin.png\" width=\"1316\" height=\"126\" /></h6></td></tr><tr><td colspan=\"2\"><h5>&nbsp;</h5><h5>COBRANZA DOCUMENTARIA<a href=\"cobranza.jsp\">--&gt; </a></h5><h5>GIROS DIRECTOS FINANCIADOS<a href=\"giros.jsp\">--&gt;</a> </h5>"
           + "<h5>FINANCIAMIENTO A CORTO PLAZO<a href=\"f_cp.jsp\">--&gt;</a></h5>        <h5>SUCURSALES EXTRANJERAS<a href=\"cons_banc.jsp\">--&gt;</a></h5></td><td rowspan=\"3\" align=\"center\" valign=\"top\" width=\"600\">"
           + "<center><h2>Departamento: "+name_depto+"</h2></center> "
           + "<center><h2>Consulta </h2></center><form name=\"aut\" method=\"post\" action=\"#\"><table border=\"0\"><thead></thead>"
                            + "<tbody><tr><td><input name=\"1mes\" type=\"radio\" id=\"consulta\" value=\"1\" />1 Mes</td>"
                            + "</tr><tr><td><input name=\"3meses\" type=\"radio\" id=\"procesa\" value=\"3\" />3 Meses</td></tr> "
                            + " <tr><td><input name=\"12meses\" type=\"radio\" id=\"procesa\" value=\"12\" />1 Año</td></tr>"
                            + "<input type='hidden' name='depto' value='"+depto+"'>"
                            + "<td><input type=\"submit\" value=\"Acceder\" name=\"accederButton\"></td></tr></tbody></table></form>"
           + "</td><td rowspan=\"2\" align=\"right\"><h5><strong><a href=\"carta.jsp\">&lt;--</a>¿QUE ES UNA CARTA DE CREDITO?</strong></h5>"
           + "<h5><strong><a href=\"c_credito.jsp\">&lt;--</a>CARTA DE CREDITO DE IMPORTACIÓN</strong><br></h5><h5><strong><a href=\"c_domestica.jsp\">&lt;--</a>CARTAS DE CREDITO DOMESTICAS</strong></h5>"
           + "<h5><strong><a href=\"c_exportacion.jsp\">&lt;--</a>CARTAS DE CREDITO DE EXPORTACIÓN</strong></h5>"
           + "<h5><strong><a href=\"c_standby.jsp\">&lt;--</a>CARTAS DE CREDITO EN STANDBY</strong></h5></td></tr><tr><td colspan=\"2\" rowspan=\"2\" align=\"left\"><h6>&nbsp;</h6>        <h6>&nbsp;</h6>        <h6>&nbsp;</h6>        <h6>&nbsp;</h6>        <h6>&nbsp;</h6>          <a href=\"qys.jsp\"><img src=\"/Cliente/images/qys.png\" width=\"265\" height=\"143\" /></a></td>"
           + "</tr><tr><td align=\"center\"><p>&nbsp;</p><p>&nbsp;</p><p><strong>SÍGUENOS EN:  </strong></p><p><strong><a href=\"www.facebook.com\"><img src=\"/Cliente/images/icon-facebook.jpg\" width=\"42\" height=\"40\" /></a></strong></p>"
           + "<p><strong>Banco.Multinacional@facebook.com</strong></p><p><strong><a href=\"www.twitter.com\"><img src=\"/Cliente/images/icon-twitter.jpg\" width=\"45\" height=\"44\" alt=\"TWITTER\" /></a> </strong></p>"
           + "<p><strong>@Banco_Multinacional</strong></p>        </td></tr><tr><td height=\"53\" colspan=\"5\" align=\"center\"> <h5>Av. Juan 1e Dios Bátiz s/n esquina Miguel Othón de Mendizabal. Unidad Profesional Adolfo López Mateos. Col. Lindavista C.P. 07742,</h5>"
           + "<h5>México, D. F. Teléfono 55238744 ext. 16948 fax 77003</h5></td></tr></tbody></table></body</html>");
            }
               
             
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

    private String consulta1Ano(java.lang.String dep) {
        escom.tds.servidor.Prevencion port = service.getPrevencionPort();
        return port.consulta1Ano(dep);
    }

    private String consulta1Mes(java.lang.String dep) {
        escom.tds.servidor.Prevencion port = service.getPrevencionPort();
        return port.consulta1Mes(dep);
    }

    private String consulta3Meses(java.lang.String dep) {
        escom.tds.servidor.Prevencion port = service.getPrevencionPort();
        return port.consulta3Meses(dep);
    }
}
