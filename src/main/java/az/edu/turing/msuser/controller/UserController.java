package az.edu.turing.msuser.controller;

import az.edu.turing.msuser.model.dto.UserRequest;
import az.edu.turing.msuser.model.dto.UserResponse;
import az.edu.turing.msuser.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest) {
        userService.create(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully.");
    }
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.status(HttpStatus.OK).body("Test");
    }

    @GetMapping("/{fin}")
    public ResponseEntity<Optional<UserResponse>> getUserByFin(@PathVariable("fin") String fin) {
        Optional<UserResponse> userResponse = userService.getByFin(fin);
        return ResponseEntity.ok(userResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        UserResponse updatedUser = userService.update(id, userRequest);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllUsers() {
        userService.deleteAll();
        return ResponseEntity.ok("All users deleted successfully.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok("User deleted successfully.");
    }
}
