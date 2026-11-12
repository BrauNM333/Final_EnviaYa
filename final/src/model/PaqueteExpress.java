package model;

import exceptions.GuiaInvalidaException;
import exceptions.PesoInvalidoException;
import exceptions.PesoMotoException;

public class PaqueteExpress extends Paquete {

    public PaqueteExpress(String guia,double peso,Zona zona)
            throws GuiaInvalidaException,
            PesoInvalidoException,
            PesoMotoException {

        super(guia,peso,zona);
    }

    @Override
    public double calcularCosto(){
        return calcularBase()*1.5;
    }

    @Override
    public boolean esExpress(){
        return true;
    }
}