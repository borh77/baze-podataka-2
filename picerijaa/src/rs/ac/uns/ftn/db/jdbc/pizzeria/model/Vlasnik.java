package rs.ac.uns.ftn.db.jdbc.pizzeria.model;

public class Vlasnik {
	private int mbv;
	private String imev;
	private String przv;
	private String telv;
	private String emailv;

	public Vlasnik() {
		super();
	}

	public Vlasnik(int mbv, String imev, String przv, String telv, String emailv) {
		this.mbv = mbv;
		this.imev = imev;
		this.przv = przv;
		this.telv = telv;
		this.emailv = emailv;
	}

	public int getMbv() {
		return mbv;
	}

	public void setMbv(int mbv) {
		this.mbv = mbv;
	}

	public String getImev() {
		return imev;
	}

	public void setImev(String imev) {
		this.imev = imev;
	}

	public String getPrzv() {
		return przv;
	}

	public void setPrzv(String przv) {
		this.przv = przv;
	}

	public String getTelv() {
		return telv;
	}

	public void setTelv(String telv) {
		this.telv = telv;
	}

	public String getEmailv() {
		return emailv;
	}

	public void setEmailv(String emailv) {
		this.emailv = emailv;
	}

	@Override
	public String toString() {
		return String.format("%-6d %-15s %-15s %-15s %-25s", 
			mbv, imev, przv, telv, emailv != null ? emailv : "");
	}

	public static String getFormattedHeader() {
		return String.format("%-6s %-15s %-15s %-15s %-25s", 
			"MBV", "IME", "PREZIME", "TELEFON", "EMAIL");
	}
}
