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
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import modelo.Catalogo;
import modelo.RenglonResurtido;
import modelo.Resurtido;

public class PanelResurtidos extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelTabla_1;
	private JPanel panelTabla;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTable tablaRenglones;
	private JTable tablaResurtido;
	private JPanel panelCaptura;
	private JLabel lblNewLabel;
	private JTextField folio;
	private JLabel lblNewLabel_1;
	private JDateChooser fecha;
	private JLabel lblNewLabel_2;
	private JTextField hora;
	private JLabel lblNewLabel_3;
	private JTextField articulos;
	private JLabel lblNewLabel_4;
	private JTextField total;
	private JButton btnBuscar;
	private JButton btnMostrarTodo;

	public PanelResurtidos() {
		setBorder(new EmptyBorder(15, 15, 15, 15));
		setBackground(new Color(28, 32, 57));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 97, 142 };
		gridBagLayout.columnWeights = new double[] { 40.0, 60.0 };
		gridBagLayout.rowWeights = new double[] { 1.0, 95.0 };
		setLayout(gridBagLayout);

		panelCaptura = new JPanel();
		panelCaptura.setBorder(new EmptyBorder(15, 15, 15, 15));
		panelCaptura.setBackground(new Color(38, 43, 73));
		GridBagConstraints gbc_panelCaptura = new GridBagConstraints();
		gbc_panelCaptura.gridwidth = 2;
		gbc_panelCaptura.insets = new Insets(0, 0, 5, 5);
		gbc_panelCaptura.fill = GridBagConstraints.BOTH;
		gbc_panelCaptura.gridx = 0;
		gbc_panelCaptura.gridy = 0;
		add(panelCaptura, gbc_panelCaptura);
		GridBagLayout gbl_panelCaptura = new GridBagLayout();
		gbl_panelCaptura.columnWidths = new int[] { 30, 100, 0, 120, 0, 100, 0, 100, 0, 100, 150, 130, 0 };
		gbl_panelCaptura.rowHeights = new int[] { 50, 0 };
		gbl_panelCaptura.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_panelCaptura.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panelCaptura.setLayout(gbl_panelCaptura);

		lblNewLabel = new JLabel("FOLIO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Product Sans", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panelCaptura.add(lblNewLabel, gbc_lblNewLabel);

		folio = new JTextField();
		folio.setHorizontalAlignment(SwingConstants.CENTER);
		folio.setForeground(Color.BLACK);
		folio.setFont(new Font("Product Sans", Font.PLAIN, 16));
		folio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (folio.getText().length() >= 15) {
					evt.consume();
					folio.requestFocus();
					btnBuscar.doClick();
				} else {
					if (Character.isDigit(c) || evt.getKeyChar() == KeyEvent.VK_ENTER
							|| evt.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
						if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
							folio.requestFocus();
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
		folio.setColumns(10);
		folio.setBackground(Color.WHITE);
		GridBagConstraints gbc_folio = new GridBagConstraints();
		gbc_folio.fill = GridBagConstraints.HORIZONTAL;
		gbc_folio.insets = new Insets(0, 0, 0, 5);
		gbc_folio.gridx = 1;
		gbc_folio.gridy = 0;
		panelCaptura.add(folio, gbc_folio);

		lblNewLabel_1 = new JLabel("FECHA");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Product Sans", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		panelCaptura.add(lblNewLabel_1, gbc_lblNewLabel_1);

		fecha = new JDateChooser();
		fecha.setForeground(Color.WHITE);
		fecha.setFont(new Font("Product Sans", Font.PLAIN, 16));
		fecha.setBackground(new Color(38, 43, 73));
		GridBagConstraints gbc_fecha = new GridBagConstraints();
		gbc_fecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_fecha.insets = new Insets(0, 0, 0, 5);
		gbc_fecha.gridx = 3;
		gbc_fecha.gridy = 0;
		panelCaptura.add(fecha, gbc_fecha);

		lblNewLabel_2 = new JLabel("HORA");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Product Sans", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 4;
		gbc_lblNewLabel_2.gridy = 0;
		panelCaptura.add(lblNewLabel_2, gbc_lblNewLabel_2);

		hora = new JTextField();
		hora.setHorizontalAlignment(SwingConstants.CENTER);
		hora.setForeground(Color.BLACK);
		hora.setFont(new Font("Product Sans", Font.PLAIN, 16));
		hora.setEnabled(false);
		hora.setColumns(10);
		hora.setBorder(new LineBorder(new Color(255, 255, 255)));
		hora.setBackground(new Color(38, 43, 73));
		GridBagConstraints gbc_hora = new GridBagConstraints();
		gbc_hora.fill = GridBagConstraints.HORIZONTAL;
		gbc_hora.insets = new Insets(0, 0, 0, 5);
		gbc_hora.gridx = 5;
		gbc_hora.gridy = 0;
		panelCaptura.add(hora, gbc_hora);

		lblNewLabel_3 = new JLabel("ARTICULOS");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Product Sans", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 6;
		gbc_lblNewLabel_3.gridy = 0;
		panelCaptura.add(lblNewLabel_3, gbc_lblNewLabel_3);

		articulos = new JTextField();
		articulos.setHorizontalAlignment(SwingConstants.CENTER);
		articulos.setForeground(Color.BLACK);
		articulos.setFont(new Font("Product Sans", Font.PLAIN, 16));
		articulos.setEnabled(false);
		articulos.setColumns(10);
		articulos.setBorder(new LineBorder(new Color(255, 255, 255)));
		articulos.setBackground(new Color(38, 43, 73));
		GridBagConstraints gbc_articulos = new GridBagConstraints();
		gbc_articulos.fill = GridBagConstraints.HORIZONTAL;
		gbc_articulos.insets = new Insets(0, 0, 0, 5);
		gbc_articulos.gridx = 7;
		gbc_articulos.gridy = 0;
		panelCaptura.add(articulos, gbc_articulos);

		lblNewLabel_4 = new JLabel("TOTAL");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Product Sans", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 8;
		gbc_lblNewLabel_4.gridy = 0;
		panelCaptura.add(lblNewLabel_4, gbc_lblNewLabel_4);

		total = new JTextField();
		total.setHorizontalAlignment(SwingConstants.CENTER);
		total.setForeground(Color.BLACK);
		total.setFont(new Font("Product Sans", Font.PLAIN, 16));
		total.setEnabled(false);
		total.setColumns(10);
		total.setBorder(new LineBorder(new Color(255, 255, 255)));
		total.setBackground(new Color(38, 43, 73));
		GridBagConstraints gbc_total = new GridBagConstraints();
		gbc_total.fill = GridBagConstraints.HORIZONTAL;
		gbc_total.insets = new Insets(0, 0, 0, 5);
		gbc_total.gridx = 9;
		gbc_total.gridy = 0;
		panelCaptura.add(total, gbc_total);

		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Product Sans", Font.BOLD, 18));
		btnBuscar.setBackground(new Color(244, 42, 87));
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuscar.insets = new Insets(0, 0, 0, 5);
		gbc_btnBuscar.gridx = 10;
		gbc_btnBuscar.gridy = 0;
		panelCaptura.add(btnBuscar, gbc_btnBuscar);

		btnMostrarTodo = new JButton("MOSTRAR TODO");
		btnMostrarTodo.setForeground(Color.WHITE);
		btnMostrarTodo.setFont(new Font("Product Sans", Font.BOLD, 18));
		btnMostrarTodo.setBackground(new Color(244, 42, 87));
		GridBagConstraints gbc_btnMostrarTodo = new GridBagConstraints();
		gbc_btnMostrarTodo.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMostrarTodo.gridx = 11;
		gbc_btnMostrarTodo.gridy = 0;
		panelCaptura.add(btnMostrarTodo, gbc_btnMostrarTodo);

		panelTabla_1 = new JPanel();
		panelTabla_1.setBorder(new EmptyBorder(15, 15, 15, 15));
		panelTabla_1.setBackground(new Color(38, 43, 73));
		GridBagConstraints gbc_panelTabla_1 = new GridBagConstraints();
		gbc_panelTabla_1.insets = new Insets(0, 0, 0, 5);
		gbc_panelTabla_1.fill = GridBagConstraints.BOTH;
		gbc_panelTabla_1.gridx = 0;
		gbc_panelTabla_1.gridy = 1;
		add(panelTabla_1, gbc_panelTabla_1);
		panelTabla_1.setLayout(new GridLayout(1, 1, 0, 0));

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(null);
		panelTabla_1.add(scrollPane_1);

		scrollPane_1.setViewportView(tablaRenglones);

		tablaResurtido = new JTable();
		tablaResurtido.setSelectionBackground(new Color(28, 32, 57));
		tablaResurtido.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablaResurtido.setBorder(null);
		scrollPane_1.setViewportView(tablaResurtido);
		tablaResurtido.setRowHeight(30);
		tablaResurtido.setFont(new Font("Product Sans", Font.PLAIN, 14));
		tablaResurtido.setEnabled(false);
		tablaResurtido.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "FOLIO", "HORA", "FECHA", "ARTICULOS", "TOTAL" }));
		DefaultTableCellRenderer headerRendererRenglones = new DefaultTableCellRenderer();
		headerRendererRenglones.setBackground(new Color(28, 32, 57));
		headerRendererRenglones.setHorizontalAlignment(JLabel.CENTER);
		headerRendererRenglones.setForeground(Color.WHITE);
		tablaResurtido.getTableHeader().setDefaultRenderer(headerRendererRenglones);
		tablaResurtido.getTableHeader().setReorderingAllowed(false);
		tablaResurtido.setDefaultEditor(Object.class, null);

		panelTabla = new JPanel();
		panelTabla.setBorder(new EmptyBorder(15, 15, 15, 5));
		panelTabla.setBackground(new Color(38, 43, 73));
		GridBagConstraints gbc_panelTabla = new GridBagConstraints();
		gbc_panelTabla.fill = GridBagConstraints.BOTH;
		gbc_panelTabla.gridx = 1;
		gbc_panelTabla.gridy = 1;
		add(panelTabla, gbc_panelTabla);
		panelTabla.setLayout(new GridLayout(1, 1, 0, 0));

		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		panelTabla.add(scrollPane);

		tablaRenglones = new JTable();
		tablaRenglones.setSelectionForeground(new Color(255, 255, 255));
		tablaRenglones.setSelectionBackground(new Color(28, 32, 57));
		tablaRenglones.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablaRenglones.setBorder(null);
		scrollPane.setViewportView(tablaRenglones);
		tablaRenglones.setRowHeight(30);
		tablaRenglones.setFont(new Font("Product Sans", Font.PLAIN, 14));
		tablaRenglones.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "C.BARRAS", "CANTIDAD", "PRECIO", "F.CADUCIDAD", "PROVEDOR", "TELEFONO", "IMPORTE" }));
		DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
		headerRenderer.setBackground(new Color(28, 32, 57));
		headerRenderer.setHorizontalAlignment(JLabel.CENTER);
		headerRenderer.setForeground(Color.WHITE);
		tablaRenglones.getTableHeader().setDefaultRenderer(headerRenderer);
		tablaRenglones.setDefaultEditor(Object.class, null);
		tablaRenglones.setEditingColumn(0);
		tablaRenglones.getTableHeader().setReorderingAllowed(false);
		tablaRenglones.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(100);

	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JButton getBtnMostrarTodo() {
		return btnMostrarTodo;
	}

	public JTable getTablaRenglones() {
		return tablaRenglones;
	}

	public void mostrarTodo() {
		folio.setText("");
		fecha.setDate(null);
		hora.setText("");
		articulos.setText("");
		total.setText("");
		DefaultTableModel modelo = (DefaultTableModel) tablaRenglones.getModel();
		modelo.setRowCount(0);
	}

	public void buscar(Catalogo<Resurtido> listaResurtido) {
		String folioBusqueda = folio.getText();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String fechaBusqueda = "";
		if (fecha.getDate() != null) {
			fechaBusqueda = dateFormat.format(fecha.getDate());
		}
		if (folioBusqueda.equalsIgnoreCase("") && fechaBusqueda.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS");
		} else {
			if (!folioBusqueda.equalsIgnoreCase("")) {
				if (listaResurtido.contains(folioBusqueda)) {
					Resurtido resurtido = listaResurtido.getElementEach(folioBusqueda);
					Catalogo<RenglonResurtido> listaRenglones = resurtido.getRenglonesResurtidos();
					llenarTablaRenglones(listaRenglones);
					Date date = Date.from(resurtido.getFecha().atStartOfDay(ZoneId.systemDefault()).toInstant());
					fecha.setDate(date);
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
					String horaFormateada = resurtido.getHora().format(formatter);
					hora.setText(horaFormateada);
					articulos.setText("" + listaRenglones.size());
					total.setText("" + resurtido.getTotal());
				} else {
					folio.setText("");
					JOptionPane.showMessageDialog(null, "FOLIO NO EXISTENTE");
				}
			} else if (!fechaBusqueda.equalsIgnoreCase("")) {
				Object[] datos = new Object[tablaResurtido.getColumnCount()];
				DefaultTableModel modelo = (DefaultTableModel) tablaResurtido.getModel();
				modelo.setRowCount(0);
				for (int i = 0; i < listaResurtido.size(); i++) {
					Resurtido resurtido = listaResurtido.getElement(i);
					Date date = Date.from(resurtido.getFecha().atStartOfDay(ZoneId.systemDefault()).toInstant());
					String fechaResurtido = dateFormat.format(date);
					if (fechaResurtido.equalsIgnoreCase(fechaBusqueda)) {
						datos[0] = resurtido.getFolio();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
						String horaFormateada = resurtido.getHora().format(formatter);
						datos[1] = horaFormateada;
						datos[2] = resurtido.getFecha();
						datos[3] = resurtido.getRenglonesResurtidos().size();
						datos[4] = resurtido.getTotal();
						modelo.addRow(datos);
					}
				}
				if (tablaResurtido.getRowCount() == 0) {
					llenarTablaResurtido(listaResurtido);
					fecha.setDate(null);
					JOptionPane.showMessageDialog(null, "NINGUN RESURTIDO PARA ESA FECHA");
				}
			}
		}
		folio.requestFocus();
	}

	public void llenarTablaResurtido(Catalogo<Resurtido> listaResurtido) {
		Object[] datos = new Object[tablaResurtido.getColumnCount()];
		DefaultTableModel modelo = (DefaultTableModel) tablaResurtido.getModel();
		modelo.setRowCount(0);
		for (int i = 0; i < listaResurtido.size(); i++) {
			Resurtido resurtido = listaResurtido.getElement(i);
			datos[0] = resurtido.getFolio();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
			String hora = resurtido.getHora().format(formatter);
			datos[1] = hora;
			datos[2] = resurtido.getFecha();
			datos[3] = resurtido.getRenglonesResurtidos().size();
			datos[4] = resurtido.getTotal();
			modelo.addRow(datos);
		}
		folio.requestFocus();
	}

	public void llenarTablaRenglones(Catalogo<RenglonResurtido> listaRenglones) {
		Object[] datos = new Object[tablaRenglones.getColumnCount()];
		DefaultTableModel modelo = (DefaultTableModel) tablaRenglones.getModel();
		modelo.setRowCount(0);
		for (int i = 0; i < listaRenglones.size(); i++) {
			RenglonResurtido renglon = listaRenglones.getElement(i);
			datos[0] = renglon.getCodigoBarras();
			datos[1] = renglon.getCantidad();
			datos[2] = renglon.getPrecio();
			datos[3] = renglon.getFechaCaduc();
			datos[4] = renglon.getProv();
			datos[5] = renglon.getTelefono();
			datos[6] = renglon.getImporte();
			modelo.addRow(datos);
		}
		folio.requestFocus();
	}

}