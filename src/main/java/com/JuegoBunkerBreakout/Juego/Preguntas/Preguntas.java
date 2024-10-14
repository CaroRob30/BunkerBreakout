
/*
Esta interfaz establece una plantilla para la gestión de preguntas en el juego, lo que permite la
incorporación sencilla de nuevos escenarios con preguntas en el futuro. Inlcuye métodos que permiten
añadir preguntas y recuperar una pregunta específica a partir de una clave.
Al implementar esta interfaz, las clases asociadas garantizan el cumplimiento de estas funcionalidades,
lo que favorece la flexibilidad y el mantenimiento del código al manejar las preguntas dentro del juego.
 */

package com.JuegoBunkerBreakout.Juego.Preguntas;

import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.PreguntasBunker;

public interface Preguntas {

    void agregarPregunta(PreguntasBunker pregunta);

    PreguntasBunker obtenerPregunta(String clave);
}
