package com.JuegoBunkerBreakout.Controlador.GestionDelJuego;

import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.GestorPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.PreguntasBunker;

/*
Esta clase se encarga de validar las respuestas del jugador. Utiliza el GestorPreguntasBunker para
verificar si la respuesta seleccionada es la correcta. Si la respuesta es correcta, revisa si se trata
de la última pregunta del juego mediante LogicaDelJuego. Si aún no es la última pregunta, actualiza la
sesión con la siguiente pregunta, de lo contrario, el juego finaliza.
Si la respuesta es incorrecta, registra un mensaje de "Perdiste" en la sesión del jugador.
 */

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
