package kevincax.proyectobiblioteca;

import Controllers.BaseDeDatos.ConexionBaseDatos;

import java.io.Serializable;

public class Editorial implements Serializable {


    private String nombre_editorial;
    private String ubicacion;
    private String ciudad_ubicacion;

    public Editorial(String nombre_editorial, String ubicacion, String ciudad_ubicacion) {
        this.nombre_editorial = nombre_editorial;
        this.ubicacion = ubicacion;
        this.ciudad_ubicacion = ciudad_ubicacion;
    }

    public String getNombre_editorial() {
        return nombre_editorial;
    }

    public void setNombre_editorial(String nombre_editorial) {
        this.nombre_editorial = nombre_editorial;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCiudad_ubicacion() {
        return ciudad_ubicacion;
    }

    public void setCiudad_ubicacion(String ciudad_ubicacion) {
        this.ciudad_ubicacion = ciudad_ubicacion;
    }

    @Override
    public String toString() {
        return "Editorial{" +
                "nombre_editorial='" + nombre_editorial + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", ciudad_ubicacion='" + ciudad_ubicacion + '\'' +
                '}';
    }
}
