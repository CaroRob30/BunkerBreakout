package com.JuegoBunkerBreakout.Juego.Configuracion.ConfigPreguntas;

import java.util.HashMap;
import java.util.Map;

public class ConfiguracionPreguntasBunker {
    private static final String SALTO_LINEA_HTML = "<br>";
    private static final Map<String, String> preguntas = new HashMap<>();

    static {
        preguntas.put("iniciar", "Frente a ti hay una puerta con una manija bastante vieja."
                + SALTO_LINEA_HTML + "A tu izquierda, una escalera que desciende a lo que parece " +
                "ser un piso completamente oscuro." + SALTO_LINEA_HTML + "Algo dentro de ti te dice" +
                " que no estás solo." + SALTO_LINEA_HTML + "¿Qué haces?");

        preguntas.put("Abro la puerta con cuidado", "La puerta se abre rechinando, al interior te " +
                "encuentras con una habitación llena de polvo y escombros." + SALTO_LINEA_HTML +
                "En el centro de la habitación hay una mesa de madera y encima de ella " +
                "una grabadora antigua." + SALTO_LINEA_HTML + "Decides reproducir la grabadora " +
                "y una voz grave y distorsionada comienza a hablar." + SALTO_LINEA_HTML +
                " \"No hay salida. La única forma es bajando... sigue el ruido\"." + SALTO_LINEA_HTML +
                "Al terminar la grabación, escuchas un ruido proveniente de la escalera." +
                SALTO_LINEA_HTML + "¿Qué haces?");

        preguntas.put("Bajas las escaleras", "Bajas las escaleras con cuidado, cada paso que das," +
                " resuena en el silencio, al llegar abajo encuentras una linterna parpadeante"
                + SALTO_LINEA_HTML + "y lo que parece ser una nota manchada de sangre."
                + SALTO_LINEA_HTML + "La nota dice: \"No confíes en las sombras, no confíes en las voces.\""
                + SALTO_LINEA_HTML + "Al terminar de leer, escuchas un ruido proveniente " +
                "al final del pasillo." + SALTO_LINEA_HTML + "¿Qué haces?");

        preguntas.put("Sigues el ruido al final del pasillo", "Sigues el ruido al final del pasillo, " +
                "al llegar encuentras una puerta de metal con un candado oxidado." + SALTO_LINEA_HTML +
                "Al intentar abrirla, escuchas un ruido detrás de ti."
                + SALTO_LINEA_HTML + "¿Qué haces?");

        preguntas.put("Volteas a ver qué hay detrás de ti", "Volteas a ver qué hay detrás de ti, " +
                "al hacerlo, ves una sombra que se desvanece en la oscuridad." + SALTO_LINEA_HTML +
                "Logras ver que hay un armario." + SALTO_LINEA_HTML + "¿Qué haces?");

        preguntas.put("Abres el armario", "Abres el armario y encuentras una caja fuerte con un candado" +
                " que parece fácil de abrir, al intentar abrirlo, algo te susurra con voz rasposa "
                + SALTO_LINEA_HTML + "\"No la abras.\"" + SALTO_LINEA_HTML + "¿Qué haces?");

        preguntas.put("Ignoras la voz y abres la caja fuerte", "Ignoras la voz y abres la caja fuerte, " +
                "al hacerlo, encuentras un diario con la fecha de hoy." + SALTO_LINEA_HTML
                + "Al abrirlo, ves que la última página dice: \"No hay salida, solo la muerte...\" " +
                "y una llave ensangrentada." + SALTO_LINEA_HTML + "Al terminar de leer, escuchas que" +
                " alguien grita pidiendo ayuda." + SALTO_LINEA_HTML + "¿Qué haces?");

        preguntas.put("Intentas abrir la puerta de metal con la llave", "Logras abrir el candado de " +
                "la puerta de metal con la llave ensangrentada, te cuesta trabajo empujarla " +
                "para abrirla, pero lo logras." + SALTO_LINEA_HTML + "Al abrirla, escuchas " +
                "nuevamente la voz rasposa que te dice \"No hay salida, solo la muerte\""
                + SALTO_LINEA_HTML + "¿Qué haces?");

        preguntas.put("Sales corriendo", "");

    }

    public static Map<String, String> getPreguntas() {
        return preguntas;
    }
}
