package PinturasInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.List;

import ProyectoPinturas.Usuario;
import PinturasDB.RegistroDB;
import ProyectoPinturas.BCrypt;

public class PanelUsuario extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField dniField;
    private JTextField nombreField;
    private JTextField contraseñaField; // Cambiado a JTextField
    private JTextField emailField;
    private JCheckBox responsableCheckBox;
    private JButton btnActualizar;
    private JButton btnEliminar;

    public PanelUsuario() {
        setLayout(new BorderLayout());

        // Crear el modelo de la tabla
        tableModel = new DefaultTableModel(new Object[]{"DNI", "Nombre", "Contraseña", "Email", "Responsable"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(tableModel);

        // Evitar que las columnas se puedan mover
        table.getTableHeader().setReorderingAllowed(false);

        // Añadir un MouseListener para seleccionar un usuario y cargar sus datos en los textfields
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    dniField.setText((String) tableModel.getValueAt(selectedRow, 0));
                    nombreField.setText((String) tableModel.getValueAt(selectedRow, 1));
                    emailField.setText((String) tableModel.getValueAt(selectedRow, 3));
                    responsableCheckBox.setSelected((Boolean) tableModel.getValueAt(selectedRow, 4));

                    // Mostrar la contraseña sin cifrar
                    String hashedPassword = (String) tableModel.getValueAt(selectedRow, 2);
                    contraseñaField.setText(hashedPassword); // Cambiado para mostrar la contraseña cifrada directamente
                }
            }
        });

        // Añadir la tabla al panel con un scroll
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Panel para los controles de entrada
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());

        // Campo de texto para el DNI del usuario
        GridBagConstraints gbcDniLabel = new GridBagConstraints();
        gbcDniLabel.insets = new Insets(5, 5, 5, 5);
        gbcDniLabel.fill = GridBagConstraints.HORIZONTAL;
        gbcDniLabel.gridx = 0;
        gbcDniLabel.gridy = 0;
        gbcDniLabel.anchor = GridBagConstraints.EAST;
        inputPanel.add(new JLabel("DNI:"), gbcDniLabel);
        dniField = new JTextField(20);
        GridBagConstraints gbcDniField = new GridBagConstraints();
        gbcDniField.insets = new Insets(5, 5, 5, 5);
        gbcDniField.fill = GridBagConstraints.HORIZONTAL;
        gbcDniField.gridx = 1;
        gbcDniField.gridy = 0;
        inputPanel.add(dniField, gbcDniField);

        // Campo de texto para el nombre del usuario
        GridBagConstraints gbcNombreLabel = new GridBagConstraints();
        gbcNombreLabel.insets = new Insets(5, 5, 5, 5);
        gbcNombreLabel.fill = GridBagConstraints.HORIZONTAL;
        gbcNombreLabel.gridx = 0;
        gbcNombreLabel.gridy = 1;
        gbcNombreLabel.anchor = GridBagConstraints.EAST;
        inputPanel.add(new JLabel("Nombre:"), gbcNombreLabel);
        nombreField = new JTextField(20);
        GridBagConstraints gbcNombreField = new GridBagConstraints();
        gbcNombreField.insets = new Insets(5, 5, 5, 5);
        gbcNombreField.fill = GridBagConstraints.HORIZONTAL;
        gbcNombreField.gridx = 1;
        gbcNombreField.gridy = 1;
        inputPanel.add(nombreField, gbcNombreField);

        // Campo de texto para la contraseña del usuario
        GridBagConstraints gbcContraseñaLabel = new GridBagConstraints();
        gbcContraseñaLabel.insets = new Insets(5, 5, 5, 5);
        gbcContraseñaLabel.fill = GridBagConstraints.HORIZONTAL;
        gbcContraseñaLabel.gridx = 0;
        gbcContraseñaLabel.gridy = 2;
        gbcContraseñaLabel.anchor = GridBagConstraints.EAST;
        inputPanel.add(new JLabel("Contraseña:"), gbcContraseñaLabel);
        contraseñaField = new JTextField(20); // Cambiado a JTextField
        GridBagConstraints gbcContraseñaField = new GridBagConstraints();
        gbcContraseñaField.insets = new Insets(5, 5, 5, 5);
        gbcContraseñaField.fill = GridBagConstraints.HORIZONTAL;
        gbcContraseñaField.gridx = 1;
        gbcContraseñaField.gridy = 2;
        inputPanel.add(contraseñaField, gbcContraseñaField);

        // Campo de texto para el email del usuario
        GridBagConstraints gbcEmailLabel = new GridBagConstraints();
        gbcEmailLabel.insets = new Insets(5, 5, 5, 5);
        gbcEmailLabel.fill = GridBagConstraints.HORIZONTAL;
        gbcEmailLabel.gridx = 0;
        gbcEmailLabel.gridy = 3;
        gbcEmailLabel.anchor = GridBagConstraints.EAST;
        inputPanel.add(new JLabel("Email:"), gbcEmailLabel);
        emailField = new JTextField(20);
        GridBagConstraints gbcEmailField = new GridBagConstraints();
        gbcEmailField.insets = new Insets(5, 5, 5, 5);
        gbcEmailField.fill = GridBagConstraints.HORIZONTAL;
        gbcEmailField.gridx = 1;
        gbcEmailField.gridy = 3;
        inputPanel.add(emailField, gbcEmailField);

        // CheckBox para el rol de responsable
        GridBagConstraints gbcResponsableLabel = new GridBagConstraints();
        gbcResponsableLabel.insets = new Insets(5, 5, 5, 5);
        gbcResponsableLabel.fill = GridBagConstraints.HORIZONTAL;
        gbcResponsableLabel.gridx = 0;
        gbcResponsableLabel.gridy = 4;
        gbcResponsableLabel.anchor = GridBagConstraints.EAST;
        inputPanel.add(new JLabel("Responsable:"), gbcResponsableLabel);
        responsableCheckBox = new JCheckBox();
        GridBagConstraints gbcResponsableField = new GridBagConstraints();
        gbcResponsableField.insets = new Insets(5, 5, 5, 5);
        gbcResponsableField.fill = GridBagConstraints.HORIZONTAL;
        gbcResponsableField.gridx = 1;
        gbcResponsableField.gridy = 4;
        inputPanel.add(responsableCheckBox, gbcResponsableField);

        add(inputPanel, BorderLayout.NORTH);

        // Panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Botón para actualizar usuarios
        btnActualizar = new JButton("Actualizar Usuario");
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOrUpdateUsuario();
            }
        });
        buttonPanel.add(btnActualizar);

        // Botón para eliminar usuarios
        btnEliminar = new JButton("Eliminar Usuario");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteUsuario();
            }
        });

        // Añadir el tooltip al pasar el ratón sobre el botón de eliminar
        btnEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnEliminar.setToolTipText("Si el usuario realizó compras, se debe eliminar desde BBDD");
            }
        });
        buttonPanel.add(btnEliminar);

        // Botón para salir del panel
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salir();
            }
        });
        buttonPanel.add(btnSalir);

        add(buttonPanel, BorderLayout.SOUTH);

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
        String contraseña = contraseñaField.getText(); // Cambiado para obtener la contraseña directamente
        String email = emailField.getText();
        int responsable = responsableCheckBox.isSelected() ? 1 : 0;

        try {
            if (RegistroDB.existeUsuario(dni)) {
                // Crear el usuario existente para actualizarlo
                Usuario usuarioExistente = new Usuario(dni, contraseña, nombre, email, responsable); // Contraseña sin cifrar
                RegistroDB.actualizarUsuario(usuarioExistente);
                JOptionPane.showMessageDialog(this, "Usuario actualizado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Añadir nuevo usuario
                RegistroDB.añadirUsuario(dni, nombre, contraseña, email); // Contraseña sin cifrar
                JOptionPane.showMessageDialog(this, "Usuario añadido correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
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

            int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar este usuario?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    // Eliminar el usuario seleccionado
                    RegistroDB.eliminarUsuario(dni);
                    // Recargar los usuarios en la tabla
                    cargarUsuarios();
                    JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error al eliminar usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void salir() {
        // Implementa la lógica para salir del panel
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
    }

    private String getPlainPasswordFromHash(String hashedPassword) {
        // Aquí necesitarías obtener la contraseña sin cifrar de alguna forma segura
        // Dado que BCrypt es un hash unidireccional, no es posible obtener la contraseña original
        // Esta función no hará nada útil en la realidad, por lo que debes gestionar esto según tus necesidades

        return hashedPassword; // Retornamos la contraseña cifrada como está
    }
}
