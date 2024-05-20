package PinturasInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
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
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JPasswordField;

public class Registrado extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    Usuario usuario_logueado;    
    private JTextField nombre;
    private JTextField email;
    private JTextField dni_tex;
    private JPasswordField _contraseña;
    private JPasswordField _repetirContra;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Registrado frame = new Registrado();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Registrado() {
        setTitle("Registro Usuario Nuevo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 789, 441);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.setBackground(new Color(153, 51, 204));
        panel.setLayout(null);
        panel.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Insertar Nuevo Usuario", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 0)));
        panel.setBounds(56, 38, 649, 313);
        contentPane.add(panel);

        JLabel lblNewLabel_1 = new JLabel("Contraseña*:");
        lblNewLabel_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(137, 94, 129, 17);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Repetir Contraseña*:");
        lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(137, 119, 144, 20);
        panel.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_3 = new JLabel("Nombre:");
        lblNewLabel_1_3.setForeground(new Color(0, 0, 0));
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_3.setBounds(137, 150, 82, 23);
        panel.add(lblNewLabel_1_3);

        JLabel lblNewLabel_1_4 = new JLabel("Email:");
        lblNewLabel_1_4.setForeground(new Color(0, 0, 0));
        lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_4.setBounds(137, 184, 93, 17);
        panel.add(lblNewLabel_1_4);

        _contraseña = new JPasswordField();
        _contraseña.setBounds(291, 91, 275, 20);
        panel.add(_contraseña);
        
        _repetirContra = new JPasswordField();
        _repetirContra.setBounds(291, 120, 275, 19);
        panel.add(_repetirContra);

        nombre = new JTextField();
        nombre.setColumns(10);
        nombre.setBounds(291, 150, 275, 20);
        panel.add(nombre);

        email = new JTextField();
        email.setColumns(10);
        email.setBounds(291, 181, 275, 20);
        panel.add(email);
        
        JLabel panelRegistro = new JLabel("New label");
        panelRegistro.setIcon(new ImageIcon(Registrado.class.getResource("/resources/mancha arcoirirs.jpg")));
        panelRegistro.setBounds(-17, 0, 790, 402);
        contentPane.add(panelRegistro);

        JButton btnNewButton = new JButton("Registrarse");
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton.setIcon(new ImageIcon(Registrado.class.getResource("/resources/nota.png")));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String DNI1 = dni_tex.getText().trim();
                String pass1 = new String(_contraseña.getPassword());
                String pass2 = new String(_repetirContra.getPassword());
                String nombre1 = nombre.getText().trim();
                String email1 = email.getText().trim();
                
                // Validación de campos obligatorios
                if (DNI1.isEmpty() || pass1.isEmpty() || pass2.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Los campos con * son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                // Validación de contraseñas iguales
                if (!pass1.equals(pass2)) {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
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
        btnNewButton.setBounds(403, 223, 163, 39);
        panel.add(btnNewButton);

        JLabel lblNewLabel_1_2 = new JLabel("DNI*:");
        lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_2.setBounds(137, 65, 129, 18);
        panel.add(lblNewLabel_1_2);

        dni_tex = new JTextField();
        dni_tex.setColumns(10);
        dni_tex.setBounds(291, 66, 275, 20);
        panel.add(dni_tex);
    }
}
