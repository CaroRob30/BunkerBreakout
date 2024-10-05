package com.JuegoBunkerBreakout.Juego.Configuracion.ConfigPreguntas;

import java.util.HashMap;
import java.util.Map;

public class ConfiguracionPreguntasBunker {
    private static final Map<String, String> preguntas = new HashMap<>();

    static {
        preguntas.put("iniciar", "Frente a ti hay una puerta con una vieja manija oxidada.\n" +
                "A tu izquierda, una escalera que desciende a lo que parece ser un piso completamente oscuro.\n" +
                "Algo dentro de ti te dice que no estás solo. ¿Qué haces?");

        preguntas.put("Abro la puerta con cuidado", "La puerta se abre rechinando, al interior te" +
                "encuentras con una habitación llena de polvo y escombros.\n" +
                "En el centro de la habitación hay una mesa de madera y encima de ella una grabadora antigua.\n" +
                "Decides ponerle play a la grabadora y una voz grave y distorsionada comienza a hablar.\n" +
                "'No hay salida. La única forma es abajo... sigue el ruido de las máquinas'.\n" +
                "Al terminar la grabación, escuchas un ruido proveniente de la escalera. ¿Qué haces?");

        preguntas.put("Bajas las escaleras", "Bajas las escaleras con cuidado, cada paso que das," +
                "resuena en el silencio, al llegar abajo" +
                "encuentras una linterna parpadeante y lo que parece ser una nota manchada de sangre.\n" +
                "La nota dice: 'No confíes en las sombras, no confíes en las voces'.\n" +
                "Al terminar de leer, escuchas un ruido proveniente al final del pasillo. ¿Qué haces?");

        preguntas.put("Sigues el ruido al final del pasillo", "Sigues el ruido al final del pasillo, " +
                "al llegar encuentras una puerta de metal con un candado oxidado.\n" +
                "Al intentar abrirla, escuchas un ruido detrás de ti. ¿Qué haces?");

        preguntas.put("Volteas a ver qué hay detrás de ti", "Volteas a ver qué hay detrás de ti, " +
                "al hacerlo, ves una sombra que se desvanece en la oscuridad.\n" +
                "Logras ver que hay un armario " +
                "¿Qué haces?");

        preguntas.put("Abres el armario", "Abres el armario y encuentras una caja fuerte con un candado.\n" +
                "Al intentar abrirla, algo te susurra con voz rasposa 'No la abras'. ¿Qué haces?");

        preguntas.put("Ignoras la voz y abres la caja fuerte", "Ignoras la voz y abres la caja fuerte, " +
                "al hacerlo, encuentras un diario con la fecha de hoy.\n" +
                "Al abrirlo, ves que la última página dice: 'No hay salida, solo la muerte'" +
                "y una llave ensangrentada.\n" +
                "Al terminar de leer, escuchas que alguien grita pidiendo ayuda. ¿Qué haces?");

        preguntas.put("Intentas abrir la puerta de metal con la llave", "Logras abrir el candado de la puerta " +
                "de metal con la llave ensangrentada, te cuesta trabajo empujarla para abrirla, pero lo logras.\n" +
                "Al abrirla, escuchas nuevamente la voz rasposa que te dice 'No hay salida, solo la muerte'.\n" +
                "¿Qué haces?");

        preguntas.put("Sales corriendo", "¡Felicidades, saliste finalmente del Bunker!, pero descubres que no" +
                "hay nada más que ruinas a tu alrededor....\n");

    }

    public static Map<String, String> getPreguntas() {
        return preguntas;
    }
}
