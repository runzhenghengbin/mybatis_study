package com.zhb.mybatis.mapper;

import com.zhb.mybatis.bean.User;

/**
 * 
* <p>Title: UserDao</p>  
* <p>Description:�û�����dao </p>  
* @author zhb  
* @date 2018��3��12��
 */
public interface UserMapper {
	
	public User findUserById(int id) throws Exception;

}
