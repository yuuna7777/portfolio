package model;

public class LoginLogic {
	public boolean execute(User user) {
		if(user.getNumber().length() <= 2) {return true; }
		return false;
	}
}
