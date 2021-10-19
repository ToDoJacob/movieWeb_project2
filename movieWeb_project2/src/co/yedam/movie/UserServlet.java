package co.yedam.movie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
		UserDAO dao = new UserDAO();
 
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userNick = request.getParameter("userNick");

		UserVO vo = new UserVO();
		vo = dao.insertUser(userId, userPw, userNick);
		vo.setUserId(userId);
		vo.setUserPw(userPw);
		vo.setUserNick(userNick);
	
//		System.out.println("<h1>추가페이지입니다</h1>");
//		//사용자가 이름과 내용은 등록해서 누르면 
//		String name =  request.getParameter("name");
//		String content = request.getParameter("content");
//		
//		Comment comment = new Comment();
//		comment.setName(name);
//		comment.setContent(content);
//		
//		dao.insertComment(comment);
//		
//		//가지고온 comment를 gson 타입으로 바꾸겠다 
//		out.println(gson.toJson(comment));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
