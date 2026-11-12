package util;

import java.util.Comparator;
import model.Paquete;

public class OrdenEntregaComparator implements Comparator<Paquete> {

    @Override
    public int compare(Paquete p1, Paquete p2) {

        if (p1.esExpress() && !p2.esExpress()) {
            return -1;
        }

        if (!p1.esExpress() && p2.esExpress()) {
            return 1;
        }

        int zona = Integer.compare(
                p1.getZona().getOrdenRuta(),
                p2.getZona().getOrdenRuta());

        if (zona != 0) {
            return zona;
        }

        return p1.getGuia().compareTo(p2.getGuia());
    }
}