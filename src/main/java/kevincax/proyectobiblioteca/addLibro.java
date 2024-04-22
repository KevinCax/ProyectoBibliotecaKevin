package kevincax.proyectobiblioteca;

import Controllers.BaseDeDatos.ConexionBaseDatos;
import Controllers.Controladores.StageInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class addLibro implements StageInterface,Initializable {
    Stage stage;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;

    }


    @Override
    public void initialize() {
        ConexionBaseDatos objetoConexion = new ConexionBaseDatos();
    }

    @FXML
    private TextField textFieldTitulo, textFieldIsbn, textFieldAutor, textFieldPublisher, textFieldEditorial, textFieldCantDis;

    @FXML
    public void guardarLibro(ActionEvent actionEvent) {
        String titulo = textFieldTitulo.getText();
        String isbn = textFieldIsbn.getText();
        String autor = textFieldAutor.getText();
        Date anio_publicacion = Date.valueOf(textFieldPublisher.getText());
        String editorial = textFieldEditorial.getText();
        int cantidad_disponible = Integer.parseInt(textFieldCantDis.getText());

        String agregarLibros = "INSERT INTO users (titulo, isbn, autor, anio_publicacion, editorial, cantidad_disponible) VALUES ('" + titulo + "','" + isbn + "','" + autor + "', '" + anio_publicacion + "', '" + editorial + "', '" + cantidad_disponible + "')";

        try {
            Statement statement;
            statement = ConexionBaseDatos.BaseDatos().createStatement();
            statement.executeUpdate(agregarLibros);
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

    @FXML
    private void cancelar() {
        HelloApplication LI = new HelloApplication();
        LI.muestraVentana(stage, "Pantalla-registros.fxml");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
