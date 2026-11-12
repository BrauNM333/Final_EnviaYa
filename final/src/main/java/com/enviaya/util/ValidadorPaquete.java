package com.enviaya.util;

public class ValidadorPaquete {

    private ValidadorPaquete() {
    }

    public static boolean esGuiaValida(String guia) {
        if (guia == null) {
            return false;
        }

        if (guia.length() != 6) {
            return false;
        }

        if (!guia.startsWith("EY")) {
            return false;
        }

        for (int i = 2; i < guia.length(); i++) {
            if (guia.charAt(i) < '0' || guia.charAt(i) > '9') {
                return false;
            }
        }

        return true;
    }

    public static boolean esPesoValido(double peso) {
        return Double.isFinite(peso) && peso > 0 && peso <= 20;
    }
}
