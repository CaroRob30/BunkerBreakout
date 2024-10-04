package com.JuegoBunkerBreakout.Controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControladorDelJuego extends HttpServlet {

    private static final Map<String, String> PREGUNTAS = new HashMap<>();
    private static final Map<String, String[]> OPCIONES = new HashMap<>();
    private static final Map<String, String> RESPUESTAS = new HashMap<>();

    static {
        PREGUNTAS.put("iniciar", "Estás en un bunker. ¿Qué haces primero?");
        OPCIONES.put("iniciar", new String[]{"Buscar una salida", "Buscar comida", "Buscar agua"});
        RESPUESTAS.put("iniciar", "Buscar una salida");

        PREGUNTAS.put("Buscar una salida", "Encuentras una puerta cerrada. ¿Qué haces?");
        OPCIONES.put("Buscar una salida", new String[]{"Forzar la puerta", "Buscar una llave", "Gritar por ayuda"});
        RESPUESTAS.put("Buscar una salida", "Buscar una llave");

        PREGUNTAS.put("Buscar una llave", "Encuentras una llave. ¿Qué haces?");
        OPCIONES.put("Buscar una llave", new String[]{"Usar la llave en la puerta", "Guardar la llave", "Tirar la llave"});
        RESPUESTAS.put("Buscar una llave", "Usar la llave en la puerta");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String nombreDelJugador = request.getParameter("nombreDelJugador");
        String respuesta = request.getParameter("respuesta");

        // Inicializar el juego
        if (nombreDelJugador != null && nombreDelJugador.trim().length() > 0) {
            session.setAttribute("nombreDelJugador", nombreDelJugador);
            session.setAttribute("preguntaActual", "iniciar");
            session.removeAttribute("mensajeDelResultado"); // Limpiar mensajes de resultados previos
        } else if (respuesta != null) {
            String preguntaActual = (String) session.getAttribute("preguntaActual");

            // Comprobar si la respuesta es correcta
            if (RESPUESTAS.get(preguntaActual).equals(respuesta)) {
                String preguntaSiguiente = OPCIONES.get(preguntaActual)[0]; // Puedes definir cómo obtener la siguiente pregunta
                session.setAttribute("preguntaActual", preguntaSiguiente);
            } else {
                session.setAttribute("mensajeDelResultado", "Perdiste. Respuesta incorrecta. Has muerto de hambre.");
                response.sendRedirect("resultado.jsp");
                return;
            }
        }

        // Mostrar la pregunta y opciones actuales
        String preguntaActual = (String) session.getAttribute("preguntaActual");
        request.setAttribute("pregunta", PREGUNTAS.get(preguntaActual));
        request.setAttribute("opciones", OPCIONES.get(preguntaActual));
        request.getRequestDispatcher("juego.jsp").forward(request, response);
    }
}