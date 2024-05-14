package kevincax.proyectobiblioteca;

import java.io.Serializable;
import java.sql.Date;

public class Libro implements Serializable {
    private String titulo;
    private String isbn;
    private java.sql.Date anio_publicacion;
    private int cantidad_disponible;
    private int editorial;
    private int autor;

    public Libro() {
        this.titulo = titulo;
        this.isbn = isbn;
        this.anio_publicacion = anio_publicacion;
        this.cantidad_disponible = cantidad_disponible;
        this.editorial = editorial;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getAnio_publicacion() {
        return anio_publicacion;
    }

    public void setAnio_publicacion(Date anio_publicacion) {
        this.anio_publicacion = anio_publicacion;
    }

    public int getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(int cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

    public int getEditorial() {
        return editorial;
    }

    public void setEditorial(int editorial) {
        this.editorial = editorial;
    }

    public int getAutor() {
        return autor;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", anio_publicacion=" + anio_publicacion +
                ", cantidad_disponible=" + cantidad_disponible +
                ", editorial=" + editorial +
                ", autor=" + autor +
                '}';
    }
}
