package model;

import exceptions.ContenidoFragilException;
import exceptions.GuiaInvalidaException;
import exceptions.PesoInvalidoException;
import exceptions.PesoMotoException;
import interfaces.ManejoEspecial;
import util.Validador;

public class PaqueteFragil extends Paquete implements ManejoEspecial {

    private final String contenido;

    public PaqueteFragil(
            String guia,
            double peso,
            Zona zona,
            String contenido)
            throws GuiaInvalidaException,
            PesoInvalidoException,
            PesoMotoException,
            ContenidoFragilException {

        super(guia,peso,zona);

        Validador.validarContenido(contenido);

        this.contenido=contenido;
    }

    public String getContenido(){
        return contenido;
    }

    @Override
    public double calcularCosto(){
        return calcularBase()+5000;
    }

    @Override
    public String getAdvertencia(){
        return getGuia()+" - FRAGIL ("+contenido+")";
    }
}