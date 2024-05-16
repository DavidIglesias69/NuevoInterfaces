package PinturasInterface;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import PinturasDB.CompraDB;
import PinturasDB.HistorialDB;
import PinturasDB.ProductoDB;
import ProyectoPinturas.Usuario;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Usuario usuario_logueado;
	private Date fechaActual = new Date(System.currentTimeMillis());
	double precioTotal=0;
	ArrayList<JSpinner> componentes = new ArrayList<JSpinner>();
	ArrayList<JLabel> labels = new ArrayList<JLabel>();


	public Inicio (Usuario usuario_logueado) throws SQLException {

		setTitle("Panel de Productos ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 573);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
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

		JLabel PrecioEscalera = new JLabel();
		PrecioEscalera.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PrecioEscalera.setHorizontalAlignment(SwingConstants.CENTER);
		PrecioEscalera.setBounds(134, 397, 57, 14);
		contentPane.add(PrecioEscalera);

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

		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon(Inicio.class.getResource("/resources/barniz.png")));
		lblNewLabel_2_2.setBounds(629, 24, 80, 64);
		contentPane.add(lblNewLabel_2_2);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(Inicio.class.getResource("/resources/sin-disolventes.png")));
		lblNewLabel_1_1.setBounds(614, 99, 80, 72);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(Inicio.class.getResource("/resources/rollos-de-papel.png")));
		lblNewLabel_3_1.setBounds(629, 197, 80, 67);
		contentPane.add(lblNewLabel_3_1);

		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(Inicio.class.getResource("/resources/aerosol.png")));
		lblNewLabel_4_1.setBounds(629, 277, 65, 72);
		contentPane.add(lblNewLabel_4_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setIcon(new ImageIcon(Inicio.class.getResource("/resources/espatula.png")));
		lblNewLabel_2_1_1.setBounds(629, 360, 80, 72);
		contentPane.add(lblNewLabel_2_1_1);




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
		PrecioEscalera.setText(String.valueOf(precioEscalera) + "€");

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




		int cantStockPintura = ProductoDB.obtenerCantidad("pintura");
		JSpinner spinnerPintura = new JSpinner();
		spinnerPintura.setEnabled(false);
		spinnerPintura.setModel(new SpinnerNumberModel(0, 0, cantStockPintura, 1));
		spinnerPintura.setBounds(174, 54, 43, 20);
		contentPane.add(spinnerPintura);

		int cantStockRodillo = ProductoDB.obtenerCantidad("rodillo");
		JSpinner spinnerRodillo = new JSpinner();
		spinnerRodillo.setEnabled(false);
		spinnerRodillo.setModel(new SpinnerNumberModel(0, 0, cantStockRodillo, 1));
		spinnerRodillo.setBounds(174, 126, 43, 20);
		contentPane.add(spinnerRodillo);

		int cantStockPapel = ProductoDB.obtenerCantidad("papel");
		JSpinner spinnerPapel = new JSpinner();
		spinnerPapel.setEnabled(false);
		spinnerPapel.setModel(new SpinnerNumberModel(0, 0, cantStockPapel, 1));
		spinnerPapel.setBounds(174, 230, 43, 20);
		contentPane.add(spinnerPapel);

		int cantStockBrocha = ProductoDB.obtenerCantidad("Brocha");
		JSpinner spinnerBrocha = new JSpinner();
		spinnerBrocha.setEnabled(false);
		spinnerBrocha.setModel(new SpinnerNumberModel(0, 0, cantStockBrocha, 1));
		spinnerBrocha.setBounds(174, 307, 43, 20);
		contentPane.add(spinnerBrocha);
		
		int cantStockEscalera = ProductoDB.obtenerCantidad("Escalera");
		JSpinner spinnerEscalera = new JSpinner();		
		spinnerEscalera.setEnabled(false);
		spinnerEscalera.setModel(new SpinnerNumberModel(0, 0, cantStockEscalera, 1));
		spinnerEscalera.setBounds(189, 394, 43, 20);
		contentPane.add(spinnerEscalera);
		
		int cantStockBarniz = ProductoDB.obtenerCantidad("barniz");
		JSpinner spinnerBarniz = new JSpinner();
		spinnerBarniz.setEnabled(false);
		spinnerBarniz.setModel(new SpinnerNumberModel(0, 0, cantStockBarniz, 1));
		spinnerBarniz.setBounds(574, 54, 45, 20);
		contentPane.add(spinnerBarniz);
		
		int cantStockDisolvente = ProductoDB.obtenerCantidad("disolvente");
		JSpinner spinnerDisolvente = new JSpinner();
		spinnerDisolvente.setEnabled(false);
		spinnerDisolvente.setModel(new SpinnerNumberModel(0, 0, cantStockDisolvente, 1));
		spinnerDisolvente.setBounds(574, 126, 45, 20);
		contentPane.add(spinnerDisolvente);

		int cantStockPlasticos = ProductoDB.obtenerCantidad("Plasticos");
		JSpinner spinnerPlasticos = new JSpinner();
		spinnerPlasticos.setEnabled(false);
		spinnerPlasticos.setModel(new SpinnerNumberModel(0, 0, cantStockPlasticos, 1));
		spinnerPlasticos.setBounds(574, 230, 45, 20);
		contentPane.add(spinnerPlasticos);

		int cantStockDecapante = ProductoDB.obtenerCantidad("Decapante");
		JSpinner spinnerDecapante = new JSpinner();
		spinnerDecapante.setEnabled(false);
		spinnerDecapante.setModel(new SpinnerNumberModel(0, 0, cantStockDecapante, 1));
		spinnerDecapante.setBounds(574, 307, 45, 20);
		contentPane.add(spinnerDecapante);
		
		int cantStockEspatula = ProductoDB.obtenerCantidad("Espatula");
		JSpinner spinnerEspatula = new JSpinner();
		spinnerEspatula.setEnabled(false);
		spinnerEspatula.setModel(new SpinnerNumberModel(0, 0, cantStockEspatula, 1));
		spinnerEspatula.setBounds(574, 394, 45, 20);
		contentPane.add(spinnerEspatula);
		
		

		JCheckBox BoxPintura = new JCheckBox("Pintura");
		BoxPintura.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxPintura.setBounds(25, 51, 97, 23);
		contentPane.add(BoxPintura);
		BoxPintura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verificar si el checkbox está marcado
				if (BoxPintura.isSelected()) {
					// Habilitar el spinner si el checkbox está marcado
					spinnerPintura.setEnabled(true);
				} else {
					// Deshabilitar el spinner si el checkbox está desmarcado
					spinnerPintura.setEnabled(false);
				}
			}
		});


		JCheckBox BoxRodillo = new JCheckBox("Rodillo");
		BoxRodillo.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxRodillo.setBounds(25, 123, 101, 23);
		contentPane.add(BoxRodillo);
		BoxRodillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verificar si el checkbox está marcado
				if (BoxRodillo.isSelected()) {
					// Habilitar el spinner si el checkbox está marcado
					spinnerRodillo.setEnabled(true);
				} else {
					// Deshabilitar el spinner si el checkbox está desmarcado
					spinnerRodillo.setEnabled(false);
				}
			}
		});

		JCheckBox BoxPapel = new JCheckBox("Papel");
		BoxPapel.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxPapel.setBounds(25, 227, 88, 23);
		contentPane.add(BoxPapel);
		BoxPapel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verificar si el checkbox está marcado
				if (BoxPapel.isSelected()) {
					// Habilitar el spinner si el checkbox está marcado
					spinnerPapel.setEnabled(true);
				} else {
					// Deshabilitar el spinner si el checkbox está desmarcado
					spinnerPapel.setEnabled(false);
				}
			}
		});

		JCheckBox BoxBrocha = new JCheckBox("Brocha");
		BoxBrocha.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxBrocha.setBounds(25, 304, 89, 23);
		contentPane.add(BoxBrocha);
		BoxBrocha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verificar si el checkbox está marcado
				if (BoxBrocha.isSelected()) {
					// Habilitar el spinner si el checkbox está marcado
					spinnerBrocha.setEnabled(true);
				} else {
					// Deshabilitar el spinner si el checkbox está desmarcado
					spinnerBrocha.setEnabled(false);
				}
			}
		});


		JCheckBox BoxEscalera = new JCheckBox("Escalera");
		BoxEscalera.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxEscalera.setBounds(21, 391, 110, 23);
		contentPane.add(BoxEscalera);
		BoxEscalera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verificar si el checkbox está marcado
				if (BoxEscalera.isSelected()) {
					// Habilitar el spinner si el checkbox está marcado
					spinnerEscalera.setEnabled(true);
				} else {
					// Deshabilitar el spinner si el checkbox está desmarcado
					spinnerEscalera.setEnabled(false);
				}
			}
		});


		JCheckBox BoxBarniz = new JCheckBox("Barniz");
		BoxBarniz.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxBarniz.setBounds(388, 54, 97, 23);
		contentPane.add(BoxBarniz);
		BoxBarniz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verificar si el checkbox está marcado
				if (BoxBarniz.isSelected()) {
					// Habilitar el spinner si el checkbox está marcado
					spinnerBarniz.setEnabled(true);
				} else {
					// Deshabilitar el spinner si el checkbox está desmarcado
					spinnerBarniz.setEnabled(false);
				}
			}
		});





		JCheckBox BoxDisolvente = new JCheckBox("Disolvente");
		BoxDisolvente.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxDisolvente.setBounds(388, 126, 125, 23);
		contentPane.add(BoxDisolvente);
		BoxDisolvente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verificar si el checkbox está marcado
				if (BoxDisolvente.isSelected()) {
					// Habilitar el spinner si el checkbox está marcado
					spinnerDisolvente.setEnabled(true);
				} else {
					// Deshabilitar el spinner si el checkbox está desmarcado
					spinnerDisolvente.setEnabled(false);
				}
			}
		});





		JCheckBox BoxPlasticos = new JCheckBox("Plasticos");
		BoxPlasticos.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxPlasticos.setBounds(388, 230, 125, 23);
		contentPane.add(BoxPlasticos);
		BoxPlasticos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verificar si el checkbox está marcado
				if (BoxPlasticos.isSelected()) {
					// Habilitar el spinner si el checkbox está marcado
					spinnerPlasticos.setEnabled(true);
				} else {
					// Deshabilitar el spinner si el checkbox está desmarcado
					spinnerPlasticos.setEnabled(false);
				}
			}
		});




		JCheckBox BoxDecapante = new JCheckBox("Decapante");
		BoxDecapante.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxDecapante.setBounds(388, 307, 125, 23);
		contentPane.add(BoxDecapante);
		BoxDecapante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verificar si el checkbox está marcado
				if (BoxDecapante.isSelected()) {
					// Habilitar el spinner si el checkbox está marcado
					spinnerDecapante.setEnabled(true);
				} else {
					// Deshabilitar el spinner si el checkbox está desmarcado
					spinnerDecapante.setEnabled(false);
				}
			}
		});



		JCheckBox BoxEspatula = new JCheckBox("Espatula");
		BoxEspatula.setFont(new Font("Monospaced", Font.PLAIN, 16));
		BoxEspatula.setBounds(388, 394, 110, 23);
		contentPane.add(BoxEspatula);
		BoxEspatula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verificar si el checkbox está marcado
				if (BoxEspatula.isSelected()) {
					// Habilitar el spinner si el checkbox está marcado
					spinnerEspatula.setEnabled(true);
				} else {
					// Deshabilitar el spinner si el checkbox está desmarcado
					spinnerEspatula.setEnabled(false);
				}
			}
		});


		JTextField PanelTotal = new JTextField();

		//LISTENERS DE UNA VEZ
		componentes.add(spinnerPintura);
		componentes.add(spinnerRodillo);
		componentes.add(spinnerPapel);
		componentes.add(spinnerBrocha);
		componentes.add(spinnerEscalera);
		componentes.add(spinnerBarniz);
		componentes.add(spinnerDisolvente);
		componentes.add(spinnerPlasticos);
		componentes.add(spinnerDecapante);
		componentes.add(spinnerEspatula);

		disableSpinnerEdit(componentes);
		
		labels.add(PrecioPintura);
		labels.add(PrecioRodillo);
		labels.add(PrecioPapel);
		labels.add(PrecioBrocha);
		labels.add(PrecioEscalera);
		labels.add(PrecioBarniz);
		labels.add(PrecioDisolvente);
		labels.add(PrecioPlasticos);
		labels.add(PrecioDecapante);
		labels.add(PrecioEspatula);




		for (JSpinner componente : componentes) {

			componente.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					double precio = precioTotal();
					PanelTotal.setText(""+precio+"€");

				}
			});

		}




		JButton btnNewButton = new JButton("COMPRAR");
		btnNewButton.setIcon(new ImageIcon(Inicio.class.getResource("/resources/carrito-de-supermercado (1).png")));
		btnNewButton.setBounds(506, 486, 151, 35);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            int idCompra = CompraDB.guardarCompra(usuario_logueado.getDNI(), fechaActual);
		            if (idCompra != -1) {
		                // Filtra los componentes habilitados (los seleccionados) antes de actualizar el historial
		                ArrayList<JSpinner> componentesSeleccionados = new ArrayList<JSpinner>();
		                ArrayList<JLabel> labelsSeleccionados = new ArrayList<JLabel>();
		                for (int i = 0; i < componentes.size(); i++) {
		                    if (componentes.get(i).isEnabled()) {
		                        componentesSeleccionados.add(componentes.get(i));
		                        labelsSeleccionados.add(labels.get(i));
		                    }
		                }
		                HistorialDB.actualizarHistorial(idCompra, componentesSeleccionados, labelsSeleccionados);
		                JOptionPane.showMessageDialog(null, "El precio total de la compra es: " + precioTotal() + " €", "Compra realizada", JOptionPane.INFORMATION_MESSAGE);
		            } else {
		                JOptionPane.showMessageDialog(null, "Error al guardar la compra.", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } catch (SQLException e1) {
		            JOptionPane.showMessageDialog(null, "Error al realizar la compra: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            e1.printStackTrace();
		        }
		    }
		});


		//---------------------------------------------------------------------------------//
		Integer i =Integer.parseInt(spinnerPintura.getValue().toString());
		double totalProductos= precioPintura*i+precioRodillo*i+precioPapel*i+precioBrocha*i+precioEscalera*i+precioBarniz*i+precioDisolvente*i+precioPlasticos*i+precioDecapante*i+precioEspatula*i;
		String valorTextonumerico = String.valueOf(totalProductos);


		PanelTotal.setText(valorTextonumerico);
		PanelTotal.setBackground(Color.ORANGE);
		PanelTotal.setForeground(new Color(0, 0, 255));
		PanelTotal.setBounds(210, 498, 272, 20);
		contentPane.add(PanelTotal);

		// Recopilar información sobre los productos seleccionados y las cantidades
		int cantidadPintura = (int) spinnerPintura.getValue();
		int cantidadRodillo = (int) spinnerRodillo.getValue();
		int cantidadPapel = (int) spinnerPapel.getValue();
		int cantidadBrocha = (int) spinnerBrocha.getValue();
		int cantidadEscalera = (int) spinnerEscalera.getValue();
		int cantidadBarniz = (int) spinnerBarniz.getValue();
		int cantidadDisolvente = (int) spinnerDisolvente.getValue();
		int cantidadPlasticos = (int) spinnerPlasticos.getValue();
		int cantidadDecapante = (int) spinnerDecapante.getValue();
		int cantidadEspatula = (int) spinnerEspatula.getValue();

		// Obtener precios de los productos seleccionados
		double precioTotalPintura = precioPintura * cantidadPintura;
		double precioTotalRodillo = precioRodillo * cantidadRodillo;
		double precioTotalPapel = precioPapel * cantidadPapel;
		double precioTotalBrocha = precioBrocha * cantidadBrocha;
		double precioTotalEscalera = precioEscalera * cantidadEscalera;
		double precioTotalBarniz = precioBarniz * cantidadBarniz;
		double precioTotalDisolvente = precioDisolvente * cantidadDisolvente;
		double precioTotalPlasticos = precioPlasticos * cantidadPlasticos;
		double precioTotalDecapante = precioDecapante * cantidadDecapante;
		double precioTotalEspatula = precioEspatula * cantidadEspatula;

		// Calcular el precio total sumando los precios individuales de los productos seleccionados
		precioTotal = precioTotalPintura + precioTotalRodillo + precioTotalPapel +
				precioTotalBrocha + precioTotalEscalera + precioTotalBarniz +
				precioTotalDisolvente + precioTotalPlasticos + precioTotalDecapante +
				precioTotalEspatula;
		// Convertir el precio total a una cadena de texto
		String precioTotalTexto = String.valueOf(precioTotal);
		// Establecer el texto en el JEditorPane
		PanelTotal.setText(precioTotalTexto);

		JButton historial = new JButton("Historial de Compras");
		historial.setIcon(new ImageIcon(Inicio.class.getResource("/resources/historial-medico (1).png")));
		historial.setBounds(10, 491, 190, 34);
		contentPane.add(historial);

		// Crear un ActionListener para el botón de historial de compras
		historial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtener el DNI del usuario actual
				String dniUsuario = usuario_logueado.getDNI();
				// Aquí debes verificar si el usuario logueado es responsable o no
				// Crear una instancia de HistorialCompras pasando el DNI del usuario como parámetro
				HistorialCompras historial = new HistorialCompras(dniUsuario);
				historial.setVisible(true);
			}
		});


		JButton btnSalir = new JButton("SALIR");
		btnSalir.setIcon(new ImageIcon(Inicio.class.getResource("/resources/boton.png")));
		btnSalir.setBounds(670, 486, 136, 37);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // Cerrar la aplicación al hacer clic en el botón "Salir"
			}


		});


		// Crea un JLabel para mostrar la fecha actual
		JLabel lblFecha = new JLabel("Fecha:  " + fechaActual);				
		lblFecha.setBounds(719, 45, 124, 14);				
		contentPane.add(lblFecha);

	}



	public double precioTotal() {
	    double total = 0;
	    for (int i = 0; i < componentes.size(); i++) {
	        if (componentes.get(i).isEnabled()) {
	            String text = labels.get(i).getText();
	            double precioLabel = Double.parseDouble(text.substring(0, text.length() - 1));
	            int cantSpinner = Integer.parseInt(componentes.get(i).getValue().toString());
	            total += precioLabel * cantSpinner;
	        }
	    }
	    return total;
	}


	// Método para deshabilitar la edición del JSpinner
	private void disableSpinnerEdit(ArrayList<JSpinner> comp) {

		for (JSpinner spinner : comp) {
			JComponent editor = spinner.getEditor();
			if (editor instanceof JSpinner.DefaultEditor) {
				JFormattedTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();
				textField.setEditable(false);
			}
		}

	}



}
