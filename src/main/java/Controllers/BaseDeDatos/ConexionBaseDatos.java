package Controllers.BaseDeDatos;

import javafx.scene.control.Button;

import javax.swing.*;
import java.sql.*;

public class ConexionBaseDatos {

    public static Connection BaseDatos () {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:postgresql://roundhouse.proxy.rlwy.net:18270/railway","postgres","bjlnClYuLvdPiDvAOntVRdQHzoPKcxFv");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
