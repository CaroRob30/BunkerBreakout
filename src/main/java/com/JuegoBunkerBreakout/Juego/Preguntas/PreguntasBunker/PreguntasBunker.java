
package com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker;

public class PreguntasBunker {
    private final String clave;
    private final String texto;
    private final String[] opciones;
    private final String respuestaCorrecta;

    public PreguntasBunker(String clave, String texto, String[] opciones, String respuestaCorrecta) {
        this.clave = clave;
        this.texto = texto;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getClave() {
        return clave;
    }

    public String getTexto() {
        return texto;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public boolean esRespuestaCorrecta(String respuesta) {
        return respuestaCorrecta.equals(respuesta);
    }
}
