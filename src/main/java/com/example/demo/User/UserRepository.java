package com.example.demo.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

	Optional<User> findByEmail(String email);

	List<User> findByNameContains(String name);

	List<User> findByName(String name);


}