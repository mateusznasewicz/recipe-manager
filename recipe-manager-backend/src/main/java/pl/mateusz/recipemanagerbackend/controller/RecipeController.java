package pl.mateusz.recipemanagerbackend.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mateusz.recipemanagerbackend.dto.RecipeDTO;
import pl.mateusz.recipemanagerbackend.model.Recipe;
import pl.mateusz.recipemanagerbackend.service.RecipeService;

import java.util.Map;
import java.util.logging.Logger;


@RestController
@RequestMapping("/recipe")
public class RecipeController{
    private final RecipeService recipeService;
    private final Logger logger = Logger.getLogger(RecipeController.class.getName());

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<RecipeDTO> addRecipe(@RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipeService.save(recipe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RecipeDTO> deleteRecipe(@PathVariable Long id) {
        return ResponseEntity.ok(recipeService.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDTO> getRecipe(@PathVariable Long id) {
        RecipeDTO r = recipeService.findById(id);
        logger.info(r.toString());
        return ResponseEntity.ok(r);
    }

    @GetMapping
    public ResponseEntity<Page<RecipeDTO>> getAllRecipes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size)
    {
        return ResponseEntity.ok(recipeService.findAll(page,size));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RecipeDTO> updateRecipe(@PathVariable Long id, Map<String, Object> updates) {
        return ResponseEntity.ok(recipeService.update(id, updates));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
