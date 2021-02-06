package org.users.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.users.domain.User;

public interface UsersRepository extends MongoRepository<User, String> {
}
