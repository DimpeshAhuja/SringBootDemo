package com.springdemo.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdemo.demo.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    
}
