package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import modelo.Catalogo;
import modelo.Producto;
import modelo.RenglonResurtido;
import modelo.RenglonTicket;
import modelo.Resurtido;
import modelo.Venta;

public class PanelProductos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField codigoBarras;
	private JTextField nombre;
	private JTextField marca;
	private JTextField descripcion;
	private JComboBox<String> presentacion;
	private JTextField stockMax;
	private JTextField stockMin;
	private JTextField cantidad;
	private JComboBox<String> unidadMedida;
	private JComboBox<String> tipo;
	private JTextField contenido;
	private JPanel panelTabla;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel_1;
	private JButton btnNuevo;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JPanel panel;
	private JButton btnBuscar;
	private JButton btnLimpiar;
	private JLabel lblNewLabel_11;
	private JTextField precio;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PanelProductos() {
		setBorder(new EmptyBorder(15, 15, 15, 15));
		setBackground(new Color(28, 32, 57));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 200, 0 };
		gridBagLayout.rowHeights = new int[] { 396, 0 };
		gridBagLayout.columnWeights = new double[] { 10.0, 90.0 };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0 };
		setLayout(gridBagLayout);

		JPanel panelCaptura = new JPanel();
		panelCaptura.setBorder(new EmptyBorder(15, 15, 15, 15));
		panelCaptura.setBackground(new Color(38, 43, 73));
		GridBagConstraints gbc_panelCaptura = new GridBagConstraints();
		gbc_panelCaptura.insets = new Insets(0, 0, 5, 5);
		gbc_panelCaptura.fill = GridBagConstraints.BOTH;
		gbc_panelCaptura.gridx = 0;
		gbc_panelCaptura.gridy = 0;
		add(panelCaptura, gbc_panelCaptura);
		GridBagLayout gbl_panelCaptura = new GridBagLayout();
		gbl_panelCaptura.columnWidths = new int[] { 100, 130, 0 };
		gbl_panelCaptura.rowHeights = new int[] { 50, 50, 0, 50, 50, 50, 50, 50, 50, 50, 50, 50, 0 };
		gbl_panelCaptura.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panelCaptura.rowWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		panelCaptura.setLayout(gbl_panelCaptura);

		JLabel lblNewLabel = new JLabel("CODIGO BARRAS");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panelCaptura.add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Product Sans", Font.PLAIN, 16));

		codigoBarras = new JTextField();
		GridBagConstraints gbc_codigoBarras = new GridBagConstraints();
		gbc_codigoBarras.fill = GridBagConstraints.HORIZONTAL;
		gbc_codigoBarras.insets = new Insets(0, 0, 5, 0);
		gbc_codigoBarras.gridx = 1;
		gbc_codigoBarras.gridy = 0;
		panelCaptura.add(codigoBarras, gbc_codigoBarras);
		codigoBarras.setForeground(new Color(0, 0, 0));
		codigoBarras.setBackground(new Color(255, 255, 255));
		codigoBarras.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (codigoBarras.getText().length() >= 15) {
					evt.consume();
					nombre.requestFocus();
					btnBuscar.doClick();
				} else {
					if (Character.isDigit(c) || evt.getKeyChar() == KeyEvent.VK_ENTER
							|| evt.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
						if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
							nombre.requestFocus();
							btnBuscar.doClick();
						}
					} else {
						evt.consume();
						JOptionPane.showMessageDialog(null, "SOLO INTRODUCIR DIGITOS", "-ERROR-",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		codigoBarras.setFont(new Font("Product Sans", Font.PLAIN, 18));
		codigoBarras.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("NOMBRE");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panelCaptura.add(lblNewLabel_1, gbc_lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Product Sans", Font.PLAIN, 16));

		nombre = new JTextField();
		GridBagConstraints gbc_nombre = new GridBagConstraints();
		gbc_nombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombre.insets = new Insets(0, 0, 5, 0);
		gbc_nombre.gridx = 1;
		gbc_nombre.gridy = 1;
		panelCaptura.add(nombre, gbc_nombre);
		nombre.setForeground(new Color(0, 0, 0));
		nombre.setBackground(new Color(255, 255, 255));
		nombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					if (precio.isEnabled()) {
						precio.requestFocus();
					} else {
						marca.requestFocus();
					}
				}
			}
		});
		nombre.setFont(new Font("Product Sans", Font.PLAIN, 18));
		nombre.setColumns(10);

		lblNewLabel_11 = new JLabel("PRECIO");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("Product Sans", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 0;
		gbc_lblNewLabel_11.gridy = 2;
		panelCaptura.add(lblNewLabel_11, gbc_lblNewLabel_11);

		precio = new JTextField();
		precio.setForeground(Color.BLACK);
		precio.setFont(new Font("Product Sans", Font.PLAIN, 18));
		precio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					marca.requestFocus();
				}
			}
		});
		precio.setColumns(10);
		precio.setBackground(Color.WHITE);
		GridBagConstraints gbc_precio = new GridBagConstraints();
		gbc_precio.insets = new Insets(0, 0, 5, 0);
		gbc_precio.fill = GridBagConstraints.HORIZONTAL;
		gbc_precio.gridx = 1;
		gbc_precio.gridy = 2;
		panelCaptura.add(precio, gbc_precio);

		JLabel lblNewLabel_2 = new JLabel("MARCA");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		panelCaptura.add(lblNewLabel_2, gbc_lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Product Sans", Font.PLAIN, 16));

		marca = new JTextField();
		GridBagConstraints gbc_marca = new GridBagConstraints();
		gbc_marca.fill = GridBagConstraints.HORIZONTAL;
		gbc_marca.insets = new Insets(0, 0, 5, 0);
		gbc_marca.gridx = 1;
		gbc_marca.gridy = 3;
		panelCaptura.add(marca, gbc_marca);
		marca.setForeground(new Color(0, 0, 0));
		marca.setBackground(new Color(255, 255, 255));
		marca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					tipo.requestFocus();
				}
			}
		});
		marca.setFont(new Font("Product Sans", Font.PLAIN, 18));
		marca.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("TIPO");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		panelCaptura.add(lblNewLabel_3, gbc_lblNewLabel_3);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Product Sans", Font.PLAIN, 16));

		tipo = new JComboBox<String>();
		GridBagConstraints gbc_tipo = new GridBagConstraints();
		gbc_tipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tipo.insets = new Insets(0, 0, 5, 0);
		gbc_tipo.gridx = 1;
		gbc_tipo.gridy = 4;
		panelCaptura.add(tipo, gbc_tipo);
		tipo.setForeground(new Color(0, 0, 0));
		tipo.setBackground(new Color(255, 255, 255));
		tipo.setModel(new DefaultComboBoxModel(new String[] { "", "Higiene personal", "Medicamentos", "Limpieza",
				"Frituras", "Deportivos", "Embutidos", "Bebidas", "Vinos y Licores", "Dulceria", "Papeleria" }));
		tipo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					contenido.requestFocus();
				}
			}
		});
		tipo.setFont(new Font("Product Sans", Font.PLAIN, 18));

		JLabel lblNewLabel_4 = new JLabel("CONTENIDO");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		panelCaptura.add(lblNewLabel_4, gbc_lblNewLabel_4);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Product Sans", Font.PLAIN, 16));

		contenido = new JTextField();
		GridBagConstraints gbc_contenido = new GridBagConstraints();
		gbc_contenido.fill = GridBagConstraints.HORIZONTAL;
		gbc_contenido.insets = new Insets(0, 0, 5, 0);
		gbc_contenido.gridx = 1;
		gbc_contenido.gridy = 5;
		panelCaptura.add(contenido, gbc_contenido);
		contenido.setForeground(new Color(0, 0, 0));
		contenido.setBackground(new Color(255, 255, 255));
		contenido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					unidadMedida.requestFocus();
				}
			}
		});
		contenido.setFont(new Font("Product Sans", Font.PLAIN, 18));
		contenido.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("UNIDAD MEDIDA");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		panelCaptura.add(lblNewLabel_5, gbc_lblNewLabel_5);
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Product Sans", Font.PLAIN, 16));

		unidadMedida = new JComboBox<String>();
		GridBagConstraints gbc_unidadMedida = new GridBagConstraints();
		gbc_unidadMedida.fill = GridBagConstraints.HORIZONTAL;
		gbc_unidadMedida.insets = new Insets(0, 0, 5, 0);
		gbc_unidadMedida.gridx = 1;
		gbc_unidadMedida.gridy = 6;
		panelCaptura.add(unidadMedida, gbc_unidadMedida);
		unidadMedida.setForeground(new Color(0, 0, 0));
		unidadMedida.setBackground(new Color(255, 255, 255));
		unidadMedida.setModel(new DefaultComboBoxModel(
				new String[] { "", "l", "ml", "gr", "kgr", "mgr", "oz", "pzas", "m", "cm", "mm" }));
		unidadMedida.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					if (cantidad.isEnabled()) {
						cantidad.requestFocus();
					} else {
						stockMin.requestFocus();
					}
				}
			}
		});
		unidadMedida.setFont(new Font("Product Sans", Font.PLAIN, 18));

		JLabel lblNewLabel_6 = new JLabel("CANTIDAD");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		panelCaptura.add(lblNewLabel_6, gbc_lblNewLabel_6);
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Product Sans", Font.PLAIN, 16));

		cantidad = new JTextField();
		GridBagConstraints gbc_cantidad = new GridBagConstraints();
		gbc_cantidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_cantidad.insets = new Insets(0, 0, 5, 0);
		gbc_cantidad.gridx = 1;
		gbc_cantidad.gridy = 7;
		panelCaptura.add(cantidad, gbc_cantidad);
		cantidad.setForeground(new Color(0, 0, 0));
		cantidad.setBackground(new Color(255, 255, 255));
		cantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (Character.isDigit(c) || evt.getKeyChar() == KeyEvent.VK_ENTER
						|| evt.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
						stockMin.requestFocus();
					}
				} else {
					evt.consume();
					JOptionPane.showMessageDialog(null, "SOLO INTRODUCIR DIGITOS", "-ERROR-",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		cantidad.setFont(new Font("Product Sans", Font.PLAIN, 18));

		JLabel lblNewLabel_7 = new JLabel("STOCK MINIMO");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 8;
		panelCaptura.add(lblNewLabel_7, gbc_lblNewLabel_7);
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Product Sans", Font.PLAIN, 16));

		stockMin = new JTextField();
		GridBagConstraints gbc_stockMin = new GridBagConstraints();
		gbc_stockMin.fill = GridBagConstraints.HORIZONTAL;
		gbc_stockMin.insets = new Insets(0, 0, 5, 0);
		gbc_stockMin.gridx = 1;
		gbc_stockMin.gridy = 8;
		panelCaptura.add(stockMin, gbc_stockMin);
		stockMin.setForeground(new Color(0, 0, 0));
		stockMin.setBackground(new Color(255, 255, 255));
		stockMin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (Character.isDigit(c) || evt.getKeyChar() == KeyEvent.VK_ENTER
						|| evt.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
						stockMax.requestFocus();
					}
				} else {
					evt.consume();
					JOptionPane.showMessageDialog(null, "SOLO INTRODUCIR DIGITOS", "-ERROR-",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		stockMin.setFont(new Font("Product Sans", Font.PLAIN, 18));

		JLabel lblNewLabel_8 = new JLabel("STOCK MAXIMO");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 9;
		panelCaptura.add(lblNewLabel_8, gbc_lblNewLabel_8);
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Product Sans", Font.PLAIN, 16));

		stockMax = new JTextField();
		GridBagConstraints gbc_stockMax = new GridBagConstraints();
		gbc_stockMax.fill = GridBagConstraints.HORIZONTAL;
		gbc_stockMax.insets = new Insets(0, 0, 5, 0);
		gbc_stockMax.gridx = 1;
		gbc_stockMax.gridy = 9;
		panelCaptura.add(stockMax, gbc_stockMax);
		stockMax.setForeground(new Color(0, 0, 0));
		stockMax.setBackground(new Color(255, 255, 255));
		stockMax.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (Character.isDigit(c) || evt.getKeyChar() == KeyEvent.VK_ENTER
						|| evt.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
						presentacion.requestFocus();
					}
				} else {
					evt.consume();
					JOptionPane.showMessageDialog(null, "SOLO INTRODUCIR DIGITOS", "-ERROR-",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		stockMax.setFont(new Font("Product Sans", Font.PLAIN, 18));

		JLabel lblNewLabel_9 = new JLabel("PRESENTACION");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 10;
		panelCaptura.add(lblNewLabel_9, gbc_lblNewLabel_9);
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Product Sans", Font.PLAIN, 16));

		presentacion = new JComboBox<String>();
		GridBagConstraints gbc_presentacion = new GridBagConstraints();
		gbc_presentacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_presentacion.insets = new Insets(0, 0, 5, 0);
		gbc_presentacion.gridx = 1;
		gbc_presentacion.gridy = 10;
		panelCaptura.add(presentacion, gbc_presentacion);
		presentacion.setForeground(new Color(0, 0, 0));
		presentacion.setBackground(new Color(255, 255, 255));
		presentacion.setModel(new DefaultComboBoxModel(
				new String[] { "", "Caja", "Lata", "Botella Cristal", "Botella Plastico", "Cilindro", "Paquete",
						"Bolsa de Plastico", "Bolsa de Papel", "Emboltorio", "Barra", "Rollo" }));
		presentacion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					descripcion.requestFocus();
				}
			}
		});
		presentacion.setFont(new Font("Product Sans", Font.PLAIN, 18));

		JLabel lblNewLabel_10 = new JLabel("DESCRIPCION");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 11;
		panelCaptura.add(lblNewLabel_10, gbc_lblNewLabel_10);
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Product Sans", Font.PLAIN, 16));
		descripcion = new JTextField();
		GridBagConstraints gbc_descripcion = new GridBagConstraints();
		gbc_descripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_descripcion.gridx = 1;
		gbc_descripcion.gridy = 11;
		panelCaptura.add(descripcion, gbc_descripcion);
		descripcion.setForeground(new Color(0, 0, 0));
		descripcion.setBackground(new Color(255, 255, 255));
		descripcion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					btnBuscar.doClick();
					btnNuevo.doClick();
				}
			}
		});
		descripcion.setFont(new Font("Product Sans", Font.PLAIN, 18));
		descripcion.setColumns(10);

		panelTabla = new JPanel();
		panelTabla.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelTabla.setBackground(new Color(38, 43, 73));
		GridBagConstraints gbc_panelTabla = new GridBagConstraints();
		gbc_panelTabla.insets = new Insets(0, 0, 5, 0);
		gbc_panelTabla.fill = GridBagConstraints.BOTH;
		gbc_panelTabla.gridx = 1;
		gbc_panelTabla.gridy = 0;
		add(panelTabla, gbc_panelTabla);
		panelTabla.setLayout(new GridLayout(1, 1, 0, 0));

		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		panelTabla.add(scrollPane);

		table = new JTable();
		table.setSelectionForeground(new Color(255, 255, 255));
		table.setSelectionBackground(new Color(28, 32, 57));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setBorder(null);
		scrollPane.setViewportView(table);
		table.setRowHeight(30);
		table.setFont(new Font("Product Sans", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "C.BARRAS", "NOMBRE", "PRECIO", "MARCA",
				"TIPO", "CONTENIDO", "U.MEDIDA", "CANTIDAD", "PRESENTACION", "DESCRIPCION", "S.MAX", "S.MIN" }));
		DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
		headerRenderer.setBackground(new Color(28, 32, 57));
		headerRenderer.setHorizontalAlignment(JLabel.CENTER);
		headerRenderer.setForeground(Color.WHITE);
		table.getTableHeader().setDefaultRenderer(headerRenderer);
		table.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(80);
		table.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(60);
		table.getTableHeader().getColumnModel().getColumn(7).setPreferredWidth(70);
		table.getTableHeader().getColumnModel().getColumn(8).setPreferredWidth(100);
		table.getTableHeader().getColumnModel().getColumn(9).setPreferredWidth(130);
		table.getTableHeader().getColumnModel().getColumn(10).setPreferredWidth(40);
		table.getTableHeader().getColumnModel().getColumn(11).setPreferredWidth(40);
		table.getTableHeader().setReorderingAllowed(false);
		table.setDefaultEditor(Object.class, null);

		panel = new JPanel();
		panel.setBackground(new Color(28, 32, 57));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.WEST;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);

		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Product Sans", Font.BOLD, 18));
		btnBuscar.setBackground(new Color(244, 42, 87));
		panel.add(btnBuscar);

		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("Product Sans", Font.BOLD, 18));
		btnLimpiar.setBackground(new Color(244, 42, 87));
		panel.add(btnLimpiar);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(28, 32, 57));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.EAST;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);

		btnNuevo = new JButton("NUEVO");
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setFont(new Font("Product Sans", Font.BOLD, 18));
		btnNuevo.setEnabled(false);
		btnNuevo.setBackground(new Color(116, 84, 184));
		panel_1.add(btnNuevo);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("Product Sans", Font.BOLD, 18));
		btnModificar.setEnabled(false);
		btnModificar.setBackground(new Color(255, 128, 0));
		panel_1.add(btnModificar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Product Sans", Font.BOLD, 18));
		btnEliminar.setEnabled(false);
		btnEliminar.setBackground(Color.RED);
		panel_1.add(btnEliminar);
	}

	public JButton getBtnNuevo() {
		return btnNuevo;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public JTextField getCodigoBarras() {
		return codigoBarras;
	}

	public JTable getTable() {
		return table;
	}

	public void limpiarCampos() {
		codigoBarras.setText("");
		nombre.setText("");
		precio.setText("");
		marca.setText("");
		descripcion.setText("");
		presentacion.setSelectedIndex(0);
		stockMax.setText("");
		stockMin.setText("");
		cantidad.setText("");
		unidadMedida.setSelectedIndex(0);
		tipo.setSelectedIndex(0);
		contenido.setText("");
		codigoBarras.setEnabled(true);
		precio.setEnabled(true);
		cantidad.setEnabled(true);
		btnNuevo.setEnabled(false);
		btnModificar.setEnabled(false);
		btnEliminar.setEnabled(false);
		codigoBarras.requestFocus();
	}

	public boolean areEmpty() {
		return codigoBarras.getText().equalsIgnoreCase("") || nombre.getText().equalsIgnoreCase("")
				|| precio.getText().equalsIgnoreCase("") || marca.getText().equalsIgnoreCase("")
				|| descripcion.getText().equalsIgnoreCase("") || stockMax.getText().equalsIgnoreCase("")
				|| stockMin.getText().equalsIgnoreCase("") || cantidad.getText().equalsIgnoreCase("")
				|| contenido.getText().equalsIgnoreCase("") || tipo.getSelectedIndex() == 0
				|| unidadMedida.getSelectedIndex() == 0 || presentacion.getSelectedIndex() == 0;
	}

	public void buscarProducto(Catalogo<Producto> listaProductos) {
		String cBarras = codigoBarras.getText();
		if (!cBarras.equalsIgnoreCase("")) {
			if (listaProductos.contains(cBarras)) {
				Producto producto = listaProductos.getElementEach(cBarras);
				codigoBarras.setEnabled(false);
				cantidad.setEnabled(false);
				precio.setEnabled(false);
				nombre.setText(producto.getNombre());
				precio.setText("" + producto.getPrecio());
				marca.setText(producto.getMarca());
				descripcion.setText(producto.getDescripcion());
				presentacion.setSelectedItem(producto.getPresentacion());
				stockMax.setText(String.valueOf(producto.getStockMaximo()));
				stockMin.setText(String.valueOf(producto.getStockMinimo()));
				cantidad.setText("" + producto.getCantidad());
				unidadMedida.setSelectedItem(producto.getUnidadMedida());
				tipo.setSelectedItem(producto.getTipo());
				contenido.setText(String.valueOf(producto.getContenido()));
				getBtnNuevo().setEnabled(false);
				getBtnModificar().setEnabled(true);
				getBtnEliminar().setEnabled(true);
			} else {
				getBtnNuevo().setEnabled(true);
				getBtnModificar().setEnabled(false);
				getBtnEliminar().setEnabled(false);
			}
		} else {
			JOptionPane.showMessageDialog(null, "LLENE EL CAMPO");
			codigoBarras.requestFocus();
		}
	}

	public void registrarProducto(Catalogo<Producto> listaProductos) {
		if (!areEmpty()) {
			String cBarras = codigoBarras.getText();
			if (cBarras.length() < 15) {
				JOptionPane.showMessageDialog(null, "C.BARRAS DEBE SER IGUAL A 15 DIGITOS");
			} else {
				if (!listaProductos.contains(cBarras)) {
					Producto producto = new Producto();
					producto.setCodigoBarras(cBarras);
					producto.setNombre(nombre.getText());
					producto.setPrecio(Double.parseDouble(precio.getText()));
					producto.setMarca(marca.getText());
					producto.setDescripcion(descripcion.getText());
					producto.setPresentacion((String) presentacion.getSelectedItem());
					producto.setStockMaximo(Integer.parseInt(stockMax.getText()));
					producto.setStockMinimo(Integer.parseInt(stockMin.getText()));
					producto.setCantidad(Integer.parseInt(cantidad.getText()));
					producto.setUnidadMedida((String) unidadMedida.getSelectedItem());
					producto.setTipo((String) tipo.getSelectedItem());
					producto.setContenido(contenido.getText());
					listaProductos.add(producto);
					JOptionPane.showMessageDialog(null, "REGISTRADO CON EXITO");
					limpiarCampos();
					llenarTabla(listaProductos);
				} else {
					JOptionPane.showMessageDialog(null, "C.BARRAS YA REGISTRADO");
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS");
		}
	}

	public void modificarProducto(Catalogo<Producto> listaProductos) {
		if (!areEmpty()) {
			String cBarras = codigoBarras.getText();
			int i = listaProductos.getIndex(cBarras);
			Producto producto = new Producto();
			producto.setCodigoBarras(cBarras);
			producto.setNombre(nombre.getText());
			producto.setPrecio(Double.parseDouble(precio.getText()));
			producto.setMarca(marca.getText());
			producto.setDescripcion(descripcion.getText());
			producto.setPresentacion((String) presentacion.getSelectedItem());
			producto.setStockMaximo(Integer.parseInt(stockMax.getText()));
			producto.setStockMinimo(Integer.parseInt(stockMin.getText()));
			producto.setCantidad(Integer.parseInt(cantidad.getText()));
			producto.setUnidadMedida((String) unidadMedida.getSelectedItem());
			producto.setTipo((String) tipo.getSelectedItem());
			producto.setContenido(contenido.getText());
			listaProductos.modify(i, producto);
			JOptionPane.showMessageDialog(null, "MODIFICADO CON EXITO");
			limpiarCampos();
			llenarTabla(listaProductos);
		} else {
			JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS");
		}
	}

	public void eliminarProducto(Catalogo<Producto> listaProductos, Catalogo<Venta> listaVentas,
			Catalogo<Resurtido> listaResurtido) {
		String cBarras = codigoBarras.getText();
		if (!productoUsado(cBarras, listaVentas, listaResurtido)) {
			int i = listaProductos.getIndex(cBarras);
			listaProductos.remove(i);
			JOptionPane.showMessageDialog(null, "ELIMINADO CON EXITO");
			limpiarCampos();
			llenarTabla(listaProductos);
		} else {
			JOptionPane.showMessageDialog(null, "NO PUEDE ELIMINAR UN PRODUCTO EN USO");
		}
	}

	public void llenarTabla(Catalogo<Producto> listaProductos) {
		Object[] datos = new Object[table.getColumnCount()];
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);
		for (int i = 0; i < listaProductos.size(); i++) {
			Producto producto = new Producto();
			producto = listaProductos.getElement(i);
			datos[0] = producto.getCodigoBarras();
			datos[1] = producto.getNombre();
			datos[2] = producto.getPrecio();
			datos[3] = producto.getMarca();
			datos[4] = producto.getTipo();
			datos[5] = producto.getContenido();
			datos[6] = producto.getUnidadMedida();
			datos[7] = producto.getCantidad();
			datos[8] = producto.getPresentacion();
			datos[9] = producto.getDescripcion();
			datos[10] = producto.getStockMaximo();
			datos[11] = producto.getStockMinimo();
			modelo.addRow(datos);
		}
		codigoBarras.requestFocus();
	}

	public boolean productoUsado(String cBarras, Catalogo<Venta> listaVentas, Catalogo<Resurtido> listaResurtido) {
		for (int i = 0; i < listaVentas.size(); i++) {
			Venta venta = listaVentas.getElement(i);
			Catalogo<RenglonTicket> renglonesTicket = venta.getRenglonesTicket();
			for (int j = 0; j < renglonesTicket.size(); j++) {
				RenglonTicket renglonTicket = renglonesTicket.getElement(j);
				if (cBarras.equalsIgnoreCase(renglonTicket.getCodigoBarras())) {
					return true;
				}
			}
		}
		for (int i = 0; i < listaResurtido.size(); i++) {
			Resurtido resurtido = listaResurtido.getElement(i);
			Catalogo<RenglonResurtido> renglonesResurtido = resurtido.getRenglonesResurtidos();
			for (int j = 0; j < renglonesResurtido.size(); j++) {
				RenglonResurtido renglonResurtido = renglonesResurtido.getElement(j);
				if (cBarras.equalsIgnoreCase(renglonResurtido.getCodigoBarras())) {
					return true;
				}
			}
		}
		return false;
	}

}