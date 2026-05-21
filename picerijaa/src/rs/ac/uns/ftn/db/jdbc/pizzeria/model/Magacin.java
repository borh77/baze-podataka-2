package rs.ac.uns.ftn.db.jdbc.pizzeria.model;

public class Magacin {
	private int magID;
	private int kvadmag;
	private int lokalLokID;
	private int nabavkaNabID;

	public Magacin() {
		super();
	}

	public Magacin(int magID, int kvadmag, int lokalLokID, int nabavkaNabID) {
		this.magID = magID;
		this.kvadmag = kvadmag;
		this.lokalLokID = lokalLokID;
		this.nabavkaNabID = nabavkaNabID;
	}

	public int getMagID() {
		return magID;
	}

	public void setMagID(int magID) {
		this.magID = magID;
	}

	public int getKvadmag() {
		return kvadmag;
	}

	public void setKvadmag(int kvadmag) {
		this.kvadmag = kvadmag;
	}

	public int getLokalLokID() {
		return lokalLokID;
	}

	public void setLokalLokID(int lokalLokID) {
		this.lokalLokID = lokalLokID;
	}

	public int getNabavkaNabID() {
		return nabavkaNabID;
	}

	public void setNabavkaNabID(int nabavkaNabID) {
		this.nabavkaNabID = nabavkaNabID;
	}

	@Override
	public String toString() {
		return String.format("%-6d %-6d %-8d %-6d %-6d", lokalLokID, magID, kvadmag, nabavkaNabID);
	}

	public static String getFormattedHeader() {
		return String.format("%-6s %-6s %-8s %-6s", "LOKAL", "MAG_ID", "KVADRAT", "NABAVKA");
	}
}
