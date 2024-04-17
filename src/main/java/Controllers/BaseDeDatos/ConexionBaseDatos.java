package Controllers.BaseDeDatos;

import javafx.scene.control.Alert;

import java.sql.*;

public class ConexionBaseDatos {


     public static Connection BaseDatos () {
      Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:postgresql://roundhouse.proxy.rlwy.net:18270/railway","postgres","bjlnClYuLvdPiDvAOntVRdQHzoPKcxFv");

          } catch (SQLException e) {
          showAlert("Mensaje", "No se conecto a la base de datos, error:"+e.toString());
      }
         return connection;
    }

      private static void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();

    }





}
