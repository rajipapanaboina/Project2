package com.raaji.CollaborationProject.Testcases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.raaji.CollaborationProject.DAO.ForumDAO;
import com.raaji.CollaborationProject.Model.ForumPart;


public class ForumDAOTestcases 
{
	Logger log = LoggerFactory.getLogger(ForumDAOTestcases.class);
	
	@Autowired
	ForumDAO forumDAO;
	
	@Autowired
	ForumPart forumPart;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	public ForumDAOTestcases()
	{
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.raaji.CollaborationProject");
		context.refresh();

		forumDAO = (ForumDAO) context.getBean("forumDAO");
		forumPart = (ForumPart) context.getBean("forumPart");
		
	}
   public void forumAdd()
   {
	   log.info("Add forum Test started");
	  
	   forumPart.setDescription("Here it contains username title and some other details...");
	   forumPart.setUsername("rajipapanaboina");
	   forumPart.setForum_title("Fresher_Gradguate");
	   forumPart.setDate_time("DATE_TIME");
	   
	   forumDAO.addForum(forumPart);
	   log.info("Add Forum Test end");
   }
   public void UpdateForum()
  	{
  		log.info("Update Success initiated.");
  		forumPart = forumDAO.getForum("testForum");
  		forumDAO.updateForum(forumPart);
  		log.info("Update Success");
  	}
   public void deleteForum()
	{
		log.info("Delete Success initiated.");
		forumPart = forumDAO.getForum("testForum");
		forumDAO.deleteForum(forumPart);
		log.info("Delete Success");
	}
   public static void main(String[] args) 
	{
	   ForumDAOTestcases tforum = new  ForumDAOTestcases ();
//		tforum.blogAdd();
	   tforum.UpdateForum();
//		tforum.deleteForum();
//		tforum.list();
		
		System.out.println("Success");
	}
   
}