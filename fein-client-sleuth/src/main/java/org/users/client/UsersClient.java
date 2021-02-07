package org.users.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.users.domain.User;

import java.util.List;

@FeignClient(name = "users-client", url = "${remote-server-url}")
public interface UsersClient {

    @PostMapping(value = "users",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    User save(User user);

    @GetMapping(value = "users",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    List<User> findAll();

    @GetMapping(value = "users/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    User findOne(@PathVariable("id") String id);

    @PutMapping(value = "users/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    User update(@PathVariable("id") String id, @RequestBody User user);

    @DeleteMapping(value = "users/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("id") String id);

    @GetMapping(value = "users/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    Boolean exists(@PathVariable("id") String id);
}
