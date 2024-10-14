package com.JuegoBunkerBreakout.Controlador.GestionDelJuego;

import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.GestorPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.PreguntasBunker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/*Este test  verifica el comportamiento de la clase GestorDelJuego, que gestiona la lógica del juego.
 En la configuración inicial, se crean objetos simulados (mocks) para GestorDeSession y
 GestorPreguntasBunker, lo que permite simular su comportamiento sin necesidad de implementar la lógica real.
 Se prueban dos métodos: primero, manejarInicio, que verifica que al iniciar el juego se establece
 correctamente el nombre del jugador, la pregunta actual y se elimina cualquier mensaje del resultado en
 la sesión.
 obtenerPreguntaActual, que comprueba que al solicitar la pregunta actual se retorna correctamente
 la instancia de PreguntasBunker esperada, utilizando la clave de la pregunta.
 Estas pruebas aseguran que la lógica del juego se maneje correctamente en estos escenarios.
 */

class GestorDelJuegoTest {

    private GestorDeSession gestorDeSesion;
    private GestorPreguntasBunker gestorPreguntasBunker;
    private GestorDelJuego gestorDelJuego;

    @BeforeEach
    void setUp() {
        gestorDeSesion = mock(GestorDeSession.class);
        gestorPreguntasBunker = mock(GestorPreguntasBunker.class);
        gestorDelJuego = new GestorDelJuego(mock(LogicaDelJuego.class)
                , gestorDeSesion, mock(GestorPreguntasBunker.class));
    }

    @Test
    void testManejarInicioDelJuego() {
        String nombreDelJugador = "Jugador1";

        gestorDelJuego.manejarInicioDelJuego(nombreDelJugador);

        verify(gestorDeSesion).setNombreDelJugador(nombreDelJugador);
        verify(gestorDeSesion).setPreguntaActual("iniciar");
        verify(gestorDeSesion).removeMensajeDelResultado();
    }

    @Test
    void testObtenerPreguntaActual() {
        String preguntaActualClave = "iniciar";
        when(gestorDeSesion.getPreguntaActual()).thenReturn(preguntaActualClave);

        PreguntasBunker pregunta = new PreguntasBunker(preguntaActualClave,
                "¿Pregunta?", new String[]{"opcion1", "opcion2"}
                , "respuesta_correcta");

        when(gestorPreguntasBunker.obtenerPregunta(preguntaActualClave)).thenReturn(pregunta);

        PreguntasBunker resultado = gestorDelJuego.obtenerPreguntaActual(gestorPreguntasBunker);

        assertEquals(pregunta, resultado);
    }
}
