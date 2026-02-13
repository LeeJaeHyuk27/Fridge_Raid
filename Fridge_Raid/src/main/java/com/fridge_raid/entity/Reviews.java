package com.fridge_raid.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "REVIEWS")
public class Reviews {

	@Id
	@Column(name = "REVIEW_ID")
	private Integer reviewId;
	
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "RECIPE_ID")
	private Integer recipeId;
	
	@Column(name = "RATING")
	private Integer rating;
	
	@Column(name = "COMMENT")
	private String comment;
	
	@Column(name = "CREATED_AT")
	private LocalDateTime createdAt;
	
}
