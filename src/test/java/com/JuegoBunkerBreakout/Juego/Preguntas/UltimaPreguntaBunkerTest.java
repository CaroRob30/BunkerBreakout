package com.JuegoBunkerBreakout.Juego.Preguntas;

import com.JuegoBunkerBreakout.Juego.Configuracion.ConfigUltimaPregunta.UltimaPreguntaBunker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
    void testEsUltimaPregunta_EmptyString() {
        UltimaPreguntaBunker ultimaPregunta = new UltimaPreguntaBunker();
        String clave = "";

        assertFalse(ultimaPregunta.esUltimaPregunta(clave),
                "Una clave vacía no debería ser reconocida como la última pregunta.");
    }

    @Test
    void testEsUltimaPregunta_Null() {
        UltimaPreguntaBunker ultimaPregunta = new UltimaPreguntaBunker();

        assertThrows(NullPointerException.class, () -> {
            ultimaPregunta.esUltimaPregunta(null);
        }, "Pasar una clave nula debería lanzar una NullPointerException.");
    }
}
