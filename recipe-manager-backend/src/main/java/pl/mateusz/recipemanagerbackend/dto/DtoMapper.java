package pl.mateusz.recipemanagerbackend.dto;

import pl.mateusz.recipemanagerbackend.model.Rating;
import pl.mateusz.recipemanagerbackend.model.Recipe;
import pl.mateusz.recipemanagerbackend.model.User;

import java.util.stream.Collectors;

public class DtoMapper {
    public static RecipeDTO toDto(Recipe recipe) {
        return RecipeDTO.builder()
                .id(recipe.getId())
                .title(recipe.getTitle())
                .author(recipe.getAuthor().getUsername())
                .ingredients(recipe.getIngredients())
                .instructions(recipe.getInstructions())
                .preparationTime(recipe.getPreparationTime())
                .difficultyLevel(recipe.getDifficultyLevel())
                .tags(recipe.getTags())
                .ratings(recipe.getRatings().stream().map(DtoMapper::toDto).collect(Collectors.toList()))
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

    public static UserDTO toDto(User user) {
        return UserDTO.builder()
                .username(user.getUsername())
                .ratings(user.getRatings().stream().map(DtoMapper::toDto).collect(Collectors.toList()))
                .authorOf(user.getAuthorOf().stream().map(DtoMapper::toDto).collect(Collectors.toList()))
                .build();
    }
}
