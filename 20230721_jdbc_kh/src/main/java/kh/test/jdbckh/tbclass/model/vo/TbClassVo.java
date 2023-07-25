package kh.test.jdbckh.tbclass.model.vo;

public class TbClassVo {
	
//	이름                    널?       유형           
//			--------------------- -------- ------------ 
//			CLASS_NO              NOT NULL VARCHAR2(10) 
//			DEPARTMENT_NO         NOT NULL VARCHAR2(20) 
//			PREATTENDING_CLASS_NO          VARCHAR2(20) 
//			CLASS_NAME            NOT NULL VARCHAR2(60) 
//			CLASS_TYPE                     VARCHAR2(20) 
	
	private String classNo;
	private String departmentNo;
	private String preattendingClassNo;
	private String className;
	private String classtype;
	private String classname2;
	
	@Override
	public String toString() {
		return "TbClassVo [classNo=" + classNo + ", departmentNo=" + departmentNo + ", preattendingClassNo="
				+ preattendingClassNo + ", className=" + className + ", classtype=" + classtype + ", classname2="
				+ classname2 + "]";
	}
	public String getClassNo() {
		return classNo;
	}
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}
	public String getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	public String getPreattendingClassNo() {
		return preattendingClassNo;
	}
	public void setPreattendingClassNo(String preattendingClassNo) {
		this.preattendingClassNo = preattendingClassNo;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClasstype() {
		return classtype;
	}
	public void setClasstype(String classtype) {
		this.classtype = classtype;
	}
	public String getClassname2() {
		return classname2;
	}
	public void setClassname2(String classname2) {
		this.classname2 = classname2;
	}
	
	
}
