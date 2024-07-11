package com.melashvili.userend.repositories;

import com.melashvili.userend.model.entitites.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.firstName = :firstName")
    List<User> findUsersByFirstName(@Param("firstName") String firstName);

    @Query("SELECT e FROM User e WHERE e.email = :email")
    User findByEmail(@Param("email") String username);
}
