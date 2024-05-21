package kevincax.proyectobiblioteca;

import Controllers.Controladores.StageInterface;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class PantallaAdmin implements StageInterface {

    private Stage stage;
    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize() {

    }



    public void onButtonAddBook() {
        HelloApplication LI = new HelloApplication();
        LI.muestraVentana(stage, "Agregar-libro.fxml");
    }

    public void onVisuMembers() {
        HelloApplication LI = new HelloApplication();
        LI.muestraVentana(stage, "Visual-members.fxml");
    }

    public void abrirAutores() {
        HelloApplication LI = new HelloApplication();
        LI.muestraVentana(stage, "Agregar-autores.fxml");
    }


    public void agregarEditorial() {
        HelloApplication LI = new HelloApplication();
        LI.muestraVentana(stage, "Agregar-editorial.fxml");
    }

    public void regresarInicio() {
        HelloApplication LI = new HelloApplication();
        LI.muestraVentana(stage, "Pantalla-inicial.fxml");
    }
}
