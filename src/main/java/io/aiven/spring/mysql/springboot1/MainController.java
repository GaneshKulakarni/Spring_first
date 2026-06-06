package io.aiven.spring.mysql.springboot1;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/demo")
public class MainController {

    private final UserRepository userRepository;

    // Constructor injection for UserRepository
    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Endpoint to add a new user: POST /demo/add?name=...&email=...
    @PostMapping("/add")
    public ResponseEntity<User> addUser(
            @RequestParam String name,
            @RequestParam String email) {

        User user = new User();
        user.setName(name);
        user.setEmail(email);

        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    // Endpoint to get all users: GET /demo/all
    @GetMapping("/all")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        Iterable<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }
}