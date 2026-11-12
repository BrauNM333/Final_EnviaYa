package main;

import exceptions.*;
import model.*;
import util.Validador;

public class Main {

    public static void main(String[] args){

        caso1();
        caso2();
        caso3();
        caso4();
    }

    private static void caso1(){

        try{

            Despacho despacho=
                    new Despacho("Andres");

            despacho.agregarPaquete(
                    new PaqueteEstandar(
                            "EY2001",5,Zona.ORIENTE));

            despacho.agregarPaquete(
                    new PaqueteExpress(
                            "EY2002",1.5,Zona.NORTE));

            despacho.agregarPaquete(
                    new PaqueteFragil(
                            "EY2003",2,
                            Zona.CENTRO,
                            "vajilla"));

            despacho.agregarPaquete(
                    new PaqueteEstandar(
                            "EY2004",8,
                            Zona.CENTRO));

            despacho.agregarPaquete(
                    new PaqueteExpress(
                            "EY2005",6,
                            Zona.ORIENTE));

            despacho.agregarPaquete(
                    new PaqueteFragil(
                            "EY2006",3.5,
                            Zona.SUR,
                            "televisor"));

            despacho.imprimirManifiesto();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void caso2(){

        crearEstandar(
                "EY3001",-2,Zona.CENTRO);

        crearFragil(
                "EY3002",2,
                Zona.NORTE,"");

        crearEstandar(
                "EY12A4",3,Zona.SUR);

        crearExpress(
                "EY3003",22,Zona.NORTE);
    }

    private static void caso3(){

        try{

            Despacho despacho=
                    new Despacho("Camila");

            despacho.agregarPaquete(
                    new PaqueteEstandar(
                            "EY4001",12,
                            Zona.CENTRO));

            despacho.agregarPaquete(
                    new PaqueteExpress(
                            "EY4002",10,
                            Zona.SUR));

            despacho.agregarPaquete(
                    new PaqueteFragil(
                            "EY4003",9,
                            Zona.NORTE,
                            "espejo"));

            despacho.agregarPaquete(
                    new PaqueteEstandar(
                            "EY4004",8,
                            Zona.ORIENTE));

            despacho.imprimirManifiesto();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void caso4(){

        try{

            Despacho despacho=
                    new Despacho("Mateo");

            despacho.agregarPaquete(
                    new PaqueteFragil(
                            "EY5001",3,
                            Zona.SUR,
                            "lampara"));

            despacho.agregarPaquete(
                    new PaqueteEstandar(
                            "EY5001",1,
                            Zona.CENTRO));

            despacho.agregarPaquete(
                    new PaqueteExpress(
                            "EY5002",2,
                            Zona.CENTRO));

            despacho.imprimirManifiesto();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void crearEstandar(
            String guia,
            double peso,
            Zona zona){

        try{

            Validador.validarGuia(guia);
            Validador.validarPeso(peso);

            new PaqueteEstandar(
                    guia,peso,zona);

        }catch(Exception e){
            System.out.println(
                    e.getMessage()+
                            " | "+guia);
        }
    }

    private static void crearExpress(
            String guia,
            double peso,
            Zona zona){

        try{

            Validador.validarGuia(guia);
            Validador.validarPeso(peso);

            new PaqueteExpress(
                    guia,peso,zona);

        }catch(Exception e){
            System.out.println(
                    e.getMessage()+
                            " | "+guia);
        }
    }

    private static void crearFragil(
            String guia,
            double peso,
            Zona zona,
            String contenido){

        try{

            Validador.validarGuia(guia);
            Validador.validarPeso(peso);
            Validador.validarContenido(contenido);

            new PaqueteFragil(
                    guia,peso,
                    zona,contenido);

        }catch(Exception e){
            System.out.println(
                    e.getMessage()+
                            " | "+guia);
        }
    }
}