package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import interfaces.Accesible;

public class Resurtido implements Serializable, Accesible {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String folio;
	private LocalTime hora;
	private LocalDate fecha;
	private Catalogo<RenglonResurtido> renglonesResurtidos;
	private double total;

	public Resurtido() {
		super();
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Catalogo<RenglonResurtido> getRenglonesResurtidos() {
		return renglonesResurtidos;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setRenglonesResurtidos(Catalogo<RenglonResurtido> renglonesResurtidos) {
		this.renglonesResurtidos = renglonesResurtidos;
	}

	@Override
	public String getPassword() {
		return folio;
	}
}