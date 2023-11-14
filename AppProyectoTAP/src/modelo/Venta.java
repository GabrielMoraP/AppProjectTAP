package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import interfaces.Accesible;

public class Venta implements Serializable, Accesible {

	private static final long serialVersionUID = 1L;
	private String folio;
	private LocalTime hora;
	private LocalDate fecha;
	private Catalogo<RenglonTicket> renglonesTicket;
	private double total;

	public Venta() {
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

	public Catalogo<RenglonTicket> getRenglonesTicket() {
		return renglonesTicket;
	}

	public void setRenglonesTicket(Catalogo<RenglonTicket> renglonesTicket) {
		this.renglonesTicket = renglonesTicket;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String getPassword() {
		return folio;
	}

}
