package rs.ac.uns.ftn.db.jdbc.pizzeria.dto;

/**
 * DTO za KOMPLEKSAN UPIT 2:
 * Statistika pica majstora sa priremljenim picama
 * Tabele: Radnik, Pica_Majstor, Stavka, Porudzbina, Zaposljava, Lokal (5 tabela)
 * LEFT OUTER JOIN, GROUP BY, ORDER BY
 */
public class PicaMajstorStatistikaDTO {
	private int mbrRadnika;
	private String imeRadnika;
	private String prezimeRadnika;
	private int godineIskustva;
	private String zvanje;
	private String nazivLokala;
	private int brojPripremljenih;
	private int ukupnaKolicina;
	private double prosecnaKolicina;

	public PicaMajstorStatistikaDTO() {
		super();
	}

	public PicaMajstorStatistikaDTO(int mbrRadnika, String imeRadnika, String prezimeRadnika, 
	                                int godineIskustva, String zvanje, String nazivLokala, 
	                                int brojPripremljenih, int ukupnaKolicina, double prosecnaKolicina) {
		this.mbrRadnika = mbrRadnika;
		this.imeRadnika = imeRadnika;
		this.prezimeRadnika = prezimeRadnika;
		this.godineIskustva = godineIskustva;
		this.zvanje = zvanje;
		this.nazivLokala = nazivLokala;
		this.brojPripremljenih = brojPripremljenih;
		this.ukupnaKolicina = ukupnaKolicina;
		this.prosecnaKolicina = prosecnaKolicina;
	}

	public int getMbrRadnika() {
		return mbrRadnika;
	}

	public void setMbrRadnika(int mbrRadnika) {
		this.mbrRadnika = mbrRadnika;
	}

	public String getImeRadnika() {
		return imeRadnika;
	}

	public void setImeRadnika(String imeRadnika) {
		this.imeRadnika = imeRadnika;
	}

	public String getPrezimeRadnika() {
		return prezimeRadnika;
	}

	public void setPrezimeRadnika(String prezimeRadnika) {
		this.prezimeRadnika = prezimeRadnika;
	}

	public int getGodineIskustva() {
		return godineIskustva;
	}

	public void setGodineIskustva(int godineIskustva) {
		this.godineIskustva = godineIskustva;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public String getNazivLokala() {
		return nazivLokala;
	}

	public void setNazivLokala(String nazivLokala) {
		this.nazivLokala = nazivLokala;
	}

	public int getBrojPripremljenih() {
		return brojPripremljenih;
	}

	public void setBrojPripremljenih(int brojPripremljenih) {
		this.brojPripremljenih = brojPripremljenih;
	}

	public int getUkupnaKolicina() {
		return ukupnaKolicina;
	}

	public void setUkupnaKolicina(int ukupnaKolicina) {
		this.ukupnaKolicina = ukupnaKolicina;
	}

	public double getProsecnaKolicina() {
		return prosecnaKolicina;
	}

	public void setProsecnaKolicina(double prosecnaKolicina) {
		this.prosecnaKolicina = prosecnaKolicina;
	}

	@Override
	public String toString() {
		return String.format("%-6d %-15s %-15s %-6d %-20s %-30s %-10d %-10d %-10.2f", 
			mbrRadnika, imeRadnika, prezimeRadnika, godineIskustva, zvanje, nazivLokala, 
			brojPripremljenih, ukupnaKolicina, prosecnaKolicina);
	}

	public static String getFormattedHeader() {
		return String.format("%-6s %-15s %-15s %-6s %-20s %-30s %-10s %-10s %-10s", 
			"MBR", "IME", "PREZIME", "GOD_ISK", "ZVANJE", "LOKAL", "BR_PRIPR", "UKUP_KOL", "PROSEK");
	}
}
