package com.raaji.SocialCollabBackend.DAO;


import java.util.List;

import com.raaji.SocialCollabBackend.Model.Job;
import com.raaji.SocialCollabBackend.Model.JobApplied;

public interface JobAppliedDAO 
{
	
	public boolean applyNew(JobApplied jobApplied);
	
	public List<JobApplied> listByUser(String username);
	
	public List<JobApplied> listByCompany();
	
}
