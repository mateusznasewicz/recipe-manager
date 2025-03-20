package pl.mateusz.recipemanagerbackend.services;

import org.springframework.stereotype.Service;
import pl.mateusz.recipemanagerbackend.models.Recipe;
import pl.mateusz.recipemanagerbackend.repositories.RecipeRepository;

import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Optional<Recipe> update(Recipe recipe){
        Optional<Recipe> r = recipeRepository.findById(recipe.getId());

        if(r.isPresent()){
            this.recipeRepository.save(recipe);
            return Optional.of(recipe);
        }else{
            return Optional.empty();
        }

    }

    public Optional<Recipe> findById(Long id) {
        return recipeRepository.findById(id);
    }

    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Optional<Recipe> delete(Long id) {
        Optional<Recipe> r = recipeRepository.findById(id);
        recipeRepository.deleteById(id);
        return r;
    }
}
