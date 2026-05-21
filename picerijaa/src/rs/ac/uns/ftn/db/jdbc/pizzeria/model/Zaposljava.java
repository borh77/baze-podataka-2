package rs.ac.uns.ftn.db.jdbc.pizzeria.model;

public class Zaposljava {
	private int zaposljavID;
	private int radnikMbr;
	private int lokalLokID;

	public Zaposljava() {
		super();
	}

	public Zaposljava(int zaposljavID, int radnikMbr, int lokalLokID) {
		this.zaposljavID = zaposljavID;
		this.radnikMbr = radnikMbr;
		this.lokalLokID = lokalLokID;
	}

	public int getZaposljavID() {
		return zaposljavID;
	}

	public void setZaposljavID(int zaposljavID) {
		this.zaposljavID = zaposljavID;
	}

	public int getRadnikMbr() {
		return radnikMbr;
	}

	public void setRadnikMbr(int radnikMbr) {
		this.radnikMbr = radnikMbr;
	}

	public int getLokalLokID() {
		return lokalLokID;
	}

	public void setLokalLokID(int lokalLokID) {
		this.lokalLokID = lokalLokID;
	}
}
