package rs.ac.uns.ftn.db.jdbc.pizzeria.model;

import java.util.Date;

public class Izvestaj {
	private int izvID;
	private Date datKreir;
	private String tesktIzv;
	private int vlasnikMbv;

	public Izvestaj() {
		super();
	}

	public Izvestaj(int izvID, Date datKreir, String tesktIzv, int vlasnikMbv) {
		this.izvID = izvID;
		this.datKreir = datKreir;
		this.tesktIzv = tesktIzv;
		this.vlasnikMbv = vlasnikMbv;
	}

	public int getIzvID() {
		return izvID;
	}

	public void setIzvID(int izvID) {
		this.izvID = izvID;
	}

	public Date getDatKreir() {
		return datKreir;
	}

	public void setDatKreir(Date datKreir) {
		this.datKreir = datKreir;
	}

	public String getTesktIzv() {
		return tesktIzv;
	}

	public void setTesktIzv(String tesktIzv) {
		this.tesktIzv = tesktIzv;
	}

	public int getVlasnikMbv() {
		return vlasnikMbv;
	}

	public void setVlasnikMbv(int vlasnikMbv) {
		this.vlasnikMbv = vlasnikMbv;
	}

	@Override
	public String toString() {
		return String.format("%-6d %-12s %-50s %-6d", 
			izvID, datKreir != null ? datKreir.toString() : "", 
			tesktIzv != null && tesktIzv.length() > 50 ? tesktIzv.substring(0, 50) : tesktIzv != null ? tesktIzv : "", 
			vlasnikMbv);
	}

	public static String getFormattedHeader() {
		return String.format("%-6s %-12s %-50s %-6s", 
			"ID", "DATUM", "TEKST", "VLASNIK");
	}
}
