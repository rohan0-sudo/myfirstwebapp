package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
//	private AuthenticationService authenticationService;
	

//	public LoginController(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}

	@RequestMapping("/")
	public String goToWelcomePage(ModelMap model) {
		model.put("name", "Rohan");
		return "welcome";
	}
	
//	@RequestMapping(value="login",method=RequestMethod.POST)
//	public String welcomePage(@RequestParam String name,@RequestParam String password, ModelMap model) {
//		
//		if(authenticationService.authenticate(name, password)) {
//		model.put("name", name);
//		model.put("password", password);
//		return "welcome";
//		}
//		model.put("errorMessage", "InvalidCredentials!");
//		return "login";
//	}
}
