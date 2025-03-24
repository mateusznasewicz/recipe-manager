package pl.mateusz.recipemanagerbackend.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class UserDTO {
    private String username;
    private Set<RatingDTO> ratings;
}
