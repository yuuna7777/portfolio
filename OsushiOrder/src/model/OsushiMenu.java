package model;

public class OsushiMenu {

	private int id;
	private String neta;
	private int price;

	public OsushiMenu(int id, String neta, int price) {
		this.id = id;
		this.neta = neta;
		this.price = price;

	}

	public int getId() { return id; }
	public String getNeta() {return neta; }
	public int getPrice() {return price; }

}