package rs.ac.uns.ftn.db.jdbc.pizzeria.model;

public class Musterija {
	private int mbm;
	private String imem;
	private String przm;
	private String telm;
	private String emailm;
	private String adrm;

	public Musterija() {
		super();
	}

	public Musterija(int mbm, String imem, String przm, String telm, String emailm, String adrm) {
		this.mbm = mbm;
		this.imem = imem;
		this.przm = przm;
		this.telm = telm;
		this.emailm = emailm;
		this.adrm = adrm;
	}

	public int getMbm() {
		return mbm;
	}

	public void setMbm(int mbm) {
		this.mbm = mbm;
	}

	public String getImem() {
		return imem;
	}

	public void setImem(String imem) {
		this.imem = imem;
	}

	public String getPrzm() {
		return przm;
	}

	public void setPrzm(String przm) {
		this.przm = przm;
	}

	public String getTelm() {
		return telm;
	}

	public void setTelm(String telm) {
		this.telm = telm;
	}

	public String getEmailm() {
		return emailm;
	}

	public void setEmailm(String emailm) {
		this.emailm = emailm;
	}

	public String getAdrm() {
		return adrm;
	}

	public void setAdrm(String adrm) {
		this.adrm = adrm;
	}

	@Override
	public String toString() {
		return String.format("%-6d %-15s %-15s %-15s %-25s %-40s", 
			mbm, imem, przm, telm, emailm != null ? emailm : "", adrm);
	}

	public static String getFormattedHeader() {
		return String.format("%-6s %-15s %-15s %-15s %-25s %-40s", 
			"MBM", "IME", "PREZIME", "TELEFON", "EMAIL", "ADRESA");
	}
}
