package org.users.service;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.users.domain.User;
import org.users.repository.UsersRepository;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public User save(User user){
        return usersRepository.save(user);
    }

    public List<User> findAll(){
        return usersRepository.findAll();
    }

    public User findOne(String id){
        return usersRepository.findById(id).orElse(null);
    }

    public void delete(String id){
        usersRepository.deleteById(id);
    }

    public boolean exists(String id){
        return ObjectUtils.isNotEmpty(usersRepository.findById(id).orElse(null));
    }
}
