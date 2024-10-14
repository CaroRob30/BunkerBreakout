package com.JuegoBunkerBreakout.Juego.Configuracion.ConfigUltimaPregunta;

/*
Esta clase define y verifica cuál es la última pregunta del juego.
Contiene una constante que almacena la clave de la última pregunta.
esUltimaPregunta() verifica si la clave de la pregunta es la última, recibiendo una clave como argumento
y devuelve un valor booleano indicando si esa clave corresponde a la útlima pregunta.
 */
public class UltimaPreguntaBunker {
    private static final String ULTIMA_PREGUNTA_BUNKER = "Sales corriendo";

    public boolean esUltimaPregunta(String clave) {
        return clave.equals(ULTIMA_PREGUNTA_BUNKER);
    }
}

