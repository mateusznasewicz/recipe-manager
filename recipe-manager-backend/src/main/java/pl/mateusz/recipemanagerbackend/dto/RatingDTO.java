package pl.mateusz.recipemanagerbackend.dto;

import lombok.*;

@Builder
@Data
public class RatingDTO {
    private Long recipeId;
    private String username;
    private String recipeName;
    private String comment;
    private double score;
}
