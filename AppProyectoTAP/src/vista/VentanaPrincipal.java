package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.IODataFile;
import modelo.Catalogo;
import modelo.Producto;
import modelo.Resurtido;
import modelo.Venta;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PanelBarra panelSuperior = new PanelBarra();
	private PanelOpciones panelOpciones = new PanelOpciones();
	private PanelInformacion panelInformacion = new PanelInformacion();
	private PanelHome panelHome = new PanelHome();
	private PanelVenta panelVenta = new PanelVenta();
	private PanelProductos panelProductos = new PanelProductos();
	private PanelResurtir panelResurtir = new PanelResurtir();
	private PanelResurtidos panelResurtidos = new PanelResurtidos();
	private PanelHistorialVentas panelHistorialVentas = new PanelHistorialVentas();
	private Catalogo<Producto> listaProductos;
	private Catalogo<Resurtido> listaResurtidos;
	private Catalogo<Venta> listaVentas;
	private GridBagConstraints gbc_panelSuperior = new GridBagConstraints();
	private GridBagConstraints gbc_panelIzquierda = new GridBagConstraints();
	private GridBagConstraints gbc_panelInformacion = new GridBagConstraints();
	private GridBagConstraints gbc_panelDerecha = new GridBagConstraints();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {

		// Metodo ventana abierta y cerrandose
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					String rutaProducto = "src/recursos/assets/productos.dat";
					if (IODataFile.readObjectToFileProducto(rutaProducto) != null) {
						listaProductos = IODataFile.readObjectToFileProducto(rutaProducto);
						listaProductos.ordenar();
					} else {
						listaProductos = new Catalogo<Producto>();
					}
					String rutaResurtido = "src/recursos/assets/resurtidos.dat";
					if (IODataFile.readObjectToFileResurtido(rutaResurtido) != null) {
						listaResurtidos = IODataFile.readObjectToFileResurtido(rutaResurtido);
						listaResurtidos.ordenar();
					} else {
						listaResurtidos = new Catalogo<Resurtido>();
					}
					String rutaVenta = "src/recursos/assets/ventas.dat";
					if (IODataFile.readObjectToFileVenta(rutaVenta) != null) {
						listaVentas = IODataFile.readObjectToFileVenta(rutaVenta);
						listaVentas.ordenar();
					} else {
						listaVentas = new Catalogo<Venta>();
					}
				} catch (Exception e1) {
					System.out.println(e1);
				}
				panelHome.calcularStock(listaProductos);
				panelHome.calcularVentas(listaVentas);
				panelHome.calcularInventario(listaProductos);
				panelHome.calcularGanancia(listaVentas);
				panelHome.menosStock(listaProductos);
				panelHome.masVendidos(listaVentas, listaProductos);
			}

			@Override
			public void windowClosing(WindowEvent e) {
				try {
					String rutaProducto = "src/recursos/assets/productos.dat";
					String rutaResurtido = "src/recursos/assets/resurtidos.dat";
					String rutaVenta = "src/recursos/assets/ventas.dat";
					IODataFile.writeObjectToFileProducto(rutaProducto, listaProductos);
					IODataFile.writeObjectToFileResurtido(rutaResurtido, listaResurtidos);
					IODataFile.writeObjectToFileVenta(rutaVenta, listaVentas);
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});

		// Componentes
		setResizable(false);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 250, 1000 };
		gbl_contentPane.rowHeights = new int[] { 47, 54, 0 };
		gbl_contentPane.columnWeights = new double[] { 10.0, 90.0 };
		gbl_contentPane.rowWeights = new double[] { 5.0, 5.0, 90.0 };
		contentPane.setLayout(gbl_contentPane);

		gbc_panelSuperior = new GridBagConstraints();
		gbc_panelSuperior.fill = GridBagConstraints.BOTH;
		gbc_panelSuperior.gridx = 1;
		gbc_panelSuperior.gridy = 0;
		panelSuperior.setBorder(new EmptyBorder(15, 0, 0, 15));
		contentPane.add(panelSuperior, gbc_panelSuperior);

		gbc_panelIzquierda = new GridBagConstraints();
		gbc_panelIzquierda.gridheight = 3;
		gbc_panelIzquierda.fill = GridBagConstraints.BOTH;
		gbc_panelIzquierda.gridx = 0;
		gbc_panelIzquierda.gridy = 0;
		panelOpciones.setBorder(new EmptyBorder(15, 0, 15, 0));
		contentPane.add(panelOpciones, gbc_panelIzquierda);

		gbc_panelInformacion.fill = GridBagConstraints.BOTH;
		gbc_panelInformacion.gridx = 1;
		gbc_panelInformacion.gridy = 1;
		panelInformacion.setBorder(new EmptyBorder(0, 15, 0, 15));
		contentPane.add(panelInformacion, gbc_panelInformacion);

		panelHome.setBackground(new Color(28, 32, 57));
		panelHome.setBorder(new EmptyBorder(0, 15, 15, 15));
		gbc_panelDerecha.fill = GridBagConstraints.BOTH;
		gbc_panelDerecha.gridx = 1;
		gbc_panelDerecha.gridy = 2;
		contentPane.add(panelHome, gbc_panelDerecha);

		// Metodos Barra Superior
		panelSuperior.getBtnMinimizar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		panelSuperior.getBtnSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String rutaProducto = "src/recursos/assets/productos.dat";
					String rutaResurtido = "src/recursos/assets/resurtidos.dat";
					String rutaVenta = "src/recursos/assets/ventas.dat";
					IODataFile.writeObjectToFileProducto(rutaProducto, listaProductos);
					IODataFile.writeObjectToFileResurtido(rutaResurtido, listaResurtidos);
					IODataFile.writeObjectToFileVenta(rutaVenta, listaVentas);
					System.exit(0);
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});

		// Metodos Panel Izquierdo
		panelOpciones.getBtnHome().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerPaneles(panelHome);
				panelHome.calcularStock(listaProductos);
				panelHome.calcularStock(listaProductos);
				panelHome.calcularVentas(listaVentas);
				panelHome.calcularInventario(listaProductos);
				panelHome.calcularGanancia(listaVentas);
				panelHome.menosStock(listaProductos);
				panelHome.masVendidos(listaVentas, listaProductos);
			}
		});
		panelOpciones.getBtnVender().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerPaneles(panelVenta);
				panelVenta.getCodigoBarras().requestFocus();
			}
		});
		panelOpciones.getBtnProductos().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerPaneles(panelProductos);
				panelProductos.llenarTabla(listaProductos);
			}
		});
		panelOpciones.getBtnResurtir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerPaneles(panelResurtir);
				panelResurtir.getCodigoBarras().requestFocus();
			}
		});
		panelOpciones.getBtnResurtidos().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerPaneles(panelResurtidos);
				panelResurtidos.llenarTablaResurtido(listaResurtidos);
			}
		});
		panelOpciones.getBtnVentas().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerPaneles(panelHistorialVentas);
				panelHistorialVentas.llenarTablaVenta(listaVentas);
			}
		});

		// Metodos Productos
		panelProductos.getBtnBuscar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelProductos.buscarProducto(listaProductos);
			}
		});

		panelProductos.getBtnLimpiar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelProductos.limpiarCampos();
			}
		});

		panelProductos.getBtnNuevo().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelProductos.registrarProducto(listaProductos);
			}
		});

		panelProductos.getBtnModificar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelProductos.modificarProducto(listaProductos);
			}
		});

		panelProductos.getBtnEliminar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelProductos.eliminarProducto(listaProductos, listaVentas, listaResurtidos);
			}
		});
		
		panelProductos.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					int rowIndex = panelProductos.getTable().getSelectedRow();
					if (rowIndex >= 0) {
						Object cBarras = panelProductos.getTable().getValueAt(rowIndex, 0);
						panelProductos.getCodigoBarras().setText(cBarras.toString());
						panelProductos.buscarProducto(listaProductos);
					}
				}
			}
		});

		// Metodos Resurtir
		panelResurtir.getBtnBuscar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelResurtir.buscarProducto(listaProductos);
			}
		});

		panelResurtir.getBtnLimpiar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelResurtir.limpiarCampos();
			}
		});

		panelResurtir.getBtnAgregar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelResurtir.agregarResurtido(listaProductos);
			}
		});

		panelResurtir.getBtnEliminar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelResurtir.eliminarResurtido();
			}
		});

		panelResurtir.getBtnResurtir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelResurtir.resurtir(listaResurtidos, listaProductos);
			}
		});

		panelResurtir.getBtnCancelar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelResurtir.cancelarResurtido();
			}
		});

		// Metodos Historial Resurtidos
		panelResurtidos.getBtnBuscar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelResurtidos.buscar(listaResurtidos);
			}
		});

		panelResurtidos.getBtnMostrarTodo().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelResurtidos.mostrarTodo();
				panelResurtidos.llenarTablaResurtido(listaResurtidos);
			}
		});
		
		panelResurtidos.getTablaRenglones().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					int rowIndex = panelResurtidos.getTablaRenglones().getSelectedRow();
					if (rowIndex >= 0) {
						Object cBarras = panelResurtidos.getTablaRenglones().getValueAt(rowIndex, 0);
						Producto producto = listaProductos.getElementEach(cBarras.toString());
						JOptionPane.showMessageDialog(null, producto.toString());
					}
				}
			}
		});

		// Metodos Vender
		panelVenta.getBtnBuscar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelVenta.buscarProducto(listaProductos);
			}
		});

		panelVenta.getBtnLimpiar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelVenta.limpiarCampos();
			}
		});

		panelVenta.getBtnAgregar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelVenta.agregarVenta();
			}
		});

		panelVenta.getBtnEliminar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelVenta.eliminarVenta();
			}
		});

		panelVenta.getBtnPagar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelVenta.vender(listaVentas, listaProductos);
			}
		});

		panelVenta.getBtnCancelar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelVenta.cancelarVenta();
			}
		});

		// Metodos Historial Ventas
		panelHistorialVentas.getBtnBuscar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelHistorialVentas.buscar(listaVentas);
			}
		});

		panelHistorialVentas.getBtnMostrarTodo().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelHistorialVentas.mostrarTodo();
				panelHistorialVentas.llenarTablaVenta(listaVentas);
			}
		});
		panelHistorialVentas.getTablaRenglones().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					int rowIndex = panelHistorialVentas.getTablaRenglones().getSelectedRow();
					if (rowIndex >= 0) {
						Object cBarras = panelHistorialVentas.getTablaRenglones().getValueAt(rowIndex, 1);
						Producto producto = listaProductos.getElementEach(cBarras.toString());
						JOptionPane.showMessageDialog(null, producto.toString());
					}
				}
			}
		});
	}

	public void removerPaneles(JPanel panelNuevo) {
		if (panelNuevo instanceof PanelHome) {

			habilitarBotones(true);
			panelOpciones.getBtnHome().setEnabled(false);

			contentPane.removeAll();
			contentPane.add(panelHome, gbc_panelDerecha);
			contentPane.add(panelSuperior, gbc_panelSuperior);
			contentPane.add(panelOpciones, gbc_panelIzquierda);
			contentPane.add(panelInformacion, gbc_panelInformacion);
			panelInformacion.getLblTitulo().setText("DASHBOARD");

			repaint();
			setVisible(true);
			System.gc();

		} else if (panelNuevo instanceof PanelVenta) {

			habilitarBotones(true);
			panelOpciones.getBtnVender().setEnabled(false);

			contentPane.removeAll();
			contentPane.add(panelVenta, gbc_panelDerecha);
			contentPane.add(panelSuperior, gbc_panelSuperior);
			contentPane.add(panelOpciones, gbc_panelIzquierda);
			contentPane.add(panelInformacion, gbc_panelInformacion);
			panelInformacion.getLblTitulo().setText("REALIZAR VENTA");

			repaint();
			setVisible(true);
			System.gc();

		} else if (panelNuevo instanceof PanelProductos) {

			habilitarBotones(true);
			panelOpciones.getBtnProductos().setEnabled(false);

			contentPane.removeAll();
			contentPane.add(panelProductos, gbc_panelDerecha);
			contentPane.add(panelSuperior, gbc_panelSuperior);
			contentPane.add(panelOpciones, gbc_panelIzquierda);
			contentPane.add(panelInformacion, gbc_panelInformacion);
			panelInformacion.getLblTitulo().setText("CONTROL PRODUCTOS");

			repaint();
			setVisible(true);
			System.gc();

		} else if (panelNuevo instanceof PanelResurtir) {

			habilitarBotones(true);
			panelOpciones.getBtnResurtir().setEnabled(false);

			contentPane.removeAll();
			contentPane.add(panelResurtir, gbc_panelDerecha);
			contentPane.add(panelSuperior, gbc_panelSuperior);
			contentPane.add(panelOpciones, gbc_panelIzquierda);
			contentPane.add(panelInformacion, gbc_panelInformacion);
			panelInformacion.getLblTitulo().setText("RESURTIR PRODUCTOS");

			repaint();
			setVisible(true);
			System.gc();

		} else if (panelNuevo instanceof PanelResurtidos) {

			habilitarBotones(true);
			panelOpciones.getBtnResurtidos().setEnabled(false);

			contentPane.removeAll();
			contentPane.add(panelResurtidos, gbc_panelDerecha);
			contentPane.add(panelSuperior, gbc_panelSuperior);
			contentPane.add(panelOpciones, gbc_panelIzquierda);
			contentPane.add(panelInformacion, gbc_panelInformacion);
			panelInformacion.getLblTitulo().setText("HISTORIAL RESURTIDOS");

			repaint();
			setVisible(true);
			System.gc();

		} else if (panelNuevo instanceof PanelHistorialVentas) {

			habilitarBotones(true);
			panelOpciones.getBtnVentas().setEnabled(false);

			contentPane.removeAll();
			contentPane.add(panelHistorialVentas, gbc_panelDerecha);
			contentPane.add(panelSuperior, gbc_panelSuperior);
			contentPane.add(panelOpciones, gbc_panelIzquierda);
			contentPane.add(panelInformacion, gbc_panelInformacion);
			panelInformacion.getLblTitulo().setText("HISTORIAL VENTAS");

			repaint();
			setVisible(true);
			System.gc();

		}
	}

	public void habilitarBotones(boolean state) {
		panelOpciones.getBtnHome().setEnabled(state);
		panelOpciones.getBtnVender().setEnabled(state);
		panelOpciones.getBtnProductos().setEnabled(state);
		panelOpciones.getBtnResurtir().setEnabled(state);
		panelOpciones.getBtnResurtidos().setEnabled(state);
		panelOpciones.getBtnVentas().setEnabled(state);
	}

}
