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
    private ComboBox cbCiudades;

    ObservableList<String> ciudadesList = FXCollections.observableArrayList("Estados Unidos","Guatemala","España", "Francia", "México", "Portugal", "Panamá", "Reino Unido", "Alemania", "Irlanda", "Argentina", "Israel", "Australia", "Italia" ,"Bangladesh");

    public void listarCiudades(Event event) {
        llenarCombo(cbCiudades, ciudadesList);

    }

    @Override
    public void initialize() {
        ConexionBaseDatos objetoConexion = new ConexionBaseDatos();
    }

    @FXML
    private TextField textNombreEditorial, textFieldDireccion;


    public void guardarEditoriales() {
        String nombre_editorial = textNombreEditorial.getText();
        String ubicacion = textFieldDireccion.getText();
        String ciudad_ubicacion = ciudadesList.getFirst();

        String agregarEditorial = "INSERT INTO editorial (nombre_editorial, ubicacion, ciudad_ubicacion ) VALUES ('" + nombre_editorial + "','" + ubicacion + "','" + ciudad_ubicacion + "')";


        try {
            Statement statement;
            statement = ConexionBaseDatos.BaseDatos().createStatement();
            statement.executeUpdate(agregarEditorial);
            showAlert("Mensaje", "¡Editorial Agregado Correctamente");
        } catch (SQLException e) {
            showAlert("Mensaje","Error al Conectar");
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





}
