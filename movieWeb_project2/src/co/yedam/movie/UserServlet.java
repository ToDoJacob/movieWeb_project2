package co.yedam.movie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();

		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userNick = request.getParameter("userNick");


		UserDAO dao = new UserDAO();
		UserVO vo = new UserVO();
		
		vo = dao.insertUser(userId, userPw, userNick);
		vo.setUserId(userId);
		vo.setUserPw(userPw);
		vo.setUserNick(userNick);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}