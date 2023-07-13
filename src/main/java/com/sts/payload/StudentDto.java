package com.sts.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentDto {
	
	
	private int id;
	
	@NotNull(message="User name can not be null")
	@NotEmpty(message="User name can not be empty")
	@Size(min=2 , message = "User name must be min 2 length")
	private String name;
	
	@Email(message = "Enter proper email")
	@NotNull(message="User email can not be null")
	@NotEmpty(message="User email can not be empty")
	private String email;
	
	@NotNull(message="User password can not be null")
	@NotEmpty(message="User password can not be empty")
	@Size(min = 6 , max = 8, message = "Password length min 6 and max 8")
	private String password;
	
	
	private String address;
	private String about;




}
