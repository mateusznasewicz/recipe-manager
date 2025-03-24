package pl.mateusz.recipemanagerbackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mateusz.recipemanagerbackend.dto.UserDTO;
import pl.mateusz.recipemanagerbackend.model.User;
import pl.mateusz.recipemanagerbackend.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    private ResponseEntity<UserDTO> findByUsername(@PathVariable String username) {
        return ResponseEntity.ok(this.userService.findUserByUsername(username));
    }
}
