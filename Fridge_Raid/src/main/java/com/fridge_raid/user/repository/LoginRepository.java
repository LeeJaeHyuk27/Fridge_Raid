package com.fridge_raid.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fridge_raid.entity.UserInfo;
import java.util.Optional;

public interface LoginRepository extends JpaRepository<UserInfo, String>{
	
	Optional<UserInfo> findByUserId(String userId);

}
