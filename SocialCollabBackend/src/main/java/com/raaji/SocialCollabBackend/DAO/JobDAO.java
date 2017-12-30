package com.raaji.SocialCollabBackend.DAO;

import java.util.List;

import com.raaji.SocialCollabBackend.Model.Job;

public interface JobDAO 
{
	
	public boolean addJob(Job job);
	
	public Job getJob(String name);
	
	public List<Job> listJobs();
	
	public boolean deleteJob(int job_id);
	
	public boolean invalidateJob(int job_id);
	
}
