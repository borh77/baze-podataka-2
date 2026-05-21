package rs.ac.uns.ftn.db.jdbc.pizzeria.model;

public class Artikal {
	private int sifArt;
	private String opisArt;
	private String nazivArt;
	private String tipArt;
	private String velArt;

	public Artikal() {
		super();
	}

	public Artikal(int sifArt, String opisArt, String nazivArt, String tipArt, String velArt) {
		this.sifArt = sifArt;
		this.opisArt = opisArt;
		this.nazivArt = nazivArt;
		this.tipArt = tipArt;
		this.velArt = velArt;
	}

	public int getSifArt() {
		return sifArt;
	}

	public void setSifArt(int sifArt) {
		this.sifArt = sifArt;
	}

	public String getOpisArt() {
		return opisArt;
	}

	public void setOpisArt(String opisArt) {
		this.opisArt = opisArt;
	}

	public String getNazivArt() {
		return nazivArt;
	}

	public void setNazivArt(String nazivArt) {
		this.nazivArt = nazivArt;
	}

	public String getTipArt() {
		return tipArt;
	}

	public void setTipArt(String tipArt) {
		this.tipArt = tipArt;
	}

	public String getVelArt() {
		return velArt;
	}

	public void setVelArt(String velArt) {
		this.velArt = velArt;
	}

	@Override
	public String toString() {
		return String.format("%-6d %-25s %-20s %-15s %-30s", 
			sifArt, nazivArt, tipArt, velArt, opisArt != null && opisArt.length() > 30 ? opisArt.substring(0, 30) : opisArt != null ? opisArt : "");
	}

	public static String getFormattedHeader() {
		return String.format("%-6s %-25s %-20s %-15s %-30s", 
			"SIFRA", "NAZIV", "TIP", "VELICINA", "OPIS");
	}
}
