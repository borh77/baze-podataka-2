SET DEFINE OFF;

-- ============================================
-- 2. LOKAL
-- ============================================
INSERT INTO Lokal (LokID, Nazl, Tell, PIB, Kvad, Adrl) VALUES (1, 'Pizzeria Bella Napoli', '0113456789', 123456789, 150, 'Knez Mihailova 25, Beograd');
INSERT INTO Lokal (LokID, Nazl, Tell, PIB, Kvad, Adrl) VALUES (2, 'Pizzeria Sole Mio', '0213456789', 987654321, 120, 'Zmaj Jovina 15, Novi Sad');
INSERT INTO Lokal (LokID, Nazl, Tell, PIB, Kvad, Adrl) VALUES (3, 'Pizzeria Roma', '0183456789', 456789123, 100, 'Glavna 50, Nis');
INSERT INTO Lokal (LokID, Nazl, Tell, PIB, Kvad, Adrl) VALUES (4, 'Pizzeria Venezia', '0343456789', 321654987, 80, 'Kralja Petra 10, Kragujevac');


-- ============================================
-- 4. RADNIK
-- ============================================
INSERT INTO Radnik (Mbr, Imer, Przr, Datr, Emailr, Telr, DatSan, Tipr, Radnik_Mbr) 
VALUES (1, 'Petar', 'Petrovic', TO_DATE('1985-03-15', 'YYYY-MM-DD'), 'petar.petrovic@pizzeria.rs', '0651234567', TO_DATE('2015-01-10', 'YYYY-MM-DD'), 'KASIR', NULL);
INSERT INTO Radnik (Mbr, Imer, Przr, Datr, Emailr, Telr, DatSan, Tipr, Radnik_Mbr) 
VALUES (2, 'Jovana', 'Nikolic', TO_DATE('1990-07-22', 'YYYY-MM-DD'), 'jovana.nikolic@pizzeria.rs', '0652345678', TO_DATE('2016-03-20', 'YYYY-MM-DD'), 'PICA_MAJSTOR', NULL);
INSERT INTO Radnik (Mbr, Imer, Przr, Datr, Emailr, Telr, DatSan, Tipr, Radnik_Mbr) 
VALUES (3, 'Milan', 'Jovanovic', TO_DATE('1992-11-05', 'YYYY-MM-DD'), 'milan.jovanovic@pizzeria.rs', '0653456789', TO_DATE('2017-05-15', 'YYYY-MM-DD'), 'POMOCNI_RADNIK', NULL);
INSERT INTO Radnik (Mbr, Imer, Przr, Datr, Emailr, Telr, DatSan, Tipr, Radnik_Mbr) 
VALUES (4, 'Marija', 'Ilic', TO_DATE('1995-04-12', 'YYYY-MM-DD'), 'marija.ilic@pizzeria.rs', '0654567890', TO_DATE('2018-08-01', 'YYYY-MM-DD'), 'KASIR', 1);
INSERT INTO Radnik (Mbr, Imer, Przr, Datr, Emailr, Telr, DatSan, Tipr, Radnik_Mbr) 
VALUES (5, 'Stefan', 'Markovic', TO_DATE('1988-09-18', 'YYYY-MM-DD'), 'stefan.markovic@pizzeria.rs', '0655678901', TO_DATE('2016-06-10', 'YYYY-MM-DD'), 'PICA_MAJSTOR', 2);
INSERT INTO Radnik (Mbr, Imer, Przr, Datr, Emailr, Telr, DatSan, Tipr, Radnik_Mbr) 
VALUES (6, 'Teodora', 'Djordjevic', TO_DATE('1993-12-25', 'YYYY-MM-DD'), 'teodora.djordjevic@pizzeria.rs', '0656789012', TO_DATE('2019-02-14', 'YYYY-MM-DD'), 'PICA_MAJSTOR', 2);
INSERT INTO Radnik (Mbr, Imer, Przr, Datr, Emailr, Telr, DatSan, Tipr, Radnik_Mbr) 
VALUES (7, 'Nemanja', 'Popovic', TO_DATE('1997-06-08', 'YYYY-MM-DD'), 'nemanja.popovic@pizzeria.rs', '0657890123', TO_DATE('2020-04-05', 'YYYY-MM-DD'), 'POMOCNI_RADNIK', 3);
INSERT INTO Radnik (Mbr, Imer, Przr, Datr, Emailr, Telr, DatSan, Tipr, Radnik_Mbr) 
VALUES (8, 'Jelena', 'Stojanovic', TO_DATE('1996-08-30', 'YYYY-MM-DD'), 'jelena.stojanovic@pizzeria.rs', '0658901234', TO_DATE('2020-09-12', 'YYYY-MM-DD'), 'POMOCNI_RADNIK', 3);
INSERT INTO Radnik (Mbr, Imer, Przr, Datr, Emailr, Telr, DatSan, Tipr, Radnik_Mbr) 
VALUES (9, 'Luka', 'Dimitrijevic', TO_DATE('1991-02-14', 'YYYY-MM-DD'), 'luka.dimitrijevic@pizzeria.rs', '0659012345', TO_DATE('2017-11-20', 'YYYY-MM-DD'), 'KASIR', 1);
INSERT INTO Radnik (Mbr, Imer, Przr, Datr, Emailr, Telr, DatSan, Tipr, Radnik_Mbr) 
VALUES (10, 'Tijana', 'Pavlovic', TO_DATE('1994-05-20', 'YYYY-MM-DD'), 'tijana.pavlovic@pizzeria.rs', '0650123456', TO_DATE('2019-07-08', 'YYYY-MM-DD'), 'PICA_MAJSTOR', 2);

