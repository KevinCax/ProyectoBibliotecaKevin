package kevincax.proyectobiblioteca;

import Controllers.Controladores.StageInterface;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LoginInicio implements StageInterface {
    public Button IdCrearUsuario;
    public Button IdIniciarSesion;
    @FXML
    private Label welcomeText;

    Stage stage;
    @Override
    public void setStage(Stage stage) {
        this.stage=stage;
    }

    @FXML
    public void initialize() {
        // Lógica de inicialización aquí
    }

    @FXML
    private void onCrearUsuario() {
        HelloApplication LI = new HelloApplication();
        LI.muestraVentana(stage, "Pantalla-secundaria.fxml");
    }


    public void onIniciarSesion() {
        HelloApplication LI = new HelloApplication();
        LI.muestraVentana(stage, "Agregar-libro.fxml");
    }
}