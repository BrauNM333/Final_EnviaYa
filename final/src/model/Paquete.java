package model;

import exceptions.GuiaInvalidaException;
import exceptions.PesoInvalidoException;
import exceptions.PesoMotoException;
import util.Validador;

public abstract class Paquete {

    private final String guia;
    private final double peso;
    private final Zona zona;

    public Paquete(String guia,double peso,Zona zona)
            throws GuiaInvalidaException,
            PesoInvalidoException,
            PesoMotoException {

        Validador.validarGuia(guia);
        Validador.validarPeso(peso);

        this.guia=guia;
        this.peso=peso;
        this.zona=zona;
    }

    public String getGuia(){
        return guia;
    }

    public double getPeso(){
        return peso;
    }

    public Zona getZona(){
        return zona;
    }

    public double calcularBase(){
        return zona.getTarifa()+(peso*1000);
    }

    public abstract double calcularCosto();

    public boolean esExpress(){
        return false;
    }

    @Override
    public boolean equals(Object obj){

        if(this==obj){
            return true;
        }

        if(obj==null || getClass()!=obj.getClass()){
            return false;
        }

        Paquete otro=(Paquete)obj;

        return guia.equals(otro.guia);
    }

    @Override
    public int hashCode(){
        return guia.hashCode();
    }

    @Override
    public String toString(){
        return guia+" | "+zona+" | "+peso+"kg";
    }
}
