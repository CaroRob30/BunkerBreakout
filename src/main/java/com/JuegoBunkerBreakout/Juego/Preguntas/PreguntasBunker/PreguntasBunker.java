

/*Escena inicial:
Te despiertas en completa oscuridad, con un frío implacable que atraviesa tu piel.
 Al abrir los ojos, lo primero que ves es un techo de metal corroído y el débil parpadeo de una bombilla
 casi agotada. Un zumbido distante retumba por las paredes del bunker, y el aire es denso, pesado, cargado
 de humedad y desesperanza.

No recuerdas cómo llegaste aquí, ni cuánto tiempo ha pasado.
Solo sabes que estás en un lugar diseñado para proteger... o para retener.
A lo lejos, escuchas el eco de pasos, pero no puedes ver quién o qué está ahí.

Narración al jugador:
"Estás atrapado en un bunker que parece haber estado deshabitado por años,
pero la sensación de que algo o alguien te observa es ineludible.
 No hay señales claras de salida.
 Lo único que tienes es tu instinto y una serie de puertas, cada una con sus propios secretos y peligros.
  Algunas decisiones te acercarán a la libertad, pero otras te hundirán aún más en este laberinto de
  acero y locura."

Primera pregunta del juego:
Situación: La bombilla parpadea y se apaga por completo.
El único sonido es el de tu respiración acelerada.
 A ciegas, extiendes la mano y sientes la fría superficie de una puerta metálica frente a ti.
 El olor a óxido y humedad te golpea con fuerza.
*/
package com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker;

import com.JuegoBunkerBreakout.Juego.Configuracion.ConfigOpciones.ConfiguracionOpciones;
import com.JuegoBunkerBreakout.Juego.Configuracion.ConfigPreguntas.ConfiguracionPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Configuracion.ConfigRespuestas.ConfiguracionRespuestas;
import com.JuegoBunkerBreakout.Juego.Preguntas.Preguntas;

import java.util.HashMap;
import java.util.Map;

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
