package com.JuegoBunkerBreakout.Controlador;

import com.JuegoBunkerBreakout.Controlador.GestionDelJuego.GestorDelJuego;
import com.JuegoBunkerBreakout.Controlador.GestionDelJuego.LogicaDelJuego;
import com.JuegoBunkerBreakout.Controlador.GestionDelJuego.GestorDeSession;
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
        GestorDeSession sessionDelJugador = new GestorDeSession(session);
        GestorDelJuego gestorDelJuego = new GestorDelJuego(logicaJuego, sessionDelJugador);

        String nombreDelJugador = request.getParameter("nombreDelJugador");
        String respuesta = request.getParameter("respuesta");

        if (nombreDelJugador != null && !nombreDelJugador.trim().isEmpty()) {
            gestorDelJuego.manejarInicioDelJuego(nombreDelJugador);
        } else if (respuesta != null) {

            if (!gestorDelJuego.manejarRespuesta(respuesta)) {
                response.sendRedirect("resultado.jsp");
                return;
            }


            if (logicaJuego.esUltimaPregunta(sessionDelJugador.getPreguntaActual())) {
                response.sendRedirect("finalizado.jsp");
                return;
            }
        }

        PreguntasBunker preguntaActual = gestorDelJuego.obtenerPreguntaActual(gestorPreguntasBunker);
        request.setAttribute("pregunta", preguntaActual.getTexto());
        request.setAttribute("opciones", preguntaActual.getOpciones());
        request.getRequestDispatcher("juego.jsp").forward(request, response);
    }
}

