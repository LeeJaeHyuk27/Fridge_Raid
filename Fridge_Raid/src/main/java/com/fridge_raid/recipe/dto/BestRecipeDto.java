package com.fridge_raid.recipe.dto;

public record BestRecipeDto(
		
		Integer recipeId,
        String title,
        Double avgRating,
        Long reviewCount,
        Long score,
        String thumbnail
	    
		) {}
