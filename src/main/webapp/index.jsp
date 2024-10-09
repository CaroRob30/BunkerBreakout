<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bunker Breakout</title>
</head>
<body>
<h1>¡Bienvenido a Bunker Breakout!</h1>
<p> Un día te despiertas en completa oscuridad, sientes cómo todos tus músculos están entumecidos <br>
    por el frío que atraviesa tu piel. <br>
    Al abrir los ojos, lo primero que logras ver es un techo de metal corroído y el débil parpadeo <br>
    de una bombilla casi agotada. <br>
    Un zumbido distante retumba por las paredes de lo que parece ser un bunker, el aire es denso, <br>
    pesado, cargado de humedad y desesperanza. <br>
    No recuerdas cómo es que llegaste ahí, tampco de cuánto tiempo ha pasado. <br>
    Sólo sabes que te encuentras en un lugar diseñado para proteger... o para retener. <br>
    A lo lejos, escuchas el eco de pasos, pero no puedes ver quién o qué está ahí. <br><br>
    Estás atrapado en un bunker que parece haber estado deshabitado por años, pero la sensación de que <br>
    algo o alguien te observa es persistente. <br>
    Lo único que tienes es tu instinto y una serie de desafíos qué enfrentar. <br>
    Algunas decisiones te acercarán a la libertad, pero otras te hundirán aún más en este laberinto de <br>
    acero y locura. <br><br>
    ¿Estás listo para enfrentar el desafío y escapar del Bunker? <br><br>
    ¡Ingresa tu nombre y comencemos! <br><br>
</p>

<form action="game" method="post">
    <label for="nombreDelJugador">Nombre del Jugador:</label>
    <input type="text" id="nombreDelJugador" name="nombreDelJugador" required>
    <button type="submit">Intentar Escapar</button>
</form>
</body>
</html>