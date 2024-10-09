<%--
  Created by IntelliJ IDEA.
  User: caros
  Date: 4/10/2024
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Fin Del Juego</title>
</head>
<body>
<h1>Resultado del Juego</h1>

<h2><strong>¡Felicidades!<br></strong></h2>
<p>Finalmente has logrado escapar del Bunker, pero no deberías confiarte. <br>
    Acabas de encontrar otro desafio en donde el mundo exterior está vacío y desolado.<br>
    Preparate para la siguiente aventura.<br><br></p>


<form action="index.jsp" method="post">
    <input type="hidden" name="reiniciar" value="true">
    <button type="submit">Reiniciar Juego</button>
</form>

</body>
</html>
