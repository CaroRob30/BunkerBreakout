package com.JuegoBunkerBreakout.Juego.Preguntas;

import com.JuegoBunkerBreakout.Juego.Configuracion.ConfigPreguntas.ConfiguracionPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.GestorPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.InicializadorPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.PreguntasBunker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InicializadorPreguntasBunkerTest {

    private GestorPreguntasBunker gestorPreguntasBunker;

    @BeforeEach
    void setUp() {
        gestorPreguntasBunker = new GestorPreguntasBunker();
        InicializadorPreguntasBunker.inicializar(gestorPreguntasBunker);
    }

    @Test
    void testInicializar_CargaCorrectaDePreguntas() {
        // Verificar que las preguntas se hayan agregado correctamente
        assertNotNull(gestorPreguntasBunker.obtenerPregunta("iniciar")
                , "La pregunta debería estar inicializada");

        assertNotNull(gestorPreguntasBunker.obtenerPregunta("Abro la puerta con cuidado")
                , "La pregunta debería estar inicializada");

        assertNotNull(gestorPreguntasBunker.obtenerPregunta("Bajas las escaleras")
                , "La pregunta debería estar inicializada");

        assertNotNull(gestorPreguntasBunker.obtenerPregunta("Sigues el ruido al final del pasillo")
                , "La pregunta debería estar inicializada");

        assertNotNull(gestorPreguntasBunker.obtenerPregunta("Volteas a ver qué hay detrás de ti")
                , "La pregunta debería estar inicializada");

        assertNotNull(gestorPreguntasBunker.obtenerPregunta("Abres el armario")
                , "La pregunta debería estar inicializada");

        assertNotNull(gestorPreguntasBunker.obtenerPregunta("Ignoras la voz y abres la caja fuerte")
                , "La pregunta debería estar inicializada");

        assertNotNull(gestorPreguntasBunker.obtenerPregunta("Intentas abrir la puerta de metal con la llave")
                , "La pregunta debería estar inicializada");

        assertNotNull(gestorPreguntasBunker.obtenerPregunta("Sales corriendo")
                , "La pregunta debería estar inicializada");
    }

    @Test
    void testInicializar_ContenidoCorrectoDePreguntas() {
        // Verificar que las preguntas tengan el contenido correcto
        PreguntasBunker pregunta = gestorPreguntasBunker.obtenerPregunta("iniciar");
        assertEquals(ConfiguracionPreguntasBunker.getPreguntas().get("iniciar")
                , pregunta.getTexto(), "El contenido de la pregunta no coincide");

        pregunta = gestorPreguntasBunker.obtenerPregunta("Abro la puerta con cuidado");
        assertEquals(ConfiguracionPreguntasBunker.getPreguntas().get("Abro la puerta con cuidado")
                , pregunta.getTexto(), "El contenido de la pregunta no coincide");

    }
}
