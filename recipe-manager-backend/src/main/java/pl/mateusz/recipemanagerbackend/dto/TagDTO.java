package pl.mateusz.recipemanagerbackend.dto;

import lombok.*;

@Builder
@Data
public class TagDTO {
    private Long id;
    private String label;
}
