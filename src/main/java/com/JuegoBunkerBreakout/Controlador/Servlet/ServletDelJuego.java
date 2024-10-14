package com.JuegoBunkerBreakout.Controlador.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
Esta clase es un servlet que actúa como el controlador principal del juego. Gestiona las solicitudes
HTTP POST enviadas. Si se recibe un nombre del jugador, inicia una nueva sesión de juego con la ayuda
de GestorServletDelJuego. Si se recibe una respuesta, valida la respuesta, determinando si continuar con
el juego o redirigir a una página de resultado.
Muestra la pregunta actual al jugador, asegurando que el flujo del juego continue de manera correcta en
la interfaz de web.
 */
public class ServletDelJuego extends HttpServlet {

    private final GestorServletDelJuego gestorServletDelJuego;

    public ServletDelJuego() {
        this.gestorServletDelJuego = new GestorServletDelJuego();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombreDelJugador = request.getParameter("nombreDelJugador");
        String respuesta = request.getParameter("respuesta");

        if (nombreDelJugador != null && !nombreDelJugador.trim().isEmpty()) {
            gestorServletDelJuego.iniciarJuego(request, nombreDelJugador);
        } else if (respuesta != null) {
            if (!gestorServletDelJuego.procesarRespuesta(request, response, respuesta)) {
                return;
            }
        }

        gestorServletDelJuego.mostrarPreguntaActual(request, response);
    }
}
