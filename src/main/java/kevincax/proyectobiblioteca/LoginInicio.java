package kevincax.proyectobiblioteca;

import Controllers.BaseDeDatos.ConexionBaseDatos;
import Controllers.Controladores.StageInterface;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import static Controllers.BaseDeDatos.ConexionBaseDatos.showAlert;

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
        LI.muestraVentana(stage, "Agregar-usuarios.fxml");
    }

    @FXML
    private TextField textFieldEmail,  textFieldPassword;

    public void onIniciarSesion() throws SQLException {
        String email = textFieldEmail.getText();
        String password = textFieldPassword.getText();

        String verifyLogin = "SELECT count(1) FROM users WHERE correo_electronico = '" + email + "'AND contrasenia = '" + password + "'";
        ResultSet queryResult = null;


                try {
                    Statement statement = ConexionBaseDatos.BaseDatos().createStatement();
                    queryResult = statement.executeQuery(verifyLogin);

                    if (queryResult.next()) {
                        int userCount = queryResult.getInt(1);
                        if (userCount == 1) {
                            if (esAdmin(email)){
                                HelloApplication LI = new HelloApplication();
                                LI.muestraVentana(stage, "Pantalla-admin.fxml");
                            }

                        } else {
                            HelloApplication LI = new HelloApplication();
                            LI.muestraVentana(stage, "Pantalla-usuarios.fxml");
                        }

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (queryResult != null){
                        queryResult.close();
                    }
                }
    }
    private boolean esAdmin(String email) {
        String query = "SELECT admin FROM users WHERE correo_electronico = '" + email + "'";
        try {
            Statement statement = ConexionBaseDatos.BaseDatos().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return resultSet.getBoolean("esadmin");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}