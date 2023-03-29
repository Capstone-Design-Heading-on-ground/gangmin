package member;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member/*")
public class MemberServlet extends HttpServlet {
	MemberDAO memberDAO;
	
	public void init() throws ServletException {
		memberDAO = new MemberDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();
		
		// action이 null 일때
		if(action == null) {
			
		} else if(action.equals("/new")) {  //action을 new로 받았을때
			String mid = request.getParameter("mid");
			String mpw = request.getParameter("mpw");
			String mname = request.getParameter("mname");
			String mnickname = request.getParameter("mnickname");
			String mhp = request.getParameter("hp1") + "-" + request.getParameter("hp2") + "-" + request.getParameter("hp3");
			String maddress = request.getParameter("maddress");
			String mmail = request.getParameter("mmail");
			String mbirthday= request.getParameter("mbirthday");
			int madmin = 0;
			
			MemberVO memberVO = new MemberVO(mid, mpw, mname, mnickname, mhp, maddress, mmail, mbirthday, madmin);
			memberDAO.addMember(memberVO);
			
			nextPage = "login.jsp";
		} else if(action.equals("/login")) {
			String mid = request.getParameter("mid");
			String mpw = request.getParameter("mpw");
			

			String isLogon = memberDAO.loginMember(mid, mpw);
		}
		
		RequestDispatcher dispach = request.getRequestDispatcher("nextPage");
		dispach.forward(request, response);
	}
}
