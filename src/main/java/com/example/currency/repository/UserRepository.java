package com.example.currency.repository;

import com.example.currency.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
//Java Persistence Query Language
    @Query("select u from User u where u.name = :p_name ")
    User loadUserByUsername(@Param("p_name") String username);
// native SQL
    @Query(value = "select r.name from app_user_role ur, app_role r where r.id = ur.role_id and ur.user_id = :p_userId ", nativeQuery = true)
    List<String> getRoles(@Param("p_userId") Integer userId);
}
