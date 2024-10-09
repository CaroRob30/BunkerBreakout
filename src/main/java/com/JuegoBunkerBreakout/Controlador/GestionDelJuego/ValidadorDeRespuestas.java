package com.JuegoBunkerBreakout.Controlador.GestionDelJuego;

import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.GestorPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.PreguntasBunker;

public class ValidadorDeRespuestas {

    private final GestorPreguntasBunker gestorPreguntasBunker;
    private final LogicaDelJuego logicaDelJuego;

    public ValidadorDeRespuestas(GestorPreguntasBunker gestorPreguntasBunker
            , LogicaDelJuego logicaDelJuego) {

        this.gestorPreguntasBunker = gestorPreguntasBunker;
        this.logicaDelJuego = logicaDelJuego;
    }

    public boolean esRespuestaCorrecta(String preguntaClave, String respuesta) {

        PreguntasBunker pregunta = gestorPreguntasBunker.obtenerPregunta(preguntaClave);
        return pregunta.esRespuestaCorrecta(respuesta);
    }

    public boolean validarRespuesta(String preguntaActualClave
            , String respuesta, GestorDeSession gestorDeSesion) {

        if (esRespuestaCorrecta(preguntaActualClave, respuesta)) {
            if (logicaDelJuego.esUltimaPregunta(preguntaActualClave)) {
                return false;
            }
            String siguientePreguntaClave = logicaDelJuego.obtenerSiguientePregunta(respuesta);
            gestorDeSesion.setPreguntaActual(siguientePreguntaClave);
            return true;
        } else {
            gestorDeSesion.setMensajeDelResultado("Perdiste. Respuesta incorrecta.");
            return false;
        }
    }
}
