package com.raaji.CollaborationProject.Testcases;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import com.raaji.CollaborationProject.DAO.BlogDAO;
import com.raaji.CollaborationProject.DAO.UserDAO;
import com.raaji.CollaborationProject.Model.BlogPart;
import com.raaji.CollaborationProject.Model.UserPart;
@Repository("userDAO")
public class UserDAOTestcases {

static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.raaji.CollaborationProject");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
	

	@Test
	public void addUserTest()
	{
		UserPart user=new UserPart();
		 user.setUsername("Raaji");
		 user.setFirstname("Raaji");
		 user.setLastname("Papanaboina");
		 user.setPassword("0675");
		 user.setEmailId("rajipapanaboina@gmail.com");
		 user.setRole("Admin");
		 user.setIsOnline("N");
		assertTrue("Problem in Inserting User",userDAO.addUser(user));
	
	}
	
	@Test
	public void isOnlineTest()
	{
		UserPart user=userDAO.getUser("Raaji");
		assertTrue("Problem in assertion..",userDAO.updateOnlineStatus("Y", user));
	}

}
