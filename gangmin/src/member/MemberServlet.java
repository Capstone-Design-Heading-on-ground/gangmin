package member;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();
		
		// action이 null 일때
		if(action == null) {
			nextPage = "/login.jsp";
			System.out.println("test");
			response.sendRedirect("/login.jsp");
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
			
			nextPage = request.getContextPath() + "/login.jsp" + "?create=success";
			response.sendRedirect(nextPage);
			
		} else if(action.equals("/login")) {
			String mid = request.getParameter("mid");
			String mpw = request.getParameter("mpw");
			String isLogon = "login_invalid";
			String isNull = null;
			
			MemberVO memberVO = memberDAO.loginMember(mid);
			if(memberVO.getMid().equals("nonexistent")) {
				isLogon = "login_invalid";
			}else {
				if(memberVO.getMpw().equals(mpw)) {
					isLogon = "login_success";
				}else {
					isLogon = "unmatched_password";
				}
			}
			
			if(isLogon.equals("login_invalid")) {
				nextPage = request.getContextPath() + "/login.jsp" + "?create=login_invalid";
				response.sendRedirect(nextPage);
			}else if(isLogon.equals("unmatched_password")) {
				nextPage = request.getContextPath() + "/login.jsp" + "?create=unmatched_password";
				response.sendRedirect(nextPage);
			}else if(isLogon.equals("login_success")) {
				session.setAttribute("mkey", memberVO.getMkey());
				session.setAttribute("mnickname", memberVO.getMnickname());
				System.out.println("login Successful");
				nextPage = request.getContextPath() + "/lecture/listLectures.do";
				response.sendRedirect(nextPage);
			}
		} else if(action.equals("/logout")){
			session.invalidate();
			nextPage = request.getContextPath() + "/lecture/listLectures.do";
			response.sendRedirect(nextPage);
		}else {
			
		}
			//nextPage = request.getContextPath() + "/login.jsp" + "?create=success";
			//response.sendRedirect(nextPage);
	}
		
		//RequestDispatcher dispach = request.getRequestDispatcher(nextPage);
		//dispach.forward(request, response);
}

