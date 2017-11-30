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

import com.raaji.CollaborationProject.Model.ForumPart;
import com.raaji.CollaborationProject.Model.UserPart;



@SuppressWarnings("deprecation")
@Repository("forumDAO")
@EnableTransactionManagement
public class ForumDAOImpl implements ForumDAO 
{
private static final Logger log = LoggerFactory.getLogger(ForumDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ForumDAOImpl(SessionFactory sessionFactory) 
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
	public boolean addForum(ForumPart forumPart) {
		log.info("Add Blog Method Started");
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(forumPart);
			log.info("Add forum Method Success");
			return true;
		}
		catch(Exception ex)
		{
			log.error("Add forum has an Error");
			ex.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean updateBlog(ForumPart forumPart) {
		log.info("Update forum method Started");
		try
		{
			log.info("Update forum Success");
			sessionFactory.getCurrentSession().update(forumPart);
			return true;
		}
		catch(Exception ex)
		{
			log.info("Update forum Unsuccessful");
			ex.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean deleteForum(ForumPart forumPart) {
		log.info("Delete forum method Started");
		try
		{
			log.info("Delete forum Success");
			sessionFactory.getCurrentSession().delete(forumPart);
			return true;
		}
		catch(Exception ex)
		{
			log.info("Delete forum Unsuccessful");
			ex.printStackTrace();
			return false;
		}
	}
	@Transactional
	public ForumPart getForum(String title) {
		log.debug("Starting of Method Get forum "+title);
		try
		{
			ForumPart forumPart =  sessionFactory.getCurrentSession().get(ForumPart.class, title);
			forumPart.setErrorCode("200");
			forumPart.setErrorMsg("User Found");
			return forumPart;
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
	public List<ForumPart> getForumByUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	public List<ForumPart> getAllForums() {
		log.info("Starting of List Method");
		String hql_string = "FROM FORUM";
		Query query = sessionFactory.getCurrentSession().createQuery(hql_string);
		log.info("List Retrieved");
		return query.list();
	}
	@Override
	public boolean updateForum(ForumPart forumPart) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	}
