package com.raaji.SocialCollabBackend.DAO;

import java.util.List;

import com.raaji.SocialCollabBackend.Model.Forum;

public interface ForumDAO
{

	public boolean addForum(Forum forum);
	
	public boolean deleteForum(int id);
	
	public boolean updateForum(Forum forum);
	
	public Forum getForum(int id);
	
	public List<Forum> getUserForums(String username);
	
	public List<Forum> getForumList();
	
	public List<Forum> approvedForums();
}
