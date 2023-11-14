package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import modelo.Catalogo;
import modelo.Producto;
import modelo.RenglonTicket;
import modelo.Venta;

public class PanelHome extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblStock;
	private JLabel lblVentas;
	private JLabel lblInventario;
	private JLabel lblGanancia;
	private DefaultCategoryDataset datasetStock;
	private DefaultCategoryDataset datasetVendidos;

	public PanelHome() {
		setBorder(new EmptyBorder(15, 15, 15, 15));
		setBackground(new Color(28, 32, 57));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 200, 200, 200, 200, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 90.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panelStock = new JPanel();
		panelStock.setBorder(new EmptyBorder(0, 15, 0, 15));
		panelStock.setBackground(new Color(116, 84, 184));
		GridBagConstraints gbc_panelStock = new GridBagConstraints();
		gbc_panelStock.insets = new Insets(0, 0, 5, 5);
		gbc_panelStock.fill = GridBagConstraints.BOTH;
		gbc_panelStock.gridx = 0;
		gbc_panelStock.gridy = 0;
		add(panelStock, gbc_panelStock);
		panelStock.setLayout(new GridLayout(2, 1, 0, 0));

		JLabel lblNewLabel = new JLabel("STOCK");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Product Sans", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panelStock.add(lblNewLabel);

		lblStock = new JLabel("$00.00");
		lblStock.setForeground(new Color(255, 255, 255));
		lblStock.setFont(new Font("Product Sans", Font.BOLD, 30));
		lblStock.setHorizontalAlignment(SwingConstants.RIGHT);
		panelStock.add(lblStock);

		JPanel panelVentas = new JPanel();
		panelVentas.setBorder(new EmptyBorder(0, 15, 0, 15));
		panelVentas.setBackground(new Color(13, 165, 144));
		GridBagConstraints gbc_panelVentas = new GridBagConstraints();
		gbc_panelVentas.insets = new Insets(0, 0, 5, 5);
		gbc_panelVentas.fill = GridBagConstraints.BOTH;
		gbc_panelVentas.gridx = 1;
		gbc_panelVentas.gridy = 0;
		add(panelVentas, gbc_panelVentas);
		panelVentas.setLayout(new GridLayout(2, 1, 0, 0));

		JLabel lblNewLabel_2 = new JLabel("VENTAS");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Product Sans", Font.BOLD, 30));
		panelVentas.add(lblNewLabel_2);

		lblVentas = new JLabel("$00.00");
		lblVentas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVentas.setForeground(Color.WHITE);
		lblVentas.setFont(new Font("Product Sans", Font.BOLD, 30));
		panelVentas.add(lblVentas);

		JPanel panelCompras = new JPanel();
		panelCompras.setBorder(new EmptyBorder(0, 15, 0, 15));
		panelCompras.setBackground(new Color(244, 42, 87));
		GridBagConstraints gbc_panelCompras = new GridBagConstraints();
		gbc_panelCompras.insets = new Insets(0, 0, 5, 5);
		gbc_panelCompras.fill = GridBagConstraints.BOTH;
		gbc_panelCompras.gridx = 2;
		gbc_panelCompras.gridy = 0;
		add(panelCompras, gbc_panelCompras);
		panelCompras.setLayout(new GridLayout(2, 1, 0, 0));

		JLabel lblNewLabel_3 = new JLabel("INVENTARIO");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Product Sans", Font.BOLD, 30));
		panelCompras.add(lblNewLabel_3);

		lblInventario = new JLabel("$00.00");
		lblInventario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInventario.setForeground(Color.WHITE);
		lblInventario.setFont(new Font("Product Sans", Font.BOLD, 30));
		panelCompras.add(lblInventario);

		JPanel panelGanancia = new JPanel();
		panelGanancia.setBorder(new EmptyBorder(0, 15, 0, 15));
		panelGanancia.setBackground(new Color(28, 182, 247));
		GridBagConstraints gbc_panelGanancia = new GridBagConstraints();
		gbc_panelGanancia.insets = new Insets(0, 0, 5, 0);
		gbc_panelGanancia.fill = GridBagConstraints.BOTH;
		gbc_panelGanancia.gridx = 3;
		gbc_panelGanancia.gridy = 0;
		add(panelGanancia, gbc_panelGanancia);
		panelGanancia.setLayout(new GridLayout(2, 1, 0, 0));

		JLabel lblNewLabel_4 = new JLabel("GANANCIA");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Product Sans", Font.BOLD, 30));
		panelGanancia.add(lblNewLabel_4);

		lblGanancia = new JLabel("$00.00");
		lblGanancia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGanancia.setForeground(Color.WHITE);
		lblGanancia.setFont(new Font("Product Sans", Font.BOLD, 30));
		panelGanancia.add(lblGanancia);

		datasetStock = new DefaultCategoryDataset();
		JFreeChart chartStock = ChartFactory.createBarChart("PRODUCTOS CON POCO STOCK", "PRODUCTOS", "STOCK",
				datasetStock);
		chartStock.setBackgroundPaint(Color.WHITE);
		ChartPanel panelGraficaBarras = new ChartPanel(chartStock);
		panelGraficaBarras.setBorder(new EmptyBorder(15, 0, 15, 0));
		panelGraficaBarras.setForeground(Color.white);
		panelGraficaBarras.setBackground(new Color(28, 32, 57));
		GridBagConstraints gbc_panelGraficaBarras = new GridBagConstraints();
		gbc_panelGraficaBarras.insets = new Insets(0, 0, 0, 5);
		gbc_panelGraficaBarras.gridwidth = 2;
		gbc_panelGraficaBarras.fill = GridBagConstraints.BOTH;
		gbc_panelGraficaBarras.gridx = 0;
		gbc_panelGraficaBarras.gridy = 1;
		add(panelGraficaBarras, gbc_panelGraficaBarras);

		datasetVendidos = new DefaultCategoryDataset();
		JFreeChart chartVendidos = ChartFactory.createBarChart("PRODUCTOS MAS VENDIDOS", "PRODUCTOS", "STOCK",
				datasetVendidos);
		chartVendidos.setBackgroundPaint(Color.WHITE);
		ChartPanel panelGraficaPastel = new ChartPanel(chartVendidos);
		panelGraficaPastel.setBorder(new EmptyBorder(15, 0, 15, 0));
		panelGraficaPastel.setBackground(new Color(28, 32, 57));
		GridBagConstraints gbc_panelGraficaPastel = new GridBagConstraints();
		gbc_panelGraficaPastel.gridwidth = 2;
		gbc_panelGraficaPastel.fill = GridBagConstraints.BOTH;
		gbc_panelGraficaPastel.gridx = 2;
		gbc_panelGraficaPastel.gridy = 1;
		add(panelGraficaPastel, gbc_panelGraficaPastel);

	}

	public void calcularStock(Catalogo<Producto> listaProductos) {
		lblStock.setText("" + listaProductos.size());
	}

	public void calcularVentas(Catalogo<Venta> listaVentas) {
		lblVentas.setText("" + listaVentas.size());
	}

	public void calcularInventario(Catalogo<Producto> listaProductos) {
		double inventario = 0;
		for (int i = 0; i < listaProductos.size(); i++) {
			Producto producto = listaProductos.getElement(i);
			inventario += producto.getPrecio() * producto.getCantidad();
		}
		lblInventario.setText("$" + inventario);
	}

	public void calcularGanancia(Catalogo<Venta> listaVentas) {
		double ventas = 0;
		for (int i = 0; i < listaVentas.size(); i++) {
			Venta venta = listaVentas.getElement(i);
			ventas += venta.getTotal();
		}
		lblGanancia.setText("$" + ventas);
	}

	public void menosStock(Catalogo<Producto> listaProductos) {
		List<Producto> listaProductosCantidad = new ArrayList<>();
		for (int i = 0; i < listaProductos.size(); i++) {
			Producto producto = listaProductos.getElement(i);
			listaProductosCantidad.add(producto);
		}
		Collections.sort(listaProductosCantidad, Comparator.comparingInt(Producto::getCantidad));
		if (listaProductos.size() < 5) {
			for (int i = 0; i < listaProductosCantidad.size(); i++) {
				Producto producto = listaProductosCantidad.get(i);
				datasetStock.addValue(producto.getCantidad(), producto.getNombre(), "STOCK");
			}
		} else {
			for (int i = 0; i < 5; i++) {
				Producto producto = listaProductosCantidad.get(i);
				datasetStock.addValue(producto.getCantidad(), producto.getNombre(), "STOCK");
			}
		}
	}

	public void masVendidos(Catalogo<Venta> listaVentas, Catalogo<Producto> listaProductos) {
		List<String> listRenglones = new ArrayList<String>();
		for (int i = 0; i < listaVentas.size(); i++) {
			Venta venta = listaVentas.getElement(i);
			Catalogo<RenglonTicket> renglonesTicket = venta.getRenglonesTicket();
			for (int j = 0; j < renglonesTicket.size(); j++) {
				RenglonTicket renglonTicket = renglonesTicket.getElement(j);
				listRenglones.add(renglonTicket.getCodigoBarras());
			}
		}

		Map<String, Integer> frecuencias = new HashMap<>();
	    for (String elemento : listRenglones) {
	        frecuencias.put(elemento, frecuencias.getOrDefault(elemento, 0) + 1);
	    }
	    
	    List<Map.Entry<String, Integer>> entradas = new ArrayList<>(frecuencias.entrySet());
	    entradas.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
	    
	    List<String> ordenadosPorFrecuencia = new ArrayList<>();
	    for (Map.Entry<String, Integer> entrada : entradas) {
	        String elemento = entrada.getKey();
	        int frecuencia = entrada.getValue();
	        for (int i = 0; i < frecuencia; i++) {
	            ordenadosPorFrecuencia.add(elemento);
	        }
	    }
	    
	    Set<String> conjunto = new LinkedHashSet<>(ordenadosPorFrecuencia);
	    List<String> sinRepetidos = new ArrayList<>(conjunto);
	    
		for (int i = 0; i < 5; i++) {
			Producto producto = listaProductos.getElementEach(sinRepetidos.get(i));
			datasetVendidos.addValue(producto.getCantidad(), producto.getNombre(), "STOCK");
		}
	}

}
