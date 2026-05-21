package rs.ac.uns.ftn.db.jdbc.pizzeria.model;

import java.util.Date;

public class Cena {
	private int cenaID;
	private double iznos;
	private String datPoc;
	private char vazeca;
	private Date datKr;
	private int artikalSifArt;

	public Cena() {
		super();
	}

	public Cena(int cenaID, double iznos, String datPoc, char vazeca, Date datKr, int artikalSifArt) {
		this.cenaID = cenaID;
		this.iznos = iznos;
		this.datPoc = datPoc;
		this.vazeca = vazeca;
		this.datKr = datKr;
		this.artikalSifArt = artikalSifArt;
	}

	public int getCenaID() {
		return cenaID;
	}

	public void setCenaID(int cenaID) {
		this.cenaID = cenaID;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	public String getDatPoc() {
		return datPoc;
	}

	public void setDatPoc(String datPoc) {
		this.datPoc = datPoc;
	}

	public char getVazeca() {
		return vazeca;
	}

	public void setVazeca(char vazeca) {
		this.vazeca = vazeca;
	}

	public Date getDatKr() {
		return datKr;
	}

	public void setDatKr(Date datKr) {
		this.datKr = datKr;
	}

	public int getArtikalSifArt() {
		return artikalSifArt;
	}

	public void setArtikalSifArt(int artikalSifArt) {
		this.artikalSifArt = artikalSifArt;
	}

	@Override
	public String toString() {
		return String.format("%-6d %-6d %-10.2f %-15s %-7c %-12s", 
			artikalSifArt, cenaID, iznos, datPoc, vazeca, datKr != null ? datKr.toString() : "");
	}

	public static String getFormattedHeader() {
		return String.format("%-6s %-6s %-10s %-15s %-7s %-12s", 
			"ARTIKL", "ID", "IZNOS", "DAT_POC", "VAZECA", "DAT_KR");
	}
}
