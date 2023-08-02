package com.org.chatApplication.Service;

import com.org.chatApplication.Entity.userInfo;

public interface userService 
{

	String saveuser(userInfo user);

	userInfo getUserByEmail(String email);

}
