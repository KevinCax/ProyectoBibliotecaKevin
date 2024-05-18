package kevincax.proyectobiblioteca;

import Controllers.Controladores.StageInterface;
import javafx.stage.Stage;

public class PantallaUsuario implements StageInterface {

    private Stage stage;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize() {

    }

    public void prestarLibro() {
        HelloApplication LI = new HelloApplication();
        LI.muestraVentana(stage, "");
    }

    public void devolverLibro() {
        HelloApplication LI = new HelloApplication();
        LI.muestraVentana(stage, "");
    }
    public void buscarLibro() {
        HelloApplication LI = new HelloApplication();
        LI.muestraVentana(stage, "");
    }




}
