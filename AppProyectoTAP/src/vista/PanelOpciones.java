package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelOpciones extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnHome;
	private JButton btnVender;
	private JButton btnProductos;
	private JButton btnResurtir;
	private JButton btnVentas;
	private JButton btnResurtidos;
	private JLabel lblNewLabel_2;

	public PanelOpciones() {
		setFocusCycleRoot(true);
		setFocusTraversalPolicyProvider(true);
		setFont(new Font("Product Sans", Font.BOLD, 11));
		setForeground(new Color(255, 255, 255));
		setBorder(null);
		setBackground(new Color(37, 44, 71));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{200, 0};
		gridBagLayout.rowHeights = new int[]{16, 40, 16, 0, 30, 0, 16, 40, 16, 40, 16, 40, 16, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 20.0, 0.0, 10.0, 0.0, 10.0, 0.0, 10.0, 0.0, 10.0, 0.0, 10.0, 0.0, 30.0};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("@GMP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Product Sans", Font.BOLD, 36));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PointOfSales");
		lblNewLabel_1.setForeground(new Color(244, 42, 87));
		lblNewLabel_1.setFont(new Font("Product Sans", Font.BOLD, 28));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 2;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		btnHome = new JButton("HOME");
		btnHome.setEnabled(false);
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Product Sans", Font.BOLD, 22));
		btnHome.setFocusTraversalPolicyProvider(true);
		btnHome.setFocusCycleRoot(true);
		btnHome.setDoubleBuffered(true);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorder(null);
		GridBagConstraints gbc_btnHome = new GridBagConstraints();
		gbc_btnHome.insets = new Insets(0, 0, 5, 0);
		gbc_btnHome.gridx = 0;
		gbc_btnHome.gridy = 3;
		add(btnHome, gbc_btnHome);
		try {
			BufferedImage image;
			image = ImageIO.read(new File("src/recursos/img/home.png"));
			Image scaledImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			btnHome.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		btnVender = new JButton("VENDER");
		btnVender.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVender.setDoubleBuffered(true);
		btnVender.setFocusCycleRoot(true);
		btnVender.setFocusTraversalPolicyProvider(true);
		btnVender.setForeground(Color.WHITE);
		btnVender.setFont(new Font("Product Sans", Font.BOLD, 22));
		btnVender.setContentAreaFilled(false);
		btnVender.setBorder(null);
		GridBagConstraints gbc_btnVender = new GridBagConstraints();
		gbc_btnVender.insets = new Insets(0, 0, 5, 0);
		gbc_btnVender.gridx = 0;
		gbc_btnVender.gridy = 5;
		add(btnVender, gbc_btnVender);
		try {
			BufferedImage image;
			image = ImageIO.read(new File("src/recursos/img/car.png"));
			Image scaledImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			btnVender.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		btnProductos = new JButton("PRODUCTOS");
		btnProductos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProductos.setDoubleBuffered(true);
		btnProductos.setFocusCycleRoot(true);
		btnProductos.setFocusTraversalPolicyProvider(true);
		btnProductos.setForeground(Color.WHITE);
		btnProductos.setFont(new Font("Product Sans", Font.BOLD, 22));
		btnProductos.setContentAreaFilled(false);
		btnProductos.setBorder(null);
		GridBagConstraints gbc_btnProductos = new GridBagConstraints();
		gbc_btnProductos.insets = new Insets(0, 0, 5, 0);
		gbc_btnProductos.gridx = 0;
		gbc_btnProductos.gridy = 7;
		add(btnProductos, gbc_btnProductos);
		try {
			BufferedImage image;
			image = ImageIO.read(new File("src/recursos/img/product.png"));
			Image scaledImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			btnProductos.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		btnResurtir = new JButton("RESURTIDO");
		btnResurtir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnResurtir.setDoubleBuffered(true);
		btnResurtir.setFocusCycleRoot(true);
		btnResurtir.setFocusTraversalPolicyProvider(true);
		btnResurtir.setForeground(Color.WHITE);
		btnResurtir.setFont(new Font("Product Sans", Font.BOLD, 22));
		btnResurtir.setContentAreaFilled(false);
		btnResurtir.setBorder(null);
		GridBagConstraints gbc_btnResurtir = new GridBagConstraints();
		gbc_btnResurtir.insets = new Insets(0, 0, 5, 0);
		gbc_btnResurtir.gridx = 0;
		gbc_btnResurtir.gridy = 9;
		add(btnResurtir, gbc_btnResurtir);
		try {
			BufferedImage image;
			image = ImageIO.read(new File("src/recursos/img/inventary.png"));
			Image scaledImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			btnResurtir.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		btnResurtidos = new JButton("RESURTIDOS");
		btnResurtidos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnResurtidos.setForeground(Color.WHITE);
		btnResurtidos.setFont(new Font("Product Sans", Font.BOLD, 22));
		btnResurtidos.setFocusTraversalPolicyProvider(true);
		btnResurtidos.setFocusCycleRoot(true);
		btnResurtidos.setDoubleBuffered(true);
		btnResurtidos.setContentAreaFilled(false);
		btnResurtidos.setBorder(null);
		GridBagConstraints gbc_btnResurtidos = new GridBagConstraints();
		gbc_btnResurtidos.insets = new Insets(0, 0, 5, 0);
		gbc_btnResurtidos.gridx = 0;
		gbc_btnResurtidos.gridy = 11;
		add(btnResurtidos, gbc_btnResurtidos);
		try {
			BufferedImage image;
			image = ImageIO.read(new File("src/recursos/img/inventary.png"));
			Image scaledImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			btnResurtidos.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		btnVentas = new JButton("VENTAS");
		btnVentas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVentas.setDoubleBuffered(true);
		btnVentas.setFocusCycleRoot(true);
		btnVentas.setFocusTraversalPolicyProvider(true);
		btnVentas.setForeground(Color.WHITE);
		btnVentas.setFont(new Font("Product Sans", Font.BOLD, 22));
		btnVentas.setContentAreaFilled(false);
		btnVentas.setBorder(null);
		GridBagConstraints gbc_btnVentas = new GridBagConstraints();
		gbc_btnVentas.insets = new Insets(0, 0, 5, 0);
		gbc_btnVentas.gridx = 0;
		gbc_btnVentas.gridy = 13;
		add(btnVentas, gbc_btnVentas);
		try {
			BufferedImage image;
			image = ImageIO.read(new File("src/recursos/img/money.png"));
			Image scaledImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			btnVentas.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		lblNewLabel_2 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 14;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

	}

	public JButton getBtnHome() {
		return btnHome;
	}

	public JButton getBtnVender() {
		return btnVender;
	}

	public JButton getBtnProductos() {
		return btnProductos;
	}

	public JButton getBtnResurtir() {
		return btnResurtir;
	}
	
	public JButton getBtnResurtidos() {
		return btnResurtidos;
	}

	public JButton getBtnVentas() {
		return btnVentas;
	}
	
}
