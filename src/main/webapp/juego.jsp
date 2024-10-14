<%--
  Created by IntelliJ IDEA.
  User: caros
  Date: 1/10/2024
  Time: 21:35
  To change this template use File | Settings | File Templates.

  Esta página representa el juego en sí, mostrando al jugador una pregunta y una serie de opciones
   para responder.
   Utiliza la biblioteca JSTL para iterar sobre una colección de opciones, creando un grupo de botones
   de radio que permiten al jugador seleccionar su respuesta. La página muestra el nombre del jugador
  (almacenado en la variable ${nombreDelJugador}) y la pregunta actual (almacenada en la variable ${pregunta}).
   Al enviar el formulario, que se dirige a la ruta game, se envía la respuesta seleccionada mediante una
   solicitud POST.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Bunker Breakout</title>
</head>
<body>
<h1>Bunker Breakout</h1>
<h2>${nombreDelJugador}:</h2>
<p>${pregunta}</p>
<form action="game" method="post">
    <c:forEach var="opcion" items="${opciones}">
        <input type="radio" id="${opcion}" name="respuesta" value="${opcion}" required>
        <label for="${opcion}">${opcion}</label><br><br>
    </c:forEach>
    <button type="submit">Responder</button>
</form>
</body>
</html>
