package kevincax.proyectobiblioteca;

import Controllers.Controladores.StageInterface;
import javafx.stage.Stage;

public class PrestarLibro implements StageInterface {

    private Stage stage;
    @Override
    public void setStage(Stage stage) {
        this.stage = stage;

    }

    @Override
    public void initialize() {

    }
}
