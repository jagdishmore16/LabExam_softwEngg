package fi.spring.restapp.firstrestapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcomeRESTController {

	@GetMapping("/home")
	public String home()
	{
		return "welcome to the first RESTful Service in Spring";
	}
}
