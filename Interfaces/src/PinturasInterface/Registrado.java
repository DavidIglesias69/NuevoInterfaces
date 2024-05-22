package PinturasInterface;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import PinturasDB.RegistroDB;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.util.regex.Pattern;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.text.DefaultEditorKit;
import javax.swing.KeyStroke;

public class Registrado extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField texNombre;
    private JTextField texEmail;
    private JTextField texDNI;
    private JPasswordField txtContraseña;
    private JPasswordField textRrepetirContra;
    private JLabel iconoContraseña;
    private int numPulsaciones = 0;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Registrado frame = new Registrado();
                    frame.setVisible(true);
                    frame.texNombre.requestFocusInWindow(); // Establecer el foco inicial en el campo nombre
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Registrado() {
        setTitle("Registro Usuario Nuevo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 789, 441);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panelInsertarNuevoUsuario = new JPanel();
        panelInsertarNuevoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panelInsertarNuevoUsuario.setBackground(new Color(153, 51, 204));
        panelInsertarNuevoUsuario.setLayout(null);
        panelInsertarNuevoUsuario.setBorder(new TitledBorder(
            new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.WHITE, new Color(160, 160, 160)), "", 
            TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK), 
            "Insertar Nuevo Usuario", TitledBorder.CENTER, TitledBorder.TOP, null, Color.YELLOW)
        );
        panelInsertarNuevoUsuario.setBounds(56, 38, 649, 313);
        contentPane.add(panelInsertarNuevoUsuario);

        // Campo de contraseña con tooltip explicativo
        JLabel lblContraseña = new JLabel("Contraseña*:");
        lblContraseña.setForeground(Color.BLACK);
        lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblContraseña.setBounds(137, 94, 129, 17);
        panelInsertarNuevoUsuario.add(lblContraseña);

        txtContraseña = new JPasswordField();
        txtContraseña.setBounds(291, 91, 275, 20);
        txtContraseña.setToolTipText("<html>La contraseña debe tener al menos:<br>- 8 caracteres<br>- Una letra mayúscula<br>- Una letra minúscula<br>- Un número<br>- Un carácter especial: @$!%*?&+\\-_.,:;=<>#[]{}|~`^()\"'\\</html>");
        panelInsertarNuevoUsuario.add(txtContraseña);

        // Deshabilitar copiar y pegar en el campo de contraseña
        txtContraseña.getInputMap().put(KeyStroke.getKeyStroke("ctrl C"), "none");
        txtContraseña.getInputMap().put(KeyStroke.getKeyStroke("ctrl V"), "none");
        txtContraseña.getInputMap().put(KeyStroke.getKeyStroke("ctrl X"), "none");
        txtContraseña.getInputMap().put(KeyStroke.getKeyStroke("shift INSERT"), "none");
        txtContraseña.getInputMap().put(KeyStroke.getKeyStroke("shift DELETE"), "none");

        // Campo de repetir contraseña
        JLabel lblRepetirContraseña = new JLabel("Repetir Contraseña*:");
        lblRepetirContraseña.setForeground(Color.BLACK);
        lblRepetirContraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblRepetirContraseña.setBounds(137, 119, 144, 20);
        panelInsertarNuevoUsuario.add(lblRepetirContraseña);

        textRrepetirContra = new JPasswordField();
        textRrepetirContra.setBounds(291, 120, 275, 19);
        panelInsertarNuevoUsuario.add(textRrepetirContra);

        // Deshabilitar copiar y pegar en el campo de repetir contraseña
        textRrepetirContra.getInputMap().put(KeyStroke.getKeyStroke("ctrl C"), "none");
        textRrepetirContra.getInputMap().put(KeyStroke.getKeyStroke("ctrl V"), "none");
        textRrepetirContra.getInputMap().put(KeyStroke.getKeyStroke("ctrl X"), "none");
        textRrepetirContra.getInputMap().put(KeyStroke.getKeyStroke("shift INSERT"), "none");
        textRrepetirContra.getInputMap().put(KeyStroke.getKeyStroke("shift DELETE"), "none");

        // Otros campos del formulario
        agregarCampo(panelInsertarNuevoUsuario, "Nombre:", 150, 291, 150);
        agregarCampo(panelInsertarNuevoUsuario, "Email:", 184, 291, 181);
        
        // Campo DNI con tooltip
        JLabel lblDNI = new JLabel("DNI*:");
        lblDNI.setForeground(Color.BLACK);
        lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblDNI.setBounds(137, 65, 129, 18);
        panelInsertarNuevoUsuario.add(lblDNI);

        texDNI = new JTextField();
        texDNI.setToolTipText("Formato: 12345678A");
        texDNI.setText("12345678A");
        texDNI.setForeground(Color.GRAY);
        texDNI.setColumns(10);
        texDNI.setBounds(291, 66, 275, 20);
        panelInsertarNuevoUsuario.add(texDNI);
        texDNI.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (texDNI.getText().equals("12345678A")) {
                    texDNI.setText("");
                    texDNI.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (texDNI.getText().isEmpty()) {
                    texDNI.setForeground(Color.GRAY);
                    texDNI.setText("12345678A");
                }
            }
        });

        // Botón de registrar
        JButton btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.setForeground(Color.BLACK);
        btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnRegistrarse.setIcon(new ImageIcon(Registrado.class.getResource("/resources/nota.png")));
        btnRegistrarse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });
        btnRegistrarse.setBounds(403, 223, 163, 39);
        panelInsertarNuevoUsuario.add(btnRegistrarse);
        
        // Botón para volver al panel principal
        JButton btnAtras = new JButton("Atrás");
        btnAtras.setForeground(Color.BLACK);
        btnAtras.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnAtras.setIcon(new ImageIcon(Registrado.class.getResource("/resources/flecha-hacia-atras.png")));
        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                volverAlPrincipal();
            }
        });
        btnAtras.setBounds(243, 223, 137, 39);
        panelInsertarNuevoUsuario.add(btnAtras);

        // Icono para mostrar/ocultar contraseñas
        iconoContraseña = new JLabel("");  // Usar la variable de instancia en lugar de declarar una nueva
        iconoContraseña.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                alternarVisibilidadContraseña();
            }
        });
        iconoContraseña.setHorizontalAlignment(SwingConstants.CENTER);
        iconoContraseña.setIcon(new ImageIcon(Registrado.class.getResource("/resources/ojo (1).png")));
        iconoContraseña.setBounds(578, 91, 46, 24);
        panelInsertarNuevoUsuario.add(iconoContraseña);
        
        // Fondo de la ventana
        JLabel imagenFondo = new JLabel("New label");
        imagenFondo.setIcon(new ImageIcon(Registrado.class.getResource("/resources/mancha arcoirirs.jpg")));
        imagenFondo.setBounds(-17, 0, 790, 402);
        contentPane.add(imagenFondo);
    }

    // Método para agregar campos al panel
    private void agregarCampo(JPanel panel, String label, int yLabel, int xField, int yField) {
        JLabel lblCampo = new JLabel(label);
        lblCampo.setForeground(Color.BLACK);
        lblCampo.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCampo.setBounds(137, yLabel, 82, 23);
        panel.add(lblCampo);

        JTextField textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(xField, yField, 275, 20);
        panel.add(textField);

        if (label.equals("Nombre:")) {
            texNombre = textField;
        } else if (label.equals("Email:")) {
            texEmail = textField;
        }
    }

    // Método para alternar la visibilidad de las contraseñas
    private void alternarVisibilidadContraseña() {
        numPulsaciones++;
        char echoChar = (numPulsaciones % 2 == 0) ? '*' : (char) 0;
        txtContraseña.setEchoChar(echoChar);
        textRrepetirContra.setEchoChar(echoChar);
        
        String iconoPath = (numPulsaciones % 2 == 0) ? "/resources/ojo (1).png" : "/resources/ojo.png";
        iconoContraseña.setIcon(new ImageIcon(Registrado.class.getResource(iconoPath)));
    }

    // Método para registrar usuario
    private void registrarUsuario() {
        String DNI1 = texDNI.getText().trim();
        String pass1 = new String(txtContraseña.getPassword()).trim();
        String pass2 = new String(textRrepetirContra.getPassword()).trim();
        String nombre1 = texNombre.getText().trim();
        String email1 = texEmail.getText().trim();
        
        // Validaciones
        if (DNI1.isEmpty() || pass1.isEmpty() || pass2.isEmpty()) {
            mostrarMensajeError("Los campos con * son obligatorios");
            return;
        }

        if (!Pattern.matches("\\d{8}[A-Za-z]", DNI1)) {
            mostrarMensajeError("El DNI debe tener 8 números seguidos de una letra");
            return;
        }

        if (!pass1.equals(pass2)) {
            mostrarMensajeError("Las contraseñas no coinciden");
            return;
        }

        if (pass1.trim().isEmpty()) {
            mostrarMensajeError("La contraseña no puede estar vacía ni contener solo espacios");
            return;
        }

        if (!esContraseñaSegura(pass1)) {
            mostrarMensajeError("La contraseña debe tener al menos 8 caracteres, incluyendo una letra mayúscula, una letra minúscula, un número y un carácter especial.");
            return;
        }

        // Registrar usuario en la base de datos
        try {
            boolean usuarioExiste = RegistroDB.existeUsuario(DNI1);
            if (usuarioExiste) {
                mostrarMensajeError("El usuario con este DNI ya existe");
            } else {
                RegistroDB.añadirUsuario(DNI1, nombre1, pass1, email1);
                JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
                Principal.main(null);
                dispose(); // Cerrar la ventana de registro
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            mostrarMensajeError("Error al registrar el usuario");
        }
    }

    // Método para mostrar mensajes de error
    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Método para validar la seguridad de la contraseña
    private boolean esContraseñaSegura(String contraseña) {
        String patron = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&+\\-_.,:;=<>#\\[\\]{}|~`^()\"'\\\\])[A-Za-z\\d@$!%*?&+\\-_.,:;=<>#\\[\\]{}|~`^()\"'\\\\]{8,}$";
        return Pattern.matches(patron, contraseña);
    }

    // Método para volver al panel principal
    private void volverAlPrincipal() {
        Principal.main(null);
        dispose();
    }
}
