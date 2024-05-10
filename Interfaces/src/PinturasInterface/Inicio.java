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

import PinturasDB.ProductoDB;
import PinturasDB.RegistroDB;
import ProyectoPinturas.Producto;
import ProyectoPinturas.Usuario;

import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Usuario usuario_logueado;
	private JCheckBox BoxPintura;
	private JCheckBox BoxRodillo;
	private JCheckBox BoxPapel;
	private JCheckBox BoxBrocha;
	private JCheckBox BoxEscalera;
	private JCheckBox BoxBarniz;
	private JCheckBox BoxDisolvente;
	private JCheckBox BoxPlasticos;
	private JCheckBox BoxDecapante;
	private JCheckBox BoxEspatula;
	

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
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setForeground(new Color(255, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.usuario_logueado = usuario_logueado;

		JLabel PrecioPintura = new JLabel();
		PrecioPintura.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PrecioPintura.setHorizontalAlignment(SwingConstants.CENTER);
		PrecioPintura.setBounds(119, 57, 57, 14);
		contentPane.add(PrecioPintura);

		JLabel PrecioRodillo = new JLabel();
		PrecioRodillo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PrecioRodillo.setHorizontalAlignment(SwingConstants.CENTER);
		PrecioRodillo.setBounds(119, 129, 57, 14);
		contentPane.add(PrecioRodillo);

		JLabel PrecioPapel = new JLabel();
		PrecioPapel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PrecioPapel.setHorizontalAlignment(SwingConstants.CENTER);
		PrecioPapel.setBounds(119, 233, 57, 14);
		contentPane.add(PrecioPapel);

		JLabel PrecioBrocha = new JLabel();
		PrecioBrocha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PrecioBrocha.setHorizontalAlignment(SwingConstants.CENTER);
		PrecioBrocha.setBounds(119, 310, 57, 14);
		contentPane.add(PrecioBrocha);

		JLabel Precioescalera = new JLabel();
		Precioescalera.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Precioescalera.setHorizontalAlignment(SwingConstants.CENTER);
		Precioescalera.setBounds(134, 397, 57, 14);
		contentPane.add(Precioescalera);

		JLabel PrecioBarniz = new JLabel();    
		PrecioBarniz.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PrecioBarniz.setHorizontalAlignment(SwingConstants.CENTER);
		PrecioBarniz.setBounds(519, 57, 57, 14);
		contentPane.add(PrecioBarniz);

		JLabel PrecioDisolvente = new JLabel();
		PrecioDisolvente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PrecioDisolvente.setHorizontalAlignment(SwingConstants.CENTER);
		PrecioDisolvente.setBounds(519, 129, 57, 14);
		contentPane.add(PrecioDisolvente);

		JLabel PrecioPlasticos = new JLabel();
		PrecioPlasticos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PrecioPlasticos.setHorizontalAlignment(SwingConstants.CENTER);
		PrecioPlasticos.setBounds(519, 233, 57, 14);
		contentPane.add(PrecioPlasticos);

		JLabel PrecioDecapante = new JLabel();    
		PrecioDecapante.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PrecioDecapante.setHorizontalAlignment(SwingConstants.CENTER);
		PrecioDecapante.setBounds(519, 310, 57, 14);
		contentPane.add(PrecioDecapante);

		JLabel PrecioEspatula = new JLabel();    
		PrecioEspatula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PrecioEspatula.setHorizontalAlignment(SwingConstants.CENTER);
		PrecioEspatula.setBounds(519, 397, 57, 14);
		contentPane.add(PrecioEspatula);


		ProductoDB productoDB = new ProductoDB();
		// Obtener y mostrar el precio de la pintura
		double precioPintura = ProductoDB.obtenerPrecio("pintura");
		PrecioPintura.setText(String.valueOf(precioPintura) + "€");

		// Obtener y mostrar el precio del rodillo
		double precioRodillo = ProductoDB.obtenerPrecio("rodillo");
		PrecioRodillo.setText(String.valueOf(precioRodillo) + "€");

		// Obtener y mostrar el precio del papel
		double precioPapel = ProductoDB.obtenerPrecio("papel");
		PrecioPapel.setText(String.valueOf(precioPapel) + "€");

		// Obtener y mostrar el precio de la brocha
		double precioBrocha = ProductoDB.obtenerPrecio("brocha");
		PrecioBrocha.setText(String.valueOf(precioBrocha) + "€");

		// Obtener y mostrar el precio de la escalera
		double precioEscalera = ProductoDB.obtenerPrecio("escalera");
		Precioescalera.setText(String.valueOf(precioEscalera) + "€");

		double precioBarniz = ProductoDB.obtenerPrecio("barniz");
		PrecioBarniz.setText(String.valueOf(precioBarniz) + "€");

		// Obtener y mostrar el precio del disolvente
		double precioDisolvente = ProductoDB.obtenerPrecio("disolvente");
		PrecioDisolvente.setText(String.valueOf(precioDisolvente) + "€");

		// Obtener y mostrar el precio de los plasticos
		double precioPlasticos = ProductoDB.obtenerPrecio("plasticos");
		PrecioPlasticos.setText(String.valueOf(precioPlasticos) + "€");

		// Obtener y mostrar el precio del decapante
		double precioDecapante = ProductoDB.obtenerPrecio("decapante");
		PrecioDecapante.setText(String.valueOf(precioDecapante) + "€");

		// Obtener y mostrar el precio de la espatula
		double precioEspatula = ProductoDB.obtenerPrecio("espatula");
		PrecioEspatula.setText(String.valueOf(precioEspatula) + "€");

		JEditorPane PanelTotal = new JEditorPane();

		JSpinner spinnerPintura = new JSpinner();
		spinnerPintura.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
				PanelTotal.setVisible(false);
				PanelTotal.setVisible(true);
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
				PanelTotal.setVisible(false);
				PanelTotal.setVisible(true);
			}
		});
		spinnerPintura.setBounds(174, 54, 43, 20);
		contentPane.add(spinnerPintura);

		JSpinner spinnerRodillo = new JSpinner();
		spinnerRodillo.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
				PanelTotal.setVisible(false);
				PanelTotal.setVisible(true);
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
				PanelTotal.setVisible(false);
				PanelTotal.setVisible(true);
			}
		});
		spinnerRodillo.setBounds(174, 126, 43, 20);
		contentPane.add(spinnerRodillo);

		JSpinner spinnerPapel = new JSpinner();
		spinnerPapel.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
				PanelTotal.setVisible(false);
				PanelTotal.setVisible(true);
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
				PanelTotal.setVisible(false);
				PanelTotal.setVisible(true);
			}
		});
		spinnerPapel.setBounds(174, 230, 43, 20);
		contentPane.add(spinnerPapel);

		JSpinner spinnerBrocha = new JSpinner();
		spinnerBrocha.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
				PanelTotal.setVisible(false);
				PanelTotal.setVisible(true);
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
				PanelTotal.setVisible(false);
				PanelTotal.setVisible(true);
			}
		});
		spinnerBrocha.setBounds(174, 307, 43, 20);
		contentPane.add(spinnerBrocha);

		JSpinner spinnerEscalera = new JSpinner();
		spinnerEscalera.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
				PanelTotal.setVisible(false);
				PanelTotal.setVisible(true);
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
				PanelTotal.setVisible(false);
				PanelTotal.setVisible(true);
			}
		});
		spinnerEscalera.setBounds(189, 394, 43, 20);
		contentPane.add(spinnerEscalera);

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
		lblNewLabel_2_1.setBounds(242, 366, 80, 66);
		contentPane.add(lblNewLabel_2_1);

		JCheckBox BoxBarniz = new JCheckBox("Barniz");
		BoxBarniz.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxBarniz.setBounds(388, 54, 97, 23);
		contentPane.add(BoxBarniz);

		JSpinner spinnerBarniz = new JSpinner();
		spinnerBarniz.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
				PanelTotal.setVisible(false);
				PanelTotal.setVisible(true);
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
				PanelTotal.setVisible(false);
				PanelTotal.setVisible(true);
			}
		});
		spinnerBarniz.setBounds(574, 54, 45, 20);
		contentPane.add(spinnerBarniz);

		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon(Inicio.class.getResource("/resources/barniz.png")));
		lblNewLabel_2_2.setBounds(629, 24, 80, 64);
		contentPane.add(lblNewLabel_2_2);

		JCheckBox BoxDisolvente = new JCheckBox("Disolvente");
		BoxDisolvente.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxDisolvente.setBounds(388, 126, 125, 23);
		contentPane.add(BoxDisolvente);

		JSpinner spinnerDisolvente = new JSpinner();
		spinnerDisolvente.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
				PanelTotal.setVisible(false);
				PanelTotal.setVisible(true);
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
				PanelTotal.setVisible(false);
				PanelTotal.setVisible(true);
			}
		});
		spinnerDisolvente.setBounds(574, 126, 45, 20);
		contentPane.add(spinnerDisolvente);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(Inicio.class.getResource("/resources/sin-disolventes.png")));
		lblNewLabel_1_1.setBounds(614, 99, 80, 72);
		contentPane.add(lblNewLabel_1_1);

		JCheckBox BoxPlasticos = new JCheckBox("Plasticos");
		BoxPlasticos.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxPlasticos.setBounds(388, 230, 125, 23);
		contentPane.add(BoxPlasticos);

		JSpinner spinnerPlasticos = new JSpinner();
		spinnerPlasticos.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
				PanelTotal.setVisible(false);
				PanelTotal.setVisible(true);
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
				PanelTotal.setVisible(false);
				PanelTotal.setVisible(true);
			}
		});
		spinnerPlasticos.setBounds(574, 230, 45, 20);
		contentPane.add(spinnerPlasticos);

		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(Inicio.class.getResource("/resources/rollos-de-papel.png")));
		lblNewLabel_3_1.setBounds(629, 197, 80, 67);
		contentPane.add(lblNewLabel_3_1);

		JCheckBox BoxDecapante = new JCheckBox("Decapante");
		BoxDecapante.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxDecapante.setBounds(388, 307, 125, 23);
		contentPane.add(BoxDecapante);

		JSpinner spinnerDecapante = new JSpinner();
		spinnerDecapante.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
				PanelTotal.setVisible(false);
				PanelTotal.setVisible(true);
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
				PanelTotal.setVisible(false);
				PanelTotal.setVisible(true);
			}
		});
		spinnerDecapante.setBounds(574, 307, 45, 20);
		contentPane.add(spinnerDecapante);

		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(Inicio.class.getResource("/resources/aerosol.png")));
		lblNewLabel_4_1.setBounds(629, 277, 65, 72);
		contentPane.add(lblNewLabel_4_1);

		JCheckBox BoxEspatula = new JCheckBox("Espatula");
		BoxEspatula.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxEspatula.setBounds(388, 394, 110, 23);
		contentPane.add(BoxEspatula);

		JSpinner spinnerEspatula = new JSpinner();
		spinnerEspatula.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
				PanelTotal.setVisible(false);
				PanelTotal.setVisible(true);
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
				PanelTotal.setVisible(false);
				PanelTotal.setVisible(true);
			}
		});
		spinnerEspatula.setBounds(574, 394, 45, 20);
		contentPane.add(spinnerEspatula);

		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setIcon(new ImageIcon(Inicio.class.getResource("/resources/espatula.png")));
		lblNewLabel_2_1_1.setBounds(629, 360, 80, 72);
		contentPane.add(lblNewLabel_2_1_1);

		
		JButton btnNewButton = new JButton("COMPRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(742, 469, 89, 23);
		contentPane.add(btnNewButton);





		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(128, 491, 125, -41);
		contentPane.add(horizontalBox);

		JCheckBox BoxPintura = new JCheckBox("Pintura");
		BoxPintura.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxPintura.setBounds(25, 51, 97, 23);
		contentPane.add(BoxPintura);

		JCheckBox BoxRodillo = new JCheckBox("Rodillo");
		BoxRodillo.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxRodillo.setBounds(25, 123, 101, 23);
		contentPane.add(BoxRodillo);

		JCheckBox BoxPapel = new JCheckBox("Papel");
		BoxPapel.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxPapel.setBounds(25, 227, 88, 23);
		contentPane.add(BoxPapel);

		JCheckBox BoxBrocha = new JCheckBox("Brocha");
		BoxBrocha.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxBrocha.setBounds(25, 304, 89, 23);
		contentPane.add(BoxBrocha);

		JCheckBox BoxEscalera = new JCheckBox("Escalera");
		BoxEscalera.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxEscalera.setBounds(21, 391, 110, 23);
		contentPane.add(BoxEscalera);

		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(347, 39, 30, 393);
		contentPane.add(verticalStrut);

		//---------------------------------------------------------------------------------//
		Integer i =Integer.parseInt(spinnerPintura.getValue().toString());
		double totalProductos= precioPintura*i+precioRodillo*i+precioPapel*i+precioBrocha*i+precioEscalera*i+precioBarniz*i+precioDisolvente*i+precioPlasticos*i+precioDecapante*i+precioEspatula*i;
		String valorTextonumerico = String.valueOf(totalProductos);

		
		PanelTotal.setText(valorTextonumerico);
		PanelTotal.setEditable(false);
		PanelTotal.setBackground(Color.ORANGE);
		PanelTotal.setForeground(new Color(0, 0, 255));
		PanelTotal.setBounds(406, 472, 272, 20);
		contentPane.add(PanelTotal);

	}
}
