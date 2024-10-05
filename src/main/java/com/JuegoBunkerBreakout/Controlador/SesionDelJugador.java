package com.JuegoBunkerBreakout.Controlador;

import jakarta.servlet.http.HttpSession;

public class SesionDelJugador {

    private HttpSession session;

    public SesionDelJugador(HttpSession sesion) {
        this.session = sesion;
    }

    public String setNombreDelJugador(String nombre) {
        session.setAttribute("nombreDelJugador", nombre);
        return nombre;
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

