package com.enviaya;

import com.enviaya.excepciones.*;
import com.enviaya.modelo.*;

public class Main {

    public static void main(String[] args) throws MensajeroInvalidoException {
        probarCasoAndres();
        probarPaquetesInvalidos();
        probarCasoCamila();
        probarCasoMateo();
    }

    private static void probarCasoAndres() throws MensajeroInvalidoException {
        System.out.println("========== CASO 1: ANDRÉS ==========");
        ManifiestoObligatorio despacho = new ManifiestoObligatorio("Andrés");

        agregarEstandar(despacho, "EY2001", 5, Zona.ORIENTE);
        agregarExpress(despacho, "EY2002", 1.5, Zona.NORTE);
        agregarFragil(despacho, "EY2003", 2, Zona.CENTRO, "vajilla");
        agregarEstandar(despacho, "EY2004", 8, Zona.CENTRO);
        agregarExpress(despacho, "EY2005", 6, Zona.ORIENTE);
        agregarFragil(despacho, "EY2006", 3.5, Zona.SUR, "televisor");

        despacho.imprimirManifiesto();
    }

    private static void probarPaquetesInvalidos() {
        System.out.println("========== CASO 2: PAQUETES INVÁLIDOS ==========");

        try {
            new PaqueteEstandar("EY3001", -2, Zona.CENTRO);
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }

        try {
            new PaqueteFragil("EY3002", 2, Zona.NORTE, "");
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }

        try {
            new PaqueteEstandar("EY12A4", 3, Zona.SUR);
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }

        try {
            new PaqueteExpress("EY3003", 22, Zona.NORTE);
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }

        System.out.println();
    }

    private static void probarCasoCamila() throws MensajeroInvalidoException {
        System.out.println("========== CASO 3: CAMILA ==========");
        ManifiestoObligatorio despacho = new ManifiestoObligatorio("Camila");

        agregarEstandar(despacho, "EY4001", 12, Zona.CENTRO);
        agregarExpress(despacho, "EY4002", 10, Zona.SUR);
        agregarFragil(despacho, "EY4003", 9, Zona.NORTE, "espejo");
        agregarEstandar(despacho, "EY4004", 8, Zona.ORIENTE);

        despacho.imprimirManifiesto();
    }

    private static void probarCasoMateo() throws MensajeroInvalidoException {
        System.out.println("========== CASO 4: MATEO ==========");
        ManifiestoObligatorio despacho = new ManifiestoObligatorio("Mateo");

        agregarFragil(despacho, "EY5001", 3, Zona.SUR, "lámpara");
        agregarEstandar(despacho, "EY5001", 1, Zona.CENTRO);
        agregarExpress(despacho, "EY5002", 2, Zona.CENTRO);

        despacho.imprimirManifiesto();
    }

    private static void agregarEstandar(ManifiestoObligatorio despacho,
            String guia, double peso, Zona zona) {
        try {
            Paquete paquete = new PaqueteEstandar(guia, peso, zona);
            despacho.agregarPaquete(paquete);
        } catch (Exception error) {
            System.out.println("Error con " + guia + ": " + error.getMessage());
        }
    }

    private static void agregarExpress(ManifiestoObligatorio despacho,
            String guia, double peso, Zona zona) {
        try {
            Paquete paquete = new PaqueteExpress(guia, peso, zona);
            despacho.agregarPaquete(paquete);
        } catch (Exception error) {
            System.out.println("Error con " + guia + ": " + error.getMessage());
        }
    }

    private static void agregarFragil(ManifiestoObligatorio despacho,
            String guia, double peso, Zona zona, String contenido) {
        try {
            Paquete paquete = new PaqueteFragil(guia, peso, zona, contenido);
            despacho.agregarPaquete(paquete);
        } catch (Exception error) {
            System.out.println("Error con " + guia + ": " + error.getMessage());
        }
    }
}
