<%--
  Created by IntelliJ IDEA.
  User: caros
  Date: 1/10/2024
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Resultado del Juego</title>
</head>
<body>
<h1>Resultado del Juego</h1>

<p><strong>Mensaje:</strong> ${sessionScope.mensajeDelResultado}</p>

<c:choose>
  <c:when test="${sessionScope.opcionElegida != null}">
    <p><strong>Opción elegida:</strong> ${sessionScope.opcionElegida}</p>
  </c:when>
  <c:otherwise>
    <p><strong>Has avanzado en el juego.</strong></p>
  </c:otherwise>
</c:choose>

<form action="index.jsp" method="post">
  <input type="hidden" name="reiniciar" value="true">
  <button type="submit">Reiniciar Juego</button>
</form>

</body>
</html>

