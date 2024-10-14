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

/*
Esta clase actúa como intermediario entre el servlet y el juego que controla las interacciones del jugador
y el juego. Maneja las solicitudes HTTP relacionadas con el inicio del juego, la validación de respuestas y la
presentación de la pregunta actual.
Al iniciar el juego, gestiona la sesión del jugador y configura las preguntas inciales. Durante el juego,
procesa la respuesta del jugador y redirigea diferentes páginas según el resultado, ya sea a la página de
resultado o a la página de finalización del juego, dependiendo de la lógica del juego.
De igual manera, se encarga de mostrar la pregunta actual al jugador, enviando los datos necesarios a la página
para que muestra la pregunta y las opciones de respuesta correspondientes.
 */

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

        request.setAttribute("pregunta", preguntaActual.getPregunta());
        request.setAttribute("opciones", preguntaActual.getOpciones());
        request.getRequestDispatcher("juego.jsp").forward(request, response);
    }
}
