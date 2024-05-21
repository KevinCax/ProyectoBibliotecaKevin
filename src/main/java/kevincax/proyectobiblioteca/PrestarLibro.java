package kevincax.proyectobiblioteca;

import Controllers.BaseDeDatos.ConexionBaseDatos;
import Controllers.Controladores.StageInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import static kevincax.proyectobiblioteca.HelloApplication.llenarCombo;

public class PrestarLibro implements StageInterface {

    private Stage stage;
    private Connection Connection;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;

    }

    @Override
    public void initialize() {

    }







}
