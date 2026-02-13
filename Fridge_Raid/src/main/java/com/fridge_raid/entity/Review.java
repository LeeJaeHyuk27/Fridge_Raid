package com.fridge_raid.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "REVIEW")
public class Review {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEW_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserInfo user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RECIPE_ID", nullable = false)
    private Recipe recipe;

    @Column(name = "RATING", nullable = false)
    private Integer rating; // 1~5

    @Column(name = "COMMENT", length = 2000)
    private String comment;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;
	
}
