package kevincax.proyectobiblioteca;

import Controllers.BaseDeDatos.ConexionBaseDatos;

import java.io.Serializable;
import java.sql.Date;

public class Libro implements Serializable {
    private int idLibro;
    private String titulo;
    private Date anio_publicacion;
    private String isbn;
    private int cantidad_disponible;
    private int idAutor;
    private int idEditorial;

    public Libro() {
    }

    public Libro(int idLibro, String titulo, Date anio_publicacion, String isbn, int cantidad_disponible, int idAutor, int idEditorial) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.anio_publicacion = anio_publicacion;
        this.isbn = isbn;
        this.cantidad_disponible = cantidad_disponible;
        this.idAutor = idAutor;
        this.idEditorial = idEditorial;
    }

    public void CrearLibro() {
        String query = "INSERT INTO libro (titulo, fecha_publicacion, isbn, cantidad_stock, fkidautor, fkideditorial) VALUES ('"
                + titulo + "', '" + anio_publicacion + "', '" + isbn + "', " + cantidad_disponible + ", " + idAutor + ", " + idEditorial + ")";

        ConexionBaseDatos.ejecutarInsercion(query);

    }
}
