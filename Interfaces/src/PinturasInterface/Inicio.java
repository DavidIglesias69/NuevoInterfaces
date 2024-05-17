package PinturasInterface;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import PinturasDB.CompraDB;
import PinturasDB.HistorialDB;
import PinturasDB.ProductoDB;
import ProyectoPinturas.Usuario;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    Usuario usuario_logueado;
    private Date fechaActual = new Date(System.currentTimeMillis());
    double precioTotal = 0;
    ArrayList<JSpinner> componentes = new ArrayList<JSpinner>();
    ArrayList<JLabel> labels = new ArrayList<JLabel>();

    // Definir nombresProductos como variable de instancia
    private String[] nombresProductos = { "Pintura", "Rodillo", "Papel", "Brocha", "Escalera", "Barniz", "Disolvente", "Plasticos", "Decapante", "Espatula" };

    public Inicio(Usuario usuario_logueado) throws SQLException {
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

        JLabel iconoPintura = new JLabel("");
        iconoPintura.setIcon(new ImageIcon(Inicio.class.getResource("/resources/bote-de-pintura (1).png")));
        iconoPintura.setBounds(227, 11, 73, 72);
        contentPane.add(iconoPintura);

        JLabel iconoRodillo = new JLabel("");
        iconoRodillo.setIcon(new ImageIcon(Inicio.class.getResource("/resources/rodillo.png")));
        iconoRodillo.setBounds(227, 105, 73, 66);
        contentPane.add(iconoRodillo);

        JLabel iconoPapel = new JLabel("");
        iconoPapel.setIcon(new ImageIcon(Inicio.class.getResource("/resources/toalla-de-papel (1).png")));
        iconoPapel.setBounds(227, 197, 73, 67);
        contentPane.add(iconoPapel);

        JLabel iconoBrocha = new JLabel("");
        iconoBrocha.setIcon(new ImageIcon(Inicio.class.getResource("/resources/construccion.png")));
        iconoBrocha.setBounds(227, 275, 73, 66);
        contentPane.add(iconoBrocha);

        JLabel iconoEscalera = new JLabel("");
        iconoEscalera.setIcon(new ImageIcon(Inicio.class.getResource("/resources/escalera-de-mano.png")));
        iconoEscalera.setBounds(242, 366, 80, 66);
        contentPane.add(iconoEscalera);

        JLabel iconoBarniz = new JLabel("");
        iconoBarniz.setIcon(new ImageIcon(Inicio.class.getResource("/resources/barniz.png")));
        iconoBarniz.setBounds(629, 24, 80, 64);
        contentPane.add(iconoBarniz);

        JLabel iconoDisolvente = new JLabel("");
        iconoDisolvente.setIcon(new ImageIcon(Inicio.class.getResource("/resources/sin-disolventes.png")));
        iconoDisolvente.setBounds(614, 99, 80, 72);
        contentPane.add(iconoDisolvente);

        JLabel iconoPlasticos = new JLabel("");
        iconoPlasticos.setIcon(new ImageIcon(Inicio.class.getResource("/resources/rollos-de-papel.png")));
        iconoPlasticos.setBounds(629, 197, 80, 67);
        contentPane.add(iconoPlasticos);

        JLabel iconoDecapante = new JLabel("");
        iconoDecapante.setIcon(new ImageIcon(Inicio.class.getResource("/resources/aerosol.png")));
        iconoDecapante.setBounds(629, 277, 65, 72);
        contentPane.add(iconoDecapante);

        JLabel iconoEspatula = new JLabel("");
        iconoEspatula.setIcon(new ImageIcon(Inicio.class.getResource("/resources/espatula.png")));
        iconoEspatula.setBounds(629, 360, 80, 72);
        contentPane.add(iconoEspatula);

        ProductoDB productoDB = new ProductoDB();
        Conexion conexion = new Conexion();
        Connection conn = conexion.abrirConsulta();

        // Obtener y mostrar el precio de la pintura
        double precioPintura = ProductoDB.obtenerPrecio("Pintura");
        PrecioPintura.setText(String.valueOf(precioPintura) + "€");

        // Obtener y mostrar el precio del rodillo
        double precioRodillo = ProductoDB.obtenerPrecio("Rodillo");
        PrecioRodillo.setText(String.valueOf(precioRodillo) + "€");

        // Obtener y mostrar el precio del papel
        double precioPapel = ProductoDB.obtenerPrecio("Papel");
        PrecioPapel.setText(String.valueOf(precioPapel) + "€");

        // Obtener y mostrar el precio de la brocha
        double precioBrocha = ProductoDB.obtenerPrecio("Brocha");
        PrecioBrocha.setText(String.valueOf(precioBrocha) + "€");

        // Obtener y mostrar el precio de la escalera
        double precioEscalera = ProductoDB.obtenerPrecio("Escalera");
        PrecioEscalera.setText(String.valueOf(precioEscalera) + "€");

        double precioBarniz = ProductoDB.obtenerPrecio("Barniz");
        PrecioBarniz.setText(String.valueOf(precioBarniz) + "€");

        // Obtener y mostrar el precio del disolvente
        double precioDisolvente = ProductoDB.obtenerPrecio("Disolvente");
        PrecioDisolvente.setText(String.valueOf(precioDisolvente) + "€");

        // Obtener y mostrar el precio de los plasticos
        double precioPlasticos = ProductoDB.obtenerPrecio("Plasticos");
        PrecioPlasticos.setText(String.valueOf(precioPlasticos) + "€");

        // Obtener y mostrar el precio del decapante
        double precioDecapante = ProductoDB.obtenerPrecio("Decapante");
        PrecioDecapante.setText(String.valueOf(precioDecapante) + "€");

        // Obtener y mostrar el precio de la espatula
        double precioEspatula = ProductoDB.obtenerPrecio("Espatula");
        PrecioEspatula.setText(String.valueOf(precioEspatula) + "€");

        // Obtener y mostrar las cantidades de cada producto
        int cantStockPintura = ProductoDB.obtenerCantidad("Pintura");
        JSpinner spinnerPintura = new JSpinner();
        spinnerPintura.setEnabled(false);
        spinnerPintura.setModel(new SpinnerNumberModel(0, 0, cantStockPintura, 1));
        spinnerPintura.setBounds(174, 54, 43, 20);
        contentPane.add(spinnerPintura);

        int cantStockRodillo = ProductoDB.obtenerCantidad("Rodillo");
        JSpinner spinnerRodillo = new JSpinner();
        spinnerRodillo.setEnabled(false);
        spinnerRodillo.setModel(new SpinnerNumberModel(0, 0, cantStockRodillo, 1));
        spinnerRodillo.setBounds(174, 126, 43, 20);
        contentPane.add(spinnerRodillo);

        int cantStockPapel = ProductoDB.obtenerCantidad("Papel");
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

        int cantStockBarniz = ProductoDB.obtenerCantidad("Barniz");
        JSpinner spinnerBarniz = new JSpinner();
        spinnerBarniz.setEnabled(false);
        spinnerBarniz.setModel(new SpinnerNumberModel(0, 0, cantStockBarniz, 1));
        spinnerBarniz.setBounds(574, 54, 45, 20);
        contentPane.add(spinnerBarniz);

        int cantStockDisolvente = ProductoDB.obtenerCantidad("Disolvente");
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

        // Cerrar la conexión después de usarla
        if (conn != null) {
            conn.close();
        }

        JCheckBox BoxPintura = new JCheckBox("Pintura");
        BoxPintura.setFont(new Font("Monospaced", Font.PLAIN, 16));
        BoxPintura.setBounds(25, 51, 97, 23);
        contentPane.add(BoxPintura);
        BoxPintura.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (BoxPintura.isSelected()) {
                    spinnerPintura.setEnabled(true);
                } else {
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
                if (BoxRodillo.isSelected()) {
                    spinnerRodillo.setEnabled(true);
                } else {
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
                if (BoxPapel.isSelected()) {
                    spinnerPapel.setEnabled(true);
                } else {
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
                if (BoxBrocha.isSelected()) {
                    spinnerBrocha.setEnabled(true);
                } else {
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
                if (BoxEscalera.isSelected()) {
                    spinnerEscalera.setEnabled(true);
                } else {
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
                if (BoxBarniz.isSelected()) {
                    spinnerBarniz.setEnabled(true);
                } else {
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
                if (BoxDisolvente.isSelected()) {
                    spinnerDisolvente.setEnabled(true);
                } else {
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
                if (BoxPlasticos.isSelected()) {
                    spinnerPlasticos.setEnabled(true);
                } else {
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
                if (BoxDecapante.isSelected()) {
                    spinnerDecapante.setEnabled(true);
                } else {
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
                if (BoxEspatula.isSelected()) {
                    spinnerEspatula.setEnabled(true);
                } else {
                    spinnerEspatula.setEnabled(false);
                }
            }
        });

        JTextField PanelTotal = new JTextField();

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
                    PanelTotal.setText("" + precio + "€");
                }
            });
        }

        JButton btnComprar = new JButton("COMPRAR");
        btnComprar.setIcon(new ImageIcon(Inicio.class.getResource("/resources/carrito-de-supermercado (1).png")));
        btnComprar.setBounds(506, 486, 151, 35);
        contentPane.add(btnComprar);
        btnComprar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Conexion conexion = new Conexion();
                    try (Connection conn = conexion.abrirConsulta()) {
                        conn.setAutoCommit(false); // Desactivar el autocommit para manejar transacciones manualmente

                        ArrayList<String> productosSinStock = verificarStock(conn);
                        if (productosSinStock.size() < componentes.size()) {
                            int idCompra = CompraDB.guardarCompra(usuario_logueado.getDNI(), fechaActual, conn);
                            if (idCompra != -1) {
                                ArrayList<JSpinner> componentesSeleccionados = new ArrayList<JSpinner>();
                                ArrayList<JLabel> labelsSeleccionados = new ArrayList<JLabel>();
                                for (int i = 0; i < componentes.size(); i++) {
                                    if (componentes.get(i).isEnabled() && !productosSinStock.contains(nombresProductos[i])) {
                                        componentesSeleccionados.add(componentes.get(i));
                                        labelsSeleccionados.add(labels.get(i));
                                    }
                                }
                                if (actualizarStock(componentesSeleccionados, conn, productosSinStock)) {
                                    HistorialDB.actualizarHistorial(idCompra, componentesSeleccionados, labelsSeleccionados, nombresProductos, conn);
                                    conn.commit();
                                    String mensaje = "El precio total de la compra es: " + precioTotal() + " €";
                                    if (!productosSinStock.isEmpty()) {
                                        mensaje += "\n\nNo hay suficiente stock para los siguientes productos, por lo que no se compraron:\n";
                                        for (String producto : productosSinStock) {
                                            mensaje += "- " + producto + "\n";
                                        }
                                    }
                                    JOptionPane.showMessageDialog(null, mensaje, "Compra realizada", JOptionPane.INFORMATION_MESSAGE);
                                    actualizarPreciosYCantidades();
                                } else {
                                    conn.rollback();
                                    JOptionPane.showMessageDialog(null, "Error al actualizar el stock.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                conn.rollback();
                                JOptionPane.showMessageDialog(null, "Error al guardar la compra.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            String mensaje = "No hay suficiente stock para los siguientes productos:\n";
                            for (String producto : productosSinStock) {
                                mensaje += "- " + producto + "\n";
                            }
                            JOptionPane.showMessageDialog(null, mensaje, "Error de Stock", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al realizar la compra: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        Integer i = Integer.parseInt(spinnerPintura.getValue().toString());
        double totalProductos = precioPintura * i + precioRodillo * i + precioPapel * i + precioBrocha * i + precioEscalera * i + precioBarniz * i + precioDisolvente * i + precioPlasticos * i + precioDecapante * i + precioEspatula * i;
        String valorTextonumerico = String.valueOf(totalProductos);

        PanelTotal.setText(valorTextonumerico);
        PanelTotal.setBackground(Color.ORANGE);
        PanelTotal.setForeground(new Color(0, 0, 255));
        PanelTotal.setBounds(210, 498, 272, 20);
        contentPane.add(PanelTotal);

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

        precioTotal = precioTotalPintura + precioTotalRodillo + precioTotalPapel + precioTotalBrocha + precioTotalEscalera + precioTotalBarniz + precioTotalDisolvente + precioTotalPlasticos + precioTotalDecapante + precioTotalEspatula;
        String precioTotalTexto = String.valueOf(precioTotal);
        PanelTotal.setText(precioTotalTexto);

        JButton btnHistorial = new JButton("Historial de Compras");
        btnHistorial.setIcon(new ImageIcon(Inicio.class.getResource("/resources/historial-medico (1).png")));
        btnHistorial.setBounds(10, 491, 190, 34);
        contentPane.add(btnHistorial);

        btnHistorial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String dniUsuario = usuario_logueado.getDNI();
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

    private void disableSpinnerEdit(ArrayList<JSpinner> comp) {
        for (JSpinner spinner : comp) {
            JComponent editor = spinner.getEditor();
            if (editor instanceof JSpinner.DefaultEditor) {
                JFormattedTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();
                textField.setEditable(false);
            }
        }
    }

    private ArrayList<String> verificarStock(Connection conn) throws SQLException {
        ArrayList<String> productosSinStock = new ArrayList<>();

        for (int i = 0; i < componentes.size(); i++) {
            if (componentes.get(i).isEnabled()) {
                int cantidadSeleccionada = (Integer) componentes.get(i).getValue();
                int stockActual = ProductoDB.obtenerCantidad(nombresProductos[i]);
                if (cantidadSeleccionada > stockActual) {
                    productosSinStock.add(nombresProductos[i]);
                }
            }
        }
        return productosSinStock;
    }

    private boolean actualizarStock(ArrayList<JSpinner> componentesSeleccionados, Connection conn, ArrayList<String> productosSinStock) throws SQLException {
        for (int i = 0; i < componentesSeleccionados.size(); i++) {
            if (!productosSinStock.contains(nombresProductos[i])) {
                int cantidadComprada = (Integer) componentesSeleccionados.get(i).getValue();
                int stockActual = ProductoDB.obtenerCantidad(nombresProductos[i]);
                ProductoDB.actualizarCantidad(nombresProductos[i], stockActual - cantidadComprada, conn);
            }
        }
        return true;
    }

    private void actualizarPreciosYCantidades() {
        try {
            Conexion conexion = new Conexion();
            Connection conn = conexion.abrirConsulta();

            for (int i = 0; i < componentes.size(); i++) {
                String nombreProducto = nombresProductos[i];
                double precio = ProductoDB.obtenerPrecio(nombreProducto);
                int cantidad = ProductoDB.obtenerCantidad(nombreProducto);

                labels.get(i).setText(String.valueOf(precio) + "€");
                componentes.get(i).setModel(new SpinnerNumberModel(0, 0, cantidad, 1));
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
