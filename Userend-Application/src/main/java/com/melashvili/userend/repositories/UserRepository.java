package com.melashvili.userend.repositories;

import com.melashvili.userend.model.dto.response.UserResponse;
import com.melashvili.userend.model.entitites.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String username);
}
