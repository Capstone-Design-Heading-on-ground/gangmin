package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addMember(MemberVO m) {
		try {
			conn = dataFactory.getConnection();
			String mid = m.getMid();
			String mpw = m.getMpw();
			String mname = m.getMname();
			String mnickname = m.getMnickname();
			String mhp = m.getMhp();
			String maddress = m.getMaddress();
			String mmail = m.getMmail();
			String mbirthday = m.getMbirthday();
			int madmin = m.getMadmin();
			
			String query = "INSERT INTO MEMBER(MKEY, MID, MPW, MNAME, MNICKNAME,MHP, MADDRESS, MMAIL, MBIRTHDAY, MADMIN)" +
						   " VALUES(tmp_seq.nextVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mid);
			pstmt.setString(2, mpw);
			pstmt.setString(3, mname);
			pstmt.setString(4, mnickname);
			pstmt.setString(5, mhp);
			pstmt.setString(6, maddress);
			pstmt.setString(7, mmail);
			pstmt.setString(8, mbirthday);
			pstmt.setInt(9, madmin);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public MemberVO loginMember(String inserted_id) {
		String mid="nonexistent";
		MemberVO memberVO = new MemberVO();
		try {
			conn = dataFactory.getConnection();
			String query = "SELECT * FROM MEMBER WHERE MID = ?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inserted_id);
			System.out.println(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int mkey = rs.getInt("MKEY");
				mid = rs.getString("MID");
				String mpw = rs.getString("MPW");
				String mname = rs.getString("MNAME");
				String mnickname = rs.getString("MNICKNAME");
				String mhp = rs.getString("MHP");
				String maddress = rs.getString("MADDRESS");
				String mmail = rs.getString("MMAIL");
				Date mtime = rs.getDate("MTIME");
				String mbirthday = rs.getString("MBIRTHDAY");
				int madmin = rs.getInt("MADMIN");
				System.out.println("hi1");
				memberVO = new MemberVO(mkey,mid,mpw,mname,mnickname,mhp,maddress,mmail,mtime,mbirthday,madmin);
			}
			if(mid.equals("nonexistent")) {
				memberVO = new MemberVO();
				memberVO.setMid(mid);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch (SQLException e) {
			System.out.println("hi2");
			e.printStackTrace();
		}
		return memberVO;
	}
}
