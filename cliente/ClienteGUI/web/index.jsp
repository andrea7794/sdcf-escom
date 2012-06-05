<%-- 
    Document   : index
    Created on : 1/05/2012, 04:58:21 PM
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
        </style>
        <style type="text/css">
            ul.ppt {
                position: relative;
            }

            .ppt li {
                list-style-type: none;
                position: absolute;
                top: 4px;
                left: 59px;
                height: 247px;
            }

            .ppt img {
                border: 1px solid #e7e7e7;
                padding: 5px;
                background-color: #ececec;
            }
        </style>
    </head>

    <body text="#FFFFFF" link="#FFFFFF" vlink="#FFFFFF" alink="#FFFFFF">
        <table width="1321" height="932" border="0" align="center">
            <tbody>
                <tr>
                    <td width="377"> </td>
                    <td width="5"> </td>
                    <td width="565"> </td>
                    <td width="10">&nbsp;</td>
                    <td width="342" colspan="2">&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="3"><h6><a href="index.jsp"><img src="images/bm_morado.png" alt="" width="384" height="211" align="top" /></a></h6></td>
                    <td colspan="3"><p>&nbsp;</p>
                        <p><a href="pages/compromisocial.jsp"><img src="images/compromiso_social.png" width="346" height="149" align="right" /></a></p></td>
                </tr>
                <tr>
                    <td height="84" colspan="6"><h6><img src="images/eco_fin.png" width="1313" height="126" /></h6></td>
                </tr>
                <tr>
                    <td colspan="2"><h5>&nbsp;</h5>
                        <h5>COBRANZA DOCUMENTARIA<a href="pages/cobranza.jsp">--&gt; </a></h5>
                        <h5>GIROS DIRECTOS FINANCIADOS<a href="pages/giros.jsp">-&gt;</a> </h5>
                        <h5>FINANCIAMIENTO A CORTO PLAZO<a href="pages/f_cp.jsp">--&gt;</a></h5>
                        <h5>SUCURSALES EXTRANJERAS<a href="pages/cons_banc.jsp">--&gt;</a></h5></td>
                    <td colspan="2" rowspan="3" valign="top"><p>
                            <ul class="ppt">
                                <li><a href="pages/user_politica.jsp"><img src="images/politica.png" alt="descripción 1" width="442" height="237"/></a></img></li>
                                <li><a href="pages/user_sistemasfinancieros.jsp"><img src="images/s_financieros.png" alt="descripción 2" width="442" height="237"/></a></img></li>
                                <li><a href="pages/user_manejodefondos.jsp"><img src="images/m_fondos.png" alt="descripción 3" width="442" height="237"/></a></img></li>
                                <li><a href="pages/user_monetaria.jsp"><img src="images/monetaria.png" alt="descripción 4" width="442" height="237" /></a> </img></li>
                            </ul>
                            <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
                            <script type="text/javascript">
                                $('.ppt li:gt(0)').hide();
                                $('.ppt li:last').addClass('last');
                                var cur = $('.ppt li:first');

                                function animate() {
                                    cur.fadeOut( 1000 );
                                    if ( cur.attr('class') == 'last' )
                                        cur = $('.ppt li:first');
                                    else
                                        cur = cur.next();
                                    cur.fadeIn( 1000 );
                                }

                                $(function() {
                                    setInterval( "animate()", 3000 );
                                } );
                            </script>

                    </td>
                    <td rowspan="2" align="right">
                        <h5><strong><a href="pages/carta.jsp">&lt;--</a>¿QUE ES UNA CARTA DE CREDITO?</strong></h5>
                        <h5><strong><a href="pages/c_credito.jsp">&lt;--</a>CARTA DE CREDITO DE IMPORTACIÓN</strong>
                        <h5><strong><a href="pages/c_domestica.jsp">&lt;--</a>CARTAS DE CREDITO DOMESTICAS</strong></h5>
                        <h5><strong><a href="pages/c_exportacion.jsp">&lt;--</a>CARTAS DE CREDITO DE EXPORTACIÓN</strong></h5>
                        <h5><strong><a href="pages/c_standby.jsp">&lt;--</a>CARTAS DE CREDITO EN STANDBY</strong></h5></td>
                </tr>
                <tr>
                    <td colspan="2" rowspan="2" align="left"><h6>&nbsp;</h6>        <h6>´</h6>        <h6>&nbsp;</h6>        <h6>&nbsp;</h6>        <h6>&nbsp;</h6>          <a href="pages/qys.jsp"><img src="images/qys.png" width="265" height="143" /></a></td>
                </tr>
                <tr>
                    <td align="center"><p>&nbsp;</p>
                        <p>&nbsp;</p>
                        <p><strong>SÍGUENOS EN:  </strong>
                        </p>
                        <p><strong><a href="www.facebook.com"><img src="images/icon-facebook.jpg" width="42" height="40" /></a></strong></p>
                        <p><strong>Banco.Multinacional@facebook.com</strong></p>
                        <p><strong><a href="www.twitter.com"><img src="images/icon-twitter.jpg" width="45" height="44" alt="TWITTER" /></a> </strong></p>
                        <p><strong>@Banco_Multinacional</strong></p>        </td>
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

