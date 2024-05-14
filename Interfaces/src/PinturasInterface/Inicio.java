package PinturasInterface;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import PinturasDB.CompraDB;
import PinturasDB.ProductoDB;
import ProyectoPinturas.Usuario;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Usuario usuario_logueado;
	private Date fechaActual = new Date(System.currentTimeMillis());
	
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
		spinnerPintura.setEnabled(false);
		spinnerPintura.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerPintura.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
				 
				
				
				
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
				spinnerPintura.setEnabled(false);
				PanelTotal.setVisible(false);
				PanelTotal.setVisible(true);
			}
		});
		spinnerPintura.setBounds(174, 54, 43, 20);
		contentPane.add(spinnerPintura);

		JSpinner spinnerRodillo = new JSpinner();
		spinnerRodillo.setEnabled(false);
		spinnerRodillo.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
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
		spinnerPapel.setEnabled(false);
		spinnerPapel.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
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
		spinnerBrocha.setEnabled(false);
		spinnerBrocha.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
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
		spinnerEscalera.setEnabled(false);
		spinnerEscalera.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
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
		
		JSpinner spinnerBarniz = new JSpinner();
		spinnerBarniz.setEnabled(false);
		spinnerBarniz.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
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
		
		JSpinner spinnerDisolvente = new JSpinner();
		spinnerDisolvente.setEnabled(false);
		spinnerDisolvente.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
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
		
		JSpinner spinnerPlasticos = new JSpinner();
		spinnerPlasticos.setEnabled(false);
		spinnerPlasticos.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
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
		
		JSpinner spinnerDecapante = new JSpinner();
		spinnerDecapante.setEnabled(false);
		spinnerDecapante.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
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
		
		JSpinner spinnerEspatula = new JSpinner();
		spinnerEspatula.setEnabled(false);
		spinnerEspatula.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
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
		
		
		


		JButton btnNewButton = new JButton("COMPRAR");
		btnNewButton.setIcon(new ImageIcon(Inicio.class.getResource("/resources/carrito-de-supermercado (1).png")));
		btnNewButton.setBounds(506, 486, 151, 35);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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
		        double precioTotal = precioTotalPintura + precioTotalRodillo + precioTotalPapel +
		                             precioTotalBrocha + precioTotalEscalera + precioTotalBarniz +
		                             precioTotalDisolvente + precioTotalPlasticos + precioTotalDecapante +
		                             precioTotalEspatula;
		        
		        CompraDB compraDB = new CompraDB();
				try {
					CompraDB.guardarCompra(usuario_logueado.getDNI(), fechaActual);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
			       
			       // HistorialCompras historial = new HistorialCompras();
				
				try {
					CompraDB.actulizarHistorial(cantidadPlasticos, cantidadDecapante, cantidadEspatula, precioTotal);;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        // Mostrar un mensaje de confirmación con el precio total
		        JOptionPane.showMessageDialog(null, "El precio total de la compra es: " + precioTotal + "€", "Compra realizada", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		






		//---------------------------------------------------------------------------------//
		Integer i =Integer.parseInt(spinnerPintura.getValue().toString());
		double totalProductos= precioPintura*i+precioRodillo*i+precioPapel*i+precioBrocha*i+precioEscalera*i+precioBarniz*i+precioDisolvente*i+precioPlasticos*i+precioDecapante*i+precioEspatula*i;
		String valorTextonumerico = String.valueOf(totalProductos);


		PanelTotal.setText(valorTextonumerico);
		PanelTotal.setEditable(false);
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
				double precioTotal = precioTotalPintura + precioTotalRodillo + precioTotalPapel +
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
	
}
