package com.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.entity.User;

// 1
public interface UserRepository extends JpaRepository<User, Long> { // a: extends JpaRepository, b: <User, Long> User: 테이블, Long: ID
	
}