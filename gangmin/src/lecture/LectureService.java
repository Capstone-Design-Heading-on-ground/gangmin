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
	
	public List<LectureVO> eventpriceLectures(String check)
	{
		System.out.println("event price service");
		List<LectureVO> lecturesList = lectureDAO.eventpriceLectures(check);
		return lecturesList;
    }
  
	public LectureVO infoLecture(int lkey)
	{
		LectureVO infoLecture = lectureDAO.infoLecture(lkey);
		return infoLecture;
	}
	
	public List<LectureVO> categorySearch(String[] selectedAcademy, String radioValue1, String radioValue2, String radioValue4){
		List<LectureVO> lecturesList = lectureDAO.categorySearch(selectedAcademy, radioValue1, radioValue2, radioValue4);
		return lecturesList;
	}
  
}
