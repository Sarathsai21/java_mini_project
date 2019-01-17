package com.cg.banking.dao;

public interface QueryMapper {
	public static final String usercheck = "select user_Id,login_password from User_Table where user_Id=? and login_password=?";

}
