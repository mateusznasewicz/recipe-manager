package pl.mateusz.recipemanagerbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mateusz.recipemanagerbackend.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
