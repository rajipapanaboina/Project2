package com.raaji.CollaborationProject.Testcases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.raaji.CollaborationProject.DAO.BlogDAO;
import com.raaji.CollaborationProject.Model.BlogPart;


public class BlogDAOTestcases 
{
	Logger log = LoggerFactory.getLogger(BlogDAOTestcases.class);
	
	@Autowired
	BlogDAO blogDAO;
	
	@Autowired
	BlogPart blogPart;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	public BlogDAOTestcases()
	{
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.raaji.CollaborationProject");
		context.refresh();

		blogDAO = (BlogDAO) context.getBean("blogDAO");
		blogPart = (BlogPart) context.getBean("blogPart");
		
	}
   public void blogAdd()
   {
	   log.info("Add blog Test started");
	  
	   blogPart.setDescription("Here it contains username title and some other details...");
	   blogPart.setUsername("rajipapanaboina");
	   blogPart.setBlog_title("Fresher_Gradguate");
	   blogPart.setDate_time("DATE_TIME");
	   
	   blogDAO.addBlog(blogPart);
	   log.info("Add Blog Test end");
   }
   public void UpdateBlog()
  	{
  		log.info("Update Success initiated.");
  		blogPart = blogDAO.getBlog("testBlog");
  		blogDAO.updateBlog(blogPart);
  		log.info("Update Success");
  	}
   public void deleteBlog()
	{
		log.info("Delete Success initiated.");
		blogPart = blogDAO.getBlog("testBlog");
		blogDAO.deleteBlog(blogPart);
		log.info("Delete Success");
	}
   public static void main(String[] args) 
	{
	   BlogDAOTestcases tblog = new  BlogDAOTestcases ();
//		tblog.blogAdd();
	    tblog.UpdateBlog();
//		tblog.deleteBlog();
//		tblog.list();
		
		System.out.println("Success");
	}
   
}