package kh.test.jdbckh.board.model.dto.param;

import java.util.List;

import kh.test.jdbckh.board.model.dto.AttachFileDto;

public class BoardReplyReq {

//	----------- -------- -------------- 
//	BNO         NOT NULL NUMBER         
//	BTITLE      NOT NULL VARCHAR2(300)  
//	BCONTENT             VARCHAR2(4000) 
//	BWRITE_DATE NOT NULL TIMESTAMP(6)   
//	MID         NOT NULL VARCHAR2(20)   
//	BREF        NOT NULL NUMBER         
//	BRE_LEVEL   NOT NULL NUMBER         
//	BRE_STEP    NOT NULL NUMBER  
	private String btitle;
	private String bcontent;
	private String mid;
	//1:n관계
//	private List<String> filepath;
	private List<AttachFileDto> attachFileList;
	
	
	
	
	//원본글 등록 view > controller > dao
	//					controller 에서 생성 > parma으로 전달 > dao
	public BoardReplyReq(String btitle, String bcontent, String mid /*List<AttachFileDto> attachFileList*/) {
		super();	//필수 항목들은 행성자를 통해 빠짐없이 값들이 들어갈 수 있도록 함.
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.mid = mid;
//		this.attachFileList = attachFileList;	<< 옵션. 넣을수도 안넣을수도.
	}

	@Override
	public String toString() {
		return "BoardReq [btitle=" + btitle + ", bcontent=" + bcontent + ", mid=" + mid + ", attachFileList="
				+ attachFileList + "]";
	}

	public String getBtitle() {
		return btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public String getMid() {
		return mid;
	}

	public List<AttachFileDto> getAttachFileList() {
		return attachFileList;
	}
	// 옵션인 항목인 경우에만 setter 작성
	public void setAttachFileList(List<AttachFileDto> attachFileList) {
		this.attachFileList = attachFileList;
	}


}
