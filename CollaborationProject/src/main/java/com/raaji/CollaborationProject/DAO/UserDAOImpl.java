package com.raaji.CollaborationProject.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.raaji.CollaborationProject.Model.UserPart;

public class UserDAOImpl implements UserDAO
{
    @Autowired
    public SessionFactory sessionFactory;
    
	public UserDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	
	public boolean addUser(UserPart user) {
        try{
		sessionFactory.getCurrentSession().save(user); 
        }
        catch(Exception e)
        {
        	System.out.println("Exception has occured..."+e);
        }
		return false;
        
	}
    @Transactional
    
	public boolean updateOnlineStatus(String status, UserPart user)
    {
    	 try
    	 {
    	   user.setIsOnline(status);	 
    	   sessionFactory.getCurrentSession().save(user); 
    	 }
    	  catch(Exception e)
    	 {
           System.out.println("Exception has occured..."+e);
    	   
    	 }
		return false;
    	 	
	}

	public UserPart getUser(String username) {
     
		Session session= sessionFactory.openSession();
		UserPart user=(UserPart)session.get(UserPart.class,username);
		session.close();
		return user;
	}	
}

