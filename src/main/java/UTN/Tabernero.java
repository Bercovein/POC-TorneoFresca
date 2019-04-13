package UTN;

import java.util.Objects;

public class Tabernero extends Humano {

    private Integer BebedorProfesional;
    private Float ToleranciaExtra;

    public Tabernero(String nombre, Integer edad, Integer peso, Float altura, Orinar orinar, Beber beber) {
        super(nombre, edad, peso, altura, orinar, beber);
        BebedorProfesional = peso/(edad*2);
        ToleranciaExtra = (peso*altura/2);
    }

    public Integer getBebedorProfesional() {
        return BebedorProfesional;
    }


    public Float getToleranciaExtra() {
        return ToleranciaExtra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tabernero tabernero = (Tabernero) o;
        return Objects.equals(BebedorProfesional, tabernero.BebedorProfesional) &&
                Objects.equals(ToleranciaExtra, tabernero.ToleranciaExtra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(BebedorProfesional, ToleranciaExtra);
    }


}
