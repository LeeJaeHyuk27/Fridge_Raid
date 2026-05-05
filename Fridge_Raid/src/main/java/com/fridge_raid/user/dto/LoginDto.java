package com.fridge_raid.user.dto;

public record LoginDto(
		
			String userId,
			String passwordHash	
		
		) {}