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
    	setTitle("PANTALLA ADMINISTRADOR MODIFICAR PRODUCTOS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 901, 848);
        despegableProductos = new JPanel();
        despegableProductos.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(despegableProductos);
        despegableProductos.setLayout(null);
        
        precioDB = new JLabel("");
        precioDB.setBounds(279, 261, 162, 30);
        precioDB.setBackground(new Color(34, 34, 34)); // Color oscuro de fondo
        precioDB.setForeground(new Color(255, 255, 255)); // Letras claras
        precioDB.setFont(new Font("Tahoma", Font.PLAIN, 20)); // Tamaño de fuente 20
        precioDB.setOpaque(true);
        despegableProductos.add(precioDB);
      
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel<>(new String[]{
                "", "Pintura", "Rodillo", "Papel", "Brocha", "Escalera", "Barniz", "Disolvente", "Plasticos", "Decapante", "Espatula"}));
        comboBox.setBounds(10, 261, 206, 30);
        comboBox.setForeground(new Color(255, 128, 64));
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 22));
        despegableProductos.add(comboBox);

        JLabel lblNewLabel_1 = new JLabel("PRODUCTO");
        lblNewLabel_1.setForeground(new Color(255, 0, 0));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblNewLabel_1.setBounds(42, 208, 153, 28);
        despegableProductos.add(lblNewLabel_1);

        JLabel precio = new JLabel("PRECIO");
        precio.setForeground(new Color(64, 0, 128));
        precio.setFont(new Font("Tahoma", Font.BOLD, 22));
        precio.setHorizontalAlignment(SwingConstants.CENTER);
        precio.setBounds(300, 201, 129, 42);
        despegableProductos.add(precio);

        JButton btnNewButton = new JButton("AÑADIR");
        btnNewButton.setIcon(new ImageIcon(Administrador.class.getResource("/resources/anadir-al-carrito.png")));
        btnNewButton.setBounds(493, 371, 122, 35);
        despegableProductos.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("ELIMINAR");
        btnNewButton_1.setIcon(new ImageIcon(Administrador.class.getResource("/resources/boton-eliminar.png")));
        btnNewButton_1.setBounds(644, 371, 122, 35);
        despegableProductos.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("CAMBIAR PRECIO");
        btnNewButton_2.setIcon(new ImageIcon(Administrador.class.getResource("/resources/euro.png")));
        btnNewButton_2.setBounds(265, 371, 176, 35);
        despegableProductos.add(btnNewButton_2);

        txtNuevoPrecio = new JTextField();
        txtNuevoPrecio.setBounds(299, 336, 96, 22);
        despegableProductos.add(txtNuevoPrecio);
        txtNuevoPrecio.setColumns(10);

        JLabel lblNuevoPrecio = new JLabel("NUEVO PRECIO:");
        lblNuevoPrecio.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNuevoPrecio.setHorizontalAlignment(SwingConstants.CENTER);
        lblNuevoPrecio.setBounds(149, 335, 134, 20);
        despegableProductos.add(lblNuevoPrecio);

        spinner = new JSpinner(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spinner.setBounds(603, 334, 48, 26);
        despegableProductos.add(spinner);

        cantidadDB = new JLabel(""); 
        cantidadDB.setBounds(556, 261, 147, 30);
        cantidadDB.setBackground(new Color(34, 34, 34)); // Color oscuro de fondo
        cantidadDB.setForeground(new Color(255, 255, 255)); // Letras claras
        cantidadDB.setFont(new Font("Tahoma", Font.PLAIN, 20)); // Tamaño de fuente 20
        cantidadDB.setOpaque(true);
        despegableProductos.add(cantidadDB);

        setupActionListeners(comboBox, btnNewButton, btnNewButton_1, btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("SALIR");
        btnNewButton_3.setIcon(new ImageIcon(Administrador.class.getResource("/resources/boton.png")));
        btnNewButton_3.setBounds(726, 631, 122, 31);
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar el panel actual
                dispose();
                Principal.main(null);
               
            }
        });
        despegableProductos.add(btnNewButton_3);
                
        JLabel lblCantidad = new JLabel("CANTIDAD");
        lblCantidad.setForeground(new Color(0, 0, 128));
        lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
        lblCantidad.setBounds(556, 202, 147, 48);
        despegableProductos.add(lblCantidad);
               
        JLabel lblNewLabel = new JLabel(new ImageIcon(Administrador.class.getResource("/resources/mancha arcoirirs.jpg")));
        lblNewLabel.setBounds(0, 0, 885, 809);
        despegableProductos.add(lblNewLabel);
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
                JOptionPane.showMessageDialog(null, "Producto agregado y stock actualizado correctamente.");
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
                JOptionPane.showMessageDialog(null, "Producto eliminado y stock actualizado correctamente.");
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
            precioDB.setText(String.format("%.2f €", precio) + " EUROS.");
            int cantidad = ProductoDB.obtenerCantidad(nombreProducto.toLowerCase());
            cantidadDB.setText(String.valueOf(cantidad) + " EN STOCK."); // Mostrar cantidad como entero
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al obtener el precio: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            precioDB.setText("Error");
            cantidadDB.setText("Error");
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            
        });
    }
}
