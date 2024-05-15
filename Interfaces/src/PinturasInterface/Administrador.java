package PinturasInterface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import PinturasDB.AdministradorDB;
import PinturasDB.ProductoDB;
import ProyectoPinturas.Usuario;

public class Administrador extends JFrame {

    private JPanel despegableProductos;
    private JLabel precioDB;
    private JLabel cantidadDB;
    private JTextField txtNuevoPrecio;
    private JSpinner spinner;

    public Administrador(Usuario user) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 901, 848);
        despegableProductos = new JPanel();
        despegableProductos.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(despegableProductos);
        despegableProductos.setLayout(null);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel<>(new String[]{
                "", "Pintura", "Rodillo", "Papel", "Brocha", "Escalera", "Barniz", "Disolvente", "Plasticos", "Decapante", "Espatula"}));
        comboBox.setBounds(80, 95, 168, 22);
        comboBox.setForeground(new Color(255, 128, 64));
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
        despegableProductos.add(comboBox);

        JLabel lblNewLabel_1 = new JLabel("Producto");
        lblNewLabel_1.setBounds(139, 67, 46, 14);
        despegableProductos.add(lblNewLabel_1);

        JLabel precio = new JLabel("Precio");
        precio.setBounds(276, 67, 46, 14);
        despegableProductos.add(precio);

        JButton btnNewButton = new JButton("Añadir");
        btnNewButton.setBounds(490, 94, 122, 23);
        despegableProductos.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Eliminar");
        btnNewButton_1.setBounds(616, 94, 122, 23);
        despegableProductos.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Cambiar precio");
        btnNewButton_2.setBounds(741, 94, 134, 23);
        despegableProductos.add(btnNewButton_2);

        txtNuevoPrecio = new JTextField();
        txtNuevoPrecio.setBounds(600, 130, 86, 20);
        despegableProductos.add(txtNuevoPrecio);
        txtNuevoPrecio.setColumns(10);

        JLabel lblNuevoPrecio = new JLabel("Nuevo Precio:");
        lblNuevoPrecio.setBounds(490, 130, 100, 20);
        despegableProductos.add(lblNuevoPrecio);

        spinner = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
        spinner.setBounds(432, 96, 48, 20);
        despegableProductos.add(spinner);

        precioDB = new JLabel("");
        precioDB.setBounds(275, 103, 46, 14);
        precioDB.setBackground(new Color(0, 255, 102));
        precioDB.setForeground(new Color(204, 51, 153));
        despegableProductos.add(precioDB);

        cantidadDB = new JLabel("");
        cantidadDB.setBounds(351, 103, 46, 14);
        cantidadDB.setBackground(Color.GREEN);
        despegableProductos.add(cantidadDB);

        JLabel lblNewLabel = new JLabel(new ImageIcon(getClass().getResource("/resources/mancha arcoiris.jpg")));
        lblNewLabel.setBounds(0, 0, 885, 698);
        despegableProductos.add(lblNewLabel);

        setupActionListeners(comboBox, btnNewButton, btnNewButton_1, btnNewButton_2);
    }

    private void setupActionListeners(JComboBox<String> comboBox, JButton btnAdd, JButton btnRemove, JButton btnChangePrice) {
        comboBox.addActionListener(e -> {
            if (comboBox.getSelectedIndex() != 0) {
                String productoSeleccionado = comboBox.getSelectedItem().toString();
                actualizarPrecio(productoSeleccionado);
                txtNuevoPrecio.setText("");  // Limpiar el campo de nuevo precio
            } else {
                precioDB.setText(""); // Limpiar el texto si no se selecciona un producto
            }
        });

        btnAdd.addActionListener(e -> {
            int cantidad = (Integer) spinner.getValue();
            String productoSeleccionado = comboBox.getSelectedItem().toString();
            try {
                AdministradorDB.añadirProducto(productoSeleccionado, cantidad);
                actualizarPrecio(productoSeleccionado);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al añadir producto: " + ex.getMessage());
            }
        });

        btnRemove.addActionListener(e -> {
            int cantidad = (Integer) spinner.getValue();
            String productoSeleccionado = comboBox.getSelectedItem().toString();
            try {
                AdministradorDB.eliminarProducto(productoSeleccionado, cantidad);
                actualizarPrecio(productoSeleccionado);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al eliminar producto: " + ex.getMessage());
            }
        });

        btnChangePrice.addActionListener(e -> {
            String productoSeleccionado = comboBox.getSelectedItem().toString();
            String inputPrecio = txtNuevoPrecio.getText();
            if (inputPrecio != null && !inputPrecio.isEmpty()) {
                try {
                    double nuevoPrecio = Double.parseDouble(inputPrecio);
                    AdministradorDB.actualizarPrecio(productoSeleccionado, nuevoPrecio);
                    actualizarPrecio(productoSeleccionado);
                    JOptionPane.showMessageDialog(null, "Precio actualizado correctamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar precio: " + ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un precio.");
            }
        });
    }

    private void actualizarPrecio(String nombreProducto) {
        try {
            double precio = ProductoDB.obtenerPrecio(nombreProducto.toLowerCase());
            precioDB.setText(String.format("%.2f €", precio));
            double cantidad = ProductoDB.obtenerCantidad(nombreProducto);
            cantidadDB.setText(String.format("%.2f", cantidad));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al obtener el precio: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            precioDB.setText("Error");
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
           
        });
    }
}
