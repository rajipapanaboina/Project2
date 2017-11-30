package com.raaji.CollaborationProject.DAO;
import java.util.List;
import com.raaji.CollaborationProject.Model.UserPart;

public interface UserDAO 
{

public boolean addUser(UserPart userPart);
	
	public boolean validateUser(String userName, String password);
	
	public UserPart getUser(String userName);
	
	public List<UserPart> getUserList();
	
	public boolean deleteUser(UserPart userPart);
	
}