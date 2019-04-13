package UTN;

public class Pinta {

    private String nombre;
    private float graduacion;

    public Pinta(String nombre, float graduacion) {
        this.nombre = nombre;
        this.graduacion = graduacion;
    }

    public String getNombre() {
        return nombre;
    }


    public float getGraduacion() {
        return graduacion;
    }

    @Override
    public String toString() {
        return nombre + ", graduacion=" + graduacion + ", ";
    }
}
