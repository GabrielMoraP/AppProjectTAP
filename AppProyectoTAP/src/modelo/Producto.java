package modelo;

import java.io.Serializable;

import interfaces.Accesible;

public class Producto implements Serializable, Accesible {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigoBarras;
	private String nombre;
	private String marca;
	private String tipo;
	private String contenido;
	private String unidadMedida;
	private String presentacion;
	private String descripcion;
	private int cantidad;
	private double precio;
	private int stockMaximo;
	private int stockMinimo;

	public Producto() {
		super();
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStockMaximo() {
		return stockMaximo;
	}

	public void setStockMaximo(int stockMaximo) {
		this.stockMaximo = stockMaximo;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	@Override
	public String toString() {
		return "C.Barras: " + codigoBarras + "\nNombre: " + nombre + "\nMarca: " + marca + "\nTipo:" + tipo
				+ "\nContenido: " + contenido + "\nU.Medida: " + unidadMedida + "\nCantidad: " + cantidad
				+ "\nPresentacion: " + presentacion + "\nDescripcion: " + descripcion + "\nS.Maximo: " + stockMaximo
				+ "\nS.Minimo: " + stockMinimo;
	}

	@Override
	public String getPassword() {
		return codigoBarras;
	}
	
	@Override
	public boolean equals(Object obj) {
		Producto producto = (Producto) obj;
		return producto.getCodigoBarras().equalsIgnoreCase(this.codigoBarras);
	}

}
