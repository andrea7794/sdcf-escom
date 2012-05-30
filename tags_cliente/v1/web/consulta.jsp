<%-- 
    Document   : Consulta
    Author     : Oscar Osvaldo Torres Hernandez
                 Rosa Isela Gonzalez Gallegos
                 Erika Manriquez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta</title>
    </head>
    <body>

         

    <center>
        <h1>Sistema de Prevención de Crisis Financiera</h1>
        <table border="0">
            <thead>
                <tr>
                    <th>Menú</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><form name="aut" method="post" action="LlamaProcesa">

                            <table border="0">
                                <thead>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><input name="radio" type="radio" id="radio" value="radio" />Consultar Información</td>
                                    </tr>
                                    <tr>
                                        <td><input name="radio" type="radio" id="radio" value="radio" />Procesar Información</td>
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
