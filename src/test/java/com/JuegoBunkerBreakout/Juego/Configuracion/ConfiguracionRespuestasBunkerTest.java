package com.JuegoBunkerBreakout.Juego.Configuracion;

import com.JuegoBunkerBreakout.Juego.Configuracion.ConfigRespuestas.ConfiguracionRespuestasBunker;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ConfiguracionRespuestasBunkerTest {

    @Test
    void testGetRespuestas_DevuelveMapaNoNulo() {

        Map<String, String> respuestas = ConfiguracionRespuestasBunker.getRespuestas();
        assertNotNull(respuestas, "El mapa de respuestas no debe ser nulo");
    }

    @Test
    void testGetRespuestas_TieneElementos() {

        Map<String, String> respuestas = ConfiguracionRespuestasBunker.getRespuestas();
        assertFalse(respuestas.isEmpty(), "El mapa de respuestas debe contener elementos");
    }

    @Test
    void testGetRespuestas_ContieneRespuestaIniciar() {

        Map<String, String> respuestas = ConfiguracionRespuestasBunker.getRespuestas();
        assertTrue(respuestas.containsKey("iniciar"), "El mapa de respuestas debe contener la clave 'iniciar'");
    }

    @Test
    void testGetRespuestas_ContieneRespuestaCorrecta() {

        Map<String, String> respuestas = ConfiguracionRespuestasBunker.getRespuestas();
        String respuesta = respuestas.get("iniciar");
        assertEquals("Abro la puerta con cuidado", respuesta, "La respuesta a 'iniciar' debe ser 'Abro la puerta con cuidado'");
    }

    @Test
    void testGetRespuestas_ClaveInexistenteDevuelveNulo() {

        Map<String, String> respuestas = ConfiguracionRespuestasBunker.getRespuestas();
        assertNull(respuestas.get("claveInexistente"), "Una clave inexistente debe devolver null");
    }
}
