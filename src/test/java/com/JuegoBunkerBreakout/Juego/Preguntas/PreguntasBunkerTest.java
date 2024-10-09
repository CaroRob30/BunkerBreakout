package com.JuegoBunkerBreakout.Juego.Preguntas;

import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.PreguntasBunker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PreguntasBunkerTest {

    @Test
    void testCrearPregunta() {
        String clave = "iniciar";
        String texto = "¿Qué deseas hacer?";
        String[] opciones = {"Abrir la puerta", "Esperar"};
        String respuestaCorrecta = "Abrir la puerta";
        boolean esRespuestacorrecta = true;

        PreguntasBunker pregunta = new PreguntasBunker(clave, texto, opciones, respuestaCorrecta);

        assertEquals(clave, pregunta.getClave(), "La clave de la pregunta coincide.");
        assertEquals(texto, pregunta.getTexto(), "La pregunta de la pregunta coincide.");
        assertArrayEquals(opciones, pregunta.getOpciones(), "Las opciones de la pregunta coinciden.");
        assertEquals(esRespuestacorrecta, pregunta.esRespuestaCorrecta(respuestaCorrecta)
                , "La respuesta correcta coincide.");
    }

    @Test
    void testEsRespuestaCorrecta_Correcta() {
        String clave = "iniciar";
        String texto = "¿Qué deseas hacer?";
        String[] opciones = {"Abrir la puerta", "Esperar"};
        String respuestaCorrecta = "Abrir la puerta";

        PreguntasBunker pregunta = new PreguntasBunker(clave, texto, opciones, respuestaCorrecta);

        assertTrue(pregunta.esRespuestaCorrecta("Abrir la puerta"), "La respuesta debería ser correcta.");
    }

    @Test
    void testEsRespuestaCorrecta_Incorrecta() {
        String clave = "iniciar";
        String texto = "¿Qué deseas hacer?";
        String[] opciones = {"Abrir la puerta", "Esperar"};
        String respuestaCorrecta = "Abrir la puerta";

        PreguntasBunker pregunta = new PreguntasBunker(clave, texto, opciones, respuestaCorrecta);

        assertFalse(pregunta.esRespuestaCorrecta("Esperar"), "La respuesta debería ser incorrecta.");
    }
}
