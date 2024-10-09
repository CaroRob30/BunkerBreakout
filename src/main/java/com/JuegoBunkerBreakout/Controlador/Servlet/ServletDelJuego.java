package com.JuegoBunkerBreakout.Controlador.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

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
