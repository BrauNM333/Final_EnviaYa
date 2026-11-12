package com.enviaya.modelo;

import com.enviaya.excepciones.GuiaInvalidaException;
import com.enviaya.excepciones.PesoInvalidoException;

public class PaqueteExpress extends Paquete {

    public PaqueteExpress(String guia, double peso, Zona zona)
            throws GuiaInvalidaException, PesoInvalidoException {
        super(guia, peso, zona);
    }

    @Override
    public double calcularCostoEnvio() {
        return getCostoBase() * 1.5;
    }

    @Override
    public String getNombreServicio() {
        return "Express";
    }

    @Override
    public String getAjusteTexto() {
        return "+50%";
    }
}
