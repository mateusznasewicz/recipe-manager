package pl.mateusz.recipemanagerbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mateusz.recipemanagerbackend.models.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
