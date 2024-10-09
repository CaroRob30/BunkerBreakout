package com.JuegoBunkerBreakout.Controlador.GestionDelJuego;

import jakarta.servlet.http.HttpSession;

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

