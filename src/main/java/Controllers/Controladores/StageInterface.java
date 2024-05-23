package Controllers.Controladores;

import javafx.stage.Stage;

import java.sql.SQLException;

public interface StageInterface {
    void setStage(Stage stage);

    void initialize() throws SQLException;
}
