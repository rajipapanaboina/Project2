package com.raaji.SocialCollabBackend.DAO;


import java.util.List;

import com.raaji.SocialCollabBackend.Model.User;

public interface UserDAO
{

	public boolean addUser(User user);
	
	public boolean validateUser(String userName, String password);
	
	public User getUser(String userName);
	
	public List<User> getUserList();
	
	public boolean deleteUser(User user);
	
}
