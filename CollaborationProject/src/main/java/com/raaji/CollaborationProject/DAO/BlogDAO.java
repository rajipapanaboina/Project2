package com.raaji.CollaborationProject.DAO;

import java.util.List;
import com.raaji.CollaborationProject.Model.BlogPart;

public interface BlogDAO 
{
	public boolean addBlog(BlogPart blog);
	public boolean updateBlog(BlogPart blog);
	public boolean deleteBlog(BlogPart blog);
	public BlogPart getBlog(int blogId);
	public List<BlogPart> getAllBlogs();
	public boolean approveBlog(BlogPart blog);
	public boolean rejectBlog(BlogPart blog);
}