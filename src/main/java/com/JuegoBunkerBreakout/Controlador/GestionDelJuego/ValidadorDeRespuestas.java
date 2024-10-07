package com.JuegoBunkerBreakout.Controlador.GestionDelJuego;

public class ValidadorDeRespuestas {

    private final LogicaDelJuego logicaDelJuego;

    public ValidadorDeRespuestas(LogicaDelJuego logicaDelJuego) {
        this.logicaDelJuego = logicaDelJuego;
    }

    public boolean validarRespuesta(String preguntaActualClave
            , String respuesta, GestorDeSession gestorDeSesion) {

        if (logicaDelJuego.esRespuestaCorrecta(preguntaActualClave, respuesta)) {
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
