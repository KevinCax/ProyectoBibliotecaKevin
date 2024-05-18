package kevincax.proyectobiblioteca;

import Controllers.Controladores.StageInterface;
import javafx.stage.Stage;

public class PantallaUsuarios implements StageInterface {

    Stage stage;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize() {

    }
}
