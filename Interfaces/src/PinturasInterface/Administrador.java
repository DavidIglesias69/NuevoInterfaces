package PinturasInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PinturasDB.ProductoDB;
import ProyectoPinturas.Usuario;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

public class Administrador extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel despegableProductos;
    private JLabel precioDB;  // Atributo de clase para precioDB
    private JLabel cantidadDB;

    public Administrador(Usuario user) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 901, 848);
        despegableProductos = new JPanel();
        despegableProductos.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(despegableProductos);
        despegableProductos.setLayout(null);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"", "Pintura", "Rodillo", "Papel", "Brocha", "Escalera", "Barniz", "Disolvente", "Plasticos", "Decapante", "Espatula"}));
        comboBox.setForeground(new Color(255, 128, 64));
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
        comboBox.setBounds(80, 95, 168, 22);
        despegableProductos.add(comboBox);

        JLabel lblNewLabel_1 = new JLabel("Producto");
        lblNewLabel_1.setBounds(139, 67, 46, 14);
        despegableProductos.add(lblNewLabel_1);

        JLabel precio = new JLabel("precio");
        precio.setBounds(276, 67, 46, 14);
        despegableProductos.add(precio);

        JButton btnNewButton = new JButton("Añadir");
        btnNewButton.setBounds(507, 94, 89, 23);
        despegableProductos.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("eliminar");
        btnNewButton_1.setBounds(622, 94, 89, 23);
        despegableProductos.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("cambiar precio");
        btnNewButton_2.setBounds(741, 94, 114, 23);
        despegableProductos.add(btnNewButton_2);

        JSpinner spinner = new JSpinner();
        spinner.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spinner.setBounds(432, 96, 48, 20);
        despegableProductos.add(spinner);

        JLabel lblCantidad = new JLabel("cantidad");
        lblCantidad.setBounds(351, 67, 46, 14);
        despegableProductos.add(lblCantidad);

        // Inicializa el precioDB que ya está declarado como atributo de la clase
        precioDB = new JLabel("");
        precioDB.setBounds(275, 103, 100, 14); // Ajusta el tamaño según sea necesario
        despegableProductos.add(precioDB);

        cantidadDB = new JLabel("");
        cantidadDB.setBounds(351, 103, 46, 14);
        despegableProductos.add(cantidadDB);

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedIndex() != 0) {
                    String productoSeleccionado = comboBox.getSelectedItem().toString();
                    actualizarPrecio(productoSeleccionado);
                } else {
                    precioDB.setText(""); // Limpiar el texto si no se selecciona un producto
                }
            }
        });
    }

    private void actualizarPrecio(String nombreProducto) {
        try {
            double precio = ProductoDB.obtenerPrecio(nombreProducto.toLowerCase());
            precioDB.setText(String.format("%.2f €", precio));
            
            double cant = ProductoDB.obtenerCantidad(nombreProducto);
            cantidadDB.setText(String.format("%.2f ", cant));
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al obtener el precio: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            precioDB.setText("Error");
        }
    }

}
