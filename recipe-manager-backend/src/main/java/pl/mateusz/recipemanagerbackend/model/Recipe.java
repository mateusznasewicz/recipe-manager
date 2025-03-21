package pl.mateusz.recipemanagerbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import pl.mateusz.recipemanagerbackend.enums.DifficultyLevel;
import pl.mateusz.recipemanagerbackend.enums.RecipeTag;

import java.util.Set;

@Entity
@Getter
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToMany
    @JoinTable(
            name = "recipe_ingredients",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Set<Ingredient> ingredients;

    @Column(nullable = false)
    private String instructions;

    @Column(nullable = false)
    private int preparationTime;

    @Enumerated(EnumType.STRING)
    private DifficultyLevel difficultyLevel;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Set<RecipeTag> tags;
}
