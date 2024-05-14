package kevincax.proyectobiblioteca;

import Controllers.BaseDeDatos.ConexionBaseDatos;
import Controllers.Controladores.StageInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AgregarUsuarios implements Initializable, StageInterface {


    private Stage stage;
    @Override
    public void setStage(Stage stage) {
        this.stage=stage;
    }

    @Override
    public void initialize() {
        ConexionBaseDatos objetoConexion = new ConexionBaseDatos();

    }


    @FXML
    private TextField textFieldNombre, textFieldDireccion, textFieldTelefono, textFieldCui, textFieldCorreo;
    @FXML
    private PasswordField textFieldContrasenia;


    public void guardarUser() {
        String nombre = textFieldNombre.getText();
        String direccion = textFieldDireccion.getText();
        String telefono = textFieldTelefono.getText();
        String cui = textFieldCui.getText();
        String correo_electronico = textFieldCorreo.getText();
        String contrasenia = textFieldContrasenia.getText();

        String agregarUsuarios = "INSERT INTO users (nombre, direccion,telefono,cui,correo_electronico,contrasenia) VALUES ('" + nombre + "','" + direccion + "','" + telefono + "', '" + cui + "', '" + correo_electronico + "', '" + contrasenia + "')";

            try {
                Statement statement;
                statement = ConexionBaseDatos.BaseDatos().createStatement();
                statement.executeUpdate(agregarUsuarios);
                showAlert("Mensaje", "¡Registro exitoso! Bienvenido :)");
            } catch (SQLException e) {
                showAlert("Mensaje","No se agregaron los datos");
            }


    }
    private static void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();

    }

    public void cancelUser(ActionEvent actionEvent) {
        HelloApplication LI = new HelloApplication();
        LI.muestraVentana(stage, "Pantalla-inicial.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
