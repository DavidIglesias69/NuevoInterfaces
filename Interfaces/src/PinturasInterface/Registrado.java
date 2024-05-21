package PinturasInterface;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import PinturasDB.RegistroDB;
import ProyectoPinturas.Usuario;
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

public class Registrado extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    Usuario usuario_logueado;    
    private JTextField texNombre;
    private JTextField texEmail;
    private JTextField texDNI;
    private JPasswordField txtContraseña;
    private JPasswordField textRrepetirContra;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Registrado frame = new Registrado();
                    frame.setVisible(true);
                    // Establecer el foco en el campo nombre después de hacer visible la ventana
                    frame.texNombre.requestFocusInWindow();
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
        panelInsertarNuevoUsuario.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Insertar Nuevo Usuario", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 0)));
        panelInsertarNuevoUsuario.setBounds(56, 38, 649, 313);
        contentPane.add(panelInsertarNuevoUsuario);

        JLabel lblContraseña = new JLabel("Contraseña*:");
        lblContraseña.setForeground(new Color(0, 0, 0));
        lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblContraseña.setBounds(137, 94, 129, 17);
        panelInsertarNuevoUsuario.add(lblContraseña);

        JLabel lblRepetirContraseña = new JLabel("Repetir Contraseña*:");
        lblRepetirContraseña.setForeground(new Color(0, 0, 0));
        lblRepetirContraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblRepetirContraseña.setBounds(137, 119, 144, 20);
        panelInsertarNuevoUsuario.add(lblRepetirContraseña);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setForeground(new Color(0, 0, 0));
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNombre.setBounds(137, 150, 82, 23);
        panelInsertarNuevoUsuario.add(lblNombre);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setForeground(new Color(0, 0, 0));
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEmail.setBounds(137, 184, 93, 17);
        panelInsertarNuevoUsuario.add(lblEmail);

        txtContraseña = new JPasswordField();
        txtContraseña.setBounds(291, 91, 275, 20);
        panelInsertarNuevoUsuario.add(txtContraseña);
        
        textRrepetirContra = new JPasswordField();
        textRrepetirContra.setBounds(291, 120, 275, 19);
        panelInsertarNuevoUsuario.add(textRrepetirContra);

        texNombre = new JTextField();
        texNombre.setColumns(10);
        texNombre.setBounds(291, 150, 275, 20);
        panelInsertarNuevoUsuario.add(texNombre);

        texEmail = new JTextField();
        texEmail.setColumns(10);
        texEmail.setBounds(291, 181, 275, 20);
        panelInsertarNuevoUsuario.add(texEmail);
        
        JLabel imagenFondo = new JLabel("New label");
        imagenFondo.setIcon(new ImageIcon(Registrado.class.getResource("/resources/mancha arcoirirs.jpg")));
        imagenFondo.setBounds(-17, 0, 790, 402);
        contentPane.add(imagenFondo);

        JButton btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.setForeground(new Color(0, 0, 0));
        btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnRegistrarse.setIcon(new ImageIcon(Registrado.class.getResource("/resources/nota.png")));
        btnRegistrarse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String DNI1 = texDNI.getText().trim();
                String pass1 = new String(txtContraseña.getPassword()).trim();
                String pass2 = new String(textRrepetirContra.getPassword()).trim();
                String nombre1 = texNombre.getText().trim();
                String email1 = texEmail.getText().trim();
                
                // Validación de campos obligatorios
                if (DNI1.isEmpty() || pass1.isEmpty() || pass2.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Los campos con * son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validación de DNI (8 números seguidos de una letra)
                if (!Pattern.matches("\\d{8}[A-Za-z]", DNI1)) {
                    JOptionPane.showMessageDialog(null, "El DNI debe tener 8 números seguidos de una letra", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                // Validación de contraseñas iguales
                if (!pass1.equals(pass2)) {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validación de contraseña no vacía ni solo espacios
                if (pass1.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "La contraseña no puede estar vacía ni contener solo espacios", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                // Validación de usuario no repetido y creación de usuario
                try {
                    boolean usuarioExiste = RegistroDB.existeUsuario(DNI1);
                    if (usuarioExiste) {
                        JOptionPane.showMessageDialog(null, "El usuario con este DNI ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        RegistroDB.añadirUsuario(DNI1, nombre1, pass1, email1);
                        JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
                        Principal.main(null);
                        dispose(); // Cerrar la ventana de registro
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al registrar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnRegistrarse.setBounds(403, 223, 163, 39);
        panelInsertarNuevoUsuario.add(btnRegistrarse);

        JLabel lblDNI = new JLabel("DNI*:");
        lblDNI.setForeground(new Color(0, 0, 0));
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
    }
}
