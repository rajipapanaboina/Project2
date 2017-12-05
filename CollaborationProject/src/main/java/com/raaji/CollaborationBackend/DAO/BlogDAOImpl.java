package com.raaji.CollaborationBackend.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.raaji.CollaborationBackend.Model.BlogPart;
@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public BlogDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	
	public boolean addBlog(BlogPart blog) 
	{
		try
		{
		sessionFactory.getCurrentSession().save(blog);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}

	public boolean updateBlog(BlogPart blog) {
		
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception has occured..........."+e);
			return false;
		}
		
	}

	@Transactional
	
	public boolean deleteBlog(BlogPart blog) {
		try
		{
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception has occured..........."+e);
			return false;
		}
		
	}

	
	public BlogPart getBlog(int blogId) {
		Session session=sessionFactory.openSession();
		BlogPart blog =(BlogPart)session.get(BlogPart.class,blogId);
		session.close();
		return blog;
	}

	
	public List<BlogPart> getAllBlogs() {
		Session session=sessionFactory.openSession();
		List<BlogPart> blogList =(List<BlogPart>)session.createQuery("from Blog");
		session.close();
		return blogList;
	}

	
	public boolean approveBlog(BlogPart blog) {
		try
		{
			blog.setStatus("A");
			sessionFactory.getCurrentSession().update(blog);	
		    return true;
	    }
        catch(Exception e)
		{
        	System.out.println("Exception has occured"+e);
        	return false;
		}
   }		
	
	
	public boolean rejectBlog(BlogPart blog) {
		try
		{
			blog.setStatus("N");
			sessionFactory.getCurrentSession().update(blog);	
		    return true;
	    }
        catch(Exception e)
		{
        	System.out.println("Exception has occured"+e);
        	return false;
		}
   }		
	
	
}
