package PinturasDB;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class HistorialDB {

    public static void actualizarHistorial(int idCompra, ArrayList<JSpinner> componentesSeleccionados, ArrayList<JLabel> labelsSeleccionados, ArrayList<String> nombresProductosSeleccionados, Connection conn) throws SQLException {
        String insertHistorial = "INSERT INTO Historial_Producto (ID_Compra, ID_Producto, Cantidad, Precio_Total) VALUES (?, ?, ?, ?)";
        String selectIdProducto = "SELECT ID_Producto FROM Producto WHERE Nombre = ?";

        try (PreparedStatement pstmtInsert = conn.prepareStatement(insertHistorial);
             PreparedStatement pstmtSelect = conn.prepareStatement(selectIdProducto)) {
            
            for (int i = 0; i < componentesSeleccionados.size(); i++) {
                String nombreProducto = nombresProductosSeleccionados.get(i);
                System.out.println("Buscando ID para el producto: " + nombreProducto);
                pstmtSelect.setString(1, nombreProducto);
                ResultSet rs = pstmtSelect.executeQuery();
                if (rs.next()) {
                    int idProducto = rs.getInt("ID_Producto");
                    System.out.println("ID encontrado: " + idProducto);

                    pstmtInsert.setInt(1, idCompra);
                    pstmtInsert.setInt(2, idProducto);
                    int cantidad = (Integer) componentesSeleccionados.get(i).getValue();
                    pstmtInsert.setInt(3, cantidad);
                    double precio = Double.parseDouble(labelsSeleccionados.get(i).getText().replace("€", ""));
                    double precioTotal = precio * cantidad;
                    pstmtInsert.setDouble(4, precioTotal);
                    pstmtInsert.addBatch();
                } else {
                    System.out.println("No se encontró ID para el producto: " + nombreProducto);
                }
                rs.close();
            }
            pstmtInsert.executeBatch();
        }
    }
}
