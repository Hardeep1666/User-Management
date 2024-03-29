package com.UserManagement.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private Long id;
	private String fullName;

	private String email;

	private String username;
	
	private String password;
}
