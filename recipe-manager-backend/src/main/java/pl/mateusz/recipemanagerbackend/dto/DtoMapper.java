package pl.mateusz.recipemanagerbackend.dto;

import pl.mateusz.recipemanagerbackend.model.Rating;
import pl.mateusz.recipemanagerbackend.model.Recipe;
import pl.mateusz.recipemanagerbackend.model.Tag;
import pl.mateusz.recipemanagerbackend.model.User;

import java.util.stream.Collectors;

public class DtoMapper {
    public static RecipeDTO toDto(Recipe recipe) {
        return RecipeDTO.builder()
                .id(recipe.getId())
                .title(recipe.getTitle())
                .ingredients(recipe.getIngredients())
                .instructions(recipe.getInstructions())
                .preparationTime(recipe.getPreparationTime())
                .difficultyLevel(recipe.getDifficultyLevel())
                .tags(recipe.getTags().stream().map(DtoMapper::toDto).collect(Collectors.toSet()))
                .ratings(recipe.getRatings().stream().map(DtoMapper::toDto).collect(Collectors.toSet()))
                .build();
    }

    public static RatingDTO toDto(Rating rating) {
        return RatingDTO.builder()
                .recipeId(rating.getRecipe().getId())
                .username(rating.getUser().getUsername())
                .recipeName(rating.getRecipe().getTitle())
                .comment(rating.getComment())
                .score(rating.getScore())
                .build();
    }

    public static TagDTO toDto(Tag tags) {
        return TagDTO.builder()
                .id(tags.getId())
                .label(tags.getLabel())
                .build();
    }

    public static UserDTO toDto(User user) {
        return UserDTO.builder()
                .username(user.getUsername())
                .ratings(user.getRatings().stream().map(DtoMapper::toDto).collect(Collectors.toSet()))
                .build();
    }
}
