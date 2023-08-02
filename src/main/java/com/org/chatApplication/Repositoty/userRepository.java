package com.org.chatApplication.Repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.chatApplication.Entity.userInfo;

public interface userRepository extends JpaRepository<userInfo, Integer>
{

	userInfo findByEmail(String email);

}
