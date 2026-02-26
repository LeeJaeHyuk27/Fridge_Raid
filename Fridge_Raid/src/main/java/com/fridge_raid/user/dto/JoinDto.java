package com.fridge_raid.user.dto;

public record JoinDto(
		
		String userId,
		String passwordHash,
		String userName
		
		) {}
