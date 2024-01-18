package model;

import DAO.MutterDAO;

public class PostArchiveLogic {
	public void execute(Mutter mutter) {
		MutterDAO dao = new MutterDAO();
		dao.create(mutter);
	}
}
