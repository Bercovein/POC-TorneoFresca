package UTN;

import java.util.Objects;

public class Vikingo extends Humano {

    private int BebedorProfesional;

    public Vikingo(String nombre,
                   Integer edad,
                   Integer peso,
                   Float altura,
                   Orinar orinar,
                   Beber beber) {
        super(nombre, edad, peso, altura, orinar, beber);
        BebedorProfesional = peso/(edad*2);
    }

    public int getBebedorProfesional() {
        return BebedorProfesional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vikingo)) return false;
        Vikingo vikingo = (Vikingo) o;
        return Objects.equals(getBebedorProfesional(), vikingo.getBebedorProfesional());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBebedorProfesional());
    }
}
