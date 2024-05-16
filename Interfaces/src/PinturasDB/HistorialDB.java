package PinturasDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JSpinner;

public class HistorialDB {
    public static void actualizarHistorial(int idCompra, ArrayList<JSpinner> componentes, ArrayList<JLabel> labels, String[] nombresProductos, Connection conn) throws SQLException {
        String sql = "INSERT INTO Historial_Producto (ID_Compra, ID_Producto, Cantidad, Precio_Total) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            for (int i = 0; i < componentes.size(); i++) {
                int cantidad = (Integer) componentes.get(i).getValue();
                if (cantidad > 0) {
                    int idProducto = ProductoDB.obtenerIdProducto(nombresProductos[i], conn); // Obtener el ID del producto basado en el nombre
                    String text = labels.get(i).getText().replace("€", "");
                    double precio = Double.parseDouble(text) * cantidad;
                    statement.setInt(1, idCompra);
                    statement.setInt(2, idProducto);
                    statement.setInt(3, cantidad);
                    statement.setDouble(4, precio);
                    statement.addBatch(); // Utilizar batch para mejorar el rendimiento
                }
            }
            statement.executeBatch(); // Ejecutar todos los inserts en batch
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Lanzar la excepción para que la transacción pueda ser revertida si falla
        }
    }
}
