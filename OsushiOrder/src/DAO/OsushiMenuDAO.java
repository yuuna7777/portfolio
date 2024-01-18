package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.OsushiMenu;


public class OsushiMenuDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/OsushiMenu";
	private final String DB_USER = "root";
	private final String DB_PASS = "";



	public List<OsushiMenu> findAll(String fish) {
		List<OsushiMenu> menuList = new ArrayList<>();


		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT ID, NETA, PRICE FROM OsushiMenu WHERE id = " + fish + ";";
			PreparedStatement pStmt= conn.prepareStatement(sql);

			//pStmt.setInt(1, Integer.parseInt(test));

			ResultSet rs = pStmt.executeQuery();

			System.out.println("idが" + fish + "のデータを取得します。");

			while (rs.next()) {
				int id = rs.getInt("ID");
				String neta = rs.getString("NETA");
				int price = rs.getInt("PRICE");
				OsushiMenu osushimenu = new OsushiMenu(id, neta, price);
				menuList.add(osushimenu);

			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return menuList;

	}

}
