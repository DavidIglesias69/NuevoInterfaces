package PinturasDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import PinturasInterface.Conexion;
import ProyectoPinturas.BCrypt;
import ProyectoPinturas.Usuario;

public class RegistroDB extends JFrame{

	 // Método existente para hacer login
    public static Usuario doLogin(String usuario, String pass) throws SQLException {
        Conexion cone = new Conexion();
        Connection link = cone.abrirConsulta();
        Usuario nuevo = null;
        String query = "SELECT * FROM Usuario WHERE DNI = ?";
        PreparedStatement llamada = link.prepareStatement(query);
        llamada.setString(1, usuario);
        ResultSet rs = llamada.executeQuery();

        if (rs != null && rs.next()) {
            String DNI = rs.getString(1);
            String nombre = rs.getString(2);
            String hashedPassword = rs.getString(3); // Contraseña encriptada almacenada
            String email = rs.getString(4);
            int resp = rs.getInt(5);

            // Comparar la contraseña ingresada con la encriptada usando BCrypt
            if (BCrypt.checkpw(pass, hashedPassword)) {
                nuevo = new Usuario(DNI, nombre, "", email, resp);
                return nuevo;
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
        }

        return null;
    }

    public static boolean existeUsuario(String DNI) throws SQLException {
        Conexion cone = new Conexion();
        Connection link = cone.abrirConsulta();
        String query = "SELECT COUNT(*) FROM Usuario WHERE DNI = ?";
        PreparedStatement llamada = link.prepareStatement(query);
        llamada.setString(1, DNI);
        ResultSet rs = llamada.executeQuery();

        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0;
        }

        return false;
    }

    // Método modificado para añadir usuario
    public static void añadirUsuario(String DNI, String nombre, String pass, String email) {
        Conexion cone = new Conexion();
        Connection link = null;
        try {
            link = cone.abrirConsulta();
            String query = "INSERT INTO Usuario (DNI, Nombre, Contraseña, Email) VALUES (?, ?, ?, ?)";
            PreparedStatement llamada = link.prepareStatement(query);
            llamada.setString(1, DNI);
            llamada.setString(2, nombre);
            // Encriptar la contraseña antes de guardarla
            String hashedPassword = BCrypt.hashpw(pass, BCrypt.gensalt());
            llamada.setString(3, hashedPassword);
            llamada.setString(4, email);

            llamada.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario registrado con éxito");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar usuario: " + e.getMessage());
        } finally {
            try {
                if (link != null) {
                    link.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
