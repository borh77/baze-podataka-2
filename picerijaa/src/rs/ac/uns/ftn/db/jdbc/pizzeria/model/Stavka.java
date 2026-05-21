package rs.ac.uns.ftn.db.jdbc.pizzeria.model;

public class Stavka {
	private int stvID;
	private int kolStv;
	private int porudzbinaPorID;
	private int picaMajstorMbr;
	private int artikalSifArt;

	public Stavka() {
		super();
	}

	public Stavka(int stvID, int kolStv, int porudzbinaPorID, int picaMajstorMbr, int artikalSifArt) {
		this.stvID = stvID;
		this.kolStv = kolStv;
		this.porudzbinaPorID = porudzbinaPorID;
		this.picaMajstorMbr = picaMajstorMbr;
		this.artikalSifArt = artikalSifArt;
	}

	public int getStvID() {
		return stvID;
	}

	public void setStvID(int stvID) {
		this.stvID = stvID;
	}

	public int getKolStv() {
		return kolStv;
	}

	public void setKolStv(int kolStv) {
		this.kolStv = kolStv;
	}

	public int getPorudzbinaPorID() {
		return porudzbinaPorID;
	}

	public void setPorudzbinaPorID(int porudzbinaPorID) {
		this.porudzbinaPorID = porudzbinaPorID;
	}

	public int getPicaMajstorMbr() {
		return picaMajstorMbr;
	}

	public void setPicaMajstorMbr(int picaMajstorMbr) {
		this.picaMajstorMbr = picaMajstorMbr;
	}

	public int getArtikalSifArt() {
		return artikalSifArt;
	}

	public void setArtikalSifArt(int artikalSifArt) {
		this.artikalSifArt = artikalSifArt;
	}

	@Override
	public String toString() {
		return String.format("%-6d %-6d %-6d %-6d %-6d", porudzbinaPorID, stvID, kolStv, artikalSifArt, picaMajstorMbr);
	}

	public static String getFormattedHeader() {
		return String.format("%-6s %-6s %-6s %-6s %-6s", "POR_ID", "STV_ID", "KOL", "ARTIKAL", "MAJSTOR");
	}
}
