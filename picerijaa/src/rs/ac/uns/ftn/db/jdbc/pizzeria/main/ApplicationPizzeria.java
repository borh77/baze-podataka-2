package rs.ac.uns.ftn.db.jdbc.pizzeria.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import rs.ac.uns.ftn.db.jdbc.pizzeria.connection.ConnectionUtil_HikariCP;
import rs.ac.uns.ftn.db.jdbc.pizzeria.model.Artikal;
import rs.ac.uns.ftn.db.jdbc.pizzeria.model.Radnik;
import rs.ac.uns.ftn.db.jdbc.pizzeria.service.ArtikalService;
import rs.ac.uns.ftn.db.jdbc.pizzeria.service.RadnikService;
import rs.ac.uns.ftn.db.jdbc.pizzeria.ui_handler.IzvestajUIHandler;
import rs.ac.uns.ftn.db.jdbc.pizzeria.ui_handler.TransakcijaUIHandler;

public class ApplicationPizzeria {

	private static RadnikService radnikService = new RadnikService();
	private static ArtikalService artikalService = new ArtikalService();
	private static Scanner scanner = new Scanner(System.in);
	private static IzvestajUIHandler izvestajUIHandler = new IzvestajUIHandler(scanner);
	private static TransakcijaUIHandler transakcijaUIHandler = new TransakcijaUIHandler(scanner);

	public static void main(String[] args) {
		System.out.println("===========================================");
		System.out.println("  DOBRODOSLI U PIZZERIA APLIKACIJU");
		System.out.println("===========================================\n");

		boolean running = true;
		while (running) {
			printMainMenu();
			int choice = scanner.nextInt();
			scanner.nextLine(); // consume newline

			try {
				switch (choice) {
					case 1:
						handleRadniciMenu();
						break;
					case 2:
						handleArtikliMenu();
						break;
					case 3:
						// IZVESTAJI I STATISTIKA - Kompleksni upiti
						izvestajUIHandler.handleIzvestajMenu();
						break;
					case 4:
						// TRANSAKCIJE - Kreiranje porudzbine
						transakcijaUIHandler.handleTransakcijaMenu();
						break;
					case 0:
						running = false;
						System.out.println("Izlazak iz aplikacije...");
						break;
					default:
						System.out.println("Nevalidan izbor. Pokusajte ponovo.");
				}
			} catch (SQLException e) {
				System.err.println("Greska u bazi podataka: " + e.getMessage());
				e.printStackTrace();
			}
		}

		ConnectionUtil_HikariCP.closeDataSource();
		scanner.close();
		System.out.println("Aplikacija zavrsena.");
	}

	private static void printMainMenu() {
		System.out.println("\n========== GLAVNI MENI ==========");
		System.out.println("1. Radnici");
		System.out.println("2. Artikli");
		System.out.println("3. Izvestaji i Statistika ");
		System.out.println("4. Transakcije (Nove porudzbine)");
		System.out.println("0. Izlaz");
		System.out.print("Izaberite opciju: ");
	}

	private static void handleRadniciMenu() throws SQLException {
		System.out.println("\n========== RADNICI MENI ==========");
		System.out.println("1. Prikazi sve radnike");
		System.out.println("2. Pronadji radnika po ID-ju");
		System.out.println("3. Prikazi radnike po tipu");
		System.out.println("0. Nazad");
		System.out.print("Izaberite opciju: ");

		int choice = scanner.nextInt();
		scanner.nextLine(); // consume newline

		switch (choice) {
			case 1:
				List<Radnik> radnici = radnikService.getAllRadnici();
				System.out.println("\n" + Radnik.getFormattedHeader());
				System.out.println("=".repeat(120));
				for (Radnik r : radnici) {
					System.out.println(r);
				}
				break;
			case 2:
				System.out.print("Unesite MBR radnika: ");
				int mbr = scanner.nextInt();
				scanner.nextLine();
				Radnik radnik = radnikService.getRadnikById(mbr);
				if (radnik != null) {
					System.out.println("\n" + Radnik.getFormattedHeader());
					System.out.println("=".repeat(120));
					System.out.println(radnik);
				} else {
					System.out.println("Radnik sa MBR " + mbr + " nije pronadjen.");
				}
				break;
			case 3:
				System.out.print("Unesite tip radnika (KASIR/PICA_MAJSTOR/POMOCNI_RADNIK): ");
				String tip = scanner.nextLine();
				List<Radnik> radniciPoTipu = radnikService.getRadniciByType(tip);
				System.out.println("\n" + Radnik.getFormattedHeader());
				System.out.println("=".repeat(120));
				for (Radnik r : radniciPoTipu) {
					System.out.println(r);
				}
				break;
			case 0:
				break;
			default:
				System.out.println("Nevalidan izbor.");
		}
	}

	private static void handleArtikliMenu() throws SQLException {
		System.out.println("\n========== ARTIKLI MENI ==========");
		System.out.println("1. Prikazi sve artikle");
		System.out.println("2. Pronadji artikal po sifri");
		System.out.println("3. Prikazi artikle po tipu");
		System.out.println("0. Nazad");
		System.out.print("Izaberite opciju: ");

		int choice = scanner.nextInt();
		scanner.nextLine(); // consume newline

		switch (choice) {
			case 1:
				List<Artikal> artikli = artikalService.getAllArtikli();
				System.out.println("\n" + Artikal.getFormattedHeader());
				System.out.println("=".repeat(120));
				for (Artikal a : artikli) {
					System.out.println(a);
				}
				break;
			case 2:
				System.out.print("Unesite sifru artikla: ");
				int sif = scanner.nextInt();
				scanner.nextLine();
				Artikal artikal = artikalService.getArtikalById(sif);
				if (artikal != null) {
					System.out.println("\n" + Artikal.getFormattedHeader());
					System.out.println("=".repeat(120));
					System.out.println(artikal);
				} else {
					System.out.println("Artikal sa sifrom " + sif + " nije pronadjen.");
				}
				break;
			case 3:
				System.out.print("Unesite tip artikla: ");
				String tip = scanner.nextLine();
				List<Artikal> artikliPoTipu = artikalService.getArtikliByType(tip);
				System.out.println("\n" + Artikal.getFormattedHeader());
				System.out.println("=".repeat(120));
				for (Artikal a : artikliPoTipu) {
					System.out.println(a);
				}
				break;
			case 0:
				break;
			default:
				System.out.println("Nevalidan izbor.");
		}
	}
}
