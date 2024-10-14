package com.JuegoBunkerBreakout.Controlador.GestionDelJuego;

import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.GestorPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.PreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Configuracion.ConfigUltimaPregunta.UltimaPreguntaBunker;

/*
Esta clase maneja la lógica interna del proceso del juego. Su función principal es determinar cuál es la
siguiente pregunta basándose en la respuesta del jugador utilizando el GestorPreguntasBunker.
También válida si una pregunta es la última del juego mediante el uso de la clase UltimaPreguntaBunker.
De esta manera, se controla el avance del jugador y asegura que siga la secuencia de preguntas hasta el final.
 */
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
