package PinturasInterface;

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
import ProyectoPinturas.Usuario;

import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JEditorPane;

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
		setTitle("Panel de Productos ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.usuario_logueado=usuario_logueado;
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.YELLOW);
		lblNewLabel.setFont(UIManager.getFont("Button.font"));
		lblNewLabel.setForeground(new Color(51, 255, 255));
		lblNewLabel.setBounds(93, 409, 298, 72);
		contentPane.add(lblNewLabel);
		
		JCheckBox BoxPintura = new JCheckBox("Pintura");
		BoxPintura.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxPintura.setBounds(16, 54, 97, 23);
		contentPane.add(BoxPintura);
		
		JCheckBox BoxRodillo = new JCheckBox("Rodillo");
		BoxRodillo.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxRodillo.setBounds(16, 126, 97, 23);
		contentPane.add(BoxRodillo);
		
		JCheckBox BoxPapel = new JCheckBox("Papel");
		BoxPapel.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxPapel.setBounds(16, 230, 97, 23);
		contentPane.add(BoxPapel);
		
		JCheckBox BoxBrocha = new JCheckBox("Brocha");
		BoxBrocha.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxBrocha.setBounds(16, 307, 97, 23);
		contentPane.add(BoxBrocha);
		
		JCheckBox BoxEscalera = new JCheckBox("Escalera");
		BoxEscalera.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxEscalera.setBounds(16, 394, 113, 23);
		contentPane.add(BoxEscalera);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(187, 54, 30, 20);
		contentPane.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(187, 126, 30, 20);
		contentPane.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(187, 230, 30, 20);
		contentPane.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(187, 307, 30, 20);
		contentPane.add(spinner_3);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(187, 394, 30, 20);
		contentPane.add(spinner_4);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Inicio.class.getResource("/resources/bote-de-pintura (1).png")));
		lblNewLabel_2.setBounds(227, 11, 73, 72);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Inicio.class.getResource("/resources/rodillo.png")));
		lblNewLabel_1.setBounds(227, 105, 73, 66);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Inicio.class.getResource("/resources/toalla-de-papel (1).png")));
		lblNewLabel_3.setBounds(227, 197, 73, 67);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Inicio.class.getResource("/resources/construccion.png")));
		lblNewLabel_4.setBounds(227, 275, 73, 66);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(Inicio.class.getResource("/resources/escalera-de-mano.png")));
		lblNewLabel_2_1.setBounds(227, 366, 80, 66);
		contentPane.add(lblNewLabel_2_1);
		
		JCheckBox BoxBarniz = new JCheckBox("Barniz");
		BoxBarniz.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxBarniz.setBounds(388, 54, 97, 23);
		contentPane.add(BoxBarniz);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setBounds(589, 54, 30, 20);
		contentPane.add(spinner_5);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon(Inicio.class.getResource("/resources/barniz.png")));
		lblNewLabel_2_2.setBounds(629, 24, 80, 64);
		contentPane.add(lblNewLabel_2_2);
		
		JCheckBox BoxDisolvente = new JCheckBox("Disolvente");
		BoxDisolvente.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxDisolvente.setBounds(388, 126, 125, 23);
		contentPane.add(BoxDisolvente);
		
		JSpinner spinner_1_1 = new JSpinner();
		spinner_1_1.setBounds(589, 126, 30, 20);
		contentPane.add(spinner_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(Inicio.class.getResource("/resources/sin-disolventes.png")));
		lblNewLabel_1_1.setBounds(614, 99, 80, 72);
		contentPane.add(lblNewLabel_1_1);
		
		JCheckBox BoxPlasticos = new JCheckBox("Plasticos");
		BoxPlasticos.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxPlasticos.setBounds(388, 230, 125, 23);
		contentPane.add(BoxPlasticos);
		
		JSpinner spinner_2_1 = new JSpinner();
		spinner_2_1.setBounds(589, 230, 30, 20);
		contentPane.add(spinner_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(Inicio.class.getResource("/resources/rollos-de-papel.png")));
		lblNewLabel_3_1.setBounds(629, 197, 80, 67);
		contentPane.add(lblNewLabel_3_1);
		
		JCheckBox BoxDecapante = new JCheckBox("Decapante");
		BoxDecapante.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxDecapante.setBounds(388, 307, 125, 23);
		contentPane.add(BoxDecapante);
		
		JSpinner spinner_3_1 = new JSpinner();
		spinner_3_1.setBounds(589, 307, 30, 20);
		contentPane.add(spinner_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(Inicio.class.getResource("/resources/aerosol.png")));
		lblNewLabel_4_1.setBounds(629, 277, 65, 72);
		contentPane.add(lblNewLabel_4_1);
		
		JCheckBox BoxEspatula = new JCheckBox("Espatula");
		BoxEspatula.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxEspatula.setBounds(388, 394, 125, 23);
		contentPane.add(BoxEspatula);
		
		JSpinner spinner_4_1 = new JSpinner();
		spinner_4_1.setBounds(589, 394, 30, 20);
		contentPane.add(spinner_4_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setIcon(new ImageIcon(Inicio.class.getResource("/resources/espatula.png")));
		lblNewLabel_2_1_1.setBounds(629, 360, 80, 72);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel PrecioPintura = new JLabel("15€ / L.");
		PrecioPintura.setHorizontalAlignment(SwingConstants.CENTER);
		PrecioPintura.setBounds(119, 60, 57, 14);
		contentPane.add(PrecioPintura);
		
		JLabel PrecioPintura_1 = new JLabel("33€ l.");
		PrecioPintura_1.setHorizontalAlignment(SwingConstants.CENTER);
		PrecioPintura_1.setBounds(522, 60, 57, 14);
		contentPane.add(PrecioPintura_1);
		
		JLabel PrecioPintura_2 = new JLabel("33€ l.");
		PrecioPintura_2.setHorizontalAlignment(SwingConstants.CENTER);
		PrecioPintura_2.setBounds(522, 132, 57, 14);
		contentPane.add(PrecioPintura_2);
		
		JLabel PrecioPintura_3 = new JLabel("33€ l.");
		PrecioPintura_3.setHorizontalAlignment(SwingConstants.CENTER);
		PrecioPintura_3.setBounds(522, 236, 57, 14);
		contentPane.add(PrecioPintura_3);
		
		JLabel PrecioPintura_4 = new JLabel("33€ l.");
		PrecioPintura_4.setHorizontalAlignment(SwingConstants.CENTER);
		PrecioPintura_4.setBounds(522, 316, 57, 14);
		contentPane.add(PrecioPintura_4);
		
		JLabel PrecioPintura_5 = new JLabel("33€ l.");
		PrecioPintura_5.setHorizontalAlignment(SwingConstants.CENTER);
		PrecioPintura_5.setBounds(522, 400, 57, 14);
		contentPane.add(PrecioPintura_5);
		
		JLabel PrecioPintura_6 = new JLabel("33€ l.");
		PrecioPintura_6.setHorizontalAlignment(SwingConstants.CENTER);
		PrecioPintura_6.setBounds(119, 400, 57, 14);
		contentPane.add(PrecioPintura_6);
		
		JLabel PrecioPintura_7 = new JLabel("33€ l.");
		PrecioPintura_7.setHorizontalAlignment(SwingConstants.CENTER);
		PrecioPintura_7.setBounds(119, 313, 57, 14);
		contentPane.add(PrecioPintura_7);
		
		JLabel PrecioPintura_8 = new JLabel("1,99 € / m.");
		PrecioPintura_8.setHorizontalAlignment(SwingConstants.CENTER);
		PrecioPintura_8.setBounds(119, 236, 57, 14);
		contentPane.add(PrecioPintura_8);
		
		JLabel PrecioPintura_9 = new JLabel("2,99€");
		PrecioPintura_9.setHorizontalAlignment(SwingConstants.CENTER);
		PrecioPintura_9.setBounds(119, 132, 57, 14);
		contentPane.add(PrecioPintura_9);
		
		JButton btnNewButton = new JButton("COMPRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(742, 469, 89, 23);
		contentPane.add(btnNewButton);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(Color.ORANGE);
		editorPane.setForeground(new Color(0, 0, 255));
		editorPane.setBounds(406, 472, 272, 20);
		contentPane.add(editorPane);
		
		
	}
}
