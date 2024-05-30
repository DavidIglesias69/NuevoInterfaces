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
    private JSpinner spinnerModificarProducto;
   
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
      
        JComboBox<String> despegableProducto = new JComboBox<>();
        despegableProducto.setModel(new DefaultComboBoxModel<>(new String[]{
                "", "Pintura", "Rodillo", "Papel", "Brocha", "Escalera", "Barniz", "Disolvente", "Plasticos", "Decapante", "Espatula"}));
        despegableProducto.setBounds(10, 261, 206, 30);
        despegableProducto.setForeground(new Color(255, 128, 64));
        despegableProducto.setFont(new Font("Tahoma", Font.BOLD, 22));
        despegableProductos.add(despegableProducto);

        JLabel nombreProducto = new JLabel("PRODUCTO");
        nombreProducto.setForeground(new Color(255, 0, 0));
        nombreProducto.setHorizontalAlignment(SwingConstants.CENTER);
        nombreProducto.setFont(new Font("Tahoma", Font.BOLD, 22));
        nombreProducto.setBounds(42, 208, 153, 28);
        despegableProductos.add(nombreProducto);

        JLabel nombrePrecio = new JLabel("PRECIO");
        nombrePrecio.setForeground(new Color(64, 0, 128));
        nombrePrecio.setFont(new Font("Tahoma", Font.BOLD, 22));
        nombrePrecio.setHorizontalAlignment(SwingConstants.CENTER);
        nombrePrecio.setBounds(300, 201, 129, 42);
        despegableProductos.add(nombrePrecio);

        JButton botonAñadir = new JButton("AÑADIR");
        botonAñadir.setIcon(new ImageIcon(Administrador.class.getResource("/resources/anadir-al-carrito.png")));
        botonAñadir.setBounds(493, 371, 122, 35);
        despegableProductos.add(botonAñadir);

        JButton botonEliminar = new JButton("ELIMINAR");
        botonEliminar.setIcon(new ImageIcon(Administrador.class.getResource("/resources/boton-eliminar.png")));
        botonEliminar.setBounds(644, 371, 122, 35);
        despegableProductos.add(botonEliminar);

        JButton botonCambiarPrecio = new JButton("CAMBIAR PRECIO");
        botonCambiarPrecio.setIcon(new ImageIcon(Administrador.class.getResource("/resources/euro.png")));
        botonCambiarPrecio.setBounds(265, 371, 176, 35);
        despegableProductos.add(botonCambiarPrecio);

        txtNuevoPrecio = new JTextField();
        txtNuevoPrecio.setBounds(299, 336, 96, 22);
        despegableProductos.add(txtNuevoPrecio);
        txtNuevoPrecio.setColumns(10);
        txtNuevoPrecio.setEditable(false); // Hacer que el campo no sea editable

        JLabel lblNuevoPrecio = new JLabel("NUEVO PRECIO:");
        lblNuevoPrecio.setBackground(new Color(0, 64, 0));
        lblNuevoPrecio.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNuevoPrecio.setHorizontalAlignment(SwingConstants.CENTER);
        lblNuevoPrecio.setBounds(149, 335, 134, 20);
        despegableProductos.add(lblNuevoPrecio);

        spinnerModificarProducto = new JSpinner(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(0), null, Integer.valueOf(1)));
        spinnerModificarProducto.setBounds(603, 334, 48, 26);
        despegableProductos.add(spinnerModificarProducto);

        JComponent editor = spinnerModificarProducto.getEditor();
        JFormattedTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();
        textField.setEditable(false); // Hacer que el campo no sea editable

        cantidadDB = new JLabel(""); 
        cantidadDB.setBounds(556, 261, 147, 30);
        cantidadDB.setBackground(new Color(34, 34, 34)); // Color oscuro de fondo
        cantidadDB.setForeground(new Color(255, 255, 255)); // Letras claras
        cantidadDB.setFont(new Font("Tahoma", Font.PLAIN, 20)); // Tamaño de fuente 20
        cantidadDB.setOpaque(true);
        despegableProductos.add(cantidadDB);

        setupAccionListeners(despegableProducto, botonAñadir, botonEliminar, botonCambiarPrecio);
        
        JButton botonSalir = new JButton("SALIR");
        botonSalir.setIcon(new ImageIcon(Administrador.class.getResource("/resources/boton.png")));
        botonSalir.setBounds(726, 631, 122, 31);
        botonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar el panel actual
                dispose();
                Principal.main(null);
            }
        });
        despegableProductos.add(botonSalir);
                
        JLabel nombreCantidad = new JLabel("CANTIDAD");
        nombreCantidad.setForeground(new Color(0, 0, 128));
        nombreCantidad.setFont(new Font("Tahoma", Font.BOLD, 22));
        nombreCantidad.setHorizontalAlignment(SwingConstants.CENTER);
        nombreCantidad.setBounds(556, 202, 147, 48);
        despegableProductos.add(nombreCantidad);
        
        JButton botonUsuario = new JButton("GESTIONAR USUARIOS");
        botonUsuario.setIcon(new ImageIcon(Administrador.class.getResource("/resources/usuario.png")));
        botonUsuario.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                JFrame frameUsuarios = new JFrame("Gestión de Usuarios");
                frameUsuarios.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frameUsuarios.setSize(600, 400);
                frameUsuarios.getContentPane().add(new PanelUsuario());
                frameUsuarios.setVisible(true);

        		
        	}
        });
        botonUsuario.setBounds(472, 631, 217, 31);
        despegableProductos.add(botonUsuario);               
        JLabel lblNewLabel = new JLabel(new ImageIcon(Administrador.class.getResource("/resources/mancha arcoirirs.jpg")));
        lblNewLabel.setBounds(0, 0, 885, 809);
        despegableProductos.add(lblNewLabel);
    }

    private void setupAccionListeners(JComboBox<String> comboBox, JButton btnAdd, JButton btnEliminar, JButton btnActualizarPrecio) {
        comboBox.addActionListener(e -> {
            if (comboBox.getSelectedIndex() != 0) {
                String productoSeleccionado = comboBox.getSelectedItem().toString();
                actualizarPrecio(productoSeleccionado);
                txtNuevoPrecio.setText("");  // Limpiar el campo de nuevo precio
                txtNuevoPrecio.setEditable(true); // Hacer el campo editable solo cuando se selecciona un producto
            } else {
                precioDB.setText(""); // Limpiar el texto si no se selecciona un producto
                txtNuevoPrecio.setEditable(false); // Hacer el campo no editable
            }
        });

        btnAdd.addActionListener(e -> {
            int cantidad = (Integer) spinnerModificarProducto.getValue();
            String productoSeleccionado = comboBox.getSelectedItem().toString();
            try {
                AdministradorDB.añadirProducto(productoSeleccionado, cantidad);
                actualizarPrecio(productoSeleccionado);
                JOptionPane.showMessageDialog(null, "Producto agregado y stock actualizado correctamente.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al añadir producto: " + ex.getMessage());
            }
        });

        btnEliminar.addActionListener(e -> {
            int cantidad = (Integer) spinnerModificarProducto.getValue();
            String productoSeleccionado = comboBox.getSelectedItem().toString();
            try {
                AdministradorDB.eliminarProducto(productoSeleccionado, cantidad);
                actualizarPrecio(productoSeleccionado);
                JOptionPane.showMessageDialog(null, "Producto eliminado y stock actualizado correctamente.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al eliminar producto: " + ex.getMessage());
            }
        });

        btnActualizarPrecio.addActionListener(e -> {
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
            // Aquí puedes iniciar la ventana del administrador para pruebas
            // new Administrador(new Usuario()).setVisible(true);
        });
    }
}
