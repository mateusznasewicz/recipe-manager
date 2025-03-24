package pl.mateusz.recipemanagerbackend.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import pl.mateusz.recipemanagerbackend.dto.DtoMapper;
import pl.mateusz.recipemanagerbackend.dto.UserDTO;
import pl.mateusz.recipemanagerbackend.model.User;
import pl.mateusz.recipemanagerbackend.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO findUserByUsername(String username) {
        Optional<User> user = this.userRepository.findByUsername(username);
        return DtoMapper.toDto(user.orElseThrow(() -> new EntityNotFoundException("username not found")));
    }
}
