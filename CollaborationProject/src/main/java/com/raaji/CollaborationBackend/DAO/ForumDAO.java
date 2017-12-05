package com.raaji.CollaborationBackend.DAO;

import java.util.List;

import com.raaji.CollaborationBackend.Model.ForumPart;

public interface ForumDAO {
	public boolean addForum(ForumPart forum);
	public boolean updateForum(ForumPart forum);
	public boolean deleteBlog(ForumPart forum);
	public ForumPart getBlog(int blogId);
	public List<ForumPart> getAllForums();
	public boolean approveBlog(ForumPart forum);
	public boolean rejectForum(ForumPart forum);

}