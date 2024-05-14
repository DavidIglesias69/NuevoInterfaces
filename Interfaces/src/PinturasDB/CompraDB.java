package PinturasDB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; // Importación correcta
import PinturasInterface.Conexion;

public class CompraDB {
    public static int guardarCompra(String dniUsuario, Date fecha) throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.abrirConsulta();
        ResultSet rs = null;
        try {
            // Preparar la consulta SQL para insertar una nueva compra
            String sql = "INSERT INTO Compra (DNI, Fecha) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);  // Uso correcto de Statement
            statement.setString(1, dniUsuario);
            statement.setDate(2, fecha);

            // Ejecutar la consulta
            statement.executeUpdate();

            // Obtener las claves generadas
            rs = statement.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // Devuelve el ID de la compra insertada
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Asegurarse de cerrar ResultSet y Connection
            if (rs != null) {
                rs.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return -1; // En caso de que algo salga mal
    }
}
