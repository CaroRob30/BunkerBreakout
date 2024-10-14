<%--
  Created by IntelliJ IDEA.
  User: caros
  Date: 1/10/2024
  Time: 22:01
  To change this template use File | Settings | File Templates.

  Esta página se encarga de mostrar el resultado cuando se equivoca de respuesta el jugador.
  La página presenta un encabezado con el título "Resultado del Juego" y un mensaje que se recupera
  de la sesión del usuario mediante la expresión ${sessionScope.mensajeDelResultado}, proporcionando
  información sobre el resultado del juego. Además, incluye un formulario que permite al jugador reiniciar
  el juego, al hacer clic en el botón "Reiniciar Juego", se envía una solicitud POST a index.jsp, incluyendo
  un campo oculto que indica que se desea reiniciar.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Resultado del Juego</title>
</head>
<body>
<h1>Resultado del Juego</h1>

<p><strong>Mensaje:</strong><br> ${sessionScope.mensajeDelResultado}</p>


<form action="index.jsp" method="post">
  <input type="hidden" name="reiniciar" value="true">
  <button type="submit">Reiniciar Juego</button>
</form>

</body>
</html>

