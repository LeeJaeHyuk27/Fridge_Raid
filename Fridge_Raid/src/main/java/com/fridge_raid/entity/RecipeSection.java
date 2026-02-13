package com.fridge_raid.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "RECIPE_SECTION")
public class RecipeSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SECTION_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RECIPE_ID", nullable = false)
    private Recipe recipe;

    @Column(name = "SECTION_NO", nullable = false)
    private Integer sectionNo;

    @Column(name = "TEXT", length = 200, nullable = false)
    private String text;

    @Column(name = "IMAGE_URL", length = 1000)
    private String imageUrl;
}
