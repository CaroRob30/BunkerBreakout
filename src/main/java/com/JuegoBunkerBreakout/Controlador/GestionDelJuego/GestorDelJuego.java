package com.JuegoBunkerBreakout.Controlador.GestionDelJuego;

import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.GestorPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.PreguntasBunker;
/*
Esta clase es la encargada de manejar la lógica principal del flujo del juego en BunkerBreakout.
Coordina la interacción entr el jugador, las preguntas y las respuestas, utilizando el GestorDeSession
y el ValidadorDeRespuestas.
Al iniciar el juego, almacena el nombre del jugador y establece la pregunta inicial. Además, valida
las respuestas del jugador a través del validador, verificando si son correctas con base a la pregunta
actualmente almacenada en la sesión.
También puede obtener la pregunta actual a través del GestorPreguntasBunker.
 */

public class GestorDelJuego {

    private final GestorDeSession gestorDeSesion;
    private final ValidadorDeRespuestas validadorDeRespuestas;

    public GestorDelJuego(LogicaDelJuego logicaJuego
            , GestorDeSession gestorDeSesion, GestorPreguntasBunker gestorPreguntasBunker) {

        this.gestorDeSesion = gestorDeSesion;
        this.validadorDeRespuestas = new ValidadorDeRespuestas(gestorPreguntasBunker, logicaJuego);
    }

    public void manejarInicioDelJuego(String nombreDelJugador) {

        gestorDeSesion.setNombreDelJugador(nombreDelJugador);
        gestorDeSesion.setPreguntaActual("iniciar");
        gestorDeSesion.removeMensajeDelResultado();
    }

    public boolean manejarRespuesta(String respuesta) {

        return validadorDeRespuestas.validarRespuesta(gestorDeSesion.getPreguntaActual()
                , respuesta, gestorDeSesion);
    }

    public PreguntasBunker obtenerPreguntaActual(GestorPreguntasBunker gestorPreguntasBunker) {

        String preguntaActualClave = gestorDeSesion.getPreguntaActual();
        return gestorPreguntasBunker.obtenerPregunta(preguntaActualClave);
    }
}


