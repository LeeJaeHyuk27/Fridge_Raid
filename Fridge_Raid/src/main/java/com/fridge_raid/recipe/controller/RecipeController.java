package com.fridge_raid.recipe.controller;

import com.fridge_raid.recipe.dto.BestRecipeDto;
import com.fridge_raid.recipe.repository.RecipeRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
@CrossOrigin(origins = "http://localhost:3000")
public class RecipeController {

    private final RecipeRepository recipeRepository;

    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/best")
    public List<BestRecipeDto> getBestRecipes() {
        return recipeRepository.findBestRecipes(PageRequest.of(0, 5));
    }

}
