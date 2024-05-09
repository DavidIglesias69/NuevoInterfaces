package ProyectoPinturas;

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
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import PinturasDB.*;

public class Principal {

	private JFrame frmPrimerInterface;
	private JTextField usuarioTextField;
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
		frmPrimerInterface.setTitle("Pinturas ArcoIrirs");
		frmPrimerInterface.getContentPane().setForeground(new Color(0, 128, 64));
		frmPrimerInterface.setBounds(100, 100, 868, 614);
		frmPrimerInterface.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmPrimerInterface.getContentPane().setLayout(null);

		usuarioTextField = new JTextField();
		usuarioTextField.setBounds(336, 92, 232, 20);
		frmPrimerInterface.getContentPane().add(usuarioTextField);
		usuarioTextField.setColumns(10);

		usuarioPasswordField = new JPasswordField();
		usuarioPasswordField.setBounds(336, 154, 232, 20);
		frmPrimerInterface.getContentPane().add(usuarioPasswordField);

		JButton boton1 = new JButton("ACEPTAR");
		boton1.setToolTipText("ftfjfjf");
		boton1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		boton1.setIcon(new ImageIcon(Principal.class.getResource("/resources/si.png")));
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario= usuarioTextField.getText();
				String password =usuarioPasswordField.getText();
				try {
					Usuario logeado = RegistroDB.doLogin(usuario, password);
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
		boton1.setBounds(613, 101, 191, 73);
		frmPrimerInterface.getContentPane().add(boton1);

		JLabel textoUsuario = new JLabel("Usuario:");
		textoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textoUsuario.setLabelFor(usuarioTextField);
		textoUsuario.setForeground(new Color(255, 0, 0));
		textoUsuario.setBounds(336, 60, 232, 31);
		frmPrimerInterface.getContentPane().add(textoUsuario);

		JLabel lblNewLabel = new JLabel("Contraseña:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setLabelFor(usuarioPasswordField);
		lblNewLabel.setBounds(336, 119, 117, 37);
		frmPrimerInterface.getContentPane().add(lblNewLabel);
		
		JButton registro = new JButton("   Registro");
		registro.setHorizontalAlignment(SwingConstants.LEFT);
		registro.setIcon(new ImageIcon(Principal.class.getResource("/resources/nota.png")));
		registro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		registro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Registrado ventanaRegistro = new Registrado();
				ventanaRegistro.show();
				frmPrimerInterface.dispose();
				

			}
		});
				
			
		registro.setBounds(623, 185, 181, 51);
		frmPrimerInterface.getContentPane().add(registro);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Principal.class.getResource("/resources/LOGO.jpg")));
		lblNewLabel_1.setBounds(10, 11, 832, 553);
		frmPrimerInterface.getContentPane().add(lblNewLabel_1);
	}
}
