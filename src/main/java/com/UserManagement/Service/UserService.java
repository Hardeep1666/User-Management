package com.UserManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.UserManagement.Dto.LoginDto;
import com.UserManagement.Dto.UserDto;
import com.UserManagement.Entity.User;
import com.UserManagement.Payload.LoginResponse;


@Service
public interface UserService {
	 List<User> getAllUsers();

	    Optional<User> getUserById(Long id);

	    User createUser(UserDto userDto);

	    User updateUser(Long id, UserDto userDto);

	    void deleteUser(Long id);
	    
	   LoginResponse userLogin(LoginDto loginDto);
	
}
