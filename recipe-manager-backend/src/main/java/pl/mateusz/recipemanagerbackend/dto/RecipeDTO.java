package pl.mateusz.recipemanagerbackend.dto;

import lombok.*;
import pl.mateusz.recipemanagerbackend.model.DifficultyLevel;
import pl.mateusz.recipemanagerbackend.model.Ingredient;
import pl.mateusz.recipemanagerbackend.model.Tag;

import java.util.List;

@Builder
@Data
public class RecipeDTO{
    private Long id;
    private String title;
    private List<Ingredient> ingredients;
    private String instructions;
    private int preparationTime;
    private DifficultyLevel difficultyLevel;
    private List<Tag> tags;
    private List<RatingDTO> ratings;
}
