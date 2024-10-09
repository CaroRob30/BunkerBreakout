package com.JuegoBunkerBreakout.Controlador;

import com.JuegoBunkerBreakout.Controlador.GestionDelJuego.GestorDeSession;
import com.JuegoBunkerBreakout.Controlador.GestionDelJuego.GestorDelJuego;
import com.JuegoBunkerBreakout.Controlador.GestionDelJuego.LogicaDelJuego;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.GestorPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.PreguntasBunker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.mockito.Mockito.*;

class ServletDelJuegoTest {

    private ServletDelJuego servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private GestorPreguntasBunker gestorPreguntasBunker;

    @BeforeEach
    void setUp() {
        gestorPreguntasBunker = mock(GestorPreguntasBunker.class);
        servlet = new ServletDelJuego();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
    }

    @Test
    void testDoPost_IniciarJuego() throws Exception {

        when(request.getParameter("nombreDelJugador")).thenReturn("Caro");
        when(request.getSession()).thenReturn(session);

        PreguntasBunker preguntaSimulada = new PreguntasBunker("iniciar"
                , "¿Cómo te llamas?", new String[]{"Caro", "Juan", "Pedro"}, "Caro");
        when(gestorPreguntasBunker.obtenerPregunta("iniciar")).thenReturn(preguntaSimulada);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        servlet.doPost(request, response);

        verify(session).setAttribute("nombreDelJugador", "Caro");
        writer.flush();
    }
}