-- ============================================
-- 5, 6, 7. KASIR, PICA_MAJSTOR, POMOCNI
-- ============================================
INSERT INTO Kasir (Mbr) VALUES (1);
INSERT INTO Kasir (Mbr) VALUES (4);
INSERT INTO Kasir (Mbr) VALUES (9);

INSERT INTO Pica_Majstor (Mbr, GodIsk, Zvanje) VALUES (2, 10, 'Glavni majstor');
INSERT INTO Pica_Majstor (Mbr, GodIsk, Zvanje) VALUES (5, 8, 'Majstor');
INSERT INTO Pica_Majstor (Mbr, GodIsk, Zvanje) VALUES (6, 5, 'Pomocni majstor');
INSERT INTO Pica_Majstor (Mbr, GodIsk, Zvanje) VALUES (10, 6, 'Majstor');

INSERT INTO Pomocni_Radnik (Mbr) VALUES (3);
INSERT INTO Pomocni_Radnik (Mbr) VALUES (7);
INSERT INTO Pomocni_Radnik (Mbr) VALUES (8);

-- ============================================
-- 8. ZAPOSLJAVA (Sada ima sve obavezne kolone)
-- ============================================
INSERT INTO Zaposljava (Zaposljava_ID, Radnik_Mbr, Lokal_LokID, DatZap, Pozicija) VALUES (1, 1, 1, TO_DATE('2024-01-01', 'YYYY-MM-DD'), 'KASIR');
INSERT INTO Zaposljava (Zaposljava_ID, Radnik_Mbr, Lokal_LokID, DatZap, Pozicija) VALUES (2, 2, 1, TO_DATE('2024-01-01', 'YYYY-MM-DD'), 'PICA_MAJSTOR');
INSERT INTO Zaposljava (Zaposljava_ID, Radnik_Mbr, Lokal_LokID, DatZap, Pozicija) VALUES (3, 3, 1, TO_DATE('2024-02-01', 'YYYY-MM-DD'), 'POMOCNI_RADNIK');
INSERT INTO Zaposljava (Zaposljava_ID, Radnik_Mbr, Lokal_LokID, DatZap, Pozicija) VALUES (4, 4, 2, TO_DATE('2024-02-01', 'YYYY-MM-DD'), 'KASIR');
INSERT INTO Zaposljava (Zaposljava_ID, Radnik_Mbr, Lokal_LokID, DatZap, Pozicija) VALUES (5, 5, 2, TO_DATE('2024-03-01', 'YYYY-MM-DD'), 'PICA_MAJSTOR');
INSERT INTO Zaposljava (Zaposljava_ID, Radnik_Mbr, Lokal_LokID, DatZap, Pozicija) VALUES (6, 6, 3, TO_DATE('2024-03-01', 'YYYY-MM-DD'), 'PICA_MAJSTOR');
INSERT INTO Zaposljava (Zaposljava_ID, Radnik_Mbr, Lokal_LokID, DatZap, Pozicija) VALUES (7, 7, 3, TO_DATE('2024-04-01', 'YYYY-MM-DD'), 'POMOCNI_RADNIK');
INSERT INTO Zaposljava (Zaposljava_ID, Radnik_Mbr, Lokal_LokID, DatZap, Pozicija) VALUES (8, 8, 4, TO_DATE('2024-04-01', 'YYYY-MM-DD'), 'POMOCNI_RADNIK');
INSERT INTO Zaposljava (Zaposljava_ID, Radnik_Mbr, Lokal_LokID, DatZap, Pozicija) VALUES (9, 9, 4, TO_DATE('2024-05-01', 'YYYY-MM-DD'), 'KASIR');
INSERT INTO Zaposljava (Zaposljava_ID, Radnik_Mbr, Lokal_LokID, DatZap, Pozicija) VALUES (10, 10, 2, TO_DATE('2024-05-01', 'YYYY-MM-DD'), 'PICA_MAJSTOR');

