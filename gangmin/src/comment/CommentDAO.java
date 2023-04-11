package comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
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
				Date cdate = rs.getDate("CDATE");
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
}
