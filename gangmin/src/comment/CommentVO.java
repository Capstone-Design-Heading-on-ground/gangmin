package comment;

import java.util.Date;

public class CommentVO {
	private int ckey;
	private String ccontent;
	private int lkey;
	private int mkey;
	private int crecommend;
	private Date cdate;
	private float cscore;
	
	public int getCkey() {
		return ckey;
	}
	
	public void setCkey(int ckey) {
		this.ckey = ckey;
	}
	
	public String getCcontent() {
		return ccontent;
	}
	
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	
	public int getLkey() {
		return lkey;
	}
	
	public void setLkey(int lkey) {
		this.lkey = lkey;
	}
	
	public int getMkey() {
		return mkey;
	}
	
	public void setMkey(int mkey) {
		this.mkey = mkey;
	}
	
	public int getCrecommend() {
		return crecommend;
	}
	
	public void setCrecommend(int crecommend) {
		this.crecommend = crecommend;
	}
	
	public Date getCdate() {
		return cdate;
	}
	
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	
	public float getCscore() {
		return cscore;
	}
	
	public void setCscore(float cscore) {
		this.cscore = cscore;
	}
	
}
