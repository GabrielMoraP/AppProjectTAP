package modelo;

import java.io.Serializable;

import interfaces.Accesible;

public class RenglonResurtido implements Serializable, Accesible {

	private static final long serialVersionUID = 1L;
	private String id;
	private String codigoBarras;
	private int cantidad;
	private double precio;
	private String fechaCaduc;
	private String prov;
	private String telefono;
	private double importe;

	public RenglonResurtido() {
		super();
	}

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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getProv() {
		return prov;
	}

	public void setProv(String prov) {
		this.prov = prov;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFechaCaduc() {
		return fechaCaduc;
	}

	public void setFechaCaduc(String fechaCaduc) {
		this.fechaCaduc = fechaCaduc;
	}

	public double getTotal() {
		return precio * cantidad;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	@Override
	public String toString() {
		return "RenglonResurtido [id=" + id + ", codigoBarras=" + codigoBarras + ", cantidad=" + cantidad + ", precio="
				+ precio + ", fechaCaduc=" + fechaCaduc + ", importe=" + importe + "]";
	}

	@Override
	public String getPassword() {
		return id;
	}

}
