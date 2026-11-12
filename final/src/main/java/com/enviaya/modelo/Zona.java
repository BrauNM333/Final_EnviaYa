package com.enviaya.modelo;

public enum Zona {
    CENTRO("Centro", 6000, 1),
    NORTE("Norte", 8000, 2),
    SUR("Sur", 8000, 3),
    ORIENTE("Oriente", 15000, 4);

    private final String nombre;
    private final double tarifa;
    private final int ordenRuta;

    Zona(String nombre, double tarifa, int ordenRuta) {
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.ordenRuta = ordenRuta;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTarifa() {
        return tarifa;
    }

    public int getOrdenRuta() {
        return ordenRuta;
    }
}
