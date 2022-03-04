package fi.spring.restapp.firstrestapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fi.spring.restapp.firstrestapp.dto.UserDTO;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@GetMapping("/auth")	//http:localhost/user/auth
	public Boolean authenticate(@RequestParam("uname") String userName,@RequestParam("pwd") String password)
	{
		if(userName.equals("fi") && password.equals("cdac"))
			return true;
		else
			return false;
	}
//	@GetMapping("/{uname}")		//http:localhost/user/fi,cdac
//	public String getInfo(@PathVariable(name = "uname") String userName)
//	{
//		if(userName.equals("fi"))
//			return "fi@123";
//		else if(userName.equals("cdac"))
//			return "cdac@123";
//		else
//			return "deafoult@123";
//	}
	
	ArrayList<UserDTO> users = new ArrayList<>();
	public UserController()
	{
		users.add(new UserDTO("fi","fi@123","Frankels Infotech","cdac@franlelsinfotech.com"));
		users.add(new UserDTO("cdac","cdac@123","cdac","cdac@123.com"));
		users.add(new UserDTO("default","default@123","Default","default@123.com"));
		
		
	}
	
	//http:localhost/user/fi,cdac
//	@GetMapping("/{uname}")		//given output bydefault json formate
//	public UserDTO getInfo(@PathVariable(name = "uname") String userName)
//	{
//		for(UserDTO objUser : users)
//		{
//			if(objUser.getUserName().equals(userName))
//				return objUser;
//		}
//		return null;
//	}
	
	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE},path="/{uname}")		
	public UserDTO getInfo(@PathVariable(name = "uname") String userName)
	{
		for(UserDTO objUser : users)
		{
			if(objUser.getUserName().equals(userName))
				return objUser;
		}
		return null;
	}
	
	@PostMapping("/newuser")
	public String newUser(@RequestBody UserDTO objUser)
	{
		System.out.println(objUser.getUserName());
		System.out.println(objUser.getPassword());
		System.out.println(objUser.getName());
		System.out.println(objUser.getEmail());
		return objUser.getEmail();
	}
	@GetMapping("/all")
	public List<UserDTO> getAll()
	{
		return users;
	}
}
