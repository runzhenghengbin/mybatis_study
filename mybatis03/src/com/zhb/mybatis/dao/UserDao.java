package com.zhb.mybatis.dao;

import com.zhb.mybatis.bean.User;

/**
 * 
* <p>Title: UserDao</p>  
* <p>Description:用户管理dao </p>  
* @author zhb  
* @date 2018年3月12日
 */
public interface UserDao {
	
	public User findById(int id) throws Exception;

}
