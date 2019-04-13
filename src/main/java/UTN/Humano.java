package UTN;

import java.util.Objects;

public class Humano {

    private String nombre;
    private Integer edad;
    private Integer Peso;
    private Float altura;
    private Float imc;
    private Integer ingerido;
    private Integer tolerancia;
    private Orinar IOrinar;
    private Beber IBeber;


    public Humano(String nombre, Integer edad, Integer peso, Float altura, Orinar orinar, Beber beber) {
        this.nombre = nombre;
        this.edad = edad;
        this.Peso = peso;
        this.altura = altura;
        this.imc = peso/(altura*altura);
        this.ingerido = 0;
        this.tolerancia = (edad * peso)/5;
        this.IOrinar = orinar;
        this.IBeber = beber;
    }

    public Integer getTolerancia() {
        return tolerancia;
    }

    public Integer getIngerido() {
        return ingerido;
    }

    public void setIngerido(Integer ingerido) {
        this.ingerido = ingerido;
    }

    public Float getImc() {
        return imc;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public UTN.Orinar getOrinar() {
        return IOrinar;
    }

    public UTN.Beber getBeber() {
        return IBeber;
    }

    @Override
    public String toString() {
        return nombre +
                ", Edad = " + edad +
                ", Peso = " + Peso +
                ", Altura = " + altura + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Humano)) return false;
        Humano humano = (Humano) o;
        return getNombre().equals(humano.getNombre()) &&
                getEdad().equals(humano.getEdad()) &&
                Peso.equals(humano.Peso) &&
                altura.equals(humano.altura) &&
                getImc().equals(humano.getImc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getEdad(), Peso, altura, getImc());
    }
}
