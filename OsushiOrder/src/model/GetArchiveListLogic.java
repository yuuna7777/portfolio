package model;

import java.util.List;

import DAO.MutterDAO;

public class GetArchiveListLogic {

	public List<Mutter> execute() {
		MutterDAO dao = new MutterDAO();
		List<Mutter> ArcList = dao.findAll();
		return ArcList;
	}

}
