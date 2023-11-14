package modelo;

import java.io.Serializable;

import interfaces.Accesible;

public class RenglonTicket implements Serializable, Accesible {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String codigoBarras;
	private String producto;
	private double precioUnitario;
	private int cantidad;
	private double importe;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	@Override
	public String getPassword() {
		return codigoBarras;
	}

}
