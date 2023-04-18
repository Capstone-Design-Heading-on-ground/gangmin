package comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.TimeZone;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CommentDAO {
	private DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;
	
	public CommentDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<CommentVO> selectALLComments(int input_lkey){
		List<CommentVO> commentsList = new ArrayList();
		try {
			conn = dataFactory.getConnection();
			String query = "SELECT * FROM COMENT WHERE LKEY = ? ORDER BY CDATE DESC";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, input_lkey);
			System.out.println(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int ckey = rs.getInt("CKEY");
				String ccontent = rs.getString("CCONTENT");
				int lkey = rs.getInt("LKEY");
				int mkey = rs.getInt("MKEY");
				int crecommend = rs.getInt("CRECOMMEND");
				Timestamp cdate = rs.getTimestamp("CDATE");
				float cscore = rs.getFloat("CSCORE");
				String mnickname = queryUserNickname(mkey);
				
				CommentVO comment = new CommentVO();
				comment.setCkey(ckey);
				comment.setCcontent(ccontent);
				comment.setLkey(lkey);
				comment.setMkey(mkey);
				comment.setCrecommend(crecommend);
				comment.setCdate(cdate);
				comment.setCscore(cscore);
				comment.setMnickname(mnickname);
				commentsList.add(comment);
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return commentsList;
	}
	
	public void addComment(CommentVO c) {
		try {
			conn = dataFactory.getConnection();
			String ccontent = c.getCcontent();
			int lkey = c.getLkey();
			int mkey = c.getMkey();
			float cscore = c.getCscore();
			
			String query = "INSERT INTO COMENT(CKEY, CCONTENT, LKEY, MKEY, CSCORE)" +
						   " VALUES(com_seq.nextVAL, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, ccontent);
			pstmt.setInt(2, lkey);
			pstmt.setInt(3, mkey);
			pstmt.setFloat(4, cscore);
			pstmt.executeUpdate();
			
			/*query = "UPDATE LECTURE SET LSUMGRADE = LSUMGRADE + ?" +
					" WHERE LKEY = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setFloat(1, cscore);
			pstmt.setInt(2, lkey);
			pstmt.executeUpdate();
			
			query = "UPDATE LECTURE SET LCOUNTGRADE = LCOUNTGRADE + 1" +
					" WHERE LKEY = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, lkey);
			pstmt.executeUpdate();
			*/
			updateL(lkey);
			
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delComment(int ckey) {
		try {
			conn = dataFactory.getConnection();
			
			String query = "DELETE FROM COMENT WHERE CKEY = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ckey);
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String queryUserNickname(int mkey) {
		String mnickname = null;
		try {
			conn = dataFactory.getConnection();
			String query = "SELECT MNICKNAME FROM MEMBER WHERE MKEY = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mkey);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				mnickname = rs.getString("MNICKNAME");
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return mnickname;
	}
	
	public void updateL(int lkey) {
		float lsumgrade = 0;
		int lcountgrade = 0;
		
		try {
			conn = dataFactory.getConnection();
			String query = "SELECT CSCORE FROM COMENT WHERE LKEY = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, lkey);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				lcountgrade++;
				lsumgrade = lsumgrade + rs.getFloat("CSCORE");
			}
			
			query = "UPDATE LECTURE SET LCOUNTGRADE = ?"+
				    " WHERE LKEY = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, lcountgrade);
			pstmt.setInt(2, lkey);
			pstmt.executeUpdate();
			
			query = "UPDATE LECTURE SET LSUMGRADE = ?"+
				    " WHERE LKEY = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setFloat(1, lsumgrade);
			pstmt.setInt(2, lkey);
			pstmt.executeUpdate();
			
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
