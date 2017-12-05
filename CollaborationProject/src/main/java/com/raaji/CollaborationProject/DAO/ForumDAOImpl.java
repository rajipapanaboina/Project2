package com.raaji.CollaborationProject.DAO;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.raaji.CollaborationProject.Model.ForumPart;

public class ForumDAOImpl {
	@Autowired
	SessionFactory sessionFactory;
	
	public ForumDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean addForum(ForumPart forum) 
	{
		try
		{
		sessionFactory.getCurrentSession().save(forum);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}


	
	public boolean updateForum(ForumPart forum) {
		
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception has occured..........."+e);
			return false;
		}
		
	}

	@Transactional
	
	public boolean deleteForum(ForumPart forum) {
		try
		{
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception has occured..........."+e);
			return false;
		}
		
	}

	
	public ForumPart getForum(int forumId) {
		Session session=sessionFactory.openSession();
		ForumPart forum =(ForumPart)session.get(ForumPart.class,forumId);
		session.close();
		return forum;
	}

	
	public List<ForumPart> getAllForums() {
		Session session=sessionFactory.openSession();
		List<ForumPart> forumList =(List<ForumPart>)session.createQuery("from Forum");
		session.close();
		return forumList;
	}

	
	public boolean approveForum(ForumPart forum) {
		try
		{
			forum.setStatus("A");
			sessionFactory.getCurrentSession().update(forum);	
		    return true;
	    }
        catch(Exception e)
		{
        	System.out.println("Exception has occured"+e);
        	return false;
		}
   }		
	
	
	public boolean rejectForum(ForumPart forum) {
		try
		{
			forum.setStatus("N");
			sessionFactory.getCurrentSession().update(forum);	
		    return true;
	    }
        catch(Exception e)
		{
        	System.out.println("Exception has occured"+e);
        	return false;
		}
   }		
	 
	}
