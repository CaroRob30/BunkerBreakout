package com.JuegoBunkerBreakout.Controlador;

import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.GestorPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.PreguntasBunker;

public class LogicaDelJuego {
    private final GestorPreguntasBunker gestorPreguntasBunker;

    public LogicaDelJuego(GestorPreguntasBunker gestorPreguntasBunker) {
        this.gestorPreguntasBunker = gestorPreguntasBunker;
    }

    public boolean esRespuestaCorrecta(String preguntaClave, String respuesta) {
        PreguntasBunker pregunta = gestorPreguntasBunker.obtenerPregunta(preguntaClave);
        return pregunta.esRespuestaCorrecta(respuesta);
    }

    public String obtenerSiguientePregunta(String respuesta) {
        PreguntasBunker siguientePregunta = gestorPreguntasBunker.obtenerPregunta(respuesta);
        return siguientePregunta != null ? siguientePregunta.getClave() : null;
    }
}