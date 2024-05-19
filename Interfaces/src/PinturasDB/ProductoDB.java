package PinturasDB;

import java.sql.*;

import PinturasInterface.Conexion;

public class ProductoDB {

    public static int obtenerCantidad(String nombreProducto) throws SQLException {
        String query = "SELECT Cantidad FROM Producto WHERE Nombre = ?";
        Conexion conexion = new Conexion();
        try (Connection conn = conexion.abrirConsulta();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nombreProducto);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("Cantidad");
            } else {
                return 0;
            }
        }
    }

    public static double obtenerPrecio(String nombreProducto) throws SQLException {
        String query = "SELECT Precio FROM Producto WHERE Nombre = ?";
        Conexion conexion = new Conexion();
        try (Connection conn = conexion.abrirConsulta();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nombreProducto);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("Precio");
            } else {
                return 0.0;
            }
        }
    }

    public static void actualizarCantidad(String nombreProducto, int nuevaCantidad, Connection conn) throws SQLException {
        String query = "UPDATE Producto SET Cantidad = ? WHERE Nombre = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, nuevaCantidad);
            pstmt.setString(2, nombreProducto);
            pstmt.executeUpdate();
        }
    }
}
