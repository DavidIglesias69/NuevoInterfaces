package interfaceGraficas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Registrado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Usuario usuario_logueado;
	private JTextField nombreUsuario;
	private JTextField pass;
	private JTextField nombre;
	private JTextField email;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Insertar Nuevo Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 37, 480, 195);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre Usuario:");
		lblNewLabel_1.setBounds(45, 32, 97, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contraseña:");
		lblNewLabel_1_1.setBounds(45, 57, 93, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nombre:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_3.setBounds(45, 88, 59, 14);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Email:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_4.setBounds(45, 122, 59, 14);
		panel.add(lblNewLabel_1_4);
		
		nombreUsuario = new JTextField();
		nombreUsuario.setColumns(10);
		nombreUsuario.setBounds(152, 29, 275, 20);
		panel.add(nombreUsuario);
		
		pass = new JTextField();
		pass.setColumns(10);
		pass.setBounds(152, 57, 275, 20);
		panel.add(pass);
		
		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(152, 85, 275, 20);
		panel.add(nombre);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(152, 116, 275, 20);
		panel.add(email);
		
		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario= nombreUsuario.getText();
				String pass1= pass.getText();
				String nombre1= nombre.getText();
				String email1= email.getText();
				try {
					MetodosDB.añadirUsuario(usuario, pass1, nombre1, email1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(311, 161, 116, 23);
		panel.add(btnNewButton);
	}
}
