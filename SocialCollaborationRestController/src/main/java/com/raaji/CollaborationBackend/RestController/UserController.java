package com.raaji.CollaborationBackend.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raaji.CollaborationBackend.DAO.UserDAO;
import com.raaji.CollaborationBackend.Model.UserPart;

@RestController
public class UserController {
	@Autowired
	UserDAO userDAO;
	
	@PostMapping(value="/registerUser")
	public ResponseEntity<String> registerUser(@RequestBody UserPart userPart)
	{
		System.out.println("Registration");
		
		userPart.setRole("User");
		userPart.setIsOnline("N");
		if(userDAO.addUser(userPart))
		{
			return new ResponseEntity<String>("Registered",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in Registration",HttpStatus.OK);
		}
	}

	@PostMapping(value="/login")
	public ResponseEntity<UserPart> checkLogin(@RequestBody UserPart userPart)
	{
		
		if(userDAO.checkLogin(userPart))
		{
			System.out.println("Logging");
			UserPart tempUser=userDAO.getUser(userPart.getUsername());
			userDAO.updateOnlineStatus("Y", tempUser);
			//session.setAttribute("username",userPart.getUsername());
			return new ResponseEntity<UserPart>(userPart,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<UserPart>(userPart,HttpStatus.OK);
		}
	}

	
	
	
	
	
}
