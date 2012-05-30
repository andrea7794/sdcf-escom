<%-- 
    Document   : qys
    Created on : May 28, 2012, 2:31:59 PM
    Author     : ROLANDO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Banco Multinacional</title>
        <style type="text/css">
            body,td,th {
                color: #90F;
            }
            a:link {
                text-decoration: none;
            }
            a:visited {
                text-decoration: none;
            }
            a:hover {
                text-decoration: underline;
                color: #FFF;
            }
            a:active {
                text-decoration: none;
            }
        </style>
    </head>

    <body text="#FFFFFF" link="#FFFFFF" vlink="#FFFFFF" alink="#FFFFFF">

        <table width="1268" height="932" border="0" align="center">
            <tbody>
                <tr>
                    <td width="171"> </td>
                    <td width="113"> </td>
                    <td width="551"> </td>
                    <td width="128">&nbsp;</td>
                    <td colspan="2">&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="3"><h6><a href="../index.jsp"><img src="../images/bm_morado.png" alt="" width="384" height="211" align="top" /></a></h6></td>
                    <td colspan="3"><p>&nbsp;</p>
                        <p><a href="compromisocial.jsp"><img src="../images/compromiso_social.png" width="346" height="149" align="right" /></a></p></td>
                </tr>
                <tr>
                    <td height="84" colspan="6"><h6><img src="../images/eco_fin.png" width="1263" height="126" /></h6></td>
                </tr>
                <tr>
                    <td colspan="2" rowspan="5"><h6><strong><a href="cobranza.jsp"> </a></strong></h6>
                        <h5>COBRANZA DOCUMENTARIA<a href="cobranza.jsp">--&gt; </a></h5>
                        <h5>GIROS DIRECTOS FINANCIADOS<a href="giros.jsp">--&gt;</a> </h5>
                        <h5>FINANCIAMIENTO A CORTO PLAZO<a href="f_cp.jsp">--&gt;</a></h5>
                        <h5>SUCURSALES EXTRANJERAS<a href="cons_banc.jsp">--&gt;</a></h5>
                        <h6>&nbsp;</h6>
                        <p>&nbsp;</p>
                        <p>&nbsp;</p>
                        <p>&nbsp;</p></td>
                    <td colspan="2" align="center" valign="top"><h3><strong>QUEJAS Y/O SUGERENCIAS</strong></h3></td>
                    <td width="284" rowspan="5" align="right"><h5><strong><a href="carta.jsp">&lt;--</a>¿QUE ES UNA CARTA DE CREDITO?</strong></h5>
                        <h5><strong><a href="c_credito.jsp">&lt;--</a>CARTA DE CREDITO DE IMPORTACIÓN</strong><br />
                        </h5>
                        <h5><strong><a href="c_domestica.jsp">&lt;--</a>CARTAS DE CREDITO DOMESTICAS</strong></h5>
                        <h5><strong><a href="c_exportacion.jsp">&lt;--</a>CARTAS DE CREDITO DE EXPORTACIÓN</strong></h5>
                        <h5><strong><a href="c_standby.jsp">&lt;--</a>CARTAS DE CREDITO EN STANDBY</strong></h5>
                        <h6>&nbsp;</h6>
                        <p>&nbsp;</p></td>
                </tr>
                <tr>
                    <td valign="top"><strong>Fecha:
                            <select name="dd" id="dd">
                                <option selected="selected">dd..</option>
                                <option value="int">1</option>
                                <option value="int">2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                                <option>6</option>
                                <option>7</option>
                                <option>8</option>
                                <option>9</option>
                                <option>10</option>
                                <option>11</option>
                                <option>12</option>
                                <option>13</option>
                                <option>14</option>
                                <option>15</option>
                                <option>16</option>
                                <option>17</option>
                                <option>18</option>
                                <option>19</option>
                                <option>20</option>
                                <option>21</option>
                                <option>22</option>
                                <option>23</option>
                                <option>24</option>
                                <option>25</option>
                                <option>26</option>
                                <option>27</option>
                                <option>28</option>
                                <option>29</option>
                                <option>30</option>
                                <option>31</option>
                            </select>
                            <select name="dd2" id="dd2">
                                <option selected="selected">mm..</option>
                                <option>Enero</option>
                                <option>Febrero</option>
                                <option>Marzo</option>
                                <option>Abril</option>
                                <option>Mayo</option>
                                <option>Junio</option>
                                <option>Julio</option>
                                <option>Agosto</option>
                                <option>Septiembre</option>
                                <option>Octubre</option>
                                <option>Noviembre</option>
                                <option>Diciembre</option>
                            </select>
                            2012</strong></td>
                    <td valign="top"><input name="folio" type="text" disabled="disabled" id="folio" value="  Folio: 00001" size="15" readonly="readonly" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center" valign="top"><h4><strong>Con la finalidad</strong> de mejorar nuestra atención, este formato le permitirá </h4>
                        <h4>emitir sus comentarios, inquietudes, sugerencias o cualquier queja derivada de los servicios que prestamos. </h4>
                        <h4>De antemano gracias por su tiempo.</h4></td>
                </tr>
                <tr>
                    <td colspan="2" align="center" valign="top"><strong>Marque la casilla que proceda:
                            <input type="radio" name="radio" id="radio" value="radio" />

                            Sugerencia
                            <input type="radio" name="radio" id="radio2" value="radio" />
                            Queja</strong></td>
                </tr>
                <tr>
                    <td colspan="2" align="center" valign="top"><strong>Area que lo atendio:
                            <input name="folio2" type="text" id="folio2" size="20" />
                            Persona que lo atendió:</strong>        <input name="folio9" type="text" id="folio9" size="20" /></td>
                </tr>
                <tr>
                    <td colspan="2" rowspan="5" align="center">  
                        <p>&nbsp;</p>
                        <p>&nbsp;</p>
                        <p>&nbsp;</p>
                        <p><a href="qys.jsp"><img src="../images/qys.png" width="265" height="143" /></a></p>
                        <p>&nbsp;</p></td>
                    <td colspan="2" align="center" valign="top"><strong>Servicio proporcionado:
                            <input name="folio3" type="text" id="folio3" size="45" />
                        </strong></td>
                    <td rowspan="5" align="center"><p>&nbsp;</p>
                        <p><strong>SÍGUENOS EN:  </strong>
                        </p>
                        <p><strong><a href="www.facebook.com"><img src="../images/icon-facebook.jpg" width="42" height="40" /></a></strong></p>
                        <p><strong>Banco.Multinacional@facebook.com</strong></p>
                        <p><strong><a href="www.twitter.com"><img src="../images/icon-twitter.jpg" width="45" height="44" alt="TWITTER" /></a> </strong></p>
                        <p><strong>@Banco_Multinacional</strong></p>        </td>
                </tr>
                <tr>
                    <td colspan="2" align="center" valign="top"><strong>Utilice este campo para describir la queja/sugerencia:</strong></td>
                </tr>
                <tr>
                    <td colspan="2" align="center" valign="top"><textarea name="queja" id="queja" cols="75" rows="8"></textarea></td>
                </tr>
                <tr>
                    <td colspan="2" align="center" valign="top"><h4>La información aqui vertida es estrictamente confidencial</h4>
                        <h4>y solo será utilizada con el propósito de mejorar nuestro servicio.</h4>
                        <h4>Para hacer contacto con usted, sea tan amable de proporcionarnos sus datos a continuación.</h4></td>
                </tr>
                <tr>
                    <td colspan="2" align="center" valign="top"><p><strong>Nombre:
                                <input name="folio5" type="text" id="folio5" size="55" />
                            </strong></p>
                        <p><strong>Teléfono:
                                <input name="folio6" type="text" id="folio6" size="30" />
                                e-mail:
                                <input name="folio7" type="text" id="folio7" size="30" />
                            </strong> </p>
                        <p>&nbsp;</p>
                        <h2><strong>E</strong><a href="graciasqys.jsp"><strong>E</strong></a><strong>N</strong><a href="graciasqys.jsp"><strong>N</strong></a><strong>V</strong><a href="graciasqys.jsp"><strong>V</strong></a><strong>I</strong><a href="graciasqys.jsp"><strong>I</strong></a><strong>A</strong><a href="graciasqys.jsp"><strong>A</strong></a><strong>R</strong><a href="graciasqys.jsp"><strong>R</strong></a></h2></td>
                </tr>
                <tr>
                    <td height="53" colspan="5" align="center"> 
                        <h5>Av. Juan 1e Dios Bátiz s/n esquina Miguel Othón de Mendizabal. Unidad Profesional Adolfo López Mateos. Col. Lindavista C.P. 07742,</h5>
                        <h5>México, D. F. Teléfono 55238744 ext. 16948 fax 77003</h5></td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
