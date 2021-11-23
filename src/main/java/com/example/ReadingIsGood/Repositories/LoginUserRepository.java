package com.example.ReadingIsGood.Repositories;

import com.example.ReadingIsGood.Models.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginUserRepository extends JpaRepository<LoginUser, Long> {

    LoginUser findByUsername(String username);
}