-- ============================================
-- 9. NABAVKA (Povezano na Zaposljava_ID)
-- ============================================
INSERT INTO Nabavka (NabID, DatNab, IznosNab, StatusNab, Zaposljava_Zaposljava_ID) 
VALUES (1, TO_DATE('2026-01-15', 'YYYY-MM-DD'), 45000.00, 'KOMPLETIRANA', 1);
INSERT INTO Nabavka (NabID, DatNab, IznosNab, StatusNab, Zaposljava_Zaposljava_ID) 
VALUES (2, TO_DATE('2026-01-20', 'YYYY-MM-DD'), 38000.00, 'KOMPLETIRANA', 2);
INSERT INTO Nabavka (NabID, DatNab, IznosNab, StatusNab, Zaposljava_Zaposljava_ID) 
VALUES (3, TO_DATE('2026-02-01', 'YYYY-MM-DD'), 52000.00, 'U_TOKU', 3);
INSERT INTO Nabavka (NabID, DatNab, IznosNab, StatusNab, Zaposljava_Zaposljava_ID) 
VALUES (4, TO_DATE('2026-02-10', 'YYYY-MM-DD'), 41000.00, 'KOMPLETIRANA', 4);
INSERT INTO Nabavka (NabID, DatNab, IznosNab, StatusNab, Zaposljava_Zaposljava_ID) 
VALUES (5, TO_DATE('2026-02-15', 'YYYY-MM-DD'), 35000.00, 'NARUCENA', 5);

-- ============================================
-- 10. MAGACIN
-- ============================================
INSERT INTO Magacin (MagID, Kvadmag, Lokal_LokID, Nabavka_NabID) VALUES (1, 50, 1, 1);
INSERT INTO Magacin (MagID, Kvadmag, Lokal_LokID, Nabavka_NabID) VALUES (2, 40, 2, 2);
INSERT INTO Magacin (MagID, Kvadmag, Lokal_LokID, Nabavka_NabID) VALUES (3, 35, 3, 3);
INSERT INTO Magacin (MagID, Kvadmag, Lokal_LokID, Nabavka_NabID) VALUES (4, 30, 4, 4);
INSERT INTO Magacin (MagID, Kvadmag, Lokal_LokID, Nabavka_NabID) VALUES (5, 45, 1, 5);

