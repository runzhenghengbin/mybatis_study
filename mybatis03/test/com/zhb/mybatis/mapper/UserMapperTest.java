package com.zhb.mybatis.mapper;



import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.zhb.mybatis.bean.User;

public class UserMapperTest {

	private SqlSessionFactory sqlSessionFactory;

	// 此方法是在执行testFindUserById之前执行
	@Before
	public void setUp() throws Exception {
		// 创建sqlSessionFactory

		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入mybatis的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
	}
	@Test
	public void testFindUserById() throws Exception {
		SqlSession  SqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = SqlSession.getMapper(UserMapper.class);
		
		User  user = userMapper.findUserById(1);
		SqlSession.close();
		System.out.println(user);
		
	}

}
