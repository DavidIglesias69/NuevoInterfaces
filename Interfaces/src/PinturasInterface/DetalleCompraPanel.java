package PinturasInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class DetalleCompraPanel extends JFrame {

    private JTable table;
    private int idCompra;

    public DetalleCompraPanel(int idCompra) {
        this.idCompra = idCompra;
        setTitle("Detalles de la Compra");
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
        scrollPane.setBounds(0, 29, 784, 497);

        // Crear un panel para el aviso y la tabla
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.add(scrollPane);

        getContentPane().add(panelPrincipal, BorderLayout.CENTER);

        JLabel panelInformativo = new JLabel("DETALLES DE LA COMPRA");
        panelInformativo.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
        panelInformativo.setHorizontalAlignment(SwingConstants.CENTER);
        panelInformativo.setBounds(116, 4, 550, 24);
        panelPrincipal.add(panelInformativo);

        // Creación de botones con diseño personalizado
        JButton btnImprimir = new JButton("Imprimir");
        btnImprimir.setBackground(new Color(65, 105, 225));
        btnImprimir.setForeground(Color.WHITE);
        btnImprimir.setFocusPainted(false);
        btnImprimir.setFont(new Font("Arial", Font.BOLD, 14));
        btnImprimir.addActionListener(e -> {
            try {
                table.print();
            } catch (java.awt.print.PrinterException ex) {
                ex.printStackTrace();
            }
        });

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBackground(new Color(220, 20, 60));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFocusPainted(false);
        btnVolver.setFont(new Font("Arial", Font.BOLD, 14));
        btnVolver.addActionListener(e -> dispose());

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

    private void updateTable() {
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
                    "WHERE c.ID_Compra = " + idCompra + " AND hp.Cantidad > 0";

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
