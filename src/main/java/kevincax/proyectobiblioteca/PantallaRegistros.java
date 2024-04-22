package kevincax.proyectobiblioteca;

import Controllers.BaseDeDatos.ConexionBaseDatos;
import Controllers.Controladores.StageInterface;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.sql.Statement;

public class PantallaRegistros implements StageInterface {

    Stage stage;
    @Override
    public void setStage(Stage stage) {
    this.stage = stage;
    }

    @Override
    public void initialize() {

    }



    public void onButtonAddBook(ActionEvent actionEvent) {
        HelloApplication LI = new HelloApplication();
        LI.muestraVentana(stage, "Agregar-libro.fxml");
    }

    public void onVisuMembers(ActionEvent actionEvent) {
        HelloApplication LI = new HelloApplication();
        LI.muestraVentana(stage, "Visual-members.fxml");
    }

    public void buttonVisuBooks(ActionEvent actionEvent) {
    }

    public void buttonSettings(ActionEvent actionEvent) {
    }
}
