package com.raaji.CollaborationProject.DAO;

import com.raaji.CollaborationProject.Model.UserPart;

public interface UserDAO {
  public boolean addUser(UserPart user);
  public boolean updateOnlineStatus(String status,UserPart user);
  public UserPart getUser(String username);
  
}