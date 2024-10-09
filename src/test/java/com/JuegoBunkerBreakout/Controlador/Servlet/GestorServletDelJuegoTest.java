package com.JuegoBunkerBreakout.Controlador.Servlet;

import com.JuegoBunkerBreakout.Controlador.GestionDelJuego.GestorDeSession;
import com.JuegoBunkerBreakout.Controlador.GestionDelJuego.LogicaDelJuego;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.GestorPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.PreguntasBunker;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GestorServletDelJuegoTest {

    private GestorServletDelJuego gestorServletDelJuego;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    @BeforeEach
    void setUp() {
        gestorServletDelJuego = new GestorServletDelJuego();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
    }

    @Test
    void testIniciarJuego() {
        String nombreDelJugador = "Jugador1";
        String respuestaSimulada = "respuesta correcta";

        when(request.getParameter("respuesta")).thenReturn(respuestaSimulada);
        when(request.getParameter("nombreDelJugador")).thenReturn(nombreDelJugador);

        when(session.getAttribute("nombreDelJugador")).thenReturn(nombreDelJugador);

        gestorServletDelJuego.iniciarJuego(request, nombreDelJugador);

        GestorDeSession sessionDelJugador = new GestorDeSession(session);
        sessionDelJugador.setNombreDelJugador(nombreDelJugador);

        assertEquals(nombreDelJugador, sessionDelJugador.getNombreDelJugador());

        verify(session, atLeastOnce()).setAttribute("nombreDelJugador", nombreDelJugador);
        verify(session).setAttribute("preguntaActual", "iniciar");
        verify(session).removeAttribute("mensajeDelResultado");
    }


    @Test
    void testProcesarRespuesta_Correcta() throws IOException {
        String respuesta = "respuestaCorrecta";
        String preguntaClave = "preguntaClave";

        when(session.getAttribute("preguntaActual")).thenReturn(preguntaClave);

        PreguntasBunker preguntaMock = mock(PreguntasBunker.class);
        when(preguntaMock.esRespuestaCorrecta(respuesta)).thenReturn(true);
        GestorPreguntasBunker gestorPreguntasBunkerMock = mock(GestorPreguntasBunker.class);
        when(gestorPreguntasBunkerMock.obtenerPregunta(preguntaClave)).thenReturn(preguntaMock);

        LogicaDelJuego logicaJuegoMock = mock(LogicaDelJuego.class);
        when(logicaJuegoMock.esUltimaPregunta(preguntaClave)).thenReturn(false);

        GestorServletDelJuego gestorServletDelJuego = new GestorServletDelJuego();

        try {
            var gestorPreguntasBunkerField = GestorServletDelJuego.class
                    .getDeclaredField("gestorPreguntasBunker");
            gestorPreguntasBunkerField.setAccessible(true);
            gestorPreguntasBunkerField.set(gestorServletDelJuego, gestorPreguntasBunkerMock);

            var logicaJuegoField = GestorServletDelJuego.class.getDeclaredField("logicaJuego");
            logicaJuegoField.setAccessible(true);
            logicaJuegoField.set(gestorServletDelJuego, logicaJuegoMock);
        } catch (Exception e) {
            e.printStackTrace();
        }

        boolean resultado = gestorServletDelJuego.procesarRespuesta(request, response, respuesta);

        assertTrue(resultado);
        verify(response, never()).sendRedirect("resultado.jsp");
        verify(response, never()).sendRedirect("finalizado.jsp");
    }

    @Test
    void testProcesarRespuesta_Incorrecta() throws IOException {
        String respuesta = "respuestaIncorrecta";
        String preguntaClave = "preguntaClave";

        when(session.getAttribute("preguntaActual")).thenReturn(preguntaClave);

        PreguntasBunker preguntaMock = mock(PreguntasBunker.class);
        when(preguntaMock.esRespuestaCorrecta(respuesta)).thenReturn(false);
        GestorPreguntasBunker gestorPreguntasBunkerMock = mock(GestorPreguntasBunker.class);
        when(gestorPreguntasBunkerMock.obtenerPregunta(preguntaClave)).thenReturn(preguntaMock);

        LogicaDelJuego logicaJuegoMock = mock(LogicaDelJuego.class);
        when(logicaJuegoMock.esUltimaPregunta(preguntaClave)).thenReturn(false);

        GestorServletDelJuego gestorServletDelJuego = new GestorServletDelJuego();

        try {
            var gestorPreguntasBunkerField = GestorServletDelJuego.class
                    .getDeclaredField("gestorPreguntasBunker");
            gestorPreguntasBunkerField.setAccessible(true);
            gestorPreguntasBunkerField.set(gestorServletDelJuego, gestorPreguntasBunkerMock);

            var logicaJuegoField = GestorServletDelJuego.class.getDeclaredField("logicaJuego");
            logicaJuegoField.setAccessible(true);
            logicaJuegoField.set(gestorServletDelJuego, logicaJuegoMock);
        } catch (Exception e) {
            e.printStackTrace();
        }

        boolean resultado = gestorServletDelJuego.procesarRespuesta(request, response, respuesta);

        assertFalse(resultado);
        verify(response).sendRedirect("resultado.jsp");
    }

    @Test
    void testMostrarPreguntaActual() throws ServletException, IOException {
        when(session.getAttribute("preguntaActual")).thenReturn("preguntaClave");
        PreguntasBunker preguntaMock = mock(PreguntasBunker.class);
        when(preguntaMock.getTexto()).thenReturn("Texto de la pregunta");
        when(preguntaMock.getOpciones()).thenReturn(new String[]{"Opción 1", "Opción 2"});
        GestorPreguntasBunker gestorPreguntasBunkerMock = mock(GestorPreguntasBunker.class);
        when(gestorPreguntasBunkerMock.obtenerPregunta("preguntaClave")).thenReturn(preguntaMock);

        RequestDispatcher requestDispatcherMock = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("juego.jsp")).thenReturn(requestDispatcherMock);

        GestorServletDelJuego gestorServletDelJuego = new GestorServletDelJuego();

        try {
            var gestorPreguntasBunkerField = GestorServletDelJuego.class
                    .getDeclaredField("gestorPreguntasBunker");
            gestorPreguntasBunkerField.setAccessible(true);
            gestorPreguntasBunkerField.set(gestorServletDelJuego, gestorPreguntasBunkerMock);
        } catch (Exception e) {
            e.printStackTrace();
        }

        gestorServletDelJuego.mostrarPreguntaActual(request, response);

        verify(request).setAttribute("pregunta", "Texto de la pregunta");
        verify(request).setAttribute("opciones", new String[]{"Opción 1", "Opción 2"});
        verify(requestDispatcherMock).forward(request, response);
    }
}
