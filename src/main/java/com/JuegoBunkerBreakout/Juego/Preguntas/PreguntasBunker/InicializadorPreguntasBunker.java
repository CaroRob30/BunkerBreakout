package com.JuegoBunkerBreakout.Juego.Preguntas.PreguntasBunker;

import com.JuegoBunkerBreakout.Juego.Configuracion.ConfigOpciones.ConfiguracionOpciones;
import com.JuegoBunkerBreakout.Juego.Configuracion.ConfigPreguntas.ConfiguracionPreguntasBunker;
import com.JuegoBunkerBreakout.Juego.Configuracion.ConfigRespuestas.ConfiguracionRespuestasBunker;

public class InicializadorPreguntasBunker {

    public static void inicializar(GestorPreguntasBunker gestorPreguntasBunker) {

        gestorPreguntasBunker
                .agregarPregunta(new PreguntasBunker("iniciar",
                        ConfiguracionPreguntasBunker
                                .getPreguntas().get("iniciar"),
                        ConfiguracionOpciones
                                .getOpciones().get("iniciar"),
                        ConfiguracionRespuestasBunker
                                .getRespuestas().get("iniciar")));

        gestorPreguntasBunker
                .agregarPregunta(new PreguntasBunker("Abro la puerta con cuidado",
                        ConfiguracionPreguntasBunker
                                .getPreguntas().get("Abro la puerta con cuidado"),
                        ConfiguracionOpciones
                                .getOpciones().get("Abro la puerta con cuidado"),
                        ConfiguracionRespuestasBunker
                                .getRespuestas().get("Abro la puerta con cuidado")));

        gestorPreguntasBunker
                .agregarPregunta(new PreguntasBunker("Bajas las escaleras",
                        ConfiguracionPreguntasBunker
                                .getPreguntas().get("Bajas las escaleras"),
                        ConfiguracionOpciones
                                .getOpciones().get("Bajas las escaleras"),
                        ConfiguracionRespuestasBunker
                                .getRespuestas().get("Bajas las escaleras")));

        gestorPreguntasBunker
                .agregarPregunta(new PreguntasBunker("Sigues el ruido al final del pasillo",
                        ConfiguracionPreguntasBunker
                                .getPreguntas().get("Sigues el ruido al final del pasillo"),
                        ConfiguracionOpciones
                                .getOpciones().get("Sigues el ruido al final del pasillo"),
                        ConfiguracionRespuestasBunker
                                .getRespuestas().get("Sigues el ruido al final del pasillo")));

        gestorPreguntasBunker
                .agregarPregunta(new PreguntasBunker("Volteas a ver qué hay detrás de ti",
                        ConfiguracionPreguntasBunker
                                .getPreguntas().get("Volteas a ver qué hay detrás de ti"),
                        ConfiguracionOpciones
                                .getOpciones().get("Volteas a ver qué hay detrás de ti"),
                        ConfiguracionRespuestasBunker
                                .getRespuestas().get("Volteas a ver qué hay detrás de ti")));

        gestorPreguntasBunker
                .agregarPregunta(new PreguntasBunker("Abres el armario",
                        ConfiguracionPreguntasBunker
                                .getPreguntas().get("Abres el armario"),
                        ConfiguracionOpciones
                                .getOpciones().get("Abres el armario"),
                        ConfiguracionRespuestasBunker
                                .getRespuestas().get("Abres el armario")));

        gestorPreguntasBunker
                .agregarPregunta(new PreguntasBunker("Ignoras la voz y abres la caja fuerte",
                        ConfiguracionPreguntasBunker
                                .getPreguntas().get("Ignoras la voz y abres la caja fuerte"),
                        ConfiguracionOpciones
                                .getOpciones().get("Ignoras la voz y abres la caja fuerte"),
                        ConfiguracionRespuestasBunker
                                .getRespuestas().get("Ignoras la voz y abres la caja fuerte")));

        gestorPreguntasBunker
                .agregarPregunta(new PreguntasBunker("Intentas abrir la puerta de metal con la llave",
                        ConfiguracionPreguntasBunker
                                .getPreguntas().get("Intentas abrir la puerta de metal con la llave"),
                        ConfiguracionOpciones
                                .getOpciones().get("Intentas abrir la puerta de metal con la llave"),
                        ConfiguracionRespuestasBunker
                                .getRespuestas().get("Intentas abrir la puerta de metal con la llave")));

        gestorPreguntasBunker
                .agregarPregunta(new PreguntasBunker("Sales corriendo",
                        ConfiguracionPreguntasBunker
                                .getPreguntas().get("Sales corriendo"),
                        ConfiguracionOpciones
                                .getOpciones().get("Sales corriendo"),
                        ConfiguracionRespuestasBunker
                                .getRespuestas().get("Sales corriendo")));

    }
}