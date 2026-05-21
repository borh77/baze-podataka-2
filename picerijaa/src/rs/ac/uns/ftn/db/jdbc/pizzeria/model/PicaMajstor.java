package rs.ac.uns.ftn.db.jdbc.pizzeria.model;

public class PicaMajstor extends Radnik {
	private int godIsk;
	private String zvanje;

	public PicaMajstor() {
		super();
	}

	public int getGodIsk() {
		return godIsk;
	}

	public void setGodIsk(int godIsk) {
		this.godIsk = godIsk;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	@Override
	public String toString() {
		return "PicaMajstor: " + super.toString() + String.format(" GodIsk: %d Zvanje: %s", godIsk, zvanje);
	}
}
