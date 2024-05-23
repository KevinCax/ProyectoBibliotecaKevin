package kevincax.proyectobiblioteca;

import Controllers.BaseDeDatos.ConexionBaseDatos;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Libro implements Serializable {
    private String titulo;
    private String isbn;
    private Date anio_publicacion;
    private int cantidad_disponible;
    private int idEditorial;
    private int idAutor;

    public Libro() {

    }

    public Libro(String titulo, String isbn) {
        this.titulo = titulo;
        this.isbn = isbn;
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

    public int getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(int idEditorial) {
        this.idEditorial = idEditorial;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", anio_publicacion=" + anio_publicacion +
                ", cantidad_disponible=" + cantidad_disponible +
                ", idEditorial=" + idEditorial +
                ", idAutor=" + idAutor +
                '}';
    }

    public ArrayList<Libro> obtenerLibros() throws SQLException {
        String obtenerSQL = "SELECT * FROM libro";
        ArrayList<Libro> libros = new  ArrayList<Libro>();
        Statement conexion = ConexionBaseDatos.BaseDatos().createStatement();
        ResultSet queryResult = conexion.executeQuery(obtenerSQL);

        while (queryResult.next()){
            Libro libro = new Libro();
            libro.setTitulo(queryResult.getString(1));
            libro.setIsbn(queryResult.getString(2));
            libro.setAnio_publicacion(queryResult.getDate(3));
            libro.setCantidad_disponible(queryResult.getInt(4));
            libro.setIdEditorial(queryResult.getInt(5));
            libro.setIdAutor(queryResult.getInt(6));

            libros.add(libro);
        }
        return libros;
    }
}
