package com.JuegoBunkerBreakout.Juego.Preguntas;

import com.JuegoBunkerBreakout.Juego.Configuracion.ConfigUltimaPregunta.UltimaPreguntaBunker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/* Esta clase se encarga de verificar el funcionamiento de la clase UltimaPreguntaBunker.
La clase incluye varios métodos de prueba que verifican el comportamiento de esUltimaPregunta.
En testEsUltimaPregunta_True, se comprueba que la clave "Sales corriendo" sea reconocida como la última
pregunta, mientras que en testEsUltimaPregunta_False, se verifica que la clave "Bajas las escaleras" no lo sea.
De igual manera se inlcuyen pruebas para manejar entradas vacías y nulas, como
tesEsUltimaPreguntaCadenaVacia, que asegura que una cadena vacía no sea reconocida como una última pregunta, y
testEsUltimaPregunta_Null, que comprueba que pasar un valor nulo genere una excepción NullPointerException.
*/

class UltimaPreguntaBunkerTest {

    @Test
    void testEsUltimaPregunta_True() {
        UltimaPreguntaBunker ultimaPregunta = new UltimaPreguntaBunker();
        String clave = "Sales corriendo";

        assertTrue(ultimaPregunta.esUltimaPregunta(clave),
                "La clave debería ser reconocida como la última pregunta.");
    }

    @Test
    void testEsUltimaPregunta_False() {
        UltimaPreguntaBunker ultimaPregunta = new UltimaPreguntaBunker();
        String clave = "Bajas las escaleras";

        assertFalse(ultimaPregunta.esUltimaPregunta(clave),
                "La clave no debería ser reconocida como la última pregunta.");
    }

    @Test
    void testEsUltimaPregunta_CadenaVacia() {
        UltimaPreguntaBunker ultimaPregunta = new UltimaPreguntaBunker();
        String clave = "";

        assertFalse(ultimaPregunta.esUltimaPregunta(clave),
                "Una clave vacía no debería ser reconocida como la última pregunta.");
    }

    @Test
    void testEsUltimaPregunta_Null() {
        UltimaPreguntaBunker ultimaPregunta = new UltimaPreguntaBunker();

        assertThrows(NullPointerException.class, ()
                        -> ultimaPregunta.esUltimaPregunta(null)
                , "Pasar una clave nula debería lanzar una NullPointerException.");
    }
}
