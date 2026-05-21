package rs.ac.uns.ftn.db.jdbc.pizzeria.ui_handler;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import rs.ac.uns.ftn.db.jdbc.pizzeria.dto.ArtikalStatistikaDTO;
import rs.ac.uns.ftn.db.jdbc.pizzeria.dto.LokalStatistikaDTO;
import rs.ac.uns.ftn.db.jdbc.pizzeria.dto.PicaMajstorStatistikaDTO;
import rs.ac.uns.ftn.db.jdbc.pizzeria.service.IzvestajService;

/**
 * UI Handler za izveštaje i kompleksne upite
 */
public class IzvestajUIHandler {
	
	private IzvestajService izvestajService = new IzvestajService();
	private Scanner scanner;
	
	public IzvestajUIHandler(Scanner scanner) {
		this.scanner = scanner;
	}
	
	/**
	 * Prikazuje meni za izveštaje
	 */
	public void handleIzvestajMenu() throws SQLException {
		boolean running = true;
		
		while (running) {
			System.out.println("\n========== IZVESTAJI I STATISTIKA ==========");
			System.out.println("1. Statistika porudžbina po lokalu");
			System.out.println("2. Statistika prodaje artikala");
			System.out.println("3. Statistika pica majstora");
			System.out.println("0. Nazad");
			System.out.print("Izaberite opciju: ");
			
			int choice = scanner.nextInt();
			scanner.nextLine(); // consume newline
			
			switch (choice) {
				case 1:
					prikaziStatistikuPoLokalu();
					break;
				case 2:
					prikaziStatistikuArtikala();
					break;
				case 3:
					prikaziStatistikuPicaMajstora();
					break;
				case 0:
					running = false;
					break;
				default:
					System.out.println("Nevalidan izbor. Pokušajte ponovo.");
			}
		}
	}
	
	/**
	 * JEDNOSTAVAN UPIT:
	 * Prikazuje statistiku porudžbina po lokalu
	 */
	private void prikaziStatistikuPoLokalu() throws SQLException {
		System.out.println("\n========================================");
		System.out.println("STATISTIKA PORUDŽBINA PO LOKALU");
		System.out.println("========================================\n");
		
		List<LokalStatistikaDTO> statistika = izvestajService.getStatistikaPoLokalu();
		
		if (statistika.isEmpty()) {
			System.out.println("Nema podataka za prikaz.");
			return;
		}
		
		System.out.println(LokalStatistikaDTO.getFormattedHeader());
		System.out.println("=".repeat(140));
		
		for (LokalStatistikaDTO dto : statistika) {
			System.out.println(dto);
		}
		
		System.out.println("\nUkupno lokala: " + statistika.size());
	}
	
	/**
	 * KOMPLEKSAN UPIT 1:
	 * Prikazuje statistiku prodaje artikala po tipovima
	 */
	private void prikaziStatistikuArtikala() throws SQLException {
		System.out.println("\n========================================");
		System.out.println("STATISTIKA PRODAJE ARTIKALA PO TIPOVIMA");
		System.out.println("========================================\n");
		
		List<ArtikalStatistikaDTO> statistika = izvestajService.getStatistikaProdajeArtikala();
		
		if (statistika.isEmpty()) {
			System.out.println("Nema podataka za prikaz.");
			return;
		}
		
		System.out.println(ArtikalStatistikaDTO.getFormattedHeader());
		System.out.println("=".repeat(120));
		
		double ukupnaVrednostSvega = 0;
		int ukupnaKolicinaSvega = 0;
		
		for (ArtikalStatistikaDTO dto : statistika) {
			System.out.println(dto);
			ukupnaVrednostSvega += dto.getUkupnaVrednost();
			ukupnaKolicinaSvega += dto.getUkupnaKolicina();
		}
		
		System.out.println("=".repeat(120));
		System.out.println("UKUPNO SVIH TIPOVA:");
		System.out.println("  - Ukupna vrednost: " + String.format("%.2f", ukupnaVrednostSvega) + " RSD");
		System.out.println("  - Ukupna količina: " + ukupnaKolicinaSvega + " komada");
		System.out.println("  - Broj tipova: " + statistika.size());
	}
	
	/**
	 * KOMPLEKSAN UPIT 2:
	 * Prikazuje statistiku pica majstora sa priremljenim picama
	 */
	private void prikaziStatistikuPicaMajstora() throws SQLException {
		System.out.println("\n========================================");
		System.out.println("STATISTIKA PICA MAJSTORA");
		System.out.println("(Spoj: Radnik, Pica_Majstor, Stavka, Porudzbina, Zaposljava, Lokal)");
		System.out.println("========================================\n");
		
		List<PicaMajstorStatistikaDTO> statistika = izvestajService.getStatistikaPicaMajstora();
		
		if (statistika.isEmpty()) {
			System.out.println("Nema podataka za prikaz.");
			return;
		}
		
		System.out.println(PicaMajstorStatistikaDTO.getFormattedHeader());
		System.out.println("=".repeat(140));
		
		int ukupnoPripremljenih = 0;
		int ukupnaKolicina = 0;
		
		for (PicaMajstorStatistikaDTO dto : statistika) {
			System.out.println(dto);
			ukupnoPripremljenih += dto.getBrojPripremljenih();
			ukupnaKolicina += dto.getUkupnaKolicina();
		}
		
		System.out.println("=".repeat(140));
		System.out.println("UKUPNO SVIH MAJSTORA:");
		System.out.println("  - Ukupno pripremljenih stavki: " + ukupnoPripremljenih);
		System.out.println("  - Ukupna količina artikala: " + ukupnaKolicina + " komada");
		System.out.println("  - Broj majstora: " + statistika.size());
	}
}
