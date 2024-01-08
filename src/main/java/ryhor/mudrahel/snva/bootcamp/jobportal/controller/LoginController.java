package ryhor.mudrahel.snva.bootcamp.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ryhor.mudrahel.snva.bootcamp.jobportal.UserCredentials;
import ryhor.mudrahel.snva.bootcamp.jobportal.model.User;
import ryhor.mudrahel.snva.bootcamp.jobportal.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/login")
//TODO verify that ti is working
@CrossOrigin(origins = "${my.allowed.origins}")
public class LoginController {

    @Value("${my.allowed.origins}")
    private String allowedOrigins;

    @Autowired
    private UserRepository userRepository;

    /*
    Request example, POST request to http://localhost:8080/api/v1/login
    with body =raw, content type json:
    {"username": "john_doe", "password": "1234"}
    */
    @PostMapping
    public ResponseEntity<User> loginUser(@RequestBody UserCredentials userCredentials) {
        String username = userCredentials.getUsername();
        String password = userCredentials.getPassword();

        User user = userRepository.findByCredentials(username, password);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
