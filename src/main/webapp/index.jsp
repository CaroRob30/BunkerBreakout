<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bunker Breakout</title>
</head>
<body>
<h1>¡Bienvenido a Bunker Breakout!</h1>
<p>
    En un mundo devastado por la guerra y el caos,
    la humanidad se ha visto forzada a refugiarse en búnkeres subterráneos.<br>
    Eres uno de los pocos sobrevivientes atrapados en el <strong>Búnker</strong>,
    un refugio que ha mantenido a salvo a sus habitantes, pero que ahora se ha vuelto un lugar peligroso.<br>
    Los recursos son escasos y el aire se está volviendo irrespirable.<br>
    La única forma de escapar es resolver una serie de acertijos
    y desafíos que pondrán a prueba tu ingenio y valentía.<br>
    Cada decisión que tomes puede acercarte a la libertad o llevarte a un destino incierto.<br>
    ¿Estás listo para enfrentar el desafío y escapar del Búnker? <br>
    ¡Ingresa tu nombre y comencemos!
</p>

<form action="game" method="post">
    <label for="nombreDelJugador">Nombre del Jugador:</label>
    <input type="text" id="nombreDelJugador" name="nombreDelJugador" required>
    <button type="submit">Intentar Escapar</button>
</form>
</body>
</html>