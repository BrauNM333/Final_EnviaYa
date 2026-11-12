package util;

import exceptions.ContenidoFragilException;
import exceptions.GuiaInvalidaException;
import exceptions.PesoInvalidoException;
import exceptions.PesoMotoException;

public final class Validador {

    private Validador() {
    }

    public static void validarGuia(String guia)
            throws GuiaInvalidaException {

        if (!guia.matches("EY\\d{4}")) {
            throw new GuiaInvalidaException(
                    "Guia invalida: " + guia);
        }
    }

    public static void validarPeso(double peso)
            throws PesoInvalidoException, PesoMotoException {

        if (peso <= 0) {
            throw new PesoInvalidoException(
                    "Peso invalido: " + peso);
        }

        if (peso > 20) {
            throw new PesoMotoException(
                    "Peso supera limite permitido: " + peso);
        }
    }

    public static void validarContenido(String contenido)
            throws ContenidoFragilException {

        if (contenido == null || contenido.trim().isEmpty()) {
            throw new ContenidoFragilException(
                    "Contenido obligatorio para paquete fragil");
        }
    }
}