package com.fridge_raid.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fridge_raid.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
