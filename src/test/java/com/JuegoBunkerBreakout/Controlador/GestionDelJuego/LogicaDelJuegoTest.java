package com.JuegoBunkerBreakout.Controlador.GestionDelJuego;

import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.GestorPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.PreguntasBunker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;
/* Esta clase se encarga de hacer las pruebas de la clase LogicaDelJuego.
Se utiliza Mockito para simular el comportamiento de la clase GestorPreguntasBunker, y así poder probar
los métodos de la clase LogicaDelJuego de forma aislada.
La clase incluye dos pruebas: una para verificar que se obtenga la siguiente pregunta correctamente
cuando se proporciona una respuesta válida, y otra para verificar que no se obtenga ninguna pregunta
cuando se proporciona una respuesta inválida.
 */

public class LogicaDelJuegoTest {

    private GestorPreguntasBunker gestorPreguntasBunker;
    private LogicaDelJuego logicaDelJuego;
    private PreguntasBunker siguientePregunta;

    @BeforeEach
    public void setUp() {

        gestorPreguntasBunker = mock(GestorPreguntasBunker.class);
        siguientePregunta = mock(PreguntasBunker.class);
        logicaDelJuego = new LogicaDelJuego(gestorPreguntasBunker);
    }

    @Test
    public void testObtenerSiguientePregunta_RespuestaValida() {

        when(gestorPreguntasBunker.obtenerPregunta("respuesta")).thenReturn(siguientePregunta);
        when(siguientePregunta.getClave()).thenReturn("siguientePregunta");

        assertEquals("siguientePregunta"
                , logicaDelJuego.obtenerSiguientePregunta("respuesta"));
    }

    @Test
    public void testObtenerSiguientePregunta_RespuestaInvalida() {

        when(gestorPreguntasBunker.obtenerPregunta("respuestaInvalida")).thenReturn(null);

        assertNull(logicaDelJuego.obtenerSiguientePregunta("respuestaInvalida"));
    }
}

