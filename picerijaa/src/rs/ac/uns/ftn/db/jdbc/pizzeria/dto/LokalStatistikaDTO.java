package rs.ac.uns.ftn.db.jdbc.pizzeria.dto;

/**
 * DTO za JEDNOSTAVAN UPIT:
 * Statistika porudžbina po lokalu (spoj Lokal, Zaposljava, Porudzbina)
 * Agregacije: COUNT, SUM, AVG
 */
public class LokalStatistikaDTO {
	private int lokalID;
	private String nazivLokala;
	private String adresaLokala;
	private int brojPorudzbina;
	private double ukupanPromet;
	private double prosecnaVrednost;

	public LokalStatistikaDTO() {
		super();
	}

	public LokalStatistikaDTO(int lokalID, String nazivLokala, String adresaLokala, 
	                          int brojPorudzbina, double ukupanPromet, double prosecnaVrednost) {
		this.lokalID = lokalID;
		this.nazivLokala = nazivLokala;
		this.adresaLokala = adresaLokala;
		this.brojPorudzbina = brojPorudzbina;
		this.ukupanPromet = ukupanPromet;
		this.prosecnaVrednost = prosecnaVrednost;
	}

	public int getLokalID() {
		return lokalID;
	}

	public void setLokalID(int lokalID) {
		this.lokalID = lokalID;
	}

	public String getNazivLokala() {
		return nazivLokala;
	}

	public void setNazivLokala(String nazivLokala) {
		this.nazivLokala = nazivLokala;
	}

	public String getAdresaLokala() {
		return adresaLokala;
	}

	public void setAdresaLokala(String adresaLokala) {
		this.adresaLokala = adresaLokala;
	}

	public int getBrojPorudzbina() {
		return brojPorudzbina;
	}

	public void setBrojPorudzbina(int brojPorudzbina) {
		this.brojPorudzbina = brojPorudzbina;
	}

	public double getUkupanPromet() {
		return ukupanPromet;
	}

	public void setUkupanPromet(double ukupanPromet) {
		this.ukupanPromet = ukupanPromet;
	}

	public double getProsecnaVrednost() {
		return prosecnaVrednost;
	}

	public void setProsecnaVrednost(double prosecnaVrednost) {
		this.prosecnaVrednost = prosecnaVrednost;
	}

	@Override
	public String toString() {
		return String.format("%-6d %-30s %-40s %-10d %-15.2f %-15.2f", 
			lokalID, nazivLokala, adresaLokala, brojPorudzbina, ukupanPromet, prosecnaVrednost);
	}

	public static String getFormattedHeader() {
		return String.format("%-6s %-30s %-40s %-10s %-15s %-15s", 
			"ID", "NAZIV LOKALA", "ADRESA", "BR_POR", "UKUPAN_PROMET", "PROSEK_VREDNOST");
	}
}
