<%--
  Created by IntelliJ IDEA.
  User: caros
  Date: 4/10/2024
  Time: 22:33
  To change this template use File | Settings | File Templates.

  Esta página muestra un mensaje de error al cargar las preguntas, fue creada para obtener exitosamente las
  pruebas del servlet.
  Además, inlcuye un formulario que permite al usuario reiniciar el juego, enviando una solicitud POST
  a la página index.jsp con un párametro oculto que indica que el juego debe reiniciarse.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h1>Error al cargar preguntas</h1>

<p><strong>Mensaje:</strong> Ha habido un error con las preguntas, intenta nuevamente</p>


<form action="index.jsp" method="post">
    <input type="hidden" name="reiniciar" value="true">
    <button type="submit">Reiniciar Juego</button>
</form>

</body>
</html>