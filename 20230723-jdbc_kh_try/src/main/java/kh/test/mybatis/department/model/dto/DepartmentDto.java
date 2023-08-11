package kh.test.mybatis.department.model.dto;

public class DepartmentDto {

	
	private String departmentNo;
	private String departmentName;
	private String category;
	private String openYn;
	private Integer capacity;
	
	
	
	public DepartmentDto() {
		super();
	}
	public DepartmentDto(String departmentNo, String departmentName, String category, String openYn, Integer capacity) {
		super();
		this.departmentNo = departmentNo;
		this.departmentName = departmentName;
		this.category = category;
		this.openYn = openYn;
		this.capacity = capacity;
	}
	@Override
	public String toString() {
		return "DepartmentDto [departmentNo=" + departmentNo + ", departmentName=" + departmentName + ", category="
				+ category + ", openYn=" + openYn + ", capacity=" + capacity + "]";
	}
	public String getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getOpenYn() {
		return openYn;
	}
	public void setOpenYn(String openYn) {
		this.openYn = openYn;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	
	
}
