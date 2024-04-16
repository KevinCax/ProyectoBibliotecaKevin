package kevincax.proyectobiblioteca;

import Controllers.BaseDeDatos.ConexionBaseDatos;
import Controllers.Controladores.StageInterface;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class addLibro implements StageInterface, Initializable {
     Stage stage;

    @Override
    public void setStage(Stage stage) {
        this.stage=stage;

    }

    @FXML
    private TextField title;

    @FXML
    private TextField isbn;

    @FXML
    private TextField author;

    @FXML
    private TextField publisher;

    @FXML
    private TextField editorial;

    @FXML
    public TextField cantDis;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;

    ConexionBaseDatos conexionBaseDatos;

    @Override
    public void initialize() {
        // Lógica de inicialización aquí
        conexionBaseDatos = new ConexionBaseDatos();
    }

    @FXML
    private void addLibro() {
        String bookTitle = title.getText();
        String bookIsbn = isbn.getText();
        String bookAuthor = author.getText();
        String bookPublisher = publisher.getText();
        String bookEditorial = editorial.getText();
        String bookCantidad = cantDis.getText();

    }

    @FXML
    private void cancelar(){
        HelloApplication LI = new HelloApplication();
        LI.muestraVentana(stage, "Pantalla-registros.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
