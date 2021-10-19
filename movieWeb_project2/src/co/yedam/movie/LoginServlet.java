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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();

		
		//1.parameter 추출
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		//2.유효성 체크
		if(userId.isEmpty() || userPw.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("");
			rd.forward(request, response);
			return;
		}
		
	
		
		

//		UserVO vo = new UserVO();
//		UserDAO dao = new UserDAO();
//		boolean result = false;
//
//		vo.setUserId(userId);
//		vo.setUserPw(userPw);
//
//		result = dao.loginUser(vo);
//		if (result) {
//			HttpSession session = request.getSession();
//			session.setAttribute("isLogOn", true);
//			session.setAttribute("login.id", userId);
//			session.setAttribute("login.pwd", userPw);
//
//			out.print("<html><body><h1>안녕하세요</h1><br><h3><a href='/show'></a>");
//
//		} else {
//			out.print("<html><body><h1>아이디가 틀립니다.</h1><br><h3><a href='/login.html'>다시</a></h3></body></html>");
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
