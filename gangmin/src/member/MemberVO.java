package member;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberVO {
	private String mid;
	private String mpw;
	private String mname;
	private String mnickname;
	private String mhp;
	private String maddress;
	private String mmail;
	private Date mtime;
	private String mbirthday;
	private int madmin;
	
	public MemberVO(String mid, String mpw, String mname, String mnickname, String mhp, String maddress, 
			 String mmail, String mbirthday, int madmin) {
			super();
			this.mid = mid;
			this.mpw = mpw;
			this.mname = mname;
			this.mnickname = mnickname;
			this.mhp = mhp;
			this.maddress = maddress;
			this.mmail = mmail;
			this.mtime = mtime;
			this.mbirthday = mbirthday;
			this.madmin = madmin;
	}
	
	public String getMid() {
		return mid;
	}
	
	public void setMid(String mid) {
		this.mid = mid;
	}
	
	public String getMpw() {
		return mpw;
	}
	
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	
	public String getMname() {
		return mname;
	}
	
	public void setMname(String mname) {
		this.mname = mname;
	}
	
	public String getMnickname() {
		return mnickname;
	}
	
	public void setMnickname(String mnickname) {
		this.mnickname = mnickname;
	}
	
	public String getMhp() {
		return mhp;
	}
	
	public void setMhp(String mhp) {
		this.mhp = mhp;
	}
	
	public String getMaddress() {
		return maddress;
	}
	
	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}
	
	public String getMmail() {
		return mmail;
	}
	
	public void setMail(String mmail) {
		this.mmail = mmail;
	}
	
	public String getMbirthday() {
		return mbirthday;
	}
	
	public void setMbirthday(String mbirthday) {
		this.mbirthday = mbirthday;
	}

	public Date getMtime() {
		return mtime;
	}

	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}

	public int getMadmin() {
		return madmin;
	}

	public void setMadmin(int madmin) {
		this.madmin = madmin;
	}
	
}
