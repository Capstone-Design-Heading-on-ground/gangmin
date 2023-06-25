package lecture;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;

public class LectureDAO {
	private DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;
	//private ResultSet rs;
	
	public LectureDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<LectureVO> selectAllLectures(){
		List<LectureVO> lecturesList = new ArrayList();
		try {
			conn = dataFactory.getConnection();
			String query = "SELECT LKEY, LID, LPRICE, LDURATION, LIMAGE, LSUMGRADE, LCOUNTGRADE"
							+ " FROM LECTURE"
							+ " ORDER BY LCOUNTGRADE desc";
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int lkey = rs.getInt("LKEY");
				String lid = rs.getString("LID");
				int lprice = rs.getInt("LPRICE");
				int lduration = rs.getInt("LDURATION");
				String limage = rs.getString("LIMAGE");
				float lsumgrade = rs.getFloat("LSUMGRADE");
				int lcountgrade = rs.getInt("LCOUNTGRADE");
				LectureVO lecture = new LectureVO();
				lecture.setLkey(lkey);
				lecture.setLid(lid);
				lecture.setLprice(lprice);
				lecture.setLduration(lduration);
				lecture.setLimage(limage);
				lecture.setLsumgrade(lsumgrade);
				lecture.setLcountgrade(lcountgrade);
				lecturesList.add(lecture);
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return lecturesList;
	}
	
	public List<LectureVO> searchAllLectures(String search)
	{
		System.out.println("lecture dao");
		List<LectureVO> lecturesList = new ArrayList();
		System.out.println(search);
		try
		{
			conn = dataFactory.getConnection();
			String query = "SELECT * FROM LECTURE WHERE LID like '%"+search+"%' ";
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int lkey = rs.getInt("LKEY");
				String lid = rs.getString("LID");
				int lprice = rs.getInt("LPRICE");
				int lduration = rs.getInt("LDURATION");
				String limage = rs.getString("LIMAGE");
				float lsumgrade = rs.getFloat("LSUMGRADE");
				int lcountgrade = rs.getInt("LCOUNTGRADE");
				LectureVO lecture = new LectureVO();
				lecture.setLkey(lkey);
				lecture.setLid(lid);
				lecture.setLprice(lprice);
				lecture.setLduration(lduration);
				lecture.setLimage(limage);
				lecture.setLsumgrade(lsumgrade);
				lecture.setLcountgrade(lcountgrade);
				lecturesList.add(lecture);
				System.out.println(lid);
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("error2");
		}
		return lecturesList;
	}
	
	public List<LectureVO> eventpriceLectures(String check)
	{
		System.out.println("lecture dao");
		List<LectureVO> lecturesList = new ArrayList();
		try
		{
			String query;
			String sort = "LPRICE";
			String updown = "DESC";
			
			conn = dataFactory.getConnection();
			if(check.equals("sort_low"))
			{
				sort = "LPRICE";
				updown = "ASC";
			}else if(check.equals("sort_high"))
			{
				sort = "LPRICE";
				updown = "DESC";
			}else if(check.equals("sort_pop"))
			{
				sort = "LCOUNTGRADE";
				updown = "DESC";
			}else if(check.equals("sort_new")) {
				sort = "LSTARTDATE";
				updown = "DESC";
			}else if(check.equals("sort_name")) {
				sort = "LID";
				updown = "DESC";
			}
				 query = "SELECT * FROM LECTURE ORDER BY " + sort + " " + updown;
		
				 //query = "SELECT * FROM LECTURE ORDER BY LPRICE DESC";
			System.out.println(check);
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int lkey = rs.getInt("LKEY");
				String lid = rs.getString("LID");
				int lprice = rs.getInt("LPRICE");
				int lduration = rs.getInt("LDURATION");
				String limage = rs.getString("LIMAGE");
				float lsumgrade = rs.getFloat("LSUMGRADE");
				int lcountgrade = rs.getInt("LCOUNTGRADE");
				LectureVO lecture = new LectureVO();
				lecture.setLkey(lkey);
				lecture.setLid(lid);
				lecture.setLprice(lprice);
				lecture.setLduration(lduration);
				lecture.setLimage(limage);
				lecture.setLsumgrade(lsumgrade);
				lecture.setLcountgrade(lcountgrade);
				lecturesList.add(lecture);
				System.out.println(lid);
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("error2");
		}
		return lecturesList;
   }
	
	public LectureVO infoLecture(int inputlkey) {
		LectureVO lectureVO = new LectureVO();
		try {
			conn = dataFactory.getConnection();
			String query = "SELECT * FROM LECTURE WHERE LKEY = ?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, inputlkey);
			System.out.println(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int lkey = rs.getInt("LKEY");
				String lid = rs.getString("LID");
				String lname = rs.getString("LNAME");
				String ltype = rs.getString("LTYPE");
				String lconst = rs.getString("LCONST");
				String lsubject = rs.getString("LSUBJECT");
				String lunit = rs.getString("LUNIT");
				String luser = rs.getString("LUSER");
				String lcreate = rs.getString("LCREATE");
				String llevel = rs.getString("LLEVEL");
				int ltime = rs.getInt("LTIME");
				int lprice = rs.getInt("LPRICE");
				int lduration = rs.getInt("LDURATION");
				String linfo = rs.getString("LINFO");
				String ltarget = rs.getString("LTARGET");
				String limage = rs.getString("LIMAGE");
				Date lstartdate = rs.getDate("LSTARTDATE");
				float lsumgrade = rs.getFloat("LSUMGRADE");
				int lcountgrade = rs.getInt("LCOUNTGRADE");
				String lacademy = rs.getString("LACADEMY");
				lectureVO.setLkey(lkey);
				lectureVO.setLname(lname);
				lectureVO.setLtype(ltype);
				lectureVO.setLconst(lconst);
				lectureVO.setLsubject(lsubject);
				lectureVO.setLunit(lunit);
				lectureVO.setLuser(luser);
				lectureVO.setLcreate(lcreate);
				lectureVO.setLlevel(llevel);
				lectureVO.setLtime(ltime);
				lectureVO.setLprice(lprice);
				lectureVO.setLduration(lduration);
				lectureVO.setLinfo(linfo);
				lectureVO.setLtarget(ltarget);
				lectureVO.setLimage(limage);
				lectureVO.setLstartdate(lstartdate);
				lectureVO.setLsumgrade(lsumgrade);
				lectureVO.setLcountgrade(lcountgrade);
				lectureVO.setLacademy(lacademy);
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return lectureVO;
	}
	
	public List<LectureVO> categorySearch(String[] selectedAcademy, String radioValue1, String radioValue2, String radioValue4){
		List<LectureVO> lecturesList = new ArrayList();
		try {
			conn = dataFactory.getConnection();
			String query = "SELECT LKEY, LID, LPRICE, LDURATION, LIMAGE, LSUMGRADE, LCOUNTGRADE"
						+ " FROM LECTURE WHERE 1=1";
			if(!radioValue4.equals("undefined")) {
				query = query + " AND LUNIT = '";
				query = query + radioValue4;
				query = query + "'";
			}
			if(!radioValue2.equals("undefined")) {
				query = query + " AND LSUBJECT = '";
				query = query + radioValue2;
				query = query + "'";
			}
			if(!radioValue1.equals("undefined")) {
				if(radioValue1.equals("인문계열")) {
					query = query + " AND (LSUBJECT = '국어'"
								 		   +" OR LSUBJECT = '수학'"
								 		   +" OR LSUBJECT = '영어'"
								 		   +" OR LSUBJECT = '생활과 윤리'"
								 		   +" OR LSUBJECT = '윤리와 사상'"
								 		   +" OR LSUBJECT = '한국 지리'"
								 		   +" OR LSUBJECT = '세계 지리')";													
				}else {
					query = query + " AND (LSUBJECT = '국어'"
					 		   			+" OR LSUBJECT = '수학'"
					 		   			+" OR LSUBJECT = '영어'"
					 		   			+" OR LSUBJECT = '물리'"
					 		   			+" OR LSUBJECT = '화학'"
					 		   			+" OR LSUBJECT = '생물'"
					 		   			+" OR LSUBJECT = '지구과학')";
				}
			}
			if(selectedAcademy[0].length()!=0) {
				query = query + " AND (LACADEMY = ''";
				for(int i=0; i<selectedAcademy.length; i++) {
					query = query + " OR LACADEMY = '";
					query = query + selectedAcademy[i];
					query = query + "'";
				}
				query = query + ")";
						
			}
			
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int lkey = rs.getInt("LKEY");
				String lid = rs.getString("LID");
				int lprice = rs.getInt("LPRICE");
				int lduration = rs.getInt("LDURATION");
				String limage = rs.getString("LIMAGE");
				float lsumgrade = rs.getFloat("LSUMGRADE");
				int lcountgrade = rs.getInt("LCOUNTGRADE");
				
				LectureVO lecture = new LectureVO();
				lecture.setLkey(lkey);
				lecture.setLid(lid);
				lecture.setLprice(lprice);
				lecture.setLduration(lduration);
				lecture.setLimage(limage);
				lecture.setLsumgrade(lsumgrade);
				lecture.setLcountgrade(lcountgrade);
				lecturesList.add(lecture);
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return lecturesList;
	}
}
