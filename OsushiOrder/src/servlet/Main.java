package servlet;

import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
import java.util.List;

import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.OsushiMenuDAO;
import model.Mutter;
import model.OsushiMenu;
import model.PostArchiveLogic;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");


		if(loginUser == null) {
			response.sendRedirect("/OsushiOrder/");
		} else {
			//ログイン済みの場合フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);

		}



	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session = request.getSession();

		//リクエストパラメーターを取得
		request.setCharacterEncoding("UTF-8");



		//メニューのネタを取得
		String name = request.getParameter("name");
		String neta = request.getParameter("neta");
		int userNum = Integer.parseInt(request.getParameter("num"));



		if(neta.equals("empty")) {
			request.setAttribute("errorMsg", "商品を選択してください");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		} else if ( neta != null ){


		OsushiMenuDAO dao = new OsushiMenuDAO();
		List<OsushiMenu> menuList = dao.findAll(neta);


		//メニューの名前をコンソールに出力
		if(neta.equals("1")) {{ name = "まぐろ"; }
		System.out.println(name);
		} else if(neta.equals("2")) {{ name = "サーモン"; }
		System.out.println(name);
		} else if(neta.equals("3")) {{ name = "えび"; }
		System.out.println(name);
		} else if(neta.equals("4")) {{ name = "玉子"; }
		System.out.println(name);
		} else if(neta.equals("5")) {{ name = "いくら"; }
		System.out.println(name);
		}
		System.out.println(userNum);


		for(OsushiMenu menu : menuList) {
			int bill = menu.getPrice() * userNum;
			System.out.println("ID:" + menu.getId());
			System.out.println("ネタ:" + menu.getNeta());
			System.out.println("値段:" + bill + "円");

			if(bill >= 1) {


				Mutter mutter = new Mutter(bill);
				PostArchiveLogic postArchiveLogic = new PostArchiveLogic();
				postArchiveLogic.execute(mutter);



			} else {
				request.setAttribute("errorMsg", "まだ何も注文していません");
			}


			session.setAttribute("bill", bill);


		}
		// セッションスコープに値を設定する
        session.setAttribute("name", name);
        session.setAttribute("userNum", userNum);






        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/OrderResult.jsp");
		dispatcher.forward(request, response);





		}




	}


}