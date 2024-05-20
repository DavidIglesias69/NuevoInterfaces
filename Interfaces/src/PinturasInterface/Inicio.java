package PinturasInterface;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import PinturasDB.CompraDB;
import PinturasDB.HistorialDB;
import PinturasDB.ProductoDB;
import ProyectoPinturas.Usuario;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends JFrame {

    private static final long serialVersionUID = 1L;
    private HistorialCompras historialComprasFrame;
    private JPanel contentPane;
    Usuario usuario_logueado;
    private Date fechaActual = new Date(System.currentTimeMillis());
    double precioTotal = 0;
    ArrayList<JSpinner> componentes = new ArrayList<JSpinner>();
    ArrayList<JLabel> labels = new ArrayList<JLabel>();

    // Definir nombresProductos como variable de instancia
    String[] nombresProductos = { "Pintura", "Rodillo", "Papel", "Brocha", "Escalera", "Barniz", "Disolvente", "Plasticos", "Decapante", "Espatula" };

    public Inicio(Usuario usuario_logueado) throws SQLException {
        setTitle("Panel de Productos ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 882, 573);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        this.usuario_logueado = usuario_logueado;

        // Crear los labels de precio y agregar al contentPane
        JLabel[] labelsPrecios = new JLabel[nombresProductos.length];
        for (int i = 0; i < nombresProductos.length; i++) {
            labelsPrecios[i] = new JLabel();
            labelsPrecios[i].setFont(new Font("Tahoma", Font.PLAIN, 15));
            labelsPrecios[i].setHorizontalAlignment(SwingConstants.CENTER);
            if (i < 5) {
                labelsPrecios[i].setBounds(180, 57 + i * 72, 57, 14);
            } else {
                labelsPrecios[i].setBounds(530, 57 + (i - 5) * 72, 57, 14);
            }
            contentPane.add(labelsPrecios[i]);
        }

        // Crear los iconos de los productos y agregar al contentPane
        JLabel[] iconosProductos = new JLabel[nombresProductos.length];
        String[] iconosPaths = { "bote-de-pintura (1).png", "rodillo.png", "toalla-de-papel (1).png", "construccion.png", "escalera-de-mano.png", "barniz.png", "sin-disolventes.png", "rollos-de-papel.png", "aerosol.png", "espatula.png" };
        for (int i = 0; i < nombresProductos.length; i++) {
            iconosProductos[i] = new JLabel("");
            iconosProductos[i].setIcon(new ImageIcon(Inicio.class.getResource("/resources/" + iconosPaths[i])));
            if (i < 5) {
                iconosProductos[i].setBounds(290, 15 + i * 72, 73, 72);
            } else {
                iconosProductos[i].setBounds(650, 24 + (i - 5) * 72, 73, 72);
            }
            contentPane.add(iconosProductos[i]);
        }

        ProductoDB productoDB = new ProductoDB();
        Conexion conexion = new Conexion();
        Connection conn = conexion.abrirConsulta();

        // Obtener y mostrar los precios y cantidades de cada producto
        for (int i = 0; i < nombresProductos.length; i++) {
            double precio = ProductoDB.obtenerPrecio(nombresProductos[i]);
            labelsPrecios[i].setText(String.valueOf(precio) + "€");

            int cantStock = ProductoDB.obtenerCantidad(nombresProductos[i]);
            JSpinner spinner = new JSpinner();
            spinner.setEnabled(false);
            spinner.setModel(new SpinnerNumberModel(0, 0, cantStock, 1));
            if (i < 5) {
                spinner.setBounds(240, 54 + i * 72, 43, 20);
            } else {
                spinner.setBounds(585, 54 + (i - 5) * 72, 45, 20);
            }
            contentPane.add(spinner);
            componentes.add(spinner);
            labels.add(labelsPrecios[i]);
        }

        // Cerrar la conexión después de usarla
        if (conn != null) {
            conn.close();
        }

        // Crear los checkboxes y agregar al contentPane
        for (int i = 0; i < nombresProductos.length; i++) {
            JCheckBox checkBox = new JCheckBox(nombresProductos[i]);
            checkBox.setFont(new Font("Monospaced", Font.PLAIN, 16));
            if (i < 5) {
                checkBox.setBounds(75, 51 + i * 72, 110, 23);
            } else {
                checkBox.setBounds(400, 54 + (i - 5) * 72, 125, 23);
            }
            contentPane.add(checkBox);
            int index = i; // Necesario para usar en el ActionListener
            checkBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    componentes.get(index).setEnabled(checkBox.isSelected());
                }
            });
        }

        JTextField PanelTotal = new JTextField();
        PanelTotal.setBackground(Color.ORANGE);
        PanelTotal.setForeground(new Color(0, 0, 255));
        PanelTotal.setBounds(264, 419, 272, 20);
        contentPane.add(PanelTotal);

        for (JSpinner componente : componentes) {
            componente.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                    double precio = precioTotal();
                    PanelTotal.setText("" + precio + "€");
                }
            });
        }

        JButton btnComprar = new JButton("COMPRAR");
        btnComprar.setIcon(new ImageIcon(Inicio.class.getResource("/resources/carrito-de-supermercado (1).png")));
        btnComprar.setBounds(351, 474, 151, 35);
        contentPane.add(btnComprar);
        btnComprar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Conexion conexion = new Conexion();
                    try (Connection conn = conexion.abrirConsulta()) {
                        conn.setAutoCommit(false);

                        ArrayList<String> productosSinStock = verificarStock(conn);
                        if (productosSinStock.size() < componentes.size()) {
                            int idCompra = CompraDB.guardarCompra(usuario_logueado.getDNI(), fechaActual, conn);
                            if (idCompra != -1) {
                                ArrayList<JSpinner> componentesSeleccionados = new ArrayList<>();
                                ArrayList<JLabel> labelsSeleccionados = new ArrayList<>();
                                ArrayList<String> nombresProductosSeleccionados = new ArrayList<>();
                                for (int i = 0; i < componentes.size(); i++) {
                                    if (componentes.get(i).isEnabled() && !productosSinStock.contains(nombresProductos[i])) {
                                        componentesSeleccionados.add(componentes.get(i));
                                        labelsSeleccionados.add(labels.get(i));
                                        nombresProductosSeleccionados.add(nombresProductos[i]);
                                    }
                                }
                                if (actualizarStock(componentesSeleccionados, nombresProductosSeleccionados, conn)) {
                                    HistorialDB.actualizarHistorial(idCompra, componentesSeleccionados, labelsSeleccionados, nombresProductosSeleccionados, conn);
                                    conn.commit();
                                    String mensaje = "El precio total de la compra es: " + precioTotal() + " €";
                                    if (!productosSinStock.isEmpty()) {
                                        mensaje += "\n\nNo hay suficiente stock para los siguientes productos, por lo que no se compraron:\n";
                                        for (String producto : productosSinStock) {
                                            mensaje += "- " + producto + "\n";
                                        }
                                    }
                                    JOptionPane.showMessageDialog(null, mensaje, "Compra realizada", JOptionPane.INFORMATION_MESSAGE);
                                    actualizarPreciosYCantidades();
                                    if (historialComprasFrame != null) {
                                        historialComprasFrame.updateTable();
                                    }
                                } else {
                                    conn.rollback();
                                    JOptionPane.showMessageDialog(null, "Error al actualizar el stock.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                conn.rollback();
                                JOptionPane.showMessageDialog(null, "Error al guardar la compra.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            String mensaje = "No hay suficiente stock para los siguientes productos:\n";
                            for (String producto : productosSinStock) {
                                mensaje += "- " + producto + "\n";
                            }
                            JOptionPane.showMessageDialog(null, mensaje, "Error de Stock", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al realizar la compra: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton btnHistorial = new JButton("HISTORIAL DE COMPRAS");
        btnHistorial.setIcon(new ImageIcon(Inicio.class.getResource("/resources/historial-medico (1).png")));
        btnHistorial.setBounds(82, 474, 215, 34);
        contentPane.add(btnHistorial);

        btnHistorial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (historialComprasFrame == null) {
                    historialComprasFrame = new HistorialCompras(usuario_logueado.getDNI());
                }
                historialComprasFrame.updateTable();
                historialComprasFrame.setVisible(true);
            }
        });

        JButton btnSalir = new JButton("SALIR");
        btnSalir.setIcon(new ImageIcon(Inicio.class.getResource("/resources/boton.png")));
        btnSalir.setBounds(563, 473, 136, 37);
        contentPane.add(btnSalir);
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JLabel lblFecha = new JLabel("Fecha:  " + fechaActual);
        lblFecha.setBounds(732, 25, 124, 14);
        contentPane.add(lblFecha);
    }

    public double precioTotal() {
        double total = 0;
        for (int i = 0; i < componentes.size(); i++) {
            if (componentes.get(i).isEnabled()) {
                String text = labels.get(i).getText();
                double precioLabel = Double.parseDouble(text.substring(0, text.length() - 1));
                int cantSpinner = Integer.parseInt(componentes.get(i).getValue().toString());
                total += precioLabel * cantSpinner;
            }
        }
        return total;
    }

    private void disableSpinnerEdit(ArrayList<JSpinner> comp) {
        for (JSpinner spinner : comp) {
            JComponent editor = spinner.getEditor();
            if (editor instanceof JSpinner.DefaultEditor) {
                JFormattedTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();
                textField.setEditable(false);
            }
        }
    }

    private ArrayList<String> verificarStock(Connection conn) throws SQLException {
        ArrayList<String> productosSinStock = new ArrayList<>();

        for (int i = 0; i < componentes.size(); i++) {
            if (componentes.get(i).isEnabled()) {
                int cantidadSeleccionada = (Integer) componentes.get(i).getValue();
                int stockActual = ProductoDB.obtenerCantidad(nombresProductos[i]);
                if (cantidadSeleccionada > stockActual) {
                    productosSinStock.add(nombresProductos[i]);
                }
            }
        }
        return productosSinStock;
    }

    private boolean actualizarStock(ArrayList<JSpinner> componentesSeleccionados, ArrayList<String> nombresProductosSeleccionados, Connection conn) throws SQLException {
        for (int i = 0; i < componentesSeleccionados.size(); i++) {
            String nombreProducto = nombresProductosSeleccionados.get(i);
            int cantidadComprada = (Integer) componentesSeleccionados.get(i).getValue();
            int stockActual = ProductoDB.obtenerCantidad(nombreProducto);
            if (cantidadComprada <= stockActual) {
                ProductoDB.actualizarCantidad(nombreProducto, stockActual - cantidadComprada, conn);
            } else {
                return false; // Error: Intentando comprar más de lo que hay en stock
            }
        }
        return true;
    }

    private void actualizarPreciosYCantidades() {
        try {
            Conexion conexion = new Conexion();
            Connection conn = conexion.abrirConsulta();

            for (int i = 0; i < componentes.size(); i++) {
                String nombreProducto = nombresProductos[i];
                double precio = ProductoDB.obtenerPrecio(nombreProducto);
                int cantidad = ProductoDB.obtenerCantidad(nombreProducto);

                labels.get(i).setText(String.valueOf(precio) + "€");
                componentes.get(i).setModel(new SpinnerNumberModel(0, 0, cantidad, 1));
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