-- ============================================
-- 11-13. PROIZVOD, SADRZAN, CUVA
-- ============================================
INSERT INTO Proizvod (ProdID, Nazp, Wght, Roktr) VALUES (1, 'Brasno tip 500', 25.0, TO_DATE('2027-06-30', 'YYYY-MM-DD'));
INSERT INTO Proizvod (ProdID, Nazp, Wght, Roktr) VALUES (2, 'Paradajz pelat', 5.0, TO_DATE('2026-12-31', 'YYYY-MM-DD'));
INSERT INTO Proizvod (ProdID, Nazp, Wght, Roktr) VALUES (3, 'Mocarela sir', 2.5, TO_DATE('2026-04-15', 'YYYY-MM-DD'));

INSERT INTO Sadrzan (Proizvod_ProdID, Nabavka_NabID) VALUES (1, 1);
INSERT INTO Sadrzan (Proizvod_ProdID, Nabavka_NabID) VALUES (2, 1);
INSERT INTO Sadrzan (Proizvod_ProdID, Nabavka_NabID) VALUES (3, 1);

INSERT INTO Cuva (Proizvod_ProdID, Magacin_LokID, Magacin_MagID) VALUES (1, 1, 1);
INSERT INTO Cuva (Proizvod_ProdID, Magacin_LokID, Magacin_MagID) VALUES (2, 1, 1);

-- ============================================
-- 14-15. NAMIRNICA, TROSI
-- ============================================
INSERT INTO Namirnica (NamID, NazNam, OpisNam, Jedinica, Pomocni_Radnik_Mbr) 
VALUES (1, 'Testo', 'Osnovno testo za picu', 'kg', 3);
INSERT INTO Namirnica (NamID, NazNam, OpisNam, Jedinica, Pomocni_Radnik_Mbr) 
VALUES (2, 'Paradajz sos', 'Sos od paradajza za picu', 'kg', 3);

INSERT INTO Trosi (Namirnica_NamID, Proizvod_ProdID) VALUES (1, 1);
INSERT INTO Trosi (Namirnica_NamID, Proizvod_ProdID) VALUES (2, 2);

-- ============================================
-- 16-17. DISTRIBUTER, OBAVLJA
-- ============================================
INSERT INTO Distributer (DisID, NazDis, KontaktDis) VALUES (1, 'Agro Invest', '0113334455');
INSERT INTO Obavlja (Distributer_DisID, Nabavka_NabID) VALUES (1, 1);

-- ============================================
-- 18-19. DOSTAVA, SARADJUJE
-- ============================================
INSERT INTO Dostava (DosID, NazDos, KontaktDos) VALUES (1, 'Brza Dostava', '0601111111');
INSERT INTO Saradjuje (Lokal_LokID, Dostava_DosID) VALUES (1, 1);

-- ============================================
-- 20. ARTIKAL
-- ============================================
INSERT INTO Artikal (SifArt, OpisArt, NazivArt, TipArt, VelArt) 
VALUES (1, 'Klasicna pica', 'Margherita', 'PICA', 'VELIKA');
INSERT INTO Artikal (SifArt, OpisArt, NazivArt, TipArt, VelArt) 
VALUES (2, 'Mesana pica', 'Capricciosa', 'PICA', 'VELIKA');

-- ============================================
-- 21. CENA (DatPoc je VARCHAR2 u DDL-u)
-- ============================================
INSERT INTO Cena (CenaID, Iznos, DatPoc, Vazeca, DatKr, Artikal_SifArt) 
VALUES (1, 950.00, '2026-01-01', 'D', NULL, 1);
INSERT INTO Cena (CenaID, Iznos, DatPoc, Vazeca, DatKr, Artikal_SifArt) 
VALUES (1, 1150.00, '2026-01-01', 'D', NULL, 2);

-- ============================================
-- 22-23. MENI, SADRZI
-- ============================================
INSERT INTO Meni (MeniID, Jezikm, Lokal_LokID) VALUES (1, 'SRPSKI', 1);
INSERT INTO Sadrzi (Meni_MeniID, Artikal_SifArt) VALUES (1, 1);
INSERT INTO Sadrzi (Meni_MeniID, Artikal_SifArt) VALUES (1, 2);

