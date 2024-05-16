package kevincax.proyectobiblioteca;

import Controllers.Controladores.StageInterface;
import javafx.stage.Stage;

public class Users implements StageInterface {
    private Stage stage;
    @Override
    public void setStage(Stage stage) {
        this.stage= stage;
    }
    @Override
    public void initialize() {

    }

    private String nombre;
    private String direccion;
    private String telefono;
    private String cui;
    private String correo_electronico;
    private String contrasenia;
    private Boolean esAdmin;

    public Users(Stage stage, String nombre, String direccion, String telefono, String cui, String correo_electronico, String contrasenia, Boolean esAdmin) {
        this.stage = stage;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cui = cui;
        this.correo_electronico = correo_electronico;
        this.contrasenia = contrasenia;
        this.esAdmin = esAdmin;
    }

    public Stage getStage() {
        return stage;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Boolean getEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(Boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    @Override
    public String toString() {
        return "Users{" +
                "stage=" + stage +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", cui='" + cui + '\'' +
                ", correo_electronico='" + correo_electronico + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", esAdmin=" + esAdmin +
                '}';
    }
}
