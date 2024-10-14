<%--
  Created by IntelliJ IDEA.
  User: caros
  Date: 4/10/2024
  Time: 22:33
  To change this template use File | Settings | File Templates.

  Esta página representa el resultado final del juego, informando al jugador que ha logrado escapar del Bunker.
  El contenido inlcuye un encabezado que celebra el logro del jugador, y un párrafo que proporciona contexto
  adicional sobre el juego.
  La página también incluye un formulario que permite al jugador reiniciar el juego, enviando una solicitud POST
  a la página index.jsp con un párametro oculto que indica que el juego debe reiniciarse.
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
