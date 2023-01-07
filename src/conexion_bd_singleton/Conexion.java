package conexion_bd_singleton;

import java.sql.*;
import javax.swing.JOptionPane;
/*
    En este ejercicio se aplicará singletón a la clase y al objeto conexion.
    Todo esto con fines educativos, así que en la práctica esto puede cambiar
    dependiendo del proyecto.
*/
public class Conexion {
    private static Connection conexion;//Variable estatica para guardar la conexion.
    private static Conexion instancia;  //Variable estatica para la clase.
    
    private final String url = "jdbc:mysql://localhost/test";
    private final String username = "root";
    private final String password = "";

    private Conexion(){}
    
    public static Conexion getInstance() { // Metodo para obtener solo una instancia de la clase conexión.
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }
    
    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexion = DriverManager.getConnection(url, username, password);
            JOptionPane.showMessageDialog(null, "conexion exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos.");
        }
        return conexion;
    }
    public void desconectar() {
        try {
            conexion.close();
            JOptionPane.showMessageDialog(null, "conexion desconectada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al desconectarse de la base de datos.");
        }
    }
    
}
