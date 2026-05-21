package rs.ac.uns.ftn.db.jdbc.pizzeria.model;

public class Lokal {
	private int lokID;
	private String nazl;
	private String tell;
	private int pib;
	private int kvad;
	private String adrl;

	public Lokal() {
		super();
	}

	public Lokal(int lokID, String nazl, String tell, int pib, int kvad, String adrl) {
		this.lokID = lokID;
		this.nazl = nazl;
		this.tell = tell;
		this.pib = pib;
		this.kvad = kvad;
		this.adrl = adrl;
	}

	public int getLokID() {
		return lokID;
	}

	public void setLokID(int lokID) {
		this.lokID = lokID;
	}

	public String getNazl() {
		return nazl;
	}

	public void setNazl(String nazl) {
		this.nazl = nazl;
	}

	public String getTell() {
		return tell;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	public int getPib() {
		return pib;
	}

	public void setPib(int pib) {
		this.pib = pib;
	}

	public int getKvad() {
		return kvad;
	}

	public void setKvad(int kvad) {
		this.kvad = kvad;
	}

	public String getAdrl() {
		return adrl;
	}

	public void setAdrl(String adrl) {
		this.adrl = adrl;
	}

	@Override
	public String toString() {
		return String.format("%-6d %-25s %-15s %-12d %-8d %-40s", 
			lokID, nazl, tell, pib, kvad, adrl);
	}

	public static String getFormattedHeader() {
		return String.format("%-6s %-25s %-15s %-12s %-8s %-40s", 
			"ID", "NAZIV", "TELEFON", "PIB", "KVADRAT", "ADRESA");
	}
}
