package com.fridge_raid.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "RECIPES")
public class Recipes {

	@Id
	@Column(name = "RECIPE_ID")
    private Integer recipeId;
	
	@Column(name = "USER_ID", nullable = false, length = 50)
    private String userId;
	
	@Column(name = "TITLE", nullable = false, length = 50)
    private String title;
	
	@Column(name = "AI_DESCRIPTION", nullable = false, length = 500)
    private String aiDescription;
	
	@Column(name = "SERVINGS", nullable = false)
    private Integer servings;
	
	@Column(name = "COOK_TIME", nullable = false)
    private Integer cookTime;
	
	@Column(name = "DIFFICULTY", nullable = false, length = 10)
    private String difficulty;
	
	@Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;
	
	@Column(name = "UPDATED_AT", nullable = false)
    private LocalDateTime updatedAt;
	
	@Column(name = "THUMBNAIL", nullable = false, length = 255)
    private String thumbnail;
	
}
