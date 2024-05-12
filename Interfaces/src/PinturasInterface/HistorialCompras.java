package PinturasInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class HistorialCompras extends JFrame {

    private JTable table;
    private static String usuarioDNI;

    public HistorialCompras(String usuarioDNI) {
    	 this.usuarioDNI = usuarioDNI; // Guardar el DNI
   
        setTitle("Historial de Compras");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Consulta la base de datos y actualiza la tabla
        updateTable();
    }

    private void updateTable() {
        Conexion conexion = new Conexion();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            conn = conexion.abrirConsulta();
            statement = conn.createStatement();

         // Crear la consulta SQL para obtener el historial de compras del usuario actual
            String sql = "SELECT c.ID_Compra, c.Fecha, p.Nombre AS Producto, hp.Cantidad, hp.Precio_Total " +
                         "FROM Compra c " +
                         "JOIN Historial_Producto hp ON c.ID_Compra = hp.ID_Compra " +
                         "JOIN Producto p ON hp.ID_Producto = p.ID_Producto " +
                         "WHERE c.DNI = '" + usuarioDNI + "'";


            // Ejecutar la consulta
            resultSet = statement.executeQuery(sql);

            // Crear el modelo de la tabla
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("ID Compra");
            tableModel.addColumn("Fecha");
            tableModel.addColumn("Producto");
            tableModel.addColumn("Cantidad");
            tableModel.addColumn("Precio Total");

            // Agregar los datos de la consulta al modelo de la tabla
            while (resultSet.next()) {
                Object[] row = new Object[5];
                row[0] = resultSet.getInt("ID_Compra");
                row[1] = resultSet.getDate("Fecha");
                row[2] = resultSet.getString("Producto");
                row[3] = resultSet.getInt("Cantidad");
                row[4] = resultSet.getDouble("Precio_Total");
                tableModel.addRow(row);
            }

            // Establecer el modelo de la tabla
            table.setModel(tableModel);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión y liberar recursos
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HistorialCompras frame = new HistorialCompras(usuarioDNI);
            frame.setVisible(true);
        });
    }
}
