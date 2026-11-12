package model;

public enum Zona {

    CENTRO(6000),
    NORTE(8000),
    SUR(8000),
    ORIENTE(15000);

    private final double tarifa;

    Zona(double tarifa){
        this.tarifa=tarifa;
    }

    public double getTarifa(){
        return tarifa;
    }

    public int getOrdenRuta(){
        switch(this){
            case CENTRO:return 1;
            case NORTE:return 2;
            case SUR:return 3;
            default:return 4;
        }
    }
}