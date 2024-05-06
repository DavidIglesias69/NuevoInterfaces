package interfaceGraficas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Principal {

	private JFrame frmPrimerInterface;
	private JTextField UsuarioTextField;
	private JPasswordField usuarioPasswordField;

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
		frmPrimerInterface = new JFrame();
		frmPrimerInterface.setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/resources/descargar.jpg")));
		frmPrimerInterface.setTitle("primer interface");
		frmPrimerInterface.getContentPane().setForeground(new Color(0, 128, 64));
		frmPrimerInterface.setBounds(100, 100, 506, 305);
		frmPrimerInterface.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmPrimerInterface.getContentPane().setLayout(null);

		UsuarioTextField = new JTextField();
		UsuarioTextField.setBounds(23, 82, 232, 20);
		frmPrimerInterface.getContentPane().add(UsuarioTextField);
		UsuarioTextField.setColumns(10);

		usuarioPasswordField = new JPasswordField();
		usuarioPasswordField.setBounds(23, 140, 232, 20);
		frmPrimerInterface.getContentPane().add(usuarioPasswordField);

		JButton boton1 = new JButton("Login");
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario= UsuarioTextField.getText();
				String password =usuarioPasswordField.getText();
				try {
					Usuario logeado = MetodosDB.doLogin(usuario,password);
					System.out.println(logeado);

					if(logeado != null) {
						Inicio ventanaNueva = new Inicio(logeado);
						ventanaNueva.usuario_logueado=logeado;
						ventanaNueva.show();
						frmPrimerInterface.dispose();
					}else {

						JOptionPane.showMessageDialog(null, "ERROR, USUARIO INCORRECTO");
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		boton1.setBounds(360, 184, 89, 23);
		frmPrimerInterface.getContentPane().add(boton1);

		JLabel textoUsuario = new JLabel("Usuario:");
		textoUsuario.setLabelFor(UsuarioTextField);
		textoUsuario.setForeground(new Color(255, 0, 0));
		textoUsuario.setBounds(23, 54, 74, 14);
		frmPrimerInterface.getContentPane().add(textoUsuario);

		JLabel lblNewLabel = new JLabel("Contraseña:");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setLabelFor(usuarioPasswordField);
		lblNewLabel.setBounds(23, 115, 91, 14);
		frmPrimerInterface.getContentPane().add(lblNewLabel);
		
		JButton registro = new JButton("registro");
		registro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Registrado ventanaRegistro = new Registrado();
				ventanaRegistro.show();
				frmPrimerInterface.dispose();
				

			}
		});
				
			
		registro.setBounds(360, 218, 89, 23);
		frmPrimerInterface.getContentPane().add(registro);
	}
}
