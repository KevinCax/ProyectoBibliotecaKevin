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

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import static kevincax.proyectobiblioteca.HelloApplication.llenarCombo;


public class PrestarLibro  implements StageInterface {

    private Stage stage;
    private Connection Connection;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    @Override
    public void initialize()  {
        ConexionBaseDatos objetoConexion = new ConexionBaseDatos();
        PrestarLibro();
    }
    ObservableList<String> cantidadListL = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10");

    public void listarCantidades(){
        llenarCombo(cantidadPrestada, cantidadListL);
    }

    @FXML
    private TextField ingresarCui;
    @FXML
    private ComboBox cantidadPrestada;
    @FXML
    private DatePicker fechaPrestamo, fechaDevolucion;



    public void prestarLibro() {
        String cui = ingresarCui.getText();
        Libro isbn = escogerLibro.getValue();
        int cant_libros_prestados = Integer.parseInt(cantidadListL.getFirst());
        LocalDate fecha_prestamo = fechaPrestamo.getValue();
        LocalDate fecha_devolucion = fechaDevolucion.getValue();

        String prestarLibros = "INSERT INTO prestamo (cui, isbn, fecha_prestamo, fecha_devolucion,  cant_libros_prestados ) VALUES ('" + cui + "','" + isbn + "','" + fecha_prestamo + "', '" + fecha_devolucion + "', '" + cant_libros_prestados + "')";

        try {
            Statement statement;
            statement = ConexionBaseDatos.BaseDatos().createStatement();
            statement.executeUpdate(prestarLibros);
            showAlert("Mensaje", "¡Autor agregado");
        } catch (SQLException e) {
            showAlert("Mensaje","No se agregaron los datos");
        }
    }



    public void cancelarPrestamo() {
    }

    @FXML
    ComboBox<Libro> escogerLibro;

    private void PrestarLibro() {
        try {
            Libro db = new Libro();
            List<Libro> editoriales = db.obtenerLibros();
            escogerLibro.getItems().addAll(editoriales);

            // Define un StringConverter para convertir libro a String y viceversa
            StringConverter<Libro> libroStringConverter = new StringConverter<Libro>() {
                @Override
                public String toString(Libro libro) {
                    return libro != null ? libro.getTitulo() : "";
                }
                @Override
                public Libro fromString(String string) {
                    return null; // No necesitamos convertir de String a Editorial en este caso
                }
            };
            // Asigna el StringConverter al ChoiceBox de editoriales
            escogerLibro.setConverter(libroStringConverter);
        }catch (SQLException e){
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
