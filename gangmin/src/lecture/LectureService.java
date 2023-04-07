package lecture;

import java.util.List;

public class LectureService {
	LectureDAO lectureDAO;
	
	public LectureService() {
		lectureDAO = new LectureDAO();
	}
	
	public List<LectureVO> listLectures()
	{
		List<LectureVO> lecturesList = lectureDAO.selectAllLectures();
		return lecturesList;
	}
	
	public List<LectureVO> searchLectures(String search)
	{
		System.out.println("lecture service");
		List<LectureVO> lecturesList = lectureDAO.searchAllLectures(search);
		return lecturesList;
	}
	
	public List<LectureVO> lowpriceLectures()
	{
		System.out.println("low price service");
		List<LectureVO> lecturesList = lectureDAO.lowpriceLectures();
		return lecturesList;
  }
  
	public LectureVO infoLecture(int lkey)
	{
		LectureVO infoLecture = lectureDAO.infoLecture(lkey);
		return infoLecture;
	}
  
}
