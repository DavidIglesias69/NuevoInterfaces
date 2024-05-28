package PinturasInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import ProyectoPinturas.Usuario;
import PinturasDB.RegistroDB;

public class PanelUsuario extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField dniField;
    private JTextField nombreField;
    private JPasswordField contraseñaField;
    private JTextField emailField;
    private JCheckBox responsableCheckBox;

    public PanelUsuario() {
        setLayout(new BorderLayout());

        // Crear el modelo de la tabla
        tableModel = new DefaultTableModel(new Object[]{"DNI", "Nombre", "Contraseña", "Email", "Responsable"}, 0);
        table = new JTable(tableModel);

        // Añadir la tabla al panel con un scroll
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Panel para los controles de entrada
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));

        // Campo de texto para el DNI del usuario
        inputPanel.add(new JLabel("DNI:"));
        dniField = new JTextField();
        inputPanel.add(dniField);

        // Campo de texto para el nombre del usuario
        inputPanel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        inputPanel.add(nombreField);

        // Campo de texto para la contraseña del usuario
        inputPanel.add(new JLabel("Contraseña:"));
        contraseñaField = new JPasswordField();
        inputPanel.add(contraseñaField);

        // Campo de texto para el email del usuario
        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        // CheckBox para el rol de responsable
        inputPanel.add(new JLabel("Responsable:"));
        responsableCheckBox = new JCheckBox();
        inputPanel.add(responsableCheckBox);

        // Botón para añadir o actualizar usuarios
        JButton addButton = new JButton("Añadir/Actualizar Usuario");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOrUpdateUsuario();
            }
        });
        inputPanel.add(addButton);

        // Botón para eliminar usuarios
        JButton deleteButton = new JButton("Eliminar Usuario");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteUsuario();
            }
        });
        inputPanel.add(deleteButton);

        add(inputPanel, BorderLayout.SOUTH);

        // Cargar los usuarios al iniciar
        cargarUsuarios();
    }

    private void cargarUsuarios() {
        // Limpiar el modelo de la tabla
        tableModel.setRowCount(0);

        try {
            // Obtener los usuarios desde la base de datos
            List<Usuario> usuarios = RegistroDB.obtenerTodosLosUsuarios();
            if (usuarios != null) {
                for (Usuario usuario : usuarios) {
                    // Agregar cada usuario al modelo de la tabla
                    tableModel.addRow(new Object[]{usuario.getDNI(), usuario.getNombre(), usuario.getPassword(), usuario.getEmail(), usuario.isResponsable() == 1});
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar usuarios: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addOrUpdateUsuario() {
        String dni = dniField.getText();
        String nombre = nombreField.getText();
        String contraseña = new String(contraseñaField.getPassword());
        String email = emailField.getText();
        int responsable = responsableCheckBox.isSelected() ? 1 : 0;

        try {
            if (RegistroDB.existeUsuario(dni)) {
                // Crear el usuario existente para actualizarlo
                Usuario usuarioExistente = new Usuario(dni, contraseña, nombre, email, responsable);
                actualizarUsuario(usuarioExistente);
            } else {
                // Añadir nuevo usuario
                RegistroDB.añadirUsuario(dni, nombre, contraseña, email);
            }
            // Recargar los usuarios en la tabla
            cargarUsuarios();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al añadir/actualizar usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteUsuario() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String dni = (String) tableModel.getValueAt(selectedRow, 0);

            try {
                // Eliminar el usuario seleccionado
                eliminarUsuario(dni);
                // Recargar los usuarios en la tabla
                cargarUsuarios();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Métodos adicionales necesarios
    private List<Usuario> obtenerTodosLosUsuarios() throws SQLException {
        // Implementa la lógica para obtener todos los usuarios desde la base de datos
        // Este método debe ser definido en tu clase RegistroDB
        return null;
    }

    private void actualizarUsuario(Usuario usuario) throws SQLException {
        // Implementa la lógica para actualizar un usuario en la base de datos
        // Este método debe ser definido en tu clase RegistroDB
    }

    private void eliminarUsuario(String dni) throws SQLException {
        // Implementa la lógica para eliminar un usuario en la base de datos
        // Este método debe ser definido en tu clase RegistroDB
    }
}
