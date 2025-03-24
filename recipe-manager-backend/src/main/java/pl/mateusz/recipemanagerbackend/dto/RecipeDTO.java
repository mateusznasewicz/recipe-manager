package pl.mateusz.recipemanagerbackend.dto;

import jakarta.persistence.Entity;
import lombok.*;
import pl.mateusz.recipemanagerbackend.model.DifficultyLevel;
import pl.mateusz.recipemanagerbackend.model.Ingredient;

import java.util.Set;

@Builder
@Data
public class RecipeDTO{
    private Long id;
    private String title;
    private Set<Ingredient> ingredients;
    private String instructions;
    private int preparationTime;
    private DifficultyLevel difficultyLevel;
    private Set<TagDTO> tags;
    private Set<RatingDTO> ratings;
}
