package com.JuegoBunkerBreakout.Juego.Configuracion;

import com.JuegoBunkerBreakout.Juego.Configuracion.ConfigPreguntas.ConfiguracionPreguntasBunker;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/* Esta clase se encarga de verificar el funcionamiento de la clase ConfiguracionPreguntasBunker.
testGetPreguntas_DevuelveMapaNoNulo comprueba que el mapa de preguntas devuelto por
ConfiguracionPreguntasBunker.getPreguntas() no sea nulo.
testGetPreguntas_TieneElementos asegura que el mapa no esté vacío.
testGetPreguntas_ContienePreguntaIniciar valida que el mapa contenga la clave "iniciar".
testGetPreguntas_ContieneRespuestaCorrecta verifica que la respuesta asociada a la clave "iniciar" sea
la esperada, asegurando que la descripción inicial del juego esté correctamente definida.
testGetPreguntas_ClaveInexistenteDevuelveNulo garantiza que al solicitar una clave que no existe en el mapa,
se devuelva null.
 */

class ConfiguracionPreguntasBunkerTest {

    @Test
    void testGetPreguntas_DevuelveMapaNoNulo() {

        Map<String, String> preguntas = ConfiguracionPreguntasBunker.getPreguntas();
        assertNotNull(preguntas, "El mapa de preguntas no debe ser nulo");
    }

    @Test
    void testGetPreguntas_TieneElementos() {

        Map<String, String> preguntas = ConfiguracionPreguntasBunker.getPreguntas();
        assertFalse(preguntas.isEmpty(), "El mapa de preguntas debe contener elementos");
    }

    @Test
    void testGetPreguntas_ContienePreguntaIniciar() {

        Map<String, String> preguntas = ConfiguracionPreguntasBunker.getPreguntas();
        assertTrue(preguntas.containsKey("iniciar")
                , "El mapa de preguntas debe contener la clave 'iniciar'");
    }

    @Test
    void testGetPreguntas_ContieneRespuestaCorrecta() {

        Map<String, String> preguntas = ConfiguracionPreguntasBunker.getPreguntas();
        String respuesta = preguntas.get("iniciar");
        assertEquals("Frente a ti hay una puerta con una vieja manija oxidada.\n" +
                "A tu izquierda, una escalera que desciende a lo que parece ser un piso completamente oscuro.\n" +
                "Algo dentro de ti te dice que no estás solo. ¿Qué haces?", respuesta);
    }

    @Test
    void testGetPreguntas_ClaveInexistenteDevuelveNulo() {

        Map<String, String> preguntas = ConfiguracionPreguntasBunker.getPreguntas();
        assertNull(preguntas.get("claveInexistente"), "Una clave inexistente debe devolver null");
    }
}
