package com.zhb.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zhb.mybatis.bean.User;



/**
 * 
* <p>Title: MybatisFirst</p>  
* <p>Description:���ų��� </p>  
* @author zhb  
* @date 2018��3��12��
 */
public class MybatisFirst {
	/**
	 * �õ�sqlsession
	 * @throws IOException 
	 */
	public SqlSession getSqlSession() throws IOException{
		// mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		// �õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//�����Ự����;
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//���ݹ����õ�sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
	
	
	/**
	 * �����û�id�õ�һ�����
	 * @throws IOException 
	 */
	@Test
	public void findUserByIdTest() throws IOException{
		SqlSession sqlSession = this.getSqlSession();
		//ͨ��sqlsession�������ݿ�
		// ��һ��������ӳ���ļ���statement��id������=namespace+"."+statement��id
		// �ڶ���������ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���
		// sqlSession.selectOne��� ����ӳ���ļ�����ƥ���resultType���͵Ķ���
		// selectOne��ѯ��һ����¼
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
		sqlSession.close();
	}
	
	/**
	 * �����û�����ģ����ѯ
	 * @throws IOException
	 */
	@Test
	public void findUserByNameTest() throws IOException{
		SqlSession sqlSession = this.getSqlSession();
		List<User> list =  sqlSession.selectList("test.findUserByName","%С��%");
		System.out.println(list);
		sqlSession.close();
		
	}
	
	/**
	 * ����û�
	 * @throws IOException
	 */
	@Test
	public void addUserTest() throws IOException{
		SqlSession sqlSession = this.getSqlSession();
		User user = new User();
		user.setUsername("github");
		user.setAddress("11");
		user.setSex("1");
		user.setBirthday(new Date());
		sqlSession.insert("test.addUser",user);
		sqlSession.commit();
		System.out.println(user.getId());
		sqlSession.close();
		
	}
	
	/**
	 * ɾ���û�
	 * @throws IOException
	 */
	@Test
	public void delUserTest() throws IOException{
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.delete("test.delUser",24);
		sqlSession.commit();
		sqlSession.close();
	}
	
	/**
	 * �����û�
	 * @throws IOException
	 */
	@Test
	public void updateUserTest() throws IOException{
		SqlSession sqlSession = this.getSqlSession();
		User user = new User();
		user.setId(1);
		user.setUsername("github");
		user.setAddress("11");
		user.setSex("1");
		user.setBirthday(new Date());
		sqlSession.update("test.updateUser",user);
		sqlSession.commit();
		sqlSession.close();
	}
	
	
}
