package com.raaji.CollaborationProject.Testcases;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.raaji.CollaborationProject.DAO.UserDAO;
import com.raaji.CollaborationProject.Model.UserPart;

public class UserDAOTestcases 
{
	Logger log = LoggerFactory.getLogger(UserDAOTestcases .class);
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	UserPart userPart;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	public UserDAOTestcases ()
	{
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.raaji.CollaborationProject");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");
		userPart = (UserPart) context.getBean("userPart");
		
	}
	
	public void testAdd()
	{
		log.info("Add User Test started");
		
		userPart.setUsername("rajipapanaboina");
		userPart.setFirst_name("raaji");
		userPart.setLast_name("papanaboina");
		userPart.setDob(new Date());
		userPart.setGender('F');
		userPart.setMail_id("rajipapanaboina@gmail.com");
		userPart.setPassword("admin");
		userPart.setStatus('N');
		userPart.setRole("ADMIN");
		
		userDAO.addUser(userPart);
		log.info("Add User Test end");
	}
	
	public void getUserDetails()
	{
		log.info("Get User Details Started");
		String userName = "testuser";
		userPart = userDAO.getUser(userName);
		System.out.println("Name - "+userPart.getFirst_name());
		System.out.println("Date - "+userPart.getDob());
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
	    Date dateobj = userPart.getDob();
	    String datetime = df.format(dateobj).toString();
	    System.out.println("Date - "+datetime);
		log.info("Get User Ended");
	}
	
	public void validateUser()
	{
		log.info("Validate User Started");
		String userName = "testuser";
		String password = "testuser";
		boolean value = userDAO.validateUser(userName, password);
		if(value)
			System.out.println("Valid");
		else
			System.out.println("Invalid");
		log.info("Validate User Ended");
	}
	
	public void deleteUser()
	{
		log.info("Delete Success initiated.");
		userPart = userDAO.getUser("testuser");
		userDAO.deleteUser(userPart);
		log.info("Delete Success");
	}
	
	public void list()
	{
		log.info("List Users");
		List<UserPart> list = userDAO.getUserList();
		int size = list.size();
		for(int index = 0; index < size; index++)
		{
			System.out.print("Name = "+list.get(index).getFirst_name());
			System.out.println("\t Email = "+list.get(index).getMail_id());
		}
	}
	
	public static void main(String[] args) 
	{
		UserDAOTestcases  tuser = new UserDAOTestcases ();
		tuser.testAdd();
  tuser.getUserDetails();
//		tuser.validateUser();
//		tuser.deleteUser();
//		tuser.list();
		
		System.out.println("Success");
	}
}

