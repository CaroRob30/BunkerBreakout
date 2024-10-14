package com.JuegoBunkerBreakout.Juego.Configuracion;

import com.JuegoBunkerBreakout.Juego.Configuracion.ConfigRespuestas.ConfiguracionRespuestasBunker;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/* Esta clase se encarga de verificar el funcionamiento de la clase ConfiguracionRespuestasBunker.
La clase incluye varios métodos de prueba para asegurar que las instancias de ConfiguracionRespuestasBunker
se creen y funcionen correctamente.
En testGetRespuestas_DevuelveMapaNoNulo, se verifica que el mapa de respuestas devuelto por
ConfiguracionRespuestasBunker.getRespuestas() no sea nulo.
En testGetRespuestas_TieneElementos, se asegura que el mapa contenga elementos.
En testGetRespuestas_ContieneRespuestaIniciar, se comprueba que el mapa incluya la clave "iniciar".
En testGetRespuestas_ContieneRespuestaCorrecta, se valida que la respuesta asociada a la clave "iniciar" sea
"Abro la puerta con cuidado".
Por último, en testGetRespuestas_ClaveInexistenteDevuelveNulo, se garantiza que al buscar una clave que no
existe en el mapa, se devuelva null.
 */
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
