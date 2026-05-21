package rs.ac.uns.ftn.db.jdbc.pizzeria.dto;

/**
 * DTO za KOMPLEKSAN UPIT 1:
 * Statistika prodaje artikala po tipovima
 * Tabele: Artikal, Stavka, Porudzbina, Cena, Meni (5 tabela)
 * LEFT OUTER JOIN, GROUP BY, HAVING, ORDER BY
 */
public class ArtikalStatistikaDTO {
	private String tipArtikla;
	private int brojArtikala;
	private int brojProdatih;
	private int ukupnaKolicina;
	private double ukupnaVrednost;
	private double prosecnaCena;
	private double prosecnaKolicina;

	public ArtikalStatistikaDTO() {
		super();
	}

	public ArtikalStatistikaDTO(String tipArtikla, int brojArtikala, int brojProdatih, 
	                            int ukupnaKolicina, double ukupnaVrednost, double prosecnaCena, 
	                            double prosecnaKolicina) {
		this.tipArtikla = tipArtikla;
		this.brojArtikala = brojArtikala;
		this.brojProdatih = brojProdatih;
		this.ukupnaKolicina = ukupnaKolicina;
		this.ukupnaVrednost = ukupnaVrednost;
		this.prosecnaCena = prosecnaCena;
		this.prosecnaKolicina = prosecnaKolicina;
	}

	public String getTipArtikla() {
		return tipArtikla;
	}

	public void setTipArtikla(String tipArtikla) {
		this.tipArtikla = tipArtikla;
	}

	public int getBrojArtikala() {
		return brojArtikala;
	}

	public void setBrojArtikala(int brojArtikala) {
		this.brojArtikala = brojArtikala;
	}

	public int getBrojProdatih() {
		return brojProdatih;
	}

	public void setBrojProdatih(int brojProdatih) {
		this.brojProdatih = brojProdatih;
	}

	public int getUkupnaKolicina() {
		return ukupnaKolicina;
	}

	public void setUkupnaKolicina(int ukupnaKolicina) {
		this.ukupnaKolicina = ukupnaKolicina;
	}

	public double getUkupnaVrednost() {
		return ukupnaVrednost;
	}

	public void setUkupnaVrednost(double ukupnaVrednost) {
		this.ukupnaVrednost = ukupnaVrednost;
	}

	public double getProsecnaCena() {
		return prosecnaCena;
	}

	public void setProsecnaCena(double prosecnaCena) {
		this.prosecnaCena = prosecnaCena;
	}

	public double getProsecnaKolicina() {
		return prosecnaKolicina;
	}

	public void setProsecnaKolicina(double prosecnaKolicina) {
		this.prosecnaKolicina = prosecnaKolicina;
	}

	@Override
	public String toString() {
		return String.format("%-15s %-10d %-10d %-12d %-15.2f %-12.2f %-12.2f", 
			tipArtikla, brojArtikala, brojProdatih, ukupnaKolicina, ukupnaVrednost, 
			prosecnaCena, prosecnaKolicina);
	}

	public static String getFormattedHeader() {
		return String.format("%-15s %-10s %-10s %-12s %-15s %-12s %-12s", 
			"TIP", "BR_ARTIK", "BR_PRODAT", "UKUP_KOL", "UKUP_VREDNOST", "PROSEK_CENA", "PROSEK_KOL");
	}
}
