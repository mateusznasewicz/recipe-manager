package pl.mateusz.recipemanagerbackend.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import pl.mateusz.recipemanagerbackend.model.Recipe;
import pl.mateusz.recipemanagerbackend.repository.RecipeRepository;

import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe update(Recipe recipe){
        this.findById(recipe.getId());
        recipeRepository.save(recipe);
        return recipe;
    }

    public Recipe findById(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        return recipe.orElseThrow(() -> new EntityNotFoundException("Recipe not found"));
    }

    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Recipe delete(Long id) {
        Recipe r = this.findById(id);
        recipeRepository.deleteById(id);
        return r;
    }
}
