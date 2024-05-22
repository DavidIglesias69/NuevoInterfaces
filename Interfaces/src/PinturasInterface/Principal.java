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
    private JTextField DNITextField;
    private JPasswordField ContraseñaPasswordField;
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
        frmPrimerInterface.setTitle("Pinturas ArcoIris");
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
                    ContraseñaPasswordField.setEchoChar('*');
                    ImageIcon icono = new ImageIcon(Principal.class.getResource("/resources/ojo (1).png"));
                    iconoContraseña.setIcon(icono);
                } else {
                    ContraseñaPasswordField.setEchoChar((char) 0);
                    ImageIcon icono = new ImageIcon(Principal.class.getResource("/resources/ojo.png"));
                    iconoContraseña.setIcon(icono);
                }
            }
        });

        // Etiqueta del título principal
        JLabel lblPinturasArcoiris = new JLabel("PINTURAS  ARCOIRIS");
        lblPinturasArcoiris.setHorizontalAlignment(SwingConstants.CENTER);
        lblPinturasArcoiris.setForeground(new Color(255, 0, 0));
        lblPinturasArcoiris.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPinturasArcoiris.setBounds(10, 11, 468, 30);
        frmPrimerInterface.getContentPane().add(lblPinturasArcoiris);
        
        iconoContraseña.setHorizontalAlignment(SwingConstants.CENTER);
        iconoContraseña.setIcon(new ImageIcon(Principal.class.getResource("/resources/ojo (1).png")));
        iconoContraseña.setBounds(241, 146, 46, 24);
        frmPrimerInterface.getContentPane().add(iconoContraseña);

        // Campo de texto para el DNI del usuario
        DNITextField = new JTextField();
        DNITextField.setBounds(10, 84, 232, 20);
        frmPrimerInterface.getContentPane().add(DNITextField);
        DNITextField.setColumns(10);

        // Campo de contraseña
        ContraseñaPasswordField = new JPasswordField();
        ContraseñaPasswordField.setBounds(10, 146, 232, 20);
        frmPrimerInterface.getContentPane().add(ContraseñaPasswordField);

        // Botón de aceptación para iniciar sesión
        JButton btnAceptar = new JButton("ACEPTAR");
        btnAceptar.setToolTipText("Iniciar compra");
        btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnAceptar.setIcon(new ImageIcon(Principal.class.getResource("/resources/si.png")));
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iniciarSesion();
            }
        });
        btnAceptar.setBounds(287, 93, 191, 73);
        frmPrimerInterface.getContentPane().add(btnAceptar);

        // Etiqueta para el campo de usuario
        JLabel lblDNI = new JLabel("DNI:");
        lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblDNI.setLabelFor(DNITextField);
        lblDNI.setForeground(new Color(255, 0, 0));
        lblDNI.setBounds(10, 52, 232, 31);
        frmPrimerInterface.getContentPane().add(lblDNI);

        // Etiqueta para el campo de contraseña
        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblContraseña.setForeground(new Color(255, 0, 0));
        lblContraseña.setLabelFor(ContraseñaPasswordField);
        lblContraseña.setBounds(10, 111, 117, 37);
        frmPrimerInterface.getContentPane().add(lblContraseña);

        // Botón de registro para nuevos usuarios
        JButton btnRegistro = new JButton("   Registro");
        btnRegistro.setHorizontalAlignment(SwingConstants.LEFT);
        btnRegistro.setIcon(new ImageIcon(Principal.class.getResource("/resources/nota.png")));
        btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaRegistro();
            }
        });
        btnRegistro.setBounds(297, 177, 181, 51);
        frmPrimerInterface.getContentPane().add(btnRegistro);

        // Etiqueta de fondo con el logo
        JLabel lblFondo = new JLabel("");
        lblFondo.setIcon(new ImageIcon(Principal.class.getResource("/resources/LOGO.jpg")));
        lblFondo.setBounds(-288, -31, 872, 642);
        frmPrimerInterface.getContentPane().add(lblFondo);
    }

    // Método para iniciar sesión
    private void iniciarSesion() {
        String DNI = DNITextField.getText();
        String password = new String(ContraseñaPasswordField.getPassword());
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

    // Método para mostrar la ventana principal
    public void setVisible(boolean visible) {
        frmPrimerInterface.setVisible(visible);
    }
}
