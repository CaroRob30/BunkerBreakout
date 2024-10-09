package com.JuegoBunkerBreakout.Controlador.GestionDelJuego;

import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.GestorPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.PreguntasBunker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GestorDelJuegoTest {

    private GestorDeSession gestorDeSesion;
    private GestorPreguntasBunker gestorPreguntasBunker;
    private GestorDelJuego gestorDelJuego;

    @BeforeEach
    void setUp() {
        gestorDeSesion = mock(GestorDeSession.class);
        gestorPreguntasBunker = mock(GestorPreguntasBunker.class);
        gestorDelJuego = new GestorDelJuego(mock(LogicaDelJuego.class), gestorDeSesion);
    }

    @Test
    void testManejarInicioDelJuego() {
        String nombreDelJugador = "Jugador1";

        gestorDelJuego.manejarInicioDelJuego(nombreDelJugador);

        verify(gestorDeSesion).setNombreDelJugador(nombreDelJugador);
        verify(gestorDeSesion).setPreguntaActual("iniciar");
        verify(gestorDeSesion).removeMensajeDelResultado();
    }

    @Test
    void testObtenerPreguntaActual() {
        String preguntaActualClave = "iniciar";
        when(gestorDeSesion.getPreguntaActual()).thenReturn(preguntaActualClave);

        PreguntasBunker pregunta = new PreguntasBunker(preguntaActualClave,
                "¿Pregunta?", new String[]{"opcion1", "opcion2"}
                , "respuesta_correcta");

        when(gestorPreguntasBunker.obtenerPregunta(preguntaActualClave)).thenReturn(pregunta);

        PreguntasBunker resultado = gestorDelJuego.obtenerPreguntaActual(gestorPreguntasBunker);

        assertEquals(pregunta, resultado);
    }
}
