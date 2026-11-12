package model;

import exceptions.GuiaInvalidaException;
import exceptions.PesoInvalidoException;
import exceptions.PesoMotoException;

public class PaqueteEstandar extends Paquete {

    public PaqueteEstandar(String guia,double peso,Zona zona)
            throws GuiaInvalidaException,
            PesoInvalidoException,
            PesoMotoException {

        super(guia,peso,zona);
    }

    @Override
    public double calcularCosto(){
        return calcularBase();
    }
}