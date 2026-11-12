package com.enviaya.modelo;

import com.enviaya.excepciones.ExcesoPesoDespachoException;
import com.enviaya.excepciones.GuiaDuplicadaException;
import com.enviaya.excepciones.MensajeroInvalidoException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class ManifiestoObligatorio {

    private static int contadorDespachos = 0;
    private static final double PESO_MAXIMO = 30;

    private final String codigo;
    private final String mensajero;
    private final List<Paquete> paquetes;

    public ManifiestoObligatorio(String mensajero) throws MensajeroInvalidoException {
        if (mensajero == null || mensajero.trim().isEmpty()) {
            throw new MensajeroInvalidoException("Debe escribir el nombre del mensajero.");
        }

        this.mensajero = mensajero.trim();
        contadorDespachos++;
        this.codigo = "D-" + contadorDespachos;
        this.paquetes = new ArrayList<Paquete>();
    }

    public void agregarPaquete(Paquete paquete)
            throws GuiaDuplicadaException, ExcesoPesoDespachoException {
        if (paquete == null) {
            throw new IllegalArgumentException("No se puede agregar un paquete vacío.");
        }

        for (Paquete registrado : paquetes) {
            if (registrado.getGuia().equals(paquete.getGuia())) {
                throw new GuiaDuplicadaException(
                        "La guía " + paquete.getGuia() + " ya está registrada en " + codigo + ".");
            }
        }

        double pesoNuevo = calcularPesoTotal() + paquete.getPeso();
        if (pesoNuevo > PESO_MAXIMO) {
            throw new ExcesoPesoDespachoException(
                    "No se agregó " + paquete.getGuia() + ". El despacho quedaría con "
                    + String.format(Locale.forLanguageTag("es-CO"), "%.1f", pesoNuevo)
                    + " kg y el máximo es 30 kg.");
        }

        paquetes.add(paquete);
    }

    public double calcularPesoTotal() {
        double total = 0;
        for (Paquete paquete : paquetes) {
            total = total + paquete.getPeso();
        }
        return total;
    }

    public double liquidarRutaObligatoria() {
        double total = 0;
        for (Paquete paquete : paquetes) {
            total = total + paquete.calcularCostoEnvio();
        }
        return total;
    }

    private void ordenarPaquetes() {
        Collections.sort(paquetes, new Comparator<Paquete>() {
            @Override
            public int compare(Paquete primero, Paquete segundo) {
                int prioridadPrimero = 1;
                int prioridadSegundo = 1;

                if (primero instanceof PaqueteExpress) {
                    prioridadPrimero = 0;
                }
                if (segundo instanceof PaqueteExpress) {
                    prioridadSegundo = 0;
                }

                if (prioridadPrimero != prioridadSegundo) {
                    return prioridadPrimero - prioridadSegundo;
                }

                if (primero.getZona().getOrdenRuta() != segundo.getZona().getOrdenRuta()) {
                    return primero.getZona().getOrdenRuta() - segundo.getZona().getOrdenRuta();
                }

                return primero.getGuia().compareTo(segundo.getGuia());
            }
        });
    }

    public void imprimirManifiesto() {
        ordenarPaquetes();

        System.out.println("Despacho " + codigo + " - Mensajero: " + mensajero);
        System.out.printf("%-9s %-24s %-10s %-10s %-13s %-9s %-13s%n",
                "Guía", "Servicio", "Zona", "Peso", "Costo base", "Ajuste", "Costo envío");

        List<String> advertencias = new ArrayList<String>();

        for (Paquete paquete : paquetes) {
            System.out.printf(Locale.forLanguageTag("es-CO"),
                    "%-9s %-24s %-10s %6.1f kg %13s %-9s %13s%n",
                    paquete.getGuia(), paquete.getNombreServicio(), paquete.getZona().getNombre(),
                    paquete.getPeso(), moneda(paquete.getCostoBase()), paquete.getAjusteTexto(),
                    moneda(paquete.calcularCostoEnvio()));

            if (paquete instanceof ManejoEspecial) {
                ManejoEspecial especial = (ManejoEspecial) paquete;
                advertencias.add(especial.obtenerAdvertencia());
            }
        }

        System.out.printf(Locale.forLanguageTag("es-CO"),
                "Peso total: %.1f kg | Costo total: %s%n",
                calcularPesoTotal(), moneda(liquidarRutaObligatoria()));

        if (advertencias.isEmpty()) {
            System.out.println("Advertencias: Ninguna");
        } else {
            System.out.println("Advertencias: " + String.join(" | ", advertencias));
        }

        System.out.println();
    }

    private String moneda(double valor) {
        return "$" + String.format(Locale.forLanguageTag("es-CO"), "%,.0f", valor);
    }
}
