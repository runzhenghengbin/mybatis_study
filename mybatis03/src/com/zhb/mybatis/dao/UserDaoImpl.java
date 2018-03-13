package com.zhb.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.zhb.mybatis.bean.User;

/**
 * 
* <p>Title: UserDaoImpl</p>  
* <p>Description: 接口实现类</p>  
* @author zhb  
* @date 2018年3月12日
 */
public class UserDaoImpl implements UserDao{
	
	private SqlSessionFactory sqlSessionFactory;
	
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findById(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById", 1);
		sqlSession.close();
		return user;
	}
	

}
