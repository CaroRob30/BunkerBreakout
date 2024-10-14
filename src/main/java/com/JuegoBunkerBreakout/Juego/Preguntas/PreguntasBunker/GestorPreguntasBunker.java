package com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker;

import com.JuegoBunkerBreakout.Juego.Preguntas.Preguntas;

import java.util.HashMap;
import java.util.Map;

/*
Esta clase implementa la interfaz Preguntas y se encargad e gestionar un conjunto de preguntas del juego.
Utiliza un mapa para almacenar intancias de PreguntasBunker, donde la clave es la identificación única de cada
pregunta.
agregarPregunta() añade una pregunta al mapa y obtenerPregunta() permite recuperar una
pregunta específica a partir de su clave.
Esta clase facilita la organización y el acceso a las preguntas del juego.
 */

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
