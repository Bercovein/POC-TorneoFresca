package UTN;

import java.util.Objects;

public class Espartano extends Humano {

    private Float ToleranciaExtra;

    public Espartano(String nombre, Integer edad, Integer peso,Float altura, Orinar orinar, Beber beber) {
        super(nombre, edad, peso, altura, orinar, beber);
        ToleranciaExtra = (peso*altura/2);
    }

    public Float getToleranciaExtra() {
        return ToleranciaExtra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Espartano)) return false;
        Espartano espartano = (Espartano) o;
        return Objects.equals(getToleranciaExtra(), espartano.getToleranciaExtra());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getToleranciaExtra());
    }


}
