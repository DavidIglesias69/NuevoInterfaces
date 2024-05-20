package PinturasInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class HistorialCompras extends JFrame {

    private JTable table;
    private String usuarioDNI;

    public HistorialCompras(String usuarioDNI) {
        this.usuarioDNI = usuarioDNI;
        setTitle("Historial de Compras");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Configuración de la tabla
        table = new JTable();
        table.setAutoCreateRowSorter(true);
        table.setBackground(new Color(255, 255, 240));
        table.setForeground(new Color(51, 51, 51));
        table.setSelectionBackground(new Color(173, 216, 230));
        
        // Desactivar la edición y la reordenación de columnas
        table.setModel(new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        table.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Creación de botones con diseño personalizado
        JButton btnImprimir = new JButton("Imprimir");
        btnImprimir.setBackground(new Color(65, 105, 225));
        btnImprimir.setForeground(Color.WHITE);
        btnImprimir.setFocusPainted(false);
        btnImprimir.setFont(new Font("Arial", Font.BOLD, 14));
        btnImprimir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    table.print();
                } catch (java.awt.print.PrinterException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBackground(new Color(220, 20, 60));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFocusPainted(false);
        btnVolver.setFont(new Font("Arial", Font.BOLD, 14));
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(btnImprimir);
        buttonPanel.add(btnVolver);
        buttonPanel.setBackground(new Color(240, 248, 255));

        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Consulta la base de datos y actualiza la tabla
        updateTable();
    }

    public void updateTable() {
        Conexion conexion = new Conexion();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            conn = conexion.abrirConsulta();
            statement = conn.createStatement();

            String sql = "SELECT c.ID_Compra, c.Fecha, p.Nombre AS Producto, hp.Cantidad, hp.Precio_Total " +
                    "FROM Compra c " +
                    "JOIN Historial_Producto hp ON c.ID_Compra = hp.ID_Compra " +
                    "JOIN Producto p ON hp.ID_Producto = p.ID_Producto " +
                    "WHERE c.DNI = '" + usuarioDNI + "'";

            resultSet = statement.executeQuery(sql);

            DefaultTableModel tableModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            tableModel.addColumn("ID Compra");
            tableModel.addColumn("Fecha");
            tableModel.addColumn("Producto");
            tableModel.addColumn("Cantidad");
            tableModel.addColumn("Precio Total");

            while (resultSet.next()) {
                Object[] row = new Object[5];
                row[0] = resultSet.getInt("ID_Compra");
                row[1] = resultSet.getDate("Fecha");
                row[2] = resultSet.getString("Producto");
                row[3] = resultSet.getInt("Cantidad");
                row[4] = resultSet.getDouble("Precio_Total");
                tableModel.addRow(row);
            }

            table.setModel(tableModel);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
}
