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
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

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
		String [] nombre = RegistroDB.class;
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.YELLOW);
		lblNewLabel.setFont(UIManager.getFont("Button.font"));
		lblNewLabel.setForeground(new Color(51, 255, 255));
		lblNewLabel.setBounds(93, 409, 298, 72);
		contentPane.add(lblNewLabel);
		
		JCheckBox BoxPintura = new JCheckBox("Pintura");
		BoxPintura.setBounds(41, 53, 97, 23);
		contentPane.add(BoxPintura);
		
		JCheckBox BoxRodillo = new JCheckBox("Rodillo");
		BoxRodillo.setBounds(41, 125, 97, 23);
		contentPane.add(BoxRodillo);
		
		JCheckBox BoxPapel = new JCheckBox("Papel");
		BoxPapel.setBounds(41, 229, 97, 23);
		contentPane.add(BoxPapel);
		
		JCheckBox BoxBrocha = new JCheckBox("Brocha");
		BoxBrocha.setBounds(41, 306, 97, 23);
		contentPane.add(BoxBrocha);
		
		JCheckBox BoxEscalera = new JCheckBox("Escalera");
		BoxEscalera.setBounds(41, 393, 97, 23);
		contentPane.add(BoxEscalera);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(171, 54, 30, 20);
		contentPane.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(171, 126, 30, 20);
		contentPane.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(171, 230, 30, 20);
		contentPane.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(171, 307, 30, 20);
		contentPane.add(spinner_3);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(171, 394, 30, 20);
		contentPane.add(spinner_4);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Inicio.class.getResource("/resources/cubo-pintura.png")));
		lblNewLabel_2.setBounds(211, 42, 38, 41);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Inicio.class.getResource("/resources/rodillo.png")));
		lblNewLabel_1.setBounds(211, 105, 73, 66);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Inicio.class.getResource("/resources/toalla-de-papel.png")));
		lblNewLabel_3.setBounds(211, 217, 30, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Inicio.class.getResource("/resources/construccion.png")));
		lblNewLabel_4.setBounds(211, 263, 73, 66);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(Inicio.class.getResource("/resources/escalera-de-mano.png")));
		lblNewLabel_2_1.setBounds(211, 350, 80, 66);
		contentPane.add(lblNewLabel_2_1);
		
		JCheckBox BoxBarniz = new JCheckBox("Barniz");
		BoxBarniz.setBounds(353, 53, 97, 23);
		contentPane.add(BoxBarniz);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setBounds(483, 54, 30, 20);
		contentPane.add(spinner_5);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon(Inicio.class.getResource("/resources/barniz.png")));
		lblNewLabel_2_2.setBounds(523, 24, 80, 64);
		contentPane.add(lblNewLabel_2_2);
		
		JCheckBox BoxDisolvente = new JCheckBox("Disolvente");
		BoxDisolvente.setBounds(353, 125, 97, 23);
		contentPane.add(BoxDisolvente);
		
		JSpinner spinner_1_1 = new JSpinner();
		spinner_1_1.setBounds(483, 126, 30, 20);
		contentPane.add(spinner_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(Inicio.class.getResource("/resources/sin-disolventes.png")));
		lblNewLabel_1_1.setBounds(508, 99, 80, 72);
		contentPane.add(lblNewLabel_1_1);
		
		JCheckBox BoxPlasticos = new JCheckBox("Plasticos");
		BoxPlasticos.setBounds(353, 229, 97, 23);
		contentPane.add(BoxPlasticos);
		
		JSpinner spinner_2_1 = new JSpinner();
		spinner_2_1.setBounds(483, 230, 30, 20);
		contentPane.add(spinner_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(Inicio.class.getResource("/resources/rollos-de-papel.png")));
		lblNewLabel_3_1.setBounds(523, 197, 80, 67);
		contentPane.add(lblNewLabel_3_1);
		
		JCheckBox BoxDecapante = new JCheckBox("Decapante");
		BoxDecapante.setBounds(353, 306, 97, 23);
		contentPane.add(BoxDecapante);
		
		JSpinner spinner_3_1 = new JSpinner();
		spinner_3_1.setBounds(483, 307, 30, 20);
		contentPane.add(spinner_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(Inicio.class.getResource("/resources/bote-de-pintura (2).png")));
		lblNewLabel_4_1.setBounds(523, 297, 30, 32);
		contentPane.add(lblNewLabel_4_1);
		
		JCheckBox BoxEspatula = new JCheckBox("Espatula");
		BoxEspatula.setBounds(353, 393, 97, 23);
		contentPane.add(BoxEspatula);
		
		JSpinner spinner_4_1 = new JSpinner();
		spinner_4_1.setBounds(483, 394, 30, 20);
		contentPane.add(spinner_4_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setIcon(new ImageIcon(Inicio.class.getResource("/resources/espatula.png")));
		lblNewLabel_2_1_1.setBounds(523, 360, 80, 72);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(104, 57, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		
	}
}
