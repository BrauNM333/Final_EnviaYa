package model;

import exceptions.GuiaDuplicadaException;
import interfaces.ManejoEspecial;
import util.OrdenEntregaComparator;

import java.util.ArrayList;
import java.util.List;

public class Despacho {

    private static int consecutivo = 1;

    private final String codigo;
    private final String mensajero;
    private final List<Paquete> paquetes;

    public Despacho(String mensajero) {
        this.codigo = "D-" + consecutivo++;
        this.mensajero = mensajero;
        this.paquetes = new ArrayList<>();
    }

    public void agregarPaquete(Paquete paquete)
            throws GuiaDuplicadaException {

        for (Paquete p : paquetes) {

            if (p.getGuia().equals(paquete.getGuia())) {

                throw new GuiaDuplicadaException(
                        "La guia " + paquete.getGuia()
                                + " ya existe en el despacho");
            }
        }

        double nuevoPeso =
                getPesoTotal() + paquete.getPeso();

        if (nuevoPeso > 30) {

            System.out.println(
                    "No se agrego el paquete "
                            + paquete.getGuia()
                            + " porque supera los 30 kg");

            return;
        }

        paquetes.add(paquete);
    }

    public double getPesoTotal() {

        double total = 0;

        for (Paquete paquete : paquetes) {
            total += paquete.getPeso();
        }

        return total;
    }

    public double getCostoTotal() {

        double total = 0;

        for (Paquete paquete : paquetes) {
            total += paquete.calcularCosto();
        }

        return total;
    }

    public void imprimirManifiesto() {

        System.out.println();
        System.out.println("==============");
        System.out.println("DESPACHO " + codigo);
        System.out.println("Mensajero: " + mensajero);
        System.out.println("==============");

        List<Paquete> ordenados =
                new ArrayList<>(paquetes);

        ordenados.sort(
                new OrdenEntregaComparator());

        for (Paquete paquete : ordenados) {

            System.out.println(
                    paquete.getGuia()
                            + " | "
                            + paquete.getZona()
                            + " | $"
                            + (int) paquete.calcularCosto());
        }

        System.out.println();
        System.out.println(
                "Peso total: "
                        + getPesoTotal()
                        + " kg");

        System.out.println(
                "Costo total del despacho: $"
                        + (int) getCostoTotal());

        System.out.println();
        System.out.println("Advertencias:");

        boolean hayAdvertencias = false;

        for (Paquete paquete : ordenados) {

            if (paquete instanceof ManejoEspecial) {

                ManejoEspecial especial =
                        (ManejoEspecial) paquete;

                System.out.println(
                        especial.getAdvertencia());

                hayAdvertencias = true;
            }
        }

        if (!hayAdvertencias) {
            System.out.println("Ninguna");
        }

        System.out.println();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensajero() {
        return mensajero;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }
}