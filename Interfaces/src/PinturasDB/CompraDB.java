package PinturasDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import PinturasInterface.Conexion;

public class CompraDB {

    public static void guardarCompra(String dniUsuario, double precioTotal) throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.abrirConsulta();

        try {
            // Preparar la consulta SQL para insertar una nueva compra
            String sql = "INSERT INTO Compra (DNI, Precio_Total) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, dniUsuario);
            statement.setDouble(2, precioTotal);

            // Ejecutar la consulta
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        } finally {
            // Cerrar la conexión
            if (conn != null) {
                conn.close();
            }
        }
    }
}
