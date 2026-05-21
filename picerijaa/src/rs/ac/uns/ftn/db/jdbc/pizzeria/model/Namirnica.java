package rs.ac.uns.ftn.db.jdbc.pizzeria.model;

public class Namirnica {
	private int namID;
	private String nazNam;
	private String opisNam;
	private String jedinica;
	private int pomocniRadnikMbr;

	public Namirnica() {
		super();
	}

	public Namirnica(int namID, String nazNam, String opisNam, String jedinica, int pomocniRadnikMbr) {
		this.namID = namID;
		this.nazNam = nazNam;
		this.opisNam = opisNam;
		this.jedinica = jedinica;
		this.pomocniRadnikMbr = pomocniRadnikMbr;
	}

	public int getNamID() {
		return namID;
	}

	public void setNamID(int namID) {
		this.namID = namID;
	}

	public String getNazNam() {
		return nazNam;
	}

	public void setNazNam(String nazNam) {
		this.nazNam = nazNam;
	}

	public String getOpisNam() {
		return opisNam;
	}

	public void setOpisNam(String opisNam) {
		this.opisNam = opisNam;
	}

	public String getJedinica() {
		return jedinica;
	}

	public void setJedinica(String jedinica) {
		this.jedinica = jedinica;
	}

	public int getPomocniRadnikMbr() {
		return pomocniRadnikMbr;
	}

	public void setPomocniRadnikMbr(int pomocniRadnikMbr) {
		this.pomocniRadnikMbr = pomocniRadnikMbr;
	}

	@Override
	public String toString() {
		return String.format("%-6d %-25s %-15s %-30s %-6d", 
			namID, nazNam, jedinica, opisNam != null && opisNam.length() > 30 ? opisNam.substring(0, 30) : opisNam != null ? opisNam : "", pomocniRadnikMbr);
	}

	public static String getFormattedHeader() {
		return String.format("%-6s %-25s %-15s %-30s %-6s", 
			"ID", "NAZIV", "JEDINICA", "OPIS", "RADNIK");
	}
}
