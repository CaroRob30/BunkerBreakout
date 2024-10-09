package com.JuegoBunkerBreakout.Controlador.GestionDelJuego;

import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.GestorPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.PreguntasBunker;

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


