package com.JuegoBunkerBreakout.Controlador.GestionDelJuego;

import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.GestorPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.PreguntasBunker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ValidadorDeRespuestasTest {

    private GestorPreguntasBunker gestorPreguntasBunker;
    private LogicaDelJuego logicaDelJuego;
    private GestorDeSession gestorDeSesion;
    private ValidadorDeRespuestas validadorDeRespuestas;
    private PreguntasBunker pregunta;

    @BeforeEach
    void setUp() {
        gestorPreguntasBunker = mock(GestorPreguntasBunker.class);
        logicaDelJuego = mock(LogicaDelJuego.class);
        gestorDeSesion = mock(GestorDeSession.class);
        validadorDeRespuestas = new ValidadorDeRespuestas(gestorPreguntasBunker, logicaDelJuego);
        pregunta = mock(PreguntasBunker.class);
    }

    @Test
    void testEsRespuestaCorrecta_Correcta() {
        String preguntaClave = "pregunta1";
        String respuesta = "respuestaCorrecta";

        when(gestorPreguntasBunker.obtenerPregunta(preguntaClave)).thenReturn(pregunta);
        when(pregunta.esRespuestaCorrecta(respuesta)).thenReturn(true);

        boolean resultado = validadorDeRespuestas.esRespuestaCorrecta(preguntaClave, respuesta);

        assertTrue(resultado);
        verify(gestorPreguntasBunker).obtenerPregunta(preguntaClave);
        verify(pregunta).esRespuestaCorrecta(respuesta);
    }

    @Test
    void testEsRespuestaCorrecta_Incorrecta() {
        String preguntaClave = "pregunta1";
        String respuesta = "respuestaIncorrecta";

        when(gestorPreguntasBunker.obtenerPregunta(preguntaClave)).thenReturn(pregunta);
        when(pregunta.esRespuestaCorrecta(respuesta)).thenReturn(false);

        boolean resultado = validadorDeRespuestas.esRespuestaCorrecta(preguntaClave, respuesta);

        assertFalse(resultado);
        verify(gestorPreguntasBunker).obtenerPregunta(preguntaClave);
        verify(pregunta).esRespuestaCorrecta(respuesta);
    }

    @Test
    void testValidarRespuesta_Correcta_ConSiguientePregunta() {
        String preguntaActualClave = "pregunta1";
        String respuesta = "respuestaCorrecta";
        String siguientePreguntaClave = "pregunta2";

        when(gestorPreguntasBunker.obtenerPregunta(preguntaActualClave)).thenReturn(pregunta);
        when(pregunta.esRespuestaCorrecta(respuesta)).thenReturn(true);
        when(logicaDelJuego.esUltimaPregunta(preguntaActualClave)).thenReturn(false);
        when(logicaDelJuego.obtenerSiguientePregunta(respuesta)).thenReturn(siguientePreguntaClave);

        boolean resultado = validadorDeRespuestas.validarRespuesta(preguntaActualClave, respuesta, gestorDeSesion);

        assertTrue(resultado);
        verify(gestorDeSesion).setPreguntaActual(siguientePreguntaClave);
    }

    @Test
    void testValidarRespuesta_Correcta_UltimaPregunta() {
        String preguntaActualClave = "pregunta1";
        String respuesta = "respuestaCorrecta";

        when(gestorPreguntasBunker.obtenerPregunta(preguntaActualClave)).thenReturn(pregunta);
        when(pregunta.esRespuestaCorrecta(respuesta)).thenReturn(true);
        when(logicaDelJuego.esUltimaPregunta(preguntaActualClave)).thenReturn(true);

        boolean resultado = validadorDeRespuestas
                .validarRespuesta(preguntaActualClave, respuesta, gestorDeSesion);

        assertFalse(resultado);
    }

    @Test
    void testValidarRespuesta_Incorrecta() {
        String preguntaActualClave = "pregunta1";
        String respuesta = "respuestaIncorrecta";

        when(gestorPreguntasBunker.obtenerPregunta(preguntaActualClave)).thenReturn(pregunta);
        when(pregunta.esRespuestaCorrecta(respuesta)).thenReturn(false);

        boolean resultado = validadorDeRespuestas
                .validarRespuesta(preguntaActualClave, respuesta, gestorDeSesion);

        assertFalse(resultado);
        verify(gestorDeSesion).setMensajeDelResultado("Perdiste. Respuesta incorrecta.");
    }
}
