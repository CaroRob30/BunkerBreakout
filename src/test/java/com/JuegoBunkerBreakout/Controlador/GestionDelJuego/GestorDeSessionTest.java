package com.JuegoBunkerBreakout.Controlador.GestionDelJuego;

import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

/* Esta clase se encarga de hacer las pruebas de la clase GestorDeSession, la cual se encarga de gestionar
los atributos de sesión en una aplicación web.
Utiliza la biblioteca Mockito para simular el comportamiento de la clase HttpSession, y así poder probar
los métodos de la clase GestorDeSession de forma aislada.
La clase incluye pruebas para los métodos setNombreDelJugador, getNombreDelJugador, setPreguntaActual,
getPreguntaActual, setMensajeDelResultado, removeMensajeDelResultado.
Cada prueba verifica que las interacciones con la sesión se realicen correctamente, asegurandose
que los atributos se establezcan, recuperen o eliminen según lo esperado.
 */

class GestorDeSessionTest {

    private HttpSession session;
    private GestorDeSession gestorDeSession;

    @BeforeEach
    void setUp() {
        session = mock(HttpSession.class);
        gestorDeSession = new GestorDeSession(session);
    }

    @Test
    void testSetNombreDelJugador() {
        String nombre = "Jugador1";
        gestorDeSession.setNombreDelJugador(nombre);
        verify(session).setAttribute("nombreDelJugador", nombre);
    }

    @Test
    void testGetNombreDelJugador() {
        String nombre = "Jugador1";
        when(session.getAttribute("nombreDelJugador")).thenReturn(nombre);
        assertEquals(nombre, gestorDeSession.getNombreDelJugador());
    }

    @Test
    void testSetPreguntaActual() {
        String preguntaActual = "pregunta1";
        gestorDeSession.setPreguntaActual(preguntaActual);
        verify(session).setAttribute("preguntaActual", preguntaActual);
    }

    @Test
    void testGetPreguntaActual() {
        String preguntaActual = "pregunta1";
        when(session.getAttribute("preguntaActual")).thenReturn(preguntaActual);
        assertEquals(preguntaActual, gestorDeSession.getPreguntaActual());
    }

    @Test
    void testSetMensajeDelResultado() {
        String mensaje = "Resultado";
        gestorDeSession.setMensajeDelResultado(mensaje);
        verify(session).setAttribute("mensajeDelResultado", mensaje);
    }

    @Test
    void testRemoveMensajeDelResultado() {
        gestorDeSession.removeMensajeDelResultado();
        verify(session).removeAttribute("mensajeDelResultado");
    }
}