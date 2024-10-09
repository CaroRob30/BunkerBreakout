package com.JuegoBunkerBreakout.Controlador.Servlet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class ServletDelJuegoTest {

    private ServletDelJuego servletDelJuego;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private GestorServletDelJuego gestorServletDelJuego;

    @BeforeEach
    public void setUp() {
        servletDelJuego = new ServletDelJuego();
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        gestorServletDelJuego = Mockito.mock(GestorServletDelJuego.class);

        try {
            var gestor = ServletDelJuego.class.getDeclaredField("gestorServletDelJuego");
            gestor.setAccessible(true);
            gestor.set(servletDelJuego, gestorServletDelJuego);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDoPost_IniciarJuego() throws ServletException, IOException {

        when(request.getParameter("nombreDelJugador")).thenReturn("Jugador1");
        when(request.getParameter("respuesta")).thenReturn(null);

        servletDelJuego.doPost(request, response);

        verify(gestorServletDelJuego, times(1))
                .iniciarJuego(request, "Jugador1");

        verify(gestorServletDelJuego, times(1))
                .mostrarPreguntaActual(request, response);
    }

    @Test
    public void testDoPost_ProcesarRespuesta() throws ServletException, IOException {

        when(request.getParameter("nombreDelJugador")).thenReturn(null);
        when(request.getParameter("respuesta")).thenReturn("respuesta1");
        when(gestorServletDelJuego.procesarRespuesta(request, response, "respuesta1"))
                .thenReturn(true);

        servletDelJuego.doPost(request, response);

        verify(gestorServletDelJuego, times(1)).procesarRespuesta(request, response, "respuesta1");

        verify(gestorServletDelJuego, times(1)).mostrarPreguntaActual(request, response);
    }

    @Test
    public void testDoPost_RespuestaInvalida() throws ServletException, IOException {

        when(request.getParameter("nombreDelJugador")).thenReturn(null);
        when(request.getParameter("respuesta")).thenReturn("respuesta1");
        when(gestorServletDelJuego.procesarRespuesta(request, response, "respuesta1"))
                .thenReturn(false);

        servletDelJuego.doPost(request, response);

        verify(gestorServletDelJuego, times(1))
                .procesarRespuesta(request, response, "respuesta1");

        verify(gestorServletDelJuego, times(0))
                .mostrarPreguntaActual(request, response);
    }
}
