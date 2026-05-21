package rs.ac.uns.ftn.db.jdbc.pizzeria.model;

public class Distributer {
	private int disID;
	private String nazDis;
	private String kontaktDis;

	public Distributer() {
		super();
	}

	public Distributer(int disID, String nazDis, String kontaktDis) {
		this.disID = disID;
		this.nazDis = nazDis;
		this.kontaktDis = kontaktDis;
	}

	public int getDisID() {
		return disID;
	}

	public void setDisID(int disID) {
		this.disID = disID;
	}

	public String getNazDis() {
		return nazDis;
	}

	public void setNazDis(String nazDis) {
		this.nazDis = nazDis;
	}

	public String getKontaktDis() {
		return kontaktDis;
	}

	public void setKontaktDis(String kontaktDis) {
		this.kontaktDis = kontaktDis;
	}

	@Override
	public String toString() {
		return String.format("%-6d %-25s %-15s", disID, nazDis, kontaktDis);
	}

	public static String getFormattedHeader() {
		return String.format("%-6s %-25s %-15s", "ID", "NAZIV", "KONTAKT");
	}
}
