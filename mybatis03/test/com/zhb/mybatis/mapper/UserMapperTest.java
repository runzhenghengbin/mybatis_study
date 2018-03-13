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

	// �˷�������ִ��testFindUserById֮ǰִ��
	@Before
	public void setUp() throws Exception {
		// ����sqlSessionFactory

		// mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		// �õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// �����Ự����������mybatis�������ļ���Ϣ
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
