package com.JuegoBunkerBreakout.Juego.Preguntas;

import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.PreguntasBunker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/* Esta clase se encarga de verificar el funcionamiento de la clase PreguntasBunker.
La clase incluye varios métodos de prueba para asegurar que las instancias de PreguntasBunker
se creen y funcionen correctamente.
En testCrearPregunta, se crea una nueva pregunta con una clave, pregunta, opciones y una respuesta correcta,
y se validan todos los atributos mediante afirmaciones que comprueban que los valores asignados son correctos.
En esRespuestaCorrecta, evalúa si una respuesta dada es correcta o incorrecta.
La prueba testEsRespuestaCorrecta_Correcta verifica que la respuesta correcta se reconozca como válida,
mientras que testEsRespuestaCorrecta_Incorrecta comprueba que una respuesta no correcta se identifique
adecuadamente.
 */

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
        assertEquals(texto, pregunta.getPregunta(), "La pregunta de la pregunta coincide.");
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
