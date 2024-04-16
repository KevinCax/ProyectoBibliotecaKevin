package kevincax.proyectobiblioteca;

import Controllers.BaseDeDatos.ConexionBaseDatos;
import Controllers.Controladores.StageInterface;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.Statement;

public class LoginInicio implements StageInterface {
    public Button IdCrearUsuario;
    public Button IdIniciarSesion;
    @FXML
    private Label welcomeText;
    @FXML
    private TextField textFieldEmail,  textFieldPassword;


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

    }


    public void onIniciarSesion() {
    String email = textFieldEmail.getText();
    String password = textFieldPassword.getText();

        String verifyLogin = "SELECT count(1) FROM users WHERE correo_electronico = '"+ email +"' AND contrasena = '"+ password +"'";

        try{
            Statement statement = ConexionBaseDatos.BaseDatos().createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);




            while(queryResult.next()){
                if(queryResult.getInt(1) == 1) {
                    HelloApplication LI = new HelloApplication();
                    LI.muestraVentana(stage, "Pantalla-registros.fxml");
                }else{
                    System.out.println("No existe el usuario");
                }

            }


        } catch(Exception e){
            e.printStackTrace();
        }
    }
}