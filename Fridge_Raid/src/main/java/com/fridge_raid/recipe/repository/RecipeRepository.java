package com.fridge_raid.recipe.repository;

import com.fridge_raid.recipe.dto.BestRecipeDto;
import com.fridge_raid.entity.Recipe;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{
	
	@Query("""
		    select new com.fridge_raid.recipe.dto.BestRecipeDto(
		        r.recipeId,
		        r.title,
		        coalesce(round(avg(rv.rating), 1), 0.0),
		        count(rv),
		        coalesce(sum(rv.rating), 0L)
		    )
		    from Recipe r
		    left join Review rv on rv.recipe = r
		    group by r.recipeId, r.title
		    order by coalesce(sum(rv.rating), 0L) desc
		""")
	    List<BestRecipeDto> findBestRecipes(Pageable pageable);

}
