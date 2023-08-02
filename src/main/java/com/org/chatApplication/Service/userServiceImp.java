package com.org.chatApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.chatApplication.Entity.userInfo;
import com.org.chatApplication.Repositoty.userRepository;

@Service
public class userServiceImp implements userService 
{

	@Autowired
	private userRepository repository;
	
	@Override
	public String saveuser(userInfo user) 
	{
		userInfo saveuser=repository.save(user);
		return saveuser.getEmail();
	}

	@Override
	public userInfo getUserByEmail(String email) 
	{
		
		return repository.findByEmail(email);
	}

}
