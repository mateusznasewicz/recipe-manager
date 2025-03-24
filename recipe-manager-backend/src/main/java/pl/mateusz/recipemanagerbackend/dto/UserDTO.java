package pl.mateusz.recipemanagerbackend.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserDTO {
    private String username;
    private List<RatingDTO> ratings;
    private List<RecipeDTO> authorOf;
}
