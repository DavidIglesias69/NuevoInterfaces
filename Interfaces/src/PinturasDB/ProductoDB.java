package PinturasDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import PinturasInterface.Conexion;

public class ProductoDB {
    // Método para obtener el precio de un producto
	 public static double obtenerPrecio(String nombreProducto) throws SQLException {
	        Conexion conexion = new Conexion();
	        Connection conn = conexion.abrirConsulta();
	        String sql = "SELECT precio FROM Producto WHERE nombre = ?";
	        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, nombreProducto);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                return rs.getDouble("precio");
	            }
	        } finally {
	            if (conn != null) {
	                conn.close();
	            }
	        }
	        return 0.0; // Retornar 0.0 si no se encuentra el producto
	    }

    // Método para obtener la cantidad de un producto
    public static int obtenerCantidad(String nombreProducto) throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.abrirConsulta();
        String sql = "SELECT cantidad FROM Producto WHERE nombre = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombreProducto);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("cantidad");
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return 0; // Retornar 0 si no se encuentra el producto
    }

    // Método para actualizar la cantidad de un producto
    public static void actualizarCantidad(String nombreProducto, int nuevaCantidad, Connection conn) throws SQLException {
        String sql = "UPDATE Producto SET cantidad = ? WHERE nombre = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, nuevaCantidad);
            stmt.setString(2, nombreProducto);
            stmt.executeUpdate();
        }
    }
    public static int obtenerIdProducto(String nombreProducto, Connection conn) throws SQLException {
        String sql = "SELECT id FROM Producto WHERE nombre = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombreProducto);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
        return -1; // Retornar -1 si no se encuentra el producto
    }
}
