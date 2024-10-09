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

    private final GestorPreguntasBunker gestorPreguntasBunker;
    private final LogicaDelJuego logicaJuego;

    public ServletDelJuego() {
        this.gestorPreguntasBunker = new GestorPreguntasBunker();
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


        if (isNombreDelJugadorValido(nombreDelJugador)) {
            iniciarJuego(gestorDelJuego, nombreDelJugador);
        } else if (respuesta != null) {
            if (!procesarRespuesta(gestorDelJuego, respuesta, sessionDelJugador, response)) {
                return;
            }
        }

        iniciarJuego(request, response, gestorDelJuego);
    }

    private boolean isNombreDelJugadorValido(String nombreDelJugador) {
        return nombreDelJugador != null && !nombreDelJugador.trim().isEmpty();
    }

    private void iniciarJuego(GestorDelJuego gestorDelJuego, String nombreDelJugador) {
        gestorDelJuego.manejarInicioDelJuego(nombreDelJugador);
    }

    private boolean procesarRespuesta(GestorDelJuego gestorDelJuego
            , String respuesta, GestorDeSession sessionDelJugador
            , HttpServletResponse response) throws IOException {

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

    private void iniciarJuego(HttpServletRequest request
            , HttpServletResponse response, GestorDelJuego gestorDelJuego)
            throws ServletException, IOException {

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