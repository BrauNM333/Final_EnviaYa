package com.enviaya.modelo;

import com.enviaya.excepciones.GuiaInvalidaException;
import com.enviaya.excepciones.PesoInvalidoException;

public class PaqueteEstandar extends Paquete {

    public PaqueteEstandar(String guia, double peso, Zona zona)
            throws GuiaInvalidaException, PesoInvalidoException {
        super(guia, peso, zona);
    }

    @Override
    public double calcularCostoEnvio() {
        return getCostoBase();
    }

    @Override
    public String getNombreServicio() {
        return "Estándar";
    }

    @Override
    public String getAjusteTexto() {
        return "-";
    }
}
