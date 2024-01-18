package model;

import java.io.Serializable;

public class Mutter implements Serializable {
	private int id;
	private int bill;


	public Mutter(int id, int bill) {
		this.id = id;
		this.bill = bill;
	}
	public Mutter(int bill) {

		this.bill = bill;
	}




	public int getId() { return id; }
	public  int getBill() { return bill; }

}