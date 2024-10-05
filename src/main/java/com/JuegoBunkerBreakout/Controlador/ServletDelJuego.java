package com.JuegoBunkerBreakout.Controlador;

import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.GestorPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.InicializadorPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.PreguntasBunker;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class ServletDelJuego extends HttpServlet {

    private final GestorPreguntasBunker gestorPreguntasBunker = new GestorPreguntasBunker();
    private final LogicaDelJuego logicaJuego;

    public ServletDelJuego() {
        InicializadorPreguntasBunker.inicializar(gestorPreguntasBunker);
        this.logicaJuego = new LogicaDelJuego(gestorPreguntasBunker);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        SesionDelJugador sessionDelJugador = new SesionDelJugador(session);
        String nombreDelJugador = request.getParameter("nombreDelJugador");
        String respuesta = request.getParameter("respuesta");

        if (nombreDelJugador != null && !nombreDelJugador.trim().isEmpty()) {
            sessionDelJugador.setNombreDelJugador(nombreDelJugador);
            sessionDelJugador.setPreguntaActual("iniciar");
            sessionDelJugador.removeMensajeDelResultado();
        } else if (respuesta != null) {
            String preguntaActualClave = sessionDelJugador.getPreguntaActual();

            if (logicaJuego.esRespuestaCorrecta(preguntaActualClave, respuesta)) {
                String siguientePreguntaClave = logicaJuego.obtenerSiguientePregunta(respuesta);
                sessionDelJugador.setPreguntaActual(siguientePreguntaClave);
            } else {
                sessionDelJugador.setMensajeDelResultado("Perdiste. Respuesta incorrecta.");
                response.sendRedirect("resultado.jsp");
                return;
            }
        }

        String preguntaActualClave = sessionDelJugador.getPreguntaActual();
        PreguntasBunker preguntaActual = gestorPreguntasBunker.obtenerPregunta(preguntaActualClave);
        request.setAttribute("pregunta", preguntaActual.getTexto());
        request.setAttribute("opciones", preguntaActual.getOpciones());
        request.getRequestDispatcher("juego.jsp").forward(request, response);
    }
}