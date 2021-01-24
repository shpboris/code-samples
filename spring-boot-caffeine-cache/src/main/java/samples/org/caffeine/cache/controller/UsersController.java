package samples.org.caffeine.cache.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import samples.org.caffeine.cache.domain.User;
import samples.org.caffeine.cache.service.UsersService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UsersController {

    private final UsersService usersService;

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(usersService.findAll());
    }

    @GetMapping("/users/{userId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<User> findById(@PathVariable("userId") String userId) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(usersService.findById(userId));
    }
}
