package com.JuegoBunkerBreakout.Controlador.GestionDelJuego;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ValidadorDeRespuestasTest {

    private LogicaDelJuego logicaDelJuego;
    private GestorDeSession gestorDeSesion;
    private ValidadorDeRespuestas validadorDeRespuestas;

    @BeforeEach
    void setUp() {
        logicaDelJuego = mock(LogicaDelJuego.class);
        gestorDeSesion = mock(GestorDeSession.class);
        validadorDeRespuestas = new ValidadorDeRespuestas(logicaDelJuego);
    }

    @Test
    void testValidarRespuesta_Correcta_Con_PreguntaSiguiente() {
        String preguntaActualClave = "pregunta1";
        String respuesta = "respuestaCorrecta";
        String siguientePreguntaClave = "pregunta2";

        when(logicaDelJuego.esRespuestaCorrecta(preguntaActualClave, respuesta)).thenReturn(true);
        when(logicaDelJuego.esUltimaPregunta(preguntaActualClave)).thenReturn(false);
        when(logicaDelJuego.obtenerSiguientePregunta(respuesta)).thenReturn(siguientePreguntaClave);

        boolean resultado = validadorDeRespuestas.validarRespuesta(preguntaActualClave
                , respuesta, gestorDeSesion);

        assertTrue(resultado);
        verify(gestorDeSesion).setPreguntaActual(siguientePreguntaClave);
    }

    @Test
    void testValidarRespuesta_Correcta_UltimaPregunta() {
        String preguntaActualClave = "pregunta1";
        String respuesta = "respuestaCorrecta";

        when(logicaDelJuego.esRespuestaCorrecta(preguntaActualClave, respuesta)).thenReturn(true);
        when(logicaDelJuego.esUltimaPregunta(preguntaActualClave)).thenReturn(true);

        boolean resultado = validadorDeRespuestas.validarRespuesta(preguntaActualClave
                , respuesta, gestorDeSesion);

        assertFalse(resultado);
    }

    @Test
    void testValidarRespuesta_Incorrecta() {
        String preguntaActualClave = "pregunta1";
        String respuesta = "respuestaIncorrecta";

        when(logicaDelJuego.esRespuestaCorrecta(preguntaActualClave, respuesta)).thenReturn(false);

        boolean resultado = validadorDeRespuestas.validarRespuesta(preguntaActualClave
                , respuesta, gestorDeSesion);

        assertFalse(resultado);
        verify(gestorDeSesion).setMensajeDelResultado("Perdiste. Respuesta incorrecta.");
    }
}
