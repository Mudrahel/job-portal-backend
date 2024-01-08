package ryhor.mudrahel.snva.bootcamp.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ryhor.mudrahel.snva.bootcamp.jobportal.UserCredentials;
import ryhor.mudrahel.snva.bootcamp.jobportal.model.User;
import ryhor.mudrahel.snva.bootcamp.jobportal.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "${my.allowed.origins}")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /*
     Request example, POST request to http://localhost:8080/api/v1/users
     with body =raw, content type json:
     {"username": "john_doe", "password": "1234"}
     */
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

}
