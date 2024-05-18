package kevincax.proyectobiblioteca;

import Controllers.Controladores.StageInterface;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class VisualMembers implements StageInterface {

    Stage stage;
    @Override
    public void setStage(Stage stage) {
        this.stage=stage;
    }

    @Override
    public void initialize() {

    }

    public void onSalir(ActionEvent actionEvent) {
        HelloApplication LI = new HelloApplication();
        LI.muestraVentana(stage, "Pantalla-admin.fxml");
    }
}
