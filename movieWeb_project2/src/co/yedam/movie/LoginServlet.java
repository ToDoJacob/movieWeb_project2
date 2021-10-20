package co.yedam.movie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 기본 설정
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 출력스트림생성
		PrintWriter out = response.getWriter();

		// getParameter를 이용하여 값을 전달받음
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String UserNick = request.getParameter("UserNick");

		UserDAO dao = new UserDAO();
		UserVO vo = new UserVO();

		Gson gson = new GsonBuilder().create();

		vo.setUserId(userId);
		vo.setUserPw(userPw);
		vo.setUserNick(UserNick);

		vo = dao.loginUser(vo);
		out.println(gson.toJson(vo));

	
//		int r = -1;
//		if (userId == vo.getUserId() && userPw == vo.getUserPw()) {
//			r = 1;
//		} else {
//			r = 0;
//		}
//		System.out.println(r);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
