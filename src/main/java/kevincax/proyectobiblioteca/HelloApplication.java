package kevincax.proyectobiblioteca;

import Controllers.Controladores.StageInterface;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Pantalla-Inicial.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.setTitle("Biblioteca Kevin");
        stage.setScene(scene);
        muestraVentana(stage, "Pantalla-inicial.fxml");
    }

    public static void main(String[] args) {
        launch();
    }

    public void muestraVentana(Stage stage, String fxmlFile){
     try {
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
         Pane panel = fxmlLoader.load();
         Scene scene = new Scene(panel);

         StageInterface controlador = fxmlLoader.getController();
         controlador.setStage(stage);

         stage.setScene(scene);
         stage.show();
     } catch (IOException e){
         e.printStackTrace();
     }
    }

    public static void llenarCombo(ComboBox<String> llenarCombo, ObservableList<String> infoCombo){
        llenarCombo.setItems(infoCombo);
    }


}