package com.enviaya.modelo;

import com.enviaya.excepciones.ContenidoFragilInvalidoException;
import com.enviaya.excepciones.GuiaInvalidaException;
import com.enviaya.excepciones.PesoInvalidoException;

public class PaqueteFragil extends Paquete implements ManejoEspecial {

    private final String contenido;

    public PaqueteFragil(String guia, double peso, Zona zona, String contenido)
            throws GuiaInvalidaException, PesoInvalidoException, ContenidoFragilInvalidoException {
        super(guia, peso, zona);

        if (contenido == null || contenido.trim().isEmpty()) {
            throw new ContenidoFragilInvalidoException(
                    "El paquete frágil " + guia + " debe indicar qué contiene.");
        }

        this.contenido = contenido.trim();
    }

    public String getContenido() {
        return contenido;
    }

    @Override
    public String obtenerAdvertencia() {
        return getGuia() + " - FRÁGIL (" + contenido + ")";
    }

    @Override
    public double calcularCostoEnvio() {
        return getCostoBase() + 5000;
    }

    @Override
    public String getNombreServicio() {
        return "Frágil (" + contenido + ")";
    }

    @Override
    public String getAjusteTexto() {
        return "+5.000";
    }
}
