package kevincax.proyectobiblioteca;

import Controllers.BaseDeDatos.ConexionBaseDatos;
import Controllers.Controladores.StageInterface;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class DevolverLibro implements StageInterface {

    private Stage stage;
    @Override
    public void setStage(Stage stage) {
        this.stage = stage;

    }

    @Override
    public void initialize() {
        ConexionBaseDatos objetoConexion = new ConexionBaseDatos();

    }

    public void devolverLibro() {
    }

    public void cancelarDevolucion() {
        HelloApplication LI = new HelloApplication();
        LI.muestraVentana(stage, "Pantalla-usuario.fxml");
    }
}
