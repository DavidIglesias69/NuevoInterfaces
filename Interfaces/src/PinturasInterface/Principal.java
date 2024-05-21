package PinturasInterface;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import PinturasDB.*;
import ProyectoPinturas.Usuario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal {

    private JFrame frmPrimerInterface;
    private JTextField usuarioTextField;
    private JPasswordField usuarioPasswordField;
    private int numPulsaciones = 0;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Principal window = new Principal();
                    window.frmPrimerInterface.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Principal() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        // Configuración de la ventana principal
        frmPrimerInterface = new JFrame();
        frmPrimerInterface.setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/resources/descargar.jpg")));
        frmPrimerInterface.setTitle("Pinturas ArcoIrirs");
        frmPrimerInterface.getContentPane().setForeground(new Color(0, 128, 64));
        frmPrimerInterface.setBounds(100, 100, 519, 573);
        frmPrimerInterface.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmPrimerInterface.getContentPane().setLayout(null);

        // Icono para mostrar/ocultar contraseña
        JLabel iconoContraseña = new JLabel("");
        iconoContraseña.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                numPulsaciones++;
                if (numPulsaciones % 2 == 0) {
                    usuarioPasswordField.setEchoChar('*');
                    ImageIcon icono = new ImageIcon(Principal.class.getResource("/resources/ojo (1).png"));
                    iconoContraseña.setIcon(icono);
                } else {
                    usuarioPasswordField.setEchoChar((char) 0);
                    ImageIcon icono = new ImageIcon(Principal.class.getResource("/resources/ojo.png"));
                    iconoContraseña.setIcon(icono);
                }
            }
        });
        iconoContraseña.setHorizontalAlignment(SwingConstants.CENTER);
        iconoContraseña.setIcon(new ImageIcon(Principal.class.getResource("/resources/ojo (1).png")));
        iconoContraseña.setBounds(241, 146, 46, 24);
        frmPrimerInterface.getContentPane().add(iconoContraseña);

        // Campo de texto para el DNI del usuario
        usuarioTextField = new JTextField();
        usuarioTextField.setBounds(10, 84, 232, 20);
        frmPrimerInterface.getContentPane().add(usuarioTextField);
        usuarioTextField.setColumns(10);

        // Campo de contraseña
        usuarioPasswordField = new JPasswordField();
        usuarioPasswordField.setBounds(10, 146, 232, 20);
        frmPrimerInterface.getContentPane().add(usuarioPasswordField);

        // Botón de aceptación para iniciar sesión
        JButton boton1 = new JButton("ACEPTAR");
        boton1.setToolTipText("Iniciar compra");
        boton1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        boton1.setIcon(new ImageIcon(Principal.class.getResource("/resources/si.png")));
        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iniciarSesion();
            }
        });
        boton1.setBounds(287, 93, 191, 73);
        frmPrimerInterface.getContentPane().add(boton1);

        // Etiqueta para el campo de usuario
        JLabel textoUsuario = new JLabel("DNI:");
        textoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textoUsuario.setLabelFor(usuarioTextField);
        textoUsuario.setForeground(new Color(255, 0, 0));
        textoUsuario.setBounds(10, 52, 232, 31);
        frmPrimerInterface.getContentPane().add(textoUsuario);

        // Etiqueta para el campo de contraseña
        JLabel lblNewLabel = new JLabel("Contraseña:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setForeground(new Color(255, 0, 0));
        lblNewLabel.setLabelFor(usuarioPasswordField);
        lblNewLabel.setBounds(10, 111, 117, 37);
        frmPrimerInterface.getContentPane().add(lblNewLabel);

        // Botón de registro para nuevos usuarios
        JButton registro = new JButton("   Registro");
        registro.setHorizontalAlignment(SwingConstants.LEFT);
        registro.setIcon(new ImageIcon(Principal.class.getResource("/resources/nota.png")));
        registro.setFont(new Font("Tahoma", Font.PLAIN, 18));
        registro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaRegistro();
            }
        });
        registro.setBounds(297, 177, 181, 51);
        frmPrimerInterface.getContentPane().add(registro);

        // Etiqueta de fondo con el logo
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(Principal.class.getResource("/resources/LOGO.jpg")));
        lblNewLabel_1.setBounds(-288, -31, 872, 642);
        frmPrimerInterface.getContentPane().add(lblNewLabel_1);

        // Etiqueta del título principal
        JLabel lblNewLabel_2 = new JLabel("PINTURAS  ARCOIRIS");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setForeground(new Color(255, 0, 0));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_2.setBounds(10, 11, 468, 30);
        frmPrimerInterface.getContentPane().add(lblNewLabel_2);
    }

    // Método para iniciar sesión
    private void iniciarSesion() {
        String DNI = usuarioTextField.getText();
        String password = new String(usuarioPasswordField.getPassword());
        try {
            Usuario logeado = RegistroDB.doLogin(DNI, password);
            if (logeado != null) {
                if (logeado.isResponsable() != 1) {
                    Inicio ventanaNueva = new Inicio(logeado);
                    ventanaNueva.setVisible(true);
                    frmPrimerInterface.dispose();
                } else if (logeado.isResponsable() == 1) {
                    Administrador ventanaNueva = new Administrador(logeado);
                    ventanaNueva.setVisible(true);
                    frmPrimerInterface.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "ERROR, USUARIO INCORRECTO");
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    // Método para abrir la ventana de registro
    private void abrirVentanaRegistro() {
        Registrado ventanaRegistro = new Registrado();
        ventanaRegistro.setVisible(true);
        frmPrimerInterface.dispose();
    }
}
