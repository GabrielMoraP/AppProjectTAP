package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
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

import com.toedter.calendar.JDateChooser;

import modelo.Catalogo;
import modelo.Producto;
import modelo.RenglonResurtido;
import modelo.Resurtido;

public class PanelResurtir extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField telefono;
	private JTextField codigoBarras;
	private JTextField descripcion;
	private JTable table;
	private JTextField cantidad;
	private JTextField precio;
	private JTextField provedor;
	private JDateChooser fecha;
	private JButton btnBuscar;
	private JButton btnLimpiar;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnResurtir;
	private JScrollPane scrollPane;
	private JButton btnCancelar;
	private JLabel lblProductos;
	private JLabel lblTotal;

	public PanelResurtir() {
		setBorder(new EmptyBorder(15, 15, 15, 15));
		setBackground(new Color(28, 32, 57));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 161 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 20.0, 80.0 };
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
		gbl_panelCaptura.rowHeights = new int[] { 0, 0, 52, 0, 0 };
		gbl_panelCaptura.columnWeights = new double[] { 1.0, 25.0, 1.0, 25.0, Double.MIN_VALUE };
		gbl_panelCaptura.rowWeights = new double[] { 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
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

		fecha = new JDateChooser();
		fecha.setForeground(Color.WHITE);
		fecha.setFont(new Font("Product Sans", Font.PLAIN, 16));
		fecha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					provedor.requestFocus();
				}
			}
		});
		fecha.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"FECHA CADUCIDAD", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 255, 255)));
		fecha.setBackground(new Color(38, 43, 73));
		GridBagConstraints gbc_fecha = new GridBagConstraints();
		gbc_fecha.gridwidth = 2;
		gbc_fecha.insets = new Insets(0, 0, 5, 5);
		gbc_fecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_fecha.gridx = 2;
		gbc_fecha.gridy = 0;
		panelCaptura.add(fecha, gbc_fecha);

		descripcion = new JTextField();
		descripcion.setEditable(false);
		descripcion.setForeground(new Color(255, 255, 255));
		descripcion.setFont(new Font("Product Sans", Font.PLAIN, 16));
		descripcion.setColumns(10);
		descripcion.setBorder(new TitledBorder(null, "DESCRIPCION", TitledBorder.LEFT, TitledBorder.TOP, null,
				new Color(255, 255, 255)));
		descripcion.setBackground(new Color(38, 43, 73));
		GridBagConstraints gbc_descripcion = new GridBagConstraints();
		gbc_descripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_descripcion.gridwidth = 2;
		gbc_descripcion.insets = new Insets(0, 0, 5, 5);
		gbc_descripcion.gridx = 0;
		gbc_descripcion.gridy = 1;
		panelCaptura.add(descripcion, gbc_descripcion);

		provedor = new JTextField();
		provedor.setForeground(new Color(0, 0, 0));
		provedor.setFont(new Font("Product Sans", Font.PLAIN, 16));
		provedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					telefono.requestFocus();
				}
			}
		});
		provedor.setColumns(10);
		provedor.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "PROVEDOR",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		provedor.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_provedor = new GridBagConstraints();
		gbc_provedor.gridwidth = 2;
		gbc_provedor.insets = new Insets(0, 0, 5, 0);
		gbc_provedor.fill = GridBagConstraints.HORIZONTAL;
		gbc_provedor.gridx = 2;
		gbc_provedor.gridy = 1;
		panelCaptura.add(provedor, gbc_provedor);

		cantidad = new JTextField();
		cantidad.setForeground(new Color(0, 0, 0));
		cantidad.setFont(new Font("Product Sans", Font.PLAIN, 16));
		cantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (Character.isDigit(c) || evt.getKeyChar() == KeyEvent.VK_ENTER
						|| evt.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
						precio.requestFocus();
					}
				} else {
					evt.consume();
					JOptionPane.showMessageDialog(null, "SOLO INTRODUCIR DIGITOS", "-ERROR-",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		cantidad.setColumns(10);
		cantidad.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "CANTIDAD",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		cantidad.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_cantidad = new GridBagConstraints();
		gbc_cantidad.gridwidth = 2;
		gbc_cantidad.insets = new Insets(0, 0, 5, 5);
		gbc_cantidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_cantidad.gridx = 0;
		gbc_cantidad.gridy = 2;
		panelCaptura.add(cantidad, gbc_cantidad);

		telefono = new JTextField();
		telefono.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"TELEFONO PROVEEDOR", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		telefono.setForeground(new Color(0, 0, 0));
		telefono.setFont(new Font("Product Sans", Font.PLAIN, 16));
		telefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					btnAgregar.doClick();
				}
			}
		});
		telefono.setColumns(10);
		telefono.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_telefono = new GridBagConstraints();
		gbc_telefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_telefono.gridwidth = 2;
		gbc_telefono.insets = new Insets(0, 0, 5, 0);
		gbc_telefono.gridx = 2;
		gbc_telefono.gridy = 2;
		panelCaptura.add(telefono, gbc_telefono);

		precio = new JTextField();
		precio.setForeground(new Color(0, 0, 0));
		precio.setFont(new Font("Product Sans", Font.PLAIN, 16));
		precio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					fecha.requestFocus();
				}
			}
		});
		precio.setColumns(10);
		precio.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "PRECIO",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		precio.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_precio = new GridBagConstraints();
		gbc_precio.gridwidth = 2;
		gbc_precio.insets = new Insets(0, 0, 0, 5);
		gbc_precio.fill = GridBagConstraints.HORIZONTAL;
		gbc_precio.gridx = 0;
		gbc_precio.gridy = 3;
		panelCaptura.add(precio, gbc_precio);

		JPanel panelBtnProducto = new JPanel();
		panelBtnProducto.setBackground(new Color(38, 43, 73));
		GridBagConstraints gbc_panelBtnProducto = new GridBagConstraints();
		gbc_panelBtnProducto.gridwidth = 2;
		gbc_panelBtnProducto.fill = GridBagConstraints.BOTH;
		gbc_panelBtnProducto.gridx = 2;
		gbc_panelBtnProducto.gridy = 3;
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
		btnAgregar.setBackground(new Color(13, 165, 144));
		btnAgregar.setForeground(new Color(255, 255, 255));
		btnAgregar.setFont(new Font("Product Sans", Font.BOLD, 24));
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.fill = GridBagConstraints.BOTH;
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAgregar.gridx = 0;
		gbc_btnAgregar.gridy = 0;
		panelBtnVenta.add(btnAgregar, gbc_btnAgregar);

		btnEliminar = new JButton("ELIMINAR RENGLON");
		btnEliminar.setEnabled(false);
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setBackground(new Color(255, 0, 0));
		btnEliminar.setFont(new Font("Product Sans", Font.BOLD, 24));
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 0);
		gbc_btnEliminar.fill = GridBagConstraints.BOTH;
		gbc_btnEliminar.gridx = 0;
		gbc_btnEliminar.gridy = 1;
		panelBtnVenta.add(btnEliminar, gbc_btnEliminar);

		btnResurtir = new JButton("RESURTIR");
		btnResurtir.setEnabled(false);
		btnResurtir.setForeground(Color.WHITE);
		btnResurtir.setFont(new Font("Product Sans", Font.BOLD, 24));
		btnResurtir.setBackground(new Color(28, 182, 247));
		GridBagConstraints gbc_btnResurtir = new GridBagConstraints();
		gbc_btnResurtir.fill = GridBagConstraints.BOTH;
		gbc_btnResurtir.gridx = 0;
		gbc_btnResurtir.gridy = 2;
		panelBtnVenta.add(btnResurtir, gbc_btnResurtir);

		JPanel panelTabla = new JPanel();
		panelTabla.setBorder(new EmptyBorder(15, 15, 15, 15));
		panelTabla.setBackground(new Color(38, 43, 73));
		GridBagConstraints gbc_panelTabla = new GridBagConstraints();
		gbc_panelTabla.insets = new Insets(0, 0, 0, 5);
		gbc_panelTabla.fill = GridBagConstraints.BOTH;
		gbc_panelTabla.gridx = 0;
		gbc_panelTabla.gridy = 1;
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
		table.setFont(new Font("Product Sans", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "C.BARRAS", "CANTIDAD", "PRECIO", "F.CADUCIDAD", "PROVEDOR", "TELEFONO", "IMPORTE" }));
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
		gbl_panelCostos.rowHeights = new int[] { 0, 0, 0 };
		gbl_panelCostos.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panelCostos.rowWeights = new double[] { 1.0, 1.0, 1.0 };
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

		JLabel lbl1 = new JLabel("PRODUCTOS");
		lbl1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl1.setForeground(Color.WHITE);
		lbl1.setFont(new Font("Product Sans", Font.BOLD, 30));
		panelSubtotal.add(lbl1);

		lblProductos = new JLabel("00");
		lblProductos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProductos.setForeground(Color.WHITE);
		lblProductos.setFont(new Font("Product Sans", Font.BOLD, 30));
		panelSubtotal.add(lblProductos);

		JPanel panelStock_1_1 = new JPanel();
		panelStock_1_1.setBorder(new EmptyBorder(0, 15, 0, 15));
		panelStock_1_1.setBackground(new Color(28, 182, 247));
		GridBagConstraints gbc_panelStock_1_1 = new GridBagConstraints();
		gbc_panelStock_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_panelStock_1_1.fill = GridBagConstraints.BOTH;
		gbc_panelStock_1_1.gridx = 0;
		gbc_panelStock_1_1.gridy = 1;
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

		btnCancelar = new JButton("CANCELAR RESURTIDO");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Product Sans", Font.BOLD, 24));
		btnCancelar.setBackground(new Color(255, 0, 0));
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 0);
		gbc_btnCancelar.anchor = GridBagConstraints.EAST;
		gbc_btnCancelar.fill = GridBagConstraints.VERTICAL;
		gbc_btnCancelar.gridx = 0;
		gbc_btnCancelar.gridy = 2;
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

	public JButton getBtnResurtir() {
		return btnResurtir;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public boolean areEmpty() {
		return codigoBarras.getText().equalsIgnoreCase("") || cantidad.getText().equalsIgnoreCase("")
				|| precio.getText().equalsIgnoreCase("") || fecha.getDateFormatString().equalsIgnoreCase("")
				|| provedor.getText().equalsIgnoreCase("") || telefono.getText().equalsIgnoreCase("");
	}

	public void buscarProducto(Catalogo<Producto> listaProductos) {
		String cBarras = codigoBarras.getText();
		if (listaProductos.contains(cBarras)) {
			Producto producto = listaProductos.getElementEach(cBarras);
			codigoBarras.setEnabled(false);
			descripcion.setText(producto.getDescripcion());
			btnAgregar.setEnabled(true);
		} else {
			JOptionPane.showMessageDialog(null, "EL PRODUCTO NO EXISTE");
			codigoBarras.requestFocus();
		}
	}

	public void limpiarCampos() {
		codigoBarras.setText("");
		descripcion.setText("");
		cantidad.setText("");
		precio.setText("");
		fecha.setDate(null);
		provedor.setText("");
		telefono.setText("");
		codigoBarras.setEnabled(true);
		btnAgregar.setEnabled(false);
		codigoBarras.requestFocus();
	}

	public void agregarResurtido(Catalogo<Producto> listaProducto) {
		if (!areEmpty()) {
			if(Integer.parseInt(cantidad.getText())>0) {
				Producto producto = listaProducto.getElementEach(codigoBarras.getText());
				int cantidadTotal = Integer.parseInt(cantidad.getText()) + producto.getCantidad();
				if(cantidadTotal<=producto.getStockMaximo()) {
					Object[] datos = new Object[table.getColumnCount()];
					DefaultTableModel modelo = (DefaultTableModel) table.getModel();
					datos[0] = codigoBarras.getText();
					datos[1] = cantidad.getText();
					datos[2] = precio.getText();
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					String strDate = dateFormat.format(fecha.getDate());
					datos[3] = strDate;
					datos[4] = provedor.getText();
					datos[5] = telefono.getText();
					double importe = Double.parseDouble(cantidad.getText()) * Double.parseDouble(precio.getText());
					datos[6] = importe;
					modelo.addRow(datos);
					limpiarCampos();
					calcularTotal();
					btnResurtir.setEnabled(true);
					btnEliminar.setEnabled(false);
					codigoBarras.requestFocus();
				}else {
					JOptionPane.showMessageDialog(null, "CANTIDAD SUPERA EL STOCK MAXIMO");
					cantidad.requestFocus();
				}
			}else {
				JOptionPane.showMessageDialog(null, "CANTIDAD ERRONEA");
				cantidad.requestFocus();
			}
		} else {
			JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS");
		}
	}

	public void eliminarResurtido() {
		int rowIndex = table.getSelectedRow();
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.removeRow(rowIndex);
	    if(table.getRowCount()==0) {
	    	btnResurtir.setEnabled(false);
	    	codigoBarras.requestFocus();
	    }
	    btnEliminar.setEnabled(false);
		calcularTotal();
	}
	
	public void resurtir(Catalogo<Resurtido> listaResurtidos, Catalogo<Producto> listaProducto) {
		Catalogo<RenglonResurtido> listaRenglonesResurtidos = new Catalogo<RenglonResurtido>();
		double total = 0;
		for (int i = 0; i < table.getRowCount(); i++) {
			RenglonResurtido renglon = new RenglonResurtido();
			renglon.setId(""+listaRenglonesResurtidos.size());
			Object cBarras = table.getValueAt(i, 0);
			Object cantidadProductos = table.getValueAt(i, 1);
			Object precio = table.getValueAt(i, 2);
			Object fechaCaducidad = table.getValueAt(i, 3);
			Object provedor = table.getValueAt(i, 4);
			Object telefono = table.getValueAt(i, 5);
			Object importe = table.getValueAt(i, 6);
			String codigoBarras = cBarras.toString();
			Producto producto = listaProducto.getElementEach(codigoBarras);
			int cantidad = Integer.parseInt(cantidadProductos.toString());
			int cantidadProducto = producto.getCantidad();
			int cantidadNueva = cantidad+cantidadProducto;
			total += Double.parseDouble(importe.toString());
			double precioNuevo = Double.parseDouble(precio.toString());
			producto.setCantidad(cantidadNueva);
			producto.setPrecio(precioNuevo);
			listaProducto.modify(listaProducto.getIndex(codigoBarras), producto);
			
			renglon.setCodigoBarras(codigoBarras);
			renglon.setCantidad(cantidad);
			renglon.setPrecio(Double.parseDouble(precio.toString()));
			renglon.setFechaCaduc(fechaCaducidad.toString());
			renglon.setProv(provedor.toString());
			renglon.setTelefono(telefono.toString());
			renglon.setImporte(Double.parseDouble(importe.toString()));
			listaRenglonesResurtidos.add(renglon);
		}
		Resurtido resurtido = new Resurtido();
		resurtido.setFolio(""+listaResurtidos.size());
		resurtido.setFecha(LocalDate.now());
		resurtido.setHora(LocalTime.now());
		resurtido.setRenglonesResurtidos(listaRenglonesResurtidos);
		resurtido.setTotal(total);
		listaResurtidos.add(resurtido);
		JOptionPane.showMessageDialog(null, "RESURTIDO REALIZADO CON EXITO");
		limpiarCampos();
		btnAgregar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnResurtir.setEnabled(false);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		lblProductos.setText("0");
		lblTotal.setText("$00.00");
	}
	
	public void cancelarResurtido() {
		limpiarCampos();
		btnAgregar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnResurtir.setEnabled(false);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		lblProductos.setText("0");
		lblTotal.setText("$00.00");
	}
	
	public void calcularTotal() {
		double total = 0.0;
		int cantidad = 0;
		for (int i = 0; i < table.getRowCount(); i++) {
			Object importe = table.getValueAt(i, 6);
			Object cantidadProductos = table.getValueAt(i, 1);
			total += Double.parseDouble(importe.toString());
			cantidad += Integer.parseInt(cantidadProductos.toString());
		}
		lblTotal.setText("$"+total);
		lblProductos.setText(""+cantidad);
	}

}
