package kh.test.mybatis.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisTemplate {


	 public static SqlSession getSqlSession() {
		 String resource ="mybatis/mybatis-config.xml"; 
		 SqlSession session = null; 	//connection 역할
		 try {
			 //inputStream으로 mybatis의 정보를 읽어 온다.
			InputStream is = Resources.getResourceAsStream(resource);
			//읽어 온 Mybatis의 설정 정보를 바탕으로 sqlSessionFactoryBuilder를 생성한다.
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(is);
			session = factory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		 return session;
	 }
	 

}
