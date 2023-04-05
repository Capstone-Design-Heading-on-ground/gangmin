package lecture;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LectureController
 */
@WebServlet("/lecture/*")
public class LectureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	LectureService lectureService;
	LectureVO lectureVO;
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		//super.init(config);
		lectureService = new LectureService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();	
		try {
			List<LectureVO> lecturesList = new ArrayList<LectureVO>();
			
			if(action == null) {
				lecturesList = lectureService.listLectures();
				request.setAttribute("LecturesList", lecturesList);
				nextPage = "/index.jsp";
			}else if(action.equals("/listLectures.do")) {
				lecturesList = lectureService.listLectures();				
				request.setAttribute("lecturesList", lecturesList);
				nextPage = "/index.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher("/index.jsp");
				dispatch.forward(request, response);
			}else if(action.equals("/connectLecture")) {
				int lkey = Integer.parseInt(request.getParameter("lkey"));
				lectureVO = lectureService.infoLecture(lkey);
				lectureVO.setLinfo(lectureVO.getLinfo().replace("\n", "<br/>"));
				request.setAttribute("infoLecture", lectureVO);
				RequestDispatcher dispatch = request.getRequestDispatcher("/lecture_info.jsp");
				dispatch.forward(request, response);
				System.out.println(lkey);
			}else {
				System.out.println(action);
			}
			
		} catch(Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}
}
