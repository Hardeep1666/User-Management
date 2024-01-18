package com.UserManagement.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
    private Long id;
	
	private String fullName;
	
	private String email;
	
	    private String username;
	 
	   
	    private String password;

		
	
	    
}
