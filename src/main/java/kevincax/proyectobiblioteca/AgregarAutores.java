package kevincax.proyectobiblioteca;

import Controllers.BaseDeDatos.ConexionBaseDatos;
import Controllers.Controladores.StageInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.sql.Statement;


public class AgregarAutores implements StageInterface {

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
    private TextField textFieldNombre, textFieldApellido, textFieldCui;
    public void guardarAutor(ActionEvent actionEvent) {
        String nombre = textFieldNombre.getText();
        String apellido = textFieldApellido.getText();
        String cui = textFieldCui.getText();

        String agregarAutor = "INSERT INTO autor (nombre, apellido, cui ) VALUES ('" + nombre + "','" + apellido + "','" + cui + "')";


        try {
            Statement statement;
            statement = ConexionBaseDatos.BaseDatos().createStatement();
            statement.executeUpdate(agregarAutor);
            showAlert("Mensaje", "¡Autor agregado");
        } catch (SQLException e) {
            showAlert("Mensaje","No se agregaron los datos");
        }


    }

    private void showAlert(String Titulo, String Mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(Titulo);
        alert.setHeaderText(null);
        alert.setContentText(Mensaje);
        alert.showAndWait();
    }


    public void regresarPantalla() {
        HelloApplication LI = new HelloApplication();
        LI.muestraVentana(stage, "Pantalla-registros.fxml");
    }


}
