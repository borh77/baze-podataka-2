package rs.ac.uns.ftn.db.jdbc.pizzeria.ui_handler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import rs.ac.uns.ftn.db.jdbc.pizzeria.model.Porudzbina;
import rs.ac.uns.ftn.db.jdbc.pizzeria.model.Stavka;
import rs.ac.uns.ftn.db.jdbc.pizzeria.service.TransakcijaService;

/**
 * UI Handler za transakcije
 */
public class TransakcijaUIHandler {
	
	private TransakcijaService transakcijaService = new TransakcijaService();
	private Scanner scanner;
	
	public TransakcijaUIHandler(Scanner scanner) {
		this.scanner = scanner;
	}
	
	/**
	 * Prikazuje meni za transakcije
	 */
	public void handleTransakcijaMenu() throws SQLException {
		boolean running = true;
		
		while (running) {
			System.out.println("\n========== TRANSAKCIJE ==========");
			System.out.println("1. Kreiraj novu porudžbinu sa stavkama");
			System.out.println("0. Nazad");
			System.out.print("Izaberite opciju: ");
			
			int choice = scanner.nextInt();
			scanner.nextLine(); // consume newline
			
			switch (choice) {
				case 1:
					kreirajNovaPorudzbina();
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
	 * TRANSAKCIJA:
	 * Kreira novu porudžbinu sa stavkama i računom
	 * INSERT u 3 tabele: Porudzbina, Stavka, Racun
	 */
	private void kreirajNovaPorudzbina() throws SQLException {
		System.out.println("\n========================================");
		System.out.println("KREIRANJE NOVE PORUDŽBINE");
		System.out.println("(TRANSAKCIJA: INSERT u Porudzbina, Stavka, Racun)");
		System.out.println("========================================\n");
		
		try {
			// Unos podataka za porudžbinu
			System.out.print("Unesite ID porudžbine: ");
			int porID = scanner.nextInt();
			scanner.nextLine();
			
			System.out.print("Unesite status (CEKANJE/PRAVI_SE/PREUZETA): ");
			String statusPor = scanner.nextLine().toUpperCase();
			
			System.out.print("Unesite način preuzimanja (DOSTAVA/LICNO_PREUZIMANJE): ");
			String nacPreuz = scanner.nextLine().toUpperCase();
			
			System.out.print("Unesite MBR kasira: ");
			int kasirMbr = scanner.nextInt();
			scanner.nextLine();
			
			System.out.print("Unesite MBM mušterije: ");
			int musterijaMbm = scanner.nextInt();
			scanner.nextLine();
			
			// Unos stavki
			List<Stavka> stavke = new ArrayList<>();
			double ukupnaSuma = 0;
			
			System.out.print("\nKoliko stavki želite da dodate? ");
			int brojStavki = scanner.nextInt();
			scanner.nextLine();
			
			for (int i = 1; i <= brojStavki; i++) {
				System.out.println("\n--- Stavka " + i + " ---");
				
				System.out.print("Unesite ID stavke: ");
				int stvID = scanner.nextInt();
				scanner.nextLine();
				
				System.out.print("Unesite količinu: ");
				int kolStv = scanner.nextInt();
				scanner.nextLine();
				
				System.out.print("Unesite MBR pica majstora: ");
				int picaMajstorMbr = scanner.nextInt();
				scanner.nextLine();
				
				System.out.print("Unesite šifru artikla: ");
				int artikalSifArt = scanner.nextInt();
				scanner.nextLine();
				
				System.out.print("Unesite cenu po komadu: ");
				double cenaPoKomadu = scanner.nextDouble();
				scanner.nextLine();
				
				Stavka stavka = new Stavka();
				stavka.setStvID(stvID);
				stavka.setKolStv(kolStv);
				stavka.setPorudzbinaPorID(porID);
				stavka.setPicaMajstorMbr(picaMajstorMbr);
				stavka.setArtikalSifArt(artikalSifArt);
				
				stavke.add(stavka);
				ukupnaSuma += kolStv * cenaPoKomadu;
			}
			
			// Unos načina plaćanja
			System.out.print("\nUnesite način plaćanja (GOTOVINA/PLATNA_KARITCA/PRENOS_NA_RACUN): ");
			String nacPl = scanner.nextLine().toUpperCase();
			
			// Kreiranje porudžbine
			Porudzbina porudzbina = new Porudzbina();
			porudzbina.setPorID(porID);
			porudzbina.setDatVrPor(new Date()); // Trenutno vreme
			porudzbina.setStatusPor(statusPor);
			porudzbina.setSuma(ukupnaSuma);
			porudzbina.setNacPreuz(nacPreuz);
			porudzbina.setKasirMbr(kasirMbr);
			porudzbina.setMusterijaMbm(musterijaMbm);
			
			// Prikaz sažetka
			System.out.println("\n========================================");
			System.out.println("SAŽETAK PORUDŽBINE:");
			System.out.println("========================================");
			System.out.println("ID Porudžbine: " + porID);
			System.out.println("Status: " + statusPor);
			System.out.println("Način preuzimanja: " + nacPreuz);
			System.out.println("Kasir MBR: " + kasirMbr);
			System.out.println("Mušterija MBM: " + musterijaMbm);
			System.out.println("Broj stavki: " + stavke.size());
			System.out.println("Ukupna suma: " + String.format("%.2f", ukupnaSuma) + " RSD");
			System.out.println("Način plaćanja: " + nacPl);
			System.out.println("========================================");
			
			System.out.print("\nDa li želite da potvrdite porudžbinu? (da/ne): ");
			String potvrda = scanner.nextLine().toLowerCase();
			
			if ("da".equals(potvrda)) {
				// Izvrši transakciju
				boolean uspeh = transakcijaService.napraviPorudzbinuSaStavkama(porudzbina, stavke, nacPl);
				
				if (uspeh) {
					System.out.println("\n✅ USPEŠNO! Porudžbina je kreirana.");
					System.out.println("   - Porudžbina ID: " + porID);
					System.out.println("   - Broj stavki: " + stavke.size());
					System.out.println("   - Ukupna suma: " + String.format("%.2f", ukupnaSuma) + " RSD");
					
					if ("PREUZETA".equals(statusPor)) {
						System.out.println("   - Račun ID: " + porID + " (kreiran)");
					}
				} else {
					System.out.println("\n❌ GREŠKA! Porudžbina nije kreirana.");
				}
			} else {
				System.out.println("\n❌ Porudžbina je otkazana.");
			}
			
		} catch (Exception e) {
			System.err.println("\n❌ GREŠKA prilikom kreiranja porudžbine!");
			System.err.println("Razlog: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
