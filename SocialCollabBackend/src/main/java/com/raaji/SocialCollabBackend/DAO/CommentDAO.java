package com.raaji.SocialCollabBackend.DAO;


import java.util.List;

import com.raaji.SocialCollabBackend.Model.BlogComment;

public interface CommentDAO
{
	
	public boolean addBlogComment(BlogComment blogComment);

	public boolean deleteComment(int id);
	
	public List<BlogComment> getBlogComments(String blog_id);
}