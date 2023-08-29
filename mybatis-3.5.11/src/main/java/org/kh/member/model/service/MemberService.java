package org.kh.member.model.service;

import org.apache.ibatis.session.SqlSession;
import org.kh.member.model.dao.MemberDao;
import org.kh.member.model.vo.MemberVo;
import org.kh.member.tem.mybatisTemplate;

public class MemberService {
	
	private MemberDao dao = new MemberDao();
	
	public int insertMember(MemberVo mOne) {
		SqlSession session = mybatisTemplate.getSqlSession(false);
		int result = dao.insertMember(session, mOne);
		
		if(result >0) {
			session.commit();
		}else {
			session.rollback();
		}
		return result;
	}

}
