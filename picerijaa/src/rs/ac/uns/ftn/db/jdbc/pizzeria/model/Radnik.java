package rs.ac.uns.ftn.db.jdbc.pizzeria.model;

import java.util.Date;

public class Radnik {
	private int mbr;
	private String imer;
	private String przr;
	private Date datr;
	private String emailr;
	private String telr;
	private Date datSan;
	private String tipr;
	private Integer radnikMbr; // supervisor - self-referencing

	public Radnik() {
		super();
	}

	public Radnik(int mbr, String imer, String przr, Date datr, String emailr, String telr, Date datSan, String tipr, Integer radnikMbr) {
		this.mbr = mbr;
		this.imer = imer;
		this.przr = przr;
		this.datr = datr;
		this.emailr = emailr;
		this.telr = telr;
		this.datSan = datSan;
		this.tipr = tipr;
		this.radnikMbr = radnikMbr;
	}

	public int getMbr() {
		return mbr;
	}

	public void setMbr(int mbr) {
		this.mbr = mbr;
	}

	public String getImer() {
		return imer;
	}

	public void setImer(String imer) {
		this.imer = imer;
	}

	public String getPrzr() {
		return przr;
	}

	public void setPrzr(String przr) {
		this.przr = przr;
	}

	public Date getDatr() {
		return datr;
	}

	public void setDatr(Date datr) {
		this.datr = datr;
	}

	public String getEmailr() {
		return emailr;
	}

	public void setEmailr(String emailr) {
		this.emailr = emailr;
	}

	public String getTelr() {
		return telr;
	}

	public void setTelr(String telr) {
		this.telr = telr;
	}

	public Date getDatSan() {
		return datSan;
	}

	public void setDatSan(Date datSan) {
		this.datSan = datSan;
	}

	public String getTipr() {
		return tipr;
	}

	public void setTipr(String tipr) {
		this.tipr = tipr;
	}

	public Integer getRadnikMbr() {
		return radnikMbr;
	}

	public void setRadnikMbr(Integer radnikMbr) {
		this.radnikMbr = radnikMbr;
	}

	@Override
	public String toString() {
		return String.format("%-6d %-15s %-15s %-12s %-25s %-15s %-12s %-20s %-6s", 
			mbr, imer, przr, datr != null ? datr.toString() : "", emailr != null ? emailr : "", 
			telr, datSan != null ? datSan.toString() : "", tipr, radnikMbr != null ? radnikMbr : "");
	}

	public static String getFormattedHeader() {
		return String.format("%-6s %-15s %-15s %-12s %-25s %-15s %-12s %-20s %-6s", 
			"MBR", "IME", "PREZIME", "DAT_RODJ", "EMAIL", "TELEFON", "DAT_ZAPOSLJ", "TIP", "SUPERVIZOR");
	}
}
