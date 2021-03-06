package com.raaji.SocialCollabBackEnd.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raaji.SocialCollabBackend.DAO.CommentDAO;
import com.raaji.SocialCollabBackend.Model.BlogComment;
import com.raaji.SocialCollabRestController.Util.Date_Time;


@RestController
public class BlogCommentController
{
	private static final Logger log = LoggerFactory.getLogger(BlogCommentController.class);
	
	@Autowired
	private BlogComment blogComment;
	
	@Autowired
	private CommentDAO commentDAO;
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/getComments-{blog_id}")
	public ResponseEntity<List<BlogComment>> getComments(@PathVariable("blog_id") String blog_id)
	{
		log.info("Getting comments for blog -"+blog_id);
		List<BlogComment> list = new ArrayList<BlogComment>();
		list = commentDAO.getBlogComments(blog_id);
		
		if(list.isEmpty() || list == null)
		{
			log.info("No comments found");
			return null;
		}
		else
		{
			return new ResponseEntity<List<BlogComment>>(list,HttpStatus.OK);
		}
	}
	
	@PostMapping("/addBlogComment")
	public ResponseEntity<BlogComment> addComment(@RequestBody BlogComment blogComment)
	{
		if(session.getAttribute("username")==null)
		{
			log.info("You have not logged in");
			return null;
		}
		else
		{
			log.info("Comment Recieved");
			blogComment.setUsername(session.getAttribute("username").toString());
			Date_Time dt = new Date_Time();
			blogComment.setPostedAt(dt.getDateTime());
			boolean value = commentDAO.addBlogComment(blogComment);
			if(value)
			{
				log.info("Comment added");
				return new ResponseEntity<BlogComment>(blogComment, HttpStatus.OK);
			}
			else
			{
				log.error("Adding Comment Failed");
				return null;
			}
		}
	}
		
	@PostMapping("/deleteComment-{id}")
	public ResponseEntity<BlogComment> deleteComment(@PathVariable("id") int id)
	{
		log.info("Delete Comment");
		boolean value = commentDAO.deleteComment(id);
		if(value)
		{
			blogComment = new BlogComment();
			blogComment.setErrorCode("200");
			blogComment.setErrorMsg("Delete Success");
			log.info("Delete Success");
			return new ResponseEntity<BlogComment>(blogComment, HttpStatus.OK);
		}
		else
		{
			log.info("Error deleting comment");
			return null;
		}
	}
}