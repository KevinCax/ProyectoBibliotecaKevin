package kevincax.proyectobiblioteca;

public class Autor {
    private String nombre;
    private String apellido;
    private String cui;

    public Autor(String nombre, String apellido, String cui) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cui = cui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cui='" + cui + '\'' +
                '}';
    }
}
