package PinturasDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import PinturasInterface.Conexion;

public class ProductoDB {
    
    public static double obtenerPrecio(String nombreProducto) throws SQLException {
        Conexion conexion = new Conexion();
        Connection link = conexion.abrirConsulta();
        double precio = 0;

        try {
            String query = "SELECT precio FROM Producto WHERE nombre = ?";
            PreparedStatement preparedStatement = link.prepareStatement(query);
            preparedStatement.setString(1, nombreProducto);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                precio = resultSet.getDouble("precio");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;  // Propagar la excepción para manejarla en la capa superior
        } finally {
            if (link != null) {
                try {
                    link.close();  // Asegurarse de cerrar la conexión
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return precio;
    }
    
    public static double calcularPrecioTotal(int[] cantidades, double[] precios) {
        double total = 0;
        for (int i = 0; i < cantidades.length; i++) {
            total += cantidades[i] * precios[i];
        }
        return total;
    }
}
