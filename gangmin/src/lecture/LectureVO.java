package lecture;

import java.util.Date;

public class LectureVO {
	private int lkey;
	private String lid;
	private String lname;
	private String ltype;
	private String lsubject;
	private String lunit;
	private String luser;
	private String lcreate;
	private String llevel;
	private int ltime;
	private int lprice;
	private int lduration;
	private String linfo;
	private String ltarget;
	private String limage;
	private Date lstartdate;
	private int lsumgrade;
	private int lcountgrade;
	
	public LectureVO() {}
	
	public LectureVO(int lkey, String lid, String lname, String ltype, String lsubject, String lunit
			,String luser, String lcreate, String llevel, int ltime, int lprice, int lduration, String linfo,
			String ltarget, String limage, Date lstartdate, int lsumgrade, int lcountgrade) 
	{
		this.lkey = lkey;
		this.lid = lid;
		this.lname = lname;
		this.ltype = ltype;
		this.lsubject = lsubject;
		this.lunit = lunit;
		this.luser = luser;
		this.lcreate = lcreate;
		this.llevel = llevel;
		this.ltime = ltime;
		this.lprice = lprice;
		this.lduration = lduration;
		this.linfo = linfo;
		this.ltarget = ltarget;
		this.limage = limage;
		this.lstartdate = lstartdate;
		this.lsumgrade = lsumgrade;
		this.lcountgrade = lcountgrade;
	}
	
	public int getLkey() {
		return lkey;
	}
	public void setLkey(int lkey) {
		this.lkey = lkey;
	}
	public String getLid() {
		return lid;
	}
	public void setLid(String lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLtype() {
		return ltype;
	}
	public void setLtype(String ltype) {
		this.ltype = ltype;
	}
	public String getLsubject() {
		return lsubject;
	}
	public void setLsubject(String lsubject) {
		this.lsubject = lsubject;
	}
	public String getLunit() {
		return lunit;
	}
	public void setLunit(String lunit) {
		this.lunit = lunit;
	}
	public String getLuser() {
		return luser;
	}
	public void setLuser(String luser) {
		this.luser = luser;
	}
	public String getLcreate() {
		return lcreate;
	}
	public void setLcreate(String lcreate) {
		this.lcreate = lcreate;
	}
	public String getLlevel() {
		return llevel;
	}
	public void setLlevel(String llevel) {
		this.llevel = llevel;
	}
	public int getLtime() {
		return ltime;
	}
	public void setLtime(int ltime) {
		this.ltime = ltime;
	}
	public int getLprice() {
		return lprice;
	}
	public void setLprice(int lprice) {
		this.lprice = lprice;
	}
	public int getLduration() {
		return lduration;
	}
	public void setLduration(int lduration) {
		this.lduration = lduration;
	}
	public String getLinfo() {
		return linfo;
	}
	public void setLinfo(String linfo) {
		this.linfo = linfo;
	}
	public String getLtarget() {
		return ltarget;
	}
	public void setLtarget(String ltarget) {
		this.ltarget = ltarget;
	}
	public String getLimage() {
		return limage;
	}
	public void setLimage(String limage) {
		this.limage = limage;
	}
	public Date getLstartdate() {
		return lstartdate;
	}
	public void setLstartdate(Date lstartdate) {
		this.lstartdate = lstartdate;
	}
	public int getLsumgrade() {
		return lsumgrade;
	}
	public void setLsumgrade(int lsumgrade) {
		this.lsumgrade = lsumgrade;
	}
	public int getLcountgrade() {
		return lcountgrade;
	}
	public void setLcountgrade(int lcountgrade) {
		this.lcountgrade = lcountgrade;
	}
	
}
