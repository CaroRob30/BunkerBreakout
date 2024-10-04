<%--
  Created by IntelliJ IDEA.
  User: caros
  Date: 1/10/2024
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Bunker Breakout</title>
</head>
<body>
<h1>Bunker Breakout</h1>
<p>${pregunta}</p>
<form action="game" method="post">
    <c:forEach var="opcion" items="${opciones}">
        <input type="radio" id="${opcion}" name="respuesta" value="${opcion}" required>
        <label for="${opcion}">${opcion}</label><br>
    </c:forEach>
    <button type="submit">Escapar</button>
</form>
</body>
</html>