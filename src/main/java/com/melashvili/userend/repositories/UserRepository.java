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

    @Query("SELECT u FROM User u JOIN u.addresses a WHERE a.number = :phoneNumber")
    List<User> findUsersByPhoneNumber(@Param("phoneNumber") Integer phoneNumber);

    @Query("SELECT u FROM User u JOIN u.preferences p WHERE p.emailOpt = :emailOpt")
    List<User> findUsersByEmailOpt(@Param("emailOpt") Boolean emailOpt);

    @Query("SELECT u FROM User u JOIN u.preferences p WHERE p.smsOpt = :smsOpt")
    List<User> findUsersBySmsOpt(@Param("smsOpt") Boolean smsOpt);

    @Query("SELECT u FROM User u JOIN u.preferences p WHERE p.promoOpt = :promoOpt")
    List<User> findUsersByPromoOpt(@Param("promoOpt") Boolean promoOpt);
}
