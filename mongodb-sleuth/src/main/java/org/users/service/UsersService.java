package org.users.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.users.domain.User;
import org.users.repository.UsersRepository;

import java.util.List;

@Service
@Slf4j
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public User save(User user){
        log.info("Creating user: {}", user);
        return usersRepository.save(user);
    }

    public List<User> findAll(){
        log.info("Finding all users");
        return usersRepository.findAll();
    }

    public User findOne(String id){
        log.info("Finding user by id: {}", id);
        return usersRepository.findById(id).orElse(null);
    }

    public void delete(String id){
        log.info("Deleting user by id: {}", id);
        usersRepository.deleteById(id);
    }

    public boolean exists(String id){
        log.info("Check if user exists by id: {}", id);
        return ObjectUtils.isNotEmpty(usersRepository.findById(id).orElse(null));
    }
}
