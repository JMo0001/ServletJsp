package org.kh.member.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.kh.member.model.vo.MemberVo;

public class MemberDao {
	
	public int insertMember(SqlSession session, MemberVo mOne) {
		int result = session.insert("member.insert", mOne);
		return result;
	}

}
