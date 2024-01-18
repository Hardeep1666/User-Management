package com.UserManagement.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UserManagement.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	public Optional<User> findOneByEmailAndPassword(String email, String password);

	public User findByEmail(String email);
	public User findByUsername(String username);
	
	

}
