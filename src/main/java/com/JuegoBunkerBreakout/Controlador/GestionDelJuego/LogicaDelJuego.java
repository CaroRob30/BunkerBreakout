package com.JuegoBunkerBreakout.Controlador.GestionDelJuego;

import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.GestorPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.PreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Configuracion.ConfigUltimaPregunta.UltimaPreguntaBunker;

public class LogicaDelJuego {

    private final GestorPreguntasBunker gestorPreguntasBunker;
    private final UltimaPreguntaBunker ultimaPreguntaBunker;

    public LogicaDelJuego(GestorPreguntasBunker gestorPreguntasBunker) {

        this.gestorPreguntasBunker = gestorPreguntasBunker;
        this.ultimaPreguntaBunker = new UltimaPreguntaBunker();
    }

    public String obtenerSiguientePregunta(String respuesta) {

        PreguntasBunker siguientePregunta = gestorPreguntasBunker.obtenerPregunta(respuesta);
        return siguientePregunta != null ? siguientePregunta.getClave() : null;
    }

    public boolean esUltimaPregunta(String clave) {
        return ultimaPreguntaBunker.esUltimaPregunta(clave);
    }
}
