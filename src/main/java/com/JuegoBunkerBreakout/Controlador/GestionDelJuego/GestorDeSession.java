package com.JuegoBunkerBreakout.Controlador.GestionDelJuego;

import jakarta.servlet.http.HttpSession;

/*
Esta clase gestiona los atributos de la sesión HTTP del jugador
Se encarga de almacenar y recuperar el nombre del jugador y la pregunta actual que se está presentando en el
juego. Además, permite establecer o eliminar un mensaje relacionado con el resultado del juego, como
ya sea si el jugador ha respondido correctamente o no.
Utiliza los métodos de la sesión HTTP para establecer y recuperar atributos, asegurando que la información
del jugador se mantenga a lo largo de la interaccción del juego.
 */
public class GestorDeSession {

    private final HttpSession session;

    public GestorDeSession(HttpSession sesion) {
        this.session = sesion;
    }

    public void setNombreDelJugador(String nombre) {
        session.setAttribute("nombreDelJugador", nombre);
    }

    public String getNombreDelJugador() {
        return (String) session.getAttribute("nombreDelJugador");
    }

    public void setPreguntaActual(String preguntaActual) {
        session.setAttribute("preguntaActual", preguntaActual);
    }

    public String getPreguntaActual() {
        return (String) session.getAttribute("preguntaActual");
    }

    public void setMensajeDelResultado(String mensaje) {
        session.setAttribute("mensajeDelResultado", mensaje);
    }

    public void removeMensajeDelResultado() {
        session.removeAttribute("mensajeDelResultado");
    }
}

