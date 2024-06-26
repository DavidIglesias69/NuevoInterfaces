package PinturasInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
        scrollPane.setBounds(0, 29, 784, 497);

        // Crear un panel para el aviso y la tabla
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.add(scrollPane);

        getContentPane().add(panelPrincipal, BorderLayout.CENTER);

        JLabel panelInformativo = new JLabel("HACIENDO CLIC EN LAS COLUMNAS SE PUEDEN ORDENAR LOS DATOS");
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

        // Añadir el listener de doble clic para abrir el nuevo panel
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = table.getSelectedRow();
                    if (row != -1) {
                        int idCompra = (int) table.getValueAt(row, 0);
                        DetalleCompraPanel detalleCompraPanel = new DetalleCompraPanel(idCompra);
                        detalleCompraPanel.setVisible(true);
                    }
                }
            }
        });
    }

    public void updateTable() {
        Conexion conexion = new Conexion();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            conn = conexion.abrirConsulta();
            statement = conn.createStatement();

            String sql = "SELECT c.ID_Compra, c.Fecha, SUM(hp.Precio_Total) AS Cantidad_Total " +
                    "FROM Compra c " +
                    "JOIN Historial_Producto hp ON c.ID_Compra = hp.ID_Compra " +
                    "WHERE c.DNI = '" + usuarioDNI + "' AND hp.Cantidad > 0 " + // Añadido para excluir productos con cantidad 0
                    "GROUP BY c.ID_Compra, c.Fecha";

            resultSet = statement.executeQuery(sql);

            DefaultTableModel tableModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            tableModel.addColumn("ID Compra");
            tableModel.addColumn("Fecha");
            tableModel.addColumn("Cantidad Total");

            while (resultSet.next()) {
                Object[] row = new Object[3];
                row[0] = resultSet.getInt("ID_Compra");
                row[1] = resultSet.getDate("Fecha");
                row[2] = resultSet.getDouble("Cantidad_Total");
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HistorialCompras frame = new HistorialCompras("12345678A");
            frame.setVisible(true);
        });
    }
}
