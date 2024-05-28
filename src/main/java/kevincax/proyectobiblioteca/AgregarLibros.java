package kevincax.proyectobiblioteca;

import Controllers.BaseDeDatos.ConexionBaseDatos;

import Controllers.Controladores.StageInterface;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class AgregarLibros implements StageInterface,Initializable {



    private Stage stage;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;

    }
    @Override
    public void initialize() {
        ConexionBaseDatos objetoConexion = new ConexionBaseDatos();
    }

    @FXML
    private TextField textFieldTitulo, textFieldIsbn, textFieldPublisher, textFieldCantDis, textFieldEditorial, textFieldAutor;

    @FXML
    public void guardarLibro() {
        String titulo = textFieldTitulo.getText();
        String isbn = textFieldIsbn.getText();
        String anio_publicacion = textFieldPublisher.getText();
        String cantidad_disponible = textFieldCantDis.getText();
        String idEditorial = textFieldEditorial.getText();
        String idAutor = textFieldAutor.getText();

        // Sanitiza las entradas para evitar SQL Injection
        idEditorial = idEditorial.trim().replace("'", "''");
        idAutor = idAutor.trim().replace("'", "''");

        String consultaEditorial = "SELECT * FROM editorial WHERE nombre_editorial = '" + idEditorial + "'";
        String consultaAutor = "SELECT * FROM autor WHERE nombreYApellido  = '" + idAutor + "'";

        int autor = 0;
        int editorial = 0;

        try (Statement statement = ConexionBaseDatos.BaseDatos().createStatement()) {
            ResultSet queryResult = statement.executeQuery(consultaEditorial);

            if (queryResult.next()) {
                editorial = queryResult.getInt("idEditorial");
            } else {
                showAlert("Alerta", "No existe Editorial");
                return;
            }

            ResultSet queryAutor = statement.executeQuery(consultaAutor);

            if (queryAutor.next()) {
                autor = queryAutor.getInt("idAutor");
            } else {
                showAlert("Alerta", "No existe Autor");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "Error al consultar la base de datos.");
            return;
        }

        String agregarLibro = "INSERT INTO libro (titulo, isbn, anio_publicacion, cantidad_disponible, idEditorial, idAutor) VALUES ('" +
                titulo.replace("'", "''") + "','" +
                isbn.replace("'", "''") + "','" +
                anio_publicacion.replace("'", "''") + "', '" +
                cantidad_disponible.replace("'", "''") + "', " +
                editorial + ", " + autor + ")";

        try (Statement statement = ConexionBaseDatos.BaseDatos().createStatement()) {
            statement.executeUpdate(agregarLibro);
            showAlert("Mensaje", "¡Registro exitoso! :)");
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Alerta", "No se agregaron los datos");
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
        LI.muestraVentana(stage, "Pantalla-admin.fxml");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
