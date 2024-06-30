package com.melashvili.userend.repository;

import com.melashvili.userend.model.entitites.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String username);
}
