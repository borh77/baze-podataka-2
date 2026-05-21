package rs.ac.uns.ftn.db.jdbc.pizzeria.model;

public class Meni {
	private int meniID;
	private String jezikm;
	private int lokalLokID;

	public Meni() {
		super();
	}

	public Meni(int meniID, String jezikm, int lokalLokID) {
		this.meniID = meniID;
		this.jezikm = jezikm;
		this.lokalLokID = lokalLokID;
	}

	public int getMeniID() {
		return meniID;
	}

	public void setMeniID(int meniID) {
		this.meniID = meniID;
	}

	public String getJezikm() {
		return jezikm;
	}

	public void setJezikm(String jezikm) {
		this.jezikm = jezikm;
	}

	public int getLokalLokID() {
		return lokalLokID;
	}

	public void setLokalLokID(int lokalLokID) {
		this.lokalLokID = lokalLokID;
	}

	@Override
	public String toString() {
		return String.format("%-6d %-15s %-6d", meniID, jezikm, lokalLokID);
	}

	public static String getFormattedHeader() {
		return String.format("%-6s %-15s %-6s", "ID", "JEZIK", "LOKAL");
	}
}
