package com.enviaya.modelo;

import com.enviaya.excepciones.GuiaInvalidaException;
import com.enviaya.excepciones.PesoInvalidoException;
import com.enviaya.util.ValidadorPaquete;

public abstract class Paquete implements CostoCalculable {

    private final String guia;
    private final double peso;
    private final Zona zona;

    public Paquete(String guia, double peso, Zona zona)
            throws GuiaInvalidaException, PesoInvalidoException {

        if (!ValidadorPaquete.esGuiaValida(guia)) {
            throw new GuiaInvalidaException(
                    "La guía " + guia + " no es válida. Debe tener EY y cuatro números.");
        }

        if (!ValidadorPaquete.esPesoValido(peso)) {
            throw new PesoInvalidoException(
                    "El peso del paquete " + guia + " debe ser mayor que 0 y máximo 20 kg.");
        }

        if (zona == null) {
            throw new IllegalArgumentException("Debe indicar la zona del paquete " + guia + ".");
        }

        this.guia = guia;
        this.peso = peso;
        this.zona = zona;
    }

    public String getGuia() {
        return guia;
    }

    public double getPeso() {
        return peso;
    }

    public Zona getZona() {
        return zona;
    }

    public double getCostoBase() {
        return zona.getTarifa() + (peso * 1000);
    }

    public abstract String getNombreServicio();

    public abstract String getAjusteTexto();

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }
        if (!(objeto instanceof Paquete)) {
            return false;
        }

        Paquete otro = (Paquete) objeto;
        return guia.equals(otro.guia);
    }

    @Override
    public int hashCode() {
        return guia.hashCode();
    }

    @Override
    public String toString() {
        return "Guía: " + guia + ", servicio: " + getNombreServicio()
                + ", zona: " + zona.getNombre() + ", peso: " + peso + " kg";
    }
}
