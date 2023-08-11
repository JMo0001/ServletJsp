package kh.test.mybatis.department.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.test.mybatis.department.model.dto.DepartmentDto;

public class DepartmentDao {
	
	public List<DepartmentDto> selectList(SqlSession session){
		List<DepartmentDto> result = session.selectList("dept1.selectList");
		return result;
	}

}
