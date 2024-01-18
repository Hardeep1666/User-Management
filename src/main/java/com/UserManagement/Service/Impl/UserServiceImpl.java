package com.UserManagement.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.UserManagement.Dto.LoginDto;
import com.UserManagement.Dto.UserDto;
import com.UserManagement.Entity.User;
import com.UserManagement.Payload.LoginResponse;
import com.UserManagement.Repo.UserRepo;
import com.UserManagement.Service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		 List<User> userdto= userRepo.findAll();
		 return userdto;
	}

	@Override
	public Optional<User> getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id);
	}

	@Override
	public User createUser(UserDto userDto) {
		
		User user = new User(userDto.getId(), userDto.getFullName(), userDto.getEmail(),userDto.getUsername(), this.passwordEncoder.encode(userDto.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public User updateUser(Long id, UserDto userDto) {
		Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setFullName(userDto.getFullName());
            existingUser.setUsername(userDto.getUsername());
            existingUser.setEmail(userDto.getEmail());
            return userRepo.save(existingUser);
        } else {
            // Handle not found scenario, throw exception or return null, etc.
            return null;
        }
	}

	@Override
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}

	@Override
	public LoginResponse userLogin(LoginDto loginDto) {
		String msg = "";
        User user = userRepo.findByEmail(loginDto.getEmail());
     //   User user1 =userRepo.findByUsername(loginDto.getUsername());
        System.out.println("user:"+user);
     //   System.out.println("username:"+user1);
        if (user != null ) {
            String password = loginDto.getPassword();
            String encodedPassword = user.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> employee = userRepo.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }
    }
}



