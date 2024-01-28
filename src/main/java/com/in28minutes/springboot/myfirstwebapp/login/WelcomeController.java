package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
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
		model.put("name", getLoggedInUserName());
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
	
	private String getLoggedInUserName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
