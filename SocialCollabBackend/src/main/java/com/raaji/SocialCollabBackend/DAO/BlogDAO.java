package com.raaji.SocialCollabBackend.DAO;

import java.util.List;

import com.raaji.SocialCollabBackend.Model.Blog;

public interface BlogDAO 
{
	public boolean addBlog(Blog blog);
	
	// to approve A blog by ADMIN only.
	public boolean approveBlog(Blog blog);
	
	public boolean updateBlog(Blog blog);	
	
	public boolean deleteBlog(Blog blog);
	
	public Blog getBlog(String title);
	
	public List<Blog> getBlogByUser(String username);
	
	public List<Blog> getApprovedBlogs();
	
	public List<Blog> getAllBlogs();

}
