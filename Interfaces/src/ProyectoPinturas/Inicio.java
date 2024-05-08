package ProyectoPinturas;

import java.awt.EventQueue;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import PinturasDB.RegistroDB;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Usuario usuario_logueado;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Inicio (Usuario usuario_logueado) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.usuario_logueado=usuario_logueado;
		
		JComboBox desplegable = new JComboBox();
		String [] nombre = RegistroDB.getEditoriales();
		desplegable.setModel(new DefaultComboBoxModel(nombre));
	
		// hacer llamada a base de datos para descargar nombre de editoriales
		
		
		desplegable.setBounds(34, 48, 120, 22);
		contentPane.add(desplegable);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(34, 93, 298, 131);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str= desplegable.getSelectedItem().toString();
				try {
					Editorial ed = RegistroDB.getEditoriales(str);
					lblNewLabel.setText(ed.toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(184, 48, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}
}
