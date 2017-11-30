package com.raaji.CollaborationProject.DAO;

import java.util.List;
import com.raaji.CollaborationProject.Model.BlogPart;
public interface BlogDAO 
{
	public boolean addBlog(BlogPart blogPart);
	public boolean updateBlog(BlogPart blogPart);	
	public boolean deleteBlog(BlogPart blogPart);
	public BlogPart getBlog(String title);
	public List<BlogPart> getBlogByUser(String username);
	public List<BlogPart> getAllBlogs();

}