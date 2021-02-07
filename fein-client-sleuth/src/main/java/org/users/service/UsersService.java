package org.users.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.users.client.UsersClient;
import org.users.domain.User;

import java.util.List;

@Service
@Slf4j
public class UsersService {

    @Autowired
    private UsersClient usersClient;

    public User save(User user){
        log.info("Creating user: {}", user);
        return usersClient.save(user);
    }

    public User update(User user){
        log.info("Updating user: {}", user);
        return usersClient.update(user.getId(), user);
    }

    public List<User> findAll(){
        log.info("Finding all users");
        return usersClient.findAll();
    }

    public User findOne(String id){
        log.info("Finding user by id: {}", id);
        return usersClient.findOne(id);
    }

    public void delete(String id){
        log.info("Deleting user by id: {}", id);
        usersClient.delete(id);
    }

    public boolean exists(String id){
        log.info("Check if user exists by id: {}", id);
        User user = null;
        try {
            user = usersClient.findOne(id);
        } catch (Exception e){
            log.error("Failed finding user with id: {}", id);
        }
        return ObjectUtils.isNotEmpty(user);
    }
}
