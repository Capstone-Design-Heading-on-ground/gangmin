package lecture;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;

public class LectureDAO {
	private DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;
	
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
				int lsumgrade = rs.getInt("LSUMGRADE");
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
				int lsumgrade = rs.getInt("LSUMGRADE");
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
	
	public List<LectureVO> lowpriceLectures()
	{
		System.out.println("lecture dao");
		List<LectureVO> lecturesList = new ArrayList();
		try
		{
			conn = dataFactory.getConnection();
			String query = "SELECT * FROM LECTURE ORDER BY LPRICE ASC";
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int lkey = rs.getInt("LKEY");
				String lid = rs.getString("LID");
				int lprice = rs.getInt("LPRICE");
				int lduration = rs.getInt("LDURATION");
				String limage = rs.getString("LIMAGE");
				int lsumgrade = rs.getInt("LSUMGRADE");
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
}
