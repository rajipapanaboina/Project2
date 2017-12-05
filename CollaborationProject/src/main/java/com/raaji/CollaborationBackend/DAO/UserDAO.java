package com.raaji.CollaborationBackend.DAO;

import com.raaji.CollaborationBackend.Model.UserPart;

public interface UserDAO {
  public boolean addUser(UserPart user);
  public boolean updateOnlineStatus(String status,UserPart user);
  public UserPart getUser(String username);
  
}