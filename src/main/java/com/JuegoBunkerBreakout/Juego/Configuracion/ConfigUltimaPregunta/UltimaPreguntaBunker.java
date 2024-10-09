package com.JuegoBunkerBreakout.Juego.Configuracion.ConfigUltimaPregunta;

public class UltimaPreguntaBunker {
    private static final String ULTIMA_PREGUNTA_BUNKER = "Sales corriendo";

    public boolean esUltimaPregunta(String clave) {
        return clave.equals(ULTIMA_PREGUNTA_BUNKER);
    }
}

