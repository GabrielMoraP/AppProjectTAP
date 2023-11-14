package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import modelo.Catalogo;
import modelo.Producto;
import modelo.RenglonTicket;
import modelo.Venta;

public class PanelVenta extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField precio;
	private JTextField cantidad;
	private JTextField codigoBarras;
	private JTextField producto;
	private JTable table;
	private JTextField descripcion;
	private JTextField stock;
	private JButton btnBuscar;
	private JButton btnLimpiar;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnPagar;
	private JButton btnCancelar;
	private JLabel lblSubtotal;
	private JLabel lblIva;
	private JLabel lblTotal;

	public PanelVenta() {
		setBorder(new EmptyBorder(15, 15, 15, 15));
		setBackground(new Color(28, 32, 57));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 161 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 1.0, 80.0 };
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
		gbl_panelCaptura.columnWidths = new int[] { 150, 150, 150, 150, 0 };
		gbl_panelCaptura.rowHeights = new int[] { 0, 0, 0, 52, 0 };
		gbl_panelCaptura.columnWeights = new double[] { 1.0, 1.0, 25.0, 25.0, Double.MIN_VALUE };
		gbl_panelCaptura.rowWeights = new double[] { 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		panelCaptura.setLayout(gbl_panelCaptura);

		codigoBarras = new JTextField();
		codigoBarras.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "C.BARRAS",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		codigoBarras.setForeground(new Color(0, 0, 0));
		codigoBarras.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (codigoBarras.getText().length() >= 15) {
					evt.consume();
					cantidad.requestFocus();
					btnBuscar.doClick();
				} else {
					if (Character.isDigit(c) || evt.getKeyChar() == KeyEvent.VK_ENTER
							|| evt.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
						if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
							cantidad.requestFocus();
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
		codigoBarras.setFont(new Font("Product Sans", Font.PLAIN, 16));
		codigoBarras.setColumns(10);
		codigoBarras.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_codigoBarras = new GridBagConstraints();
		gbc_codigoBarras.fill = GridBagConstraints.HORIZONTAL;
		gbc_codigoBarras.gridwidth = 2;
		gbc_codigoBarras.insets = new Insets(0, 0, 5, 5);
		gbc_codigoBarras.gridx = 0;
		gbc_codigoBarras.gridy = 0;
		panelCaptura.add(codigoBarras, gbc_codigoBarras);

		precio = new JTextField();
		precio.setEditable(false);
		precio.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "PRECIO",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 255, 255)));
		precio.setForeground(new Color(255, 255, 255));
		precio.setFont(new Font("Product Sans", Font.PLAIN, 16));
		precio.setColumns(10);
		precio.setBackground(new Color(38, 43, 73));
		GridBagConstraints gbc_precio = new GridBagConstraints();
		gbc_precio.fill = GridBagConstraints.HORIZONTAL;
		gbc_precio.gridwidth = 2;
		gbc_precio.insets = new Insets(0, 0, 5, 0);
		gbc_precio.gridx = 2;
		gbc_precio.gridy = 0;
		panelCaptura.add(precio, gbc_precio);

		producto = new JTextField();
		producto.setEditable(false);
		producto.setBorder(new TitledBorder(null, "PRODUCTO", TitledBorder.LEFT, TitledBorder.TOP, null,
				new Color(255, 255, 255)));
		producto.setForeground(new Color(255, 255, 255));
		producto.setFont(new Font("Product Sans", Font.PLAIN, 16));
		producto.setColumns(10);
		producto.setBackground(new Color(38, 43, 73));
		GridBagConstraints gbc_producto = new GridBagConstraints();
		gbc_producto.fill = GridBagConstraints.HORIZONTAL;
		gbc_producto.gridwidth = 2;
		gbc_producto.insets = new Insets(0, 0, 5, 5);
		gbc_producto.gridx = 0;
		gbc_producto.gridy = 1;
		panelCaptura.add(producto, gbc_producto);

		cantidad = new JTextField();
		cantidad.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "CANTIDAD",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		cantidad.setForeground(new Color(0, 0, 0));
		cantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (Character.isDigit(c) || evt.getKeyChar() == KeyEvent.VK_ENTER
						|| evt.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
						btnAgregar.doClick();
					}
				} else {
					evt.consume();
					JOptionPane.showMessageDialog(null, "SOLO INTRODUCIR DIGITOS", "-ERROR-",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		cantidad.setFont(new Font("Product Sans", Font.PLAIN, 16));
		cantidad.setColumns(10);
		cantidad.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_cantidad = new GridBagConstraints();
		gbc_cantidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_cantidad.gridwidth = 2;
		gbc_cantidad.insets = new Insets(0, 0, 5, 0);
		gbc_cantidad.gridx = 2;
		gbc_cantidad.gridy = 1;
		panelCaptura.add(cantidad, gbc_cantidad);

		descripcion = new JTextField();
		descripcion.setForeground(Color.WHITE);
		descripcion.setFont(new Font("Product Sans", Font.PLAIN, 16));
		descripcion.setEditable(false);
		descripcion.setColumns(10);
		descripcion.setBorder(new TitledBorder(null, "DESCRIPCION", TitledBorder.LEFT, TitledBorder.TOP, null,
				new Color(255, 255, 255)));
		descripcion.setBackground(new Color(38, 43, 73));
		GridBagConstraints gbc_descripcion = new GridBagConstraints();
		gbc_descripcion.gridwidth = 2;
		gbc_descripcion.insets = new Insets(0, 0, 5, 5);
		gbc_descripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_descripcion.gridx = 0;
		gbc_descripcion.gridy = 2;
		panelCaptura.add(descripcion, gbc_descripcion);

		stock = new JTextField();
		stock.setForeground(Color.WHITE);
		stock.setFont(new Font("Product Sans", Font.PLAIN, 16));
		stock.setEditable(false);
		stock.setColumns(10);
		stock.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "STOCK",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 255, 255)));
		stock.setBackground(new Color(38, 43, 73));
		GridBagConstraints gbc_stock = new GridBagConstraints();
		gbc_stock.gridwidth = 2;
		gbc_stock.insets = new Insets(0, 0, 0, 5);
		gbc_stock.fill = GridBagConstraints.HORIZONTAL;
		gbc_stock.gridx = 0;
		gbc_stock.gridy = 3;
		panelCaptura.add(stock, gbc_stock);

		JPanel panelBtnProducto = new JPanel();
		panelBtnProducto.setBackground(new Color(38, 43, 73));
		GridBagConstraints gbc_panelBtnProducto = new GridBagConstraints();
		gbc_panelBtnProducto.gridheight = 2;
		gbc_panelBtnProducto.gridwidth = 2;
		gbc_panelBtnProducto.fill = GridBagConstraints.BOTH;
		gbc_panelBtnProducto.gridx = 2;
		gbc_panelBtnProducto.gridy = 2;
		panelCaptura.add(panelBtnProducto, gbc_panelBtnProducto);
		GridBagLayout gbl_panelBtnProducto = new GridBagLayout();
		gbl_panelBtnProducto.columnWidths = new int[] { 166, 166, 0 };
		gbl_panelBtnProducto.rowHeights = new int[] { 64, 0 };
		gbl_panelBtnProducto.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panelBtnProducto.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panelBtnProducto.setLayout(gbl_panelBtnProducto);

		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Product Sans", Font.BOLD, 18));
		btnBuscar.setBackground(new Color(244, 42, 87));
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.anchor = GridBagConstraints.EAST;
		gbc_btnBuscar.insets = new Insets(0, 0, 0, 5);
		gbc_btnBuscar.gridx = 0;
		gbc_btnBuscar.gridy = 0;
		panelBtnProducto.add(btnBuscar, gbc_btnBuscar);

		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("Product Sans", Font.BOLD, 18));
		btnLimpiar.setBackground(new Color(244, 42, 87));
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.anchor = GridBagConstraints.WEST;
		gbc_btnLimpiar.gridx = 1;
		gbc_btnLimpiar.gridy = 0;
		panelBtnProducto.add(btnLimpiar, gbc_btnLimpiar);

		JPanel panelBtnVenta = new JPanel();
		panelBtnVenta.setBorder(new EmptyBorder(15, 100, 15, 100));
		panelBtnVenta.setBackground(new Color(28, 32, 57));
		GridBagConstraints gbc_panelBtnVenta = new GridBagConstraints();
		gbc_panelBtnVenta.insets = new Insets(0, 0, 5, 0);
		gbc_panelBtnVenta.fill = GridBagConstraints.BOTH;
		gbc_panelBtnVenta.gridx = 1;
		gbc_panelBtnVenta.gridy = 0;
		add(panelBtnVenta, gbc_panelBtnVenta);
		GridBagLayout gbl_panelBtnVenta = new GridBagLayout();
		gbl_panelBtnVenta.columnWidths = new int[] { 271, 0 };
		gbl_panelBtnVenta.rowHeights = new int[] { 50, 50, 50, 0 };
		gbl_panelBtnVenta.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panelBtnVenta.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		panelBtnVenta.setLayout(gbl_panelBtnVenta);

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setEnabled(false);
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setFont(new Font("Product Sans", Font.BOLD, 24));
		btnAgregar.setBackground(new Color(13, 165, 144));
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.fill = GridBagConstraints.BOTH;
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAgregar.gridx = 0;
		gbc_btnAgregar.gridy = 0;
		panelBtnVenta.add(btnAgregar, gbc_btnAgregar);

		btnEliminar = new JButton("ELIMINAR RENGLON");
		btnEliminar.setEnabled(false);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Product Sans", Font.BOLD, 24));
		btnEliminar.setBackground(Color.RED);
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.fill = GridBagConstraints.BOTH;
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 0);
		gbc_btnEliminar.gridx = 0;
		gbc_btnEliminar.gridy = 1;
		panelBtnVenta.add(btnEliminar, gbc_btnEliminar);

		btnPagar = new JButton("PAGAR");
		btnPagar.setEnabled(false);
		btnPagar.setForeground(Color.WHITE);
		btnPagar.setFont(new Font("Product Sans", Font.BOLD, 24));
		btnPagar.setBackground(new Color(28, 182, 247));
		GridBagConstraints gbc_btnPagar = new GridBagConstraints();
		gbc_btnPagar.fill = GridBagConstraints.BOTH;
		gbc_btnPagar.gridx = 0;
		gbc_btnPagar.gridy = 2;
		panelBtnVenta.add(btnPagar, gbc_btnPagar);

		JPanel panelTabla = new JPanel();
		panelTabla.setBorder(new EmptyBorder(15, 15, 15, 5));
		panelTabla.setBackground(new Color(38, 43, 73));
		GridBagConstraints gbc_panelTabla = new GridBagConstraints();
		gbc_panelTabla.insets = new Insets(0, 0, 0, 5);
		gbc_panelTabla.fill = GridBagConstraints.BOTH;
		gbc_panelTabla.gridx = 0;
		gbc_panelTabla.gridy = 1;
		add(panelTabla, gbc_panelTabla);
		panelTabla.setLayout(new GridLayout(1, 1, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		panelTabla.add(scrollPane);

		table = new JTable();
		table.setSelectionForeground(new Color(255, 255, 255));
		table.setSelectionBackground(new Color(28, 32, 57));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setBorder(null);
		scrollPane.setViewportView(table);
		table.setRowHeight(30);
		table.setFont(new Font("Product Sans", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "C.BARRAS", "PRODUCTO", "PRECIO UNITARIO", "CANTIDAD", "IMPORTE" }));
		DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
		headerRenderer.setBackground(new Color(28, 32, 57));
		headerRenderer.setHorizontalAlignment(JLabel.CENTER);
		headerRenderer.setForeground(Color.WHITE);
		table.getTableHeader().setDefaultRenderer(headerRenderer);
		table.setDefaultEditor(Object.class, null);
		table.setEditingColumn(0);
		table.getTableHeader().setReorderingAllowed(false);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					int rowIndex = table.getSelectedRow();
					if (rowIndex >= 0) {
						btnEliminar.setEnabled(true);
					}
				}
			}
		});

		JPanel panelCostos = new JPanel();
		panelCostos.setBorder(new EmptyBorder(15, 15, 15, 15));
		panelCostos.setBackground(new Color(38, 43, 73));
		GridBagConstraints gbc_panelCostos = new GridBagConstraints();
		gbc_panelCostos.fill = GridBagConstraints.BOTH;
		gbc_panelCostos.gridx = 1;
		gbc_panelCostos.gridy = 1;
		add(panelCostos, gbc_panelCostos);
		GridBagLayout gbl_panelCostos = new GridBagLayout();
		gbl_panelCostos.columnWidths = new int[] { 0, 0 };
		gbl_panelCostos.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panelCostos.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panelCostos.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		panelCostos.setLayout(gbl_panelCostos);

		JPanel panelSubtotal = new JPanel();
		panelSubtotal.setBorder(new EmptyBorder(0, 15, 0, 15));
		panelSubtotal.setBackground(new Color(116, 84, 184));
		GridBagConstraints gbc_panelSubtotal = new GridBagConstraints();
		gbc_panelSubtotal.insets = new Insets(0, 0, 5, 0);
		gbc_panelSubtotal.fill = GridBagConstraints.BOTH;
		gbc_panelSubtotal.gridx = 0;
		gbc_panelSubtotal.gridy = 0;
		panelCostos.add(panelSubtotal, gbc_panelSubtotal);
		panelSubtotal.setLayout(new GridLayout(2, 1, 0, 0));

		JLabel lbl1 = new JLabel("SUBTOTAL");
		lbl1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl1.setForeground(Color.WHITE);
		lbl1.setFont(new Font("Product Sans", Font.BOLD, 30));
		panelSubtotal.add(lbl1);

		lblSubtotal = new JLabel("$00.00");
		lblSubtotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubtotal.setForeground(Color.WHITE);
		lblSubtotal.setFont(new Font("Product Sans", Font.BOLD, 30));
		panelSubtotal.add(lblSubtotal);

		JPanel panelStock_1 = new JPanel();
		panelStock_1.setBorder(new EmptyBorder(0, 15, 0, 15));
		panelStock_1.setBackground(new Color(244, 42, 87));
		GridBagConstraints gbc_panelStock_1 = new GridBagConstraints();
		gbc_panelStock_1.insets = new Insets(0, 0, 5, 0);
		gbc_panelStock_1.fill = GridBagConstraints.BOTH;
		gbc_panelStock_1.gridx = 0;
		gbc_panelStock_1.gridy = 1;
		panelCostos.add(panelStock_1, gbc_panelStock_1);
		panelStock_1.setLayout(new GridLayout(2, 1, 0, 0));

		JLabel lbl2 = new JLabel("IVA");
		lbl2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl2.setForeground(Color.WHITE);
		lbl2.setFont(new Font("Product Sans", Font.BOLD, 30));
		panelStock_1.add(lbl2);

		lblIva = new JLabel("$00.00");
		lblIva.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIva.setForeground(Color.WHITE);
		lblIva.setFont(new Font("Product Sans", Font.BOLD, 30));
		panelStock_1.add(lblIva);

		JPanel panelStock_1_1 = new JPanel();
		panelStock_1_1.setBorder(new EmptyBorder(0, 15, 0, 15));
		panelStock_1_1.setBackground(new Color(28, 182, 247));
		GridBagConstraints gbc_panelStock_1_1 = new GridBagConstraints();
		gbc_panelStock_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_panelStock_1_1.fill = GridBagConstraints.BOTH;
		gbc_panelStock_1_1.gridx = 0;
		gbc_panelStock_1_1.gridy = 2;
		panelCostos.add(panelStock_1_1, gbc_panelStock_1_1);
		panelStock_1_1.setLayout(new GridLayout(2, 1, 0, 0));

		JLabel lbl3 = new JLabel("TOTAL");
		lbl3.setHorizontalAlignment(SwingConstants.LEFT);
		lbl3.setForeground(Color.WHITE);
		lbl3.setFont(new Font("Product Sans", Font.BOLD, 30));
		panelStock_1_1.add(lbl3);

		lblTotal = new JLabel("$00.00");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("Product Sans", Font.BOLD, 30));
		panelStock_1_1.add(lblTotal);

		btnCancelar = new JButton("CANCELAR VENTA");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Product Sans", Font.BOLD, 24));
		btnCancelar.setBackground(new Color(255, 0, 0));
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.EAST;
		gbc_btnCancelar.fill = GridBagConstraints.VERTICAL;
		gbc_btnCancelar.gridx = 0;
		gbc_btnCancelar.gridy = 3;
		panelCostos.add(btnCancelar, gbc_btnCancelar);
	}

	public JTextField getCodigoBarras() {
		return codigoBarras;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JButton getBtnPagar() {
		return btnPagar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public boolean areEmpty() {
		return codigoBarras.getText().equalsIgnoreCase("") || producto.getText().equalsIgnoreCase("")
				|| descripcion.getText().equalsIgnoreCase("") || stock.getText().equalsIgnoreCase("")
				|| precio.getText().equalsIgnoreCase("") || cantidad.getText().equalsIgnoreCase("");
	}

	public void buscarProducto(Catalogo<Producto> listaProductos) {
		String cBarras = codigoBarras.getText();
		if (listaProductos.contains(cBarras)) {
			Producto productoBuscado = listaProductos.getElementEach(cBarras);
			codigoBarras.setEnabled(false);
			producto.setText(productoBuscado.getNombre());
			descripcion.setText(productoBuscado.getDescripcion());
			stock.setText("" + productoBuscado.getCantidad());
			precio.setText("" + productoBuscado.getPrecio());
			btnAgregar.setEnabled(true);
		} else {
			JOptionPane.showMessageDialog(null, "EL PRODUCTO NO EXISTE");
			codigoBarras.requestFocus();
		}
	}

	public void limpiarCampos() {
		codigoBarras.setText("");
		producto.setText("");
		descripcion.setText("");
		stock.setText("");
		precio.setText("");
		cantidad.setText("");
		codigoBarras.setEnabled(true);
		btnAgregar.setEnabled(false);
		codigoBarras.requestFocus();
	}

	public void agregarVenta() {
		if (!areEmpty()) {
			int cantidadVender = Integer.parseInt(cantidad.getText());
			if(Integer.parseInt(cantidad.getText())>0) {
				int stockProducto = Integer.parseInt(stock.getText());
				if (cantidadVender > stockProducto) {
					JOptionPane.showMessageDialog(null, "STOCK INSUFICIENTE");
				} else {
					Object[] datos = new Object[table.getColumnCount()];
					DefaultTableModel modelo = (DefaultTableModel) table.getModel();
					datos[0] = codigoBarras.getText();
					datos[1] = producto.getText();
					datos[2] = precio.getText();
					datos[3] = cantidad.getText();
					double importe = Double.parseDouble(cantidad.getText()) * Double.parseDouble(precio.getText());
					datos[4] = importe;
					modelo.addRow(datos);
					limpiarCampos();
					calcularTotal();
					btnPagar.setEnabled(true);
					btnEliminar.setEnabled(false);
					codigoBarras.requestFocus();
				}
			}else {
				JOptionPane.showMessageDialog(null, "CANTIDAD ERRONEA");
				cantidad.requestFocus();
			}
		} else {
			JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS");
		}
	}

	public void eliminarVenta() {
		int rowIndex = table.getSelectedRow();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.removeRow(rowIndex);
		if (table.getRowCount() == 0) {
			btnPagar.setEnabled(false);
			codigoBarras.requestFocus();
		}
		btnEliminar.setEnabled(false);
		calcularTotal();
	}

	public void vender(Catalogo<Venta> listaVentas, Catalogo<Producto> listaProducto) {
		Catalogo<RenglonTicket> listaRenglonesTicket = new Catalogo<RenglonTicket>();
		double subTotal = 0.0;
		double iva = 0.0;
		double total = 0;
		for (int i = 0; i < table.getRowCount(); i++) {
			RenglonTicket renglon = new RenglonTicket();
			renglon.setId("" + listaRenglonesTicket.size());
			Object cBarras = table.getValueAt(i, 0);
			Object producto = table.getValueAt(i, 1);
			Object precioUnitario = table.getValueAt(i, 2);
			Object cantidadProductos = table.getValueAt(i, 3);
			Object importe = table.getValueAt(i, 4);
			String codigoBarras = cBarras.toString();
			Producto productoBuscado = listaProducto.getElementEach(codigoBarras);
			int cantidad = Integer.parseInt(cantidadProductos.toString());
			int cantidadProducto = productoBuscado.getCantidad();
			int cantidadNueva = cantidadProducto - cantidad;
			subTotal += Double.parseDouble(importe.toString());
			productoBuscado.setCantidad(cantidadNueva);
			listaProducto.modify(listaProducto.getIndex(codigoBarras), productoBuscado);
			renglon.setCodigoBarras(codigoBarras);
			renglon.setProducto(producto.toString());
			renglon.setPrecioUnitario(Double.parseDouble(precioUnitario.toString()));
			renglon.setCantidad(Integer.parseInt(cantidadProductos.toString()));
			renglon.setImporte(Double.parseDouble(importe.toString()));
			listaRenglonesTicket.add(renglon);
		}
		Venta venta = new Venta();
		venta.setFolio("" + listaVentas.size());
		venta.setFecha(LocalDate.now());
		venta.setHora(LocalTime.now());
		venta.setRenglonesTicket(listaRenglonesTicket);
		iva += subTotal * 0.16;
		total = subTotal + iva;
		venta.setTotal(total);
		listaVentas.add(venta);
		Double dineroRecibido = Double.parseDouble(JOptionPane.showInputDialog(null, "DINERO RECIBIDO"));
		Double cambio = dineroRecibido - total;
		JOptionPane.showMessageDialog(null, "!VENTA REALIZADA! \n" + "SU CAMBIO ES $" + cambio);
		limpiarCampos();
		btnAgregar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnPagar.setEnabled(false);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		lblSubtotal.setText("$00.00");
		lblIva.setText("$00.00");
		lblTotal.setText("$00.00");
	}

	public void cancelarVenta() {
		limpiarCampos();
		btnAgregar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnPagar.setEnabled(false);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		lblSubtotal.setText("$00.00");
		lblIva.setText("$00.00");
		lblTotal.setText("$00.00");
	}

	public void calcularTotal() {
		double subTotal = 0.0;
		double iva = 0.0;
		double total = 0.0;
		for (int i = 0; i < table.getRowCount(); i++) {
			Object importe = table.getValueAt(i, 4);
			subTotal += Double.parseDouble(importe.toString());
		}
		iva += subTotal * 0.16;
		total = subTotal + iva;
		lblSubtotal.setText("$" + subTotal);
		lblIva.setText("$" + iva);
		lblTotal.setText("$" + total);
	}

}
