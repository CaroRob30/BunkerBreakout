package com.JuegoBunkerBreakout.Juego.Preguntas;

import com.JuegoBunkerBreakout.Juego.Configuracion.ConfigPreguntas.ConfiguracionPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.GestorPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.InicializadorPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.PreguntasBunker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/* Esta clase se encarga de verificar el funcionamiento de la clase InicializadorPreguntasBunker.
En setUp(), se crea una instancia del GestorPreguntasBunker y se llama inicializar() para cargar
las preguntas predeterminadas.
Las pruebas inlcuyen la verificación de que un conjunto específico de preguntas esté correctamente
inicializado y disponible en el gestor, asegurándose de que cada pregunta se pueda recuperar
y no sea null.
Se validan los contenidos de las preguntas, comprobando que coincidan con los valores esperados
de la configuración de preguntas, garantizando así que el proceso de inicialización funcione correctamente
y que las preguntas se configuren adecuadamente para su uso en el juego.
 */

class InicializadorPreguntasBunkerTest {

    private GestorPreguntasBunker gestorPreguntasBunker;

    @BeforeEach
    void setUp() {
        gestorPreguntasBunker = new GestorPreguntasBunker();
        InicializadorPreguntasBunker.inicializar(gestorPreguntasBunker);
    }

    @Test
    void testInicializar_CargaCorrectaDePreguntas() {

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

        PreguntasBunker pregunta = gestorPreguntasBunker.obtenerPregunta("iniciar");
        assertEquals(ConfiguracionPreguntasBunker.getPreguntas().get("iniciar")
                , pregunta.getPregunta(), "El contenido de la pregunta no coincide");

        pregunta = gestorPreguntasBunker.obtenerPregunta("Abro la puerta con cuidado");
        assertEquals(ConfiguracionPreguntasBunker.getPreguntas().get("Abro la puerta con cuidado")
                , pregunta.getPregunta(), "El contenido de la pregunta no coincide");

    }
}
