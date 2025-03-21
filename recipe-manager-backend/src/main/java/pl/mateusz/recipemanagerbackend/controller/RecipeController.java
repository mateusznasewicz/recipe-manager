package pl.mateusz.recipemanagerbackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mateusz.recipemanagerbackend.model.Recipe;
import pl.mateusz.recipemanagerbackend.service.RecipeService;

@RestController("/recipe")
public class RecipeController{
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipeService.save(recipe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Recipe> deleteRecipe(@PathVariable Long id) {
        return ResponseEntity.ok(recipeService.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable Long id) {
        return ResponseEntity.ok(recipeService.findById(id));
    }

    @PutMapping
    public ResponseEntity<Recipe> updateRecipe(@RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipeService.save(recipe));
    }
}
