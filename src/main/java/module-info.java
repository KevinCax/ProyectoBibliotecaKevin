module kevincax.proyectobiblioteca {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires org.postgresql.jdbc;
    requires java.desktop;

    opens kevincax.proyectobiblioteca to javafx.fxml;
    exports kevincax.proyectobiblioteca;
    exports kevincax.proyectobiblioteca.Controllers.BaseDeDatos;
    exports kevincax.proyectobiblioteca.Controllers.Controladores;
}