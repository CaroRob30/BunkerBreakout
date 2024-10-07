

/* Esta interfaz nos va a permitir que en un futuro, si se desean agregar más escenarios con preguntas
al juego, se pueda realizar con facilidad.
Su función es la de agregar preguntas, obtener preguntas, obtener opciones,verificar si una respuesta
es correcta y obtener la siguiente pregunta.
 */

package com.JuegoBunkerBreakout.Juego.Preguntas;

import com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker.PreguntasBunker;

public interface Preguntas {

    void agregarPregunta(PreguntasBunker pregunta);

    PreguntasBunker obtenerPregunta(String clave);
}
