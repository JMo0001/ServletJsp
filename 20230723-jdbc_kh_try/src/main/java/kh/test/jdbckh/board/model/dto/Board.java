package kh.test.jdbckh.board.model.dto;

public class Board {
//	BNO         NOT NULL NUMBER         
//	BTITLE      NOT NULL VARCHAR2(300)  
//	BCONTENT             VARCHAR2(4000) 
//	BWRITE_DATE NOT NULL TIMESTAMP(6)   
//	MID         NOT NULL VARCHAR2(20)   
//	BREF        NOT NULL NUMBER         
//	BRE_LEVEL   NOT NULL NUMBER         
//	BRE_STEP    NOT NULL NUMBER  
	
	private int bno;
	private String btitle;
	private String bcontent;
	private String bwriteDate;
	private String mid;
	private int bref;
	private int breLevel;
	private int breStep;
	
	
	
	// 게시글 하나 보기
	public Board(int bno, String btitle, String bcontent, String bwriteDate, String mid, int bref, int breLevel,
			int breStep) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriteDate = bwriteDate;
		this.mid = mid;
		this.bref = bref;
		this.breLevel = breLevel;
		this.breStep = breStep;
	}
	
	//전체보기 (content 없음)
	public Board(int bno, String btitle, String bwriteDate, String mid, int bref, int breLevel, int breStep) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bwriteDate = bwriteDate;
		this.mid = mid;
		this.bref = bref;
		this.breLevel = breLevel;
		this.breStep = breStep;
	}

	//글 등록
	public Board(String btitle, String bcontent, String mid) {
		super();
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.mid = mid;
	}
	
	

	//답글 등록
	public Board(int bno, String btitle, String bcontent, String mid) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "Board [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bwriteDate=" + bwriteDate
				+ ", mid=" + mid + ", bref=" + bref + ", breLevel=" + breLevel + ", breStep=" + breStep + "]";
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getbwriteDate() {
		return bwriteDate;
	}
	public void setbwriteDate(String bwriteDate) {
		this.bwriteDate = bwriteDate;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getBref() {
		return bref;
	}
	public void setBref(int bref) {
		this.bref = bref;
	}
	public int getBreLevel() {
		return breLevel;
	}
	public void setBreLevel(int breLevel) {
		this.breLevel = breLevel;
	}
	public int getBreStep() {
		return breStep;
	}
	public void setBreStep(int breStep) {
		this.breStep = breStep;
	}
	
	
	
}
