package rs.ac.uns.ftn.db.jdbc.pizzeria.model;

import java.util.Date;

public class Nabavka {
	private int nabID;
	private Date datNab;
	private double iznosNab;
	private String statusNab;
	private int zaposljavZaposljavID;

	public Nabavka() {
		super();
	}

	public Nabavka(int nabID, Date datNab, double iznosNab, String statusNab, int zaposljavZaposljavID) {
		this.nabID = nabID;
		this.datNab = datNab;
		this.iznosNab = iznosNab;
		this.statusNab = statusNab;
		this.zaposljavZaposljavID = zaposljavZaposljavID;
	}

	public int getNabID() {
		return nabID;
	}

	public void setNabID(int nabID) {
		this.nabID = nabID;
	}

	public Date getDatNab() {
		return datNab;
	}

	public void setDatNab(Date datNab) {
		this.datNab = datNab;
	}

	public double getIznosNab() {
		return iznosNab;
	}

	public void setIznosNab(double iznosNab) {
		this.iznosNab = iznosNab;
	}

	public String getStatusNab() {
		return statusNab;
	}

	public void setStatusNab(String statusNab) {
		this.statusNab = statusNab;
	}

	public int getZaposljavZaposljavID() {
		return zaposljavZaposljavID;
	}

	public void setZaposljavZaposljavID(int zaposljavZaposljavID) {
		this.zaposljavZaposljavID = zaposljavZaposljavID;
	}

	@Override
	public String toString() {
		return String.format("%-6d %-12s %-12.2f %-15s %-6d", 
			nabID, datNab != null ? datNab.toString() : "", iznosNab, statusNab, zaposljavZaposljavID);
	}

	public static String getFormattedHeader() {
		return String.format("%-6s %-12s %-12s %-15s %-6s", 
			"ID", "DATUM", "IZNOS", "STATUS", "ZAPOSL_ID");
	}
}
