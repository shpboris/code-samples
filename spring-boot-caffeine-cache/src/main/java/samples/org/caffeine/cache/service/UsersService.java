package samples.org.caffeine.cache.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import samples.org.caffeine.cache.domain.User;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UsersService {

    private List<User> users = new ArrayList<>();

    @PostConstruct
    private void init(){
        users.add(new User("1", "user1"));
        users.add(new User("2", "user2"));
        users.add(new User("3", "user3"));
        users.add(new User("4", "user4"));
    }

    public List<User> findAll(){
        log.info("In findAll");
        return users;
    }

    @Cacheable(value = "users", key = "#id")
    public User findById(String id){
        log.info("In findById, id is: {}", id);
        return users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }

}
