package Controllers.BaseDeDatos;

import javafx.scene.control.Alert;

import java.sql.*;

public class ConexionBaseDatos {


    public static Connection BaseDatos () {
      Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:postgresql://roundhouse.proxy.rlwy.net:18270/railway","postgres","bjlnClYuLvdPiDvAOntVRdQHzoPKcxFv");

          } catch (SQLException e) {
          showAlert("Alerta", "No se conecto a la base de datos, error:"+e.toString());
      }
         return connection;
    }

      public static void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();

    }

    public static ResultSet ConsultaSQL(String query){
        ResultSet rs;
        try {
            Connection connection = ConexionBaseDatos.BaseDatos();
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }
    public static void ejecutarInsercion(String query) {
        try {
            Connection connection = ConexionBaseDatos.BaseDatos();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar la consulta de inserción: " + e.getMessage(), e);
        }
    }



}
