package com.zhb.mybatis.dao;

import com.zhb.mybatis.bean.User;

/**
 * 
* <p>Title: UserDao</p>  
* <p>Description:�û�����dao </p>  
* @author zhb  
* @date 2018��3��12��
 */
public interface UserDao {
	
	public User findById(int id) throws Exception;

}
