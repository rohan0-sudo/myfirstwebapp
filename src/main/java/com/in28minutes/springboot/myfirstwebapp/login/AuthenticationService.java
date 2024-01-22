package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String name, String password) {
		
		boolean isValidName = name.equalsIgnoreCase("admin");
		boolean isValidPass = password.equalsIgnoreCase("test");
		
		return isValidName && isValidPass;
	}

}
