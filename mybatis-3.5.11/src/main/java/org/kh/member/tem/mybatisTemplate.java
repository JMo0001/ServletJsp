package org.kh.member.tem;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class mybatisTemplate {
	
	public static SqlSession getSqlSession(boolean autoCommit) {
		SqlSession session = null;
		
		try {
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
			session = factory.openSession(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return session;
	}

}
