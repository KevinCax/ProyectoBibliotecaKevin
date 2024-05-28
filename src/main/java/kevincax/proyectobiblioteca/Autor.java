package kevincax.proyectobiblioteca;

public class Autor {
    private String nombreYApellido;

    private String cui;

    public Autor(String nombre, String apellido, String cui) {
        this.nombreYApellido = nombre;
        this.cui = cui;
    }

    public String getNombre() {
        return nombreYApellido;
    }

    public void setNombre(String nombre) {
        this.nombreYApellido = nombre;
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
                "nombreYApellido='" + nombreYApellido + '\'' +
                ", cui='" + cui + '\'' +
                '}';
    }
}
