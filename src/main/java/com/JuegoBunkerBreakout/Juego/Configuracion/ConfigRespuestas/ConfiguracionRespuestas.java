package com.JuegoBunkerBreakout.Juego.Configuracion.ConfigRespuestas;

import java.util.HashMap;
import java.util.Map;

public class ConfiguracionRespuestas {

    private static final Map<String, String> respuestas = new HashMap<>();

    static {
        respuestas.put("iniciar", "Abro la puerta con cuidado");
        respuestas.put("Abro la puerta con cuidado", "Bajas las escaleras");
        respuestas.put("Bajas las escaleras", "Sigues el ruido al final del pasillo");
        respuestas.put("Sigues el ruido al final del pasillo", "Volteas a ver qué hay detrás de ti");
        respuestas.put("Volteas a ver qué hay detrás de ti", "Abres el armario");
        respuestas.put("Abres el armario", "Ignoras la voz y abres la caja fuerte");
        respuestas.put("Ignoras la voz y abres la caja fuerte", "Intentas abrir la puerta de metal con la llave");
        respuestas.put("Intentas abrir la puerta de metal con la llave", "Sales corriendo");
    }


    public static Map<String, String> getRespuestas () {
        return respuestas;
    }
}
