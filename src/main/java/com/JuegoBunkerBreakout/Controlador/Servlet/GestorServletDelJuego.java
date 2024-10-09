package com.JuegoBunkerBreakout.Controlador.Servlet;

import com.JuegoBunkerBreakout.Controlador.GestionDelJuego.GestorDeSession;
import com.JuegoBunkerBreakout.Controlador.GestionDelJuego.GestorDelJuego;
import com.JuegoBunkerBreakout.Controlador.GestionDelJuego.LogicaDelJuego;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.GestorPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.InicializadorPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.PreguntasBunker;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class GestorServletDelJuego {

    private final GestorPreguntasBunker gestorPreguntasBunker;
    private final LogicaDelJuego logicaJuego;

    public GestorServletDelJuego() {

        this.gestorPreguntasBunker = new GestorPreguntasBunker();
        InicializadorPreguntasBunker.inicializar(gestorPreguntasBunker);
        this.logicaJuego = new LogicaDelJuego(gestorPreguntasBunker);
    }

    public void iniciarJuego(HttpServletRequest request, String nombreDelJugador) {

        HttpSession session = request.getSession();
        GestorDeSession sessionDelJugador = new GestorDeSession(session);
        GestorDelJuego gestorDelJuego =
                new GestorDelJuego(logicaJuego, sessionDelJugador, gestorPreguntasBunker);

        gestorDelJuego.manejarInicioDelJuego(nombreDelJugador);
    }

    public boolean procesarRespuesta(HttpServletRequest request, HttpServletResponse response
            , String respuesta) throws IOException {

        HttpSession session = request.getSession();
        GestorDeSession sessionDelJugador = new GestorDeSession(session);
        GestorDelJuego gestorDelJuego =
                new GestorDelJuego(logicaJuego, sessionDelJugador, gestorPreguntasBunker);

        if (!gestorDelJuego.manejarRespuesta(respuesta)) {
            response.sendRedirect("resultado.jsp");
            return false;
        }

        if (logicaJuego.esUltimaPregunta(sessionDelJugador.getPreguntaActual())) {
            response.sendRedirect("finalizado.jsp");
            return false;
        }
        return true;
    }

    public void mostrarPreguntaActual(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        GestorDeSession sessionDelJugador = new GestorDeSession(session);
        GestorDelJuego gestorDelJuego =
                new GestorDelJuego(logicaJuego, sessionDelJugador, gestorPreguntasBunker);

        PreguntasBunker preguntaActual = gestorDelJuego.obtenerPreguntaActual(gestorPreguntasBunker);
        if (preguntaActual == null) {
            response.sendRedirect("error.jsp");
            return;
        }

        request.setAttribute("pregunta", preguntaActual.getTexto());
        request.setAttribute("opciones", preguntaActual.getOpciones());
        request.getRequestDispatcher("juego.jsp").forward(request, response);
    }
}
