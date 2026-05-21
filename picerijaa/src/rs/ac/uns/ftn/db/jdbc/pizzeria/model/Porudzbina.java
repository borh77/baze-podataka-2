package rs.ac.uns.ftn.db.jdbc.pizzeria.model;

import java.util.Date;

public class Porudzbina {
	private int porID;
	private Date datVrPor;
	private String statusPor;
	private double suma;
	private String nacPreuz;
	private int kasirMbr;
	private int musterijaMbm;

	public Porudzbina() {
		super();
	}

	public Porudzbina(int porID, Date datVrPor, String statusPor, double suma, String nacPreuz, int kasirMbr, int musterijaMbm) {
		this.porID = porID;
		this.datVrPor = datVrPor;
		this.statusPor = statusPor;
		this.suma = suma;
		this.nacPreuz = nacPreuz;
		this.kasirMbr = kasirMbr;
		this.musterijaMbm = musterijaMbm;
	}

	public int getPorID() {
		return porID;
	}

	public void setPorID(int porID) {
		this.porID = porID;
	}

	public Date getDatVrPor() {
		return datVrPor;
	}

	public void setDatVrPor(Date datVrPor) {
		this.datVrPor = datVrPor;
	}

	public String getStatusPor() {
		return statusPor;
	}

	public void setStatusPor(String statusPor) {
		this.statusPor = statusPor;
	}

	public double getSuma() {
		return suma;
	}

	public void setSuma(double suma) {
		this.suma = suma;
	}

	public String getNacPreuz() {
		return nacPreuz;
	}

	public void setNacPreuz(String nacPreuz) {
		this.nacPreuz = nacPreuz;
	}

	public int getKasirMbr() {
		return kasirMbr;
	}

	public void setKasirMbr(int kasirMbr) {
		this.kasirMbr = kasirMbr;
	}

	public int getMusterijaMbm() {
		return musterijaMbm;
	}

	public void setMusterijaMbm(int musterijaMbm) {
		this.musterijaMbm = musterijaMbm;
	}

	@Override
	public String toString() {
		return String.format("%-6d %-12s %-15s %-10.2f %-15s %-6d %-6d", 
			porID, datVrPor != null ? datVrPor.toString() : "", statusPor, suma, nacPreuz, kasirMbr, musterijaMbm);
	}

	public static String getFormattedHeader() {
		return String.format("%-6s %-12s %-15s %-10s %-15s %-6s %-6s", 
			"ID", "DATUM", "STATUS", "SUMA", "NAC_PREUZ", "KASIR", "MUSTERIJA");
	}
}
