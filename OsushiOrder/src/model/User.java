package model;

import java.io.Serializable;

public class User implements Serializable {
	private String number;

	public User(String number) {
		this.number = number;

	}
	public String getNumber() {return number; }


}
