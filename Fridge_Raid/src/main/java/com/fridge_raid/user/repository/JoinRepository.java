package com.fridge_raid.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fridge_raid.entity.UserInfo;

public interface JoinRepository extends JpaRepository<UserInfo, String>{
	
	boolean existsByUserId(String userId);
	
	boolean existsByUserName(String userName);
	
}
