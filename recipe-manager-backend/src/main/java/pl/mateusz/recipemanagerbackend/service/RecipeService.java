package pl.mateusz.recipemanagerbackend.service;

import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import pl.mateusz.recipemanagerbackend.dto.DtoMapper;
import pl.mateusz.recipemanagerbackend.dto.RecipeDTO;
import pl.mateusz.recipemanagerbackend.model.Recipe;
import pl.mateusz.recipemanagerbackend.repository.RecipeRepository;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final Logger logger = LoggerFactory.getLogger(RecipeService.class);

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public RecipeDTO update(Long id, Map<String, Object> updates){
        Recipe recipe = recipeRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Recipe.class, key);
            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, recipe, value);
            }
        });
        recipeRepository.save(recipe);

        return DtoMapper.toDto(recipe);
    }

    public RecipeDTO findById(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        return DtoMapper.toDto(recipe.orElseThrow(() -> new EntityNotFoundException("Recipe not found")));
    }

    public Page<RecipeDTO> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Recipe> recipes = recipeRepository.findAll(pageable);
        return recipes.map(DtoMapper::toDto);
    }

    public RecipeDTO save(Recipe recipe) {
        recipeRepository.save(recipe);
        return DtoMapper.toDto(recipe);
    }

    public RecipeDTO delete(Long id) {
        RecipeDTO r = this.findById(id);
        recipeRepository.deleteById(id);
        return r;
    }
}
