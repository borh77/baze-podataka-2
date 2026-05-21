package rs.ac.uns.ftn.db.jdbc.pizzeria.model;

import java.util.Date;

public class Proizvod {
	private int prodID;
	private String nazp;
	private double wght;
	private Date roktr;

	public Proizvod() {
		super();
	}

	public Proizvod(int prodID, String nazp, double wght, Date roktr) {
		this.prodID = prodID;
		this.nazp = nazp;
		this.wght = wght;
		this.roktr = roktr;
	}

	public int getProdID() {
		return prodID;
	}

	public void setProdID(int prodID) {
		this.prodID = prodID;
	}

	public String getNazp() {
		return nazp;
	}

	public void setNazp(String nazp) {
		this.nazp = nazp;
	}

	public double getWght() {
		return wght;
	}

	public void setWght(double wght) {
		this.wght = wght;
	}

	public Date getRoktr() {
		return roktr;
	}

	public void setRoktr(Date roktr) {
		this.roktr = roktr;
	}

	@Override
	public String toString() {
		return String.format("%-6d %-25s %-10.2f %-12s", 
			prodID, nazp, wght, roktr != null ? roktr.toString() : "");
	}

	public static String getFormattedHeader() {
		return String.format("%-6s %-25s %-10s %-12s", 
			"ID", "NAZIV", "TEZINA", "ROK_TRAJANJA");
	}
}
