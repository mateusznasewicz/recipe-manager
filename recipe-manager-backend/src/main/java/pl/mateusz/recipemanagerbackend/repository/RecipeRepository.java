package pl.mateusz.recipemanagerbackend.repository;

import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.mateusz.recipemanagerbackend.model.Recipe;

import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @NonNull
    Page<Recipe> findAll(@NonNull Pageable pageable);
}
