package kevincax.proyectobiblioteca;

import Controllers.BaseDeDatos.ConexionBaseDatos;
import Controllers.Controladores.StageInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import static kevincax.proyectobiblioteca.HelloApplication.llenarCombo;


public class PrestarLibro  implements StageInterface {

    private Stage stage;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize() {
        ConexionBaseDatos objetoConexion = new ConexionBaseDatos();
        inicializarLibros();
        cantidadListL();
    }

    private void cantidadListL() {
        llenarCombo(cantidadPrestada, cantidadListL);
    }

    ObservableList<String> cantidadListL = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

    @FXML
    private TextField ingresarCui;
    @FXML
    private ComboBox<String> cantidadPrestada;
    @FXML
    private TextField fechaPrestamo;
    @FXML
    private TextField fechaDevolucion;

    @FXML
    private ComboBox<Libro> escogerLibro;

    public void prestarLibro() {
        String cui = ingresarCui.getText();
        Libro libro = escogerLibro.getValue();
        String cant_libros_prestados = cantidadPrestada.getValue();
        String fecha_prestamo = fechaPrestamo.getText();
        String fecha_devolucion = fechaDevolucion.getText();

        if (libro == null || fecha_prestamo == null || fecha_devolucion == null) {
            showAlert("Alerta", "Debe seleccionar un libro y las fechas de préstamo y devolución.");
            return;
        }


        String prestarLibros = "INSERT INTO prestamo (cui, isbn, fecha_prestamo, fecha_devolucion, cant_libros_prestados) VALUES ('"
                + cui + "','" + libro.getIsbn() + "','" + fecha_prestamo + "', '" + fecha_devolucion + "', '" + cant_libros_prestados + "')";

        try {
            Statement statement = ConexionBaseDatos.BaseDatos().createStatement();
            statement.executeUpdate(prestarLibros);
            actualizarDisponibilidadLibro(libro.getIsbn(), cant_libros_prestados);
            showAlert("Mensaje", "¡Préstamo Realizado!");
        } catch (SQLException e) {
            showAlert("Alerta", "No se agregaron los datos");
        }
    }

    private void actualizarDisponibilidadLibro(String isbn, String cantidadPrestada) {
        String actualizarLibro = "UPDATE libro SET cantidad_disponible = cantidad_disponible - " + cantidadPrestada + " WHERE isbn = '" + isbn + "'";
        try {
            Statement statement = ConexionBaseDatos.BaseDatos().createStatement();
            statement.executeUpdate(actualizarLibro);
        } catch (SQLException e) {
            showAlert("Alerta", "No se pudo actualizar la disponibilidad del libro.");
        }
    }

    public void cancelarPrestamo() {
        HelloApplication LI = new HelloApplication();
        LI.muestraVentana(stage, "Pantalla-usuario.fxml");
    }

    private void inicializarLibros() {
        try {
            Libro db = new Libro();
            List<Libro> libros = db.obtenerLibros();
            escogerLibro.getItems().addAll(libros);

            // Define un StringConverter para convertir libro a String y viceversa
            StringConverter<Libro> libroStringConverter = new StringConverter<Libro>() {
                @Override
                public String toString(Libro libro) {
                    return libro != null ? libro.getTitulo() : "";
                }

                @Override
                public Libro fromString(String string) {
                    return null; // No necesitamos convertir de String a Libro en este caso
                }
            };

            // Asigna el StringConverter al ComboBox de libros
            escogerLibro.setConverter(libroStringConverter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private void showAlert(String Titulo, String Mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(Titulo);
        alert.setHeaderText(null);
        alert.setContentText(Mensaje);
        alert.showAndWait();
    }
}
