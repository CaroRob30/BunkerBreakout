package com.JuegoBunkerBreakout.Juego.Configuracion.ConfigOpciones;

import java.util.HashMap;
import java.util.Map;

public class ConfiguracionOpciones {
    private final static Map<String, String[]> opciones = new HashMap<>();

    static {
        opciones.put("iniciar", new String[]{"Bajo las escaleras lentamente"
                , "Golpeo la puerta con fuerza"
                , "Abro la puerta con cuidado"
                , "No hago nada para escuchar algo más"});

        opciones.put("Abro la puerta con cuidado", new String[]{"Bajas las escaleras"
                , "Buscas algo en la habitación"
                , "Te quedas en la habitación"
                , "Gritas para que alguien te escuche"});

        opciones.put("Bajas las escaleras", new String[]{"Enciendes la linterna"
                , "Regresas a la habitación"
                , "Sigues caminando en la oscuridad"
                , "Sigues el ruido al final del pasillo"});

        opciones.put("Sigues el ruido al final del pasillo", new String[]{"Intentas forzar el candado"
                , "Regresas por donde viniste"
                , "Volteas a ver qué hay detrás de ti"
                , "Gritas para que alguien te escuche"});

        opciones.put("Volteas a ver qué hay detrás de ti", new String[]{"Regresas por donde viniste"
                , "Abres el armario"
                , "Sigues caminando en la oscuridad"
                , "Intentas seguir la sombra"});

        opciones.put("Abres el armario", new String[]{"Ignoras la voz y abres la caja fuerte"
                , "Volteas a ver quién te habla"
                , "Golpeas la puerta de metal"
                , "Gritas del miedo"});

        opciones.put("Ignoras la voz y abres la caja fuerte"
                , new String[]{"Vas a ver quien está pidiendo ayuda"
                        , "Lloras"
                        , "Avientas el diario"
                        , "Intentas abrir la puerta de metal con la llave"});

        opciones.put("Intentas abrir la puerta de metal con la llave"
                , new String[]{"Volteas a ver quién te habla"
                        , "Gritas del miedo"
                        , "Sales corriendo"
                        , "Regresas por donde viniste"});

        opciones.put("Sales corriendo", new String[]{});
    }

    public static Map<String, String[]> getOpciones() {
        return opciones;
    }
}
