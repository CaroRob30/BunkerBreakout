package com.JuegoBunkerBreakout.Juego.Configuracion;

import com.JuegoBunkerBreakout.Juego.Configuracion.ConfigOpciones.ConfiguracionOpciones;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
/* Esta clase se encarga de verificar el funcionamiento de la clase ConfiguracionOpciones.
testGetOpciones_ContieneClaves verifica que ciertas claves estén presentes en el mapa de opciones devuelto
por ConfiguracionOpciones.getOpciones().
testGetOpciones_DevuelveLosValoresCorrectos valida que las opciones asociadas a estas claves sean las
esperadas, asegurando que las respuestas posibles se correspondan con las definidas en la configuración.
testGetOpciones_VerificaCadenaVaciaEnUltimaPregunta verifica que la opción correspondiente a "Sales corriendo"
no tenga ninguna opción asociada, lo que indica que es una de las preguntas finales del juego.
 */

class ConfiguracionOpcionesTest {

    @Test
    void testGetOpciones_ContieneClaves() {

        Map<String, String[]> opciones = ConfiguracionOpciones.getOpciones();

        assertTrue(opciones.containsKey("iniciar"));
        assertTrue(opciones.containsKey("Abro la puerta con cuidado"));
        assertTrue(opciones.containsKey("Bajas las escaleras"));
        assertTrue(opciones.containsKey("Sales corriendo"));
    }

    @Test
    void testGetOpciones_DevuelveLosValoresCorrectos() {

        Map<String, String[]> opciones = ConfiguracionOpciones.getOpciones();

        String[] opcionesIniciar = opciones.get("iniciar");
        assertArrayEquals(new String[]{
                "Bajo las escaleras lentamente",
                "Golpeo la puerta con fuerza",
                "Abro la puerta con cuidado",
                "No hago nada para escuchar algo más"
        }, opcionesIniciar);

        String[] opcionesAbrePuerta = opciones.get("Abro la puerta con cuidado");
        assertArrayEquals(new String[]{
                "Bajas las escaleras",
                "Buscas algo en la habitación",
                "Te quedas en la habitación",
                "Gritas para que alguien te escuche"
        }, opcionesAbrePuerta);
    }

    @Test
    void testGetOpciones_VerificaCadenaVaciaEnUltimaPregunta() {

        Map<String, String[]> opciones = ConfiguracionOpciones.getOpciones();

        String[] opcionesSalesCorriendo = opciones.get("Sales corriendo");

        assertArrayEquals(new String[]{}, opcionesSalesCorriendo);
    }
}
