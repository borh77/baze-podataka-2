package rs.ac.uns.ftn.db.jdbc.pizzeria.model;

public class Dostava {
	private int dosID;
	private String nazDos;
	private String kontaktDos;

	public Dostava() {
		super();
	}

	public Dostava(int dosID, String nazDos, String kontaktDos) {
		this.dosID = dosID;
		this.nazDos = nazDos;
		this.kontaktDos = kontaktDos;
	}

	public int getDosID() {
		return dosID;
	}

	public void setDosID(int dosID) {
		this.dosID = dosID;
	}

	public String getNazDos() {
		return nazDos;
	}

	public void setNazDos(String nazDos) {
		this.nazDos = nazDos;
	}

	public String getKontaktDos() {
		return kontaktDos;
	}

	public void setKontaktDos(String kontaktDos) {
		this.kontaktDos = kontaktDos;
	}

	@Override
	public String toString() {
		return String.format("%-6d %-25s %-15s", dosID, nazDos, kontaktDos);
	}

	public static String getFormattedHeader() {
		return String.format("%-6s %-25s %-15s", "ID", "NAZIV", "KONTAKT");
	}
}
