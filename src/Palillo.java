public class Palillo {
    protected String nombre;
    protected boolean disponible;

    public Palillo(String nombre) {
        this.nombre = nombre;
        this.disponible = true;
    }

    @Override
    public String toString() {
        return
                "nombre='" + nombre + '\'' +
                ", disponible=" + disponible +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
