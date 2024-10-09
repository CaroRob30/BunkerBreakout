package com.JuegoBunkerBreakout.Juego.Preguntas;

import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.GestorPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.PreguntasBunker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class GestorPreguntasBunkerTest {

    private GestorPreguntasBunker gestor;
    private PreguntasBunker pregunta1;
    private PreguntasBunker pregunta2;

    @BeforeEach
    void setUp() {
        gestor = new GestorPreguntasBunker();

        pregunta1 = new PreguntasBunker("clave1"
                , "¿Qué harías en esta situación?", new String[]{"Opción 1", "Opción 2"}
                , "Opción 1");

        pregunta2 = new PreguntasBunker("clave2"
                , "¿Cuál es tu respuesta a esto?"
                , new String[]{"Respuesta 1", "Respuesta 2"}
                , "Respuesta 1");
    }

    @Test
    void testAgregarPregunta() {

        gestor.agregarPregunta(pregunta1);
        PreguntasBunker preguntaObtenida = gestor.obtenerPregunta("clave1");

        assertNotNull(preguntaObtenida, "La pregunta debería haber sido agregada");
        assertEquals("¿Qué harías en esta situación?", preguntaObtenida.getTexto(), "El contenido de la pregunta debe coincidir");
    }

    @Test
    void testObtenerPregunta_NoExistente() {

        PreguntasBunker preguntaObtenida = gestor.obtenerPregunta("claveInexistente");
        assertNull(preguntaObtenida, "La pregunta no existente debería devolver null");
    }

    @Test
    void testAgregarYObtenerMultiplesPreguntas() {

        gestor.agregarPregunta(pregunta1);
        gestor.agregarPregunta(pregunta2);

        PreguntasBunker preguntaObtenida1 = gestor.obtenerPregunta("clave1");
        PreguntasBunker preguntaObtenida2 = gestor.obtenerPregunta("clave2");

        assertNotNull(preguntaObtenida1, "La primera pregunta debería haber sido agregada");
        assertNotNull(preguntaObtenida2, "La segunda pregunta debería haber sido agregada");
        assertEquals("¿Qué harías en esta situación?"
                , preguntaObtenida1.getTexto()
                , "El contenido de la primera pregunta debe coincidir");

        assertEquals("¿Cuál es tu respuesta a esto?"
                , preguntaObtenida2.getTexto()
                , "El contenido de la segunda pregunta debe coincidir");
    }
}