-- ============================================
-- 24. SASTAVLJEN
-- ============================================
INSERT INTO Sastavljen (Artikal_SifArt, Namirnica_NamID) VALUES (1, 1);
INSERT INTO Sastavljen (Artikal_SifArt, Namirnica_NamID) VALUES (1, 2);

-- ============================================
-- 25. MUSTERIJA
-- ============================================
INSERT INTO Musterija (Mbm, Imem, Przm, Telm, Emailm, Adrm) 
VALUES (1, 'Ivan', 'Ivanovic', '0661111111', 'ivan.ivanovic@gmail.com', 'Bulevar Kralja Aleksandra 100, Beograd');

-- ============================================
-- 26. PORUDZBINA (Sa ispravljenom 'DOSTAVA' vrednošću)
-- ============================================
INSERT INTO Porudzbina (PorID, DatVrPor, StatusPor, Suma, NacPreuz, Kasir_Mbr, Musterija_Mbm) 
VALUES (1, TO_DATE('2026-02-10 18:30:00', 'YYYY-MM-DD HH24:MI:SS'), 'PREUZETA', 2250.00, 'DOSTAVA', 1, 1);

INSERT INTO Porudzbina (PorID, DatVrPor, StatusPor, Suma, NacPreuz, Kasir_Mbr, Musterija_Mbm) 
VALUES (2, TO_DATE('2026-02-10 19:15:00', 'YYYY-MM-DD HH24:MI:SS'), 'PREUZETA', 1800.00, 'LICNO_PREUZIMANJE', 1, 1);

-- ============================================
-- 27. STAVKA
-- ============================================
INSERT INTO Stavka (StvID, KolStv, Porudzbina_PorID, Pica_Majstor_Mbr, Artikal_SifArt) 
VALUES (1, 2, 1, 2, 1);

-- ============================================
-- 28. RACUN (Prilagodjeno 'PLATNA_KARITCA')
-- ============================================
INSERT INTO Racun (RacID, NacPl, DatVrRac, Izn, Kasir_Mbr) 
VALUES (1, 'GOTOVINA', TO_DATE('2026-02-10 18:35:00', 'YYYY-MM-DD HH24:MI:SS'), 2250.00, 1);
INSERT INTO Racun (RacID, NacPl, DatVrRac, Izn, Kasir_Mbr) 
VALUES (2, 'PLATNA_KARITCA', TO_DATE('2026-02-10 19:20:00', 'YYYY-MM-DD HH24:MI:SS'), 1800.00, 1);

-- Ponovni unos vlasnika (sada će proći)
INSERT INTO Vlasnik (Mbv, Imev, Przv, Telv, Emailv) VALUES (1, 'Marko', 'Petrovic', '0641234567', 'marko.petrovic@pizzeria.rs');
INSERT INTO Vlasnik (Mbv, Imev, Przv, Telv, Emailv) VALUES (2, 'Ana', 'Jovanovic', '0642345678', 'ana.jovanovic@pizzeria.rs');
INSERT INTO Vlasnik (Mbv, Imev, Przv, Telv, Emailv) VALUES (3, 'Nikola', 'Nikolic', '0643456789', 'nikola.nikolic@pizzeria.rs');

-- Ponovni unos veza vlasnik-lokal
INSERT INTO Poseduje (Vlasnik_Mbv, Lokal_LokID) VALUES (1, 1);
INSERT INTO Poseduje (Vlasnik_Mbv, Lokal_LokID) VALUES (1, 2);
INSERT INTO Poseduje (Vlasnik_Mbv, Lokal_LokID) VALUES (2, 3);
INSERT INTO Poseduje (Vlasnik_Mbv, Lokal_LokID) VALUES (3, 4);

-- Ponovni unos izveštaja
INSERT INTO Izvestaj (IzvID, DatKreir, TesktIzv, Vlasnik_Mbv) 
VALUES (1, TO_DATE('2026-02-01', 'YYYY-MM-DD'), 'Mesecni izvestaj za Januar 2026', 1);

1

COMMIT;