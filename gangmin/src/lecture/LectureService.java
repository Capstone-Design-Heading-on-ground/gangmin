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
	
	public LectureVO infoLecture(int lkey)
	{
		LectureVO infoLecture = lectureDAO.infoLecture(lkey);
		return infoLecture;
	}
}
