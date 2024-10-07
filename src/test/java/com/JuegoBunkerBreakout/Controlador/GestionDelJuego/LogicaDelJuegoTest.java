package com.JuegoBunkerBreakout.Controlador.GestionDelJuego;

import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.GestorPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.PreguntasBunker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class LogicaDelJuegoTest {

    private GestorPreguntasBunker gestorPreguntasBunker;
    private LogicaDelJuego logicaDelJuego;
    private PreguntasBunker pregunta;
    private PreguntasBunker siguientePregunta;

    @BeforeEach
    public void setUp() {

        gestorPreguntasBunker = mock(GestorPreguntasBunker.class);
        pregunta = mock(PreguntasBunker.class);
        siguientePregunta = mock(PreguntasBunker.class);
        logicaDelJuego = new LogicaDelJuego(gestorPreguntasBunker);
    }
    @Test
    public void testEsRespuestaCorrecta_RespuestaCorrecta() {

        when(gestorPreguntasBunker.obtenerPregunta("pregunta1")).thenReturn(pregunta);

        when(pregunta.esRespuestaCorrecta("respuestaCorrecta")).thenReturn(true);

        assertTrue(logicaDelJuego.esRespuestaCorrecta("pregunta1"
                , "respuestaCorrecta"));
    }

    @Test
    public void testEsRespuestaCorrecta_RespuestaIncorrecta() {

        when(gestorPreguntasBunker.obtenerPregunta("pregunta2")).thenReturn(pregunta);

        when(pregunta.esRespuestaCorrecta("respuestaIncorrecta")).thenReturn(false);

        assertFalse(logicaDelJuego.esRespuestaCorrecta("pregunta2"
                , "respuestaIncorrecta"));
    }

    @Test
    public void testObtenerSiguientePregunta_RespuestaValida() {

        when(gestorPreguntasBunker.obtenerPregunta("respuesta")).thenReturn(siguientePregunta);
        when(siguientePregunta.getClave()).thenReturn("siguientePregunta");

        assertEquals("siguientePregunta"
                , logicaDelJuego.obtenerSiguientePregunta("respuesta"));
    }

    @Test
    public void testObtenerSiguientePregunta_RespuestaInvalida() {

        when(gestorPreguntasBunker.obtenerPregunta("respuestaInvalida")).thenReturn(null);

        assertNull(logicaDelJuego.obtenerSiguientePregunta("respuestaInvalida"));
    }
}

