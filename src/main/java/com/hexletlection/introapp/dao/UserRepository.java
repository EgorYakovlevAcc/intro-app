package com.hexletlection.introapp.dao;

import com.hexletlection.introapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUsersByUsername(String username);
    void deleteUserByUsername(String username);
}
