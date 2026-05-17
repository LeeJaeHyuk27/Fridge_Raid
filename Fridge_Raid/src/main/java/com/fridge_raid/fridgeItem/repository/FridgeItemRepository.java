package com.fridge_raid.fridgeItem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fridge_raid.entity.FridgeItem;
import com.fridge_raid.entity.FridgeItemId;

public interface FridgeItemRepository extends JpaRepository<FridgeItem, FridgeItemId>{
	
	List<FridgeItem> findByUser_UserId(String userId);

}
