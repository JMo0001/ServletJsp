package kh.test.jdbckh.board.model.dto;

import java.util.List;

public class AttachFileDto {
	
	private int bno;
	private String filepath;
	private String fileno;
	
	
	
	
	public AttachFileDto() {
		super();
	}
	public AttachFileDto(String filepath) {
		super();
		this.filepath = filepath;
	}
	@Override
	public String toString() {
		return "AttachFileDto [bno=" + bno + ", filepath=" + filepath + ", fileno=" + fileno + "]";
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getFileno() {
		return fileno;
	}
	public void setFileno(String fileno) {
		this.fileno = fileno;
	}
	
	
}
