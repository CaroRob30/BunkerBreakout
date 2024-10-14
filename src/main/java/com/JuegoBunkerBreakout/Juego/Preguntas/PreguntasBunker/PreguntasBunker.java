
package com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker;

/*
Esta clase representa una pregunta dentro del juego Bunker Breakout, encapsulando los detalles necesarios
para su funcionamiento. Cada instancia de esta clase contiene una clave, el texto de la pregunta, un arreglo
de opciones posibles y la respuesta correcta. A través de su constructor, se inicializan estos atributos.
La clase proporciona métodos para acceder a la clave, el texto de la pregunta, y las opciones diponibles.
Además esResponsaCorrecta() permite verificar si la respuesta seleccionada coincide con la respuesta correcta,
lo que facilita la evaluación de las respuestas del jugador.
 */

public class PreguntasBunker {
    private final String clave;
    private final String pregunta;
    private final String[] opciones;
    private final String respuestaCorrecta;

    public PreguntasBunker(String clave, String pregunta, String[] opciones, String respuestaCorrecta) {
        this.clave = clave;
        this.pregunta = pregunta;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getClave() {
        return clave;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public boolean esRespuestaCorrecta(String respuesta) {
        return respuestaCorrecta.equals(respuesta);
    }
}
