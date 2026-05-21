package rs.ac.uns.ftn.db.jdbc.pizzeria.model;

import java.util.Date;

public class Racun {
	private int racID;
	private String nacPl;
	private Date datVrRac;
	private double izn;
	private int kasirMbr;

	public Racun() {
		super();
	}

	public Racun(int racID, String nacPl, Date datVrRac, double izn, int kasirMbr) {
		this.racID = racID;
		this.nacPl = nacPl;
		this.datVrRac = datVrRac;
		this.izn = izn;
		this.kasirMbr = kasirMbr;
	}

	public int getRacID() {
		return racID;
	}

	public void setRacID(int racID) {
		this.racID = racID;
	}

	public String getNacPl() {
		return nacPl;
	}

	public void setNacPl(String nacPl) {
		this.nacPl = nacPl;
	}

	public Date getDatVrRac() {
		return datVrRac;
	}

	public void setDatVrRac(Date datVrRac) {
		this.datVrRac = datVrRac;
	}

	public double getIzn() {
		return izn;
	}

	public void setIzn(double izn) {
		this.izn = izn;
	}

	public int getKasirMbr() {
		return kasirMbr;
	}

	public void setKasirMbr(int kasirMbr) {
		this.kasirMbr = kasirMbr;
	}

	@Override
	public String toString() {
		return String.format("%-6d %-20s %-12s %-10.2f %-6d", 
			racID, nacPl, datVrRac != null ? datVrRac.toString() : "", izn, kasirMbr);
	}

	public static String getFormattedHeader() {
		return String.format("%-6s %-20s %-12s %-10s %-6s", 
			"ID", "NACIN_PLACANJA", "DATUM", "IZNOS", "KASIR");
	}
}
