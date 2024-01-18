package com.UserManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import lombok.EqualsAndHashCode.Exclude;

@SpringBootApplication 


//(exclude = {SecurityAutoConfiguration.class})
public class UserManagementApplication {


	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);
	}
	// we have to enable security config for this project //basic auth

}
