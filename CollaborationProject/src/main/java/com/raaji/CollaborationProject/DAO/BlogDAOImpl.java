package com.raaji.CollaborationProject.DAO;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.raaji.CollaborationProject.Model.BlogPart;
import com.raaji.CollaborationProject.Model.UserPart;

@SuppressWarnings("deprecation")
@Repository("blogDAO")
@EnableTransactionManagement
public class BlogDAOImpl implements BlogDAO 
{
private static final Logger log = LoggerFactory.getLogger(BlogDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public BlogDAOImpl(SessionFactory sessionFactory) 
	{
		try 
		{
			this.sessionFactory = sessionFactory;
			log.info("Connection Established Successfully");
		} 
		catch (Exception ex) 
		{
			log.error("Failed to establish connection");
			ex.printStackTrace();
		}
	}
	@Transactional
	public boolean addBlog(BlogPart blogPart) {
		log.info("Add Blog Method Started");
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(blogPart);
			log.info("Add blog Method Success");
			return true;
		}
		catch(Exception ex)
		{
			log.error("Add blog has an Error");
			ex.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean updateBlog(BlogPart blogPart) {
		log.info("Update Blog method Started");
		try
		{
			log.info("Update blog Success");
			sessionFactory.getCurrentSession().update(blogPart);
			return true;
		}
		catch(Exception ex)
		{
			log.info("Update Blog Unsuccessful");
			ex.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean deleteBlog(BlogPart blogPart) {
		log.info("Delete Blog method Started");
		try
		{
			log.info("Delete blog Success");
			sessionFactory.getCurrentSession().delete(blogPart);
			return true;
		}
		catch(Exception ex)
		{
			log.info("Delete Blog Unsuccessful");
			ex.printStackTrace();
			return false;
		}
	}
	@Transactional
	public BlogPart getBlog(String title) {
		log.debug("Starting of Method Get Blog "+title);
		try
		{
			BlogPart blogPart =  sessionFactory.getCurrentSession().get(BlogPart.class, title);
			blogPart.setErrorCode("200");
			blogPart.setErrorMsg("User Found");
			return blogPart;
		}
		catch(Exception ex)
		{
			UserPart userPart = new UserPart();
			ex.printStackTrace();
			userPart.setErrorCode("404");
			userPart.setErrorMsg("User Not Found");
			return null;
		}
	}
	@Transactional
	public List<BlogPart> getBlogByUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	public List<BlogPart> getAllBlogs() {
		log.info("Starting of List Method");
		String hql_string = "FROM Blog";
		Query query = sessionFactory.getCurrentSession().createQuery(hql_string);
		log.info("List Retrieved");
		return query.list();
	}
	

	}
