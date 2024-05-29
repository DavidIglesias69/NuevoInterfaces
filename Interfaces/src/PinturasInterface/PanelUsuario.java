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
    private JTextField emailField;
    private JCheckBox responsableCheckBox;
    private JButton btnActualizar;
    private JButton btnEliminar;

    public PanelUsuario() {
        setLayout(new BorderLayout());
        setBackground(Color.DARK_GRAY);

        // Crear el modelo de la tabla
        tableModel = new DefaultTableModel(new Object[]{"DNI", "Nombre", "Email", "Responsable"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(tableModel);
        table.setBackground(Color.DARK_GRAY);
        table.setForeground(Color.WHITE);
        table.getTableHeader().setBackground(Color.DARK_GRAY);
        table.getTableHeader().setForeground(Color.WHITE);

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
                    emailField.setText((String) tableModel.getValueAt(selectedRow, 2));
                    responsableCheckBox.setSelected((Boolean) tableModel.getValueAt(selectedRow, 3));
                }
            }
        });

        // Añadir la tabla al panel con un scroll
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Panel para los controles de entrada
        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.DARK_GRAY);
        inputPanel.setLayout(new GridBagLayout());

        // Campo de texto para el DNI del usuario
        GridBagConstraints gbcDniLabel = new GridBagConstraints();
        gbcDniLabel.insets = new Insets(5, 5, 5, 5);
        gbcDniLabel.fill = GridBagConstraints.HORIZONTAL;
        gbcDniLabel.gridx = 0;
        gbcDniLabel.gridy = 0;
        gbcDniLabel.anchor = GridBagConstraints.EAST;
        JLabel dniLabel = new JLabel("DNI:");
        dniLabel.setForeground(Color.WHITE);
        inputPanel.add(dniLabel, gbcDniLabel);
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
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setForeground(Color.WHITE);
        inputPanel.add(nombreLabel, gbcNombreLabel);
        nombreField = new JTextField(20);
        GridBagConstraints gbcNombreField = new GridBagConstraints();
        gbcNombreField.insets = new Insets(5, 5, 5, 5);
        gbcNombreField.fill = GridBagConstraints.HORIZONTAL;
        gbcNombreField.gridx = 1;
        gbcNombreField.gridy = 1;
        inputPanel.add(nombreField, gbcNombreField);

        // Campo de texto para el email del usuario
        GridBagConstraints gbcEmailLabel = new GridBagConstraints();
        gbcEmailLabel.insets = new Insets(5, 5, 5, 5);
        gbcEmailLabel.fill = GridBagConstraints.HORIZONTAL;
        gbcEmailLabel.gridx = 0;
        gbcEmailLabel.gridy = 2;
        gbcEmailLabel.anchor = GridBagConstraints.EAST;
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE);
        inputPanel.add(emailLabel, gbcEmailLabel);
        emailField = new JTextField(20);
        GridBagConstraints gbcEmailField = new GridBagConstraints();
        gbcEmailField.insets = new Insets(5, 5, 5, 5);
        gbcEmailField.fill = GridBagConstraints.HORIZONTAL;
        gbcEmailField.gridx = 1;
        gbcEmailField.gridy = 2;
        inputPanel.add(emailField, gbcEmailField);

        // CheckBox para el rol de responsable
        GridBagConstraints gbcResponsableLabel = new GridBagConstraints();
        gbcResponsableLabel.insets = new Insets(5, 5, 5, 5);
        gbcResponsableLabel.fill = GridBagConstraints.HORIZONTAL;
        gbcResponsableLabel.gridx = 0;
        gbcResponsableLabel.gridy = 3;
        gbcResponsableLabel.anchor = GridBagConstraints.EAST;
        JLabel responsableLabel = new JLabel("Responsable:");
        responsableLabel.setForeground(Color.WHITE);
        inputPanel.add(responsableLabel, gbcResponsableLabel);
        responsableCheckBox = new JCheckBox();
        GridBagConstraints gbcResponsableField = new GridBagConstraints();
        gbcResponsableField.anchor = GridBagConstraints.WEST;
        gbcResponsableField.insets = new Insets(5, 5, 5, 5);
        gbcResponsableField.gridx = 1;
        gbcResponsableField.gridy = 3;
        inputPanel.add(responsableCheckBox, gbcResponsableField);

        add(inputPanel, BorderLayout.NORTH);

        // Panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.DARK_GRAY);

        // Botón para actualizar usuarios
        btnActualizar = new JButton("Actualizar Usuario");
        btnActualizar.setBackground(Color.RED);
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOrUpdateUsuario();
            }
        });
        buttonPanel.add(btnActualizar);

        // Botón para eliminar usuarios
        btnEliminar = new JButton("Eliminar Usuario");
        btnEliminar.setBackground(Color.RED);
        btnEliminar.setForeground(Color.WHITE);
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
        btnSalir.setBackground(Color.RED);
        btnSalir.setForeground(Color.WHITE);
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
                    tableModel.addRow(new Object[]{usuario.getDNI(), usuario.getNombre(), usuario.getEmail(), usuario.isResponsable() == 1});
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar usuarios: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addOrUpdateUsuario() {
        String dni = dniField.getText();
        String nombre = nombreField.getText();
        String email = emailField.getText();
        int responsable = responsableCheckBox.isSelected() ? 1 : 0;

        try {
            if (RegistroDB.existeUsuario(dni)) {
                // Crear el usuario existente para actualizarlo
                Usuario usuarioExistente = new Usuario(dni, null, nombre, email, responsable); // Contraseña no se actualiza
                RegistroDB.actualizarUsuario(usuarioExistente);
                JOptionPane.showMessageDialog(this, "Usuario actualizado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Añadir nuevo usuario
                String contraseña = ""; // Contraseña vacía ya que no se gestiona desde aquí
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
}
