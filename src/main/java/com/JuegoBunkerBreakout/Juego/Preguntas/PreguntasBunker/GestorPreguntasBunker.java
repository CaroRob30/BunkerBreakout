package com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker;

import com.JuegoBunkerBreakout.Juego.Preguntas.Preguntas;

import java.util.HashMap;
import java.util.Map;

public class GestorPreguntasBunker implements Preguntas {

    private final Map<String, PreguntasBunker> preguntas = new HashMap<>();

    @Override
    public void agregarPregunta(PreguntasBunker pregunta) {

        preguntas.put(pregunta.getClave(), pregunta);
    }

    @Override
    public PreguntasBunker obtenerPregunta(String clave) {

        return preguntas.get(clave);
    }
}
