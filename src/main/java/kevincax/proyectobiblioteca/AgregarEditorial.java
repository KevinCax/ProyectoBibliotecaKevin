package kevincax.proyectobiblioteca;

import Controllers.BaseDeDatos.ConexionBaseDatos;
import Controllers.Controladores.StageInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.sql.Statement;

import static kevincax.proyectobiblioteca.HelloApplication.llenarCombo;

public class AgregarEditorial implements StageInterface {

    private Stage stage;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private ComboBox<String> cbCiudades;  // Especifica el tipo String

    ObservableList<String> ciudadesList = FXCollections.observableArrayList(
            " ","Guatemala", "España", "Francia", "México", "Portugal", "Panamá",
            "Reino Unido", "Alemania", "Irlanda", "Argentina", "Israel",
            "Australia", "Italia", "Bangladesh", "Estados Unidos", "Canadá",
            "Brasil", "Chile", "Colombia", "Perú");

    @Override
    public void initialize() {
        ConexionBaseDatos objetoConexion = new ConexionBaseDatos();
        cbCiudades.setItems(ciudadesList);  // Llena el ComboBox con la lista de ciudades
    }

    @FXML
    private TextField textNombreEditorial, textFieldDireccion;

    public void guardarEditoriales() {
        String nombre_editorial = textNombreEditorial.getText();
        String ubicacion = textFieldDireccion.getText();
        String ciudad_ubicacion = cbCiudades.getValue();  // Obtener la ciudad seleccionada

        if (ciudad_ubicacion == null || ciudad_ubicacion.isEmpty()) {
            showAlert("Error", "Por favor, seleccione una ciudad.");
            return;
        }

        String agregarEditorial = "INSERT INTO editorial (nombre_editorial, ubicacion, ciudad_ubicacion) VALUES ('"
                + nombre_editorial.replace("'", "''") + "','"
                + ubicacion.replace("'", "''") + "','"
                + ciudad_ubicacion.replace("'", "''") + "')";

        try {
            Statement statement = ConexionBaseDatos.BaseDatos().createStatement();
            statement.executeUpdate(agregarEditorial);
            showAlert("Mensaje", "¡Editorial Agregado Correctamente!");
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Mensaje", "Error al Conectar");
        }
    }

    private void showAlert(String Titulo, String Mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(Titulo);
        alert.setHeaderText(null);
        alert.setContentText(Mensaje);
        alert.showAndWait();
    }

    public void buttonCancelar() {
        HelloApplication LI = new HelloApplication();
        LI.muestraVentana(stage, "Pantalla-admin.fxml");
    }

    public void listarCiudades(Event event) {
        llenarCombo(cbCiudades, ciudadesList);
    }
}
