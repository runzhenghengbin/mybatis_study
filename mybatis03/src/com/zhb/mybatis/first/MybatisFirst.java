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
* <p>Description:入门程序 </p>  
* @author zhb  
* @date 2018年3月12日
 */
public class MybatisFirst {
	/**
	 * 得到sqlsession
	 * @throws IOException 
	 */
	public SqlSession getSqlSession() throws IOException{
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂;
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//根据工厂得到sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
	
	
	/**
	 * 根据用户id得到一条结果
	 * @throws IOException 
	 */
	@Test
	public void findUserByIdTest() throws IOException{
		SqlSession sqlSession = this.getSqlSession();
		//通过sqlsession操作数据库
		// 第一个参数：映射文件中statement的id，等于=namespace+"."+statement的id
		// 第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		// sqlSession.selectOne结果 是与映射文件中所匹配的resultType类型的对象
		// selectOne查询出一条记录
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
		sqlSession.close();
	}
	
	/**
	 * 根据用户姓名模糊查询
	 * @throws IOException
	 */
	@Test
	public void findUserByNameTest() throws IOException{
		SqlSession sqlSession = this.getSqlSession();
		List<User> list =  sqlSession.selectList("test.findUserByName","%小明%");
		System.out.println(list);
		sqlSession.close();
		
	}
	
	/**
	 * 添加用户
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
	 * 删除用户
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
	 * 更新用户
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
