package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MutterDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/billarchive";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	public List<Mutter> findAll() {
		List<Mutter> ArcList = new ArrayList<>();



		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT SUM(BILL) AS BILLRESULT FROM BILLARCHIVE ORDER BY ID DESC";
			PreparedStatement pStmt= conn.prepareStatement(sql);


			ResultSet rs = pStmt.executeQuery();



			while (rs.next()) {

				int bill = rs.getInt("BILLRESULT");
				Mutter mutter = new Mutter(bill);
				ArcList.add(mutter);

			}
		}

		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return ArcList;

	}
	public boolean create(Mutter mutter) {

		try(Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO billarchive(BILL) VALUES(?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, mutter.getBill());


			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

}